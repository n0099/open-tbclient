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
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes3.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    private View dJs;
    private BdTypeListView frv;
    private View hqx;
    private TextView kao;
    private ImageView mBackImageView;
    private List<q> mDataList;
    private c myg;
    private d myh;
    private View myi;
    private TextView myj;
    private TextView myk;
    private TextView myl;
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != TransmitForumActivity.this.kao.getId()) {
                    if (view.getId() == TransmitForumActivity.this.dJs.getId() || view.getId() == TransmitForumActivity.this.hqx.getId()) {
                        TransmitForumActivity.this.setResult(0);
                        TransmitForumActivity.this.startExitAnimation();
                        return;
                    }
                    return;
                }
                ArrayList<TransmitForumData> dvk = TransmitForumActivity.this.dvk();
                Intent intent = new Intent();
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.fr(dvk));
                TransmitForumActivity.this.setResult(-1, intent);
                TransmitForumActivity.this.startExitAnimation();
            }
        }
    };
    private a mym = new a() { // from class: com.baidu.tieba.write.transmit.TransmitForumActivity.2
        @Override // com.baidu.tieba.write.transmit.a
        public boolean dvh() {
            return x.getCount(TransmitForumActivity.this.dvk()) >= 3;
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dvi() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // com.baidu.tieba.write.transmit.a
        public void dvj() {
            TransmitForumActivity.this.cIw();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        this.dJs = findViewById(R.id.trasmit_back);
        this.dJs.setOnClickListener(this.mOnClickListener);
        this.kao = (TextView) findViewById(R.id.transmit_cofirm);
        this.myj = (TextView) findViewById(R.id.transmit_title);
        this.myk = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.kao.setOnClickListener(this.mOnClickListener);
        this.frv = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.frv.setMaxHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.frv.setOverScrollMode(2);
        this.myl = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        ArrayList arrayList = null;
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (x.getCount(parcelableArrayListExtra) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) parcelableArrayListExtra.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.myl.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.myl.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            arrayList = parcelableArrayListExtra;
        }
        this.mDataList.add(new e());
        this.myg = new c(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.myh = new d(getPageContext().getPageActivity(), e.ID_TRANSMIT_SELECT_DATA, getUniqueId(), arrayList);
        this.myg.a(this.mym);
        this.aWf.add(this.myg);
        this.aWf.add(this.myh);
        this.frv.addAdapters(this.aWf);
        this.frv.setData(this.mDataList);
        cIw();
        this.hqx = findViewById(R.id.view_top);
        this.hqx.setOnClickListener(this.mOnClickListener);
        this.myi = findViewById(R.id.layout_operate);
        this.myi.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        ao.setBackgroundColor(this.myi, R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.kao, R.drawable.btn_all_blue);
        ao.setViewTextColor(this.kao, R.color.cp_cont_g, 1);
        ao.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        ao.setViewTextColor(this.myj, R.color.cp_cont_f, 1);
        ao.setViewTextColor(this.myk, R.color.cp_cont_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fr(List<TransmitForumData> list) {
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
            HotTopicBussinessData Hi = this.myh.Hi(intent.getIntExtra("hot_topic_change_fourm", 0));
            if (Hi != null) {
                for (q qVar : this.mDataList) {
                    if ((qVar instanceof TransmitForumData) && TextUtils.equals(Hi.mForumName, ((TransmitForumData) qVar).forumName)) {
                        return;
                    }
                }
                if (this.mym.dvh()) {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Hi.mForumId, Hi.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    this.mDataList.add(this.mDataList.size() - 1, new TransmitForumData(Hi.mForumId, Hi.mForumName, true, 0));
                }
                cIw();
                this.frv.setData(this.mDataList);
                this.frv.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIw() {
        int count = x.getCount(dvk());
        if (count > 0) {
            this.kao.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.kao.setText(getResources().getString(R.string.confirm));
        }
    }

    public ArrayList<TransmitForumData> dvk() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (q qVar : this.mDataList) {
            if (qVar instanceof TransmitForumData) {
                TransmitForumData transmitForumData = (TransmitForumData) qVar;
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
        this.myi.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.myh != null) {
            this.myh.destroy();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }
}
