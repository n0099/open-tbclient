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
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View cQo;
    private View eYa;
    private TextView fCm;
    private c hHh;
    private d hHi;
    private View hHj;
    private TextView hHk;
    private TextView hHl;
    private TextView hHm;
    private ImageView mBackImageView;
    private List<i> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.fCm.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eYa.getId() || view.getId() == TransmitForumActivity.this.cQo.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Jz();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bGZ = TransmitForumActivity.this.bGZ();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dR(bGZ));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Jz();
            }
        }
    };
    private a hHn = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bGW() {
            return v.D(TransmitForumActivity.this.bGZ()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGX() {
            TransmitForumActivity.this.showToast(d.j.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bGY() {
            TransmitForumActivity.this.aYV();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.transmit_forum_activity);
        this.eYa = findViewById(d.g.trasmit_back);
        this.eYa.setOnClickListener(this.mOnClickListener);
        this.fCm = (TextView) findViewById(d.g.transmit_cofirm);
        this.hHk = (TextView) findViewById(d.g.transmit_title);
        this.hHl = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.fCm.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.aq(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.hHm = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.D(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.hHm.setText(d.j.transmit_forum_publish_more_forum);
                    } else {
                        this.hHm.setText(d.j.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hHh = new c(getPageContext().getPageActivity(), TransmitForumData.aQN);
        this.hHi = new d(getPageContext().getPageActivity(), e.aQN, getUniqueId(), arrayList);
        this.hHh.a(this.hHn);
        this.mAdapters.add(this.hHh);
        this.mAdapters.add(this.hHi);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aYV();
        this.cQo = findViewById(d.g.view_top);
        this.cQo.setOnClickListener(this.mOnClickListener);
        this.hHj = findViewById(d.g.layout_operate);
        this.hHj.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        aj.t(this.hHj, d.C0140d.cp_bg_line_d);
        aj.s(this.fCm, d.f.btn_all_blue);
        aj.e(this.fCm, d.C0140d.cp_cont_g, 1);
        aj.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        aj.e(this.hHk, d.C0140d.cp_cont_f, 1);
        aj.e(this.hHl, d.C0140d.cp_cont_d, 1);
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
            HotTopicBussinessData xv = this.hHi.xv(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (xv != null) {
                for (i iVar : this.mDataList) {
                    if ((iVar instanceof TransmitForumData) && TextUtils.equals(xv.mForumName, ((TransmitForumData) iVar).forumName)) {
                        return;
                    }
                }
                if (this.hHn.bGW()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(xv.mForumId, xv.mForumName, false, 0));
                    showToast(d.j.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(xv.mForumId, xv.mForumName, true, 0));
                }
                aYV();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYV() {
        int D = v.D(bGZ());
        if (D > 0) {
            this.fCm.setText(getResources().getString(d.j.transmit_confirm, Integer.valueOf(D), 3));
        } else {
            this.fCm.setText(getResources().getString(d.j.confirm));
        }
    }

    public ArrayList<TransmitForumData> bGZ() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (i iVar : this.mDataList) {
            if (iVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) iVar;
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
    public void Jz() {
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
        this.hHj.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hHi != null) {
            this.hHi.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Jz();
    }
}
