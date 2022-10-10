package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
public class oy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List<k15> c;
    public final List<k15> d;
    public boolean e;

    public oy6() {
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

    public k15 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            k15 k15Var = new k15();
            k15Var.a = i;
            k15Var.b = str;
            k15Var.c = str2;
            k15Var.d = str3;
            return k15Var;
        }
        return (k15) invokeCommon.objValue;
    }

    public k15 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            k15 k15Var = new k15();
            k15Var.a = i;
            k15Var.b = str;
            k15Var.c = str2;
            k15Var.i(i == 5);
            return k15Var;
        }
        return (k15) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.e) {
                return false;
            }
            List<k15> i = i();
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

    public final List<k15> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, g(R.string.obfuscated_res_0x7f0f1375), ""));
            arrayList.add(b(6, g(R.string.obfuscated_res_0x7f0f1371), ""));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1370), "game"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136d), "digital"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136e), "entertainment"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136f), "films"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136b), "campus"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136a), "animes"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1374), "sports"));
            arrayList.add(a(202, g(R.string.obfuscated_res_0x7f0f1372), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.b));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    @NonNull
    public List<k15> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public final String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public List<k15> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final List<k15> i() {
        InterceptResult invokeV;
        k15 k15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(ox4.k().q("key_index_tab_info_list", "[]"));
                List<k15> arrayList2 = new ArrayList<>();
                if (jSONArray.length() == 0) {
                    this.e = true;
                    arrayList2 = d();
                } else {
                    this.e = false;
                }
                boolean isHomeTabModifyABTestA = UbsABTestHelper.isHomeTabModifyABTestA();
                int size = this.e ? arrayList2.size() : jSONArray.length();
                for (int i = 0; i < size; i++) {
                    if (this.e) {
                        k15Var = arrayList2.get(i);
                    } else {
                        k15Var = new k15();
                        k15Var.h(jSONArray.getJSONObject(i));
                    }
                    if (!k15Var.e()) {
                        if (isHomeTabModifyABTestA) {
                            if (k15Var.f() && arrayList.size() < 2) {
                                arrayList.add(k15Var);
                            } else {
                                this.d.add(k15Var);
                            }
                        } else {
                            arrayList.add(k15Var);
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

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<k15> i = i();
            if (ListUtils.isEmpty(i)) {
                return;
            }
            this.c.addAll(i);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<k15> list = this.c;
            if (list != null) {
                list.clear();
            }
            j();
        }
    }
}
