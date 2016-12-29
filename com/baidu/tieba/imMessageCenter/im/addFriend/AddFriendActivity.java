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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private View aVz;
    private EditText cYL;
    private TextView cYM;
    private TextView cYN;
    private ImageView cYO;
    private boolean cYP;
    private String cYQ;
    private InputMethodManager cdc;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.activity_add_friend);
        this.cdc = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        initViews();
        initData(bundle);
        Tc();
    }

    private void Tc() {
        registerListener(new a(this, 304100));
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra("user_id");
                this.cYQ = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.cYL != null) {
                    if (!StringUtils.isNull(this.cYQ)) {
                        this.cYL.setText(this.cYQ);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.cYL.setText(String.valueOf(getPageContext().getString(r.j.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.cYL.setText(String.valueOf(getPageContext().getString(r.j.i_am_come_from)) + stringExtra + getPageContext().getString(r.j.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.cYL.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.cYP = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.cYQ = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.cYL != null) {
            if (!StringUtils.isNull(this.cYQ)) {
                this.cYL.setText(this.cYQ);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.cYL.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.cYP = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.cYL != null && !TextUtils.isEmpty(this.cYL.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.cYL.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.cYP);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.cYQ);
        }
    }

    private void initViews() {
        this.aVz = getPageContext().getPageActivity().findViewById(r.g.search_friend_parent);
        this.aVz.setOnClickListener(new b(this));
        this.cYO = (ImageView) getPageContext().getPageActivity().findViewById(r.g.cancle);
        this.cYO.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(r.g.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(r.j.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cYM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.group_apply_send));
        if (this.cYM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYM.getLayoutParams();
            layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), r.e.ds16);
            this.cYM.setLayoutParams(layoutParams);
        }
        this.cYM.setOnClickListener(new d(this));
        this.cYN = (TextView) getPageContext().getPageActivity().findViewById(r.g.search_friend_tip);
        this.cYL = (EditText) getPageContext().getPageActivity().findViewById(r.g.search_friend_input);
        this.cYL.setOnFocusChangeListener(new e(this));
        this.cYL.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hz(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.h.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(r.j.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.cdc, this.cYL);
        this.cYL.setSelection(this.cYL.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.cdc, this.cYL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().x(this.aVz);
        this.cYN.setTextColor(ar.getColor(r.d.cp_cont_c));
        this.cYM.setTextColor(ar.getColor(r.d.cp_cont_i));
        ar.k(this.cYM, r.f.s_navbar_button_bg);
    }
}
