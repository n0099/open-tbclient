package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class jd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<kd5> a;

    public jd5() {
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

    public void a(JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
            this.a = new ArrayList();
            try {
                if (jSONArray == null) {
                    SharedPrefHelper.getInstance().putString("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(SharedPrefHelper.getInstance().getString("key_index_tab_info_list", "[]"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    kd5 kd5Var = new kd5();
                    kd5 kd5Var2 = new kd5();
                    kd5Var.i(jSONArray.getJSONObject(i));
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        kd5Var2.i(jSONArray2.getJSONObject(i2));
                        if (kd5Var.c != null && kd5Var.c.equals(kd5Var2.c)) {
                            if (!TextUtils.isEmpty(kd5Var2.e) && kd5Var2.e.equals(kd5Var.e)) {
                                z = false;
                                kd5Var.f = z;
                            }
                            z = true;
                            kd5Var.f = z;
                        }
                    }
                    if (!kd5Var.f()) {
                        this.a.add(kd5Var);
                    }
                }
                SharedPrefHelper.getInstance().putString("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
