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
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View gDS;
    private TextView heN;
    private c jqi;
    private d jqj;
    private View jqk;
    private TextView jql;
    private TextView jqm;
    private TextView jqn;
    private ImageView mBackImageView;
    private List<m> mDataList;
    private BdTypeListView mListView;
    private View mTopView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.heN.getId()) {
                    if (view.getId() == TransmitForumActivity.this.gDS.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.akv();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> cpG = TransmitForumActivity.this.cpG();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.eo(cpG));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.akv();
            }
        }
    };
    private a jqo = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean cpD() {
            return v.S(TransmitForumActivity.this.cpG()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void cpE() {
            TransmitForumActivity.this.showToast(d.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void cpF() {
            TransmitForumActivity.this.bGn();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.transmit_forum_activity);
        this.gDS = findViewById(d.g.trasmit_back);
        this.gDS.setOnClickListener(this.mOnClickListener);
        this.heN = (TextView) findViewById(d.g.transmit_cofirm);
        this.jql = (TextView) findViewById(d.g.transmit_title);
        this.jqm = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.heN.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aQ(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.jqn = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.S(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.jqn.setText(d.j.transmit_forum_publish_more_forum);
                    } else {
                        this.jqn.setText(d.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.jqi = new c(getPageContext().getPageActivity(), TransmitForumData.bEd);
        this.jqj = new d(getPageContext().getPageActivity(), e.bEd, getUniqueId(), arrayList);
        this.jqi.a(this.jqo);
        this.mAdapters.add(this.jqi);
        this.mAdapters.add(this.jqj);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bGn();
        this.mTopView = findViewById(d.g.view_top);
        this.mTopView.setOnClickListener(this.mOnClickListener);
        this.jqk = findViewById(d.g.layout_operate);
        this.jqk.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        al.l(this.jqk, d.C0236d.cp_bg_line_d);
        al.k(this.heN, d.f.btn_all_blue);
        al.d(this.heN, d.C0236d.cp_cont_g, 1);
        al.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        al.d(this.jql, d.C0236d.cp_cont_f, 1);
        al.d(this.jqm, d.C0236d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String eo(List<TransmitForumData> list) {
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
            HotTopicBussinessData Br = this.jqj.Br(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (Br != null) {
                for (m mVar : this.mDataList) {
                    if ((mVar instanceof TransmitForumData) && TextUtils.equals(Br.mForumName, ((TransmitForumData) mVar).forumName)) {
                        return;
                    }
                }
                if (this.jqo.cpD()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Br.mForumId, Br.mForumName, false, 0));
                    showToast(d.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Br.mForumId, Br.mForumName, true, 0));
                }
                bGn();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGn() {
        int S = v.S(cpG());
        if (S > 0) {
            this.heN.setText(getResources().getString(d.j.transmit_confirm, Integer.valueOf(S), 3));
        } else {
            this.heN.setText(getResources().getString(d.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> cpG() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (m mVar : this.mDataList) {
            if (mVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) mVar;
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
    public void akv() {
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
        this.jqk.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jqj != null) {
            this.jqj.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        akv();
    }
}
