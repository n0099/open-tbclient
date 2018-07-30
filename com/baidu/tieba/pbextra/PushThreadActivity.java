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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes3.dex */
public class PushThreadActivity extends BaseActivity {
    private PushStatusData aiY;
    private GridView cZG;
    private int fPB;
    private PushTypeData fPC;
    private TextView fPD;
    private ImageButton fPE;
    private HttpMessageListener fPF = new HttpMessageListener(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(d.j.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.fPB == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
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
        this.fPF.setSelfListener(true);
        registerListener(this.fPF);
    }

    private void initData() {
        this.aiY = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.aiY != null) {
            this.mPushTypeDatas = this.aiY.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(d.h.push_thread_layout);
        am.i(findViewById(d.g.push_thread_container), d.f.dialog_background);
        am.h((TextView) findViewById(d.g.select_hint), d.C0140d.cp_cont_b);
        this.cZG = (GridView) findViewById(d.g.gv_push);
        this.cZG.setAdapter((ListAdapter) new a());
        this.cZG.setOnItemClickListener(this);
        this.fPD = (TextView) findViewById(d.g.push_commit);
        am.i(this.fPD, d.f.push_commit_selector);
        am.h(this.fPD, d.C0140d.cp_cont_i);
        this.fPD.setOnClickListener(this);
        this.fPE = (ImageButton) findViewById(d.g.ib_close);
        am.i(this.fPE, d.f.push_close_selector);
        this.fPE.setOnClickListener(this);
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
            PushThreadActivity.this.fPB = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return w.y(PushThreadActivity.this.mPushTypeDatas);
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
            PushTypeData pushTypeData = (PushTypeData) w.d(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.fPB) {
                    am.c(imageView, d.f.bg_choose_ok);
                    am.h(textView, d.C0140d.cp_other_b);
                } else {
                    am.h(textView, d.C0140d.cp_cont_b);
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
        this.fPD.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) w.d(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.fPB == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                am.h(textView, d.C0140d.cp_cont_b);
                this.fPB = -1;
                return;
            }
            if (this.fPC != null && (childAt = adapterView.getChildAt(w.a(this.mPushTypeDatas, this.fPC))) != null) {
                ((ImageView) childAt.findViewById(d.g.iv_item_hint)).setImageDrawable(null);
                am.h((TextView) childAt.findViewById(d.g.tv_item_title), d.C0140d.cp_cont_b);
            }
            am.c(imageView, d.f.bg_choose_ok);
            am.h(textView, d.C0140d.cp_other_b);
            this.fPB = pushTypeData.getType();
            this.fPC = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fPD) {
            if (this.fPB == 0) {
                showToast(d.j.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.fPB, longExtra3));
        } else if (view == this.fPE) {
            finish();
        }
    }
}
