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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes3.dex */
public class PushThreadActivity extends BaseActivity {
    private PushStatusData aPN;
    private GridView dwa;
    private ImageButton geA;
    private HttpMessageListener geB = new HttpMessageListener(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(d.j.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.gex == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        PushThreadActivity.this.setResult(-1, new Intent());
                    } else {
                        PushThreadActivity.this.showToast(d.j.neterror);
                    }
                    PushThreadActivity.this.finish();
                }
            }
        }
    };
    private int gex;
    private PushTypeData gey;
    private TextView gez;
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
        this.geB.setSelfListener(true);
        registerListener(this.geB);
    }

    private void initData() {
        this.aPN = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.aPN != null) {
            this.mPushTypeDatas = this.aPN.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(d.h.push_thread_layout);
        aj.s(findViewById(d.g.push_thread_container), d.f.dialog_background);
        aj.r((TextView) findViewById(d.g.select_hint), d.C0140d.cp_cont_b);
        this.dwa = (GridView) findViewById(d.g.gv_push);
        this.dwa.setAdapter((ListAdapter) new a());
        this.dwa.setOnItemClickListener(this);
        this.gez = (TextView) findViewById(d.g.push_commit);
        aj.s(this.gez, d.f.push_commit_selector);
        aj.r(this.gez, d.C0140d.cp_cont_i);
        this.gez.setOnClickListener(this);
        this.geA = (ImageButton) findViewById(d.g.ib_close);
        aj.s(this.geA, d.f.push_close_selector);
        this.geA.setOnClickListener(this);
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
            PushThreadActivity.this.gex = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return v.D(PushThreadActivity.this.mPushTypeDatas);
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
            View inflate = LayoutInflater.from(PushThreadActivity.this.getPageContext().getPageActivity()).inflate(d.h.push_thread_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.iv_item_icon);
            ImageView imageView = (ImageView) inflate.findViewById(d.g.iv_item_hint);
            TextView textView = (TextView) inflate.findViewById(d.g.tv_item_title);
            PushTypeData pushTypeData = (PushTypeData) v.f(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.gex) {
                    aj.c(imageView, d.f.bg_choose_ok);
                    aj.r(textView, d.C0140d.cp_other_b);
                } else {
                    aj.r(textView, d.C0140d.cp_cont_b);
                    imageView.setImageDrawable(null);
                }
            }
            return inflate;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        View childAt;
        ImageView imageView = (ImageView) view.findViewById(d.g.iv_item_hint);
        TextView textView = (TextView) view.findViewById(d.g.tv_item_title);
        this.gez.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) v.f(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.gex == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                aj.r(textView, d.C0140d.cp_cont_b);
                this.gex = -1;
                return;
            }
            if (this.gey != null && (childAt = adapterView.getChildAt(v.a(this.mPushTypeDatas, this.gey))) != null) {
                ((ImageView) childAt.findViewById(d.g.iv_item_hint)).setImageDrawable(null);
                aj.r((TextView) childAt.findViewById(d.g.tv_item_title), d.C0140d.cp_cont_b);
            }
            aj.c(imageView, d.f.bg_choose_ok);
            aj.r(textView, d.C0140d.cp_other_b);
            this.gex = pushTypeData.getType();
            this.gey = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gez) {
            if (this.gex == 0) {
                showToast(d.j.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.gex, longExtra3));
        } else if (view == this.geA) {
            finish();
        }
    }
}
