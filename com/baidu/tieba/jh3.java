package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* loaded from: classes6.dex */
    public class a implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jh3 jh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                long lastModified = file.lastModified();
                long lastModified2 = file2.lastModified();
                if (lastModified == lastModified2) {
                    return 0;
                }
                if (lastModified - lastModified2 > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947883252, "Lcom/baidu/tieba/jh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947883252, "Lcom/baidu/tieba/jh3;");
                return;
            }
        }
        b = rr1.a;
    }

    public jh3() {
        String str;
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
        try {
            str = AppRuntime.getAppContext().getFilesDir().getPath();
        } catch (Exception e) {
            if (!b) {
                str = "";
            } else {
                throw e;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.a = str + File.separator + "aiapps_folder/stability";
            return;
        }
        this.a = "";
    }

    public final void a(int i) {
        File[] c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (c = c()) != null && c.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(c, new a(this));
            ArrayList<File> arrayList = new ArrayList(c.length);
            int i2 = 0;
            for (File file : c) {
                if (i2 < i) {
                    if (file.lastModified() - currentTimeMillis > 172800000) {
                        arrayList.add(file);
                    }
                } else {
                    arrayList.add(file);
                }
                i2++;
            }
            for (File file2 : arrayList) {
                lr4.j(file2);
            }
        }
    }

    public final File b(long j) {
        InterceptResult invokeJ;
        String g0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                return null;
            }
            if (hb3.g0() == null) {
                g0 = "";
            } else {
                g0 = hb3.g0();
            }
            return new File(this.a + File.separator + g0 + "_" + j + "_swan_stability_traces.log");
        }
        return (File) invokeJ.objValue;
    }

    public File[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                return null;
            }
            try {
                return new File(this.a).listFiles();
            } catch (Exception e) {
                if (b) {
                    Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                }
                return null;
            }
        }
        return (File[]) invokeV.objValue;
    }

    public File d(JSONArray jSONArray) {
        InterceptResult invokeL;
        String g0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                a(9);
                JSONObject jSONObject = new JSONObject();
                if (hb3.g0() == null) {
                    g0 = "";
                } else {
                    g0 = hb3.g0();
                }
                jSONObject.put("_app_id", g0);
                jSONObject.put("_date", vn3.b(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
                jSONArray.put(jSONObject);
                File b2 = b(currentTimeMillis);
                if (b2 == null) {
                    return null;
                }
                if (!ku2.b(b2.getPath(), jSONArray.toString(), false)) {
                    return null;
                }
                return b2;
            } catch (Exception e) {
                if (b) {
                    Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                }
                return null;
            }
        }
        return (File) invokeL.objValue;
    }
}
