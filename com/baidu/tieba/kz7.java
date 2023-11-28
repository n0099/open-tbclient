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
public class kz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<pi> a;
    public List<ThreadData> b;
    public Object[] c;

    public kz7() {
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
                        ju6 ju6Var = new ju6();
                        ju6Var.c(threadData);
                        this.a.add(ju6Var);
                    } else {
                        ku6 ku6Var = new ku6();
                        ku6Var.c(threadData);
                        this.a.add(ku6Var);
                    }
                }
            }
        }
    }

    public void c(int i, iz7 iz7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, iz7Var) != null) || iz7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[iz7Var.b + 10];
        }
        if (!ListUtils.isEmpty(iz7Var.c)) {
            ArrayList arrayList = new ArrayList(iz7Var.c.size());
            for (ThreadData threadData : iz7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(iz7Var);
        }
        this.a.clear();
        b();
        g();
        f(iz7Var);
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

    public final void f(iz7 iz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iz7Var) == null) {
            pu6 pu6Var = new pu6();
            pu6Var.d(iz7Var.d);
            this.a.add(0, pu6Var);
        }
    }

    public final void e(iz7 iz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iz7Var) == null) {
            if (!ListUtils.isEmpty(iz7Var.e)) {
                for (FeatureCardHot featureCardHot : iz7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(iz7Var.f)) {
                for (FeatureCardTopic featureCardTopic : iz7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(iz7Var.g)) {
                for (jz7 jz7Var : iz7Var.g) {
                    if (jz7Var != null && jz7Var.a()) {
                        d(jz7Var.c.intValue());
                        this.c[jz7Var.c.intValue()] = jz7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(iz7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : iz7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(iz7Var.i)) {
                for (FeatureCardGod featureCardGod : iz7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(iz7Var.j)) {
                for (FeatureCardGame featureCardGame : iz7Var.j) {
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
                            nu6 nu6Var = new nu6();
                            nu6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, nu6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            qu6 qu6Var = new qu6();
                            qu6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, qu6Var);
                        } else if (obj instanceof jz7) {
                            mu6 mu6Var = new mu6();
                            mu6Var.d((jz7) obj);
                            this.a.add(i2, mu6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            lu6 lu6Var = new lu6();
                            lu6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, lu6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            ps7 ps7Var = new ps7();
                            ps7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, ps7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            ou6 ou6Var = new ou6();
                            ou6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, ou6Var);
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
