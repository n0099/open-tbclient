package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ShareGridLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final int DEFAULT_MARGIN_LEFT_RIGHT;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57356e;

    /* renamed from: f  reason: collision with root package name */
    public int f57357f;

    /* renamed from: g  reason: collision with root package name */
    public int f57358g;

    /* renamed from: h  reason: collision with root package name */
    public int f57359h;

    /* renamed from: i  reason: collision with root package name */
    public int f57360i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(882631482, "Lcom/baidu/tieba/transmitShare/ShareGridLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(882631482, "Lcom/baidu/tieba/transmitShare/ShareGridLayout;");
                return;
            }
        }
        DEFAULT_MARGIN_LEFT_RIGHT = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareGridLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f57356e = context;
            b(0, l.k(context) - (DEFAULT_MARGIN_LEFT_RIGHT * 2));
        }
    }

    public final void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            int i4 = i3 - i2;
            if (l.k(TbadkCoreApplication.getInst()) > 800 && this.f57357f * 5 <= i4) {
                this.f57359h = 5;
            } else {
                this.f57359h = 4;
            }
            int i5 = this.f57357f;
            int i6 = this.f57359h;
            double d2 = i4 - (i5 * i6);
            if (d2 <= 0.0d) {
                this.f57360i = 0;
            } else if (i6 == 5) {
                this.f57360i = (int) Math.floor(d2 / 10.0d);
            } else {
                this.f57360i = (int) Math.floor(d2 / 8.0d);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            b(i2, i4);
            int i6 = this.f57360i;
            int childCount = getChildCount();
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < childCount) {
                getChildAt(i7).layout(i6, i8, this.f57357f + i6, this.f57358g + i8);
                i9++;
                int i10 = i6 + this.f57357f;
                int i11 = this.f57360i;
                i6 = i10 + (i11 * 2);
                if (i9 >= this.f57359h) {
                    i6 = i11;
                    i9 = 0;
                }
                i7++;
                i8 = (i7 / this.f57359h) * this.f57358g;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f57357f, Integer.MIN_VALUE);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f57358g, Integer.MIN_VALUE);
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                getChildAt(i4).measure(makeMeasureSpec, makeMeasureSpec2);
            }
            int i5 = this.f57359h;
            if (childCount <= i5) {
                setMeasuredDimension(ViewGroup.resolveSize((this.f57357f * i5) + (this.f57360i * 2 * i5), i2), ViewGroup.resolveSize(this.f57358g, i3));
                return;
            }
            int i6 = childCount / i5;
            if (childCount % i5 > 0) {
                i6++;
            }
            int i7 = this.f57357f;
            int i8 = this.f57359h;
            setMeasuredDimension(ViewGroup.resolveSize((i7 * i8) + (this.f57360i * 2 * i8), i2), ViewGroup.resolveSize(this.f57358g * i6, i3));
        }
    }

    public void setItemParams(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.f57357f = i2;
            this.f57358g = i3;
            requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareGridLayout(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
