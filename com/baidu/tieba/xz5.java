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
/* loaded from: classes7.dex */
public class xz5 {
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
    public String l;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @NonNull
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final xz5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-272463816, "Lcom/baidu/tieba/xz5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-272463816, "Lcom/baidu/tieba/xz5$b;");
                    return;
                }
            }
            a = new xz5(null);
        }
    }

    public xz5() {
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
            this.b = ji.k();
            this.c = TbadkCoreApplication.getInst().getCuidGalaxy2();
            this.d = r();
            this.e = s();
            this.f = ji.g();
            this.g = TbadkCoreApplication.getInst().getImei();
            this.h = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            this.i = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            this.j = BdBaseApplication.getInst().getPackageName();
            this.k = TbadkCoreApplication.getInst().getAndroidId();
            this.l = "com.baidu.tieba.fileprovider";
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @NonNull
    public final String r() {
        InterceptResult invokeV;
        String sb;
        String replace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                sb = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = property.length();
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if (charAt > 31 && charAt < 127) {
                        sb2.append(charAt);
                    } else {
                        sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    }
                }
                sb = sb2.toString();
            }
            String k = ji.k();
            if (TextUtils.isEmpty(k)) {
                replace = "0.0";
            } else {
                replace = k.replace("_", "-");
            }
            return sb + " baiduboxapp/" + TbConfig.getVersion() + " (Baidu; P1 " + replace + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ xz5(a aVar) {
        this();
    }

    public static xz5 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (xz5) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNull(this.k)) {
                try {
                    this.k = TbadkCoreApplication.getInst().getAndroidId();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String baiduIdForAnti = TbSingleton.getInstance().getBaiduIdForAnti();
            if (baiduIdForAnti == null) {
                return "";
            }
            return baiduIdForAnti;
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
            if (this.l == null) {
                this.l = "com.baidu.tieba.fileprovider";
            }
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (StringUtils.isNull(this.g)) {
                try {
                    this.g = TbadkCoreApplication.getInst().getImei();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (StringUtils.isNull(this.i)) {
                try {
                    this.i = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (StringUtils.isNull(this.f)) {
                this.f = ji.g();
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (StringUtils.isNull(this.h)) {
                try {
                    this.h = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (StringUtils.isNull(this.b)) {
                this.b = ji.k();
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (StringUtils.isNull(this.j)) {
                try {
                    this.j = BdBaseApplication.getInst().getPackageName();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (StringUtils.isNull(this.e)) {
                try {
                    this.e = s();
                } catch (Exception e) {
                    BdLog.e(e);
                    return "";
                }
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String sampleId = TbSingleton.getInstance().getSampleId();
            if (sampleId == null) {
                return "";
            }
            return sampleId.replace(SignatureImpl.SEP, ',');
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
}
