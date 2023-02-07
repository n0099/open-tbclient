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
public class st6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m95 a;
    public FrsActivity b;
    public Map<String, Date> c;
    public boolean d;

    public st6(FrsActivity frsActivity) {
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
        m95 m95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (m95Var = this.a) != null) {
            m95Var.q();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            m95 m95Var = this.a;
            if (m95Var != null && m95Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Date c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
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

    public void d(String str) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (frsActivity = this.b) != null && frsActivity.getPageContext() != null) {
            Date c = c(str);
            if ((!NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() || !m85.d().n()) && this.d) {
                boolean z = false;
                if (n95.g(TbadkCoreApplication.getInst(), 0)) {
                    FrsActivity frsActivity2 = this.b;
                    if (frsActivity2 != null && frsActivity2.t1() != null) {
                        z = this.b.t1().A;
                    }
                    HashMap hashMap = new HashMap();
                    if (z) {
                        hashMap.put("view_params_key_style", "short");
                    }
                    m95 m95Var = this.a;
                    if (m95Var != null) {
                        m95Var.q();
                    }
                    this.a = n95.l(this.b.getPageContext(), "forum_follow", 2000L, hashMap);
                    this.c.put(str, c);
                    TbSingleton.getInstance().setHasShowTip(this.c);
                    return;
                }
            }
            ej.S(TbadkCoreApplication.getInst(), R.string.push_like_tip_msg);
        }
    }
}
