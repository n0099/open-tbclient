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
    private View eMP;
    private View eii;
    private TextView fnG;
    private c hwh;
    private d hwi;
    private View hwj;
    private TextView hwk;
    private TextView hwl;
    private TextView hwm;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fnG.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eMP.getId() || view.getId() == TransmitForumActivity.this.eii.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.FU();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bGE = TransmitForumActivity.this.bGE();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dQ(bGE));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.FU();
            }
        }
    };
    private a hwn = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bGB() {
            return w.y(TransmitForumActivity.this.bGE()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGC() {
            TransmitForumActivity.this.showToast(d.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGD() {
            TransmitForumActivity.this.aXO();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.transmit_forum_activity);
        this.eMP = findViewById(d.g.trasmit_back);
        this.eMP.setOnClickListener(this.mOnClickListener);
        this.fnG = (TextView) findViewById(d.g.transmit_cofirm);
        this.hwk = (TextView) findViewById(d.g.transmit_title);
        this.hwl = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.fnG.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aj(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hwm = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (w.y(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hwm.setText(d.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hwm.setText(d.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hwh = new c(getPageContext().getPageActivity(), TransmitForumData.akh);
        this.hwi = new d(getPageContext().getPageActivity(), e.akh, getUniqueId(), arrayList);
        this.hwh.a(this.hwn);
        this.mAdapters.add(this.hwh);
        this.mAdapters.add(this.hwi);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aXO();
        this.eii = findViewById(d.g.view_top);
        this.eii.setOnClickListener(this.mOnClickListener);
        this.hwj = findViewById(d.g.layout_operate);
        this.hwj.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        am.j(this.hwj, d.C0140d.cp_bg_line_d);
        am.i(this.fnG, d.f.btn_all_blue);
        am.c(this.fnG, d.C0140d.cp_cont_g, 1);
        am.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        am.c(this.hwk, d.C0140d.cp_cont_f, 1);
        am.c(this.hwl, d.C0140d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dQ(List<TransmitForumData> list) {
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
            HotTopicBussinessData vz = this.hwi.vz(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (vz != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(vz.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hwn.bGB()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vz.mForumId, vz.mForumName, false, 0));
                    showToast(d.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vz.mForumId, vz.mForumName, true, 0));
                }
                aXO();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXO() {
        int y = w.y(bGE());
        if (y > 0) {
            this.fnG.setText(getResources().getString(d.j.transmit_confirm, Integer.valueOf(y), 3));
        } else {
            this.fnG.setText(getResources().getString(d.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bGE() {
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
    public void FU() {
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
        this.hwj.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hwi != null) {
            this.hwi.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        FU();
    }
}
