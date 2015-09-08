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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private String aju;
    private RadioGroup bZg;
    private String bZh;
    private TextView bZi;
    private a bZj;
    private View.OnClickListener bZk = new com.baidu.tieba.pb.account.forbid.a(this);
    private String mForumId;
    private String mForumName;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mThreadId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.forbid_btn_txt), this.bZk);
        this.bZi = (TextView) findViewById(i.f.forbid_id);
        this.mListView = (BdListView) findViewById(i.f.listview_forbid_reason);
        this.bZg = (RadioGroup) findViewById(i.f.forbid_days);
        this.bZg.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.bZh = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.aju = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.bZh, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.bZg.getChildAt(i2);
            if (radioButton.getId() == i) {
                al.h((View) radioButton, i.e.btn_prohibit_day_s);
                al.b(radioButton, i.c.cp_cont_i, 3);
            } else {
                al.h((View) radioButton, i.e.btn_prohibit_day_n);
                al.b(radioButton, i.c.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(i.f.root);
        getLayoutMode().ad(z);
        getLayoutMode().k(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mListView.setDivider(al.getDrawable(i.e.forbid_list_divider));
        this.mListView.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private String[] bZn;
        private int bZo = 0;
        private View.OnClickListener bJG = new e(this);

        public a(String[] strArr) {
            this.bZn = strArr;
        }

        public String acE() {
            if (this.bZn == null || this.bZo >= this.bZn.length) {
                return null;
            }
            return this.bZn[this.bZo];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bZn == null) {
                return 0;
            }
            return this.bZn.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.bZq = (TextView) view.findViewById(i.f.reason_text);
                bVar2.bZr = (ImageView) view.findViewById(i.f.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.bJG);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.bZq.setText(this.bZn[i]);
            if (bVar.mIndex == this.bZo) {
                al.c(bVar.bZr, i.e.icon_found_information_choose);
                bVar.bZr.setVisibility(0);
                al.b(bVar.bZq, i.c.forbid_selected_txt, 1);
            } else {
                bVar.bZr.setVisibility(4);
                al.b(bVar.bZq, i.c.appeal_com_text, 1);
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
        TextView bZq;
        ImageView bZr;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
