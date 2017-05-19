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
    private List<v> aSY;
    private View cHp;
    private View eOf;
    private TextView fOD;
    private e fOE;
    private h fOF;
    private View fOG;
    private TextView fOH;
    private TextView fOI;
    private TextView fOJ;
    private ImageView mBackImageView;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new b(this);
    private a fOK = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(w.j.transmit_forum_activity);
        this.eOf = findViewById(w.h.trasmit_back);
        this.eOf.setOnClickListener(this.mOnClickListener);
        this.fOD = (TextView) findViewById(w.h.transmit_cofirm);
        this.fOH = (TextView) findViewById(w.h.transmit_title);
        this.fOI = (TextView) findViewById(w.h.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(w.h.trasmit_back);
        this.fOD.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(w.h.trasmit_grid_view);
        this.mListView.setMaxHeight(com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(w.f.ds568));
        this.mListView.setOverScrollMode(2);
        this.fOJ = (TextView) findViewById(w.h.transmit_subtitle);
        this.aSY = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (x.q(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.aaP) {
                        this.fOJ.setText(w.l.transmit_forum_publish_more_forum);
                    } else {
                        this.fOJ.setText(w.l.transmit_forum_select_more_forum);
                    }
                }
                this.aSY.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.aSY.add(new k());
        this.fOE = new e(getPageContext().getPageActivity(), TransmitForumData.fOQ);
        this.fOF = new h(getPageContext().getPageActivity(), k.fOQ, arrayList);
        this.fOE.a(this.fOK);
        this.mAdapters.add(this.fOE);
        this.mAdapters.add(this.fOF);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.aSY);
        bmX();
        this.cHp = findViewById(w.h.view_top);
        this.cHp.setOnClickListener(this.mOnClickListener);
        this.fOG = findViewById(w.h.layout_operate);
        this.fOG.startAnimation(AnimationUtils.loadAnimation(getActivity(), w.a.in_from_bottom));
        aq.k(this.fOG, w.e.cp_bg_line_d);
        aq.j(this.fOD, w.g.btn_all_blue);
        aq.c(this.fOD, w.e.cp_cont_g, 1);
        aq.c(this.mBackImageView, w.g.icon_pb_post_close_n);
        aq.c(this.fOH, w.e.cp_cont_f, 1);
        aq.c(this.fOI, w.e.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cQ(List<TransmitForumData> list) {
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
            HotTopicBussinessData sW = this.fOF.sW(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (sW != null) {
                for (v vVar : this.aSY) {
                    if ((vVar instanceof TransmitForumData) && TextUtils.equals(sW.mForumName, ((TransmitForumData) vVar).forumName)) {
                        return;
                    }
                }
                if (this.fOK.bmU()) {
                    this.aSY.add(this.aSY.size() - 1, new TransmitForumData(sW.mForumId, sW.mForumName, false, 0));
                    showToast(w.l.transmit_max_commit);
                } else {
                    this.aSY.add(this.aSY.size() - 1, new TransmitForumData(sW.mForumId, sW.mForumName, true, 0));
                }
                bmX();
                this.mListView.setData(this.aSY);
                this.mListView.setSelection(this.aSY.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmX() {
        int q = x.q(bmY());
        if (q > 0) {
            this.fOD.setText(getResources().getString(w.l.transmit_confirm, Integer.valueOf(q), 3));
        } else {
            this.fOD.setText(getResources().getString(w.l.transmit_confirm_no_num));
        }
    }

    public ArrayList<TransmitForumData> bmY() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (v vVar : this.aSY) {
            if (vVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) vVar;
                if (transmitForumData.aaP) {
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
    public void bmZ() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), w.a.out_to_bottom);
        loadAnimation.setAnimationListener(new d(this));
        this.fOG.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fOF != null) {
            this.fOF.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        bmZ();
    }
}
