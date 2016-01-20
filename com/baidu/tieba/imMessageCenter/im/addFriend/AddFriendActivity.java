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
    private String Ws;
    private View aJq;
    private InputMethodManager byv;
    private EditText ccP;
    private TextView ccQ;
    private TextView ccR;
    private ImageView ccS;
    private boolean ccT;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.activity_add_friend);
        this.byv = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
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
                this.Ws = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.ccP != null) {
                    if (!StringUtils.isNull(this.Ws)) {
                        this.ccP.setText(this.Ws);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.ccP.setText(String.valueOf(getPageContext().getString(n.j.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.ccP.setText(String.valueOf(getPageContext().getString(n.j.i_am_come_from)) + stringExtra + getPageContext().getString(n.j.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.ccP.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.ccT = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Ws = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.ccP != null) {
            if (!StringUtils.isNull(this.Ws)) {
                this.ccP.setText(this.Ws);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.ccP.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.ccT = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.ccP != null && !TextUtils.isEmpty(this.ccP.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.ccP.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.ccT);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Ws);
        }
    }

    private void initViews() {
        this.aJq = getPageContext().getPageActivity().findViewById(n.g.search_friend_parent);
        this.aJq.setOnClickListener(new b(this));
        this.ccS = (ImageView) getPageContext().getPageActivity().findViewById(n.g.cancle);
        this.ccS.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(n.g.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(n.j.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ccQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.j.group_apply_send));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ccQ.getLayoutParams();
        layoutParams.rightMargin = k.d(getPageContext().getPageActivity(), n.e.ds16);
        this.ccQ.setLayoutParams(layoutParams);
        this.ccQ.setOnClickListener(new d(this));
        this.ccR = (TextView) getPageContext().getPageActivity().findViewById(n.g.search_friend_tip);
        this.ccP = (EditText) getPageContext().getPageActivity().findViewById(n.g.search_friend_input);
        this.ccP.setOnFocusChangeListener(new e(this));
        this.ccP.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.h.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(n.j.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.byv, this.ccP);
        this.ccP.setSelection(this.ccP.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.byv, this.ccP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().k(this.aJq);
        this.ccR.setTextColor(as.getColor(n.d.cp_cont_c));
        this.ccQ.setTextColor(as.getColor(n.d.cp_cont_i));
        as.i((View) this.ccQ, n.f.s_navbar_button_bg);
    }
}
