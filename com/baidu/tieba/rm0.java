package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.lm0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rm0 extends qm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final gm0 e;
    public HashMap<String, b> f;
    public String g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-456393481, "Lcom/baidu/tieba/rm0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-456393481, "Lcom/baidu/tieba/rm0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadStatus.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm0(@NonNull gm0 gm0Var) {
        super(gm0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gm0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gm0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new HashMap<>();
        this.g = "";
        this.e = gm0Var;
        this.c = new wm0(this);
    }

    @NonNull
    public gm0 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (gm0) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m(this.c);
        }
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = a.a[this.e.c.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return "0";
                            }
                            return "4";
                        }
                        gm0 gm0Var = this.e;
                        gm0Var.i = 1.0f;
                        gm0Var.j = 1.0f;
                        return "3";
                    }
                    return "2";
                }
                return "1";
            }
            gm0 gm0Var2 = this.e;
            gm0Var2.i = 0.0f;
            gm0Var2.j = 0.0f;
            return "0";
        }
        return (String) invokeV.objValue;
    }

    public void x(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, str4) == null) {
            lm0 lm0Var = new lm0();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            String a2 = rn0.a(str, str2, str3, str4);
            y31.f(jSONObject, "status", "0");
            y31.f(jSONObject, "message", "");
            y31.f(jSONObject, "data", a2);
            for (String str5 : this.f.keySet()) {
                b bVar = (b) z31.b(this.f, str5);
                if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
                    lm0.a aVar = new lm0.a();
                    aVar.b = bVar.b;
                    aVar.a = bVar.a;
                    aVar.c = jSONObject.toString();
                    aVar.d = this.g;
                    x31.b(arrayList, aVar);
                }
            }
            if (!arrayList.isEmpty()) {
                lm0Var.a = arrayList;
                do0.a().a(lm0Var);
            }
        }
    }

    public void y(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str5 = str + "_" + str4 + "_" + str3 + "_" + str2;
            this.f.remove(str5);
            b bVar = new b();
            bVar.b = str;
            bVar.a = str2;
            this.f.put(str5, bVar);
        }
    }

    public void z(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            this.f.remove(str + "_" + str4 + "_" + str3 + "_" + str2);
            this.g = "";
        }
    }
}
