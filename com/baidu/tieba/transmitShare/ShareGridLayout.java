package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.d.f.p.n;
import c.a.p0.g4.b;
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
/* loaded from: classes6.dex */
public class ShareGridLayout extends ViewGroup implements b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f36378f;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f36379b;

    /* renamed from: c  reason: collision with root package name */
    public int f36380c;

    /* renamed from: d  reason: collision with root package name */
    public int f36381d;

    /* renamed from: e  reason: collision with root package name */
    public int f36382e;

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
        f36378f = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b(context);
    }

    @Override // c.a.p0.g4.b
    public void a(int i, @NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, view) == null) {
            addView(view);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            c(0, n.k(context) - (f36378f * 2));
        }
    }

    public final void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            int i3 = i2 - i;
            if (n.k(TbadkCoreApplication.getInst()) > 800 && this.f36379b * 5 <= i3) {
                this.f36381d = 5;
            } else {
                this.f36381d = 4;
            }
            int i4 = this.f36379b;
            int i5 = this.f36381d;
            double d2 = i3 - (i4 * i5);
            if (d2 <= 0.0d) {
                this.f36382e = 0;
            } else if (i5 == 5) {
                this.f36382e = (int) Math.floor(d2 / 10.0d);
            } else {
                this.f36382e = (int) Math.floor(d2 / 8.0d);
            }
        }
    }

    @Override // c.a.p0.g4.b
    @NonNull
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            c(i, i3);
            int i5 = this.f36382e;
            int childCount = getChildCount();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < childCount) {
                getChildAt(i6).layout(i5, i7, this.f36379b + i5, this.f36380c + i7);
                i8++;
                int i9 = i5 + this.f36379b;
                int i10 = this.f36382e;
                i5 = i9 + (i10 * 2);
                if (i8 >= this.f36381d) {
                    i5 = i10;
                    i8 = 0;
                }
                i6++;
                i7 = (i6 / this.f36381d) * this.f36380c;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f36379b, Integer.MIN_VALUE);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f36380c, Integer.MIN_VALUE);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
            }
            int i4 = this.f36381d;
            if (childCount <= i4) {
                setMeasuredDimension(ViewGroup.resolveSize((this.f36379b * i4) + (this.f36382e * 2 * i4), i), ViewGroup.resolveSize(this.f36380c, i2));
                return;
            }
            int i5 = childCount / i4;
            if (childCount % i4 > 0) {
                i5++;
            }
            int i6 = this.f36379b;
            int i7 = this.f36381d;
            setMeasuredDimension(ViewGroup.resolveSize((i6 * i7) + (this.f36382e * 2 * i7), i), ViewGroup.resolveSize(this.f36380c * i5, i2));
        }
    }

    @Override // c.a.p0.g4.b
    public void setItemParams(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            this.f36379b = i;
            this.f36380c = i2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareGridLayout(Context context, AttributeSet attributeSet, int i) {
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
        b(context);
    }
}
