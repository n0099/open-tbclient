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
/* loaded from: classes9.dex */
public class zc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ad5> a;

    public zc5() {
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
                    ad5 ad5Var = new ad5();
                    ad5 ad5Var2 = new ad5();
                    ad5Var.i(jSONArray.getJSONObject(i));
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        ad5Var2.i(jSONArray2.getJSONObject(i2));
                        if (ad5Var.c != null && ad5Var.c.equals(ad5Var2.c)) {
                            if (!TextUtils.isEmpty(ad5Var2.e) && ad5Var2.e.equals(ad5Var.e)) {
                                z = false;
                                ad5Var.f = z;
                            }
                            z = true;
                            ad5Var.f = z;
                        }
                    }
                    if (!ad5Var.f()) {
                        this.a.add(ad5Var);
                    }
                }
                SharedPrefHelper.getInstance().putString("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
