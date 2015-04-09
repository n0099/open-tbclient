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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String Qi;
    private InputMethodManager aUN;
    private View axC;
    private EditText boX;
    private TextView boY;
    private TextView boZ;
    private ImageView bpa;
    private boolean bpb;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_add_friend);
        this.aUN = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        EP();
        initData(bundle);
        HH();
    }

    private void HH() {
        registerListener(new a(this, 304100));
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra("user_id");
                this.Qi = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.boX != null) {
                    if (!StringUtils.isNull(this.Qi)) {
                        this.boX.setText(this.Qi);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.boX.setText(String.valueOf(getPageContext().getString(y.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.boX.setText(String.valueOf(getPageContext().getString(y.i_am_come_from)) + stringExtra + getPageContext().getString(y.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.boX.requestFocus();
                }
                this.portrait = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.name = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.bpb = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Qi = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.boX != null) {
            if (!StringUtils.isNull(this.Qi)) {
                this.boX.setText(this.Qi);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.boX.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.name = bundle.getString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.bpb = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.boX != null && !TextUtils.isEmpty(this.boX.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.boX.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.bpb);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Qi);
        }
    }

    private void EP() {
        this.axC = getPageContext().getPageActivity().findViewById(v.search_friend_parent);
        this.axC.setOnClickListener(new b(this));
        this.bpa = (ImageView) getPageContext().getPageActivity().findViewById(v.cancle);
        this.bpa.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(v.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(y.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.boY = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(y.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.boY.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(t.ds94);
        this.boY.setLayoutParams(layoutParams);
        this.boY.setBackgroundResource(u.btn_titlebar_finish);
        this.boY.setOnClickListener(new d(this));
        this.boZ = (TextView) getPageContext().getPageActivity().findViewById(v.search_friend_tip);
        this.boX = (EditText) getPageContext().getPageActivity().findViewById(v.search_friend_input);
        this.boX.setOnFocusChangeListener(new e(this));
        this.boX.setOnTouchListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.g.c.a(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(y.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.aUN, this.boX);
        this.boX.setSelection(this.boX.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.aUN, this.boX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().h(this.axC);
        this.boZ.setTextColor(ba.getColor(s.cp_cont_c));
        this.boY.setTextColor(ba.getColor(s.cp_cont_i));
        ba.i((View) this.boY, u.btn_titlebar_finish);
    }
}
