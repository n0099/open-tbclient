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
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View dUO;
    private BdTypeListView fGf;
    private View hKw;
    private TextView kyq;
    private ImageView mBackImageView;
    private List<q> mDataList;
    private c naF;
    private d naG;
    private View naH;
    private TextView naI;
    private TextView naJ;
    private TextView naK;
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.kyq.getId()) {
                    if (view.getId() == TransmitForumActivity.this.dUO.getId() || view.getId() == TransmitForumActivity.this.hKw.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.startExitAnimation();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> dKG = TransmitForumActivity.this.dKG();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.fI(dKG));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.startExitAnimation();
            }
        }
    };
    private a naL = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean dKD() {
            return y.getCount(TransmitForumActivity.this.dKG()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dKE() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dKF() {
            TransmitForumActivity.this.cWR();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.dUO = findViewById(R.id.trasmit_back);
        this.dUO.setOnClickListener(this.mOnClickListener);
        this.kyq = (TextView) findViewById(R.id.transmit_cofirm);
        this.naI = (TextView) findViewById(R.id.transmit_title);
        this.naJ = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.kyq.setOnClickListener(this.mOnClickListener);
        this.fGf = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.fGf.setMaxHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.fGf.setOverScrollMode(2);
        this.naK = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (y.getCount(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.naK.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.naK.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.naF = new c(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.naG = new d(getPageContext().getPageActivity(), e.ID_TRANSMIT_SELECT_DATA, getUniqueId(), arrayList);
        this.naF.a(this.naL);
        this.bdV.add(this.naF);
        this.bdV.add(this.naG);
        this.fGf.addAdapters(this.bdV);
        this.fGf.setData(this.mDataList);
        cWR();
        this.hKw = findViewById(R.id.view_top);
        this.hKw.setOnClickListener(this.mOnClickListener);
        this.naH = findViewById(R.id.layout_operate);
        this.naH.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        ap.setBackgroundColor(this.naH, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.kyq, R.drawable.btn_all_blue);
        ap.setViewTextColor(this.kyq, R.color.cp_cont_g, 1);
        ap.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        ap.setViewTextColor(this.naI, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.naJ, R.color.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fI(List<TransmitForumData> list) {
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
            HotTopicBussinessData Kk = this.naG.Kk(intent.getIntExtra("hot_topic_change_fourm", 0));
            if (Kk != null) {
                for (q qVar : this.mDataList) {
                    if ((qVar instanceof TransmitForumData) && TextUtils.equals(Kk.mForumName, ((TransmitForumData) qVar).forumName)) {
                        return;
                    }
                }
                if (this.naL.dKD()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Kk.mForumId, Kk.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Kk.mForumId, Kk.mForumName, true, 0));
                }
                cWR();
                this.fGf.setData(this.mDataList);
                this.fGf.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWR() {
        int count = y.getCount(dKG());
        if (count > 0) {
            this.kyq.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.kyq.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> dKG() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (q qVar : this.mDataList) {
            if (qVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) qVar;
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
        this.naH.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.naG != null) {
            this.naG.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }
}
