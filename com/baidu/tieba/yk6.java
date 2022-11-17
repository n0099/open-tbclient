package com.baidu.tieba;

import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class yk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m45 a;
    public FrsActivity b;
    public Map<String, Date> c;
    public boolean d;

    public yk6(FrsActivity frsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new HashMap();
        this.d = false;
        this.b = frsActivity;
    }

    public void a() {
        m45 m45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (m45Var = this.a) != null) {
            m45Var.q();
        }
    }

    public Date b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.c == null) {
                this.c = new HashMap();
            } else {
                this.c = TbSingleton.getInstance().getHasShowTip();
            }
            Date date = new Date(System.currentTimeMillis());
            Map<String, Date> map = this.c;
            if (map != null && map.containsKey(str)) {
                if (TimeHelper.getDayDifference(this.c.get(str), date) >= 1) {
                    this.d = true;
                }
            } else {
                this.d = true;
            }
            return date;
        }
        return (Date) invokeL.objValue;
    }

    public void c(String str) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (frsActivity = this.b) != null && frsActivity.getPageContext() != null) {
            Date b = b(str);
            if (!NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && this.d) {
                boolean z = false;
                if (n45.g(TbadkCoreApplication.getInst(), 0)) {
                    FrsActivity frsActivity2 = this.b;
                    if (frsActivity2 != null && frsActivity2.S0() != null) {
                        z = this.b.S0().B;
                    }
                    HashMap hashMap = new HashMap();
                    if (z) {
                        hashMap.put("view_params_key_style", "short");
                    }
                    m45 m45Var = this.a;
                    if (m45Var != null) {
                        m45Var.q();
                    }
                    this.a = n45.j(this.b.getPageContext(), "forum_follow", 2000L, hashMap);
                    this.c.put(str, b);
                    TbSingleton.getInstance().setHasShowTip(this.c);
                    return;
                }
            }
            yi.R(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0f9e);
        }
    }
}
