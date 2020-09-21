package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes21.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private View ftd;
    private InputMethodManager iIR;
    private EditText jJq;
    private TextView jJr;
    private TextView jJs;
    private ImageView jJt;
    private boolean jJu;
    private String jJv;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_friend);
        this.iIR = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        initViews();
        initData(bundle);
        initListener();
    }

    private void initListener() {
        registerListener(new c(CmdConfigSocket.CMD_ADD_NEW_FRIEND) { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                    ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                    int error = responseAddFriendMessage.getError();
                    String errorString = responseAddFriendMessage.getErrorString();
                    if (error == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND, new a(AddFriendActivity.this.userId, AddFriendActivity.this.name)));
                        if (AddFriendActivity.this.jJu) {
                            AddFriendActivity.this.showToast(AddFriendActivity.this.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                        } else {
                            AddFriendActivity.this.showToast(AddFriendActivity.this.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                        }
                        AddFriendActivity.this.finish();
                    } else if (AntiHelper.bC(error, errorString)) {
                        AntiHelper.bh(AddFriendActivity.this.getPageContext().getPageActivity(), errorString);
                    } else {
                        l.showToast(AddFriendActivity.this.getPageContext().getPageActivity(), errorString);
                    }
                }
            }
        });
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra("user_id");
                this.jJv = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.jJq != null) {
                    if (!StringUtils.isNull(this.jJv)) {
                        this.jJq.setText(this.jJv);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.jJq.setText(getPageContext().getString(R.string.my_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.jJq.setText(getPageContext().getString(R.string.i_am_come_from) + stringExtra + getPageContext().getString(R.string.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.jJq.requestFocus();
                }
                this.portrait = intent.getStringExtra("portrait");
                this.name = intent.getStringExtra("name_show");
                this.jJu = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.jJv = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.jJq != null) {
            if (!StringUtils.isNull(this.jJv)) {
                this.jJq.setText(this.jJv);
            } else {
                String string = bundle.getString("msg");
                if (!StringUtils.isNull(string)) {
                    this.jJq.setText(string);
                }
            }
        }
        this.portrait = bundle.getString("portrait");
        this.name = bundle.getString("name_show");
        this.jJu = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.jJq != null && !TextUtils.isEmpty(this.jJq.getText().toString())) {
                bundle.putString("msg", this.jJq.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.jJu);
            bundle.putString("portrait", this.portrait);
            bundle.putString("name_show", this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.jJv);
        }
    }

    private void initViews() {
        this.ftd = getPageContext().getPageActivity().findViewById(R.id.search_friend_parent);
        this.ftd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddFriendActivity.this.HidenSoftKeyPad(AddFriendActivity.this.iIR, AddFriendActivity.this.jJq);
            }
        });
        this.jJt = (ImageView) getPageContext().getPageActivity().findViewById(R.id.cancle);
        this.jJt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddFriendActivity.this.jJq != null) {
                    AddFriendActivity.this.jJq.setText("");
                }
            }
        });
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(R.id.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(R.string.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jJr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
        if (this.jJr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jJr.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
            this.jJr.setLayoutParams(layoutParams);
        }
        this.jJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddFriendActivity.this.HidenSoftKeyPad(AddFriendActivity.this.iIR, AddFriendActivity.this.jJq);
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                    AddFriendActivity.this.Em(AddFriendActivity.this.jJq.getText().toString());
                    return;
                }
                AddFriendActivity.this.showToast(R.string.plugin_not_install);
            }
        });
        this.jJs = (TextView) getPageContext().getPageActivity().findViewById(R.id.search_friend_tip);
        this.jJq = (EditText) getPageContext().getPageActivity().findViewById(R.id.search_friend_input);
        this.jJq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    AddFriendActivity.this.ShowSoftKeyPad(AddFriendActivity.this.iIR, AddFriendActivity.this.jJq);
                } else {
                    AddFriendActivity.this.HidenSoftKeyPad(AddFriendActivity.this.iIR, AddFriendActivity.this.jJq);
                }
            }
        });
        this.jJq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AddFriendActivity.this.jJq.getParent() != null) {
                    AddFriendActivity.this.jJq.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Em(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(b.toLong(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? getPageContext().getPageActivity().getString(R.string.my_name_is) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.iIR, this.jJq);
        this.jJq.setSelection(this.jJq.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.iIR, this.jJq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().onModeChanged(this.ftd);
        this.jJs.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.jJr.setTextColor(ap.getColor(R.color.cp_cont_a));
        ap.setBackgroundResource(this.jJr, R.drawable.s_navbar_button_bg);
    }
}
