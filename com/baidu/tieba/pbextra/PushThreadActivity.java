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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes9.dex */
public class PushThreadActivity extends BaseActivity {
    private GridView cpt;
    private PushStatusData dNp;
    private int kBC;
    private PushTypeData kBD;
    private TextView kBE;
    private ImageButton kBF;
    private HttpMessageListener kBG = new HttpMessageListener(1001806) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(R.string.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.kBC == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
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
        this.kBG.setSelfListener(true);
        registerListener(this.kBG);
    }

    private void initData() {
        this.dNp = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.dNp != null) {
            this.mPushTypeDatas = this.dNp.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(R.layout.push_thread_layout);
        an.setBackgroundResource(findViewById(R.id.push_thread_container), R.drawable.dialog_background);
        an.setViewTextColor((TextView) findViewById(R.id.select_hint), (int) R.color.cp_cont_b);
        this.cpt = (GridView) findViewById(R.id.gv_push);
        this.cpt.setAdapter((ListAdapter) new a());
        this.cpt.setOnItemClickListener(this);
        this.kBE = (TextView) findViewById(R.id.push_commit);
        an.setBackgroundResource(this.kBE, R.drawable.push_commit_selector);
        an.setViewTextColor(this.kBE, (int) R.color.cp_cont_a);
        this.kBE.setOnClickListener(this);
        this.kBF = (ImageButton) findViewById(R.id.ib_close);
        an.setBackgroundResource(this.kBF, R.drawable.push_close_selector);
        this.kBF.setOnClickListener(this);
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
            PushThreadActivity.this.kBC = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return w.getCount(PushThreadActivity.this.mPushTypeDatas);
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
            PushTypeData pushTypeData = (PushTypeData) w.getItem(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.kBC) {
                    an.setImageResource(imageView, R.drawable.bg_choose_ok);
                    an.setViewTextColor(textView, (int) R.color.cp_other_b);
                } else {
                    an.setViewTextColor(textView, (int) R.color.cp_cont_b);
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
        this.kBE.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) w.getItem(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.kBC == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                an.setViewTextColor(textView, (int) R.color.cp_cont_b);
                this.kBC = -1;
                return;
            }
            if (this.kBD != null && (childAt = adapterView.getChildAt(w.getPosition(this.mPushTypeDatas, this.kBD))) != null) {
                ((ImageView) childAt.findViewById(R.id.iv_item_hint)).setImageDrawable(null);
                an.setViewTextColor((TextView) childAt.findViewById(R.id.tv_item_title), (int) R.color.cp_cont_b);
            }
            an.setImageResource(imageView, R.drawable.bg_choose_ok);
            an.setViewTextColor(textView, (int) R.color.cp_other_b);
            this.kBC = pushTypeData.getType();
            this.kBD = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kBE) {
            if (this.kBC == 0) {
                showToast(R.string.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.kBC, longExtra3));
        } else if (view == this.kBF) {
            finish();
        }
    }
}
