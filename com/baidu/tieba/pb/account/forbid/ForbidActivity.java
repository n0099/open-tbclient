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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView Je;
    private RadioGroup daW;
    private String daX;
    private TextView daY;
    private a daZ;
    private View.OnClickListener dba = new com.baidu.tieba.pb.account.forbid.a(this);
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mThreadId;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.forbid_btn_txt), this.dba);
        this.daY = (TextView) findViewById(t.g.forbid_id);
        this.Je = (BdListView) findViewById(t.g.listview_forbid_reason);
        this.daW = (RadioGroup) findViewById(t.g.forbid_days);
        this.daW.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.daX = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.daX, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.daW.getChildAt(i2);
            if (radioButton.getId() == i) {
                at.k(radioButton, t.f.btn_prohibit_day_s);
                at.b(radioButton, t.d.cp_cont_i, 3);
            } else {
                at.k(radioButton, t.f.btn_prohibit_day_n);
                at.b(radioButton, t.d.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(t.g.root);
        getLayoutMode().ab(z);
        getLayoutMode().x(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.Je.setDivider(at.getDrawable(t.f.forbid_list_divider));
        this.Je.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private int bKO = 0;
        private View.OnClickListener bKS = new e(this);
        private String[] dbd;

        public a(String[] strArr) {
            this.dbd = strArr;
        }

        public String avc() {
            if (this.dbd == null || this.bKO >= this.dbd.length) {
                return null;
            }
            return this.dbd[this.bKO];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dbd == null) {
                return 0;
            }
            return this.dbd.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.dbf = (TextView) view.findViewById(t.g.reason_text);
                bVar2.dbg = (ImageView) view.findViewById(t.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.bKS);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.dbf.setText(this.dbd[i]);
            if (bVar.mIndex == this.bKO) {
                at.c(bVar.dbg, t.f.icon_found_information_choose);
                bVar.dbg.setVisibility(0);
                at.b(bVar.dbf, t.d.forbid_selected_txt, 1);
            } else {
                bVar.dbg.setVisibility(4);
                at.b(bVar.dbf, t.d.appeal_com_text, 1);
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
        TextView dbf;
        ImageView dbg;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
