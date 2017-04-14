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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private View aXy;
    private InputMethodManager cjw;
    private EditText dgR;
    private TextView dgS;
    private TextView dgT;
    private ImageView dgU;
    private boolean dgV;
    private String dgW;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.activity_add_friend);
        this.cjw = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
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
                this.dgW = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.dgR != null) {
                    if (!StringUtils.isNull(this.dgW)) {
                        this.dgR.setText(this.dgW);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.dgR.setText(String.valueOf(getPageContext().getString(w.l.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.dgR.setText(String.valueOf(getPageContext().getString(w.l.i_am_come_from)) + stringExtra + getPageContext().getString(w.l.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.dgR.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.dgV = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.dgW = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.dgR != null) {
            if (!StringUtils.isNull(this.dgW)) {
                this.dgR.setText(this.dgW);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.dgR.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.dgV = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.dgR != null && !TextUtils.isEmpty(this.dgR.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.dgR.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.dgV);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.dgW);
        }
    }

    private void initViews() {
        this.aXy = getPageContext().getPageActivity().findViewById(w.h.search_friend_parent);
        this.aXy.setOnClickListener(new b(this));
        this.dgU = (ImageView) getPageContext().getPageActivity().findViewById(w.h.cancle);
        this.dgU.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(w.h.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(w.l.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dgS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.send_msg));
        if (this.dgS.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgS.getLayoutParams();
            layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), w.f.ds16);
            this.dgS.setLayoutParams(layoutParams);
        }
        this.dgS.setOnClickListener(new d(this));
        this.dgT = (TextView) getPageContext().getPageActivity().findViewById(w.h.search_friend_tip);
        this.dgR = (EditText) getPageContext().getPageActivity().findViewById(w.h.search_friend_input);
        this.dgR.setOnFocusChangeListener(new e(this));
        this.dgR.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.g.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(w.l.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.cjw, this.dgR);
        this.dgR.setSelection(this.dgR.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.cjw, this.dgR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().t(this.aXy);
        this.dgT.setTextColor(aq.getColor(w.e.cp_cont_c));
        this.dgS.setTextColor(aq.getColor(w.e.cp_cont_i));
        aq.j(this.dgS, w.g.s_navbar_button_bg);
    }
}
