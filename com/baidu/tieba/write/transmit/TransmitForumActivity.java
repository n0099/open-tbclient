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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View gUW;
    private TextView hvS;
    private c jIS;
    private d jIT;
    private View jIU;
    private TextView jIV;
    private TextView jIW;
    private TextView jIX;
    private ImageView mBackImageView;
    private List<m> mDataList;
    private BdTypeListView mListView;
    private View mTopView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.hvS.getId()) {
                    if (view.getId() == TransmitForumActivity.this.gUW.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.apu();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> cxN = TransmitForumActivity.this.cxN();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.ev(cxN));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.apu();
            }
        }
    };
    private a jIY = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean cxK() {
            return v.Z(TransmitForumActivity.this.cxN()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void cxL() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void cxM() {
            TransmitForumActivity.this.bNT();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.gUW = findViewById(R.id.trasmit_back);
        this.gUW.setOnClickListener(this.mOnClickListener);
        this.hvS = (TextView) findViewById(R.id.transmit_cofirm);
        this.jIV = (TextView) findViewById(R.id.transmit_title);
        this.jIW = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.hvS.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.mListView.setMaxHeight(l.ah(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.mListView.setOverScrollMode(2);
        this.jIX = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.Z(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.jIX.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.jIX.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.jIS = new c(getPageContext().getPageActivity(), TransmitForumData.bLC);
        this.jIT = new d(getPageContext().getPageActivity(), e.bLC, getUniqueId(), arrayList);
        this.jIS.a(this.jIY);
        this.mAdapters.add(this.jIS);
        this.mAdapters.add(this.jIT);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bNT();
        this.mTopView = findViewById(R.id.view_top);
        this.mTopView.setOnClickListener(this.mOnClickListener);
        this.jIU = findViewById(R.id.layout_operate);
        this.jIU.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        al.l(this.jIU, R.color.cp_bg_line_d);
        al.k(this.hvS, R.drawable.btn_all_blue);
        al.f(this.hvS, R.color.cp_cont_g, 1);
        al.c(this.mBackImageView, (int) R.drawable.icon_pb_post_close_n);
        al.f(this.jIV, R.color.cp_cont_f, 1);
        al.f(this.jIW, R.color.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ev(List<TransmitForumData> list) {
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
            HotTopicBussinessData Cw = this.jIT.Cw(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (Cw != null) {
                for (m mVar : this.mDataList) {
                    if ((mVar instanceof TransmitForumData) && TextUtils.equals(Cw.mForumName, ((TransmitForumData) mVar).forumName)) {
                        return;
                    }
                }
                if (this.jIY.cxK()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Cw.mForumId, Cw.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Cw.mForumId, Cw.mForumName, true, 0));
                }
                bNT();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNT() {
        int Z = v.Z(cxN());
        if (Z > 0) {
            this.hvS.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(Z), 3));
        } else {
            this.hvS.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> cxN() {
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
    public void apu() {
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
        this.jIU.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jIT != null) {
            this.jIT.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        apu();
    }
}
