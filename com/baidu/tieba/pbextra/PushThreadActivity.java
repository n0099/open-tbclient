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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import java.util.List;
/* loaded from: classes4.dex */
public class PushThreadActivity extends BaseActivity {
    private PushStatusData bCF;
    private GridView eLX;
    private int hGF;
    private PushTypeData hGG;
    private TextView hGH;
    private ImageButton hGI;
    private HttpMessageListener hGJ = new HttpMessageListener(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.PushThreadActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                if (httpResponsedMessage.hasError()) {
                    PushThreadActivity.this.showToast(d.j.neterror);
                } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                    if (PushThreadActivity.this.hGF == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
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
        this.hGJ.setSelfListener(true);
        registerListener(this.hGJ);
    }

    private void initData() {
        this.bCF = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
        if (this.bCF != null) {
            this.mPushTypeDatas = this.bCF.getPushTypeDatas();
        }
    }

    private void initUI() {
        setContentView(d.h.push_thread_layout);
        al.k(findViewById(d.g.push_thread_container), d.f.dialog_background);
        al.j((TextView) findViewById(d.g.select_hint), d.C0277d.cp_cont_b);
        this.eLX = (GridView) findViewById(d.g.gv_push);
        this.eLX.setAdapter((ListAdapter) new a());
        this.eLX.setOnItemClickListener(this);
        this.hGH = (TextView) findViewById(d.g.push_commit);
        al.k(this.hGH, d.f.push_commit_selector);
        al.j(this.hGH, d.C0277d.cp_btn_a);
        this.hGH.setOnClickListener(this);
        this.hGI = (ImageButton) findViewById(d.g.ib_close);
        al.k(this.hGI, d.f.push_close_selector);
        this.hGI.setOnClickListener(this);
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
            PushThreadActivity.this.hGF = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return v.S(PushThreadActivity.this.mPushTypeDatas);
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
            PushTypeData pushTypeData = (PushTypeData) v.c(PushThreadActivity.this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                tbImageView.startLoad(pushTypeData.getIcon(), 10, false);
                textView.setText(pushTypeData.getName());
                if (pushTypeData.getType() == PushThreadActivity.this.hGF) {
                    al.c(imageView, d.f.bg_choose_ok);
                    al.j(textView, d.C0277d.cp_other_b);
                } else {
                    al.j(textView, d.C0277d.cp_cont_b);
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
        this.hGH.setEnabled(true);
        PushTypeData pushTypeData = (PushTypeData) v.c(this.mPushTypeDatas, i);
        if (pushTypeData != null) {
            if (this.hGF == pushTypeData.getType()) {
                imageView.setImageDrawable(null);
                al.j(textView, d.C0277d.cp_cont_b);
                this.hGF = -1;
                return;
            }
            if (this.hGG != null && (childAt = adapterView.getChildAt(v.a(this.mPushTypeDatas, this.hGG))) != null) {
                ((ImageView) childAt.findViewById(d.g.iv_item_hint)).setImageDrawable(null);
                al.j((TextView) childAt.findViewById(d.g.tv_item_title), d.C0277d.cp_cont_b);
            }
            al.c(imageView, d.f.bg_choose_ok);
            al.j(textView, d.C0277d.cp_other_b);
            this.hGF = pushTypeData.getType();
            this.hGG = pushTypeData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hGH) {
            if (this.hGF == 0) {
                showToast(d.j.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.hGF, longExtra3));
        } else if (view == this.hGI) {
            finish();
        }
    }
}
