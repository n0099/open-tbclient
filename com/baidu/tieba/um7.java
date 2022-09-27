package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes6.dex */
public class um7 implements Cdo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public transient /* synthetic */ FieldHolder $fh;
    public rm7 a;
    public List<vm7> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948215882, "Lcom/baidu/tieba/um7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948215882, "Lcom/baidu/tieba/um7;");
                return;
            }
        }
        c = BdUniqueId.gen();
    }

    public um7(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipDailyList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        rm7 rm7Var = new rm7();
        this.a = rm7Var;
        rm7Var.e(1);
        this.a.d(vipDailyList.class_name);
        this.a.f(vipDailyList.class_url_name);
        this.a.g(vipDailyList.class_url);
        this.b = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.b.add(new vm7(vipThemeItem));
        }
    }

    @Override // com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c : (BdUniqueId) invokeV.objValue;
    }
}
