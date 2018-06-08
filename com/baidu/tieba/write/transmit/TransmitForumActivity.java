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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View cpn;
    private View eFf;
    private TextView fjz;
    private c hqS;
    private d hqT;
    private View hqU;
    private TextView hqV;
    private TextView hqW;
    private TextView hqX;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fjz.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eFf.getId() || view.getId() == TransmitForumActivity.this.cpn.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.FG();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bHs = TransmitForumActivity.this.bHs();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dR(bHs));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.FG();
            }
        }
    };
    private a hqY = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bHp() {
            return w.y(TransmitForumActivity.this.bHs()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bHq() {
            TransmitForumActivity.this.showToast(d.k.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bHr() {
            TransmitForumActivity.this.aYM();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.i.transmit_forum_activity);
        this.eFf = findViewById(d.g.trasmit_back);
        this.eFf.setOnClickListener(this.mOnClickListener);
        this.fjz = (TextView) findViewById(d.g.transmit_cofirm);
        this.hqV = (TextView) findViewById(d.g.transmit_title);
        this.hqW = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.fjz.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aj(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hqX = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (w.y(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hqX.setText(d.k.transmit_forum_publish_more_forum);
                    } else {
                        this.hqX.setText(d.k.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hqS = new c(getPageContext().getPageActivity(), TransmitForumData.akj);
        this.hqT = new d(getPageContext().getPageActivity(), e.akj, getUniqueId(), arrayList);
        this.hqS.a(this.hqY);
        this.mAdapters.add(this.hqS);
        this.mAdapters.add(this.hqT);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aYM();
        this.cpn = findViewById(d.g.view_top);
        this.cpn.setOnClickListener(this.mOnClickListener);
        this.hqU = findViewById(d.g.layout_operate);
        this.hqU.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        al.j(this.hqU, d.C0141d.cp_bg_line_d);
        al.i(this.fjz, d.f.btn_all_blue);
        al.c(this.fjz, d.C0141d.cp_cont_g, 1);
        al.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        al.c(this.hqV, d.C0141d.cp_cont_f, 1);
        al.c(this.hqW, d.C0141d.cp_cont_d, 1);
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
            HotTopicBussinessData vr = this.hqT.vr(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (vr != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(vr.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hqY.bHp()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vr.mForumId, vr.mForumName, false, 0));
                    showToast(d.k.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(vr.mForumId, vr.mForumName, true, 0));
                }
                aYM();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYM() {
        int y = w.y(bHs());
        if (y > 0) {
            this.fjz.setText(getResources().getString(d.k.transmit_confirm, Integer.valueOf(y), 3));
        } else {
            this.fjz.setText(getResources().getString(d.k.confirm));
        }
    }

    public ArrayList<TransmitForumData> bHs() {
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
    public void FG() {
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
        this.hqU.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hqT != null) {
            this.hqT.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        FG();
    }
}
