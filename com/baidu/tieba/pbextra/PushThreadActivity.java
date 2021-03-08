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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes2.dex */
public class PushThreadActivity extends BaseActivity {
    private GridView dkY;
    private PushStatusData eTV;
    private List<PushTypeData> mPushTypeDatas;
    private int mrB;
    private PushTypeData mrC;
    private TextView mrD;
    private ImageButton mrE;
    private HttpMessageListener mrF = new HttpMessageListener(1001806) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(R.string.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.mrB == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
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
        this.mrF.setSelfListener(true);
        registerListener(this.mrF);
    }

    private void initData() {
        this.eTV = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.eTV != null) {
            this.mPushTypeDatas = this.eTV.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(R.layout.push_thread_layout);
        ap.setBackgroundResource(findViewById(R.id.push_thread_container), R.drawable.dialog_background);
        ap.setViewTextColor((TextView) findViewById(R.id.select_hint), R.color.CAM_X0105);
        this.dkY = (GridView) findViewById(R.id.gv_push);
        this.dkY.setAdapter((ListAdapter) new a());
        this.dkY.setOnItemClickListener(this);
        this.mrD = (TextView) findViewById(R.id.push_commit);
        ap.setBackgroundResource(this.mrD, R.drawable.push_commit_selector);
        ap.setViewTextColor(this.mrD, R.color.CAM_X0101);
        this.mrD.setOnClickListener(this);
        this.mrE = (ImageButton) findViewById(R.id.ib_close);
        ap.setBackgroundResource(this.mrE, R.drawable.push_close_selector);
        this.mrE.setOnClickListener(this);
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
            PushThreadActivity.this.mrB = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return y.getCount(PushThreadActivity.this.mPushTypeDatas);
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
            PushTypeData pushTypeData = (PushTypeData) y.getItem(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.mrB) {
                    ap.setImageResource(imageView, R.drawable.bg_choose_ok);
                    ap.setViewTextColor(textView, R.color.CAM_X0308);
                } else {
                    ap.setViewTextColor(textView, R.color.CAM_X0105);
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
        this.mrD.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) y.getItem(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.mrB == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                ap.setViewTextColor(textView, R.color.CAM_X0105);
                this.mrB = -1;
                return;
            }
            if (this.mrC != null && (childAt = adapterView.getChildAt(y.getPosition(this.mPushTypeDatas, this.mrC))) != null) {
                ((ImageView) childAt.findViewById(R.id.iv_item_hint)).setImageDrawable(null);
                ap.setViewTextColor((TextView) childAt.findViewById(R.id.tv_item_title), R.color.CAM_X0105);
            }
            ap.setImageResource(imageView, R.drawable.bg_choose_ok);
            ap.setViewTextColor(textView, R.color.CAM_X0308);
            this.mrB = pushTypeData.getType();
            this.mrC = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mrD) {
            if (this.mrB == 0) {
                showToast(R.string.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.mrB, longExtra3));
        } else if (view == this.mrE) {
            finish();
        }
    }
}
