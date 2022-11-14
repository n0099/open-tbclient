package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class p07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List<l25> c;
    public final List<l25> d;
    public boolean e;

    public p07() {
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

    public l25 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            l25 l25Var = new l25();
            l25Var.a = i;
            l25Var.b = str;
            l25Var.c = str2;
            l25Var.d = str3;
            return l25Var;
        }
        return (l25) invokeCommon.objValue;
    }

    public l25 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            l25 l25Var = new l25();
            l25Var.a = i;
            l25Var.b = str;
            l25Var.c = str2;
            if (i == 5) {
                z = true;
            } else {
                z = false;
            }
            l25Var.i(z);
            return l25Var;
        }
        return (l25) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.e) {
                return false;
            }
            List<l25> i = i();
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

    public final List<l25> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, g(R.string.obfuscated_res_0x7f0f13ad), ""));
            arrayList.add(b(6, g(R.string.obfuscated_res_0x7f0f13a9), ""));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f13a8), "game"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f13a5), "digital"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f13a6), "entertainment"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f13a7), "films"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f13a3), "campus"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f13a2), "animes"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f13ac), "sports"));
            arrayList.add(a(202, g(R.string.obfuscated_res_0x7f0f13aa), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.b));
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
    public List<l25> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List<l25> h() {
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
            List<l25> i = i();
            if (!ListUtils.isEmpty(i)) {
                this.c.addAll(i);
            }
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

    public final List<l25> i() {
        InterceptResult invokeV;
        int length;
        l25 l25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(py4.k().q("key_index_tab_info_list", "[]"));
                List<l25> arrayList2 = new ArrayList<>();
                if (jSONArray.length() == 0) {
                    this.e = true;
                    arrayList2 = d();
                } else {
                    this.e = false;
                }
                if (this.e) {
                    length = arrayList2.size();
                } else {
                    length = jSONArray.length();
                }
                for (int i = 0; i < length; i++) {
                    if (this.e) {
                        l25Var = arrayList2.get(i);
                    } else {
                        l25Var = new l25();
                        l25Var.h(jSONArray.getJSONObject(i));
                    }
                    if (!l25Var.e()) {
                        if (l25Var.f() && arrayList.size() < 2) {
                            arrayList.add(l25Var);
                        } else {
                            this.d.add(l25Var);
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
