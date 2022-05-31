package com.baidu.tieba.memberCenter.tail.edit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cw4;
import com.repackage.dq4;
import com.repackage.si7;
import com.repackage.sz4;
import com.repackage.th7;
import com.repackage.ti7;
import com.repackage.tz4;
import com.repackage.wh7;
import com.repackage.wq4;
import com.repackage.xh7;
/* loaded from: classes3.dex */
public class TailEditActivity extends BaseActivity<TailEditActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public si7<Integer> addTailCallBack;
    public View.OnClickListener mCancelButtonClickListener;
    public tz4 mEditorListener;
    public wh7 mModel;
    public View.OnClickListener mSubmitButtonClickListener;
    public View mTailEditContainer;
    public TextWatcher mTextNumberWatcher;
    public View.OnTouchListener mTextOnTouchListener;
    public xh7 mView;
    public si7<Integer> updateTailCallBack;

    /* loaded from: classes3.dex */
    public class a implements si7<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public a(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.si7
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) == null) {
                this.a.submitCallback(true, z, str, num);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements si7<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public b(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.si7
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) == null) {
                this.a.submitCallback(false, z, str, num);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public c(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.mView.h().length() != 0) {
                    this.a.mView.r();
                    this.a.mModel.r(this.a.mView.h().getText().toString());
                    return;
                }
                TailEditActivity tailEditActivity = this.a;
                tailEditActivity.showToast(tailEditActivity.getResources().getString(R.string.obfuscated_res_0x7f0f1374));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public d(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mModel.i().setContent(this.a.mView.g());
                if (this.a.mModel.k()) {
                    this.a.confirmCancelEdit();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public e(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.mView.j();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public f(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

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

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                this.a.userInputChanged(charSequence.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements tz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public g(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // com.repackage.tz4
        public void onAction(sz4 sz4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, sz4Var) == null) || sz4Var == null) {
                return;
            }
            int i = sz4Var.a;
            if (i == 24) {
                this.a.addEmotion(sz4Var.c);
            } else if (i == 26) {
                this.a.changeColor(sz4Var.c);
            } else if (i == 3) {
                this.a.mView.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ TailEditActivity b;

        public h(TailEditActivity tailEditActivity, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tailEditActivity;
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ TailEditActivity b;

        public i(TailEditActivity tailEditActivity, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tailEditActivity;
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                this.b.finish();
            }
        }
    }

    public TailEditActivity() {
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
        this.addTailCallBack = new a(this);
        this.updateTailCallBack = new b(this);
        this.mSubmitButtonClickListener = new c(this);
        this.mCancelButtonClickListener = new d(this);
        this.mTextOnTouchListener = new e(this);
        this.mTextNumberWatcher = new f(this);
        this.mEditorListener = new g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEmotion(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, obj) == null) {
            this.mModel.i().setContent(this.mView.g());
            wh7 wh7Var = this.mModel;
            if (wh7Var.l(wh7Var.e(wh7Var.i().getContent()))) {
                showToast(R.string.obfuscated_res_0x7f0f0d0e);
            } else if (obj == null || !(obj instanceof cw4)) {
            } else {
                new ti7().b(this, this.mView.h(), (cw4) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeColor(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, obj) == null) || obj == null) {
            return;
        }
        String obj2 = obj.toString();
        this.mView.m(obj2);
        this.mModel.o(obj2);
        this.mView.p(this.mModel.s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmCancelEdit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            dq4 dq4Var = new dq4(getActivity());
            dq4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f1369));
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new h(this, dq4Var));
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f042e, new i(this, dq4Var));
            dq4Var.create(getPageContext());
            dq4Var.show();
        }
    }

    private String cutTextToMax(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            if (this.mModel.m(this.mModel.e(str))) {
                String h2 = this.mModel.h(str);
                this.mView.n(h2);
                this.mView.k();
                return h2;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private void initEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mView.a(this.mEditorListener, this.mModel.g());
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mModel.n(this.addTailCallBack);
            this.mModel.q(this.updateTailCallBack);
            this.mView.h().addTextChangedListener(this.mTextNumberWatcher);
            this.mView.h().setOnTouchListener(this.mTextOnTouchListener);
        }
    }

    private void loadTailData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mModel.j(getIntent().getIntExtra(TailEditActivityConfig.TAIL_ID, 0), getIntent().getStringExtra(TailEditActivityConfig.TAIL_CONTENT), getIntent().getStringExtra(TailEditActivityConfig.TAIL_COLOR), getIntent().getBooleanExtra(TailEditActivityConfig.IS_NO_TAIL, false));
            this.mView.s(this.mModel.i());
        }
    }

    private void setAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010063, R.anim.obfuscated_res_0x7f010064);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitCallback(boolean z, boolean z2, String str, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, num}) == null) {
            this.mView.i();
            if (z2) {
                showToast(str);
            } else if (num == null) {
            } else {
                TailData tailData = new TailData();
                tailData.setId(num.intValue());
                tailData.setContent(this.mModel.i().getContent());
                tailData.setFontColor(this.mModel.g());
                th7 th7Var = new th7(1, tailData);
                if (!z) {
                    th7Var.a = 2;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                finish();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, th7Var));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void userInputChanged(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
            String cutTextToMax = cutTextToMax(str);
            this.mModel.i().setContent(cutTextToMax);
            this.mView.q(this.mModel.e(cutTextToMax), 50);
            this.mView.p(this.mModel.s());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mView.l(i2);
            wq4 d2 = wq4.d(this.mTailEditContainer);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d07e9);
            setActivityBgTransparent();
            setSwipeBackEnabled(false);
            this.mView = new xh7(this, this.mSubmitButtonClickListener, this.mCancelButtonClickListener);
            this.mModel = new wh7(getPageContext());
            this.mTailEditContainer = findViewById(R.id.obfuscated_res_0x7f091eb3);
            initListener();
            loadTailData();
            initEditor();
            this.mView.f();
            adjustResizeForSoftInput(R.color.common_color_10022, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                this.mModel.i().setContent(this.mView.g());
                if (this.mModel.k()) {
                    confirmCancelEdit();
                    return true;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
