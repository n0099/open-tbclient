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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View cUK;
    private View dyF;
    private h ghB;
    private k ghC;
    private View ghD;
    private TextView ghE;
    private TextView ghF;
    private TextView ghG;
    private TextView gho;
    private ImageView mBackImageView;
    private List<v> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new e(this);
    private a ghH = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(w.j.transmit_forum_activity);
        this.dyF = findViewById(w.h.trasmit_back);
        this.dyF.setOnClickListener(this.mOnClickListener);
        this.gho = (TextView) findViewById(w.h.transmit_cofirm);
        this.ghE = (TextView) findViewById(w.h.transmit_title);
        this.ghF = (TextView) findViewById(w.h.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(w.h.trasmit_back);
        this.gho.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(w.h.trasmit_grid_view);
        this.mListView.setMaxHeight(com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(w.f.ds568));
        this.mListView.setOverScrollMode(2);
        this.ghG = (TextView) findViewById(w.h.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (z.s(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.aaP) {
                        this.ghG.setText(w.l.transmit_forum_publish_more_forum);
                    } else {
                        this.ghG.setText(w.l.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new n());
        this.ghB = new h(getPageContext().getPageActivity(), TransmitForumData.ghM);
        this.ghC = new k(getPageContext().getPageActivity(), n.ghM, getUniqueId(), arrayList);
        this.ghB.a(this.ghH);
        this.mAdapters.add(this.ghB);
        this.mAdapters.add(this.ghC);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bsU();
        this.cUK = findViewById(w.h.view_top);
        this.cUK.setOnClickListener(this.mOnClickListener);
        this.ghD = findViewById(w.h.layout_operate);
        this.ghD.startAnimation(AnimationUtils.loadAnimation(getActivity(), w.a.in_from_bottom));
        as.k(this.ghD, w.e.cp_bg_line_d);
        as.j(this.gho, w.g.btn_all_blue);
        as.c(this.gho, w.e.cp_cont_g, 1);
        as.c(this.mBackImageView, w.g.icon_pb_post_close_n);
        as.c(this.ghE, w.e.cp_cont_f, 1);
        as.c(this.ghF, w.e.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dh(List<TransmitForumData> list) {
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
            HotTopicBussinessData tN = this.ghC.tN(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (tN != null) {
                for (v vVar : this.mDataList) {
                    if ((vVar instanceof TransmitForumData) && TextUtils.equals(tN.mForumName, ((TransmitForumData) vVar).forumName)) {
                        return;
                    }
                }
                if (this.ghH.bsR()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(tN.mForumId, tN.mForumName, false, 0));
                    showToast(w.l.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(tN.mForumId, tN.mForumName, true, 0));
                }
                bsU();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsU() {
        int s = z.s(bsV());
        if (s > 0) {
            this.gho.setText(getResources().getString(w.l.transmit_confirm, Integer.valueOf(s), 3));
        } else {
            this.gho.setText(getResources().getString(w.l.transmit_confirm_no_num));
        }
    }

    public ArrayList<TransmitForumData> bsV() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (v vVar : this.mDataList) {
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
    public void bsX() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), w.a.out_to_bottom);
        loadAnimation.setAnimationListener(new g(this));
        this.ghD.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ghC != null) {
            this.ghC.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        bsX();
    }
}
