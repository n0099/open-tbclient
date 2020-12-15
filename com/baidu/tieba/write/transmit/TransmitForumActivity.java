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
    private View eAA;
    private BdTypeListView gpZ;
    private View iDy;
    private TextView ltQ;
    private ImageView mBackImageView;
    private List<q> mDataList;
    private c nYg;
    private d nYh;
    private View nYi;
    private TextView nYj;
    private TextView nYk;
    private TextView nYl;
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.ltQ.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eAA.getId() || view.getId() == TransmitForumActivity.this.iDy.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.startExitAnimation();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> dZu = TransmitForumActivity.this.dZu();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.gp(dZu));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.startExitAnimation();
            }
        }
    };
    private a nYm = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean dZr() {
            return y.getCount(TransmitForumActivity.this.dZu()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dZs() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dZt() {
            TransmitForumActivity.this.dkU();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.eAA = findViewById(R.id.trasmit_back);
        this.eAA.setOnClickListener(this.mOnClickListener);
        this.ltQ = (TextView) findViewById(R.id.transmit_cofirm);
        this.nYj = (TextView) findViewById(R.id.transmit_title);
        this.nYk = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.ltQ.setOnClickListener(this.mOnClickListener);
        this.gpZ = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.gpZ.setMaxHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.gpZ.setOverScrollMode(2);
        this.nYl = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (y.getCount(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.nYl.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.nYl.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.nYg = new c(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.nYh = new d(getPageContext().getPageActivity(), e.ID_TRANSMIT_SELECT_DATA, getUniqueId(), arrayList);
        this.nYg.a(this.nYm);
        this.bnf.add(this.nYg);
        this.bnf.add(this.nYh);
        this.gpZ.addAdapters(this.bnf);
        this.gpZ.setData(this.mDataList);
        dkU();
        this.iDy = findViewById(R.id.view_top);
        this.iDy.setOnClickListener(this.mOnClickListener);
        this.nYi = findViewById(R.id.layout_operate);
        this.nYi.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        ap.setBackgroundColor(this.nYi, R.color.CAM_X0201);
        ap.setBackgroundResource(this.ltQ, R.drawable.btn_all_blue);
        ap.setViewTextColor(this.ltQ, R.color.CAM_X0111, 1);
        ap.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        ap.setViewTextColor(this.nYj, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.nYk, R.color.CAM_X0109, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gp(List<TransmitForumData> list) {
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
            HotTopicBussinessData MQ = this.nYh.MQ(intent.getIntExtra("hot_topic_change_fourm", 0));
            if (MQ != null) {
                for (q qVar : this.mDataList) {
                    if ((qVar instanceof TransmitForumData) && TextUtils.equals(MQ.mForumName, ((TransmitForumData) qVar).forumName)) {
                        return;
                    }
                }
                if (this.nYm.dZr()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(MQ.mForumId, MQ.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(MQ.mForumId, MQ.mForumName, true, 0));
                }
                dkU();
                this.gpZ.setData(this.mDataList);
                this.gpZ.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkU() {
        int count = y.getCount(dZu());
        if (count > 0) {
            this.ltQ.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.ltQ.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> dZu() {
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
        this.nYi.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nYh != null) {
            this.nYh.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }
}
