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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String Vr;
    private View aGI;
    private EditText bFs;
    private TextView bFt;
    private TextView bFu;
    private ImageView bFv;
    private boolean bFw;
    private InputMethodManager blt;
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
        this.blt = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        Gy();
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
                this.Vr = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.bFs != null) {
                    if (!StringUtils.isNull(this.Vr)) {
                        this.bFs.setText(this.Vr);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.bFs.setText(String.valueOf(getPageContext().getString(i.C0057i.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.bFs.setText(String.valueOf(getPageContext().getString(i.C0057i.i_am_come_from)) + stringExtra + getPageContext().getString(i.C0057i.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.bFs.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.bFw = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Vr = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.bFs != null) {
            if (!StringUtils.isNull(this.Vr)) {
                this.bFs.setText(this.Vr);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.bFs.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.bFw = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.bFs != null && !TextUtils.isEmpty(this.bFs.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.bFs.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.bFw);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Vr);
        }
    }

    private void Gy() {
        this.aGI = getPageContext().getPageActivity().findViewById(i.f.search_friend_parent);
        this.aGI.setOnClickListener(new b(this));
        this.bFv = (ImageView) getPageContext().getPageActivity().findViewById(i.f.cancle);
        this.bFv.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(i.f.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(i.C0057i.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bFt = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.C0057i.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.bFt.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(i.d.ds94);
        this.bFt.setLayoutParams(layoutParams);
        this.bFt.setBackgroundResource(i.e.btn_titlebar_finish);
        this.bFt.setOnClickListener(new d(this));
        this.bFu = (TextView) getPageContext().getPageActivity().findViewById(i.f.search_friend_tip);
        this.bFs = (EditText) getPageContext().getPageActivity().findViewById(i.f.search_friend_input);
        this.bFs.setOnFocusChangeListener(new e(this));
        this.bFs.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fX(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.g.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(i.C0057i.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.blt, this.bFs);
        this.bFs.setSelection(this.bFs.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.blt, this.bFs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().k(this.aGI);
        this.bFu.setTextColor(al.getColor(i.c.cp_cont_c));
        this.bFt.setTextColor(al.getColor(i.c.cp_cont_i));
        al.i((View) this.bFt, i.e.btn_titlebar_finish);
    }
}
