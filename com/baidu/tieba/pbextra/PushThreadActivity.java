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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes2.dex */
public class PushThreadActivity extends BaseActivity {
    private GridView dhj;
    private PushStatusData eQi;
    private List<PushTypeData> mPushTypeDatas;
    private int mgh;
    private PushTypeData mgi;
    private TextView mgj;
    private ImageButton mgk;
    private HttpMessageListener mgl = new HttpMessageListener(1001806) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(R.string.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.mgh == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        PushThreadActivity.this.setResult(-1, new Intent());
                    } else {
                        PushThreadActivity.this.showToast(R.string.neterror);
                    }
                    PushThreadActivity.this.finish();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        initData();
        initUI();
        this.mgl.setSelfListener(true);
        registerListener(this.mgl);
    }

    private void initData() {
        this.eQi = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.eQi != null) {
            this.mPushTypeDatas = this.eQi.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(R.layout.push_thread_layout);
        ao.setBackgroundResource(findViewById(R.id.push_thread_container), R.drawable.dialog_background);
        ao.setViewTextColor((TextView) findViewById(R.id.select_hint), R.color.CAM_X0105);
        this.dhj = (GridView) findViewById(R.id.gv_push);
        this.dhj.setAdapter((ListAdapter) new a());
        this.dhj.setOnItemClickListener(this);
        this.mgj = (TextView) findViewById(R.id.push_commit);
        ao.setBackgroundResource(this.mgj, R.drawable.push_commit_selector);
        ao.setViewTextColor(this.mgj, R.color.CAM_X0101);
        this.mgj.setOnClickListener(this);
        this.mgk = (ImageButton) findViewById(R.id.ib_close);
        ao.setBackgroundResource(this.mgk, R.drawable.push_close_selector);
        this.mgk.setOnClickListener(this);
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
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        public a() {
            PushThreadActivity.this.mgh = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return x.getCount(PushThreadActivity.this.mPushTypeDatas);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(PushThreadActivity.this.getPageContext().getPageActivity()).inflate(R.layout.push_thread_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_item_icon);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_item_hint);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_item_title);
            PushTypeData pushTypeData = (PushTypeData) x.getItem(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.mgh) {
                    ao.setImageResource(imageView, R.drawable.bg_choose_ok);
                    ao.setViewTextColor(textView, R.color.CAM_X0308);
                } else {
                    ao.setViewTextColor(textView, R.color.CAM_X0105);
                    imageView.setImageDrawable(null);
                }
            }
            return inflate;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        View childAt;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_hint);
        TextView textView = (TextView) view.findViewById(R.id.tv_item_title);
        this.mgj.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) x.getItem(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.mgh == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                ao.setViewTextColor(textView, R.color.CAM_X0105);
                this.mgh = -1;
                return;
            }
            if (this.mgi != null && (childAt = adapterView.getChildAt(x.getPosition(this.mPushTypeDatas, this.mgi))) != null) {
                ((ImageView) childAt.findViewById(R.id.iv_item_hint)).setImageDrawable(null);
                ao.setViewTextColor((TextView) childAt.findViewById(R.id.tv_item_title), R.color.CAM_X0105);
            }
            ao.setImageResource(imageView, R.drawable.bg_choose_ok);
            ao.setViewTextColor(textView, R.color.CAM_X0308);
            this.mgh = pushTypeData.getType();
            this.mgi = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mgj) {
            if (this.mgh == 0) {
                showToast(R.string.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.mgh, longExtra3));
        } else if (view == this.mgk) {
            finish();
        }
    }
}
