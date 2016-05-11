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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String Pp;
    private View aJB;
    private InputMethodManager bHm;
    private EditText csQ;
    private TextView csR;
    private TextView csS;
    private ImageView csT;
    private boolean csU;
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
        this.bHm = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        initViews();
        initData(bundle);
        lr();
    }

    private void lr() {
        registerListener(new a(this, 304100));
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra("user_id");
                this.Pp = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.csQ != null) {
                    if (!StringUtils.isNull(this.Pp)) {
                        this.csQ.setText(this.Pp);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.csQ.setText(String.valueOf(getPageContext().getString(t.j.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.csQ.setText(String.valueOf(getPageContext().getString(t.j.i_am_come_from)) + stringExtra + getPageContext().getString(t.j.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.csQ.requestFocus();
                }
                this.portrait = intent.getStringExtra(IntentConfig.PORTRAIT);
                this.name = intent.getStringExtra(IntentConfig.NAME_SHOW);
                this.csU = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Pp = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.csQ != null) {
            if (!StringUtils.isNull(this.Pp)) {
                this.csQ.setText(this.Pp);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.csQ.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(IntentConfig.PORTRAIT);
        this.name = bundle.getString(IntentConfig.NAME_SHOW);
        this.csU = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.csQ != null && !TextUtils.isEmpty(this.csQ.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.csQ.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.csU);
            bundle.putString(IntentConfig.PORTRAIT, this.portrait);
            bundle.putString(IntentConfig.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Pp);
        }
    }

    private void initViews() {
        this.aJB = getPageContext().getPageActivity().findViewById(t.g.search_friend_parent);
        this.aJB.setOnClickListener(new b(this));
        this.csT = (ImageView) getPageContext().getPageActivity().findViewById(t.g.cancle);
        this.csT.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(t.g.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(t.j.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.group_apply_send));
        if (this.csR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csR.getLayoutParams();
            layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), t.e.ds16);
            this.csR.setLayoutParams(layoutParams);
        }
        this.csR.setOnClickListener(new d(this));
        this.csS = (TextView) getPageContext().getPageActivity().findViewById(t.g.search_friend_tip);
        this.csQ = (EditText) getPageContext().getPageActivity().findViewById(t.g.search_friend_input);
        this.csQ.setOnFocusChangeListener(new e(this));
        this.csQ.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gN(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.h.b.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(t.j.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.bHm, this.csQ);
        this.csQ.setSelection(this.csQ.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.bHm, this.csQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().x(this.aJB);
        this.csS.setTextColor(at.getColor(t.d.cp_cont_c));
        this.csR.setTextColor(at.getColor(t.d.cp_cont_i));
        at.k(this.csR, t.f.s_navbar_button_bg);
    }
}
