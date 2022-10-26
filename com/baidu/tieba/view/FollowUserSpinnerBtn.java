package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.fj;
import com.baidu.tieba.vz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements vz4 {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public FrameLayout b;
    public TextView c;
    public ImageView d;
    public Paint e;
    public int f;
    public int g;
    public RectF h;
    public Path i;
    public String j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public b o;

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z, boolean z2);
    }

    @Override // com.baidu.tieba.vz4
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.vz4
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ FollowUserSpinnerBtn b;

        public a(FollowUserSpinnerBtn followUserSpinnerBtn, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {followUserSpinnerBtn, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = followUserSpinnerBtn;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (bVar = this.a) != null) {
                bVar.a(!this.b.l, false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1893154144, "Lcom/baidu/tieba/view/FollowUserSpinnerBtn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1893154144, "Lcom/baidu/tieba/view/FollowUserSpinnerBtn;");
                return;
            }
        }
        p = fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
        q = fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
        r = fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FollowUserSpinnerBtn(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            setBackgroundColor(SkinManager.getColor(this.g));
            SkinManager.setViewTextColor(this.c, this.f);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, this.f, null);
            this.k = pureDrawable;
            this.d.setImageDrawable(pureDrawable);
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet, int i) {
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
        this.m = true;
        g(context);
    }

    @Override // com.baidu.tieba.vz4
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    public void setFirstUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.m = z;
        }
    }

    public void setOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
        }
    }

    public void setOpenListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.o = bVar;
            this.b.setOnClickListener(new a(this, bVar));
        }
    }

    @Override // com.baidu.tieba.vz4
    public void b(boolean z, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            d(z, i);
        }
    }

    @Override // com.baidu.tieba.vz4
    public void d(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            i(z);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            this.h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.i.reset();
            this.i.addRoundRect(this.h, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
            canvas.clipPath(this.i);
            super.draw(canvas);
            if (!this.n) {
                return;
            }
            this.e.setColor(SkinManager.getColor(this.f));
            float right = this.a.getRight();
            canvas.drawLine(right, this.d.getTop(), right, this.d.getBottom(), this.e);
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d029b, this);
            setOrientation(0);
            this.a = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0912b5);
            this.b = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091c23);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f092203);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902ba);
            Paint paint = new Paint(1);
            this.e = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.e.setStrokeCap(Paint.Cap.ROUND);
            this.e.setStrokeWidth(fj.f(context, R.dimen.tbds3));
            this.h = new RectF();
            this.i = new Path();
            this.f = R.color.CAM_X0105;
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, this.f, null);
            this.k = pureDrawable;
            this.d.setImageDrawable(pureDrawable);
        }
    }

    public void i(boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.j = getResources().getString(R.string.obfuscated_res_0x7f0f0662);
                this.f = R.color.CAM_X0101;
                this.g = R.color.CAM_X0904;
            } else {
                this.j = getResources().getString(R.string.obfuscated_res_0x7f0f02b0);
                this.f = R.color.CAM_X0105;
                this.g = R.color.CAM_X0901;
            }
            this.c.setText(this.j);
            requestLayout();
            h(0);
            if (this.n && !this.m && z && !this.l && (bVar = this.o) != null) {
                bVar.a(true, true);
            }
            this.m = false;
        }
    }

    public ImageView getArrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (ImageView) invokeV.objValue;
    }

    public void setShowPullBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.n = z;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            if (z) {
                this.b.setVisibility(0);
                layoutParams.leftMargin = q;
                layoutParams.rightMargin = r;
                layoutParams.gravity = 16;
                layoutParams.width = -2;
            } else {
                this.b.setVisibility(8);
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.gravity = 17;
                layoutParams.width = p;
            }
            this.c.setLayoutParams(layoutParams);
            requestLayout();
        }
    }
}
