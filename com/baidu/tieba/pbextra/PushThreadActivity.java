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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes4.dex */
public class PushThreadActivity extends BaseActivity {
    private PushStatusData ccv;
    private GridView fld;
    private int ifG;
    private PushTypeData ifH;
    private TextView ifI;
    private ImageButton ifJ;
    private HttpMessageListener ifK = new HttpMessageListener(1001806) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(R.string.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.ifG == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        PushThreadActivity.this.setResult(-1, new Intent());
                    } else {
                        PushThreadActivity.this.showToast(R.string.neterror);
                    }
                    PushThreadActivity.this.finish();
                }
            }
        }
    };
    private List<PushTypeData> mPushTypeDatas;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        initData();
        initUI();
        this.ifK.setSelfListener(true);
        registerListener(this.ifK);
    }

    private void initData() {
        this.ccv = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.ccv != null) {
            this.mPushTypeDatas = this.ccv.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(R.layout.push_thread_layout);
        am.setBackgroundResource(findViewById(R.id.push_thread_container), R.drawable.dialog_background);
        am.setViewTextColor((TextView) findViewById(R.id.select_hint), (int) R.color.cp_cont_b);
        this.fld = (GridView) findViewById(R.id.gv_push);
        this.fld.setAdapter((ListAdapter) new a());
        this.fld.setOnItemClickListener(this);
        this.ifI = (TextView) findViewById(R.id.push_commit);
        am.setBackgroundResource(this.ifI, R.drawable.push_commit_selector);
        am.setViewTextColor(this.ifI, (int) R.color.cp_cont_a);
        this.ifI.setOnClickListener(this);
        this.ifJ = (ImageButton) findViewById(R.id.ib_close);
        am.setBackgroundResource(this.ifJ, R.drawable.push_close_selector);
        this.ifJ.setOnClickListener(this);
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
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public a() {
            PushThreadActivity.this.ifG = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return v.getCount(PushThreadActivity.this.mPushTypeDatas);
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
            PushTypeData pushTypeData = (PushTypeData) v.getItem(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.ifG) {
                    am.setImageResource(imageView, R.drawable.bg_choose_ok);
                    am.setViewTextColor(textView, (int) R.color.cp_other_b);
                } else {
                    am.setViewTextColor(textView, (int) R.color.cp_cont_b);
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
        this.ifI.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) v.getItem(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.ifG == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                am.setViewTextColor(textView, (int) R.color.cp_cont_b);
                this.ifG = -1;
                return;
            }
            if (this.ifH != null && (childAt = adapterView.getChildAt(v.getPosition(this.mPushTypeDatas, this.ifH))) != null) {
                ((ImageView) childAt.findViewById(R.id.iv_item_hint)).setImageDrawable(null);
                am.setViewTextColor((TextView) childAt.findViewById(R.id.tv_item_title), (int) R.color.cp_cont_b);
            }
            am.setImageResource(imageView, R.drawable.bg_choose_ok);
            am.setViewTextColor(textView, (int) R.color.cp_other_b);
            this.ifG = pushTypeData.getType();
            this.ifH = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ifI) {
            if (this.ifG == 0) {
                showToast(R.string.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.ifG, longExtra3));
        } else if (view == this.ifJ) {
            finish();
        }
    }
}
