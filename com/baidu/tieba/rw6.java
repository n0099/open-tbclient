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
public class rw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List<py4> c;
    public final List<py4> d;
    public boolean e;

    public rw6() {
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

    public py4 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            py4 py4Var = new py4();
            py4Var.a = i;
            py4Var.b = str;
            py4Var.c = str2;
            py4Var.d = str3;
            return py4Var;
        }
        return (py4) invokeCommon.objValue;
    }

    public py4 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            py4 py4Var = new py4();
            py4Var.a = i;
            py4Var.b = str;
            py4Var.c = str2;
            return py4Var;
        }
        return (py4) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.e) {
                return false;
            }
            List<py4> i = i();
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

    public final List<py4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, g(R.string.obfuscated_res_0x7f0f1356), ""));
            arrayList.add(b(6, g(R.string.obfuscated_res_0x7f0f1352), ""));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1351), "game"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f134e), "digital"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f134f), "entertainment"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1350), "films"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f134c), "campus"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f134b), "animes"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1355), "sports"));
            arrayList.add(a(202, g(R.string.obfuscated_res_0x7f0f1353), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.b));
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
    public List<py4> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public final String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public List<py4> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final List<py4> i() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONArray(tu4.k().q("key_index_tab_info_list", "[]"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jSONArray.length() == 0) {
                this.e = true;
                return d();
            }
            this.e = false;
            boolean isHomeTabModifyABTestA = UbsABTestHelper.isHomeTabModifyABTestA();
            for (int i = 0; i < jSONArray.length(); i++) {
                py4 py4Var = new py4();
                py4Var.h(jSONArray.getJSONObject(i));
                if (!py4Var.e()) {
                    if (isHomeTabModifyABTestA) {
                        if (py4Var.f() && arrayList.size() < 2) {
                            arrayList.add(py4Var);
                        } else {
                            this.d.add(py4Var);
                        }
                    } else {
                        arrayList.add(py4Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<py4> i = i();
            if (ListUtils.isEmpty(i)) {
                return;
            }
            this.c.addAll(i);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<py4> list = this.c;
            if (list != null) {
                list.clear();
            }
            j();
        }
    }
}
