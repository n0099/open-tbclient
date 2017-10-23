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
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View dLn;
    private View dki;
    private TextView euw;
    private c gIJ;
    private d gIK;
    private View gIL;
    private TextView gIM;
    private TextView gIN;
    private TextView gIO;
    private ImageView mBackImageView;
    private List<f> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.euw.getId()) {
                    if (view.getId() == TransmitForumActivity.this.dLn.getId() || view.getId() == TransmitForumActivity.this.dki.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Hc();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bzU = TransmitForumActivity.this.bzU();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dH(bzU));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Hc();
            }
        }
    };
    private a gIP = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bzR() {
            return v.t(TransmitForumActivity.this.bzU()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bzS() {
            TransmitForumActivity.this.showToast(d.l.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bzT() {
            TransmitForumActivity.this.aLT();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.transmit_forum_activity);
        this.dLn = findViewById(d.h.trasmit_back);
        this.dLn.setOnClickListener(this.mOnClickListener);
        this.euw = (TextView) findViewById(d.h.transmit_cofirm);
        this.gIM = (TextView) findViewById(d.h.transmit_title);
        this.gIN = (TextView) findViewById(d.h.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.h.trasmit_back);
        this.euw.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.h.trasmit_grid_view);
        this.mListView.setMaxHeight(l.af(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.f.ds568));
        this.mListView.setOverScrollMode(2);
        this.gIO = (TextView) findViewById(d.h.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.t(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.gIO.setText(d.l.transmit_forum_publish_more_forum);
                    } else {
                        this.gIO.setText(d.l.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.gIJ = new c(getPageContext().getPageActivity(), TransmitForumData.aad);
        this.gIK = new d(getPageContext().getPageActivity(), e.aad, getUniqueId(), arrayList);
        this.gIJ.a(this.gIP);
        this.mAdapters.add(this.gIJ);
        this.mAdapters.add(this.gIK);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aLT();
        this.dki = findViewById(d.h.view_top);
        this.dki.setOnClickListener(this.mOnClickListener);
        this.gIL = findViewById(d.h.layout_operate);
        this.gIL.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        aj.k(this.gIL, d.e.cp_bg_line_d);
        aj.j(this.euw, d.g.btn_all_blue);
        aj.c(this.euw, d.e.cp_cont_g, 1);
        aj.c(this.mBackImageView, d.g.icon_pb_post_close_n);
        aj.c(this.gIM, d.e.cp_cont_f, 1);
        aj.c(this.gIN, d.e.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dH(List<TransmitForumData> list) {
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
            HotTopicBussinessData uV = this.gIK.uV(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (uV != null) {
                for (f fVar : this.mDataList) {
                    if ((fVar instanceof TransmitForumData) && TextUtils.equals(uV.mForumName, ((TransmitForumData) fVar).forumName)) {
                        return;
                    }
                }
                if (this.gIP.bzR()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(uV.mForumId, uV.mForumName, false, 0));
                    showToast(d.l.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(uV.mForumId, uV.mForumName, true, 0));
                }
                aLT();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLT() {
        int t = v.t(bzU());
        if (t > 0) {
            this.euw.setText(getResources().getString(d.l.transmit_confirm, Integer.valueOf(t), 3));
        } else {
            this.euw.setText(getResources().getString(d.l.confirm));
        }
    }

    public ArrayList<TransmitForumData> bzU() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (f fVar : this.mDataList) {
            if (fVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) fVar;
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
    public void Hc() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), d.a.out_to_bottom);
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
        this.gIL.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gIK != null) {
            this.gIK.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Hc();
    }
}
