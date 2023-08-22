package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes6.dex */
public class l89 implements bn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public static int d;
    public static boolean e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public k89 a;
    public List<m89> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896892, "Lcom/baidu/tieba/l89;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896892, "Lcom/baidu/tieba/l89;");
                return;
            }
        }
        c = BdUniqueId.gen();
        d = 3;
        e = false;
    }

    @Override // com.baidu.tieba.bn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return c;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public l89(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipSpecialList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipSpecialList != null && (list = vipSpecialList.item) != null && list.size() > 0) {
            String str2 = vipSpecialList.card_id;
            k89 k89Var = new k89();
            this.a = k89Var;
            k89Var.e(4);
            this.a.d(vipSpecialList.class_name);
            this.a.f(vipSpecialList.class_url_name);
            this.a.g(vipSpecialList.class_url);
            if (TbadkCoreApplication.isLogin()) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = SevenZipUtils.FILE_NAME_TEMP;
            }
            if (StringUtils.isNull(f) || !f.equals(str)) {
                e = false;
                f = str;
            }
            this.b = new ArrayList();
            for (int i3 = 0; i3 < vipSpecialList.item.size(); i3++) {
                this.b.add(new m89(vipSpecialList.item.get(i3)));
                if (e) {
                    if (i3 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > d) {
                        this.b.add(new m89(true, true));
                    }
                } else if (i3 == d - 1 && vipSpecialList.item.size() > d) {
                    this.b.add(new m89(true, false));
                    return;
                }
            }
        }
    }
}
