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
    private View gUZ;
    private TextView hvV;
    private c jIT;
    private d jIU;
    private View jIV;
    private TextView jIW;
    private TextView jIX;
    private TextView jIY;
    private ImageView mBackImageView;
    private List<m> mDataList;
    private BdTypeListView mListView;
    private View mTopView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.hvV.getId()) {
                    if (view.getId() == TransmitForumActivity.this.gUZ.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.apu();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> cxP = TransmitForumActivity.this.cxP();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.ev(cxP));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.apu();
            }
        }
    };
    private a jIZ = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean cxM() {
            return v.Z(TransmitForumActivity.this.cxP()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void cxN() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void cxO() {
            TransmitForumActivity.this.bNW();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.gUZ = findViewById(R.id.trasmit_back);
        this.gUZ.setOnClickListener(this.mOnClickListener);
        this.hvV = (TextView) findViewById(R.id.transmit_cofirm);
        this.jIW = (TextView) findViewById(R.id.transmit_title);
        this.jIX = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.hvV.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.mListView.setMaxHeight(l.ah(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.mListView.setOverScrollMode(2);
        this.jIY = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.Z(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.jIY.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.jIY.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.jIT = new c(getPageContext().getPageActivity(), TransmitForumData.bLC);
        this.jIU = new d(getPageContext().getPageActivity(), e.bLC, getUniqueId(), arrayList);
        this.jIT.a(this.jIZ);
        this.mAdapters.add(this.jIT);
        this.mAdapters.add(this.jIU);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        bNW();
        this.mTopView = findViewById(R.id.view_top);
        this.mTopView.setOnClickListener(this.mOnClickListener);
        this.jIV = findViewById(R.id.layout_operate);
        this.jIV.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        al.l(this.jIV, R.color.cp_bg_line_d);
        al.k(this.hvV, R.drawable.btn_all_blue);
        al.f(this.hvV, R.color.cp_cont_g, 1);
        al.c(this.mBackImageView, (int) R.drawable.icon_pb_post_close_n);
        al.f(this.jIW, R.color.cp_cont_f, 1);
        al.f(this.jIX, R.color.cp_cont_d, 1);
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
            HotTopicBussinessData Cw = this.jIU.Cw(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (Cw != null) {
                for (m mVar : this.mDataList) {
                    if ((mVar instanceof TransmitForumData) && TextUtils.equals(Cw.mForumName, ((TransmitForumData) mVar).forumName)) {
                        return;
                    }
                }
                if (this.jIZ.cxM()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Cw.mForumId, Cw.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Cw.mForumId, Cw.mForumName, true, 0));
                }
                bNW();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNW() {
        int Z = v.Z(cxP());
        if (Z > 0) {
            this.hvV.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(Z), 3));
        } else {
            this.hvV.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> cxP() {
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
        this.jIV.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jIU != null) {
            this.jIU.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        apu();
    }
}
