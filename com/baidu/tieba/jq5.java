package com.baidu.tieba;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes4.dex */
public class jq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final jq5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-681583619, "Lcom/baidu/tieba/jq5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-681583619, "Lcom/baidu/tieba/jq5$b;");
                    return;
                }
            }
            a = new jq5(null);
        }
    }

    public /* synthetic */ jq5(a aVar) {
        this();
    }

    public static jq5 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (jq5) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNull(this.j)) {
                try {
                    this.j = TbadkCoreApplication.getInst().getAndroidId();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String baiduIdForAnti = TbSingleton.getInstance().getBaiduIdForAnti();
            return baiduIdForAnti == null ? "" : baiduIdForAnti;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (StringUtils.isNull(this.a)) {
                try {
                    this.a = TbConfig.getVersion();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (StringUtils.isNull(this.c)) {
                try {
                    this.c = TbadkCoreApplication.getInst().getCuidGalaxy2();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.k == null) {
                this.k = "com.baidu.tieba.fileprovider";
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (StringUtils.isNull(this.f)) {
                try {
                    this.f = TbadkCoreApplication.getInst().getImei();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (StringUtils.isNull(this.h)) {
                try {
                    this.h = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (StringUtils.isNull(this.e)) {
                this.e = gj.g();
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (StringUtils.isNull(this.g)) {
                try {
                    this.g = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (StringUtils.isNull(this.b)) {
                this.b = gj.k();
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (StringUtils.isNull(this.i)) {
                try {
                    this.i = BdBaseApplication.getInst().getPackageName();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (StringUtils.isNull(this.d)) {
                try {
                    this.d = r();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String sampleId = TbSingleton.getInstance().getSampleId();
            return sampleId == null ? "" : sampleId.replace(SignatureImpl.SEP, ',');
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TbadkCoreApplication.getCurrentAccount() : (String) invokeV.objValue;
    }

    @NonNull
    public final String q() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                sb = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = property.length();
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        sb2.append(charAt);
                    }
                }
                sb = sb2.toString();
            }
            String k = gj.k();
            String replace = TextUtils.isEmpty(k) ? "0.0" : k.replace("_", "-");
            return sb + " baiduboxapp/" + TbConfig.getVersion() + " (Baidu; P1 " + replace + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DisplayMetrics displayMetrics = TbadkCoreApplication.getInst().getResources().getDisplayMetrics();
            int i = 0;
            String[] strArr = {String.valueOf(displayMetrics.widthPixels), String.valueOf(displayMetrics.heightPixels), "android", TbConfig.getVersion(), String.valueOf(displayMetrics.densityDpi)};
            StringBuilder sb = new StringBuilder();
            String str = "";
            while (i < 5) {
                String str2 = strArr[i];
                sb.append(str);
                sb.append(str2);
                i++;
                str = "_";
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public jq5() {
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
        try {
            this.a = TbConfig.getVersion();
            this.b = gj.k();
            this.c = TbadkCoreApplication.getInst().getCuidGalaxy2();
            q();
            this.d = r();
            this.e = gj.g();
            this.f = TbadkCoreApplication.getInst().getImei();
            this.g = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            this.h = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            this.i = BdBaseApplication.getInst().getPackageName();
            this.j = TbadkCoreApplication.getInst().getAndroidId();
            this.k = "com.baidu.tieba.fileprovider";
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
