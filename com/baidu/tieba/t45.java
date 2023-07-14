package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes8.dex */
public class t45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q35 a;
    public List<d25> b;
    public List<e25> c;
    public List<p35> d;

    public t45() {
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
        q35 q35Var = new q35();
        this.a = q35Var;
        q35Var.a(seniorLottery.theme);
        this.b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i = 0; i < size; i++) {
            d25 d25Var = new d25();
            d25Var.a(seniorLottery.award_info.get(i));
            this.b.add(d25Var);
        }
        String str = seniorLottery.myaward;
        this.c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i2 = 0; i2 < size2; i2++) {
            e25 e25Var = new e25();
            e25Var.a(seniorLottery.luck_users.get(i2));
            this.c.add(e25Var);
        }
        String str2 = seniorLottery.act_desc;
        this.d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i3 = 0; i3 < size3; i3++) {
            p35 p35Var = new p35();
            p35Var.a(seniorLottery.act_regular.get(i3));
            this.d.add(p35Var);
        }
    }
}
