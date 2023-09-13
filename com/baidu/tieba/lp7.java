package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class lp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<cn> a;
    public List<ThreadData> b;
    public Object[] c;

    public lp7() {
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
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public List<cn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.b.size(); i++) {
                ThreadData threadData = this.b.get(i);
                if (threadData != null) {
                    if (i % 4 == 0) {
                        tx6 tx6Var = new tx6();
                        tx6Var.c(threadData);
                        this.a.add(tx6Var);
                    } else {
                        ux6 ux6Var = new ux6();
                        ux6Var.c(threadData);
                        this.a.add(ux6Var);
                    }
                }
            }
        }
    }

    public void c(int i, jp7 jp7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, jp7Var) != null) || jp7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[jp7Var.b + 10];
        }
        if (!ListUtils.isEmpty(jp7Var.c)) {
            ArrayList arrayList = new ArrayList(jp7Var.c.size());
            for (ThreadData threadData : jp7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(jp7Var);
        }
        this.a.clear();
        b();
        g();
        f(jp7Var);
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Object[] objArr = this.c;
            if (i >= objArr.length) {
                this.c = Arrays.copyOf(objArr, i + 1);
            }
        }
    }

    public final void f(jp7 jp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jp7Var) == null) {
            zx6 zx6Var = new zx6();
            zx6Var.d(jp7Var.d);
            this.a.add(0, zx6Var);
        }
    }

    public final void e(jp7 jp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jp7Var) == null) {
            if (!ListUtils.isEmpty(jp7Var.e)) {
                for (FeatureCardHot featureCardHot : jp7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(jp7Var.f)) {
                for (FeatureCardTopic featureCardTopic : jp7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(jp7Var.g)) {
                for (kp7 kp7Var : jp7Var.g) {
                    if (kp7Var != null && kp7Var.a()) {
                        d(kp7Var.c.intValue());
                        this.c[kp7Var.c.intValue()] = kp7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(jp7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : jp7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(jp7Var.i)) {
                for (FeatureCardGod featureCardGod : jp7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(jp7Var.j)) {
                for (FeatureCardGame featureCardGame : jp7Var.j) {
                    if (featureCardGame != null && featureCardGame.isValid()) {
                        d(featureCardGame.floor.intValue());
                        this.c[featureCardGame.floor.intValue()] = featureCardGame;
                    }
                }
            }
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (objArr = this.c) != null && objArr.length > 0) {
            int i = 0;
            while (true) {
                Object[] objArr2 = this.c;
                if (i < objArr2.length) {
                    Object obj = objArr2[i];
                    if (obj != null) {
                        int i2 = i - 1;
                        if (i2 < 0) {
                            i2 = 0;
                        } else if (i2 >= this.a.size()) {
                            i2 = this.a.size();
                        }
                        if (obj instanceof FeatureCardHot) {
                            xx6 xx6Var = new xx6();
                            xx6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, xx6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            ay6 ay6Var = new ay6();
                            ay6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, ay6Var);
                        } else if (obj instanceof kp7) {
                            wx6 wx6Var = new wx6();
                            wx6Var.d((kp7) obj);
                            this.a.add(i2, wx6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            vx6 vx6Var = new vx6();
                            vx6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, vx6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            si7 si7Var = new si7();
                            si7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, si7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            yx6 yx6Var = new yx6();
                            yx6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, yx6Var);
                        }
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
