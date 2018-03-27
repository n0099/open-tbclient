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
    private PushStatusData aPD;
    private GridView dvR;
    private int geC;
    private PushTypeData geD;
    private TextView geE;
    private ImageButton geF;
    private HttpMessageListener geG = new HttpMessageListener(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(d.j.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.geC == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        PushThreadActivity.this.setResult(-1, new Intent());
                    } else {
                        PushThreadActivity.this.showToast(d.j.neterror);
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
        this.geG.setSelfListener(true);
        registerListener(this.geG);
    }

    private void initData() {
        this.aPD = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.aPD != null) {
            this.mPushTypeDatas = this.aPD.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(d.h.push_thread_layout);
        aj.s(findViewById(d.g.push_thread_container), d.f.dialog_background);
        aj.r((TextView) findViewById(d.g.select_hint), d.C0141d.cp_cont_b);
        this.dvR = (GridView) findViewById(d.g.gv_push);
        this.dvR.setAdapter((ListAdapter) new a());
        this.dvR.setOnItemClickListener(this);
        this.geE = (TextView) findViewById(d.g.push_commit);
        aj.s(this.geE, d.f.push_commit_selector);
        aj.r(this.geE, d.C0141d.cp_cont_i);
        this.geE.setOnClickListener(this);
        this.geF = (ImageButton) findViewById(d.g.ib_close);
        aj.s(this.geF, d.f.push_close_selector);
        this.geF.setOnClickListener(this);
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
            PushThreadActivity.this.geC = 0;
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
                if (pushTypeData.getType() == PushThreadActivity.this.geC) {
                    aj.c(imageView, d.f.bg_choose_ok);
                    aj.r(textView, d.C0141d.cp_other_b);
                } else {
                    aj.r(textView, d.C0141d.cp_cont_b);
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
        this.geE.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) v.f(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.geC == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                aj.r(textView, d.C0141d.cp_cont_b);
                this.geC = -1;
                return;
            }
            if (this.geD != null && (childAt = adapterView.getChildAt(v.a(this.mPushTypeDatas, this.geD))) != null) {
                ((ImageView) childAt.findViewById(d.g.iv_item_hint)).setImageDrawable(null);
                aj.r((TextView) childAt.findViewById(d.g.tv_item_title), d.C0141d.cp_cont_b);
            }
            aj.c(imageView, d.f.bg_choose_ok);
            aj.r(textView, d.C0141d.cp_other_b);
            this.geC = pushTypeData.getType();
            this.geD = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.geE) {
            if (this.geC == 0) {
                showToast(d.j.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.geC, longExtra3));
        } else if (view == this.geF) {
            finish();
        }
    }
}
