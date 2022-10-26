package com.baidu.tieba;

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
/* loaded from: classes6.dex */
public class vy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List c;
    public final List d;
    public boolean e;

    public vy6() {
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

    public q15 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            q15 q15Var = new q15();
            q15Var.a = i;
            q15Var.b = str;
            q15Var.c = str2;
            q15Var.d = str3;
            return q15Var;
        }
        return (q15) invokeCommon.objValue;
    }

    public q15 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            q15 q15Var = new q15();
            q15Var.a = i;
            q15Var.b = str;
            q15Var.c = str2;
            if (i == 5) {
                z = true;
            } else {
                z = false;
            }
            q15Var.i(z);
            return q15Var;
        }
        return (q15) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.e) {
                return false;
            }
            List i = i();
            int size = i.size();
            if (size != this.c.size()) {
                return true;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (i.get(i2) != null && !((q15) i.get(i2)).equals(this.c.get(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, g(R.string.obfuscated_res_0x7f0f1389), ""));
            arrayList.add(b(6, g(R.string.obfuscated_res_0x7f0f1385), ""));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1384), "game"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1381), "digital"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1382), "entertainment"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1383), "films"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f137f), "campus"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f137e), "animes"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1388), "sports"));
            arrayList.add(a(202, g(R.string.obfuscated_res_0x7f0f1386), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.b));
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

    public List f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List h() {
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
            List i = i();
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

    public final List i() {
        InterceptResult invokeV;
        int length;
        q15 q15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(ux4.k().q("key_index_tab_info_list", "[]"));
                List arrayList2 = new ArrayList();
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
                        q15Var = (q15) arrayList2.get(i);
                    } else {
                        q15Var = new q15();
                        q15Var.h(jSONArray.getJSONObject(i));
                    }
                    if (!q15Var.e()) {
                        if (q15Var.f() && arrayList.size() < 2) {
                            arrayList.add(q15Var);
                        } else {
                            this.d.add(q15Var);
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
