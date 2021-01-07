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
/* loaded from: classes8.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View eKd;
    private BdTypeListView gAY;
    private View iPK;
    private TextView lyY;
    private ImageView mBackImageView;
    private List<n> mDataList;
    private TransmitForumAdapter oaY;
    private TransmitSelectAdapter oaZ;
    private View oba;
    private TextView obb;
    private TextView obc;
    private TextView obd;
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.lyY.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eKd.getId() || view.getId() == TransmitForumActivity.this.iPK.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.startExitAnimation();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> dYS = TransmitForumActivity.this.dYS();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.gj(dYS));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.startExitAnimation();
            }
        }
    };
    private a obe = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean dYP() {
            return x.getCount(TransmitForumActivity.this.dYS()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dYQ() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dYR() {
            TransmitForumActivity.this.dkF();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.eKd = findViewById(R.id.trasmit_back);
        this.eKd.setOnClickListener(this.mOnClickListener);
        this.lyY = (TextView) findViewById(R.id.transmit_cofirm);
        this.obb = (TextView) findViewById(R.id.transmit_title);
        this.obc = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.lyY.setOnClickListener(this.mOnClickListener);
        this.gAY = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.gAY.setMaxHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.gAY.setOverScrollMode(2);
        this.obd = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (x.getCount(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.obd.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.obd.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new c());
        this.oaY = new TransmitForumAdapter(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.oaZ = new TransmitSelectAdapter(getPageContext().getPageActivity(), c.ID_TRANSMIT_SELECT_DATA, getUniqueId(), arrayList);
        this.oaY.a(this.obe);
        this.boM.add(this.oaY);
        this.boM.add(this.oaZ);
        this.gAY.addAdapters(this.boM);
        this.gAY.setData(this.mDataList);
        dkF();
        this.iPK = findViewById(R.id.view_top);
        this.iPK.setOnClickListener(this.mOnClickListener);
        this.oba = findViewById(R.id.layout_operate);
        this.oba.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        ao.setBackgroundColor(this.oba, R.color.CAM_X0201);
        ao.setBackgroundResource(this.lyY, R.drawable.btn_all_blue);
        ao.setViewTextColor(this.lyY, R.color.CAM_X0111, 1);
        ao.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        ao.setViewTextColor(this.obb, R.color.CAM_X0106, 1);
        ao.setViewTextColor(this.obc, R.color.CAM_X0109, 1);
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
            HotTopicBussinessData MD = this.oaZ.MD(intent.getIntExtra("hot_topic_change_fourm", 0));
            if (MD != null) {
                for (n nVar : this.mDataList) {
                    if ((nVar instanceof TransmitForumData) && TextUtils.equals(MD.mForumName, ((TransmitForumData) nVar).forumName)) {
                        return;
                    }
                }
                if (this.obe.dYP()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(MD.mForumId, MD.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(MD.mForumId, MD.mForumName, true, 0));
                }
                dkF();
                this.gAY.setData(this.mDataList);
                this.gAY.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkF() {
        int count = x.getCount(dYS());
        if (count > 0) {
            this.lyY.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.lyY.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> dYS() {
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
        this.oba.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.oaZ != null) {
            this.oaZ.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }
}
