package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View cMN;
    private View eWQ;
    private e fWA;
    private h fWB;
    private View fWC;
    private TextView fWD;
    private TextView fWE;
    private TextView fWF;
    private TextView fWz;
    private ImageView mBackImageView;
    private List<v> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new b(this);
    private a fWG = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(w.j.transmit_forum_activity);
        this.eWQ = findViewById(w.h.trasmit_back);
        this.eWQ.setOnClickListener(this.mOnClickListener);
        this.fWz = (TextView) findViewById(w.h.transmit_cofirm);
        this.fWD = (TextView) findViewById(w.h.transmit_title);
        this.fWE = (TextView) findViewById(w.h.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(w.h.trasmit_back);
        this.fWz.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(w.h.trasmit_grid_view);
        this.mListView.setMaxHeight(com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(w.f.ds568));
        this.mListView.setOverScrollMode(2);
        this.fWF = (TextView) findViewById(w.h.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (x.q(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.aaO) {
                        this.fWF.setText(w.l.transmit_forum_publish_more_forum);
                    } else {
                        this.fWF.setText(w.l.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new k());
        this.fWA = new e(getPageContext().getPageActivity(), TransmitForumData.fWM);
        this.fWB = new h(getPageContext().getPageActivity(), k.fWM, arrayList);
        this.fWA.a(this.fWG);
        this.mAdapters.add(this.fWA);
        this.mAdapters.add(this.fWB);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bow();
        this.cMN = findViewById(w.h.view_top);
        this.cMN.setOnClickListener(this.mOnClickListener);
        this.fWC = findViewById(w.h.layout_operate);
        this.fWC.startAnimation(AnimationUtils.loadAnimation(getActivity(), w.a.in_from_bottom));
        aq.k(this.fWC, w.e.cp_bg_line_d);
        aq.j(this.fWz, w.g.btn_all_blue);
        aq.c(this.fWz, w.e.cp_cont_g, 1);
        aq.c(this.mBackImageView, w.g.icon_pb_post_close_n);
        aq.c(this.fWD, w.e.cp_cont_f, 1);
        aq.c(this.fWE, w.e.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cS(List<TransmitForumData> list) {
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

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25005) {
            HotTopicBussinessData tr = this.fWB.tr(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (tr != null) {
                for (v vVar : this.mDataList) {
                    if ((vVar instanceof TransmitForumData) && TextUtils.equals(tr.mForumName, ((TransmitForumData) vVar).forumName)) {
                        return;
                    }
                }
                if (this.fWG.bot()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(tr.mForumId, tr.mForumName, false, 0));
                    showToast(w.l.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(tr.mForumId, tr.mForumName, true, 0));
                }
                bow();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bow() {
        int q = x.q(box());
        if (q > 0) {
            this.fWz.setText(getResources().getString(w.l.transmit_confirm, Integer.valueOf(q), 3));
        } else {
            this.fWz.setText(getResources().getString(w.l.transmit_confirm_no_num));
        }
    }

    public ArrayList<TransmitForumData> box() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (v vVar : this.mDataList) {
            if (vVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) vVar;
                if (transmitForumData.aaO) {
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
    public void boy() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), w.a.out_to_bottom);
        loadAnimation.setAnimationListener(new d(this));
        this.fWC.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fWB != null) {
            this.fWB.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        boy();
    }
}
