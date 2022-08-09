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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.dr4;
import com.repackage.jg;
import com.repackage.kg;
import com.repackage.ms4;
import com.repackage.vi8;
import com.repackage.zm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class SignStampIconsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public vi8 b;
    public List<ImageView> c;

    /* loaded from: classes4.dex */
    public class a extends jg<zm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;
        public final /* synthetic */ SignStampIconsView b;

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
            this.b = signStampIconsView;
            this.a = tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jg
        public void onLoaded(zm zmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, zmVar, str, i) == null) {
                super.onLoaded((a) zmVar, str, i);
                this.b.f(zmVar, this.a);
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
        d = UtilHelper.getDimenPixelSize(R.dimen.tbds62);
        e = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
        f = UtilHelper.getDimenPixelSize(R.dimen.M_W_X012);
        g = R.string.J_X01;
        h = UtilHelper.getDimenPixelSize(R.dimen.tbds94);
        i = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        j = R.color.CAM_X0101;
        k = R.color.CAM_X0103;
        l = R.dimen.T_X08;
        int i2 = h;
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
            View view2 = new View(this.a);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(d, e);
            int i2 = f;
            int i3 = m;
            marginLayoutParams.leftMargin = i2 - i3;
            marginLayoutParams.rightMargin = i2 - i3;
            view2.setLayoutParams(marginLayoutParams);
            view2.setTag("crossLine");
            ms4 d2 = ms4.d(view2);
            d2.n(g);
            d2.p(new int[]{R.color.CAM_X0612, R.color.CAM_X0618}, Direction.LEFT);
            return view2;
        }
        return (View) invokeV.objValue;
    }

    public final ObjectAnimator b(float f2, float f3, long j2, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2), view2})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(Key.SCALE_X, f2), PropertyValuesHolder.ofFloat(Key.SCALE_Y, f3));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final View c(final dr4.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            TbImageView tbImageView = new TbImageView(this.a);
            int i2 = h;
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
            textView.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f11de), Integer.valueOf(aVar.a())));
            if (aVar.e() == 1) {
                ms4.d(textView).v(j);
            } else {
                ms4.d(textView).v(k);
            }
            ms4.d(textView).z(l);
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(tbImageView);
            linearLayout.addView(textView);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.aj8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SignStampIconsView.this.e(aVar, view2);
                    }
                }
            });
            this.c.add(tbImageView);
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

    public /* synthetic */ void e(dr4.a aVar, View view2) {
        if (aVar.f()) {
            return;
        }
        j();
        if (view2 instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view2;
            if (linearLayout.getChildCount() > 0) {
                h(linearLayout.getChildAt(0), 1.44f, 1.44f, 70L);
            }
        }
        vi8 vi8Var = this.b;
        if (vi8Var != null) {
            vi8Var.a(aVar);
        }
    }

    public final void f(zm zmVar, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, zmVar, tbImageView) == null) || zmVar == null || !zmVar.w() || tbImageView == null) {
            return;
        }
        tbImageView.setImageBitmap(i(zmVar.p()));
    }

    public final void g(dr4.a aVar, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, tbImageView) == null) || aVar == null) {
            return;
        }
        if (aVar.e() != 1) {
            a aVar2 = new a(this, tbImageView);
            zm zmVar = (zm) kg.h().n(aVar.d(), 10, new Object[0]);
            if (zmVar != null && zmVar.w()) {
                f(zmVar, tbImageView);
                return;
            } else {
                kg.h().m(aVar.d(), 10, aVar2, null);
                return;
            }
        }
        tbImageView.K(aVar.d(), 10, false);
        if (aVar.f()) {
            h(tbImageView, 1.44f, 1.44f, 70L);
        }
    }

    public final void h(View view2, float f2, float f3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)}) == null) {
            b(f2, f3, j2, view2).start();
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.c) == null) {
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
                        childAt2.layout(childAt2.getLeft(), top - (e / 2), childAt2.getRight(), (e / 2) + top);
                    }
                }
            }
        }
    }

    public void setSignStampIconClickListener(vi8 vi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vi8Var) == null) {
            this.b = vi8Var;
        }
    }

    public void setStampIconsList(List<dr4.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null) {
            return;
        }
        Iterator<dr4.a> it = list.iterator();
        while (it.hasNext()) {
            View c = c(it.next());
            if (c != null) {
                addView(c);
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
        this.c = new ArrayList();
        d();
    }
}
