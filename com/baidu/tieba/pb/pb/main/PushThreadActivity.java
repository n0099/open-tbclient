package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PushThreadActivity extends BaseActivity {
    private static String[] dnl = {"明星", "电影", "电视剧", "综艺", "活动"};
    private static int[] dnm = {t.f.icon_yule_star, t.f.icon_yule_film, t.f.icon_yule_tv, t.f.icon_yule_show, t.f.icon_yule_activity};
    private static int[] dnn = {1, 2, 3, 4, 5};
    private GridView cQM;
    private int dno;
    private View dnp;
    private TextView dnq;
    private ImageButton dnr;
    private HttpMessageListener dns = new gh(this, CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        pU();
        this.dns.setSelfListener(true);
        registerListener(this.dns);
    }

    private void pU() {
        setContentView(t.h.push_thread_layout);
        com.baidu.tbadk.core.util.at.k(findViewById(t.g.push_thread_container), t.f.dialog_push_bg);
        com.baidu.tbadk.core.util.at.j((View) ((TextView) findViewById(t.g.select_hint)), t.d.cp_cont_b);
        this.cQM = (GridView) findViewById(t.g.gv_push);
        this.cQM.setAdapter((ListAdapter) new a());
        this.cQM.setOnItemClickListener(this);
        this.dnq = (TextView) findViewById(t.g.push_commit);
        com.baidu.tbadk.core.util.at.k(this.dnq, t.f.push_commit_selector);
        com.baidu.tbadk.core.util.at.j((View) this.dnq, t.d.cp_cont_i);
        this.dnq.setOnClickListener(this);
        this.dnr = (ImageButton) findViewById(t.g.ib_close);
        com.baidu.tbadk.core.util.at.k(this.dnr, t.f.push_close_selector);
        this.dnr.setOnClickListener(this);
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
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        public a() {
            PushThreadActivity.this.dno = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return PushThreadActivity.dnl.length;
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
            View inflate = LayoutInflater.from(PushThreadActivity.this.getPageContext().getPageActivity()).inflate(t.h.push_thread_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.tv_item_title);
            com.baidu.tbadk.core.util.at.c((ImageView) inflate.findViewById(t.g.iv_item_icon), PushThreadActivity.dnm[i]);
            textView.setText(PushThreadActivity.dnl[i]);
            com.baidu.tbadk.core.util.at.j((View) textView, t.d.cp_cont_b);
            ((ImageView) inflate.findViewById(t.g.iv_item_hint)).setImageDrawable(null);
            return inflate;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ImageView imageView = (ImageView) view.findViewById(t.g.iv_item_hint);
        TextView textView = (TextView) view.findViewById(t.g.tv_item_title);
        this.dnq.setEnabled(true);
        if (this.dno == dnn[i]) {
            imageView.setImageDrawable(null);
            com.baidu.tbadk.core.util.at.j((View) textView, t.d.cp_cont_b);
            this.dno = 0;
            return;
        }
        if (this.dnp != null) {
            ((ImageView) this.dnp.findViewById(t.g.iv_item_hint)).setImageDrawable(null);
            com.baidu.tbadk.core.util.at.j((View) ((TextView) this.dnp.findViewById(t.g.tv_item_title)), t.d.cp_cont_b);
        }
        com.baidu.tbadk.core.util.at.c(imageView, t.f.bg_choose_ok);
        com.baidu.tbadk.core.util.at.j((View) textView, t.d.cp_other_b);
        this.dno = dnn[i];
        this.dnp = view;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dnq) {
            if (this.dno == 0) {
                showToast(t.j.select_category);
                return;
            }
            long longExtra = getIntent().getLongExtra("forum_id", 0L);
            long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
            long longExtra3 = getIntent().getLongExtra("user_id", 0L);
            showLoadingDialog("");
            sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.dno, longExtra3));
        } else if (view == this.dnr) {
            finish();
        }
    }
}
