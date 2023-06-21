package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class rl3 {
    public static /* synthetic */ Interceptable $ic;
    public static rl3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, b> a;
    public AudioManager b;
    public boolean c;
    public BroadcastReceiver d;

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl3 this$0;

        public a(rl3 rl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = rl3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (this.this$0.b == null) {
                    this.this$0.b = (AudioManager) gv2.c().getSystemService("audio");
                }
                for (Map.Entry entry : this.this$0.a.entrySet()) {
                    if (this.this$0.b != null) {
                        i = this.this$0.b.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((b) entry.getValue()).a(i);
                }
            }
        }
    }

    public rl3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
        this.d = new a(this);
    }

    public static rl3 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (rl3.class) {
                    if (e == null) {
                        e = new rl3();
                    }
                }
            }
            return e;
        }
        return (rl3) invokeV.objValue;
    }

    public static void h() {
        rl3 rl3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && (rl3Var = e) != null) {
            rl3Var.g();
        }
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            gv2.c().registerReceiver(this.d, intentFilter);
            this.c = true;
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                gv2.c().unregisterReceiver(this.d);
                this.c = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == null) {
                this.b = (AudioManager) gv2.c().getSystemService("audio");
            }
            AudioManager audioManager = this.b;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return 100;
        }
        return invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
                this.b = null;
                this.c = false;
            }
            e = null;
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, bVar) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.a.put(str, bVar);
            if (!this.c) {
                registerReceiver();
            }
            if (js1.a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.a.size());
            }
        }
    }

    public boolean i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            synchronized (this) {
                b remove = this.a.remove(str);
                if (this.a.size() == 0 && this.c) {
                    unregisterReceiver();
                }
                if (js1.a && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.a.size());
                }
                if (remove != null) {
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
