package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer a;
    public v32 b;

    /* loaded from: classes7.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v32 a;
        public final /* synthetic */ m32 b;

        public a(m32 m32Var, v32 v32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m32Var, v32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m32Var;
            this.a = v32Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v32 v32Var = this.a;
                if (v32Var != null) {
                    v32Var.a();
                }
                this.b.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final m32 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-653043841, "Lcom/baidu/tieba/m32$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-653043841, "Lcom/baidu/tieba/m32$b;");
                    return;
                }
            }
            a = new m32(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947921661, "Lcom/baidu/tieba/m32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947921661, "Lcom/baidu/tieba/m32;");
                return;
            }
        }
        c = nr1.a;
    }

    public m32() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static m32 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (m32) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            v32 v32Var = this.b;
            if (v32Var != null) {
                v32Var.cancel();
            }
            j();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                CameraPreview.r();
            } catch (Exception e) {
                if (c) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b = null;
            Timer timer = this.a;
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    public /* synthetic */ m32(a aVar) {
        this();
    }

    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            a();
        }
    }

    public void e(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            String str3 = "error";
            if (so3.f("1.13.0")) {
                HashMap hashMap = new HashMap();
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                hashMap.put("cameraId", str2);
                if (!z) {
                    str3 = "stop";
                }
                hashMap.put("eType", str3);
                qw2.T().u(new el2("camera", hashMap));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                jSONObject.put("cameraId", str2);
                if (!z) {
                    str3 = "stop";
                }
                jSONObject.put("eType", str3);
            } catch (JSONException e) {
                if (c) {
                    e.printStackTrace();
                }
            }
            kq3.d(str, str2, "camera", jSONObject.optString("eType"), jSONObject);
        }
    }

    public boolean h(byte[] bArr, String str, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bArr, str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                File file = new File(str);
                if (file.exists()) {
                    boolean delete = file.delete();
                    if (c) {
                        Log.d("SwanAppCameraManager", "delete = " + delete);
                    }
                }
                if (file.getParentFile() != null) {
                    boolean mkdirs = file.getParentFile().mkdirs();
                    if (c) {
                        Log.d("SwanAppCameraManager", "mkdirs = " + mkdirs);
                    }
                }
                boolean createNewFile = file.createNewFile();
                if (c) {
                    Log.d("SwanAppCameraManager", "createNewFile = " + createNewFile);
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (i2 != 0 || z) {
                    Matrix matrix = new Matrix();
                    matrix.reset();
                    if (i2 != 0) {
                        matrix.postRotate(i2);
                    }
                    if (z) {
                        matrix.postScale(-1.0f, 1.0f);
                    }
                    decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i, bufferedOutputStream);
                bufferedOutputStream.flush();
                hr4.d(bufferedOutputStream);
                return true;
            } catch (Exception e) {
                if (!c) {
                    return false;
                }
                e.printStackTrace();
                return false;
            } catch (OutOfMemoryError e2) {
                if (!c) {
                    return false;
                }
                e2.printStackTrace();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void i(int i, v32 v32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, v32Var) == null) {
            this.b = v32Var;
            Timer timer = new Timer();
            this.a = timer;
            timer.schedule(new a(this, v32Var), i);
        }
    }
}
