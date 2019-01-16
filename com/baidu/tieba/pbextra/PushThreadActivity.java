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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes3.dex */
public class PushThreadActivity extends BaseActivity {
    private PushStatusData avk;
    private int gqt;
    private PushTypeData gqu;
    private TextView gqv;
    private ImageButton gqw;
    private HttpMessageListener gqx = new HttpMessageListener(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(e.j.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.gqt == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        PushThreadActivity.this.setResult(-1, new Intent());
                    } else {
                        PushThreadActivity.this.showToast(e.j.neterror);
                    }
                    PushThreadActivity.this.finish();
                }
            }
        }
    };
    private GridView mGridView;
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
        this.gqx.setSelfListener(true);
        registerListener(this.gqx);
    }

    private void initData() {
        this.avk = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.avk != null) {
            this.mPushTypeDatas = this.avk.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(e.h.push_thread_layout);
        al.i(findViewById(e.g.push_thread_container), e.f.dialog_background);
        al.h((TextView) findViewById(e.g.select_hint), e.d.cp_cont_b);
        this.mGridView = (GridView) findViewById(e.g.gv_push);
        this.mGridView.setAdapter((ListAdapter) new a());
        this.mGridView.setOnItemClickListener(this);
        this.gqv = (TextView) findViewById(e.g.push_commit);
        al.i(this.gqv, e.f.push_commit_selector);
        al.h(this.gqv, e.d.cp_cont_i);
        this.gqv.setOnClickListener(this);
        this.gqw = (ImageButton) findViewById(e.g.ib_close);
        al.i(this.gqw, e.f.push_close_selector);
        this.gqw.setOnClickListener(this);
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
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        public a() {
            PushThreadActivity.this.gqt = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return v.H(PushThreadActivity.this.mPushTypeDatas);
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
            View inflate = LayoutInflater.from(PushThreadActivity.this.getPageContext().getPageActivity()).inflate(e.h.push_thread_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(e.g.iv_item_icon);
            ImageView imageView = (ImageView) inflate.findViewById(e.g.iv_item_hint);
            TextView textView = (TextView) inflate.findViewById(e.g.tv_item_title);
            PushTypeData pushTypeData = (PushTypeData) v.d(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.gqt) {
                    al.c(imageView, e.f.bg_choose_ok);
                    al.h(textView, e.d.cp_other_b);
                } else {
                    al.h(textView, e.d.cp_cont_b);
                    imageView.setImageDrawable(null);
                }
            }
            return inflate;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        View childAt;
        ImageView imageView = (ImageView) view.findViewById(e.g.iv_item_hint);
        TextView textView = (TextView) view.findViewById(e.g.tv_item_title);
        this.gqv.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) v.d(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.gqt == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                al.h(textView, e.d.cp_cont_b);
                this.gqt = -1;
                return;
            }
            if (this.gqu != null && (childAt = adapterView.getChildAt(v.a(this.mPushTypeDatas, this.gqu))) != null) {
                ((ImageView) childAt.findViewById(e.g.iv_item_hint)).setImageDrawable(null);
                al.h((TextView) childAt.findViewById(e.g.tv_item_title), e.d.cp_cont_b);
            }
            al.c(imageView, e.f.bg_choose_ok);
            al.h(textView, e.d.cp_other_b);
            this.gqt = pushTypeData.getType();
            this.gqu = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gqv) {
            if (this.gqt == 0) {
                showToast(e.j.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.gqt, longExtra3));
        } else if (view == this.gqw) {
            finish();
        }
    }
}
