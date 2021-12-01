package com.baidu.tieba.memberCenter.tail.edit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import c.a.q0.s.s.a;
import c.a.q0.t.c.w;
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
/* loaded from: classes10.dex */
public class TailEditActivity extends BaseActivity<TailEditActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.e2.h.f.a<Integer> addTailCallBack;
    public View.OnClickListener mCancelButtonClickListener;
    public c.a.q0.x.b mEditorListener;
    public c.a.r0.e2.h.b.a mModel;
    public View.OnClickListener mSubmitButtonClickListener;
    public View mTailEditContainer;
    public TextWatcher mTextNumberWatcher;
    public View.OnTouchListener mTextOnTouchListener;
    public c.a.r0.e2.h.b.b mView;
    public c.a.r0.e2.h.f.a<Integer> updateTailCallBack;

    /* loaded from: classes10.dex */
    public class a implements c.a.r0.e2.h.f.a<Integer> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.e2.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) == null) {
                this.a.submitCallback(true, z, str, num);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements c.a.r0.e2.h.f.a<Integer> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.e2.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) == null) {
                this.a.submitCallback(false, z, str, num);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TailEditActivity f47009e;

        public c(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47009e = tailEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47009e.mView.h().length() != 0) {
                    this.f47009e.mView.r();
                    this.f47009e.mModel.r(this.f47009e.mView.h().getText().toString());
                    return;
                }
                TailEditActivity tailEditActivity = this.f47009e;
                tailEditActivity.showToast(tailEditActivity.getResources().getString(R.string.tail_submit_empty_toast));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TailEditActivity f47010e;

        public d(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47010e = tailEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47010e.mModel.i().setContent(this.f47010e.mView.g());
                if (this.f47010e.mModel.k()) {
                    this.f47010e.confirmCancelEdit();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                this.f47010e.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TailEditActivity f47011e;

        public e(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47011e = tailEditActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f47011e.mView.j();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TailEditActivity f47012e;

        public f(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47012e = tailEditActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                this.f47012e.userInputChanged(charSequence.toString());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TailEditActivity f47013e;

        public g(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47013e = tailEditActivity;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 24) {
                this.f47013e.addEmotion(aVar.f13679c);
            } else if (i2 == 26) {
                this.f47013e.changeColor(aVar.f13679c);
            } else if (i2 == 3) {
                this.f47013e.mView.e();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f47014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TailEditActivity f47015f;

        public h(TailEditActivity tailEditActivity, c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47015f = tailEditActivity;
            this.f47014e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f47014e.dismiss();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f47016e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TailEditActivity f47017f;

        public i(TailEditActivity tailEditActivity, c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47017f = tailEditActivity;
            this.f47016e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f47016e.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                this.f47017f.finish();
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
            c.a.r0.e2.h.b.a aVar = this.mModel;
            if (aVar.l(aVar.e(aVar.i().getContent()))) {
                showToast(R.string.over_limit_tip);
            } else if (obj == null || !(obj instanceof w)) {
            } else {
                new c.a.r0.e2.h.f.b().b(this, this.mView.h(), (w) obj);
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
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
            aVar.setMessage(getResources().getString(R.string.tail_cancel_modified_toast));
            aVar.setNegativeButton(R.string.cancel, new h(this, aVar));
            aVar.setPositiveButton(R.string.confirm, new i(this, aVar));
            aVar.create(getPageContext());
            aVar.show();
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
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
                c.a.r0.e2.h.a.e eVar = new c.a.r0.e2.h.a.e(1, tailData);
                if (!z) {
                    eVar.a = 2;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                finish();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, eVar));
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
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.mTailEditContainer);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.tail_edit_activity);
            setActivityBgTransparent();
            setSwipeBackEnabled(false);
            this.mView = new c.a.r0.e2.h.b.b(this, this.mSubmitButtonClickListener, this.mCancelButtonClickListener);
            this.mModel = new c.a.r0.e2.h.b.a(getPageContext());
            this.mTailEditContainer = findViewById(R.id.tail_edit_container);
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
