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
import c.a.s0.s.q.z1;
import c.a.t0.t3.h.b;
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
/* loaded from: classes12.dex */
public class SignStampIconsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final int f48091h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f48092i;

    /* renamed from: j  reason: collision with root package name */
    public static final int f48093j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f48094e;

    /* renamed from: f  reason: collision with root package name */
    public b f48095f;

    /* renamed from: g  reason: collision with root package name */
    public List<ImageView> f48096g;

    /* loaded from: classes12.dex */
    public class a extends c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SignStampIconsView f48097b;

        public a(SignStampIconsView signStampIconsView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signStampIconsView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48097b = signStampIconsView;
            this.a = tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((a) aVar, str, i2);
                this.f48097b.f(aVar, this.a);
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
        f48091h = UtilHelper.getDimenPixelSize(R.dimen.tbds62);
        f48092i = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
        f48093j = UtilHelper.getDimenPixelSize(R.dimen.M_W_X012);
        k = R.string.J_X01;
        l = UtilHelper.getDimenPixelSize(R.dimen.tbds94);
        m = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        n = R.color.CAM_X0101;
        o = R.color.CAM_X0103;
        p = R.dimen.T_X08;
        int i2 = l;
        q = (int) (((i2 * 1.44f) - i2) / 2.0f);
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
            View view = new View(this.f48094e);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(f48091h, f48092i);
            int i2 = f48093j;
            int i3 = q;
            marginLayoutParams.leftMargin = i2 - i3;
            marginLayoutParams.rightMargin = i2 - i3;
            view.setLayoutParams(marginLayoutParams);
            view.setTag("crossLine");
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(view);
            d2.n(k);
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

    public final View c(final z1.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            TbImageView tbImageView = new TbImageView(this.f48094e);
            int i2 = l;
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i2, i2);
            int i3 = q;
            marginLayoutParams.topMargin = i3;
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i3;
            tbImageView.setLayoutParams(marginLayoutParams);
            g(aVar, tbImageView);
            TextView textView = new TextView(this.f48094e);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams2.topMargin = m;
            textView.setLayoutParams(marginLayoutParams2);
            textView.setText(String.format(getResources().getString(R.string.stamp_level), Integer.valueOf(aVar.a())));
            if (aVar.e() == 1) {
                c.a.s0.s.u.c.d(textView).v(n);
            } else {
                c.a.s0.s.u.c.d(textView).v(o);
            }
            c.a.s0.s.u.c.d(textView).z(p);
            LinearLayout linearLayout = new LinearLayout(this.f48094e);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(tbImageView);
            linearLayout.addView(textView);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: c.a.t0.t3.j.c
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
            this.f48096g.add(tbImageView);
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

    public /* synthetic */ void e(z1.a aVar, View view) {
        if (aVar.f()) {
            return;
        }
        i();
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            if (linearLayout.getChildCount() > 0) {
                h(linearLayout.getChildAt(0), 1.44f, 1.44f, 70L);
            }
        }
        b bVar = this.f48095f;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public final void f(c.a.d.n.d.a aVar, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, aVar, tbImageView) == null) || aVar == null || !aVar.w() || tbImageView == null) {
            return;
        }
        tbImageView.setImageBitmap(transformationGrey(aVar.p()));
    }

    public final void g(z1.a aVar, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, tbImageView) == null) || aVar == null) {
            return;
        }
        if (aVar.e() != 1) {
            a aVar2 = new a(this, tbImageView);
            c.a.d.n.d.a aVar3 = (c.a.d.n.d.a) d.h().n(aVar.d(), 10, new Object[0]);
            if (aVar3 != null && aVar3.w()) {
                f(aVar3, tbImageView);
                return;
            } else {
                d.h().m(aVar.d(), 10, aVar2, null);
                return;
            }
        }
        tbImageView.startLoad(aVar.d(), 10, false);
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

    public final void i() {
        List<ImageView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (list = this.f48096g) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
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
                        childAt2.layout(childAt2.getLeft(), top - (f48092i / 2), childAt2.getRight(), (f48092i / 2) + top);
                    }
                }
            }
        }
    }

    public void setSignStampIconClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f48095f = bVar;
        }
    }

    public void setStampIconsList(List<z1.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || list == null) {
            return;
        }
        Iterator<z1.a> it = list.iterator();
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

    public Bitmap transformationGrey(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bitmap)) == null) {
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
        this.f48094e = context;
        this.f48096g = new ArrayList();
        d();
    }
}
