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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View cgp;
    private TextView eXa;
    private View esJ;
    private c hdW;
    private d hdX;
    private View hdY;
    private TextView hdZ;
    private TextView hea;
    private TextView heb;
    private ImageView mBackImageView;
    private List<h> mDataList;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null) {
                if (view2.getId() != TransmitForumActivity.this.eXa.getId()) {
                    if (view2.getId() == TransmitForumActivity.this.esJ.getId() || view2.getId() == TransmitForumActivity.this.cgp.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.Cf();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> bCp = TransmitForumActivity.this.bCp();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.dI(bCp));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.Cf();
            }
        }
    };
    private a hec = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean bCm() {
            return v.v(TransmitForumActivity.this.bCp()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bCn() {
            TransmitForumActivity.this.showToast(d.k.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void bCo() {
            TransmitForumActivity.this.aTQ();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.i.transmit_forum_activity);
        this.esJ = findViewById(d.g.trasmit_back);
        this.esJ.setOnClickListener(this.mOnClickListener);
        this.eXa = (TextView) findViewById(d.g.transmit_cofirm);
        this.hdZ = (TextView) findViewById(d.g.transmit_title);
        this.hea = (TextView) findViewById(d.g.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(d.g.trasmit_back);
        this.eXa.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(d.g.trasmit_grid_view);
        this.mListView.setMaxHeight(l.ah(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(d.e.ds568));
        this.mListView.setOverScrollMode(2);
        this.heb = (TextView) findViewById(d.g.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.v(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.heb.setText(d.k.transmit_forum_publish_more_forum);
                    } else {
                        this.heb.setText(d.k.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.hdW = new c(getPageContext().getPageActivity(), TransmitForumData.ace);
        this.hdX = new d(getPageContext().getPageActivity(), e.ace, getUniqueId(), arrayList);
        this.hdW.a(this.hec);
        this.mAdapters.add(this.hdW);
        this.mAdapters.add(this.hdX);
        this.mListView.addAdapters(this.mAdapters);
        this.mListView.setData(this.mDataList);
        aTQ();
        this.cgp = findViewById(d.g.view_top);
        this.cgp.setOnClickListener(this.mOnClickListener);
        this.hdY = findViewById(d.g.layout_operate);
        this.hdY.startAnimation(AnimationUtils.loadAnimation(getActivity(), d.a.in_from_bottom));
        ak.j(this.hdY, d.C0126d.cp_bg_line_d);
        ak.i(this.eXa, d.f.btn_all_blue);
        ak.c(this.eXa, d.C0126d.cp_cont_g, 1);
        ak.c(this.mBackImageView, d.f.icon_pb_post_close_n);
        ak.c(this.hdZ, d.C0126d.cp_cont_f, 1);
        ak.c(this.hea, d.C0126d.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dI(List<TransmitForumData> list) {
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
            HotTopicBussinessData va = this.hdX.va(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (va != null) {
                for (h hVar : this.mDataList) {
                    if ((hVar instanceof TransmitForumData) && TextUtils.equals(va.mForumName, ((TransmitForumData) hVar).forumName)) {
                        return;
                    }
                }
                if (this.hec.bCm()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(va.mForumId, va.mForumName, false, 0));
                    showToast(d.k.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(va.mForumId, va.mForumName, true, 0));
                }
                aTQ();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTQ() {
        int v = v.v(bCp());
        if (v > 0) {
            this.eXa.setText(getResources().getString(d.k.transmit_confirm, Integer.valueOf(v), 3));
        } else {
            this.eXa.setText(getResources().getString(d.k.confirm));
        }
    }

    public ArrayList<TransmitForumData> bCp() {
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
    public void Cf() {
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
        this.hdY.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hdX != null) {
            this.hdX.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        Cf();
    }
}
