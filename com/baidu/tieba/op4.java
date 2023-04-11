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
import com.baidu.tieba.mh3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class op4 implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
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

    /* loaded from: classes5.dex */
    public class a implements mh3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ op4 a;

        public a(op4 op4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {op4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = op4Var;
        }

        @Override // com.baidu.tieba.mh3.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.g.setProgress(i);
            }
        }
    }

    public op4(Context context) {
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

    public void k(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048585, this, f) == null) && (this.a instanceof Activity)) {
            sh3.c().e((Activity) this.a, f / 100.0f);
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

    public void l() {
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

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e != null) {
            n();
            this.e.setVisibility(0);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(null);
            mh3.e().i("#com.baidu.swan.videoplayer&MediaSettingViewLayer");
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08a4, (ViewGroup) null);
            this.c = frameLayout;
            frameLayout.setOnTouchListener(this);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0921ae);
            this.d = linearLayout;
            linearLayout.setVisibility(8);
            this.d.findViewById(R.id.obfuscated_res_0x7f0921b6).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f0921b7).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f0921b8).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f0921b9).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f0921ba).setOnClickListener(this);
            this.i = R.id.obfuscated_res_0x7f0921b7;
            j(R.id.obfuscated_res_0x7f0921b7, -13399809);
            h();
            LinearLayout linearLayout2 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0921af);
            this.e = linearLayout2;
            linearLayout2.setVisibility(8);
            this.e.setOnTouchListener(this);
            this.f = (SeekBar) this.e.findViewById(R.id.obfuscated_res_0x7f0921be);
            this.g = (SeekBar) this.e.findViewById(R.id.obfuscated_res_0x7f0921bf);
            this.f.setOnSeekBarChangeListener(this);
            this.g.setOnSeekBarChangeListener(this);
            this.f.setMax(100);
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            this.h = audioManager;
            this.g.setMax(audioManager.getStreamMaxVolume(3));
            n();
            mh3.e().d("#com.baidu.swan.videoplayer&MediaSettingViewLayer", new a(this));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            j(this.i, -1);
            if (TextUtils.equals("0.75", str)) {
                this.i = R.id.obfuscated_res_0x7f0921b6;
            } else if (TextUtils.equals("1.0", str)) {
                this.i = R.id.obfuscated_res_0x7f0921b7;
            } else if (TextUtils.equals("1.25", str)) {
                this.i = R.id.obfuscated_res_0x7f0921b8;
            } else if (TextUtils.equals("1.5", str)) {
                this.i = R.id.obfuscated_res_0x7f0921b9;
            } else if (TextUtils.equals("2.0", str)) {
                this.i = R.id.obfuscated_res_0x7f0921ba;
            } else {
                this.i = 0;
            }
            j(this.i, -13399809);
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
            j(i, -1);
            int id2 = view2.getId();
            this.i = id2;
            j(id2, -13399809);
            int i2 = this.i;
            if (i2 == R.id.obfuscated_res_0x7f0921b6) {
                str = "0.75";
            } else if (i2 == R.id.obfuscated_res_0x7f0921b7) {
                str = "1.0";
            } else if (i2 == R.id.obfuscated_res_0x7f0921b8) {
                str = "1.25";
            } else if (i2 == R.id.obfuscated_res_0x7f0921b9) {
                str = "1.5";
            } else if (i2 == R.id.obfuscated_res_0x7f0921ba) {
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
            dimension = this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070710);
        } else {
            dimension = this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07070f);
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

    public final void j(int i, int i2) {
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
            if (view2.getId() == R.id.obfuscated_res_0x7f0921af) {
                return true;
            }
            e();
            d();
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a instanceof Activity) {
                this.f.setProgress((int) (sh3.c().a((Activity) this.a) * 100.0f));
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
        if (seekBar.getId() == R.id.obfuscated_res_0x7f0921bf) {
            i(i);
        } else if (seekBar.getId() == R.id.obfuscated_res_0x7f0921be) {
            k(i);
        }
    }
}
