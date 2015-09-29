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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String Vj;
    private View aFO;
    private EditText bJe;
    private TextView bJf;
    private TextView bJg;
    private ImageView bJh;
    private boolean bJi;
    private InputMethodManager bmm;
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
        this.bmm = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        Gg();
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
                this.Vj = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.bJe != null) {
                    if (!StringUtils.isNull(this.Vj)) {
                        this.bJe.setText(this.Vj);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.bJe.setText(String.valueOf(getPageContext().getString(i.h.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.bJe.setText(String.valueOf(getPageContext().getString(i.h.i_am_come_from)) + stringExtra + getPageContext().getString(i.h.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.bJe.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.bJi = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Vj = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.bJe != null) {
            if (!StringUtils.isNull(this.Vj)) {
                this.bJe.setText(this.Vj);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.bJe.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.bJi = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.bJe != null && !TextUtils.isEmpty(this.bJe.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.bJe.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.bJi);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Vj);
        }
    }

    private void Gg() {
        this.aFO = getPageContext().getPageActivity().findViewById(i.f.search_friend_parent);
        this.aFO.setOnClickListener(new b(this));
        this.bJh = (ImageView) getPageContext().getPageActivity().findViewById(i.f.cancle);
        this.bJh.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(i.f.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(i.h.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bJf = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.bJf.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(i.d.ds94);
        this.bJf.setLayoutParams(layoutParams);
        this.bJf.setBackgroundResource(i.e.s_navbar_button_bg);
        this.bJf.setOnClickListener(new d(this));
        this.bJg = (TextView) getPageContext().getPageActivity().findViewById(i.f.search_friend_tip);
        this.bJe = (EditText) getPageContext().getPageActivity().findViewById(i.f.search_friend_input);
        this.bJe.setOnFocusChangeListener(new e(this));
        this.bJe.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.g.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(i.h.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.bmm, this.bJe);
        this.bJe.setSelection(this.bJe.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.bmm, this.bJe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().k(this.aFO);
        this.bJg.setTextColor(am.getColor(i.c.cp_cont_c));
        this.bJf.setTextColor(am.getColor(i.c.cp_cont_i));
        am.i((View) this.bJf, i.e.s_navbar_button_bg);
    }
}
