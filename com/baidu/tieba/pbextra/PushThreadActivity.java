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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes3.dex */
public class PushThreadActivity extends BaseActivity {
    private PushStatusData aiY;
    private GridView cZC;
    private int fPt;
    private PushTypeData fPu;
    private TextView fPv;
    private ImageButton fPw;
    private HttpMessageListener fPx = new HttpMessageListener(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(f.j.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.fPt == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        PushThreadActivity.this.setResult(-1, new Intent());
                    } else {
                        PushThreadActivity.this.showToast(f.j.neterror);
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
        this.fPx.setSelfListener(true);
        registerListener(this.fPx);
    }

    private void initData() {
        this.aiY = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.aiY != null) {
            this.mPushTypeDatas = this.aiY.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(f.h.push_thread_layout);
        am.i(findViewById(f.g.push_thread_container), f.C0146f.dialog_background);
        am.h((TextView) findViewById(f.g.select_hint), f.d.cp_cont_b);
        this.cZC = (GridView) findViewById(f.g.gv_push);
        this.cZC.setAdapter((ListAdapter) new a());
        this.cZC.setOnItemClickListener(this);
        this.fPv = (TextView) findViewById(f.g.push_commit);
        am.i(this.fPv, f.C0146f.push_commit_selector);
        am.h(this.fPv, f.d.cp_cont_i);
        this.fPv.setOnClickListener(this);
        this.fPw = (ImageButton) findViewById(f.g.ib_close);
        am.i(this.fPw, f.C0146f.push_close_selector);
        this.fPw.setOnClickListener(this);
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
            PushThreadActivity.this.fPt = 0;
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
            View inflate = LayoutInflater.from(PushThreadActivity.this.getPageContext().getPageActivity()).inflate(f.h.push_thread_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(f.g.iv_item_icon);
            ImageView imageView = (ImageView) inflate.findViewById(f.g.iv_item_hint);
            TextView textView = (TextView) inflate.findViewById(f.g.tv_item_title);
            PushTypeData pushTypeData = (PushTypeData) w.d(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.fPt) {
                    am.c(imageView, f.C0146f.bg_choose_ok);
                    am.h(textView, f.d.cp_other_b);
                } else {
                    am.h(textView, f.d.cp_cont_b);
                    imageView.setImageDrawable(null);
                }
            }
            return inflate;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        View childAt;
        ImageView imageView = (ImageView) view.findViewById(f.g.iv_item_hint);
        TextView textView = (TextView) view.findViewById(f.g.tv_item_title);
        this.fPv.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) w.d(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.fPt == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                am.h(textView, f.d.cp_cont_b);
                this.fPt = -1;
                return;
            }
            if (this.fPu != null && (childAt = adapterView.getChildAt(w.a(this.mPushTypeDatas, this.fPu))) != null) {
                ((ImageView) childAt.findViewById(f.g.iv_item_hint)).setImageDrawable(null);
                am.h((TextView) childAt.findViewById(f.g.tv_item_title), f.d.cp_cont_b);
            }
            am.c(imageView, f.C0146f.bg_choose_ok);
            am.h(textView, f.d.cp_other_b);
            this.fPt = pushTypeData.getType();
            this.fPu = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fPv) {
            if (this.fPt == 0) {
                showToast(f.j.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.fPt, longExtra3));
        } else if (view == this.fPw) {
            finish();
        }
    }
}
