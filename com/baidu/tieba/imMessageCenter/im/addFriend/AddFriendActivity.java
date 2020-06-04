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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes9.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private View ePH;
    private InputMethodManager hSM;
    private EditText iMk;
    private TextView iMl;
    private TextView iMm;
    private ImageView iMn;
    private boolean iMo;
    private String iMp;
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
        this.hSM = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
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
                        if (AddFriendActivity.this.iMo) {
                            AddFriendActivity.this.showToast(AddFriendActivity.this.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                        } else {
                            AddFriendActivity.this.showToast(AddFriendActivity.this.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                        }
                        AddFriendActivity.this.finish();
                    } else if (AntiHelper.bv(error, errorString)) {
                        AntiHelper.aX(AddFriendActivity.this.getPageContext().getPageActivity(), errorString);
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
                this.iMp = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.iMk != null) {
                    if (!StringUtils.isNull(this.iMp)) {
                        this.iMk.setText(this.iMp);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.iMk.setText(getPageContext().getString(R.string.my_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.iMk.setText(getPageContext().getString(R.string.i_am_come_from) + stringExtra + getPageContext().getString(R.string.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.iMk.requestFocus();
                }
                this.portrait = intent.getStringExtra("portrait");
                this.name = intent.getStringExtra("name_show");
                this.iMo = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.iMp = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.iMk != null) {
            if (!StringUtils.isNull(this.iMp)) {
                this.iMk.setText(this.iMp);
            } else {
                String string = bundle.getString("msg");
                if (!StringUtils.isNull(string)) {
                    this.iMk.setText(string);
                }
            }
        }
        this.portrait = bundle.getString("portrait");
        this.name = bundle.getString("name_show");
        this.iMo = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.iMk != null && !TextUtils.isEmpty(this.iMk.getText().toString())) {
                bundle.putString("msg", this.iMk.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.iMo);
            bundle.putString("portrait", this.portrait);
            bundle.putString("name_show", this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.iMp);
        }
    }

    private void initViews() {
        this.ePH = getPageContext().getPageActivity().findViewById(R.id.search_friend_parent);
        this.ePH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddFriendActivity.this.HidenSoftKeyPad(AddFriendActivity.this.hSM, AddFriendActivity.this.iMk);
            }
        });
        this.iMn = (ImageView) getPageContext().getPageActivity().findViewById(R.id.cancle);
        this.iMn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddFriendActivity.this.iMk != null) {
                    AddFriendActivity.this.iMk.setText("");
                }
            }
        });
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(R.id.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(R.string.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
        if (this.iMl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iMl.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
            this.iMl.setLayoutParams(layoutParams);
        }
        this.iMl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddFriendActivity.this.HidenSoftKeyPad(AddFriendActivity.this.hSM, AddFriendActivity.this.iMk);
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                    AddFriendActivity.this.Aq(AddFriendActivity.this.iMk.getText().toString());
                    return;
                }
                AddFriendActivity.this.showToast(R.string.plugin_not_install);
            }
        });
        this.iMm = (TextView) getPageContext().getPageActivity().findViewById(R.id.search_friend_tip);
        this.iMk = (EditText) getPageContext().getPageActivity().findViewById(R.id.search_friend_input);
        this.iMk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    AddFriendActivity.this.ShowSoftKeyPad(AddFriendActivity.this.hSM, AddFriendActivity.this.iMk);
                } else {
                    AddFriendActivity.this.HidenSoftKeyPad(AddFriendActivity.this.hSM, AddFriendActivity.this.iMk);
                }
            }
        });
        this.iMk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AddFriendActivity.this.iMk.getParent() != null) {
                    AddFriendActivity.this.iMk.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(b.toLong(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? getPageContext().getPageActivity().getString(R.string.my_name_is) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.hSM, this.iMk);
        this.iMk.setSelection(this.iMk.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.hSM, this.iMk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().onModeChanged(this.ePH);
        this.iMm.setTextColor(am.getColor(R.color.cp_cont_c));
        this.iMl.setTextColor(am.getColor(R.color.cp_cont_a));
        am.setBackgroundResource(this.iMl, R.drawable.s_navbar_button_bg);
    }
}
