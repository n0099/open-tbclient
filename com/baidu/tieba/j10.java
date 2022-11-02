package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
public class j10 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean d;
    public static j10 e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public SharedPreferences c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947830304, "Lcom/baidu/tieba/j10;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947830304, "Lcom/baidu/tieba/j10;");
                return;
            }
        }
        d = AppConfig.isDebug();
    }

    public j10() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    public static j10 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (j10.class) {
                    if (e == null) {
                        e = new j10();
                    }
                }
            }
            return e;
        }
        return (j10) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = AppRuntime.getAppContext().getSharedPreferences(ChannelManager.PREFS_NAME, 0);
            f();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String g = g();
            this.b = g;
            if (TextUtils.isEmpty(g) && !TextUtils.isEmpty(this.a)) {
                this.b = this.a;
                j();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String i = i();
            this.a = i;
            if (TextUtils.isEmpty(i)) {
                this.a = h();
            }
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c.getString("channel", null);
        }
        return (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.edit().putString("channel", this.b).apply();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (com.baidu.tieba.j10.d == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        android.util.Log.e(com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager.TAG, "readLastChannelFromAssets", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0070, code lost:
        if (com.baidu.tieba.j10.d == false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = null;
            try {
                inputStream = AppRuntime.getAppContext().getAssets().open("channel");
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
                inputStream = null;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    try {
                        str = bufferedReader.readLine();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e3) {
                                if (d) {
                                    Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e3);
                                }
                            }
                        }
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        if (d) {
                            Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e);
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e6) {
                                if (d) {
                                    Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e6);
                                }
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e7) {
                                e = e7;
                            }
                        }
                        return str;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e8) {
                            if (d) {
                                Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e8);
                            }
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e9) {
                            if (d) {
                                Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e9);
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                bufferedReader = null;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (com.baidu.tieba.j10.d == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
        android.util.Log.e(com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager.TAG, "readLastChannelFromRaw", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (com.baidu.tieba.j10.d == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = null;
            try {
                InputStream openRawResource = AppRuntime.getAppContext().getResources().openRawResource(R.raw.obfuscated_res_0x7f110074);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
                try {
                    str = bufferedReader.readLine();
                    try {
                        openRawResource.close();
                        bufferedReader.close();
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    if (d) {
                        Log.e(ChannelManager.TAG, "readLastChannelFromRaw", e3);
                    }
                    try {
                        openRawResource.close();
                        bufferedReader.close();
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
            } catch (Exception e5) {
                if (d) {
                    Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e5);
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
