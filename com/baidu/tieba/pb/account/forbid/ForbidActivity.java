package com.baidu.tieba.pb.account.forbid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private String aec;
    private String bIA;
    private TextView bIB;
    private e bIC;
    private View.OnClickListener bID = new a(this);
    private RadioGroup bIz;
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
        setContentView(r.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.forbid_btn_txt), this.bID);
        this.bIB = (TextView) findViewById(q.forbid_id);
        this.mListView = (BdListView) findViewById(q.listview_forbid_reason);
        this.bIz = (RadioGroup) findViewById(q.forbid_days);
        this.bIz.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.bIA = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.aec = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        l.a(this.mForumId, this.bIA, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.bIz.getChildAt(i2);
            if (radioButton.getId() == i) {
                ay.i((View) radioButton, p.btn_prohibit_day_s);
                ay.b(radioButton, com.baidu.tieba.n.cp_cont_i, 3);
            } else {
                ay.i((View) radioButton, p.btn_prohibit_day_n);
                ay.b(radioButton, com.baidu.tieba.n.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(q.root);
        getLayoutMode().ab(z);
        getLayoutMode().j(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mListView.setDivider(ay.getDrawable(p.forbid_list_divider));
        this.mListView.setDividerHeight(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 1.0f));
    }
}
