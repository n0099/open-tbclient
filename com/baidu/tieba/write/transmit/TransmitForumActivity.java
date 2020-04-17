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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View cDX;
    private View dkl;
    private BdTypeListView eOe;
    private TextView jij;
    private c lBf;
    private d lBg;
    private View lBh;
    private TextView lBi;
    private TextView lBj;
    private TextView lBk;
    private ImageView mBackImageView;
    private List<m> mDataList;
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.jij.getId()) {
                    if (view.getId() == TransmitForumActivity.this.dkl.getId() || view.getId() == TransmitForumActivity.this.cDX.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.startExitAnimation();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> dgc = TransmitForumActivity.this.dgc();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.eM(dgc));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.startExitAnimation();
            }
        }
    };
    private a lBl = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean dfZ() {
            return v.getCount(TransmitForumActivity.this.dgc()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dga() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dgb() {
            TransmitForumActivity.this.ctF();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.dkl = findViewById(R.id.trasmit_back);
        this.dkl.setOnClickListener(this.mOnClickListener);
        this.jij = (TextView) findViewById(R.id.transmit_cofirm);
        this.lBi = (TextView) findViewById(R.id.transmit_title);
        this.lBj = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.jij.setOnClickListener(this.mOnClickListener);
        this.eOe = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.eOe.setMaxHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.eOe.setOverScrollMode(2);
        this.lBk = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (v.getCount(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.lBk.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.lBk.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.lBf = new c(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.lBg = new d(getPageContext().getPageActivity(), e.ID_TRANSMIT_SELECT_DATA, getUniqueId(), arrayList);
        this.lBf.a(this.lBl);
        this.aMd.add(this.lBf);
        this.aMd.add(this.lBg);
        this.eOe.addAdapters(this.aMd);
        this.eOe.setData(this.mDataList);
        ctF();
        this.cDX = findViewById(R.id.view_top);
        this.cDX.setOnClickListener(this.mOnClickListener);
        this.lBh = findViewById(R.id.layout_operate);
        this.lBh.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        am.setBackgroundColor(this.lBh, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jij, R.drawable.btn_all_blue);
        am.setViewTextColor(this.jij, R.color.cp_cont_g, 1);
        am.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        am.setViewTextColor(this.lBi, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.lBj, R.color.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String eM(List<TransmitForumData> list) {
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
            HotTopicBussinessData ET = this.lBg.ET(intent.getIntExtra("hot_topic_change_fourm", 0));
            if (ET != null) {
                for (m mVar : this.mDataList) {
                    if ((mVar instanceof TransmitForumData) && TextUtils.equals(ET.mForumName, ((TransmitForumData) mVar).forumName)) {
                        return;
                    }
                }
                if (this.lBl.dfZ()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(ET.mForumId, ET.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(ET.mForumId, ET.mForumName, true, 0));
                }
                ctF();
                this.eOe.setData(this.mDataList);
                this.eOe.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctF() {
        int count = v.getCount(dgc());
        if (count > 0) {
            this.jij.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.jij.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> dgc() {
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
        this.lBh.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lBg != null) {
            this.lBg.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }
}
