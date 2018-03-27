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
import com.baidu.adp.widget.ListView.i;
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
    private View cQf;
    private View eYc;
    private TextView fCq;
    private c hHs;
    private d hHt;
    private View hHu;
    private TextView hHv;
    private TextView hHw;
    private TextView hHx;
    private ImageView mBackImageView;
    private List<i> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fCq.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eYc.getId() || view.getId() == TransmitForumActivity.this.cQf.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Jz();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bHd = TransmitForumActivity.this.bHd();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dR(bHd));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Jz();
            }
        }
    };
    private a hHy = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bHa() {
            return v.D(TransmitForumActivity.this.bHd()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bHb() {
            TransmitForumActivity.this.showToast(d.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bHc() {
            TransmitForumActivity.this.aYV();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.transmit_forum_activity);
        this.eYc = findViewById(d.g.trasmit_back);
        this.eYc.setOnClickListener(this.mOnClickListener);
        this.fCq = (TextView) findViewById(d.g.transmit_cofirm);
        this.hHv = (TextView) findViewById(d.g.transmit_title);
        this.hHw = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.fCq.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aq(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hHx = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.D(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hHx.setText(d.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hHx.setText(d.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hHs = new c(getPageContext().getPageActivity(), TransmitForumData.aQE);
        this.hHt = new d(getPageContext().getPageActivity(), e.aQE, getUniqueId(), arrayList);
        this.hHs.a(this.hHy);
        this.mAdapters.add(this.hHs);
        this.mAdapters.add(this.hHt);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aYV();
        this.cQf = findViewById(d.g.view_top);
        this.cQf.setOnClickListener(this.mOnClickListener);
        this.hHu = findViewById(d.g.layout_operate);
        this.hHu.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        aj.t(this.hHu, d.C0141d.cp_bg_line_d);
        aj.s(this.fCq, d.f.btn_all_blue);
        aj.e(this.fCq, d.C0141d.cp_cont_g, 1);
        aj.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        aj.e(this.hHv, d.C0141d.cp_cont_f, 1);
        aj.e(this.hHw, d.C0141d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dR(List<TransmitForumData> list) {
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
            HotTopicBussinessData xw = this.hHt.xw(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (xw != null) {
                for (i iVar : this.mDataList) {
                    if ((iVar instanceof TransmitForumData) && TextUtils.equals(xw.mForumName, ((TransmitForumData) iVar).forumName)) {
                        return;
                    }
                }
                if (this.hHy.bHa()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(xw.mForumId, xw.mForumName, false, 0));
                    showToast(d.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(xw.mForumId, xw.mForumName, true, 0));
                }
                aYV();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYV() {
        int D = v.D(bHd());
        if (D > 0) {
            this.fCq.setText(getResources().getString(d.j.transmit_confirm, Integer.valueOf(D), 3));
        } else {
            this.fCq.setText(getResources().getString(d.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bHd() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (i iVar : this.mDataList) {
            if (iVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) iVar;
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
    public void Jz() {
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
        this.hHu.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hHt != null) {
            this.hHt.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Jz();
    }
}
