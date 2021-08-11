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
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements c.a.o0.s.f0.t.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f57815e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f57816f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57817g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f57818h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f57819i;

    /* renamed from: j  reason: collision with root package name */
    public int f57820j;
    public int k;
    public RectF l;
    public Path m;
    public String n;
    public Drawable o;
    public boolean p;
    public boolean q;
    public boolean r;
    public b s;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57821e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FollowUserSpinnerBtn f57822f;

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
            this.f57822f = followUserSpinnerBtn;
            this.f57821e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = this.f57821e) == null) {
                return;
            }
            bVar.a(!this.f57822f.p, false);
        }
    }

    /* loaded from: classes7.dex */
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

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
            setOrientation(0);
            this.f57815e = (FrameLayout) findViewById(R.id.leftBox);
            this.f57816f = (FrameLayout) findViewById(R.id.rightBox);
            this.f57817g = (TextView) findViewById(R.id.title);
            this.f57818h = (ImageView) findViewById(R.id.arrow);
            Paint paint = new Paint(1);
            this.f57819i = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f57819i.setStrokeCap(Paint.Cap.ROUND);
            this.f57819i.setStrokeWidth(l.g(context, R.dimen.tbds3));
            this.l = new RectF();
            this.m = new Path();
            this.f57820j = R.color.CAM_X0105;
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, this.f57820j, null);
            this.o = pureDrawable;
            this.f57818h.setImageDrawable(pureDrawable);
        }
    }

    @Override // c.a.o0.s.f0.t.b
    public void bindOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.l.set(0.0f, 0.0f, getWidth(), getHeight());
            this.m.reset();
            this.m.addRoundRect(this.l, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
            canvas.clipPath(this.m);
            super.draw(canvas);
            if (this.r) {
                this.f57819i.setColor(SkinManager.getColor(this.f57820j));
                float right = this.f57815e.getRight();
                canvas.drawLine(right, this.f57818h.getTop(), right, this.f57818h.getBottom(), this.f57819i);
            }
        }
    }

    public ImageView getArrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57818h : (ImageView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            setBackgroundColor(SkinManager.getColor(this.k));
            SkinManager.setViewTextColor(this.f57817g, this.f57820j);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, this.f57820j, null);
            this.o = pureDrawable;
            this.f57818h.setImageDrawable(pureDrawable);
            invalidate();
        }
    }

    @Override // c.a.o0.s.f0.t.b
    public void onClickEvent(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
        }
    }

    public void setFirstUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.q = z;
        }
    }

    public void setOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.p = z;
        }
    }

    public void setOpenListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.s = bVar;
            this.f57816f.setOnClickListener(new a(this, bVar));
        }
    }

    public void setShowPullBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.r = z;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f57817g.getLayoutParams();
            if (z) {
                this.f57816f.setVisibility(0);
                layoutParams.leftMargin = u;
                layoutParams.rightMargin = v;
                layoutParams.gravity = 16;
                layoutParams.width = -2;
            } else {
                this.f57816f.setVisibility(8);
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.gravity = 17;
                layoutParams.width = t;
            }
            this.f57817g.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    @Override // c.a.o0.s.f0.t.b
    public void updateFansNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    public void updateLikeStatus(boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.n = getResources().getString(R.string.followed);
                this.f57820j = R.color.CAM_X0101;
                this.k = R.color.CAM_X0904;
            } else {
                this.n = getResources().getString(R.string.attention);
                this.f57820j = R.color.CAM_X0105;
                this.k = R.color.CAM_X0901;
            }
            this.f57817g.setText(this.n);
            requestLayout();
            onChangeSkinType(0);
            if (this.r && !this.q && z && !this.p && (bVar = this.s) != null) {
                bVar.a(true, true);
            }
            this.q = false;
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
        b(context);
    }

    @Override // c.a.o0.s.f0.t.b
    public void updateLikeStatus(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            updateLikeStatus(z);
        }
    }

    @Override // c.a.o0.s.f0.t.b
    public void updateLikeStatus(boolean z, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            updateLikeStatus(z, i2);
        }
    }
}
