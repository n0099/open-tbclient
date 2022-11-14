package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.re6;
import com.baidu.tieba.s28;
import com.baidu.tieba.t28;
import com.baidu.tieba.tj5;
import com.baidu.tieba.u28;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextWatcher A;
    public SearchEmotionModel.b B;
    public RelativeLayout a;
    public HListView b;
    public t28 c;
    public float d;
    public float e;
    public float f;
    public double g;
    public int h;
    public int i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public j o;
    public s28 p;
    public RelativeLayout q;
    public EditText r;
    public ImageView s;
    public VelocityTracker t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public u28 z;

    /* loaded from: classes5.dex */
    public interface i {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface j {
        void onMove(float f);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbEmotionBar a;

        public a(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbEmotionBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c12492");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbEmotionBar a;

        public b(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbEmotionBar;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int b = tj5.b(obj);
                if (i5 > 0) {
                    for (int i6 = i3; i6 < i5 + i3 && obj.length() < i6; i6++) {
                        b -= tj5.a(obj.charAt(i6));
                    }
                } else {
                    b += tj5.b(charSequence.toString());
                }
                if (b > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, length + i);
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbEmotionBar a;

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

        public c(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbEmotionBar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || editable == null) {
                return;
            }
            String trim = editable.toString().trim();
            if (TextUtils.isEmpty(trim)) {
                if (this.a.p != null && !ListUtils.isEmpty(this.a.p.a())) {
                    this.a.c.e(this.a.p.a());
                    this.a.c.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (this.a.z == null) {
                this.a.z = new u28();
                this.a.z.g(this.a.B);
            }
            this.a.z.f(trim);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SearchEmotionModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbEmotionBar a;

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }

        public d(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbEmotionBar;
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, re6 re6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, str, re6Var) != null) || re6Var == null || ListUtils.isEmpty(re6Var.a()) || !this.a.r.getText().toString().trim().equals(str)) {
                return;
            }
            this.a.c.e(re6Var.a());
            this.a.c.notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout.LayoutParams a;
        public final /* synthetic */ PbEmotionBar b;

        public e(PbEmotionBar pbEmotionBar, RelativeLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbEmotionBar;
            this.a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.leftMargin = intValue;
                this.b.B(intValue);
                PbEmotionBar pbEmotionBar = this.b;
                pbEmotionBar.A(pbEmotionBar.r(this.a.leftMargin));
                this.b.setLayoutParams(this.a);
                this.b.v(this.a.leftMargin);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbEmotionBar a;

        public f(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbEmotionBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (((RelativeLayout.LayoutParams) this.a.getLayoutParams()).leftMargin > 0) {
                    return;
                }
                this.a.setCanShowEmotionPreview(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbEmotionBar a;

        public g(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbEmotionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r.requestFocus();
                yi.N(this.a.getContext(), this.a.r);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;
        public final /* synthetic */ PbEmotionBar b;

        public h(PbEmotionBar pbEmotionBar, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbEmotionBar;
            this.a = iVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.i
        public void a(String str, List<String> list, List<String> list2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, list, list2) == null) && this.b.p != null) {
                this.a.a(this.b.r.getText().toString(), this.b.p.b(), list2);
                TiebaStatic.log("c12177");
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.i
        public void b(EmotionImageData emotionImageData, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, z) == null) {
                this.a.b(emotionImageData, z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbEmotionBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = false;
        this.A = new c(this);
        this.B = new d(this);
        t();
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            float f2 = 1.0f - ((i2 * 1.0f) / this.i);
            this.q.getLayoutParams().height = (int) (this.n * f2);
            this.q.setAlpha(f2);
            this.s.setScaleX(f2);
            this.s.setScaleY(f2);
            this.r.setTextSize(0, yi.g(getContext(), R.dimen.obfuscated_res_0x7f0702b7) * f2);
        }
    }

    public final boolean y(MotionEvent motionEvent) {
        InterceptResult invokeL;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            if (u(motionEvent)) {
                return false;
            }
            if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                return true;
            }
            if (this.b.getChildCount() > 0 && this.b.getFirstVisiblePosition() == 0 && (childAt = this.b.getChildAt(0)) != null && childAt.getLeft() >= 0 && motionEvent.getRawX() > this.f) {
                return true;
            }
            setCanShowEmotionPreview(true);
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbEmotionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.y = false;
        this.A = new c(this);
        this.B = new d(this);
        t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbEmotionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.y = false;
        this.A = new c(this);
        this.B = new d(this);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            this.x = z;
        }
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.b.getLayoutParams().height = (this.m * 2) + i2;
            this.c.h(i2);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            p(true);
            if (z) {
                ah.a().postDelayed(new g(this), 300L);
            }
        }
    }

    public final int r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            return (int) ((this.g * i2) + this.l);
        }
        return invokeI.intValue;
    }

    public void setOnEmotionClickListener(i iVar) {
        t28 t28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, iVar) == null) && iVar != null && (t28Var = this.c) != null) {
            t28Var.g(new h(this, iVar));
        }
    }

    public void setOnMoveListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jVar) == null) {
            this.o = jVar;
        }
    }

    public final void v(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i2) == null) && (jVar = this.o) != null) {
            int i3 = this.i;
            jVar.onMove((i3 - i2) * (1.0f / i3));
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public int getMaxLeftMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public void s() {
        u28 u28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (u28Var = this.z) != null) {
            u28Var.e();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
            this.r.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            t28 t28Var = this.c;
            if (t28Var != null) {
                t28Var.notifyDataSetChanged();
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            t28 t28Var = this.c;
            if (t28Var != null) {
                t28Var.d();
            }
            s();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r1 != 2) goto L15;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean dispatchTouchEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            this.a.requestDisallowInterceptTouchEvent(true);
            if (!onInterceptTouchEvent(motionEvent)) {
                if (this.y && motionEvent.getAction() == 2) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(0);
                    dispatchTouchEvent = super.dispatchTouchEvent(obtain);
                } else {
                    dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                }
                this.y = false;
            } else {
                this.y = true;
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.d = motionEvent.getRawX();
                this.e = motionEvent.getRawY();
                this.f = motionEvent.getRawX();
            }
            this.f = motionEvent.getRawX();
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                } else if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.i && u(motionEvent)) {
                    p(true);
                }
                return y(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            int i2 = ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin;
            if (i2 <= 0) {
                setCanShowEmotionPreview(true);
                return;
            }
            int i3 = this.i;
            if (z) {
                i3 = 0;
                TiebaStatic.log("c12175");
            }
            if (!z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
            }
            z(i2, i3);
        }
    }

    public final boolean u(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getRawX() - this.d);
            float abs2 = Math.abs(motionEvent.getRawY() - this.e);
            float f2 = this.j;
            if (abs < f2 && abs2 < f2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r1 != 3) goto L12;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (this.t == null) {
                this.t = VelocityTracker.obtain();
            }
            this.t.addMovement(motionEvent);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int action = motionEvent.getAction();
            int i2 = 0;
            if (action != 1) {
                if (action == 2) {
                    setCanShowEmotionPreview(false);
                    int rawX = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.f));
                    if (rawX >= 0 && rawX <= (i2 = this.i)) {
                        i2 = rawX;
                    }
                    if (layoutParams.leftMargin != i2) {
                        layoutParams.leftMargin = i2;
                        int r = r(i2);
                        if (r <= this.l && r >= this.k) {
                            B(i2);
                            A(r);
                            v(layoutParams.leftMargin);
                        }
                        setLayoutParams(layoutParams);
                    }
                }
                return true;
            }
            this.t.computeCurrentVelocity(1000, this.v);
            float xVelocity = this.t.getXVelocity();
            int rawX2 = (int) (motionEvent.getRawX() - this.d);
            if (Math.abs(xVelocity) > this.u && Math.abs(rawX2) > this.w) {
                if (rawX2 > 0) {
                    p(false);
                } else {
                    p(true);
                }
            } else if (layoutParams.leftMargin > this.h * 0.4d) {
                p(false);
            } else {
                p(true);
            }
            this.t.clear();
            this.t.recycle();
            this.t = null;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            setId(R.id.obfuscated_res_0x7f091837);
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04cb, this);
            setOrientation(1);
            setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.b = (HListView) findViewById(R.id.obfuscated_res_0x7f0914a4);
            t28 t28Var = new t28();
            this.c = t28Var;
            t28Var.f(this);
            this.b.setAdapter((ListAdapter) this.c);
            this.b.setDividerWidth(yi.g(getContext(), R.dimen.obfuscated_res_0x7f0702f6));
            this.b.setSelector(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08127e));
            this.q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0912dc);
            this.r = (EditText) findViewById(R.id.obfuscated_res_0x7f09089b);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f09105d);
            this.r.addTextChangedListener(this.A);
            this.r.setOnClickListener(new a(this));
            this.r.setFilters(new InputFilter[]{new b(this)});
            this.h = yi.l(getContext());
            this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.v = ViewConfiguration.getMaximumFlingVelocity();
            this.u = ViewConfiguration.getMinimumFlingVelocity();
            this.w = yi.g(getContext(), R.dimen.obfuscated_res_0x7f07024d);
            this.k = yi.g(getContext(), R.dimen.obfuscated_res_0x7f0702e3);
            this.l = yi.g(getContext(), R.dimen.obfuscated_res_0x7f070238);
            this.m = yi.g(getContext(), R.dimen.obfuscated_res_0x7f070230);
            int g2 = this.h - yi.g(getContext(), R.dimen.tbds196);
            this.i = g2;
            this.g = (this.k - this.l) * (1.0d / g2);
            this.n = yi.g(getContext(), R.dimen.obfuscated_res_0x7f07019a);
            w();
        }
    }

    public final void z(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048599, this, i2, i3) != null) || i2 == i3) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new e(this, (RelativeLayout.LayoutParams) getLayoutParams()));
        ofInt.addListener(new f(this));
        ofInt.setDuration(300L).start();
    }
}
