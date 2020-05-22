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
/* loaded from: classes9.dex */
public class PushThreadActivity extends BaseActivity {
    private GridView ckE;
    private PushStatusData dGE;
    private int kgJ;
    private PushTypeData kgK;
    private TextView kgL;
    private ImageButton kgM;
    private HttpMessageListener kgN = new HttpMessageListener(1001806) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(R.string.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.kgJ == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
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
        this.kgN.setSelfListener(true);
        registerListener(this.kgN);
    }

    private void initData() {
        this.dGE = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.dGE != null) {
            this.mPushTypeDatas = this.dGE.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(R.layout.push_thread_layout);
        am.setBackgroundResource(findViewById(R.id.push_thread_container), R.drawable.dialog_background);
        am.setViewTextColor((TextView) findViewById(R.id.select_hint), (int) R.color.cp_cont_b);
        this.ckE = (GridView) findViewById(R.id.gv_push);
        this.ckE.setAdapter((ListAdapter) new a());
        this.ckE.setOnItemClickListener(this);
        this.kgL = (TextView) findViewById(R.id.push_commit);
        am.setBackgroundResource(this.kgL, R.drawable.push_commit_selector);
        am.setViewTextColor(this.kgL, (int) R.color.cp_cont_a);
        this.kgL.setOnClickListener(this);
        this.kgM = (ImageButton) findViewById(R.id.ib_close);
        am.setBackgroundResource(this.kgM, R.drawable.push_close_selector);
        this.kgM.setOnClickListener(this);
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
    /* loaded from: classes9.dex */
    public class a extends BaseAdapter {
        public a() {
            PushThreadActivity.this.kgJ = 0;
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
                if (pushTypeData.getType() == PushThreadActivity.this.kgJ) {
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
        this.kgL.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) v.getItem(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.kgJ == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                am.setViewTextColor(textView, (int) R.color.cp_cont_b);
                this.kgJ = -1;
                return;
            }
            if (this.kgK != null && (childAt = adapterView.getChildAt(v.getPosition(this.mPushTypeDatas, this.kgK))) != null) {
                ((ImageView) childAt.findViewById(R.id.iv_item_hint)).setImageDrawable(null);
                am.setViewTextColor((TextView) childAt.findViewById(R.id.tv_item_title), (int) R.color.cp_cont_b);
            }
            am.setImageResource(imageView, R.drawable.bg_choose_ok);
            am.setViewTextColor(textView, (int) R.color.cp_other_b);
            this.kgJ = pushTypeData.getType();
            this.kgK = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kgL) {
            if (this.kgJ == 0) {
                showToast(R.string.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.kgJ, longExtra3));
        } else if (view == this.kgM) {
            finish();
        }
    }
}
