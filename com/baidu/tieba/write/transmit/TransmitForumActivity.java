package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View dKu;
    private View dgH;
    private c gED;
    private d gEE;
    private View gEF;
    private TextView gEG;
    private TextView gEH;
    private TextView gEI;
    private TextView gEq;
    private ImageView mBackImageView;
    private List<f> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.gEq.getId()) {
                    if (view.getId() == TransmitForumActivity.this.dKu.getId() || view.getId() == TransmitForumActivity.this.dgH.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.bzt();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bzs = TransmitForumActivity.this.bzs();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dF(bzs));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.bzt();
            }
        }
    };
    private a gEJ = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bzo() {
            return u.u(TransmitForumActivity.this.bzs()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bzp() {
            TransmitForumActivity.this.showToast(d.l.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bzq() {
            TransmitForumActivity.this.bzr();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.transmit_forum_activity);
        this.dKu = findViewById(d.h.trasmit_back);
        this.dKu.setOnClickListener(this.mOnClickListener);
        this.gEq = (TextView) findViewById(d.h.transmit_cofirm);
        this.gEG = (TextView) findViewById(d.h.transmit_title);
        this.gEH = (TextView) findViewById(d.h.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.h.trasmit_back);
        this.gEq.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.h.trasmit_grid_view);
        this.mListView.setMaxHeight(k.ah(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.f.ds568));
        this.mListView.setOverScrollMode(2);
        this.gEI = (TextView) findViewById(d.h.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (u.u(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.abk) {
                        this.gEI.setText(d.l.transmit_forum_publish_more_forum);
                    } else {
                        this.gEI.setText(d.l.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.gED = new c(getPageContext().getPageActivity(), TransmitForumData.abj);
        this.gEE = new d(getPageContext().getPageActivity(), e.abj, getUniqueId(), arrayList);
        this.gED.a(this.gEJ);
        this.mAdapters.add(this.gED);
        this.mAdapters.add(this.gEE);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bzr();
        this.dgH = findViewById(d.h.view_top);
        this.dgH.setOnClickListener(this.mOnClickListener);
        this.gEF = findViewById(d.h.layout_operate);
        this.gEF.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        ai.k(this.gEF, d.e.cp_bg_line_d);
        ai.j(this.gEq, d.g.btn_all_blue);
        ai.c(this.gEq, d.e.cp_cont_g, 1);
        ai.c(this.mBackImageView, d.g.icon_pb_post_close_n);
        ai.c(this.gEG, d.e.cp_cont_f, 1);
        ai.c(this.gEH, d.e.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dF(List<TransmitForumData> list) {
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
            HotTopicBussinessData uw = this.gEE.uw(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (uw != null) {
                for (f fVar : this.mDataList) {
                    if ((fVar instanceof TransmitForumData) && TextUtils.equals(uw.mForumName, ((TransmitForumData) fVar).forumName)) {
                        return;
                    }
                }
                if (this.gEJ.bzo()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(uw.mForumId, uw.mForumName, false, 0));
                    showToast(d.l.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(uw.mForumId, uw.mForumName, true, 0));
                }
                bzr();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzr() {
        int u = u.u(bzs());
        if (u > 0) {
            this.gEq.setText(getResources().getString(d.l.transmit_confirm, Integer.valueOf(u), 3));
        } else {
            this.gEq.setText(getResources().getString(d.l.transmit_confirm_no_num));
        }
    }

    public ArrayList<TransmitForumData> bzs() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (f fVar : this.mDataList) {
            if (fVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) fVar;
                if (transmitForumData.abk) {
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
    public void bzt() {
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
        this.gEF.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gEE != null) {
            this.gEE.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        bzt();
    }
}
