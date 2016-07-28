package com.baidu.tieba.pb.account.forbid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private RadioGroup dWc;
    private String dWd;
    private TextView dWe;
    private TextView dWf;
    private a dWg;
    private View.OnClickListener dWh = new com.baidu.tieba.pb.account.forbid.a(this);
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mThreadId;
    private String mUserName;
    private BdListView zU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m10getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dWe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(u.j.forbid_btn_txt), this.dWh);
        this.dWf = (TextView) findViewById(u.g.forbid_id);
        this.zU = (BdListView) findViewById(u.g.listview_forbid_reason);
        this.dWc = (RadioGroup) findViewById(u.g.forbid_days);
        this.dWc.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.dWd = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.dWd, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.dWc.getChildAt(i2);
            if (radioButton.getId() == i) {
                av.k(radioButton, u.f.btn_prohibit_day_s);
                av.c(radioButton, u.d.cp_cont_i, 3);
            } else {
                av.k(radioButton, u.f.btn_prohibit_day_n);
                av.c(radioButton, u.d.common_color_10039, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(u.g.root);
        getLayoutMode().af(z);
        getLayoutMode().w(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dWe.setTextColor(av.getColor(u.d.cp_cont_f));
        this.zU.setDivider(av.getDrawable(u.f.forbid_list_divider));
        this.zU.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private String[] dWk;
        private int cln = 0;
        private View.OnClickListener aLH = new e(this);

        public a(String[] strArr) {
            this.dWk = strArr;
        }

        public String aGA() {
            if (this.dWk == null || this.cln >= this.dWk.length) {
                return null;
            }
            return this.dWk[this.cln];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dWk == null) {
                return 0;
            }
            return this.dWk.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(u.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.dWm = (TextView) view.findViewById(u.g.reason_text);
                bVar2.dWn = (ImageView) view.findViewById(u.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.aLH);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.dWm.setText(this.dWk[i]);
            if (bVar.mIndex == this.cln) {
                av.c(bVar.dWn, u.f.icon_found_information_choose);
                bVar.dWn.setVisibility(0);
                av.c(bVar.dWm, u.d.common_color_10047, 1);
            } else {
                bVar.dWn.setVisibility(4);
                av.c(bVar.dWm, u.d.common_color_10039, 1);
            }
            return view;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        TextView dWm;
        ImageView dWn;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
