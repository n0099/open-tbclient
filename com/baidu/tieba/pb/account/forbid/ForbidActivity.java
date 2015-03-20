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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private String acM;
    private RadioGroup bFr;
    private String bFs;
    private TextView bFt;
    private e bFu;
    private View.OnClickListener bFv = new a(this);
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
        setContentView(w.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(y.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(y.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(y.forbid_btn_txt), this.bFv);
        this.bFt = (TextView) findViewById(v.forbid_id);
        this.mListView = (BdListView) findViewById(v.listview_forbid_reason);
        this.bFr = (RadioGroup) findViewById(v.forbid_days);
        this.bFr.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.bFs = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.acM = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        l.a(this.mForumId, this.bFs, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.bFr.getChildAt(i2);
            if (radioButton.getId() == i) {
                ba.i((View) radioButton, u.btn_prohibit_day_s);
                ba.b(radioButton, s.cp_cont_i, 3);
            } else {
                ba.i((View) radioButton, u.btn_prohibit_day_n);
                ba.b(radioButton, s.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(v.root);
        getLayoutMode().X(z);
        getLayoutMode().h(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mListView.setDivider(ba.getDrawable(u.forbid_list_divider));
        this.mListView.setDividerHeight(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 1.0f));
    }
}
