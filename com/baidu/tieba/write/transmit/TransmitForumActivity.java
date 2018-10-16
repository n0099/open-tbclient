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
    private TextView fCA;
    private View fbN;
    private c hLS;
    private d hLT;
    private View hLU;
    private TextView hLV;
    private TextView hLW;
    private TextView hLX;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private View mTopView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fCA.getId()) {
                    if (view.getId() == TransmitForumActivity.this.fbN.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Jl();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bML = TransmitForumActivity.this.bML();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.ef(bML));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Jl();
            }
        }
    };
    private a hLY = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bMI() {
            return v.I(TransmitForumActivity.this.bML()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bMJ() {
            TransmitForumActivity.this.showToast(e.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bMK() {
            TransmitForumActivity.this.bdi();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(e.h.transmit_forum_activity);
        this.fbN = findViewById(e.g.trasmit_back);
        this.fbN.setOnClickListener(this.mOnClickListener);
        this.fCA = (TextView) findViewById(e.g.transmit_cofirm);
        this.hLV = (TextView) findViewById(e.g.transmit_title);
        this.hLW = (TextView) findViewById(e.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(e.g.trasmit_back);
        this.fCA.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(e.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aQ(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(e.C0175e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hLX = (TextView) findViewById(e.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.I(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hLX.setText(e.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hLX.setText(e.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hLS = new c(getPageContext().getPageActivity(), TransmitForumData.arI);
        this.hLT = new d(getPageContext().getPageActivity(), e.arI, getUniqueId(), arrayList);
        this.hLS.a(this.hLY);
        this.mAdapters.add(this.hLS);
        this.mAdapters.add(this.hLT);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bdi();
        this.mTopView = findViewById(e.g.view_top);
        this.mTopView.setOnClickListener(this.mOnClickListener);
        this.hLU = findViewById(e.g.layout_operate);
        this.hLU.startAnimation(AnimationUtils.loadAnimation(getActivity(), e.a.in_from_bottom));
        al.j(this.hLU, e.d.cp_bg_line_d);
        al.i(this.fCA, e.f.btn_all_blue);
        al.c(this.fCA, e.d.cp_cont_g, 1);
        al.c(this.mBackImageView, e.f.icon_pb_post_close_n);
        al.c(this.hLV, e.d.cp_cont_f, 1);
        al.c(this.hLW, e.d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ef(List<TransmitForumData> list) {
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
            HotTopicBussinessData ww = this.hLT.ww(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (ww != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(ww.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hLY.bMI()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(ww.mForumId, ww.mForumName, false, 0));
                    showToast(e.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(ww.mForumId, ww.mForumName, true, 0));
                }
                bdi();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdi() {
        int I = v.I(bML());
        if (I > 0) {
            this.fCA.setText(getResources().getString(e.j.transmit_confirm, Integer.valueOf(I), 3));
        } else {
            this.fCA.setText(getResources().getString(e.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bML() {
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
    public void Jl() {
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
        this.hLU.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hLT != null) {
            this.hLT.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Jl();
    }
}
