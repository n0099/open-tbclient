package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.AVStream;
import com.yy.transvod.player.common.AVframe;
import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.AudioSendStamp;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.NetRequestStatusInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import com.yy.transvod.player.common.effectmp4.EffectFrame;
import com.yy.transvod.player.common.effectmp4.EffectInfo;
import com.yy.transvod.player.common.effectmp4.EffectObject;
import com.yy.transvod.player.common.effectmp4.EffectSource;
import com.yy.transvod.player.core.TransVodProxy;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.NativeFfmpeg;
import com.yy.transvod.player.mediacodec.NativeIttiam;
import java.util.UUID;
/* loaded from: classes6.dex */
public class iwb {
    public static /* synthetic */ Interceptable $ic;
    public static String d;
    public transient /* synthetic */ FieldHolder $fh;
    public TransVodProxy a;
    public fwb b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947869333, "Lcom/baidu/tieba/iwb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947869333, "Lcom/baidu/tieba/iwb;");
                return;
            }
        }
        jub.b();
        d = null;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return jub.a();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.l();
                    this.a = null;
                }
            }
            fwb fwbVar = this.b;
            if (fwbVar != null) {
                fwbVar.f();
                this.b = null;
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.v(true);
                }
            }
        }
    }

    public iwb(Context context, kvb kvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kvbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        jub.c(context);
        c();
        this.c = context;
        String a = a(context);
        TLog.h("TransVodManager", "generated uid " + a);
    }

    public static synchronized String a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (iwb.class) {
                if (d == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("transvod-uid-pref", 0);
                    String string = sharedPreferences.getString("transvod-uid-pref", null);
                    d = string;
                    if (string == null) {
                        d = UUID.randomUUID().toString();
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("transvod-uid-pref", d);
                        edit.commit();
                    }
                }
                str = d;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!jub.a()) {
                TLog.h("TransVodManager", "init failed, library not load success");
                return;
            }
            Log.i("TransVodManager", "TLog.setLevel()");
            TLog.i(4);
            TransVodProxy.nativeClassInit();
            AVframe.nativeClassInit();
            AVStream.nativeClassInit();
            NativeFfmpeg.nativeClassInit();
            NativeIttiam.nativeClassInit();
            VideoExtraInfo.nativeClassInit();
            AlphaChannelData.nativeClassInit();
            MixVideoExtraInfo.nativeClassInit();
            MixAudioExtraInfo.nativeClassInit();
            NetRequestStatusInfo.nativeClassInit();
            AudioSendStamp.nativeClassInit();
            EffectInfo.nativeClassInit();
            EffectSource.nativeClassInit();
            EffectObject.nativeClassInit();
            EffectFrame.nativeClassInit();
        }
    }

    public TransVodProxy d(int i, kvb kvbVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, kvbVar)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new TransVodProxy(null, i, kvbVar);
                }
            }
            if (this.b == null) {
                fwb fwbVar = new fwb(this.c, this);
                this.b = fwbVar;
                fwbVar.i();
            }
            return this.a;
        }
        return (TransVodProxy) invokeIL.objValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.f(i);
                }
            }
        }
    }
}
