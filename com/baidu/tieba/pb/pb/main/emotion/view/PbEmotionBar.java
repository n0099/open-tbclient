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
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.z0.j0;
import java.util.List;
/* loaded from: classes4.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public d.a.p0.h2.k.e.b1.g.b D;
    public TextWatcher E;
    public SearchEmotionModel.b F;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f19514e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f19515f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.h2.k.e.b1.g.a f19516g;

    /* renamed from: h  reason: collision with root package name */
    public float f19517h;

    /* renamed from: i  reason: collision with root package name */
    public float f19518i;
    public float j;
    public double k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public j s;
    public d.a.p0.h2.k.e.b1.e.a t;
    public RelativeLayout u;
    public EditText v;
    public ImageView w;
    public VelocityTracker x;
    public int y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f19519e;

        public a(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19519e = pbEmotionBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c12492");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f19520e;

        public b(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19520e = pbEmotionBar;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                int i6 = i5 - i4;
                int length = 30 - (spanned.length() - i6);
                String obj = spanned.toString();
                int b2 = j0.b(obj);
                if (i6 > 0) {
                    for (int i7 = i4; i7 < i6 + i4 && obj.length() < i7; i7++) {
                        b2 -= j0.a(obj.charAt(i7));
                    }
                } else {
                    b2 += j0.b(charSequence.toString());
                }
                if (b2 <= 30 && length > 0) {
                    if (length >= i3 - i2) {
                        return null;
                    }
                    return charSequence.subSequence(i2, length + i2);
                }
                return "";
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f19521e;

        public c(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19521e = pbEmotionBar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            String trim = editable.toString().trim();
            if (TextUtils.isEmpty(trim)) {
                if (this.f19521e.t == null || ListUtils.isEmpty(this.f19521e.t.a())) {
                    return;
                }
                this.f19521e.f19516g.e(this.f19521e.t.a());
                this.f19521e.f19516g.notifyDataSetChanged();
                return;
            }
            if (this.f19521e.D == null) {
                this.f19521e.D = new d.a.p0.h2.k.e.b1.g.b();
                this.f19521e.D.g(this.f19521e.F);
            }
            this.f19521e.D.f(trim);
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
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements SearchEmotionModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f19522a;

        public d(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19522a = pbEmotionBar;
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, d.a.p0.o0.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || aVar == null || ListUtils.isEmpty(aVar.a()) || !this.f19522a.v.getText().toString().trim().equals(str)) {
                return;
            }
            this.f19522a.f19516g.e(aVar.a());
            this.f19522a.f19516g.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout.LayoutParams f19523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f19524f;

        public e(PbEmotionBar pbEmotionBar, RelativeLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19524f = pbEmotionBar;
            this.f19523e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f19523e.leftMargin = intValue;
                this.f19524f.B(intValue);
                PbEmotionBar pbEmotionBar = this.f19524f;
                pbEmotionBar.A(pbEmotionBar.r(this.f19523e.leftMargin));
                this.f19524f.setLayoutParams(this.f19523e);
                this.f19524f.v(this.f19523e.leftMargin);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f19525e;

        public f(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19525e = pbEmotionBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (((RelativeLayout.LayoutParams) this.f19525e.getLayoutParams()).leftMargin <= 0) {
                    this.f19525e.setCanShowEmotionPreview(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f19526e;

        public g(PbEmotionBar pbEmotionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19526e = pbEmotionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19526e.v.requestFocus();
                l.K(this.f19526e.getContext(), this.f19526e.v);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19527a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f19528b;

        public h(PbEmotionBar pbEmotionBar, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbEmotionBar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19528b = pbEmotionBar;
            this.f19527a = iVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.i
        public void a(String str, List<String> list, List<String> list2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, list, list2) == null) || this.f19528b.t == null) {
                return;
            }
            this.f19527a.a(this.f19528b.v.getText().toString(), this.f19528b.t.b(), list2);
            TiebaStatic.log("c12177");
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.i
        public void b(EmotionImageData emotionImageData, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, z) == null) {
                this.f19527a.b(emotionImageData, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface j {
        void onMove(float f2);
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
        this.C = false;
        this.E = new c(this);
        this.F = new d(this);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            this.B = z;
        }
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f19515f.getLayoutParams().height = (this.q * 2) + i2;
            this.f19516g.h(i2);
        }
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            float f2 = 1.0f - ((i2 * 1.0f) / this.m);
            this.u.getLayoutParams().height = (int) (this.r * f2);
            this.u.setAlpha(f2);
            this.w.setScaleX(f2);
            this.w.setScaleY(f2);
            this.v.setTextSize(0, l.g(getContext(), R.dimen.fontsize32) * f2);
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
            this.f19514e.requestDisallowInterceptTouchEvent(true);
            if (!onInterceptTouchEvent(motionEvent)) {
                if (this.C && motionEvent.getAction() == 2) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(0);
                    dispatchTouchEvent = super.dispatchTouchEvent(obtain);
                } else {
                    dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                }
                this.C = false;
            } else {
                this.C = true;
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.f19517h = motionEvent.getRawX();
                this.f19518i = motionEvent.getRawY();
                this.j = motionEvent.getRawX();
            }
            this.j = motionEvent.getRawX();
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public int getMaxLeftMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : invokeV.intValue;
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
                } else if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.m && u(motionEvent)) {
                    p(true);
                }
                return y(motionEvent);
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
            if (this.x == null) {
                this.x = VelocityTracker.obtain();
            }
            this.x.addMovement(motionEvent);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int action = motionEvent.getAction();
            int i2 = 0;
            if (action != 1) {
                if (action == 2) {
                    setCanShowEmotionPreview(false);
                    int rawX = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.j));
                    if (rawX >= 0 && rawX <= (i2 = this.m)) {
                        i2 = rawX;
                    }
                    if (layoutParams.leftMargin != i2) {
                        layoutParams.leftMargin = i2;
                        int r = r(i2);
                        if (r <= this.p && r >= this.o) {
                            B(i2);
                            A(r);
                            v(layoutParams.leftMargin);
                        }
                        setLayoutParams(layoutParams);
                    }
                }
                return true;
            }
            this.x.computeCurrentVelocity(1000, this.z);
            float xVelocity = this.x.getXVelocity();
            int rawX2 = (int) (motionEvent.getRawX() - this.f19517h);
            if (Math.abs(xVelocity) <= this.y || Math.abs(rawX2) <= this.A) {
                if (layoutParams.leftMargin > this.l * 0.4d) {
                    p(false);
                } else {
                    p(true);
                }
            } else if (rawX2 > 0) {
                p(false);
            } else {
                p(true);
            }
            this.x.clear();
            this.x.recycle();
            this.x = null;
            return true;
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
            int i3 = this.m;
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

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            p(true);
            if (z) {
                d.a.c.e.m.e.a().postDelayed(new g(this), 300L);
            }
        }
    }

    public final int r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? (int) ((this.k * i2) + this.p) : invokeI.intValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    public void s() {
        d.a.p0.h2.k.e.b1.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bVar = this.D) == null) {
            return;
        }
        bVar.e();
    }

    public void setOnEmotionClickListener(i iVar) {
        d.a.p0.h2.k.e.b1.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, iVar) == null) || iVar == null || (aVar = this.f19516g) == null) {
            return;
        }
        aVar.g(new h(this, iVar));
    }

    public void setOnMoveListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jVar) == null) {
            this.s = jVar;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            setId(R.id.pb_emotion_bar);
            LinearLayout.inflate(getContext(), R.layout.layout_pb_emotion_bar, this);
            setOrientation(1);
            setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.f19515f = (HListView) findViewById(R.id.lv_emotion);
            d.a.p0.h2.k.e.b1.g.a aVar = new d.a.p0.h2.k.e.b1.g.a();
            this.f19516g = aVar;
            aVar.f(this);
            this.f19515f.setAdapter((ListAdapter) this.f19516g);
            this.f19515f.setDividerWidth(l.g(getContext(), R.dimen.ds7));
            this.f19515f.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            this.u = (RelativeLayout) findViewById(R.id.layout_search);
            this.v = (EditText) findViewById(R.id.edit_search);
            this.w = (ImageView) findViewById(R.id.iv_search);
            this.v.addTextChangedListener(this.E);
            this.v.setOnClickListener(new a(this));
            this.v.setFilters(new InputFilter[]{new b(this)});
            this.l = l.k(getContext());
            this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.z = ViewConfiguration.getMaximumFlingVelocity();
            this.y = ViewConfiguration.getMinimumFlingVelocity();
            this.A = l.g(getContext(), R.dimen.ds150);
            this.o = l.g(getContext(), R.dimen.ds58);
            this.p = l.g(getContext(), R.dimen.ds114);
            this.q = l.g(getContext(), R.dimen.ds10);
            int g2 = this.l - l.g(getContext(), R.dimen.tbds196);
            this.m = g2;
            this.k = (this.o - this.p) * (1.0d / g2);
            this.r = l.g(getContext(), R.dimen.ds100);
            w();
        }
    }

    public final boolean u(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getRawX() - this.f19517h);
            float abs2 = Math.abs(motionEvent.getRawY() - this.f19518i);
            float f2 = this.n;
            return abs < f2 && abs2 < f2;
        }
        return invokeL.booleanValue;
    }

    public final void v(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (jVar = this.s) == null) {
            return;
        }
        int i3 = this.m;
        jVar.onMove((i3 - i2) * (1.0f / i3));
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
            this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            d.a.p0.h2.k.e.b1.g.a aVar = this.f19516g;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            d.a.p0.h2.k.e.b1.g.a aVar = this.f19516g;
            if (aVar != null) {
                aVar.d();
            }
            s();
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
            if (this.f19515f.getChildCount() <= 0 || this.f19515f.getFirstVisiblePosition() != 0 || (childAt = this.f19515f.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.j) {
                setCanShowEmotionPreview(true);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void z(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) || i2 == i3) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new e(this, (RelativeLayout.LayoutParams) getLayoutParams()));
        ofInt.addListener(new f(this));
        ofInt.setDuration(300L).start();
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
        this.C = false;
        this.E = new c(this);
        this.F = new d(this);
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
        this.C = false;
        this.E = new c(this);
        this.F = new d(this);
        t();
    }
}
