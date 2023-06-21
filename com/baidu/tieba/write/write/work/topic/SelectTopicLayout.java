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
import com.baidu.tieba.n75;
import com.baidu.tieba.p75;
import com.baidu.tieba.q68;
import com.baidu.tieba.t68;
import com.baidu.tieba.wi;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicListLayout;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicSuggestLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
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
    public List<t68> w;
    public float x;
    public float y;
    public final View.OnClickListener z;

    /* loaded from: classes8.dex */
    public interface f {
        void a(boolean z, boolean z2);
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicLayout a;

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
                if (obj != null && obj.trim().length() > 0) {
                    this.a.l.setVisibility(8);
                    this.a.m.setVisibility(0);
                    this.a.n.i0(obj);
                    this.a.setDelButtonVisible(true);
                    return;
                }
                this.a.m.b("", null);
                this.a.l.setVisibility(0);
                this.a.m.setVisibility(8);
                this.a.setDelButtonVisible(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SelectTopicLayout b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.b.setVisibility(8);
                this.b.p = false;
                this.b.k.setText("");
                this.b.l.e();
                this.b.m.e();
                if (this.b.o != null) {
                    this.b.o.a(false, this.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicLayout a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.p = false;
        }
    }

    /* loaded from: classes8.dex */
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

    public void setDelButtonVisible(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            ImageView imageView = this.j;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
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
        if ((interceptable != null && interceptable.invokeI(1048594, this, i) != null) || i <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.height = i;
        this.a.setLayoutParams(layoutParams);
        int j = wi.j(getContext()) - i;
        this.q = j;
        this.c.setTranslationY(j);
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

    private String getSearchKey() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.n;
            if (hotTopicSelectModel == null) {
                str = "";
            } else {
                str = hotTopicSelectModel.a0();
            }
            if (str == null) {
                return "";
            }
            return str;
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

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r = -1;
            x();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.u = ViewConfiguration.getMaximumFlingVelocity();
            this.t = ViewConfiguration.getMinimumFlingVelocity();
            this.v = wi.j(getContext()) / 8;
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (velocityTracker = this.s) != null) {
            velocityTracker.clear();
            this.s.recycle();
            this.s = null;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !this.p) {
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
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0865, this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0924d1);
            this.a = findViewById;
            findViewById.setOnClickListener(new a(this));
            this.b = findViewById(R.id.obfuscated_res_0x7f0907a4);
            this.c = (RelativeLayout) findViewById(R.id.container_layout);
            this.d = findViewById(R.id.obfuscated_res_0x7f09253b);
            this.e = findViewById(R.id.obfuscated_res_0x7f090449);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0920b3);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0920b4);
            this.h = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0925a7);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0925a8);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f0925a6);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0925a9);
            this.k = editText;
            editText.addTextChangedListener(new b(this));
            this.l = (SelectTopicListLayout) findViewById(R.id.obfuscated_res_0x7f0920b1);
            this.m = (SelectTopicSuggestLayout) findViewById(R.id.obfuscated_res_0x7f0920b2);
            this.j.setOnClickListener(this.z);
            setDelButtonVisible(false);
            v();
            o();
        }
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
                float f2 = 0.0f;
                if (action != 1) {
                    if (action == 2) {
                        int m = m(motionEvent, this.r);
                        if (!p(motionEvent, m, this.r)) {
                            float y = motionEvent.getY(m);
                            float f3 = y - this.x;
                            this.x = y;
                            float translationY = this.c.getTranslationY() + f3;
                            if (translationY >= 0.0f) {
                                f2 = translationY;
                            }
                            this.c.setTranslationY(f2);
                        }
                    }
                }
                VelocityTracker velocityTracker = this.s;
                velocityTracker.computeCurrentVelocity(1000, this.u);
                float yVelocity = velocityTracker.getYVelocity();
                int l = l(motionEvent);
                k();
                if (Math.abs(yVelocity) > this.t && l > this.v) {
                    if (yVelocity > 0.0f) {
                        i();
                    } else {
                        w();
                    }
                } else if (this.c.getTranslationY() >= this.q / 2.0f) {
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
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048586, this, motionEvent, i, i2)) == null) {
            if (motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount()) {
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public void s(q68 q68Var, q68 q68Var2, q68 q68Var3) {
        SelectTopicListLayout selectTopicListLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, q68Var, q68Var2, q68Var3) == null) && (selectTopicListLayout = this.l) != null) {
            selectTopicListLayout.a(q68Var, q68Var2, q68Var3);
        }
    }

    public void u(q68 q68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, q68Var) == null) {
            this.w.clear();
            String searchKey = getSearchKey();
            q68 q68Var2 = new q68();
            this.w.add(new t68(searchKey, 0L, false));
            if (q68Var == null) {
                q68Var = q68Var2;
            }
            q68Var.c().addAll(0, this.w);
            this.m.b(getSearchKey(), q68Var.c());
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            p75.d(this.b).p(new int[]{R.color.CAM_X0803, R.color.CAM_X0601});
            p75 d2 = p75.d(this.d);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0207);
            p75.d(this.e).f(R.color.CAM_X0207);
            p75 d3 = p75.d(this.g);
            d3.x(R.color.CAM_X0108);
            d3.C(R.dimen.T_X09);
            d3.D(R.string.F_X01);
            p75 d4 = p75.d(this.h);
            d4.o(R.string.J_X07);
            d4.f(R.color.CAM_X0209);
            p75 d5 = p75.d(this.i);
            d5.x(R.color.CAM_X0110);
            d5.C(R.dimen.T_X07);
            d5.D(R.string.F_X01);
            this.k.setHintTextColor(n75.i(R.color.CAM_X0110));
            p75 d6 = p75.d(this.k);
            d6.x(R.color.CAM_X0105);
            d6.C(R.dimen.T_X07);
            d6.D(R.string.F_X01);
            this.l.d();
            this.m.d();
            SkinManager.setImageResource(this.j, R.drawable.del_search_btn);
            p75 d7 = p75.d(this.f);
            d7.o(R.string.J_X01);
            d7.f(R.color.CAM_X0209);
            this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b92, SkinManager.getColor(R.color.CAM_X0108), WebPManager.ResourceStateType.NORMAL_DISABLE));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && !this.p) {
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
                hotTopicSelectModel.Z();
            }
        }
    }
}
