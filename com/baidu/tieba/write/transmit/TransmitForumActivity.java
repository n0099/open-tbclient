package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    public static final int MAX_FORUM_NUM = 3;
    public ImageView mBackImageView;
    public View mBackView;
    public List<n> mDataList;
    public TransmitForumAdapter mForumAdapter;
    public View mLayoutOperate;
    public BdTypeListView mListView;
    public TransmitSelectAdapter mSelectAdapter;
    public View mTopView;
    public TextView mTransmitConfirmButton;
    public TextView mTransmitSubTitle;
    public TextView mTransmitTipsView;
    public TextView mTransmitTitle;
    public List<d.b.b.j.e.a> mAdapters = new ArrayList();
    public View.OnClickListener mOnClickListener = new a();
    public d.b.i0.u3.r.a mTransmitForumCallback = new b();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            if (view.getId() != TransmitForumActivity.this.mTransmitConfirmButton.getId()) {
                if (view.getId() == TransmitForumActivity.this.mBackView.getId() || view.getId() == TransmitForumActivity.this.mTopView.getId()) {
                    TransmitForumActivity.this.setResult(0);
                    TransmitForumActivity.this.startExitAnimation();
                    return;
                }
                return;
            }
            ArrayList<TransmitForumData> selectedList = TransmitForumActivity.this.getSelectedList();
            Intent intent = new Intent();
            intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, TransmitForumActivity.this.generateSelectResult(selectedList));
            TransmitForumActivity.this.setResult(-1, intent);
            TransmitForumActivity.this.startExitAnimation();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b.i0.u3.r.a {
        public b() {
        }

        @Override // d.b.i0.u3.r.a
        public void a() {
            TransmitForumActivity.this.showToast(R.string.transmit_max_commit);
        }

        @Override // d.b.i0.u3.r.a
        public boolean b() {
            return ListUtils.getCount(TransmitForumActivity.this.getSelectedList()) >= 3;
        }

        @Override // d.b.i0.u3.r.a
        public void c() {
            TransmitForumActivity.this.setTransmitConfirmButtonText();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TransmitForumActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateSelectResult(List<TransmitForumData> list) {
        JSONArray jSONArray = new JSONArray();
        for (TransmitForumData transmitForumData : list) {
            if (transmitForumData != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(String.valueOf(transmitForumData.forumId), transmitForumData.type);
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransmitConfirmButtonText() {
        int count = ListUtils.getCount(getSelectedList());
        if (count > 0) {
            this.mTransmitConfirmButton.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
        } else {
            this.mTransmitConfirmButton.setText(getResources().getString(R.string.confirm));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExitAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.out_to_bottom);
        loadAnimation.setAnimationListener(new c());
        this.mLayoutOperate.startAnimation(loadAnimation);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    public ArrayList<TransmitForumData> getSelectedList() {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25005) {
            HotTopicBussinessData s0 = this.mSelectAdapter.s0(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            if (s0 == null) {
                return;
            }
            for (n nVar : this.mDataList) {
                if ((nVar instanceof TransmitForumData) && TextUtils.equals(s0.mForumName, ((TransmitForumData) nVar).forumName)) {
                    return;
                }
            }
            if (this.mTransmitForumCallback.b()) {
                List<n> list = this.mDataList;
                list.add(list.size() - 1, new TransmitForumData(s0.mForumId, s0.mForumName, false, 0));
                showToast(R.string.transmit_max_commit);
            } else {
                List<n> list2 = this.mDataList;
                list2.add(list2.size() - 1, new TransmitForumData(s0.mForumId, s0.mForumName, true, 0));
            }
            setTransmitConfirmButtonText();
            this.mListView.setData(this.mDataList);
            this.mListView.setSelection(this.mDataList.size() - 1);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        startExitAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ArrayList arrayList;
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.transmit_forum_activity);
        View findViewById = findViewById(R.id.trasmit_back);
        this.mBackView = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        this.mTransmitConfirmButton = (TextView) findViewById(R.id.transmit_cofirm);
        this.mTransmitTitle = (TextView) findViewById(R.id.transmit_title);
        this.mTransmitSubTitle = (TextView) findViewById(R.id.transmit_subtitle);
        this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
        this.mTransmitConfirmButton.setOnClickListener(this.mOnClickListener);
        this.mListView = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
        this.mListView.setMaxHeight(l.i(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
        this.mListView.setOverScrollMode(2);
        this.mTransmitTipsView = (TextView) findViewById(R.id.transmit_subtitle);
        this.mDataList = new ArrayList();
        if (getIntent() != null) {
            arrayList = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
            if (ListUtils.getCount(arrayList) > 0) {
                TransmitForumData transmitForumData = (TransmitForumData) arrayList.get(0);
                if (transmitForumData != null) {
                    if (transmitForumData.checked) {
                        this.mTransmitTipsView.setText(R.string.transmit_forum_publish_more_forum);
                    } else {
                        this.mTransmitTipsView.setText(R.string.transmit_forum_select_more_forum);
                    }
                }
                this.mDataList.addAll(arrayList);
            }
        } else {
            arrayList = null;
        }
        this.mDataList.add(new d.b.i0.u3.r.c());
        this.mForumAdapter = new TransmitForumAdapter(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
        this.mSelectAdapter = new TransmitSelectAdapter(getPageContext().getPageActivity(), d.b.i0.u3.r.c.f61689e, getUniqueId(), arrayList);
        this.mForumAdapter.l0(this.mTransmitForumCallback);
        this.mAdapters.add(this.mForumAdapter);
        this.mAdapters.add(this.mSelectAdapter);
        this.mListView.a(this.mAdapters);
        this.mListView.setData(this.mDataList);
        setTransmitConfirmButtonText();
        View findViewById2 = findViewById(R.id.view_top);
        this.mTopView = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        View findViewById3 = findViewById(R.id.layout_operate);
        this.mLayoutOperate = findViewById3;
        findViewById3.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
        SkinManager.setBackgroundColor(this.mLayoutOperate, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.mTransmitConfirmButton, R.drawable.btn_all_blue);
        SkinManager.setViewTextColor(this.mTransmitConfirmButton, R.color.CAM_X0111, 1);
        SkinManager.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
        SkinManager.setViewTextColor(this.mTransmitTitle, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.mTransmitSubTitle, R.color.CAM_X0109, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TransmitSelectAdapter transmitSelectAdapter = this.mSelectAdapter;
        if (transmitSelectAdapter != null) {
            transmitSelectAdapter.r0();
        }
    }
}
