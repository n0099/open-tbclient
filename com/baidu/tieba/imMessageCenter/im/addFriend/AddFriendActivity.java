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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String QE;
    private InputMethodManager aXu;
    private View azo;
    private EditText brD;
    private TextView brE;
    private TextView brF;
    private ImageView brG;
    private boolean brH;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.activity_add_friend);
        this.aXu = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        FL();
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
                this.QE = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.brD != null) {
                    if (!StringUtils.isNull(this.QE)) {
                        this.brD.setText(this.QE);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.brD.setText(String.valueOf(getPageContext().getString(t.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.brD.setText(String.valueOf(getPageContext().getString(t.i_am_come_from)) + stringExtra + getPageContext().getString(t.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.brD.requestFocus();
                }
                this.portrait = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
                this.name = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW);
                this.brH = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.QE = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.brD != null) {
            if (!StringUtils.isNull(this.QE)) {
                this.brD.setText(this.QE);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.brD.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
        this.name = bundle.getString(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW);
        this.brH = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.brD != null && !TextUtils.isEmpty(this.brD.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.brD.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.brH);
            bundle.putString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT, this.portrait);
            bundle.putString(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.QE);
        }
    }

    private void FL() {
        this.azo = getPageContext().getPageActivity().findViewById(q.search_friend_parent);
        this.azo.setOnClickListener(new b(this));
        this.brG = (ImageView) getPageContext().getPageActivity().findViewById(q.cancle);
        this.brG.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(q.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(t.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.brE = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.brE.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(o.ds94);
        this.brE.setLayoutParams(layoutParams);
        this.brE.setBackgroundResource(p.btn_titlebar_finish);
        this.brE.setOnClickListener(new d(this));
        this.brF = (TextView) getPageContext().getPageActivity().findViewById(q.search_friend_tip);
        this.brD = (EditText) getPageContext().getPageActivity().findViewById(q.search_friend_input);
        this.brD.setOnFocusChangeListener(new e(this));
        this.brD.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.g.c.c(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(t.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.aXu, this.brD);
        this.brD.setSelection(this.brD.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.aXu, this.brD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().j(this.azo);
        this.brF.setTextColor(ay.getColor(n.cp_cont_c));
        this.brE.setTextColor(ay.getColor(n.cp_cont_i));
        ay.i((View) this.brE, p.btn_titlebar_finish);
    }
}
