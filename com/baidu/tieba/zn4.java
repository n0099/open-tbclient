package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.yf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zn4 implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public SwanVideoView b;
    public FrameLayout c;
    public LinearLayout d;
    public LinearLayout e;
    public SeekBar f;
    public SeekBar g;
    public AudioManager h;
    public int i;
    public boolean j;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, seekBar) == null) {
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, seekBar) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements yf3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn4 a;

        public a(zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn4Var;
        }

        @Override // com.baidu.tieba.yf3.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.g.setProgress(i);
            }
        }
    }

    public zn4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        f();
    }

    public void b(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.b = swanVideoView;
        }
    }

    public void l(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048585, this, f) == null) && (this.a instanceof Activity)) {
            eg3.c().e((Activity) this.a, f / 100.0f);
        }
    }

    public FrameLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void d() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (linearLayout = this.d) != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void e() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (linearLayout = this.e) != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void m() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SwanVideoView swanVideoView = this.b;
            if (swanVideoView != null) {
                z = swanVideoView.x();
            } else {
                z = false;
            }
            if (this.d != null) {
                if (z != this.j) {
                    this.j = z;
                    h();
                }
                this.d.setVisibility(0);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e != null) {
            o();
            this.e.setVisibility(0);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(null);
            yf3.e().j("#com.baidu.swan.videoplayer&MediaSettingViewLayer");
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0958, (ViewGroup) null);
            this.c = frameLayout;
            frameLayout.setOnTouchListener(this);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0923af);
            this.d = linearLayout;
            linearLayout.setVisibility(8);
            this.d.findViewById(R.id.obfuscated_res_0x7f0923b7).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f0923b8).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f0923b9).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f0923ba).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f0923bb).setOnClickListener(this);
            this.i = R.id.obfuscated_res_0x7f0923b8;
            k(R.id.obfuscated_res_0x7f0923b8, -13399809);
            h();
            LinearLayout linearLayout2 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0923b0);
            this.e = linearLayout2;
            linearLayout2.setVisibility(8);
            this.e.setOnTouchListener(this);
            this.f = (SeekBar) this.e.findViewById(R.id.obfuscated_res_0x7f0923bf);
            this.g = (SeekBar) this.e.findViewById(R.id.obfuscated_res_0x7f0923c0);
            this.f.setOnSeekBarChangeListener(this);
            this.g.setOnSeekBarChangeListener(this);
            this.f.setMax(100);
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            this.h = audioManager;
            this.g.setMax(audioManager.getStreamMaxVolume(3));
            o();
            yf3.e().d("#com.baidu.swan.videoplayer&MediaSettingViewLayer", new a(this));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            k(this.i, -1);
            if (TextUtils.equals("0.75", str)) {
                this.i = R.id.obfuscated_res_0x7f0923b7;
            } else if (TextUtils.equals("1.0", str)) {
                this.i = R.id.obfuscated_res_0x7f0923b8;
            } else if (TextUtils.equals("1.25", str)) {
                this.i = R.id.obfuscated_res_0x7f0923b9;
            } else if (TextUtils.equals("1.5", str)) {
                this.i = R.id.obfuscated_res_0x7f0923ba;
            } else if (TextUtils.equals("2.0", str)) {
                this.i = R.id.obfuscated_res_0x7f0923bb;
            } else {
                this.i = 0;
            }
            k(this.i, -13399809);
            SwanVideoView swanVideoView = this.b;
            if (swanVideoView != null) {
                swanVideoView.Q(str);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            d();
            if (this.b == null) {
                return;
            }
            int id = view2.getId();
            int i = this.i;
            if (id == i) {
                return;
            }
            k(i, -1);
            int id2 = view2.getId();
            this.i = id2;
            k(id2, -13399809);
            int i2 = this.i;
            if (i2 == R.id.obfuscated_res_0x7f0923b7) {
                str = "0.75";
            } else if (i2 == R.id.obfuscated_res_0x7f0923b8) {
                str = "1.0";
            } else if (i2 == R.id.obfuscated_res_0x7f0923b9) {
                str = "1.25";
            } else if (i2 == R.id.obfuscated_res_0x7f0923ba) {
                str = "1.5";
            } else if (i2 == R.id.obfuscated_res_0x7f0923bb) {
                str = "2.0";
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.b.J(Float.parseFloat(str));
                    this.b.Q(str);
                } catch (NumberFormatException unused) {
                }
            }
        }
    }

    public void h() {
        float dimension;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.d == null) {
            return;
        }
        if (this.j) {
            dimension = this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07088c);
        } else {
            dimension = this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07088b);
        }
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.width = (int) dimension;
        this.d.setLayoutParams(layoutParams);
    }

    public void i(int i) {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (swanVideoView = this.b) != null && !swanVideoView.A()) {
            AudioManager audioManager = this.h;
            if (audioManager != null) {
                audioManager.setStreamVolume(3, i, 0);
            }
            if (i == 0) {
                this.b.setMuted(true);
            } else if (this.b.y()) {
                this.b.setMuted(false);
            }
        }
    }

    public final void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) != null) || i == 0) {
            return;
        }
        ((TextView) this.c.findViewById(i)).setTextColor(i2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, view2, motionEvent)) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0923b0) {
                return true;
            }
            e();
            d();
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a instanceof Activity) {
                this.f.setProgress((int) (eg3.c().a((Activity) this.a) * 100.0f));
            }
            SwanVideoView swanVideoView = this.b;
            if (swanVideoView != null && swanVideoView.y()) {
                this.g.setProgress(0);
            } else {
                this.g.setProgress(this.h.getStreamVolume(3));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || !z) {
            return;
        }
        if (seekBar.getId() == R.id.obfuscated_res_0x7f0923c0) {
            i(i);
        } else if (seekBar.getId() == R.id.obfuscated_res_0x7f0923bf) {
            l(i);
        }
    }
}
