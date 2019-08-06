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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View bCe;
    private TextView hDa;
    private c jRd;
    private d jRe;
    private View jRf;
    private TextView jRg;
    private TextView jRh;
    private TextView jRi;
    private ImageView mBackImageView;
    private List<m> mDataList;
    private BdTypeListView mListView;
    private View mTopView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.hDa.getId()) {
                    if (view.getId() == TransmitForumActivity.this.bCe.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.aqB();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> cBh = TransmitForumActivity.this.cBh();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.ex(cBh));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.aqB();
            }
        }
    };
    private a jRj = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean cBe() {
            return v.Z(TransmitForumActivity.this.cBh()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void cBf() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void cBg() {
            TransmitForumActivity.this.bQU();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.bCe = findViewById(R.id.trasmit_back);
        this.bCe.setOnClickListener(this.mOnClickListener);
        this.hDa = (TextView) findViewById(R.id.transmit_cofirm);
        this.jRg = (TextView) findViewById(R.id.transmit_title);
        this.jRh = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.hDa.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.mListView.setMaxHeight(l.ah(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.mListView.setOverScrollMode(2);
        this.jRi = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.Z(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.jRi.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.jRi.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.jRd = new c(getPageContext().getPageActivity(), TransmitForumData.bMI);
        this.jRe = new d(getPageContext().getPageActivity(), e.bMI, getUniqueId(), arrayList);
        this.jRd.a(this.jRj);
        this.mAdapters.add(this.jRd);
        this.mAdapters.add(this.jRe);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bQU();
        this.mTopView = findViewById(R.id.view_top);
        this.mTopView.setOnClickListener(this.mOnClickListener);
        this.jRf = findViewById(R.id.layout_operate);
        this.jRf.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        am.l(this.jRf, R.color.cp_bg_line_d);
        am.k(this.hDa, R.drawable.btn_all_blue);
        am.f(this.hDa, R.color.cp_cont_g, 1);
        am.c(this.mBackImageView, (int) R.drawable.icon_pb_post_close_n);
        am.f(this.jRg, R.color.cp_cont_f, 1);
        am.f(this.jRh, R.color.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ex(List<TransmitForumData> list) {
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
            HotTopicBussinessData Df = this.jRe.Df(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (Df != null) {
                for (m mVar : this.mDataList) {
                    if ((mVar instanceof TransmitForumData) && TextUtils.equals(Df.mForumName, ((TransmitForumData) mVar).forumName)) {
                        return;
                    }
                }
                if (this.jRj.cBe()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Df.mForumId, Df.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Df.mForumId, Df.mForumName, true, 0));
                }
                bQU();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQU() {
        int Z = v.Z(cBh());
        if (Z > 0) {
            this.hDa.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(Z), 3));
        } else {
            this.hDa.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> cBh() {
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
    public void aqB() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.out_to_bottom);
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
        this.jRf.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jRe != null) {
            this.jRe.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        aqB();
    }
}
