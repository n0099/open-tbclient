package com.baidu.tieba.pbextra;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.PushStatusData;
import com.baidu.tbadk.core.data.PushTypeData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes5.dex */
public class PushThreadActivity extends BaseActivity {
    public int mCurrentPushType;
    public GridView mGridView;
    public ImageButton mIbClose;
    public PushTypeData mPreSelectData;
    public TextView mPushCommit;
    public PushStatusData mPushStatusData;
    public HttpMessageListener mPushThreadMessageListener = new a(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD);
    public List<PushTypeData> mPushTypeDatas;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z = httpResponsedMessage instanceof PbPushHttpResponseMessage;
            if (z) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(R.string.neterror);
                } else if (z) {
                    if (PushThreadActivity.this.mCurrentPushType == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        PushThreadActivity.this.setResult(-1, new Intent());
                    } else {
                        PushThreadActivity.this.showToast(R.string.neterror);
                    }
                    PushThreadActivity.this.finish();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BaseAdapter {
        public b() {
            PushThreadActivity.this.mCurrentPushType = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ListUtils.getCount(PushThreadActivity.this.mPushTypeDatas);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(PushThreadActivity.this.getPageContext().getPageActivity()).inflate(R.layout.push_thread_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_item_icon);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_item_hint);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_item_title);
            PushTypeData pushTypeData = (PushTypeData) ListUtils.getItem(PushThreadActivity.this.mPushTypeDatas, i2);
            if (pushTypeData != null) {
                tbImageView.V(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.mCurrentPushType) {
                    SkinManager.setImageResource(imageView, R.drawable.bg_choose_ok);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0308);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                    imageView.setImageDrawable(null);
                }
            }
            return inflate;
        }
    }

    private void initData() {
        PushStatusData pushStatusData = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        this.mPushStatusData = pushStatusData;
        if (pushStatusData != null) {
            this.mPushTypeDatas = pushStatusData.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(R.layout.push_thread_layout);
        SkinManager.setBackgroundResource(findViewById(R.id.push_thread_container), R.drawable.dialog_background);
        SkinManager.setViewTextColor((TextView) findViewById(R.id.select_hint), R.color.CAM_X0105);
        this.mGridView = (GridView) findViewById(R.id.gv_push);
        this.mGridView.setAdapter((ListAdapter) new b());
        this.mGridView.setOnItemClickListener(this);
        TextView textView = (TextView) findViewById(R.id.push_commit);
        this.mPushCommit = textView;
        SkinManager.setBackgroundResource(textView, R.drawable.push_commit_selector);
        SkinManager.setViewTextColor(this.mPushCommit, R.color.CAM_X0101);
        this.mPushCommit.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) findViewById(R.id.ib_close);
        this.mIbClose = imageButton;
        SkinManager.setBackgroundResource(imageButton, R.drawable.push_close_selector);
        this.mIbClose.setOnClickListener(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mPushCommit) {
            if (this.mCurrentPushType == 0) {
                showToast(R.string.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.mCurrentPushType, longExtra3));
        } else if (view == this.mIbClose) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        initData();
        initUI();
        this.mPushThreadMessageListener.setSelfListener(true);
        registerListener(this.mPushThreadMessageListener);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        View childAt;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_hint);
        TextView textView = (TextView) view.findViewById(R.id.tv_item_title);
        this.mPushCommit.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) ListUtils.getItem(this.mPushTypeDatas, i2);
        if (pushTypeData != null) {
            if (this.mCurrentPushType == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                this.mCurrentPushType = -1;
                return;
            }
            PushTypeData pushTypeData2 = this.mPreSelectData;
            if (pushTypeData2 != null && (childAt = adapterView.getChildAt(ListUtils.getPosition(this.mPushTypeDatas, pushTypeData2))) != null) {
                ((ImageView) childAt.findViewById(R.id.iv_item_hint)).setImageDrawable(null);
                SkinManager.setViewTextColor((TextView) childAt.findViewById(R.id.tv_item_title), R.color.CAM_X0105);
            }
            SkinManager.setImageResource(imageView, R.drawable.bg_choose_ok);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0308);
            this.mCurrentPushType = pushTypeData.getType();
            this.mPreSelectData = pushTypeData;
        }
    }
}
