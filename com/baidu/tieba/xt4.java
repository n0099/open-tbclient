package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes6.dex */
public class xt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vs4 a;
    public List<kr4> b;
    public List<lr4> c;
    public List<us4> d;

    public xt4() {
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

    public void a(SeniorLottery seniorLottery) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, seniorLottery) != null) || seniorLottery == null) {
            return;
        }
        vs4 vs4Var = new vs4();
        this.a = vs4Var;
        vs4Var.a(seniorLottery.theme);
        this.b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i = 0; i < size; i++) {
            kr4 kr4Var = new kr4();
            kr4Var.a(seniorLottery.award_info.get(i));
            this.b.add(kr4Var);
        }
        String str = seniorLottery.myaward;
        this.c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i2 = 0; i2 < size2; i2++) {
            lr4 lr4Var = new lr4();
            lr4Var.a(seniorLottery.luck_users.get(i2));
            this.c.add(lr4Var);
        }
        String str2 = seniorLottery.act_desc;
        this.d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i3 = 0; i3 < size3; i3++) {
            us4 us4Var = new us4();
            us4Var.a(seniorLottery.act_regular.get(i3));
            this.d.add(us4Var);
        }
    }
}
