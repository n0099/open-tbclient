package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String VS;
    private View aHS;
    private EditText bYP;
    private TextView bYQ;
    private TextView bYR;
    private ImageView bYS;
    private boolean bYT;
    private InputMethodManager buE;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.activity_add_friend);
        this.buE = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        initViews();
        initData(bundle);
        initListener();
    }

    private void initListener() {
        registerListener(new a(this, 304100));
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra("user_id");
                this.VS = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.bYP != null) {
                    if (!StringUtils.isNull(this.VS)) {
                        this.bYP.setText(this.VS);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.bYP.setText(String.valueOf(getPageContext().getString(n.i.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.bYP.setText(String.valueOf(getPageContext().getString(n.i.i_am_come_from)) + stringExtra + getPageContext().getString(n.i.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.bYP.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.bYT = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.VS = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.bYP != null) {
            if (!StringUtils.isNull(this.VS)) {
                this.bYP.setText(this.VS);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.bYP.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.bYT = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.bYP != null && !TextUtils.isEmpty(this.bYP.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.bYP.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.bYT);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.VS);
        }
    }

    private void initViews() {
        this.aHS = getPageContext().getPageActivity().findViewById(n.f.search_friend_parent);
        this.aHS.setOnClickListener(new b(this));
        this.bYS = (ImageView) getPageContext().getPageActivity().findViewById(n.f.cancle);
        this.bYS.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(n.f.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(n.i.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bYQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.i.group_apply_send));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bYQ.getLayoutParams();
        layoutParams.rightMargin = k.d(getPageContext().getPageActivity(), n.d.ds16);
        this.bYQ.setLayoutParams(layoutParams);
        this.bYQ.setOnClickListener(new d(this));
        this.bYR = (TextView) getPageContext().getPageActivity().findViewById(n.f.search_friend_tip);
        this.bYP = (EditText) getPageContext().getPageActivity().findViewById(n.f.search_friend_input);
        this.bYP.setOnFocusChangeListener(new e(this));
        this.bYP.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.h.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(n.i.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.buE, this.bYP);
        this.bYP.setSelection(this.bYP.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.buE, this.bYP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().k(this.aHS);
        this.bYR.setTextColor(as.getColor(n.c.cp_cont_c));
        this.bYQ.setTextColor(as.getColor(n.c.cp_cont_i));
        as.i((View) this.bYQ, n.e.s_navbar_button_bg);
    }
}
