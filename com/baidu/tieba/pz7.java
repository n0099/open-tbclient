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
/* loaded from: classes7.dex */
public class pz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<pi> a;
    public List<ThreadData> b;
    public Object[] c;

    public pz7() {
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

    public List<pi> a() {
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
                        nu6 nu6Var = new nu6();
                        nu6Var.c(threadData);
                        this.a.add(nu6Var);
                    } else {
                        ou6 ou6Var = new ou6();
                        ou6Var.c(threadData);
                        this.a.add(ou6Var);
                    }
                }
            }
        }
    }

    public void c(int i, nz7 nz7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, nz7Var) != null) || nz7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[nz7Var.b + 10];
        }
        if (!ListUtils.isEmpty(nz7Var.c)) {
            ArrayList arrayList = new ArrayList(nz7Var.c.size());
            for (ThreadData threadData : nz7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(nz7Var);
        }
        this.a.clear();
        b();
        g();
        f(nz7Var);
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

    public final void f(nz7 nz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nz7Var) == null) {
            tu6 tu6Var = new tu6();
            tu6Var.d(nz7Var.d);
            this.a.add(0, tu6Var);
        }
    }

    public final void e(nz7 nz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nz7Var) == null) {
            if (!ListUtils.isEmpty(nz7Var.e)) {
                for (FeatureCardHot featureCardHot : nz7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(nz7Var.f)) {
                for (FeatureCardTopic featureCardTopic : nz7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(nz7Var.g)) {
                for (oz7 oz7Var : nz7Var.g) {
                    if (oz7Var != null && oz7Var.a()) {
                        d(oz7Var.c.intValue());
                        this.c[oz7Var.c.intValue()] = oz7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(nz7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : nz7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(nz7Var.i)) {
                for (FeatureCardGod featureCardGod : nz7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(nz7Var.j)) {
                for (FeatureCardGame featureCardGame : nz7Var.j) {
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
                            ru6 ru6Var = new ru6();
                            ru6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, ru6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            uu6 uu6Var = new uu6();
                            uu6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, uu6Var);
                        } else if (obj instanceof oz7) {
                            qu6 qu6Var = new qu6();
                            qu6Var.d((oz7) obj);
                            this.a.add(i2, qu6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            pu6 pu6Var = new pu6();
                            pu6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, pu6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            us7 us7Var = new us7();
                            us7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, us7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            su6 su6Var = new su6();
                            su6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, su6Var);
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
