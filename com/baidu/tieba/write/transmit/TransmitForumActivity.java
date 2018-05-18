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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View chi;
    private TextView eYe;
    private View etP;
    private c heX;
    private d heY;
    private View heZ;
    private TextView hfa;
    private TextView hfb;
    private TextView hfc;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null) {
                if (view2.getId() != TransmitForumActivity.this.eYe.getId()) {
                    if (view2.getId() == TransmitForumActivity.this.etP.getId() || view2.getId() == TransmitForumActivity.this.chi.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Cd();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bCn = TransmitForumActivity.this.bCn();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dL(bCn));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Cd();
            }
        }
    };
    private a hfd = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bCk() {
            return v.v(TransmitForumActivity.this.bCn()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bCl() {
            TransmitForumActivity.this.showToast(d.k.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bCm() {
            TransmitForumActivity.this.aTQ();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.i.transmit_forum_activity);
        this.etP = findViewById(d.g.trasmit_back);
        this.etP.setOnClickListener(this.mOnClickListener);
        this.eYe = (TextView) findViewById(d.g.transmit_cofirm);
        this.hfa = (TextView) findViewById(d.g.transmit_title);
        this.hfb = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.eYe.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.ah(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hfc = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.v(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hfc.setText(d.k.transmit_forum_publish_more_forum);
                    } else {
                        this.hfc.setText(d.k.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.heX = new c(getPageContext().getPageActivity(), TransmitForumData.acf);
        this.heY = new d(getPageContext().getPageActivity(), e.acf, getUniqueId(), arrayList);
        this.heX.a(this.hfd);
        this.mAdapters.add(this.heX);
        this.mAdapters.add(this.heY);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aTQ();
        this.chi = findViewById(d.g.view_top);
        this.chi.setOnClickListener(this.mOnClickListener);
        this.heZ = findViewById(d.g.layout_operate);
        this.heZ.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        ak.j(this.heZ, d.C0126d.cp_bg_line_d);
        ak.i(this.eYe, d.f.btn_all_blue);
        ak.c(this.eYe, d.C0126d.cp_cont_g, 1);
        ak.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        ak.c(this.hfa, d.C0126d.cp_cont_f, 1);
        ak.c(this.hfb, d.C0126d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dL(List<TransmitForumData> list) {
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
            HotTopicBussinessData uZ = this.heY.uZ(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (uZ != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(uZ.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hfd.bCk()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(uZ.mForumId, uZ.mForumName, false, 0));
                    showToast(d.k.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(uZ.mForumId, uZ.mForumName, true, 0));
                }
                aTQ();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTQ() {
        int v = v.v(bCn());
        if (v > 0) {
            this.eYe.setText(getResources().getString(d.k.transmit_confirm, Integer.valueOf(v), 3));
        } else {
            this.eYe.setText(getResources().getString(d.k.confirm));
        }
    }

    public ArrayList<TransmitForumData> bCn() {
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
    public void Cd() {
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
        this.heZ.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.heY != null) {
            this.heY.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Cd();
    }
}
