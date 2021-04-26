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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    public String defaultMessage;
    public boolean isLower;
    public ImageView mCancel;
    public InputMethodManager mInputMethodManager;
    public NavigationBar mNavigationBar;
    public View mParentView;
    public TextView mSayBtn;
    public EditText mSayInput;
    public TextView mSayTip;
    public String name;
    public String portrait;
    public String st_type;
    public String userId;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                int error = responseAddFriendMessage.getError();
                String errorString = responseAddFriendMessage.getErrorString();
                if (error == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001193, new d.a.j0.f1.a.a.a(AddFriendActivity.this.userId, AddFriendActivity.this.name)));
                    if (AddFriendActivity.this.isLower) {
                        AddFriendActivity addFriendActivity = AddFriendActivity.this;
                        addFriendActivity.showToast(addFriendActivity.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                    } else {
                        AddFriendActivity addFriendActivity2 = AddFriendActivity.this;
                        addFriendActivity2.showToast(addFriendActivity2.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                    }
                    AddFriendActivity.this.finish();
                } else if (AntiHelper.m(error, errorString)) {
                    AntiHelper.u(AddFriendActivity.this.getPageContext().getPageActivity(), errorString);
                } else {
                    l.M(AddFriendActivity.this.getPageContext().getPageActivity(), errorString);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AddFriendActivity addFriendActivity = AddFriendActivity.this;
            addFriendActivity.HidenSoftKeyPad(addFriendActivity.mInputMethodManager, AddFriendActivity.this.mSayInput);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AddFriendActivity.this.mSayInput != null) {
                AddFriendActivity.this.mSayInput.setText("");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AddFriendActivity addFriendActivity = AddFriendActivity.this;
            addFriendActivity.HidenSoftKeyPad(addFriendActivity.mInputMethodManager, AddFriendActivity.this.mSayInput);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                AddFriendActivity.this.requestFriendData(AddFriendActivity.this.mSayInput.getText().toString());
                return;
            }
            AddFriendActivity.this.showToast(R.string.plugin_not_install);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                AddFriendActivity addFriendActivity = AddFriendActivity.this;
                addFriendActivity.ShowSoftKeyPad(addFriendActivity.mInputMethodManager, AddFriendActivity.this.mSayInput);
                return;
            }
            AddFriendActivity addFriendActivity2 = AddFriendActivity.this;
            addFriendActivity2.HidenSoftKeyPad(addFriendActivity2.mInputMethodManager, AddFriendActivity.this.mSayInput);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AddFriendActivity.this.mSayInput.getParent() != null) {
                AddFriendActivity.this.mSayInput.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
            return false;
        }
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra("user_id");
                String stringExtra = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                this.defaultMessage = stringExtra;
                if (this.mSayInput != null) {
                    if (!StringUtils.isNull(stringExtra)) {
                        this.mSayInput.setText(this.defaultMessage);
                    } else {
                        String stringExtra2 = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra2)) {
                            EditText editText = this.mSayInput;
                            editText.setText(getPageContext().getString(R.string.my_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            EditText editText2 = this.mSayInput;
                            editText2.setText(getPageContext().getString(R.string.i_am_come_from) + stringExtra2 + getPageContext().getString(R.string.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.mSayInput.requestFocus();
                }
                this.portrait = intent.getStringExtra("portrait");
                this.name = intent.getStringExtra("name_show");
                this.isLower = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        String string = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        this.defaultMessage = string;
        if (this.mSayInput != null) {
            if (!StringUtils.isNull(string)) {
                this.mSayInput.setText(this.defaultMessage);
            } else {
                String string2 = bundle.getString("msg");
                if (!StringUtils.isNull(string2)) {
                    this.mSayInput.setText(string2);
                }
            }
        }
        this.portrait = bundle.getString("portrait");
        this.name = bundle.getString("name_show");
        this.isLower = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    private void initListener() {
        registerListener(new a(304100));
    }

    private void initViews() {
        View findViewById = getPageContext().getPageActivity().findViewById(R.id.search_friend_parent);
        this.mParentView = findViewById;
        findViewById.setOnClickListener(new b());
        ImageView imageView = (ImageView) getPageContext().getPageActivity().findViewById(R.id.cancle);
        this.mCancel = imageView;
        imageView.setOnClickListener(new c());
        NavigationBar navigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(R.id.search_friend_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setTitleText(getPageContext().getPageActivity().getString(R.string.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
        this.mSayBtn = addTextButton;
        if (addTextButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mSayBtn.getLayoutParams();
            layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
            this.mSayBtn.setLayoutParams(layoutParams);
        }
        this.mSayBtn.setOnClickListener(new d());
        this.mSayTip = (TextView) getPageContext().getPageActivity().findViewById(R.id.search_friend_tip);
        EditText editText = (EditText) getPageContext().getPageActivity().findViewById(R.id.search_friend_input);
        this.mSayInput = editText;
        editText.setOnFocusChangeListener(new e());
        this.mSayInput.setOnTouchListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFriendData(String str) {
        if (TextUtils.isEmpty(this.userId) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.portrait)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = getPageContext().getPageActivity().getString(R.string.my_name_is) + TbadkCoreApplication.getCurrentAccountName();
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(d.a.c.e.m.b.f(this.userId, 0L), this.name, this.portrait, str, this.st_type));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        getLayoutMode().j(this.mParentView);
        this.mSayTip.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.mSayBtn.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
        SkinManager.setBackgroundResource(this.mSayBtn, R.drawable.s_navbar_button_bg);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_friend);
        this.mInputMethodManager = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        initViews();
        initData(bundle);
        initListener();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.mInputMethodManager, this.mSayInput);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.mInputMethodManager, this.mSayInput);
        EditText editText = this.mSayInput;
        editText.setSelection(editText.getText().length());
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            EditText editText = this.mSayInput;
            if (editText != null && !TextUtils.isEmpty(editText.getText().toString())) {
                bundle.putString("msg", this.mSayInput.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.isLower);
            bundle.putString("portrait", this.portrait);
            bundle.putString("name_show", this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.defaultMessage);
        }
    }
}
