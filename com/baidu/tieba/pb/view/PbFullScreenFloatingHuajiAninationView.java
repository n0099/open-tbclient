package com.baidu.tieba.pb.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.m.e;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_DURATION = 2000;
    public static final int w;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f55805e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55806f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55807g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55808h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f55809i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f55810j;
    public TextView k;
    public AnimatorSet l;
    public AnimatorSet m;
    public AnimatorSet n;
    public AnimatorSet o;
    public AnimatorSet p;
    public AnimatorSet q;
    public AnimatorSet r;
    public c s;
    public boolean t;
    public Runnable u;
    public Runnable v;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenFloatingHuajiAninationView f55811e;

        public a(PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenFloatingHuajiAninationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55811e = pbFullScreenFloatingHuajiAninationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55811e.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenFloatingHuajiAninationView f55812e;

        public b(PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenFloatingHuajiAninationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55812e = pbFullScreenFloatingHuajiAninationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewGroup viewGroup = (ViewGroup) ((Activity) this.f55812e.getContext()).getWindow().getDecorView();
                if (this.f55812e.getParent() == null || this.f55812e.getParent() != viewGroup) {
                    return;
                }
                viewGroup.removeView(this.f55812e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-357334472, "Lcom/baidu/tieba/pb/view/PbFullScreenFloatingHuajiAninationView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-357334472, "Lcom/baidu/tieba/pb/view/PbFullScreenFloatingHuajiAninationView;");
                return;
            }
        }
        w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
        x = l.k(TbadkCoreApplication.getInst());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFullScreenFloatingHuajiAninationView(Context context) {
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
        this.t = false;
        this.u = new a(this);
        this.v = new b(this);
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t = false;
            e.a().post(this.v);
            c cVar = this.s;
            if (cVar != null) {
                cVar.onAnimationEnd();
            }
            removeCallbacks(this.u);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.pb_full_screen_floating_huaji_view, this);
            this.f55805e = (ImageView) findViewById(R.id.pb_video_floating_big_huaji);
            this.f55806f = (ImageView) findViewById(R.id.pb_video_floating_small_huaji1);
            this.f55807g = (ImageView) findViewById(R.id.pb_video_floating_small_huaji2);
            this.f55808h = (ImageView) findViewById(R.id.pb_video_floating_small_huaji3);
            this.f55809i = (ImageView) findViewById(R.id.pb_video_floating_small_huaji4);
            this.f55810j = (ImageView) findViewById(R.id.pb_video_floating_small_huaji5);
            TextView textView = (TextView) findViewById(R.id.pb_video_floating_huaji_tip);
            this.k = textView;
            textView.setX((x - w) / 2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l = new AnimatorSet();
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_floor_bigpraised_floating);
            ImageView imageView = this.f55805e;
            float intrinsicWidth = (x - drawable.getIntrinsicWidth()) / 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "X", x, intrinsicWidth);
            ofFloat.setDuration(400L);
            ImageView imageView2 = this.f55805e;
            float intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "X", intrinsicWidth, intrinsicWidth2);
            ofFloat2.setDuration(500L);
            ofFloat2.setStartDelay(1000L);
            this.l.playTogether(ofFloat, ofFloat2);
            this.m = new AnimatorSet();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f55806f, "X", x, intrinsicWidth2);
            ofFloat3.setDuration(600L);
            ofFloat3.setStartDelay(800L);
            this.m.play(ofFloat3);
            this.n = new AnimatorSet();
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f55807g, "X", x, intrinsicWidth2);
            ofFloat4.setDuration(600L);
            ofFloat4.setStartDelay(800L);
            this.n.play(ofFloat4);
            this.o = new AnimatorSet();
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f55808h, "X", x, intrinsicWidth2);
            ofFloat5.setDuration(300L);
            ofFloat5.setStartDelay(1100L);
            this.o.play(ofFloat5);
            this.p = new AnimatorSet();
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f55809i, "X", x, intrinsicWidth2);
            ofFloat6.setDuration(200L);
            ofFloat6.setStartDelay(IMLikeRequest.TIME_INTERVAL);
            this.p.play(ofFloat6);
            this.q = new AnimatorSet();
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f55810j, "X", x, intrinsicWidth2);
            ofFloat7.setDuration(150L);
            ofFloat7.setStartDelay(1400L);
            this.q.play(ofFloat7);
            this.r = new AnimatorSet();
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.k, "scaleX", 0.0f, 2.0f, 1.0f);
            ofFloat8.setDuration(500L);
            ofFloat8.setStartDelay(400L);
            ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.k, "scaleY", 0.0f, 2.0f, 1.0f);
            ofFloat9.setDuration(500L);
            ofFloat8.setStartDelay(400L);
            ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.k, "X", x / 2, intrinsicWidth2);
            ofFloat10.setDuration(300L);
            ofFloat10.setStartDelay(700L);
            this.r.playTogether(ofFloat8, ofFloat9, ofFloat10);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.black_alpha60);
            int i3 = R.drawable.icon_floor_praised_floating;
            int i4 = R.drawable.icon_floor_bigpraised_floating;
            c.a.q0.t.c.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
            if (activitySwitch != null && activitySwitch.a()) {
                i3 = R.drawable.icon_floor_praised_floating_xmas;
                i4 = R.drawable.icon_floor_bigpraised_floating_xmas;
            }
            SkinManager.setImageResource(this.f55805e, i4);
            SkinManager.setImageResource(this.f55806f, i3);
            SkinManager.setImageResource(this.f55807g, i3);
            SkinManager.setImageResource(this.f55808h, i3);
            SkinManager.setImageResource(this.f55809i, i3);
            SkinManager.setImageResource(this.f55810j, i3);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                stopAnimation();
            }
        }
    }

    public void setFloatingHuajiAninationListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void startAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || UtilHelper.getRealScreenOrientation(getContext()) == 2 || this.t) {
            return;
        }
        this.t = true;
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
        postDelayed(this.u, 2000L);
        this.l.start();
        this.m.start();
        this.n.start();
        this.o.start();
        this.p.start();
        this.q.start();
    }

    public void stopAnimation() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.t) {
            b();
            this.l.cancel();
            this.m.cancel();
            this.n.cancel();
            this.o.cancel();
            this.p.cancel();
            this.q.cancel();
            this.r.cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet) {
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
        this.t = false;
        this.u = new a(this);
        this.v = new b(this);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet, int i2) {
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
        this.t = false;
        this.u = new a(this);
        this.v = new b(this);
        c();
    }
}
