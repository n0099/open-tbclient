package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class ne5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "add_user_collect_emotoin";
    public static String b = "image_url";
    public static String c = "thumbnail_url";
    public static String d = "pic_id";
    public static String e = "package_id";
    public static String f = "#(meme,setting)";
    public static String g = "#(meme,collect_";
    public static String h = "meme,collect_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947999595, "Lcom/baidu/tieba/ne5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947999595, "Lcom/baidu/tieba/ne5;");
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public a() {
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

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

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

    public static String a() {
        InterceptResult invokeV;
        String currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("collect_");
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            sb.append(currentAccount);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        String currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("diy_");
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            sb.append(currentAccount);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return Math.abs(b().hashCode()) + "";
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return Math.abs(a().hashCode()) + "";
        }
        return (String) invokeV.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Matcher matcher = Pattern.compile("#\\(meme,collect_[a-zA-Z0-9_,]+\\)").matcher(str);
        int i = 0;
        int i2 = 0;
        while (matcher.find()) {
            String[] split = matcher.group().split(",");
            if (split != null && split.length == 5 && split[1] != null && split[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)")) {
                i2++;
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
        while (matcher2.find()) {
            String[] split2 = matcher2.group().split(",");
            if (split2 != null && split2.length == 5 && split2[1] != null && !split2[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)") && split2[1].contains("_")) {
                i++;
            }
        }
        if (i2 > 0) {
            StatisticItem statisticItem = new StatisticItem("c12223");
            statisticItem.param("obj_param1", i2);
            TiebaStatic.log(statisticItem);
        }
        if (i > 0) {
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_USE_EMOTION);
            statisticItem2.param("obj_param1", i);
            TiebaStatic.log(statisticItem2);
        }
    }
}
