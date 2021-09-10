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
import c.a.e.e.p.l;
import c.a.q0.d1.m0;
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
import java.util.List;
/* loaded from: classes7.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public c.a.r0.j2.k.e.b1.g.b D;
    public TextWatcher E;
    public SearchEmotionModel.b F;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f55269e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f55270f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.j2.k.e.b1.g.a f55271g;

    /* renamed from: h  reason: collision with root package name */
    public float f55272h;

    /* renamed from: i  reason: collision with root package name */
    public float f55273i;

    /* renamed from: j  reason: collision with root package name */
    public float f55274j;
    public double k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public j s;
    public c.a.r0.j2.k.e.b1.e.a t;
    public RelativeLayout u;
    public EditText v;
    public ImageView w;
    public VelocityTracker x;
    public int y;
    public int z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f55275e;

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
            this.f55275e = pbEmotionBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c12492");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f55276e;

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
            this.f55276e = pbEmotionBar;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                int i6 = i5 - i4;
                int length = 30 - (spanned.length() - i6);
                String obj = spanned.toString();
                int b2 = m0.b(obj);
                if (i6 > 0) {
                    for (int i7 = i4; i7 < i6 + i4 && obj.length() < i7; i7++) {
                        b2 -= m0.a(obj.charAt(i7));
                    }
                } else {
                    b2 += m0.b(charSequence.toString());
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

    /* loaded from: classes7.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f55277e;

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
            this.f55277e = pbEmotionBar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            String trim = editable.toString().trim();
            if (TextUtils.isEmpty(trim)) {
                if (this.f55277e.t == null || ListUtils.isEmpty(this.f55277e.t.a())) {
                    return;
                }
                this.f55277e.f55271g.e(this.f55277e.t.a());
                this.f55277e.f55271g.notifyDataSetChanged();
                return;
            }
            if (this.f55277e.D == null) {
                this.f55277e.D = new c.a.r0.j2.k.e.b1.g.b();
                this.f55277e.D.g(this.f55277e.F);
            }
            this.f55277e.D.f(trim);
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

    /* loaded from: classes7.dex */
    public class d implements SearchEmotionModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f55278a;

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
            this.f55278a = pbEmotionBar;
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, c.a.r0.q0.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || aVar == null || ListUtils.isEmpty(aVar.a()) || !this.f55278a.v.getText().toString().trim().equals(str)) {
                return;
            }
            this.f55278a.f55271g.e(aVar.a());
            this.f55278a.f55271g.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout.LayoutParams f55279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f55280f;

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
            this.f55280f = pbEmotionBar;
            this.f55279e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f55279e.leftMargin = intValue;
                this.f55280f.s(intValue);
                PbEmotionBar pbEmotionBar = this.f55280f;
                pbEmotionBar.r(pbEmotionBar.l(this.f55279e.leftMargin));
                this.f55280f.setLayoutParams(this.f55279e);
                this.f55280f.o(this.f55279e.leftMargin);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f55281e;

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
            this.f55281e = pbEmotionBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (((RelativeLayout.LayoutParams) this.f55281e.getLayoutParams()).leftMargin <= 0) {
                    this.f55281e.setCanShowEmotionPreview(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f55282e;

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
            this.f55282e = pbEmotionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55282e.v.requestFocus();
                l.K(this.f55282e.getContext(), this.f55282e.v);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f55283a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbEmotionBar f55284b;

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
            this.f55284b = pbEmotionBar;
            this.f55283a = iVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.i
        public void a(String str, List<String> list, List<String> list2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, list, list2) == null) || this.f55284b.t == null) {
                return;
            }
            this.f55283a.a(this.f55284b.v.getText().toString(), this.f55284b.t.b(), list2);
            TiebaStatic.log("c12177");
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.i
        public void b(EmotionImageData emotionImageData, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, z) == null) {
                this.f55283a.b(emotionImageData, z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface i {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes7.dex */
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
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            this.B = z;
        }
    }

    public void autoAnimate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
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
            q(i2, i3);
        }
    }

    public void autoShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            autoAnimate(true);
            if (z) {
                c.a.e.e.m.e.a().postDelayed(new g(this), 300L);
            }
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean canClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean canShowPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public void cancelLoadData() {
        c.a.r0.j2.k.e.b1.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.D) == null) {
            return;
        }
        bVar.e();
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
            this.f55269e.requestDisallowInterceptTouchEvent(true);
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
                this.f55272h = motionEvent.getRawX();
                this.f55273i = motionEvent.getRawY();
                this.f55274j = motionEvent.getRawX();
            }
            this.f55274j = motionEvent.getRawX();
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public int getMaxLeftMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m : invokeV.intValue;
    }

    public final int l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? (int) ((this.k * i2) + this.p) : invokeI.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setId(R.id.pb_emotion_bar);
            LinearLayout.inflate(getContext(), R.layout.layout_pb_emotion_bar, this);
            setOrientation(1);
            setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.f55270f = (HListView) findViewById(R.id.lv_emotion);
            c.a.r0.j2.k.e.b1.g.a aVar = new c.a.r0.j2.k.e.b1.g.a();
            this.f55271g = aVar;
            aVar.f(this);
            this.f55270f.setAdapter((ListAdapter) this.f55271g);
            this.f55270f.setDividerWidth(l.g(getContext(), R.dimen.ds7));
            this.f55270f.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
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
            onChangeSkinType();
        }
    }

    public final boolean n(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getRawX() - this.f55272h);
            float abs2 = Math.abs(motionEvent.getRawY() - this.f55273i);
            float f2 = this.n;
            return abs < f2 && abs2 < f2;
        }
        return invokeL.booleanValue;
    }

    public final void o(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (jVar = this.s) == null) {
            return;
        }
        int i3 = this.m;
        jVar.onMove((i3 - i2) * (1.0f / i3));
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
            this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            c.a.r0.j2.k.e.b1.g.a aVar = this.f55271g;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.r0.j2.k.e.b1.g.a aVar = this.f55271g;
            if (aVar != null) {
                aVar.d();
            }
            cancelLoadData();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                } else if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.m && n(motionEvent)) {
                    autoAnimate(true);
                }
                return p(motionEvent);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
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
                    int rawX = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.f55274j));
                    if (rawX >= 0 && rawX <= (i2 = this.m)) {
                        i2 = rawX;
                    }
                    if (layoutParams.leftMargin != i2) {
                        layoutParams.leftMargin = i2;
                        int l = l(i2);
                        if (l <= this.p && l >= this.o) {
                            s(i2);
                            r(l);
                            o(layoutParams.leftMargin);
                        }
                        setLayoutParams(layoutParams);
                    }
                }
                return true;
            }
            this.x.computeCurrentVelocity(1000, this.z);
            float xVelocity = this.x.getXVelocity();
            int rawX2 = (int) (motionEvent.getRawX() - this.f55272h);
            if (Math.abs(xVelocity) <= this.y || Math.abs(rawX2) <= this.A) {
                if (layoutParams.leftMargin > this.l * 0.4d) {
                    autoAnimate(false);
                } else {
                    autoAnimate(true);
                }
            } else if (rawX2 > 0) {
                autoAnimate(false);
            } else {
                autoAnimate(true);
            }
            this.x.clear();
            this.x.recycle();
            this.x = null;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean p(MotionEvent motionEvent) {
        InterceptResult invokeL;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            if (n(motionEvent)) {
                return false;
            }
            if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                return true;
            }
            if (this.f55270f.getChildCount() <= 0 || this.f55270f.getFirstVisiblePosition() != 0 || (childAt = this.f55270f.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.f55274j) {
                setCanShowEmotionPreview(true);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || i2 == i3) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new e(this, (RelativeLayout.LayoutParams) getLayoutParams()));
        ofInt.addListener(new f(this));
        ofInt.setDuration(300L).start();
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f55270f.getLayoutParams().height = (this.q * 2) + i2;
            this.f55271g.h(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            float f2 = 1.0f - ((i2 * 1.0f) / this.m);
            this.u.getLayoutParams().height = (int) (this.r * f2);
            this.u.setAlpha(f2);
            this.w.setScaleX(f2);
            this.w.setScaleY(f2);
            this.v.setTextSize(0, l.g(getContext(), R.dimen.fontsize32) * f2);
        }
    }

    public void setOnEmotionClickListener(i iVar) {
        c.a.r0.j2.k.e.b1.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, iVar) == null) || iVar == null || (aVar = this.f55271g) == null) {
            return;
        }
        aVar.g(new h(this, iVar));
    }

    public void setOnMoveListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jVar) == null) {
            this.s = jVar;
        }
    }

    public void showView(RelativeLayout relativeLayout, c.a.r0.j2.k.e.b1.e.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048598, this, relativeLayout, aVar, z) == null) || aVar == null || aVar.a() == null || aVar.a().isEmpty()) {
            return;
        }
        this.f55269e = relativeLayout;
        this.t = aVar;
        this.f55271g.e(aVar.a());
        r(this.o);
        s(this.m);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.m;
        layoutParams.addRule(12);
        relativeLayout.addView(this, layoutParams);
        if (z) {
            return;
        }
        setVisibility(8);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void startShowPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void startStopPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
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
        m();
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
        m();
    }
}
