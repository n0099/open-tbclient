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
    private View dBj;
    private TextView eKr;
    private View ebZ;
    private c hhB;
    private d hhC;
    private View hhD;
    private TextView hhE;
    private TextView hhF;
    private TextView hhG;
    private ImageView mBackImageView;
    private List<f> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.eKr.getId()) {
                    if (view.getId() == TransmitForumActivity.this.ebZ.getId() || view.getId() == TransmitForumActivity.this.dBj.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Bz();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bGW = TransmitForumActivity.this.bGW();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dW(bGW));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Bz();
            }
        }
    };
    private a hhH = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bGT() {
            return v.v(TransmitForumActivity.this.bGW()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGU() {
            TransmitForumActivity.this.showToast(d.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGV() {
            TransmitForumActivity.this.aPS();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.transmit_forum_activity);
        this.ebZ = findViewById(d.g.trasmit_back);
        this.ebZ.setOnClickListener(this.mOnClickListener);
        this.eKr = (TextView) findViewById(d.g.transmit_cofirm);
        this.hhE = (TextView) findViewById(d.g.transmit_title);
        this.hhF = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.eKr.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.ae(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hhG = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.v(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hhG.setText(d.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hhG.setText(d.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hhB = new c(getPageContext().getPageActivity(), TransmitForumData.aaP);
        this.hhC = new d(getPageContext().getPageActivity(), e.aaP, getUniqueId(), arrayList);
        this.hhB.a(this.hhH);
        this.mAdapters.add(this.hhB);
        this.mAdapters.add(this.hhC);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aPS();
        this.dBj = findViewById(d.g.view_top);
        this.dBj.setOnClickListener(this.mOnClickListener);
        this.hhD = findViewById(d.g.layout_operate);
        this.hhD.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        aj.k(this.hhD, d.C0096d.cp_bg_line_d);
        aj.j(this.eKr, d.f.btn_all_blue);
        aj.c(this.eKr, d.C0096d.cp_cont_g, 1);
        aj.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        aj.c(this.hhE, d.C0096d.cp_cont_f, 1);
        aj.c(this.hhF, d.C0096d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dW(List<TransmitForumData> list) {
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
            HotTopicBussinessData wc = this.hhC.wc(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (wc != null) {
                for (f fVar : this.mDataList) {
                    if ((fVar instanceof TransmitForumData) && TextUtils.equals(wc.mForumName, ((TransmitForumData) fVar).forumName)) {
                        return;
                    }
                }
                if (this.hhH.bGT()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(wc.mForumId, wc.mForumName, false, 0));
                    showToast(d.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(wc.mForumId, wc.mForumName, true, 0));
                }
                aPS();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPS() {
        int v = v.v(bGW());
        if (v > 0) {
            this.eKr.setText(getResources().getString(d.j.transmit_confirm, Integer.valueOf(v), 3));
        } else {
            this.eKr.setText(getResources().getString(d.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bGW() {
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
    public void Bz() {
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
        this.hhD.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hhC != null) {
            this.hhC.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Bz();
    }
}
