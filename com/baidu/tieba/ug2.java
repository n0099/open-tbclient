package com.baidu.tieba;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ug2 implements tg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] a;

    public ug2() {
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
        this.a = new String[]{br2.c().getDatabasePath("ai_apps.db").getAbsolutePath(), br2.c().getDatabasePath("ai_apps_pms.db").getAbsolutePath()};
    }

    @Override // com.baidu.tieba.tg2
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.a) {
                String K = yn4.K(str);
                if (!TextUtils.isEmpty(K)) {
                    arraySet.add(K);
                }
            }
            u42.k("SwanDatabaseCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }
}
