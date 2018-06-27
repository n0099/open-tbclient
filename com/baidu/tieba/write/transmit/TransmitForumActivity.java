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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View eIV;
    private View ees;
    private TextView fnv;
    private c hvb;
    private d hvc;
    private View hvd;
    private TextView hve;
    private TextView hvf;
    private TextView hvg;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fnv.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eIV.getId() || view.getId() == TransmitForumActivity.this.ees.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.FY();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bHT = TransmitForumActivity.this.bHT();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dU(bHT));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.FY();
            }
        }
    };
    private a hvh = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bHQ() {
            return w.z(TransmitForumActivity.this.bHT()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bHR() {
            TransmitForumActivity.this.showToast(d.k.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bHS() {
            TransmitForumActivity.this.aZt();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.i.transmit_forum_activity);
        this.eIV = findViewById(d.g.trasmit_back);
        this.eIV.setOnClickListener(this.mOnClickListener);
        this.fnv = (TextView) findViewById(d.g.transmit_cofirm);
        this.hve = (TextView) findViewById(d.g.transmit_title);
        this.hvf = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.fnv.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aj(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hvg = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (w.z(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hvg.setText(d.k.transmit_forum_publish_more_forum);
                    } else {
                        this.hvg.setText(d.k.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hvb = new c(getPageContext().getPageActivity(), TransmitForumData.akI);
        this.hvc = new d(getPageContext().getPageActivity(), e.akI, getUniqueId(), arrayList);
        this.hvb.a(this.hvh);
        this.mAdapters.add(this.hvb);
        this.mAdapters.add(this.hvc);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aZt();
        this.ees = findViewById(d.g.view_top);
        this.ees.setOnClickListener(this.mOnClickListener);
        this.hvd = findViewById(d.g.layout_operate);
        this.hvd.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        am.j(this.hvd, d.C0142d.cp_bg_line_d);
        am.i(this.fnv, d.f.btn_all_blue);
        am.c(this.fnv, d.C0142d.cp_cont_g, 1);
        am.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        am.c(this.hve, d.C0142d.cp_cont_f, 1);
        am.c(this.hvf, d.C0142d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dU(List<TransmitForumData> list) {
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
            HotTopicBussinessData vA = this.hvc.vA(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (vA != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(vA.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hvh.bHQ()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vA.mForumId, vA.mForumName, false, 0));
                    showToast(d.k.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vA.mForumId, vA.mForumName, true, 0));
                }
                aZt();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZt() {
        int z = w.z(bHT());
        if (z > 0) {
            this.fnv.setText(getResources().getString(d.k.transmit_confirm, Integer.valueOf(z), 3));
        } else {
            this.fnv.setText(getResources().getString(d.k.confirm));
        }
    }

    public ArrayList<TransmitForumData> bHT() {
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
    public void FY() {
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
        this.hvd.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hvc != null) {
            this.hvc.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        FY();
    }
}
