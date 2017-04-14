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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView Ik;
    private RadioGroup eef;
    private String eeg;
    private TextView eeh;
    private TextView eei;
    private a eej;
    private View.OnClickListener eek = new com.baidu.tieba.pb.account.forbid.a(this);
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
        setContentView(w.j.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(w.l.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eeh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.forbid_btn_txt), this.eek);
        this.eei = (TextView) findViewById(w.h.forbid_id);
        this.Ik = (BdListView) findViewById(w.h.listview_forbid_reason);
        this.eef = (RadioGroup) findViewById(w.h.forbid_days);
        this.eef.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.eeg = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.eeg, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.eef.getChildAt(i2);
            if (radioButton.getId() == i) {
                aq.j(radioButton, w.g.btn_prohibit_day_s);
                aq.c(radioButton, w.e.cp_cont_i, 3);
            } else {
                aq.j(radioButton, w.g.btn_prohibit_day_n);
                aq.c(radioButton, w.e.common_color_10039, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(w.h.root);
        getLayoutMode().aj(z);
        getLayoutMode().t(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eeh.setTextColor(aq.getColor(w.e.cp_cont_f));
        this.Ik.setDivider(aq.getDrawable(w.g.forbid_list_divider));
        this.Ik.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private String[] een;
        private int cnR = 0;
        private View.OnClickListener ceA = new e(this);

        public a(String[] strArr) {
            this.een = strArr;
        }

        public String aJa() {
            if (this.een == null || this.cnR >= this.een.length) {
                return null;
            }
            return this.een[this.cnR];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.een == null) {
                return 0;
            }
            return this.een.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(w.j.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.eep = (TextView) view.findViewById(w.h.reason_text);
                bVar2.eeq = (ImageView) view.findViewById(w.h.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.ceA);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.eep.setText(this.een[i]);
            if (bVar.mIndex == this.cnR) {
                aq.c(bVar.eeq, w.g.icon_found_information_choose);
                bVar.eeq.setVisibility(0);
                aq.c(bVar.eep, w.e.common_color_10047, 1);
            } else {
                bVar.eeq.setVisibility(4);
                aq.c(bVar.eep, w.e.common_color_10039, 1);
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
        TextView eep;
        ImageView eeq;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
