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
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View eFs;
    private BdTypeListView gwr;
    private View iLd;
    private TextView lus;
    private ImageView mBackImageView;
    private List<n> mDataList;
    private TransmitForumAdapter nWt;
    private TransmitSelectAdapter nWu;
    private View nWv;
    private TextView nWw;
    private TextView nWx;
    private TextView nWy;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.lus.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eFs.getId() || view.getId() == TransmitForumActivity.this.iLd.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.startExitAnimation();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> dVa = TransmitForumActivity.this.dVa();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.gj(dVa));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.startExitAnimation();
            }
        }
    };
    private a nWz = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean dUX() {
            return x.getCount(TransmitForumActivity.this.dVa()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dUY() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dUZ() {
            TransmitForumActivity.this.dgN();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.eFs = findViewById(R.id.trasmit_back);
        this.eFs.setOnClickListener(this.mOnClickListener);
        this.lus = (TextView) findViewById(R.id.transmit_cofirm);
        this.nWw = (TextView) findViewById(R.id.transmit_title);
        this.nWx = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.lus.setOnClickListener(this.mOnClickListener);
        this.gwr = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.gwr.setMaxHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.gwr.setOverScrollMode(2);
        this.nWy = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (x.getCount(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.nWy.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.nWy.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new c());
        this.nWt = new TransmitForumAdapter(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.nWu = new TransmitSelectAdapter(getPageContext().getPageActivity(), c.ID_TRANSMIT_SELECT_DATA, getUniqueId(), arrayList);
        this.nWt.a(this.nWz);
        this.bjZ.add(this.nWt);
        this.bjZ.add(this.nWu);
        this.gwr.addAdapters(this.bjZ);
        this.gwr.setData(this.mDataList);
        dgN();
        this.iLd = findViewById(R.id.view_top);
        this.iLd.setOnClickListener(this.mOnClickListener);
        this.nWv = findViewById(R.id.layout_operate);
        this.nWv.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        ao.setBackgroundColor(this.nWv, R.color.CAM_X0201);
        ao.setBackgroundResource(this.lus, R.drawable.btn_all_blue);
        ao.setViewTextColor(this.lus, R.color.CAM_X0111, 1);
        ao.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        ao.setViewTextColor(this.nWw, R.color.CAM_X0106, 1);
        ao.setViewTextColor(this.nWx, R.color.CAM_X0109, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gj(List<TransmitForumData> list) {
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
            HotTopicBussinessData KW = this.nWu.KW(intent.getIntExtra("hot_topic_change_fourm", 0));
            if (KW != null) {
                for (n nVar : this.mDataList) {
                    if ((nVar instanceof TransmitForumData) && TextUtils.equals(KW.mForumName, ((TransmitForumData) nVar).forumName)) {
                        return;
                    }
                }
                if (this.nWz.dUX()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(KW.mForumId, KW.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(KW.mForumId, KW.mForumName, true, 0));
                }
                dgN();
                this.gwr.setData(this.mDataList);
                this.gwr.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgN() {
        int count = x.getCount(dVa());
        if (count > 0) {
            this.lus.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.lus.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> dVa() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (n nVar : this.mDataList) {
            if (nVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) nVar;
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
    public void startExitAnimation() {
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
        this.nWv.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nWu != null) {
            this.nWu.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }
}
