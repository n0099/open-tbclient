package com.baidu.tieba;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vq4 implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public b b;
    public SensorManager c;
    public Sensor d;
    public Vibrator e;
    public SoundPool f;
    public int g;
    public int h;
    public long i;
    public boolean j;
    public MediaPlayer k;
    public double l;
    public double m;

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, sensor, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq4 a;

        public a(vq4 vq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq4Var;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.k.start();
            }
        }
    }

    public vq4(@NonNull Context context, @Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 2.5d;
        this.m = 4.2d;
        if (context == null) {
            return;
        }
        this.a = context;
        this.b = bVar;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.c = sensorManager;
        if (sensorManager != null) {
            this.d = TbadkCoreApplication.getInst().getDefaultSensor(1);
        }
        this.e = (Vibrator) context.getSystemService("vibrator");
        SoundPool soundPool = new SoundPool(1, 3, 0);
        this.f = soundPool;
        if (soundPool != null) {
            try {
                this.g = soundPool.load(context, R.raw.shake_tone, 1);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void j(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)}) == null) {
            this.m = d;
        }
    }

    public void k(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d)}) == null) {
            this.l = d;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && (bVar = this.b) != null) {
            bVar.a();
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.i > 2000) {
                this.i = currentTimeMillis;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (sensorManager = this.c) != null) {
            sensorManager.unregisterListener(this);
            this.j = false;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (sensor = this.d) != null) {
            this.c.registerListener(this, sensor, 2);
            this.j = true;
        }
    }

    public final boolean e(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fArr)) == null) {
            double sqrt = Math.sqrt(Math.pow(Math.abs(fArr[0]) / 9.8d, 2.0d) + Math.pow(Math.abs(fArr[1]) / 9.8d, 2.0d) + Math.pow(Math.abs(fArr[2]) / 9.8d, 2.0d));
            if (Build.VERSION.SDK_INT <= 23) {
                if (sqrt >= this.l && b()) {
                    return true;
                }
            } else if (sqrt >= this.m && b()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return false;
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i = -1;
            if (audioManager != null) {
                i = audioManager.getRingerMode();
            }
            Vibrator vibrator = this.e;
            if (vibrator == null || !vibrator.hasVibrator() || i <= 0) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.e.vibrate(VibrationEffect.createOneShot(400L, 255));
                return true;
            }
            this.e.vibrate(400L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z && (i = this.h) != 0) {
                SoundPool soundPool = this.f;
                if (soundPool != null) {
                    soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                    return;
                }
                return;
            }
            SoundPool soundPool2 = this.f;
            if (soundPool2 != null) {
                soundPool2.play(this.g, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (this.k == null) {
                this.k = new MediaPlayer();
            }
            try {
                this.k.reset();
                this.k.setLooping(false);
                this.k.setDataSource(str);
                this.k.prepareAsync();
                this.k.setOnPreparedListener(new a(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
