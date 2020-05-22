package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View dyp;
    private BdTypeListView faQ;
    private View gXL;
    private TextView jxp;
    private TextView lUA;
    private TextView lUB;
    private TextView lUC;
    private c lUx;
    private d lUy;
    private View lUz;
    private ImageView mBackImageView;
    private List<o> mDataList;
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.jxp.getId()) {
                    if (view.getId() == TransmitForumActivity.this.dyp.getId() || view.getId() == TransmitForumActivity.this.gXL.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.startExitAnimation();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> dnq = TransmitForumActivity.this.dnq();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.eT(dnq));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.startExitAnimation();
            }
        }
    };
    private a lUD = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean dnn() {
            return v.getCount(TransmitForumActivity.this.dnq()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dno() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dnp() {
            TransmitForumActivity.this.cAf();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.dyp = findViewById(R.id.trasmit_back);
        this.dyp.setOnClickListener(this.mOnClickListener);
        this.jxp = (TextView) findViewById(R.id.transmit_cofirm);
        this.lUA = (TextView) findViewById(R.id.transmit_title);
        this.lUB = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.jxp.setOnClickListener(this.mOnClickListener);
        this.faQ = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.faQ.setMaxHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.faQ.setOverScrollMode(2);
        this.lUC = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.getCount(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.lUC.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.lUC.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.lUx = new c(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.lUy = new d(getPageContext().getPageActivity(), e.ID_TRANSMIT_SELECT_DATA, getUniqueId(), arrayList);
        this.lUx.a(this.lUD);
        this.aSj.add(this.lUx);
        this.aSj.add(this.lUy);
        this.faQ.addAdapters(this.aSj);
        this.faQ.setData(this.mDataList);
        cAf();
        this.gXL = findViewById(R.id.view_top);
        this.gXL.setOnClickListener(this.mOnClickListener);
        this.lUz = findViewById(R.id.layout_operate);
        this.lUz.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        am.setBackgroundColor(this.lUz, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jxp, R.drawable.btn_all_blue);
        am.setViewTextColor(this.jxp, R.color.cp_cont_g, 1);
        am.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        am.setViewTextColor(this.lUA, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.lUB, R.color.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String eT(List<TransmitForumData> list) {
        JSONArray jSONArray = new JSONArray();
        for (TransmitForumData transmitForumData : list) {
            if (transmitForumData != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(String.valueOf(transmitForumData.forumId), transmitForumData.type);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25005) {
            HotTopicBussinessData FG = this.lUy.FG(intent.getIntExtra("hot_topic_change_fourm", 0));
            if (FG != null) {
                for (o oVar : this.mDataList) {
                    if ((oVar instanceof TransmitForumData) && TextUtils.equals(FG.mForumName, ((TransmitForumData) oVar).forumName)) {
                        return;
                    }
                }
                if (this.lUD.dnn()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(FG.mForumId, FG.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(FG.mForumId, FG.mForumName, true, 0));
                }
                cAf();
                this.faQ.setData(this.mDataList);
                this.faQ.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAf() {
        int count = v.getCount(dnq());
        if (count > 0) {
            this.jxp.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.jxp.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> dnq() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (o oVar : this.mDataList) {
            if (oVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) oVar;
                if (transmitForumData.checked) {
                    arrayList.add(transmitForumData);
                }
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExitAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.out_to_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TransmitForumActivity.this.finish();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.lUz.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lUy != null) {
            this.lUy.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }
}
