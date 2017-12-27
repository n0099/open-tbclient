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
    private View eQI;
    private View enq;
    private TextView fwR;
    private c hPH;
    private d hPI;
    private View hPJ;
    private TextView hPK;
    private TextView hPL;
    private TextView hPM;
    private ImageView mBackImageView;
    private List<i> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fwR.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eQI.getId() || view.getId() == TransmitForumActivity.this.enq.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Jb();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bMJ = TransmitForumActivity.this.bMJ();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.ec(bMJ));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Jb();
            }
        }
    };
    private a hPN = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bMG() {
            return v.F(TransmitForumActivity.this.bMJ()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bMH() {
            TransmitForumActivity.this.showToast(d.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bMI() {
            TransmitForumActivity.this.aXc();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.transmit_forum_activity);
        this.eQI = findViewById(d.g.trasmit_back);
        this.eQI.setOnClickListener(this.mOnClickListener);
        this.fwR = (TextView) findViewById(d.g.transmit_cofirm);
        this.hPK = (TextView) findViewById(d.g.transmit_title);
        this.hPL = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.fwR.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aq(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hPM = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.F(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hPM.setText(d.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hPM.setText(d.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hPH = new c(getPageContext().getPageActivity(), TransmitForumData.aPo);
        this.hPI = new d(getPageContext().getPageActivity(), e.aPo, getUniqueId(), arrayList);
        this.hPH.a(this.hPN);
        this.mAdapters.add(this.hPH);
        this.mAdapters.add(this.hPI);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aXc();
        this.enq = findViewById(d.g.view_top);
        this.enq.setOnClickListener(this.mOnClickListener);
        this.hPJ = findViewById(d.g.layout_operate);
        this.hPJ.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        aj.t(this.hPJ, d.C0108d.cp_bg_line_d);
        aj.s(this.fwR, d.f.btn_all_blue);
        aj.e(this.fwR, d.C0108d.cp_cont_g, 1);
        aj.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        aj.e(this.hPK, d.C0108d.cp_cont_f, 1);
        aj.e(this.hPL, d.C0108d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ec(List<TransmitForumData> list) {
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
            HotTopicBussinessData yT = this.hPI.yT(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (yT != null) {
                for (i iVar : this.mDataList) {
                    if ((iVar instanceof TransmitForumData) && TextUtils.equals(yT.mForumName, ((TransmitForumData) iVar).forumName)) {
                        return;
                    }
                }
                if (this.hPN.bMG()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(yT.mForumId, yT.mForumName, false, 0));
                    showToast(d.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(yT.mForumId, yT.mForumName, true, 0));
                }
                aXc();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXc() {
        int F = v.F(bMJ());
        if (F > 0) {
            this.fwR.setText(getResources().getString(d.j.transmit_confirm, Integer.valueOf(F), 3));
        } else {
            this.fwR.setText(getResources().getString(d.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bMJ() {
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
    public void Jb() {
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
        this.hPJ.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hPI != null) {
            this.hPI.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Jb();
    }
}
