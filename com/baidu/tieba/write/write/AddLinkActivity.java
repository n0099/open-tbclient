package com.baidu.tieba.write.write;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.ik5;
import com.baidu.tieba.mj5;
import com.baidu.tieba.mk5;
import com.baidu.tieba.qq8;
import com.baidu.tieba.rw4;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AddLinkActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public ViewGroup b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ViewGroup f;
    public EditText g;
    public ImageView h;
    public TextView i;
    public String j;
    public boolean k;
    public String l;
    public WriteTipBubbleController m;
    public WriteTipBubbleController.b n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        /* loaded from: classes6.dex */
        public class a extends ik5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return UtilHelper.getClipBoardContent();
                }
                return (String) invokeV.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.write.write.AddLinkActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0475b implements mj5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0475b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.mj5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                    return;
                }
                this.a.a.K1(str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AddLinkActivity addLinkActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity, Integer.valueOf(i)};
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
            this.a = addLinkActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                    mk5.b(new a(this), new C0475b(this));
                    return;
                }
                this.a.K1(UtilHelper.getClipBoardContent());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        /* loaded from: classes6.dex */
        public class a extends ik5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return UtilHelper.getClipBoardContent();
                }
                return (String) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements mj5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.mj5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                    return;
                }
                this.a.a.K1(str);
            }
        }

        public h(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (xi.isEmpty(this.a.l)) {
                    if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                        mk5.b(new a(this), new b(this));
                        return;
                    }
                    this.a.K1(UtilHelper.getClipBoardContent());
                    return;
                }
                AddLinkActivity addLinkActivity = this.a;
                addLinkActivity.K1(addLinkActivity.l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public a(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) && this.a.g != null && this.a.m != null) {
                TiebaStatic.log("c13802");
                this.a.m.c();
                UtilHelper.clearClipBoard();
                this.a.g.setText(str);
                this.a.g.setSelection(this.a.g.getText().length());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public c(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.H1();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public d(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.H1();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public e(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null && this.a.g.getText() != null) {
                String obj = this.a.g.getText().toString();
                if (xi.isEmpty(obj) || !UrlManager.getInstance().isUrlValid(obj)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0a4e);
                } else {
                    this.a.G1(obj);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public f(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if (charSequence != null && charSequence.length() != 0) {
                    this.a.h.setVisibility(0);
                    for (int i4 = 0; i4 < charSequence.length(); i4++) {
                        if (!Character.isWhitespace(charSequence.charAt(i4))) {
                            this.a.e.setEnabled(true);
                            return;
                        }
                    }
                    this.a.e.setEnabled(false);
                    return;
                }
                this.a.e.setEnabled(false);
                this.a.h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public g(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g.setText("");
                this.a.g.setSelection(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ AddLinkActivity b;

        public i(AddLinkActivity addLinkActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = addLinkActivity;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.m == null) {
                    AddLinkActivity addLinkActivity = this.b;
                    addLinkActivity.m = new WriteTipBubbleController(addLinkActivity.getPageContext(), this.b.n);
                }
                WriteTipBubbleController writeTipBubbleController = this.b.m;
                EditText editText = this.b.g;
                writeTipBubbleController.d(editText, this.b.getPageContext().getString(R.string.find_new_link) + "\n" + this.a, this.a, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
            }
        }
    }

    public AddLinkActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.o = new b(this, 2001011);
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getIntent() != null) {
            this.j = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.k = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.l = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    public final void G1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Intent intent = new Intent();
            intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
            setResult(-1, intent);
            finish();
        }
    }

    public final void K1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.g != null && !xi.isEmpty(str) && UrlManager.getInstance().isUrlValid(str)) {
            this.g.post(new i(this, str));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            I1();
            registerListener(this.o);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setResult(0);
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0078);
            setActivityBgTransparent();
            setSwipeBackEnabled(false);
            this.a = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090124);
            this.b = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090125);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f092436);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0924dd);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09243f);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090126);
            this.g = (EditText) findViewById(R.id.obfuscated_res_0x7f090968);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f091091);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090127);
            this.a.setOnClickListener(new c(this));
            this.b.setClickable(true);
            this.c.setOnClickListener(new d(this));
            this.e.setOnClickListener(new e(this));
            this.f.setClickable(true);
            this.g.addTextChangedListener(new f(this));
            this.g.setText(this.j);
            EditText editText = this.g;
            editText.setSelection(editText.getText().length());
            this.h.setOnClickListener(new g(this));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            addGlobalLayoutListener();
            adjustResizeForSoftInput(R.color.black_alpha70, true);
            ShowSoftKeyPadDelay(this.g);
            EditText editText2 = this.g;
            editText2.setSelection(editText2.length());
            if (this.k) {
                this.g.post(new h(this));
            }
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int color = SkinManager.getColor(R.color.CAM_X0302);
            this.e.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{qq8.a(color, SkinManager.RESOURCE_ALPHA_DISABLE), qq8.a(color, SkinManager.RESOURCE_ALPHA_PRESS), color}));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundResource(this.b, R.drawable.bg_add_link_content);
            this.c.setTextColor(SkinManager.getColorStateListWithClickState(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            J1();
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            this.g.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            rw4 d2 = rw4.d(this.f);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0209);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0110);
        }
    }
}
