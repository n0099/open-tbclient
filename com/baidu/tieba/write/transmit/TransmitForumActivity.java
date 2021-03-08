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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View eIZ;
    private BdTypeListView gAY;
    private View iSI;
    private TextView lEM;
    private ImageView mBackImageView;
    private List<n> mDataList;
    private TransmitForumAdapter ojf;
    private TransmitSelectAdapter ojg;
    private View ojh;
    private TextView oji;
    private TextView ojj;
    private TextView ojk;
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.lEM.getId()) {
                    if (view.getId() == TransmitForumActivity.this.eIZ.getId() || view.getId() == TransmitForumActivity.this.iSI.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.startExitAnimation();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> dXE = TransmitForumActivity.this.dXE();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.gh(dXE));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.startExitAnimation();
            }
        }
    };
    private a ojl = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean dXB() {
            return y.getCount(TransmitForumActivity.this.dXE()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dXC() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dXD() {
            TransmitForumActivity.this.dje();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.eIZ = findViewById(R.id.trasmit_back);
        this.eIZ.setOnClickListener(this.mOnClickListener);
        this.lEM = (TextView) findViewById(R.id.transmit_cofirm);
        this.oji = (TextView) findViewById(R.id.transmit_title);
        this.ojj = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.lEM.setOnClickListener(this.mOnClickListener);
        this.gAY = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.gAY.setMaxHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.gAY.setOverScrollMode(2);
        this.ojk = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (y.getCount(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.ojk.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.ojk.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new c());
        this.ojf = new TransmitForumAdapter(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.ojg = new TransmitSelectAdapter(getPageContext().getPageActivity(), c.ID_TRANSMIT_SELECT_DATA, getUniqueId(), arrayList);
        this.ojf.a(this.ojl);
        this.boS.add(this.ojf);
        this.boS.add(this.ojg);
        this.gAY.addAdapters(this.boS);
        this.gAY.setData(this.mDataList);
        dje();
        this.iSI = findViewById(R.id.view_top);
        this.iSI.setOnClickListener(this.mOnClickListener);
        this.ojh = findViewById(R.id.layout_operate);
        this.ojh.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        ap.setBackgroundColor(this.ojh, R.color.CAM_X0201);
        ap.setBackgroundResource(this.lEM, R.drawable.btn_all_blue);
        ap.setViewTextColor(this.lEM, R.color.CAM_X0111, 1);
        ap.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        ap.setViewTextColor(this.oji, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.ojj, R.color.CAM_X0109, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gh(List<TransmitForumData> list) {
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
            HotTopicBussinessData Lw = this.ojg.Lw(intent.getIntExtra("hot_topic_change_fourm", 0));
            if (Lw != null) {
                for (n nVar : this.mDataList) {
                    if ((nVar instanceof TransmitForumData) && TextUtils.equals(Lw.mForumName, ((TransmitForumData) nVar).forumName)) {
                        return;
                    }
                }
                if (this.ojl.dXB()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Lw.mForumId, Lw.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Lw.mForumId, Lw.mForumName, true, 0));
                }
                dje();
                this.gAY.setData(this.mDataList);
                this.gAY.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dje() {
        int count = y.getCount(dXE());
        if (count > 0) {
            this.lEM.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.lEM.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> dXE() {
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
        this.ojh.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ojg != null) {
            this.ojg.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }
}
