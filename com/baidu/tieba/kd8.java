package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class kd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List<a95> c;
    public final List<a95> d;

    public kd8() {
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
        this.a = 1;
        this.b = "https://boxnovel.baidu.com/boxnovel/haokan";
        this.c = new ArrayList();
        this.d = new ArrayList();
        j();
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<a95> i = i();
            int size = i.size();
            if (size != this.c.size()) {
                return true;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (i.get(i2) != null && !i.get(i2).equals(this.c.get(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public a95 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            a95 a95Var = new a95();
            a95Var.a = i;
            a95Var.b = str;
            a95Var.c = str2;
            a95Var.d = str3;
            return a95Var;
        }
        return (a95) invokeCommon.objValue;
    }

    public a95 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            a95 a95Var = new a95();
            a95Var.a = i;
            a95Var.b = str;
            a95Var.c = str2;
            if (i == 5) {
                z = true;
            } else {
                z = false;
            }
            a95Var.k(z);
            return a95Var;
        }
        return (a95) invokeILL.objValue;
    }

    public final List<a95> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, g(R.string.tab_name_topic_rank), ""));
            arrayList.add(b(6, g(R.string.obfuscated_res_0x7f0f161b), ""));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f161a), "game"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1617), "digital"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1618), "entertainment"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1619), "films"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1615), "campus"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1614), "animes"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f161e), "sports"));
            arrayList.add(a(202, g(R.string.obfuscated_res_0x7f0f161c), "novel", this.b));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @NonNull
    public List<a95> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List<a95> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<a95> i = i();
            if (!ListUtils.isEmpty(i)) {
                this.c.addAll(i);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<a95> list = this.c;
            if (list != null) {
                list.clear();
            }
            j();
        }
    }

    public final String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return TbadkCoreApplication.getInst().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public final List<a95> i() {
        InterceptResult invokeV;
        boolean z;
        int length;
        a95 a95Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(SharedPrefHelper.getInstance().getString("key_index_tab_info_list", "[]"));
                List<a95> arrayList2 = new ArrayList<>();
                if (jSONArray.length() == 0) {
                    arrayList2 = d();
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    length = arrayList2.size();
                } else {
                    length = jSONArray.length();
                }
                for (int i = 0; i < length; i++) {
                    if (z) {
                        a95Var = arrayList2.get(i);
                    } else {
                        a95Var = new a95();
                        a95Var.i(jSONArray.getJSONObject(i));
                    }
                    if (!a95Var.f()) {
                        if (a95Var.g() && arrayList.size() < 2) {
                            arrayList.add(a95Var);
                        } else {
                            this.d.add(a95Var);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
