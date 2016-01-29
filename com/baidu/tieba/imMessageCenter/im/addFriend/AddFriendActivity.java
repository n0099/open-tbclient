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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String Wh;
    private View aKv;
    private InputMethodManager bBG;
    private EditText cho;
    private TextView chp;
    private TextView chq;
    private ImageView chr;
    private boolean chs;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.activity_add_friend);
        this.bBG = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        initViews();
        initData(bundle);
        pm();
    }

    private void pm() {
        registerListener(new a(this, 304100));
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra("user_id");
                this.Wh = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.cho != null) {
                    if (!StringUtils.isNull(this.Wh)) {
                        this.cho.setText(this.Wh);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.cho.setText(String.valueOf(getPageContext().getString(t.j.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.cho.setText(String.valueOf(getPageContext().getString(t.j.i_am_come_from)) + stringExtra + getPageContext().getString(t.j.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.cho.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.chs = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Wh = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.cho != null) {
            if (!StringUtils.isNull(this.Wh)) {
                this.cho.setText(this.Wh);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.cho.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.chs = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.cho != null && !TextUtils.isEmpty(this.cho.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.cho.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.chs);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Wh);
        }
    }

    private void initViews() {
        this.aKv = getPageContext().getPageActivity().findViewById(t.g.search_friend_parent);
        this.aKv.setOnClickListener(new b(this));
        this.chr = (ImageView) getPageContext().getPageActivity().findViewById(t.g.cancle);
        this.chr.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(t.g.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(t.j.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.chp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.group_apply_send));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.chp.getLayoutParams();
        layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.chp.setLayoutParams(layoutParams);
        this.chp.setOnClickListener(new d(this));
        this.chq = (TextView) getPageContext().getPageActivity().findViewById(t.g.search_friend_tip);
        this.cho = (EditText) getPageContext().getPageActivity().findViewById(t.g.search_friend_input);
        this.cho.setOnFocusChangeListener(new e(this));
        this.cho.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gA(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.h.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(t.j.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.bBG, this.cho);
        this.cho.setSelection(this.cho.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.bBG, this.cho);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().x(this.aKv);
        this.chq.setTextColor(ar.getColor(t.d.cp_cont_c));
        this.chp.setTextColor(ar.getColor(t.d.cp_cont_i));
        ar.k(this.chp, t.f.s_navbar_button_bg);
    }
}
