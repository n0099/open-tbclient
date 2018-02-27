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
    private View cQc;
    private View eXO;
    private TextView fCa;
    private c hGU;
    private d hGV;
    private View hGW;
    private TextView hGX;
    private TextView hGY;
    private TextView hGZ;
    private ImageView mBackImageView;
    private List<i> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fCa.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eXO.getId() || view.getId() == TransmitForumActivity.this.cQc.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Jy();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bGY = TransmitForumActivity.this.bGY();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dR(bGY));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Jy();
            }
        }
    };
    private a hHa = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bGV() {
            return v.D(TransmitForumActivity.this.bGY()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGW() {
            TransmitForumActivity.this.showToast(d.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGX() {
            TransmitForumActivity.this.aYU();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.transmit_forum_activity);
        this.eXO = findViewById(d.g.trasmit_back);
        this.eXO.setOnClickListener(this.mOnClickListener);
        this.fCa = (TextView) findViewById(d.g.transmit_cofirm);
        this.hGX = (TextView) findViewById(d.g.transmit_title);
        this.hGY = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.fCa.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aq(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hGZ = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.D(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hGZ.setText(d.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hGZ.setText(d.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hGU = new c(getPageContext().getPageActivity(), TransmitForumData.aQC);
        this.hGV = new d(getPageContext().getPageActivity(), e.aQC, getUniqueId(), arrayList);
        this.hGU.a(this.hHa);
        this.mAdapters.add(this.hGU);
        this.mAdapters.add(this.hGV);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aYU();
        this.cQc = findViewById(d.g.view_top);
        this.cQc.setOnClickListener(this.mOnClickListener);
        this.hGW = findViewById(d.g.layout_operate);
        this.hGW.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        aj.t(this.hGW, d.C0141d.cp_bg_line_d);
        aj.s(this.fCa, d.f.btn_all_blue);
        aj.e(this.fCa, d.C0141d.cp_cont_g, 1);
        aj.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        aj.e(this.hGX, d.C0141d.cp_cont_f, 1);
        aj.e(this.hGY, d.C0141d.cp_cont_d, 1);
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
            HotTopicBussinessData xw = this.hGV.xw(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (xw != null) {
                for (i iVar : this.mDataList) {
                    if ((iVar instanceof TransmitForumData) && TextUtils.equals(xw.mForumName, ((TransmitForumData) iVar).forumName)) {
                        return;
                    }
                }
                if (this.hHa.bGV()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(xw.mForumId, xw.mForumName, false, 0));
                    showToast(d.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(xw.mForumId, xw.mForumName, true, 0));
                }
                aYU();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYU() {
        int D = v.D(bGY());
        if (D > 0) {
            this.fCa.setText(getResources().getString(d.j.transmit_confirm, Integer.valueOf(D), 3));
        } else {
            this.fCa.setText(getResources().getString(d.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bGY() {
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
    public void Jy() {
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
        this.hGW.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hGV != null) {
            this.hGV.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Jy();
    }
}
