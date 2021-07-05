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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AddFriendActivity f17699a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AddFriendActivity addFriendActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17699a = addFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                int error = responseAddFriendMessage.getError();
                String errorString = responseAddFriendMessage.getErrorString();
                if (error == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001193, new d.a.s0.j1.a.a.a(this.f17699a.userId, this.f17699a.name)));
                    if (this.f17699a.isLower) {
                        AddFriendActivity addFriendActivity = this.f17699a;
                        addFriendActivity.showToast(addFriendActivity.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                    } else {
                        AddFriendActivity addFriendActivity2 = this.f17699a;
                        addFriendActivity2.showToast(addFriendActivity2.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                    }
                    this.f17699a.finish();
                } else if (AntiHelper.m(error, errorString)) {
                    AntiHelper.u(this.f17699a.getPageContext().getPageActivity(), errorString);
                } else {
                    l.M(this.f17699a.getPageContext().getPageActivity(), errorString);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AddFriendActivity f17700e;

        public b(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17700e = addFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AddFriendActivity addFriendActivity = this.f17700e;
                addFriendActivity.HidenSoftKeyPad(addFriendActivity.mInputMethodManager, this.f17700e.mSayInput);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AddFriendActivity f17701e;

        public c(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17701e = addFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17701e.mSayInput == null) {
                return;
            }
            this.f17701e.mSayInput.setText("");
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AddFriendActivity f17702e;

        public d(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17702e = addFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AddFriendActivity addFriendActivity = this.f17702e;
                addFriendActivity.HidenSoftKeyPad(addFriendActivity.mInputMethodManager, this.f17702e.mSayInput);
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                    this.f17702e.requestFriendData(this.f17702e.mSayInput.getText().toString());
                    return;
                }
                this.f17702e.showToast(R.string.plugin_not_install);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AddFriendActivity f17703e;

        public e(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17703e = addFriendActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    AddFriendActivity addFriendActivity = this.f17703e;
                    addFriendActivity.ShowSoftKeyPad(addFriendActivity.mInputMethodManager, this.f17703e.mSayInput);
                    return;
                }
                AddFriendActivity addFriendActivity2 = this.f17703e;
                addFriendActivity2.HidenSoftKeyPad(addFriendActivity2.mInputMethodManager, this.f17703e.mSayInput);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AddFriendActivity f17704e;

        public f(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17704e = addFriendActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f17704e.mSayInput.getParent() != null) {
                    this.f17704e.mSayInput.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public AddFriendActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, bundle) == null) {
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
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            registerListener(new a(this, 304100));
        }
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            View findViewById = getPageContext().getPageActivity().findViewById(R.id.search_friend_parent);
            this.mParentView = findViewById;
            findViewById.setOnClickListener(new b(this));
            ImageView imageView = (ImageView) getPageContext().getPageActivity().findViewById(R.id.cancle);
            this.mCancel = imageView;
            imageView.setOnClickListener(new c(this));
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
            this.mSayBtn.setOnClickListener(new d(this));
            this.mSayTip = (TextView) getPageContext().getPageActivity().findViewById(R.id.search_friend_tip);
            EditText editText = (EditText) getPageContext().getPageActivity().findViewById(R.id.search_friend_input);
            this.mSayInput = editText;
            editText.setOnFocusChangeListener(new e(this));
            this.mSayInput.setOnTouchListener(new f(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFriendData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, str) == null) || TextUtils.isEmpty(this.userId) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.portrait)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = getPageContext().getPageActivity().getString(R.string.my_name_is) + TbadkCoreApplication.getCurrentAccountName();
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(d.a.c.e.m.b.f(this.userId, 0L), this.name, this.portrait, str, this.st_type));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().j(this.mParentView);
            this.mSayTip.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.mSayBtn.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            SkinManager.setBackgroundResource(this.mSayBtn, R.drawable.s_navbar_button_bg);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_add_friend);
            this.mInputMethodManager = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
            initViews();
            initData(bundle);
            initListener();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onPause();
            HidenSoftKeyPad(this.mInputMethodManager, this.mSayInput);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            ShowSoftKeyPad(this.mInputMethodManager, this.mSayInput);
            EditText editText = this.mSayInput;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
}
