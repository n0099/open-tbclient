package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.permission.DangerousPermissionConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n03 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public String g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947948600, "Lcom/baidu/tieba/n03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947948600, "Lcom/baidu/tieba/n03;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public n03() {
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
        this.a = 60000;
        this.b = "aac";
        this.c = 1;
        this.d = 8000;
        this.e = 16000;
        this.f = 1;
    }

    public static n03 a(JSONObject jSONObject, n03 n03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, n03Var)) == null) {
            if (jSONObject != null && jSONObject.length() > 0) {
                n03Var = new n03();
                n03Var.a = jSONObject.optInt("duration", 60000);
                String optString = jSONObject.optString("format");
                n03Var.b = optString;
                if (TextUtils.isEmpty(optString)) {
                    n03Var.b = "aac";
                }
                n03Var.c = jSONObject.optInt("numberOfChannels", 1);
                n03Var.d = jSONObject.optInt("sampleRate", 8000);
                int optInt = jSONObject.optInt("encodeBitRate");
                n03Var.e = optInt;
                if (optInt == 0) {
                    int i = n03Var.d;
                    if (i != 8000) {
                        if (i != 16000) {
                            if (i == 44100) {
                                n03Var.e = 64000;
                            }
                        } else {
                            n03Var.e = 24000;
                        }
                    } else {
                        n03Var.e = 16000;
                    }
                }
                n03Var.f = b(jSONObject.optString("audioSource", "auto"));
                n03Var.g = jSONObject.optString("cb");
            }
            return n03Var;
        }
        return (n03) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            switch (str.hashCode()) {
                case -401509030:
                    if (str.equals(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMCORDER)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 108103:
                    if (str.equals(DangerousPermissionConstants.DANGEROUS_PERMISSION_MIC)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1059882026:
                    if (str.equals("voice_recognition")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1611170697:
                    if (str.equals("voice_communication")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0 && c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            return -1;
                        }
                        return 6;
                    }
                    return 7;
                }
                return 5;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0086, code lost:
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.a;
            if (i <= 600000 && i >= 0) {
                int i2 = this.c;
                boolean z = true;
                if (i2 != 1 && i2 != 2) {
                    return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
                }
                if (!TextUtils.equals(this.b, "aac") && !TextUtils.equals(this.b, "pcm")) {
                    return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
                }
                int i3 = this.d;
                if (i3 != 8000 && i3 != 16000 && i3 != 44100) {
                    return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
                }
                if (!TextUtils.equals(this.b, "pcm")) {
                    if ((r3 = this.d) != 8000) {
                        if (z) {
                            return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
                        }
                    } else if (z) {
                    }
                }
                if (this.f < 0) {
                    return UnitedSchemeUtility.wrapCallbackParams(202, "error audioSource");
                }
                return null;
            }
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "recordTime : " + this.a + "; channel : " + this.c + "; audioFormat : " + this.b + "; sampleRate : " + this.d + "; bitRate : " + this.e + "; callbacks : " + this.g;
        }
        return (String) invokeV.objValue;
    }
}
