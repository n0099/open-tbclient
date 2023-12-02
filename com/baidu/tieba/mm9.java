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
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes7.dex */
public class mm9 implements pi {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId d;
    public transient /* synthetic */ FieldHolder $fh;
    public hm9 a;
    public List<nm9> b;
    public List<nm9> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947977616, "Lcom/baidu/tieba/mm9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947977616, "Lcom/baidu/tieba/mm9;");
                return;
            }
        }
        d = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return d;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public mm9(VipThemeList vipThemeList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipThemeList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        hm9 hm9Var = new hm9();
        this.a = hm9Var;
        hm9Var.e(2);
        this.a.d(vipThemeList.class_name);
        this.a.f(vipThemeList.class_url_name);
        this.a.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.b = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.b.add(new nm9(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.c = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.c.add(new nm9(vipThemeItem2));
            }
        }
    }
}
