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
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.tieba.v75;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public AnimatorSet h;
    public AnimatorSet i;
    public AnimatorSet j;
    public AnimatorSet k;
    public AnimatorSet l;
    public AnimatorSet m;
    public AnimatorSet n;
    public c o;
    public boolean p;
    public Runnable q;
    public Runnable r;

    /* loaded from: classes5.dex */
    public interface c {
        void onAnimationEnd();
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenFloatingHuajiAninationView a;

        public a(PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenFloatingHuajiAninationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenFloatingHuajiAninationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.b();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenFloatingHuajiAninationView a;

        public b(PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenFloatingHuajiAninationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenFloatingHuajiAninationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewGroup viewGroup = (ViewGroup) ((Activity) this.a.getContext()).getWindow().getDecorView();
                if (this.a.getParent() != null && this.a.getParent() == viewGroup) {
                    viewGroup.removeView(this.a);
                }
            }
        }
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
        s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cc);
        t = ej.l(TbadkCoreApplication.getInst());
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.p) {
            return;
        }
        b();
        this.h.cancel();
        this.i.cancel();
        this.j.cancel();
        this.k.cancel();
        this.l.cancel();
        this.m.cancel();
        this.n.cancel();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = new a(this);
        this.r = new b(this);
        c();
    }

    public void e(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setBackgroundColor(this, R.color.black_alpha60);
            v75 activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
            if (activitySwitch != null && activitySwitch.a()) {
                i2 = R.drawable.icon_floor_praised_floating_xmas;
                i3 = R.drawable.icon_floor_bigpraised_floating_xmas;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f08074f;
                i3 = R.drawable.obfuscated_res_0x7f08074d;
            }
            SkinManager.setImageResource(this.a, i3);
            SkinManager.setImageResource(this.b, i2);
            SkinManager.setImageResource(this.c, i2);
            SkinManager.setImageResource(this.d, i2);
            SkinManager.setImageResource(this.e, i2);
            SkinManager.setImageResource(this.f, i2);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.p) {
            this.p = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.q, 2000L);
            this.h.start();
            this.i.start();
            this.j.start();
            this.k.start();
            this.l.start();
            this.m.start();
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
        this.p = false;
        this.q = new a(this);
        this.r = new b(this);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet, int i) {
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
        this.p = false;
        this.q = new a(this);
        this.r = new b(this);
        c();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                g();
            }
        }
    }

    public void setFloatingHuajiAninationListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.p = false;
            gh.a().post(this.r);
            c cVar = this.o;
            if (cVar != null) {
                cVar.onAnimationEnd();
            }
            removeCallbacks(this.q);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0709, this);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919e1);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919e3);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919e4);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919e5);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919e6);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919e7);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0919e2);
            this.g = textView;
            textView.setX((t - s) / 2);
            e(TbadkCoreApplication.getInst().getSkinType());
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h = new AnimatorSet();
            Drawable drawable = SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08074d);
            ImageView imageView = this.a;
            float intrinsicWidth = (t - drawable.getIntrinsicWidth()) / 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "X", t, intrinsicWidth);
            ofFloat.setDuration(400L);
            ImageView imageView2 = this.a;
            float intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "X", intrinsicWidth, intrinsicWidth2);
            ofFloat2.setDuration(500L);
            ofFloat2.setStartDelay(1000L);
            this.h.playTogether(ofFloat, ofFloat2);
            this.i = new AnimatorSet();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.b, "X", t, intrinsicWidth2);
            ofFloat3.setDuration(600L);
            ofFloat3.setStartDelay(800L);
            this.i.play(ofFloat3);
            this.j = new AnimatorSet();
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.c, "X", t, intrinsicWidth2);
            ofFloat4.setDuration(600L);
            ofFloat4.setStartDelay(800L);
            this.j.play(ofFloat4);
            this.k = new AnimatorSet();
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.d, "X", t, intrinsicWidth2);
            ofFloat5.setDuration(300L);
            ofFloat5.setStartDelay(1100L);
            this.k.play(ofFloat5);
            this.l = new AnimatorSet();
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.e, "X", t, intrinsicWidth2);
            ofFloat6.setDuration(200L);
            ofFloat6.setStartDelay(IMLikeRequest.TIME_INTERVAL);
            this.l.play(ofFloat6);
            this.m = new AnimatorSet();
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f, "X", t, intrinsicWidth2);
            ofFloat7.setDuration(150L);
            ofFloat7.setStartDelay(1400L);
            this.m.play(ofFloat7);
            this.n = new AnimatorSet();
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.g, Key.SCALE_X, 0.0f, 2.0f, 1.0f);
            ofFloat8.setDuration(500L);
            ofFloat8.setStartDelay(400L);
            ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.g, Key.SCALE_Y, 0.0f, 2.0f, 1.0f);
            ofFloat9.setDuration(500L);
            ofFloat8.setStartDelay(400L);
            ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.g, "X", t / 2, intrinsicWidth2);
            ofFloat10.setDuration(300L);
            ofFloat10.setStartDelay(700L);
            this.n.playTogether(ofFloat8, ofFloat9, ofFloat10);
        }
    }
}
