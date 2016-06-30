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
    private RadioGroup dJT;
    private String dJU;
    private TextView dJV;
    private TextView dJW;
    private a dJX;
    private View.OnClickListener dJY = new com.baidu.tieba.pb.account.forbid.a(this);
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mThreadId;
    private String mUserName;
    private BdListView zt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dJV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(u.j.forbid_btn_txt), this.dJY);
        this.dJW = (TextView) findViewById(u.g.forbid_id);
        this.zt = (BdListView) findViewById(u.g.listview_forbid_reason);
        this.dJT = (RadioGroup) findViewById(u.g.forbid_days);
        this.dJT.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.dJU = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.dJU, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.dJT.getChildAt(i2);
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
        getLayoutMode().ad(z);
        getLayoutMode().w(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dJV.setTextColor(av.getColor(u.d.cp_cont_f));
        this.zt.setDivider(av.getDrawable(u.f.forbid_list_divider));
        this.zt.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private String[] dKb;
        private int cja = 0;
        private View.OnClickListener aKO = new e(this);

        public a(String[] strArr) {
            this.dKb = strArr;
        }

        public String aDq() {
            if (this.dKb == null || this.cja >= this.dKb.length) {
                return null;
            }
            return this.dKb[this.cja];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dKb == null) {
                return 0;
            }
            return this.dKb.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(u.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.dKd = (TextView) view.findViewById(u.g.reason_text);
                bVar2.dKe = (ImageView) view.findViewById(u.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.aKO);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.dKd.setText(this.dKb[i]);
            if (bVar.mIndex == this.cja) {
                av.c(bVar.dKe, u.f.icon_found_information_choose);
                bVar.dKe.setVisibility(0);
                av.c(bVar.dKd, u.d.common_color_10047, 1);
            } else {
                bVar.dKe.setVisibility(4);
                av.c(bVar.dKd, u.d.common_color_10039, 1);
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
        TextView dKd;
        ImageView dKe;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
