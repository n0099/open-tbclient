package com.baidu.tieba.write.write.work.topic;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import com.baidu.tieba.ms4;
import com.baidu.tieba.os4;
import com.baidu.tieba.ri;
import com.baidu.tieba.t57;
import com.baidu.tieba.w57;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicListLayout;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicSuggestLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SelectTopicLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public RelativeLayout c;
    public View d;
    public View e;
    public ImageView f;
    public TextView g;
    public RelativeLayout h;
    public TextView i;
    public ImageView j;
    public EditText k;
    public SelectTopicListLayout l;
    public SelectTopicSuggestLayout m;
    public HotTopicSelectModel n;
    public f o;
    public boolean p;
    public int q;
    public int r;
    public VelocityTracker s;
    public int t;
    public int u;
    public int v;
    public List<w57> w;
    public float x;
    public float y;
    public final View.OnClickListener z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicLayout a;

        public a(SelectTopicLayout selectTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicLayout a;

        public b(SelectTopicLayout selectTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicLayout;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (obj == null || obj.trim().length() <= 0) {
                    this.a.m.a("", null);
                    this.a.l.setVisibility(0);
                    this.a.m.setVisibility(8);
                    this.a.setDelButtonVisible(false);
                    return;
                }
                this.a.l.setVisibility(8);
                this.a.m.setVisibility(0);
                this.a.n.N(obj);
                this.a.setDelButtonVisible(true);
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
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SelectTopicLayout b;

        public c(SelectTopicLayout selectTopicLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = selectTopicLayout;
            this.a = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.b.setVisibility(8);
                this.b.p = false;
                this.b.k.setText("");
                this.b.l.e();
                this.b.m.d();
                if (this.b.o != null) {
                    this.b.o.a(false, this.a);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicLayout a;

        public d(SelectTopicLayout selectTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.p = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicLayout a;

        public e(SelectTopicLayout selectTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 == this.a.j) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(boolean z, boolean z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = -1;
        this.w = new ArrayList();
        this.z = new e(this);
        n();
    }

    private String getSearchKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.n;
            String F = hotTopicSelectModel != null ? hotTopicSelectModel.F() : "";
            return F != null ? F : "";
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.setText("");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j(false);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.p) {
            return;
        }
        if (this.k.isFocused()) {
            Context context = getContext();
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).HidenSoftKeyPad((InputMethodManager) context.getSystemService("input_method"), this.k);
            }
        }
        this.p = true;
        RelativeLayout relativeLayout = this.c;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, Key.TRANSLATION_Y, relativeLayout.getTranslationY(), this.q);
        ofFloat.setDuration(((this.q - this.c.getTranslationY()) / this.q) * 300.0f);
        ofFloat.addListener(new c(this, z));
        ofFloat.start();
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r = -1;
            x();
        }
    }

    public final int l(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int i = this.r;
            int m = m(motionEvent, i);
            if (p(motionEvent, m, i)) {
                return 0;
            }
            return (int) Math.abs(motionEvent.getY(m) - this.y);
        }
        return invokeL.intValue;
    }

    public final int m(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, motionEvent, i)) == null) {
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex == -1) {
                this.r = -1;
            }
            return findPointerIndex;
        }
        return invokeLI.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0797, this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0921e7);
            this.a = findViewById;
            findViewById.setOnClickListener(new a(this));
            this.b = findViewById(R.id.obfuscated_res_0x7f0906c6);
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906c5);
            this.d = findViewById(R.id.obfuscated_res_0x7f092243);
            this.e = findViewById(R.id.obfuscated_res_0x7f0903d6);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e06);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091e07);
            this.h = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0922a7);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0922a8);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f0922a6);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0922a9);
            this.k = editText;
            editText.addTextChangedListener(new b(this));
            this.l = (SelectTopicListLayout) findViewById(R.id.obfuscated_res_0x7f091e04);
            this.m = (SelectTopicSuggestLayout) findViewById(R.id.obfuscated_res_0x7f091e05);
            this.j.setOnClickListener(this.z);
            setDelButtonVisible(false);
            v();
            o();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.u = ViewConfiguration.getMaximumFlingVelocity();
            this.t = ViewConfiguration.getMinimumFlingVelocity();
            this.v = ri.i(getContext()) / 8;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (this.p) {
                return true;
            }
            if ((motionEvent.getAction() & 255) == 0) {
                int actionIndex = motionEvent.getActionIndex();
                this.r = motionEvent.getPointerId(actionIndex);
                this.x = motionEvent.getY();
                float y = motionEvent.getY(actionIndex);
                this.y = y;
                if (y < this.a.getHeight()) {
                    return false;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r0 != 3) goto L18;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (this.p) {
                return true;
            }
            if (this.s == null) {
                this.s = VelocityTracker.obtain();
            }
            this.s.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int m = m(motionEvent, this.r);
                        if (!p(motionEvent, m, this.r)) {
                            float y = motionEvent.getY(m);
                            float f2 = y - this.x;
                            this.x = y;
                            float translationY = this.c.getTranslationY() + f2;
                            this.c.setTranslationY(translationY >= 0.0f ? translationY : 0.0f);
                        }
                    }
                }
                VelocityTracker velocityTracker = this.s;
                velocityTracker.computeCurrentVelocity(1000, this.u);
                float yVelocity = velocityTracker.getYVelocity();
                int l = l(motionEvent);
                k();
                if (Math.abs(yVelocity) <= this.t || l <= this.v) {
                    if (this.c.getTranslationY() >= this.q / 2.0f) {
                        i();
                    } else {
                        w();
                    }
                } else if (yVelocity > 0.0f) {
                    i();
                } else {
                    w();
                }
            } else {
                int actionIndex = motionEvent.getActionIndex();
                this.r = motionEvent.getPointerId(actionIndex);
                this.x = motionEvent.getY();
                this.y = motionEvent.getY(actionIndex);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean p(MotionEvent motionEvent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048586, this, motionEvent, i, i2)) == null) ? motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount() : invokeLII.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    public void s(t57 t57Var, t57 t57Var2, t57 t57Var3) {
        SelectTopicListLayout selectTopicListLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, t57Var, t57Var2, t57Var3) == null) || (selectTopicListLayout = this.l) == null) {
            return;
        }
        selectTopicListLayout.a(t57Var, t57Var2, t57Var3);
    }

    public void setDelButtonVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.j.setVisibility(z ? 0 : 8);
        }
    }

    public void setHotTopicModel(HotTopicSelectModel hotTopicSelectModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hotTopicSelectModel) == null) {
            this.n = hotTopicSelectModel;
        }
    }

    public void setSelectTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.l.setSelectTopicId(j);
        }
    }

    public void setStateListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void setTitlePlaceholderHeight(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || i <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.height = i;
        this.a.setLayoutParams(layoutParams);
        int i2 = ri.i(getContext()) - i;
        this.q = i2;
        this.c.setTranslationY(i2);
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    public void u(t57 t57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, t57Var) == null) {
            this.w.clear();
            String searchKey = getSearchKey();
            t57 t57Var2 = new t57();
            this.w.add(new w57(searchKey, 0L, false));
            if (t57Var == null) {
                t57Var = t57Var2;
            }
            t57Var.c().addAll(0, this.w);
            this.m.a(getSearchKey(), t57Var.c());
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            os4.d(this.b).o(new int[]{R.color.CAM_X0803, R.color.CAM_X0601});
            os4 d2 = os4.d(this.d);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0207);
            os4.d(this.e).f(R.color.CAM_X0207);
            os4 d3 = os4.d(this.g);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X09);
            d3.A(R.string.F_X01);
            os4 d4 = os4.d(this.h);
            d4.n(R.string.J_X07);
            d4.f(R.color.CAM_X0209);
            os4 d5 = os4.d(this.i);
            d5.v(R.color.CAM_X0110);
            d5.z(R.dimen.T_X07);
            d5.A(R.string.F_X01);
            this.k.setHintTextColor(ms4.h(R.color.CAM_X0110));
            os4 d6 = os4.d(this.k);
            d6.v(R.color.CAM_X0105);
            d6.z(R.dimen.T_X07);
            d6.A(R.string.F_X01);
            this.l.d();
            this.m.c();
            SkinManager.setImageResource(this.j, R.drawable.del_search_btn);
            os4 d7 = os4.d(this.f);
            d7.n(R.string.J_X01);
            d7.f(R.color.CAM_X0209);
            this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08099b, SkinManager.getColor(R.color.CAM_X0108), WebPManager.ResourceStateType.NORMAL_DISABLE));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.p) {
            return;
        }
        this.p = true;
        setVisibility(0);
        RelativeLayout relativeLayout = this.c;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, Key.TRANSLATION_Y, relativeLayout.getTranslationY(), 0.0f);
        ofFloat.setDuration((this.c.getTranslationY() / this.q) * 300.0f);
        ofFloat.addListener(new d(this));
        ofFloat.start();
        f fVar = this.o;
        if (fVar != null) {
            fVar.a(true, false);
        }
        HotTopicSelectModel hotTopicSelectModel = this.n;
        if (hotTopicSelectModel != null) {
            hotTopicSelectModel.E();
        }
    }

    public final void x() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (velocityTracker = this.s) == null) {
            return;
        }
        velocityTracker.clear();
        this.s.recycle();
        this.s = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = -1;
        this.w = new ArrayList();
        this.z = new e(this);
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.r = -1;
        this.w = new ArrayList();
        this.z = new e(this);
        n();
    }
}
