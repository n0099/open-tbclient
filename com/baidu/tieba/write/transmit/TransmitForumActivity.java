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
    private View eUf;
    private TextView fuX;
    private c hEG;
    private d hEH;
    private View hEI;
    private TextView hEJ;
    private TextView hEK;
    private TextView hEL;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private View mTopView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fuX.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eUf.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Hk();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bJz = TransmitForumActivity.this.bJz();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dR(bJz));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Hk();
            }
        }
    };
    private a hEM = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bJw() {
            return v.y(TransmitForumActivity.this.bJz()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bJx() {
            TransmitForumActivity.this.showToast(e.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bJy() {
            TransmitForumActivity.this.aZW();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(e.h.transmit_forum_activity);
        this.eUf = findViewById(e.g.trasmit_back);
        this.eUf.setOnClickListener(this.mOnClickListener);
        this.fuX = (TextView) findViewById(e.g.transmit_cofirm);
        this.hEJ = (TextView) findViewById(e.g.transmit_title);
        this.hEK = (TextView) findViewById(e.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(e.g.trasmit_back);
        this.fuX.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(e.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aQ(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(e.C0141e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hEL = (TextView) findViewById(e.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.y(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hEL.setText(e.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hEL.setText(e.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hEG = new c(getPageContext().getPageActivity(), TransmitForumData.amN);
        this.hEH = new d(getPageContext().getPageActivity(), e.amN, getUniqueId(), arrayList);
        this.hEG.a(this.hEM);
        this.mAdapters.add(this.hEG);
        this.mAdapters.add(this.hEH);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aZW();
        this.mTopView = findViewById(e.g.view_top);
        this.mTopView.setOnClickListener(this.mOnClickListener);
        this.hEI = findViewById(e.g.layout_operate);
        this.hEI.startAnimation(AnimationUtils.loadAnimation(getActivity(), e.a.in_from_bottom));
        al.j(this.hEI, e.d.cp_bg_line_d);
        al.i(this.fuX, e.f.btn_all_blue);
        al.c(this.fuX, e.d.cp_cont_g, 1);
        al.c(this.mBackImageView, e.f.icon_pb_post_close_n);
        al.c(this.hEJ, e.d.cp_cont_f, 1);
        al.c(this.hEK, e.d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dR(List<TransmitForumData> list) {
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
            HotTopicBussinessData vZ = this.hEH.vZ(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (vZ != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(vZ.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hEM.bJw()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vZ.mForumId, vZ.mForumName, false, 0));
                    showToast(e.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vZ.mForumId, vZ.mForumName, true, 0));
                }
                aZW();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZW() {
        int y = v.y(bJz());
        if (y > 0) {
            this.fuX.setText(getResources().getString(e.j.transmit_confirm, Integer.valueOf(y), 3));
        } else {
            this.fuX.setText(getResources().getString(e.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bJz() {
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
    public void Hk() {
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
        this.hEI.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hEH != null) {
            this.hEH.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Hk();
    }
}
