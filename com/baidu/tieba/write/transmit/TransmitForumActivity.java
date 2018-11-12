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
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private TextView fDY;
    private View fdi;
    private c hND;
    private d hNE;
    private View hNF;
    private TextView hNG;
    private TextView hNH;
    private TextView hNI;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private View mTopView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fDY.getId()) {
                    if (view.getId() == TransmitForumActivity.this.fdi.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Jx();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bMk = TransmitForumActivity.this.bMk();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.ed(bMk));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Jx();
            }
        }
    };
    private a hNJ = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bMh() {
            return v.H(TransmitForumActivity.this.bMk()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bMi() {
            TransmitForumActivity.this.showToast(e.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bMj() {
            TransmitForumActivity.this.bcH();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(e.h.transmit_forum_activity);
        this.fdi = findViewById(e.g.trasmit_back);
        this.fdi.setOnClickListener(this.mOnClickListener);
        this.fDY = (TextView) findViewById(e.g.transmit_cofirm);
        this.hNG = (TextView) findViewById(e.g.transmit_title);
        this.hNH = (TextView) findViewById(e.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(e.g.trasmit_back);
        this.fDY.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(e.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aQ(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(e.C0200e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hNI = (TextView) findViewById(e.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.H(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hNI.setText(e.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hNI.setText(e.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hND = new c(getPageContext().getPageActivity(), TransmitForumData.asv);
        this.hNE = new d(getPageContext().getPageActivity(), e.asv, getUniqueId(), arrayList);
        this.hND.a(this.hNJ);
        this.mAdapters.add(this.hND);
        this.mAdapters.add(this.hNE);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bcH();
        this.mTopView = findViewById(e.g.view_top);
        this.mTopView.setOnClickListener(this.mOnClickListener);
        this.hNF = findViewById(e.g.layout_operate);
        this.hNF.startAnimation(AnimationUtils.loadAnimation(getActivity(), e.a.in_from_bottom));
        al.j(this.hNF, e.d.cp_bg_line_d);
        al.i(this.fDY, e.f.btn_all_blue);
        al.c(this.fDY, e.d.cp_cont_g, 1);
        al.c(this.mBackImageView, e.f.icon_pb_post_close_n);
        al.c(this.hNG, e.d.cp_cont_f, 1);
        al.c(this.hNH, e.d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ed(List<TransmitForumData> list) {
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
            HotTopicBussinessData wP = this.hNE.wP(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (wP != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(wP.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hNJ.bMh()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(wP.mForumId, wP.mForumName, false, 0));
                    showToast(e.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(wP.mForumId, wP.mForumName, true, 0));
                }
                bcH();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcH() {
        int H = v.H(bMk());
        if (H > 0) {
            this.fDY.setText(getResources().getString(e.j.transmit_confirm, Integer.valueOf(H), 3));
        } else {
            this.fDY.setText(getResources().getString(e.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bMk() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (h hVar : this.mDataList) {
            if (hVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) hVar;
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
    public void Jx() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), e.a.out_to_bottom);
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
        this.hNF.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hNE != null) {
            this.hNE.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Jx();
    }
}
