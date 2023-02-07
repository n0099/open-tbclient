package com.baidu.tieba.immessagecenter.im.addFriend;

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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.yb;
import com.baidu.tieba.zr7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputMethodManager a;
    public View b;
    public NavigationBar c;
    public EditText d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public String l;
    public String m;

    /* loaded from: classes5.dex */
    public class a extends yb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AddFriendActivity addFriendActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                int error = responseAddFriendMessage.getError();
                String errorString = responseAddFriendMessage.getErrorString();
                if (error == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001193, new zr7(this.a.h, this.a.j)));
                    if (this.a.k) {
                        AddFriendActivity addFriendActivity = this.a;
                        addFriendActivity.showToast(addFriendActivity.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                    } else {
                        AddFriendActivity addFriendActivity2 = this.a;
                        addFriendActivity2.showToast(addFriendActivity2.getPageContext().getPageActivity().getString(R.string.group_apply_succ), false);
                    }
                    this.a.finish();
                } else if (AntiHelper.m(error, errorString)) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), errorString);
                } else {
                    ej.Q(this.a.getPageContext().getPageActivity(), errorString);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddFriendActivity a;

        public b(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AddFriendActivity addFriendActivity = this.a;
                addFriendActivity.HidenSoftKeyPad(addFriendActivity.a, this.a.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddFriendActivity a;

        public c(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null) {
                this.a.d.setText("");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddFriendActivity a;

        public d(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AddFriendActivity addFriendActivity = this.a;
                addFriendActivity.HidenSoftKeyPad(addFriendActivity.a, this.a.d);
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                    this.a.showToast(R.string.plugin_not_install);
                    return;
                }
                this.a.G1(this.a.d.getText().toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddFriendActivity a;

        public e(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addFriendActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z) {
                    AddFriendActivity addFriendActivity = this.a;
                    addFriendActivity.ShowSoftKeyPad(addFriendActivity.a, this.a.d);
                    return;
                }
                AddFriendActivity addFriendActivity2 = this.a;
                addFriendActivity2.HidenSoftKeyPad(addFriendActivity2.a, this.a.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddFriendActivity a;

        public f(AddFriendActivity addFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addFriendActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.d.getParent() != null) {
                    this.a.d.getParent().requestDisallowInterceptTouchEvent(true);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            registerListener(new a(this, 304100));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            HidenSoftKeyPad(this.a, this.d);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            ShowSoftKeyPad(this.a, this.d);
            EditText editText = this.d;
            editText.setSelection(editText.getText().length());
        }
    }

    public final void E1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle == null) {
                Intent intent = getPageContext().getPageActivity().getIntent();
                if (intent != null) {
                    this.h = intent.getStringExtra("user_id");
                    String stringExtra = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                    this.m = stringExtra;
                    if (this.d != null) {
                        if (!StringUtils.isNull(stringExtra)) {
                            this.d.setText(this.m);
                        } else {
                            String stringExtra2 = intent.getStringExtra("from");
                            if (StringUtils.isNull(stringExtra2)) {
                                EditText editText = this.d;
                                editText.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0bfd) + TbadkCoreApplication.getCurrentAccountName());
                            } else {
                                EditText editText2 = this.d;
                                editText2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f093f) + stringExtra2 + getPageContext().getString(R.string.obfuscated_res_0x7f0f028b) + TbadkCoreApplication.getCurrentAccountName());
                            }
                        }
                        this.d.requestFocus();
                    }
                    this.i = intent.getStringExtra("portrait");
                    this.j = intent.getStringExtra("name_show");
                    this.k = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                    this.l = intent.getStringExtra("st_type");
                    return;
                }
                return;
            }
            this.h = bundle.getString("user_id");
            String string = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            this.m = string;
            if (this.d != null) {
                if (!StringUtils.isNull(string)) {
                    this.d.setText(this.m);
                } else {
                    String string2 = bundle.getString("msg");
                    if (!StringUtils.isNull(string2)) {
                        this.d.setText(string2);
                    }
                }
            }
            this.i = bundle.getString("portrait");
            this.j = bundle.getString("name_show");
            this.k = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
            this.l = bundle.getString("st_type");
        }
    }

    public final void G1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.i)) {
            if (TextUtils.isEmpty(str)) {
                str = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0bfd) + TbadkCoreApplication.getCurrentAccountName();
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(dh.g(this.h, 0L), this.j, this.i, str, this.l));
        }
    }

    public final void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View findViewById = getPageContext().getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ee3);
            this.b = findViewById;
            findViewById.setOnClickListener(new b(this));
            ImageView imageView = (ImageView) getPageContext().getPageActivity().findViewById(R.id.obfuscated_res_0x7f0904ba);
            this.g = imageView;
            imageView.setOnClickListener(new c(this));
            NavigationBar navigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ee2);
            this.c = navigationBar;
            navigationBar.setTitleText(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f02aa));
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
            this.e = addTextButton;
            if (addTextButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
                layoutParams.rightMargin = ej.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
                this.e.setLayoutParams(layoutParams);
            }
            this.e.setOnClickListener(new d(this));
            this.f = (TextView) getPageContext().getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ee4);
            EditText editText = (EditText) getPageContext().getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ee1);
            this.d = editText;
            editText.setOnFocusChangeListener(new e(this));
            this.d.setOnTouchListener(new f(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.c.onChangeSkinType(getPageContext(), i);
            getLayoutMode().k(this.b);
            this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.e.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            SkinManager.setBackgroundResource(this.e, R.drawable.s_navbar_button_bg);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0028);
            this.a = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
            initViews();
            E1(bundle);
            F1();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("user_id", this.h);
                EditText editText = this.d;
                if (editText != null && !TextUtils.isEmpty(editText.getText().toString())) {
                    bundle.putString("msg", this.d.getText().toString());
                }
                bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.k);
                bundle.putString("portrait", this.i);
                bundle.putString("name_show", this.j);
                bundle.putString("st_type", this.l);
                bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.m);
            }
        }
    }
}
