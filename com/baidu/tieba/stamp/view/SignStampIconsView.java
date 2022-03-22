package com.baidu.tieba.stamp.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.l.c;
import c.a.d.f.l.d;
import c.a.o0.r.r.w1;
import c.a.p0.w3.h.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.stamp.view.SignStampIconsView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class SignStampIconsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f36055d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f36056e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f36057f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f36058g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f36059h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public b f36060b;

    /* renamed from: c  reason: collision with root package name */
    public List<ImageView> f36061c;

    /* loaded from: classes6.dex */
    public class a extends c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SignStampIconsView f36062b;

        public a(SignStampIconsView signStampIconsView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signStampIconsView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36062b = signStampIconsView;
            this.a = tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((a) aVar, str, i);
                this.f36062b.f(aVar, this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(327092082, "Lcom/baidu/tieba/stamp/view/SignStampIconsView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(327092082, "Lcom/baidu/tieba/stamp/view/SignStampIconsView;");
                return;
            }
        }
        f36055d = UtilHelper.getDimenPixelSize(R.dimen.tbds62);
        f36056e = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
        f36057f = UtilHelper.getDimenPixelSize(R.dimen.M_W_X012);
        f36058g = R.string.J_X01;
        f36059h = UtilHelper.getDimenPixelSize(R.dimen.tbds94);
        i = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        j = R.color.CAM_X0101;
        k = R.color.CAM_X0103;
        l = R.dimen.T_X08;
        int i2 = f36059h;
        m = (int) (((i2 * 1.44f) - i2) / 2.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SignStampIconsView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private View getCrossLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            View view = new View(this.a);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(f36055d, f36056e);
            int i2 = f36057f;
            int i3 = m;
            marginLayoutParams.leftMargin = i2 - i3;
            marginLayoutParams.rightMargin = i2 - i3;
            view.setLayoutParams(marginLayoutParams);
            view.setTag("crossLine");
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(view);
            d2.n(f36058g);
            d2.p(new int[]{R.color.CAM_X0612, R.color.CAM_X0618}, Direction.LEFT);
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final ObjectAnimator b(float f2, float f3, long j2, View view) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2), view})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f3));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final View c(final w1.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            TbImageView tbImageView = new TbImageView(this.a);
            int i2 = f36059h;
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i2, i2);
            int i3 = m;
            marginLayoutParams.topMargin = i3;
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i3;
            tbImageView.setPlaceHolder(0);
            tbImageView.setLayoutParams(marginLayoutParams);
            g(aVar, tbImageView);
            TextView textView = new TextView(this.a);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams2.topMargin = i;
            textView.setLayoutParams(marginLayoutParams2);
            textView.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f11b9), Integer.valueOf(aVar.a())));
            if (aVar.e() == 1) {
                c.a.o0.r.v.c.d(textView).v(j);
            } else {
                c.a.o0.r.v.c.d(textView).v(k);
            }
            c.a.o0.r.v.c.d(textView).z(l);
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(tbImageView);
            linearLayout.addView(textView);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.w3.j.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        SignStampIconsView.this.e(aVar, view);
                    }
                }
            });
            this.f36061c.add(tbImageView);
            return linearLayout;
        }
        return (View) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOrientation(0);
        }
    }

    public /* synthetic */ void e(w1.a aVar, View view) {
        if (aVar.f()) {
            return;
        }
        j();
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            if (linearLayout.getChildCount() > 0) {
                h(linearLayout.getChildAt(0), 1.44f, 1.44f, 70L);
            }
        }
        b bVar = this.f36060b;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public final void f(c.a.d.o.d.a aVar, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, aVar, tbImageView) == null) || aVar == null || !aVar.w() || tbImageView == null) {
            return;
        }
        tbImageView.setImageBitmap(i(aVar.p()));
    }

    public final void g(w1.a aVar, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, tbImageView) == null) || aVar == null) {
            return;
        }
        if (aVar.e() != 1) {
            a aVar2 = new a(this, tbImageView);
            c.a.d.o.d.a aVar3 = (c.a.d.o.d.a) d.h().n(aVar.d(), 10, new Object[0]);
            if (aVar3 != null && aVar3.w()) {
                f(aVar3, tbImageView);
                return;
            } else {
                d.h().m(aVar.d(), 10, aVar2, null);
                return;
            }
        }
        tbImageView.J(aVar.d(), 10, false);
        if (aVar.f()) {
            h(tbImageView, 1.44f, 1.44f, 70L);
        }
    }

    public final void h(View view, float f2, float f3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)}) == null) {
            b(f2, f3, j2, view).start();
        }
    }

    public Bitmap i(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bitmap)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void j() {
        List<ImageView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.f36061c) == null) {
            return;
        }
        for (ImageView imageView : list) {
            if (imageView != null) {
                h(imageView, 1.0f, 1.0f, 70L);
                imageView.clearAnimation();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int childCount = getChildCount();
            if (childCount <= 1) {
                return;
            }
            View childAt = getChildAt(0);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                int top = (linearLayout.getChildAt(0).getTop() + linearLayout.getChildAt(0).getBottom()) / 2;
                for (int i6 = 0; i6 < childCount - 1; i6++) {
                    View childAt2 = getChildAt(i6);
                    if ("crossLine".equals(childAt2.getTag())) {
                        childAt2.layout(childAt2.getLeft(), top - (f36056e / 2), childAt2.getRight(), (f36056e / 2) + top);
                    }
                }
            }
        }
    }

    public void setSignStampIconClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f36060b = bVar;
        }
    }

    public void setStampIconsList(List<w1.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null) {
            return;
        }
        Iterator<w1.a> it = list.iterator();
        while (it.hasNext()) {
            View c2 = c(it.next());
            if (c2 != null) {
                addView(c2);
                if (it.hasNext()) {
                    addView(getCrossLine());
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SignStampIconsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignStampIconsView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.a = context;
        this.f36061c = new ArrayList();
        d();
    }
}
