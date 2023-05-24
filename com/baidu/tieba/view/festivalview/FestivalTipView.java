package com.baidu.tieba.view.festivalview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.f0a;
import com.baidu.tieba.p45;
import com.baidu.tieba.ri;
import com.baidu.tieba.s5a;
import com.baidu.tieba.t5a;
import com.baidu.tieba.v5a;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.wv5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\u0006\u0010(\u001a\u00020 J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/tieba/view/festivalview/FestivalTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "festivalTipViewClickCallBack", "Lcom/baidu/tieba/view/festivalview/FestivalTipViewClickCallBack;", "getFestivalTipViewClickCallBack", "()Lcom/baidu/tieba/view/festivalview/FestivalTipViewClickCallBack;", "setFestivalTipViewClickCallBack", "(Lcom/baidu/tieba/view/festivalview/FestivalTipViewClickCallBack;)V", "festivalTipViewData", "Lcom/baidu/tieba/view/festivalview/FestivalTipViewData;", "getFestivalTipViewData", "()Lcom/baidu/tieba/view/festivalview/FestivalTipViewData;", "setFestivalTipViewData", "(Lcom/baidu/tieba/view/festivalview/FestivalTipViewData;)V", "festivalTipViewStyle", "Lcom/baidu/tieba/view/festivalview/FestivalTipViewStyle;", "getFestivalTipViewStyle", "()Lcom/baidu/tieba/view/festivalview/FestivalTipViewStyle;", "setFestivalTipViewStyle", "(Lcom/baidu/tieba/view/festivalview/FestivalTipViewStyle;)V", "icon", "Lcom/baidu/tbadk/widget/image/TbImage;", "text", "Landroid/widget/TextView;", "bindData", "", "changeSkin", "shouldSetUrl", "", "initIcon", "initListener", "initRoot", "initText", "resetView", "setIconUrl", "iconUrl", "Lcom/baidu/tieba/view/festivalview/FestivalTipViewData$IconUrl;", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FestivalTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;
    public t5a a;
    public v5a b;
    public s5a c;
    public final TbImage d;
    public final TextView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FestivalTipView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FestivalTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1939238953, "Lcom/baidu/tieba/view/festivalview/FestivalTipView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1939238953, "Lcom/baidu/tieba/view/festivalview/FestivalTipView;");
                return;
            }
        }
        f = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        g = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
        h = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        i = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        j = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X006);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FestivalTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        this.d = new TbImage(context2, null, 0, 6, null);
        this.e = new TextView(getContext());
        f();
        c();
        g();
        d();
    }

    public /* synthetic */ FestivalTipView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final void e(FestivalTipView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            s5a s5aVar = this$0.c;
            if (s5aVar != null) {
                Intrinsics.checkNotNullExpressionValue(view2, "view");
                s5aVar.onClick(view2);
            }
        }
    }

    private final void setIconUrl(t5a.b bVar) {
        String b;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, bVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0) {
                if (skinType != 4) {
                    b = "";
                } else {
                    b = bVar.a();
                }
            } else {
                b = bVar.b();
            }
            if (b.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.d.k(b);
            }
        }
    }

    @JvmOverloads
    public final void b(boolean z) {
        t5a t5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            v5a v5aVar = this.b;
            if (v5aVar != null) {
                p45 d = p45.d(this);
                d.o(R.string.J_X01);
                d.h(f0a.b(v5aVar.b()));
                this.e.setTextColor(f0a.b(v5aVar.c()));
            }
            if (z && (t5aVar = this.a) != null) {
                setIconUrl(t5aVar.b());
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            t5a t5aVar = this.a;
            if (t5aVar != null) {
                this.e.setText(t5aVar.d());
                setIconUrl(t5aVar.b());
            } else {
                setVisibility(8);
            }
            b(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.r5a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        FestivalTipView.e(FestivalTipView.this, view2);
                    }
                }
            });
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setOrientation(0);
            setGravity(16);
        }
    }

    public final s5a getFestivalTipViewClickCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (s5a) invokeV.objValue;
    }

    public final t5a getFestivalTipViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (t5a) invokeV.objValue;
    }

    public final v5a getFestivalTipViewStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (v5a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b = null;
            this.a = null;
            this.e.setText((CharSequence) null);
            this.d.setBackground(null);
            this.d.setController(null);
            this.c = null;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = f;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            int i3 = g;
            int i4 = i;
            layoutParams.setMargins(i3, i4, h, i4);
            this.d.setLayoutParams(layoutParams);
            this.d.setPlaceHolderDrawable(wv5.a.a());
            addView(this.d);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = j;
            this.e.setLayoutParams(layoutParams);
            this.e.setSingleLine();
            this.e.setEllipsize(TextUtils.TruncateAt.END);
            p45 d = p45.d(this.e);
            d.B(R.dimen.T_X09);
            d.C(R.string.F_X02);
            addView(this.e);
        }
    }

    public final void setFestivalTipViewClickCallBack(s5a s5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, s5aVar) == null) {
            this.c = s5aVar;
        }
    }

    public final void setFestivalTipViewData(t5a t5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t5aVar) == null) {
            this.a = t5aVar;
        }
    }

    public final void setFestivalTipViewStyle(v5a v5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, v5aVar) == null) {
            this.b = v5aVar;
        }
    }
}
