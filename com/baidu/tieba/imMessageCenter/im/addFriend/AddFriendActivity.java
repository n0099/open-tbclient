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
    private String Vl;
    private View aFZ;
    private EditText bJp;
    private TextView bJq;
    private TextView bJr;
    private ImageView bJs;
    private boolean bJt;
    private InputMethodManager bmx;
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
        this.bmx = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        Gc();
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
                this.Vl = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.bJp != null) {
                    if (!StringUtils.isNull(this.Vl)) {
                        this.bJp.setText(this.Vl);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.bJp.setText(String.valueOf(getPageContext().getString(i.h.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.bJp.setText(String.valueOf(getPageContext().getString(i.h.i_am_come_from)) + stringExtra + getPageContext().getString(i.h.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.bJp.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.bJt = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Vl = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.bJp != null) {
            if (!StringUtils.isNull(this.Vl)) {
                this.bJp.setText(this.Vl);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.bJp.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.bJt = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.bJp != null && !TextUtils.isEmpty(this.bJp.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.bJp.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.bJt);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Vl);
        }
    }

    private void Gc() {
        this.aFZ = getPageContext().getPageActivity().findViewById(i.f.search_friend_parent);
        this.aFZ.setOnClickListener(new b(this));
        this.bJs = (ImageView) getPageContext().getPageActivity().findViewById(i.f.cancle);
        this.bJs.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(i.f.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(i.h.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bJq = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.bJq.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(i.d.ds94);
        this.bJq.setLayoutParams(layoutParams);
        this.bJq.setBackgroundResource(i.e.s_navbar_button_bg);
        this.bJq.setOnClickListener(new d(this));
        this.bJr = (TextView) getPageContext().getPageActivity().findViewById(i.f.search_friend_tip);
        this.bJp = (EditText) getPageContext().getPageActivity().findViewById(i.f.search_friend_input);
        this.bJp.setOnFocusChangeListener(new e(this));
        this.bJp.setOnTouchListener(new f(this));
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
        ShowSoftKeyPad(this.bmx, this.bJp);
        this.bJp.setSelection(this.bJp.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.bmx, this.bJp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().k(this.aFZ);
        this.bJr.setTextColor(an.getColor(i.c.cp_cont_c));
        this.bJq.setTextColor(an.getColor(i.c.cp_cont_i));
        an.i((View) this.bJq, i.e.s_navbar_button_bg);
    }
}
