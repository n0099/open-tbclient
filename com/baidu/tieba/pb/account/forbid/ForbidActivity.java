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
    private RadioGroup ddq;
    private String ddr;
    private TextView dds;
    private TextView ddt;
    private a ddv;
    private View.OnClickListener ddw = new com.baidu.tieba.pb.account.forbid.a(this);
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mThreadId;
    private String mUserName;
    private BdListView zu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m11getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dds = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.forbid_btn_txt), this.ddw);
        this.ddt = (TextView) findViewById(t.g.forbid_id);
        this.zu = (BdListView) findViewById(t.g.listview_forbid_reason);
        this.ddq = (RadioGroup) findViewById(t.g.forbid_days);
        this.ddq.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.ddr = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.ddr, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.ddq.getChildAt(i2);
            if (radioButton.getId() == i) {
                at.k(radioButton, t.f.btn_prohibit_day_s);
                at.c(radioButton, t.d.cp_cont_i, 3);
            } else {
                at.k(radioButton, t.f.btn_prohibit_day_n);
                at.c(radioButton, t.d.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(t.g.root);
        getLayoutMode().ae(z);
        getLayoutMode().x(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dds.setTextColor(at.getColor(t.d.cp_cont_f));
        this.zu.setDivider(at.getDrawable(t.f.forbid_list_divider));
        this.zu.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private int bKU = 0;
        private View.OnClickListener bxd = new e(this);
        private String[] ddz;

        public a(String[] strArr) {
            this.ddz = strArr;
        }

        public String avl() {
            if (this.ddz == null || this.bKU >= this.ddz.length) {
                return null;
            }
            return this.ddz[this.bKU];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ddz == null) {
                return 0;
            }
            return this.ddz.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.ddB = (TextView) view.findViewById(t.g.reason_text);
                bVar2.ddC = (ImageView) view.findViewById(t.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.bxd);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.ddB.setText(this.ddz[i]);
            if (bVar.mIndex == this.bKU) {
                at.c(bVar.ddC, t.f.icon_found_information_choose);
                bVar.ddC.setVisibility(0);
                at.c(bVar.ddB, t.d.forbid_selected_txt, 1);
            } else {
                bVar.ddC.setVisibility(4);
                at.c(bVar.ddB, t.d.appeal_com_text, 1);
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
        TextView ddB;
        ImageView ddC;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
