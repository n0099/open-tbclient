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
/* loaded from: classes5.dex */
public class ou6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yn> a;
    public List<ThreadData> b;
    public Object[] c;

    public ou6() {
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

    public List<yn> a() {
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
                        qd6 qd6Var = new qd6();
                        qd6Var.c(threadData);
                        this.a.add(qd6Var);
                    } else {
                        rd6 rd6Var = new rd6();
                        rd6Var.c(threadData);
                        this.a.add(rd6Var);
                    }
                }
            }
        }
    }

    public void c(int i, mu6 mu6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, mu6Var) != null) || mu6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[mu6Var.b + 10];
        }
        if (!ListUtils.isEmpty(mu6Var.c)) {
            ArrayList arrayList = new ArrayList(mu6Var.c.size());
            for (ThreadData threadData : mu6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(mu6Var);
        }
        this.a.clear();
        b();
        g();
        f(mu6Var);
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

    public final void f(mu6 mu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mu6Var) == null) {
            wd6 wd6Var = new wd6();
            wd6Var.f(mu6Var.d);
            this.a.add(0, wd6Var);
        }
    }

    public final void e(mu6 mu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mu6Var) == null) {
            if (!ListUtils.isEmpty(mu6Var.e)) {
                for (FeatureCardHot featureCardHot : mu6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(mu6Var.f)) {
                for (FeatureCardTopic featureCardTopic : mu6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(mu6Var.g)) {
                for (nu6 nu6Var : mu6Var.g) {
                    if (nu6Var != null && nu6Var.a()) {
                        d(nu6Var.c.intValue());
                        this.c[nu6Var.c.intValue()] = nu6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(mu6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : mu6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(mu6Var.i)) {
                for (FeatureCardGod featureCardGod : mu6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(mu6Var.j)) {
                for (FeatureCardGame featureCardGame : mu6Var.j) {
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
                            ud6 ud6Var = new ud6();
                            ud6Var.f((FeatureCardHot) obj);
                            this.a.add(i2, ud6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            xd6 xd6Var = new xd6();
                            xd6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, xd6Var);
                        } else if (obj instanceof nu6) {
                            td6 td6Var = new td6();
                            td6Var.f((nu6) obj);
                            this.a.add(i2, td6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            sd6 sd6Var = new sd6();
                            sd6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, sd6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            co6 co6Var = new co6();
                            co6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, co6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            vd6 vd6Var = new vd6();
                            vd6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, vd6Var);
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
