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
public class p18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List<ad5> c;
    public final List<ad5> d;

    public p18() {
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
            List<ad5> i = i();
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

    public ad5 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            ad5 ad5Var = new ad5();
            ad5Var.a = i;
            ad5Var.b = str;
            ad5Var.c = str2;
            ad5Var.d = str3;
            return ad5Var;
        }
        return (ad5) invokeCommon.objValue;
    }

    public ad5 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            ad5 ad5Var = new ad5();
            ad5Var.a = i;
            ad5Var.b = str;
            ad5Var.c = str2;
            if (i == 5) {
                z = true;
            } else {
                z = false;
            }
            ad5Var.k(z);
            return ad5Var;
        }
        return (ad5) invokeILL.objValue;
    }

    public final List<ad5> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, g(R.string.tab_name_topic_rank), ""));
            arrayList.add(b(6, g(R.string.obfuscated_res_0x7f0f15c6), ""));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f15c5), "game"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f15c2), "digital"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f15c3), "entertainment"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f15c4), "films"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f15c0), "campus"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f15bf), "animes"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f15c9), "sports"));
            arrayList.add(a(202, g(R.string.obfuscated_res_0x7f0f15c7), "novel", this.b));
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
    public List<ad5> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List<ad5> h() {
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
            List<ad5> i = i();
            if (!ListUtils.isEmpty(i)) {
                this.c.addAll(i);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<ad5> list = this.c;
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

    public final List<ad5> i() {
        InterceptResult invokeV;
        boolean z;
        int length;
        ad5 ad5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(SharedPrefHelper.getInstance().getString("key_index_tab_info_list", "[]"));
                List<ad5> arrayList2 = new ArrayList<>();
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
                        ad5Var = arrayList2.get(i);
                    } else {
                        ad5Var = new ad5();
                        ad5Var.i(jSONArray.getJSONObject(i));
                    }
                    if (!ad5Var.f()) {
                        if (ad5Var.g() && arrayList.size() < 2) {
                            arrayList.add(ad5Var);
                        } else {
                            this.d.add(ad5Var);
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
