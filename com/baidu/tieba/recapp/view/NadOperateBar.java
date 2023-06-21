package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.d61;
import com.baidu.tieba.o31;
import com.baidu.tieba.recapp.lego.view.AdCardBaseView;
import com.baidu.tieba.recapp.lego.view.XfremodeRoundLayout;
import com.baidu.tieba.recapp.view.NadOperateBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.gslbsdk.db.DelayTB;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010+\u001a\u00020\u000eH\u0002J\u0010\u0010,\u001a\u0004\u0018\u00010\u00182\u0006\u0010-\u001a\u00020\u000eJ\b\u0010.\u001a\u00020/H\u0014J\u0016\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u000eJ\u0010\u00103\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u000105J\u0016\u00106\u001a\u00020/2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b'\u0010\u001aR\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/baidu/tieba/recapp/view/NadOperateBar;", "Lcom/baidu/tieba/recapp/lego/view/XfremodeRoundLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adAppInfo", "Lcom/baidu/tbadk/core/data/AdvertAppInfo;", "animCallback", "Lcom/baidu/tieba/recapp/lego/view/AdCardBaseView$IOperateExpandAnimCallback;", "containRecommendReason", "", "getContainRecommendReason", "()Z", "setContainRecommendReason", "(Z)V", "isAddAnimRunable", "setAddAnimRunable", "isExpanded", "setExpanded", "longButtonContainer", "Landroid/widget/RelativeLayout;", "getLongButtonContainer", "()Landroid/widget/RelativeLayout;", "longButtonContainer$delegate", "Lkotlin/Lazy;", "mainHandler", "Landroid/os/Handler;", "parentCardView", "Lcom/baidu/tieba/recapp/lego/view/AdCardBaseView;", "recommendReason", "Landroid/widget/TextView;", "getRecommendReason", "()Landroid/widget/TextView;", "recommendReason$delegate", "shortButtonContainer", "getShortButtonContainer", "shortButtonContainer$delegate", "startAnimation", "Ljava/lang/Runnable;", "checkCanExpand", "getDownloadButtonContainer", "isShortButton", "onDetachedFromWindow", "", "setAdInfo", "info", "isOperateExpanded", "setRecommendReason", "reason", "", "startExpandAnim", DelayTB.DELAY, "", WebChromeClient.KEY_ARG_CALLBACK, "Companion", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NadOperateBar extends XfremodeRoundLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public boolean g;
    public boolean h;
    public boolean i;
    public AdvertAppInfo j;
    public AdCardBaseView k;
    public AdCardBaseView.p l;
    public final Handler m;
    public final Runnable n;
    public Map<Integer, View> o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1179639285, "Lcom/baidu/tieba/recapp/view/NadOperateBar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1179639285, "Lcom/baidu/tieba/recapp/view/NadOperateBar;");
                return;
            }
        }
        new Companion(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadOperateBar(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadOperateBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Map<Integer, View> map = this.o;
            View view2 = map.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                if (findViewById != null) {
                    map.put(Integer.valueOf(i), findViewById);
                    return findViewById;
                }
                return null;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/recapp/view/NadOperateBar$Companion;", "", "()V", "BG_SCALE_ANIMATOR_DURATION", "", "OPERATE_HEIGHT", "", "TEXT_ALPHA_ANIMATOR_DELAY", "TEXT_ALPHA_ANIMATOR_DURATION", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadOperateBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.o = new LinkedHashMap();
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>(this) { // from class: com.baidu.tieba.recapp.view.NadOperateBar$shortButtonContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadOperateBar this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (RelativeLayout) this.this$0.findViewById(R.id.obfuscated_res_0x7f09195c);
                }
                return (RelativeLayout) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>(this) { // from class: com.baidu.tieba.recapp.view.NadOperateBar$longButtonContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadOperateBar this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (RelativeLayout) this.this$0.findViewById(R.id.obfuscated_res_0x7f09195a);
                }
                return (RelativeLayout) invokeV.objValue;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.recapp.view.NadOperateBar$recommendReason$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadOperateBar this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.obfuscated_res_0x7f09195b);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.m = new Handler(Looper.getMainLooper());
        this.n = new Runnable() { // from class: com.baidu.tieba.yp9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    NadOperateBar.c(NadOperateBar.this);
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0683, this);
        getRecommendReason().setTextColor(SkinManager.getColor(R.color.CAM_X0304));
        this.i = false;
        this.h = false;
    }

    public /* synthetic */ NadOperateBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final RelativeLayout getDownloadButtonContainer(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (z) {
                return getShortButtonContainer();
            }
            return getLongButtonContainer();
        }
        return (RelativeLayout) invokeZ.objValue;
    }

    public final void setAddAnimRunable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.h = z;
        }
    }

    public final void setContainRecommendReason(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.g = z;
        }
    }

    public final void setExpanded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.i = z;
        }
    }

    public static final void c(final NadOperateBar this$0) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.i && this$0.b()) {
                this$0.setVisibility(0);
                AdCardBaseView.p pVar = this$0.l;
                if (pVar != null) {
                    pVar.onAnimStart();
                }
                ClogBuilder clogBuilder = new ClogBuilder();
                ClogBuilder v = clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).v("OPERATE");
                AdvertAppInfo advertAppInfo = this$0.j;
                String str = null;
                if (advertAppInfo != null) {
                    num = Integer.valueOf(advertAppInfo.position + 1);
                } else {
                    num = null;
                }
                ClogBuilder q = v.q(String.valueOf(num));
                AdvertAppInfo advertAppInfo2 = this$0.j;
                if (advertAppInfo2 != null) {
                    str = advertAppInfo2.g;
                }
                q.p(str);
                o31.b(clogBuilder);
                AnimatorSet animatorSet = new AnimatorSet();
                final ValueAnimator ofInt = ValueAnimator.ofInt(0, d61.c.a(this$0.getContext(), 34.6f));
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.xp9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            NadOperateBar.d(NadOperateBar.this, ofInt, valueAnimator);
                        }
                    }
                });
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0, View.ALPHA, 0.0f, 1.0f);
                ofFloat.setDuration(300L);
                animatorSet.play(ofInt).with(ofFloat);
                if (this$0.g) {
                    this$0.getRecommendReason().setVisibility(0);
                    View childAt = this$0.getShortButtonContainer().getChildAt(0);
                    if (childAt == null) {
                        this$0.h = false;
                    } else {
                        childAt.setVisibility(0);
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.getRecommendReason(), View.ALPHA, 0.0f, 1.0f);
                        ofFloat2.setDuration(250L);
                        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(childAt, View.ALPHA, 0.0f, 1.0f);
                        ofFloat3.setDuration(250L);
                        animatorSet.play(ofFloat2).with(ofFloat3).after(150L);
                        animatorSet.addListener(new AnimatorListenerAdapter(this$0) { // from class: com.baidu.tieba.recapp.view.NadOperateBar$startAnimation$1$1$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NadOperateBar a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this$0};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this$0;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                AdCardBaseView.p pVar2;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null && interceptable2.invokeL(1048576, this, animator) != null) {
                                    return;
                                }
                                pVar2 = this.a.l;
                                if (pVar2 != null) {
                                    pVar2.a(Boolean.TRUE);
                                }
                                this.a.setAddAnimRunable(false);
                                this.a.setExpanded(true);
                            }
                        });
                    }
                } else {
                    View childAt2 = this$0.getLongButtonContainer().getChildAt(0);
                    if (childAt2 == null) {
                        this$0.h = false;
                    } else {
                        childAt2.setVisibility(0);
                        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(childAt2, View.ALPHA, 0.0f, 1.0f);
                        ofFloat4.setDuration(250L);
                        animatorSet.play(ofFloat4).after(150L);
                        animatorSet.addListener(new AnimatorListenerAdapter(this$0) { // from class: com.baidu.tieba.recapp.view.NadOperateBar$startAnimation$1$1$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NadOperateBar a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = objArr;
                                    Object[] objArr = {this$0};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this$0;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                AdCardBaseView.p pVar2;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null && interceptable2.invokeL(1048576, this, animator) != null) {
                                    return;
                                }
                                pVar2 = this.a.l;
                                if (pVar2 != null) {
                                    pVar2.a(Boolean.TRUE);
                                }
                                this.a.setAddAnimRunable(false);
                                this.a.setExpanded(true);
                            }
                        });
                    }
                }
                animatorSet.start();
                return;
            }
            this$0.h = false;
        }
    }

    public static final void d(NadOperateBar this$0, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, this$0, valueAnimator, valueAnimator2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewGroup.LayoutParams layoutParams = this$0.getLayoutParams();
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                layoutParams.height = ((Integer) animatedValue).intValue();
                this$0.requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ViewParent parent = getParent();
            while (true) {
                if (parent == null) {
                    break;
                } else if (parent instanceof AdCardBaseView) {
                    this.k = (AdCardBaseView) parent;
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
            Rect rect = new Rect();
            AdCardBaseView adCardBaseView = this.k;
            if (adCardBaseView != null) {
                adCardBaseView.getLocalVisibleRect(rect);
            }
            AdCardBaseView adCardBaseView2 = this.k;
            if (adCardBaseView2 != null) {
                i = adCardBaseView2.getMeasuredHeight();
            } else {
                i = Integer.MAX_VALUE;
            }
            if (rect.height() < i) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean getContainRecommendReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final RelativeLayout getLongButtonContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object value = this.e.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-longButtonContainer>(...)");
            return (RelativeLayout) value;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final TextView getRecommendReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Object value = this.f.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-recommendReason>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    public final RelativeLayout getShortButtonContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object value = this.d.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-shortButtonContainer>(...)");
            return (RelativeLayout) value;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final boolean isAddAnimRunable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final boolean isExpanded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            this.m.removeCallbacks(this.n);
        }
    }

    public final void setAdInfo(AdvertAppInfo info, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, info, z) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.j = info;
            this.i = z;
            this.h = false;
        }
    }

    public final void startExpandAnim(long j, AdCardBaseView.p callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (!this.i && !this.h) {
                this.l = callback;
                this.m.postDelayed(this.n, j);
                this.h = true;
            }
        }
    }

    public final void setRecommendReason(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                getRecommendReason().setVisibility(8);
                this.g = false;
                return;
            }
            this.g = true;
            getRecommendReason().setText(str);
            getRecommendReason().setVisibility(0);
        }
    }
}
