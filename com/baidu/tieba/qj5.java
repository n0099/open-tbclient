package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class qj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;

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

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
        }

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (StringUtils.isNull(str)) {
                    return null;
                }
                a aVar = new a();
                if (str.contains("#")) {
                    String[] split = str.split("#");
                    if (split.length == 1) {
                        aVar.a = split[0];
                    } else if (split.length == 2) {
                        aVar.a = split[0];
                        aVar.b = yg.e(split[1], -1);
                    }
                } else {
                    aVar.a = str;
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (StringUtils.isNull(this.a)) {
                    return "";
                }
                return this.a + "#" + this.b;
            }
            return (String) invokeV.objValue;
        }
    }

    public static String[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String r = cz4.l().r("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "");
            if (StringUtils.isNull(r)) {
                return new String[0];
            }
            String[] split = r.split("\\^");
            if (split != null && split.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : split) {
                    a a2 = a.a(str);
                    if (a2 != null && !StringUtils.isNull(a2.a)) {
                        arrayList.add(a2.a);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return null;
        }
        return (String[]) invokeV.objValue;
    }
}
