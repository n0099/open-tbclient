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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements d.a.r0.r.f0.s.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f22006e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f22007f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22008g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22009h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f22010i;
    public int j;
    public int k;
    public RectF l;
    public Path m;
    public String n;
    public Drawable o;
    public boolean p;
    public boolean q;
    public boolean r;
    public b s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22011e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FollowUserSpinnerBtn f22012f;

        public a(FollowUserSpinnerBtn followUserSpinnerBtn, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {followUserSpinnerBtn, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22012f = followUserSpinnerBtn;
            this.f22011e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = this.f22011e) == null) {
                return;
            }
            bVar.a(!this.f22012f.p, false);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, boolean z2);
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
        t = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
        u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
        v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
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

    @Override // d.a.r0.r.f0.s.b
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
        }
    }

    @Override // d.a.r0.r.f0.s.b
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    @Override // d.a.r0.r.f0.s.b
    public void c(boolean z, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            e(z, i2);
        }
    }

    @Override // d.a.r0.r.f0.s.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            this.l.set(0.0f, 0.0f, getWidth(), getHeight());
            this.m.reset();
            this.m.addRoundRect(this.l, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
            canvas.clipPath(this.m);
            super.draw(canvas);
            if (this.r) {
                this.f22010i.setColor(SkinManager.getColor(this.j));
                float right = this.f22006e.getRight();
                canvas.drawLine(right, this.f22009h.getTop(), right, this.f22009h.getBottom(), this.f22010i);
            }
        }
    }

    @Override // d.a.r0.r.f0.s.b
    public void e(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            i(z);
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
            setOrientation(0);
            this.f22006e = (FrameLayout) findViewById(R.id.leftBox);
            this.f22007f = (FrameLayout) findViewById(R.id.rightBox);
            this.f22008g = (TextView) findViewById(R.id.title);
            this.f22009h = (ImageView) findViewById(R.id.arrow);
            Paint paint = new Paint(1);
            this.f22010i = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f22010i.setStrokeCap(Paint.Cap.ROUND);
            this.f22010i.setStrokeWidth(l.g(context, R.dimen.tbds3));
            this.l = new RectF();
            this.m = new Path();
            this.j = R.color.CAM_X0105;
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, this.j, null);
            this.o = pureDrawable;
            this.f22009h.setImageDrawable(pureDrawable);
        }
    }

    public ImageView getArrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22009h : (ImageView) invokeV.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            setBackgroundColor(SkinManager.getColor(this.k));
            SkinManager.setViewTextColor(this.f22008g, this.j);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, this.j, null);
            this.o = pureDrawable;
            this.f22009h.setImageDrawable(pureDrawable);
            invalidate();
        }
    }

    public void i(boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.n = getResources().getString(R.string.followed);
                this.j = R.color.CAM_X0101;
                this.k = R.color.CAM_X0904;
            } else {
                this.n = getResources().getString(R.string.attention);
                this.j = R.color.CAM_X0105;
                this.k = R.color.CAM_X0901;
            }
            this.f22008g.setText(this.n);
            requestLayout();
            h(0);
            if (this.r && !this.q && z && !this.p && (bVar = this.s) != null) {
                bVar.a(true, true);
            }
            this.q = false;
        }
    }

    public void setFirstUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.q = z;
        }
    }

    public void setOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.p = z;
        }
    }

    public void setOpenListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.s = bVar;
            this.f22007f.setOnClickListener(new a(this, bVar));
        }
    }

    public void setShowPullBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.r = z;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f22008g.getLayoutParams();
            if (z) {
                this.f22007f.setVisibility(0);
                layoutParams.leftMargin = u;
                layoutParams.rightMargin = v;
                layoutParams.gravity = 16;
                layoutParams.width = -2;
            } else {
                this.f22007f.setVisibility(8);
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.gravity = 17;
                layoutParams.width = t;
            }
            this.f22008g.setLayoutParams(layoutParams);
            requestLayout();
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
    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet, int i2) {
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
        this.q = true;
        g(context);
    }
}
