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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View eMK;
    private TextView fnA;
    private c hwj;
    private d hwk;
    private View hwl;
    private TextView hwm;
    private TextView hwn;
    private TextView hwo;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private View mTopView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fnA.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eMK.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.FU();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bGI = TransmitForumActivity.this.bGI();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dQ(bGI));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.FU();
            }
        }
    };
    private a hwp = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bGF() {
            return w.y(TransmitForumActivity.this.bGI()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGG() {
            TransmitForumActivity.this.showToast(f.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGH() {
            TransmitForumActivity.this.aXJ();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(f.h.transmit_forum_activity);
        this.eMK = findViewById(f.g.trasmit_back);
        this.eMK.setOnClickListener(this.mOnClickListener);
        this.fnA = (TextView) findViewById(f.g.transmit_cofirm);
        this.hwm = (TextView) findViewById(f.g.transmit_title);
        this.hwn = (TextView) findViewById(f.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(f.g.trasmit_back);
        this.fnA.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(f.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aj(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(f.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hwo = (TextView) findViewById(f.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (w.y(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hwo.setText(f.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hwo.setText(f.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hwj = new c(getPageContext().getPageActivity(), TransmitForumData.akh);
        this.hwk = new d(getPageContext().getPageActivity(), e.akh, getUniqueId(), arrayList);
        this.hwj.a(this.hwp);
        this.mAdapters.add(this.hwj);
        this.mAdapters.add(this.hwk);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aXJ();
        this.mTopView = findViewById(f.g.view_top);
        this.mTopView.setOnClickListener(this.mOnClickListener);
        this.hwl = findViewById(f.g.layout_operate);
        this.hwl.startAnimation(AnimationUtils.loadAnimation(getActivity(), f.a.in_from_bottom));
        am.j(this.hwl, f.d.cp_bg_line_d);
        am.i(this.fnA, f.C0146f.btn_all_blue);
        am.c(this.fnA, f.d.cp_cont_g, 1);
        am.c(this.mBackImageView, f.C0146f.icon_pb_post_close_n);
        am.c(this.hwm, f.d.cp_cont_f, 1);
        am.c(this.hwn, f.d.cp_cont_d, 1);
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
            HotTopicBussinessData vz = this.hwk.vz(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (vz != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(vz.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hwp.bGF()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vz.mForumId, vz.mForumName, false, 0));
                    showToast(f.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vz.mForumId, vz.mForumName, true, 0));
                }
                aXJ();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXJ() {
        int y = w.y(bGI());
        if (y > 0) {
            this.fnA.setText(getResources().getString(f.j.transmit_confirm, Integer.valueOf(y), 3));
        } else {
            this.fnA.setText(getResources().getString(f.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bGI() {
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
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), f.a.out_to_bottom);
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
        this.hwl.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hwk != null) {
            this.hwk.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        FU();
    }
}
