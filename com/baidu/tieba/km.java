package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.stats.AppBeforeCreateSpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Scopes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class km {
    public static /* synthetic */ Interceptable $ic;
    public static volatile km d;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public int c;

    public km() {
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
        this.a = -1L;
        this.b = 0L;
        this.c = 0;
    }

    public static synchronized km d() {
        InterceptResult invokeV;
        km kmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (km.class) {
                if (d == null) {
                    d = new km();
                }
                kmVar = d;
            }
            return kmVar;
        }
        return (km) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (a() > c()) {
                return -1L;
            }
            return this.a;
        }
        return invokeV.longValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File file = new File(AppRuntime.getAppContext().getCacheDir(), "titan_sandbox_cache");
            file.mkdirs();
            return new File(file, "update_v3.profile");
        }
        return (File) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                Context appContext = AppRuntime.getAppContext();
                PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                if (packageInfo != null) {
                    ng8 defaultLog = DefaultLog.getInstance();
                    defaultLog.a(TitanDownloadService.TAG, "cur host version code = " + packageInfo.versionCode);
                    return packageInfo.versionCode;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void g() {
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            File f = f();
            if (!f.exists()) {
                return;
            }
            DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(f));
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.a = dataInputStream.readLong();
                this.b = dataInputStream.readLong();
                this.c = dataInputStream.readInt();
                Closeables.closeSafely(dataInputStream);
            } catch (IOException e2) {
                e = e2;
                dataInputStream2 = dataInputStream;
                e.printStackTrace();
                Closeables.closeSafely(dataInputStream2);
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                Closeables.closeSafely(dataInputStream2);
                throw th;
            }
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.c = i;
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.b = j;
        }
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.a = j;
        }
    }

    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("updateVersion", this.a);
                jSONObject.put("lastUpdateTime", this.b);
                jSONObject.put("hostVersionCode", this.c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "[updateVersion = " + this.a + ", lastUpdateTime = " + this.b + ", hostVersionCode = " + this.c + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0080 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.File] */
    public void l() {
        File file;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            File file2 = TitanDownloadService.TAG;
            DefaultLog.getInstance().a(TitanDownloadService.TAG, "updateToFile value = " + toString());
            File f = f();
            DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    file2 = File.createTempFile(AppBeforeCreateSpeedStats.TITAN_DETAILS, Scopes.PROFILE, f.getParentFile());
                    try {
                        dataOutputStream = new DataOutputStream(new FileOutputStream((File) file2));
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    dataOutputStream.writeLong(this.a);
                    dataOutputStream.writeLong(this.b);
                    dataOutputStream.writeInt(this.c);
                    dataOutputStream.close();
                    f.delete();
                    file2.renameTo(f);
                    Closeables.closeSafely(dataOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    dataOutputStream2 = dataOutputStream;
                    e.printStackTrace();
                    Closeables.closeSafely(dataOutputStream2);
                    if (file2 != null) {
                        boolean exists = file2.exists();
                        file = file2;
                        if (!exists) {
                            return;
                        }
                        file.delete();
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream2 = dataOutputStream;
                    Closeables.closeSafely(dataOutputStream2);
                    if (file2 != 0 && file2.exists()) {
                        file2.delete();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                file2 = null;
            } catch (Throwable th3) {
                th = th3;
                file2 = 0;
            }
            if (file2 != 0) {
                boolean exists2 = file2.exists();
                file = file2;
                if (!exists2) {
                    return;
                }
                file.delete();
            }
        }
    }
}
