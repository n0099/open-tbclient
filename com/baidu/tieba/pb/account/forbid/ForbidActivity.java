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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView Ib;
    private TextView epA;
    private TextView epB;
    private a epC;
    private View.OnClickListener epD = new com.baidu.tieba.pb.account.forbid.a(this);
    private RadioGroup epy;
    private String epz;
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
        this.epA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.forbid_btn_txt), this.epD);
        this.epB = (TextView) findViewById(w.h.forbid_id);
        this.Ib = (BdListView) findViewById(w.h.listview_forbid_reason);
        this.epy = (RadioGroup) findViewById(w.h.forbid_days);
        this.epy.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.epz = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.epz, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.epy.getChildAt(i2);
            if (radioButton.getId() == i) {
                as.j(radioButton, w.g.btn_prohibit_day_s);
                as.c(radioButton, w.e.cp_cont_i, 3);
            } else {
                as.j(radioButton, w.g.btn_prohibit_day_n);
                as.c(radioButton, w.e.common_color_10039, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(w.h.root);
        getLayoutMode().ah(z);
        getLayoutMode().t(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.epA.setTextColor(as.getColor(w.e.cp_cont_f));
        this.Ib.setDivider(as.getDrawable(w.g.forbid_list_divider));
        this.Ib.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private int cBs = 0;
        private View.OnClickListener crS = new e(this);
        private String[] epG;

        public a(String[] strArr) {
            this.epG = strArr;
        }

        public String aLX() {
            if (this.epG == null || this.cBs >= this.epG.length) {
                return null;
            }
            return this.epG[this.cBs];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.epG == null) {
                return 0;
            }
            return this.epG.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(w.j.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.epI = (TextView) view.findViewById(w.h.reason_text);
                bVar2.epJ = (ImageView) view.findViewById(w.h.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.crS);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.epI.setText(this.epG[i]);
            if (bVar.mIndex == this.cBs) {
                as.c(bVar.epJ, w.g.icon_found_information_choose);
                bVar.epJ.setVisibility(0);
                as.c(bVar.epI, w.e.common_color_10047, 1);
            } else {
                bVar.epJ.setVisibility(4);
                as.c(bVar.epI, w.e.common_color_10039, 1);
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
        TextView epI;
        ImageView epJ;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
