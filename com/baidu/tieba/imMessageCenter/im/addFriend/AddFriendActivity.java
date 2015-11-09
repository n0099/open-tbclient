package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String Vn;
    private View aET;
    private EditText bJK;
    private TextView bJL;
    private TextView bJM;
    private ImageView bJN;
    private boolean bJO;
    private InputMethodManager bnb;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.activity_add_friend);
        this.bnb = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        FZ();
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
                this.Vn = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.bJK != null) {
                    if (!StringUtils.isNull(this.Vn)) {
                        this.bJK.setText(this.Vn);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.bJK.setText(String.valueOf(getPageContext().getString(i.h.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.bJK.setText(String.valueOf(getPageContext().getString(i.h.i_am_come_from)) + stringExtra + getPageContext().getString(i.h.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.bJK.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.bJO = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Vn = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.bJK != null) {
            if (!StringUtils.isNull(this.Vn)) {
                this.bJK.setText(this.Vn);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.bJK.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.bJO = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.bJK != null && !TextUtils.isEmpty(this.bJK.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.bJK.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.bJO);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Vn);
        }
    }

    private void FZ() {
        this.aET = getPageContext().getPageActivity().findViewById(i.f.search_friend_parent);
        this.aET.setOnClickListener(new b(this));
        this.bJN = (ImageView) getPageContext().getPageActivity().findViewById(i.f.cancle);
        this.bJN.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(i.f.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(i.h.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bJL = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.bJL.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(i.d.ds94);
        this.bJL.setLayoutParams(layoutParams);
        this.bJL.setBackgroundResource(i.e.s_navbar_button_bg);
        this.bJL.setOnClickListener(new d(this));
        this.bJM = (TextView) getPageContext().getPageActivity().findViewById(i.f.search_friend_tip);
        this.bJK = (EditText) getPageContext().getPageActivity().findViewById(i.f.search_friend_input);
        this.bJK.setOnFocusChangeListener(new e(this));
        this.bJK.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.g.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(i.h.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.bnb, this.bJK);
        this.bJK.setSelection(this.bJK.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.bnb, this.bJK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().k(this.aET);
        this.bJM.setTextColor(an.getColor(i.c.cp_cont_c));
        this.bJL.setTextColor(an.getColor(i.c.cp_cont_i));
        an.i((View) this.bJL, i.e.s_navbar_button_bg);
    }
}
