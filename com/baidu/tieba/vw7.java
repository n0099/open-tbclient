package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class vw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List<jd5> c;
    public final List<jd5> d;

    public vw7() {
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
            List<jd5> i = i();
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

    public jd5 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            jd5 jd5Var = new jd5();
            jd5Var.a = i;
            jd5Var.b = str;
            jd5Var.c = str2;
            jd5Var.d = str3;
            return jd5Var;
        }
        return (jd5) invokeCommon.objValue;
    }

    public jd5 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            jd5 jd5Var = new jd5();
            jd5Var.a = i;
            jd5Var.b = str;
            jd5Var.c = str2;
            if (i == 5) {
                z = true;
            } else {
                z = false;
            }
            jd5Var.j(z);
            return jd5Var;
        }
        return (jd5) invokeILL.objValue;
    }

    public final List<jd5> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, g(R.string.tab_name_topic_rank), ""));
            arrayList.add(b(6, g(R.string.obfuscated_res_0x7f0f157d), ""));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f157c), "game"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1579), "digital"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f157a), "entertainment"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f157b), "films"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1577), "campus"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1576), "animes"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1580), "sports"));
            arrayList.add(a(202, g(R.string.obfuscated_res_0x7f0f157e), "novel", this.b));
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
    public List<jd5> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List<jd5> h() {
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
            List<jd5> i = i();
            if (!ListUtils.isEmpty(i)) {
                this.c.addAll(i);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<jd5> list = this.c;
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

    public final List<jd5> i() {
        InterceptResult invokeV;
        boolean z;
        int length;
        jd5 jd5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(n95.m().s("key_index_tab_info_list", "[]"));
                List<jd5> arrayList2 = new ArrayList<>();
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
                        jd5Var = arrayList2.get(i);
                    } else {
                        jd5Var = new jd5();
                        jd5Var.i(jSONArray.getJSONObject(i));
                    }
                    if (!jd5Var.f()) {
                        if (jd5Var.g() && arrayList.size() < 2) {
                            arrayList.add(jd5Var);
                        } else {
                            this.d.add(jd5Var);
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
