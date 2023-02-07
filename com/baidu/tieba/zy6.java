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
public class zy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Cdo> a;
    public List<ThreadData> b;
    public Object[] c;

    public zy6() {
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

    public List<Cdo> a() {
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
                        bi6 bi6Var = new bi6();
                        bi6Var.c(threadData);
                        this.a.add(bi6Var);
                    } else {
                        ci6 ci6Var = new ci6();
                        ci6Var.c(threadData);
                        this.a.add(ci6Var);
                    }
                }
            }
        }
    }

    public void c(int i, xy6 xy6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, xy6Var) != null) || xy6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[xy6Var.b + 10];
        }
        if (!ListUtils.isEmpty(xy6Var.c)) {
            ArrayList arrayList = new ArrayList(xy6Var.c.size());
            for (ThreadData threadData : xy6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(xy6Var);
        }
        this.a.clear();
        b();
        g();
        f(xy6Var);
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

    public final void f(xy6 xy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xy6Var) == null) {
            hi6 hi6Var = new hi6();
            hi6Var.f(xy6Var.d);
            this.a.add(0, hi6Var);
        }
    }

    public final void e(xy6 xy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xy6Var) == null) {
            if (!ListUtils.isEmpty(xy6Var.e)) {
                for (FeatureCardHot featureCardHot : xy6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(xy6Var.f)) {
                for (FeatureCardTopic featureCardTopic : xy6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(xy6Var.g)) {
                for (yy6 yy6Var : xy6Var.g) {
                    if (yy6Var != null && yy6Var.a()) {
                        d(yy6Var.c.intValue());
                        this.c[yy6Var.c.intValue()] = yy6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(xy6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : xy6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(xy6Var.i)) {
                for (FeatureCardGod featureCardGod : xy6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(xy6Var.j)) {
                for (FeatureCardGame featureCardGame : xy6Var.j) {
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
                            fi6 fi6Var = new fi6();
                            fi6Var.f((FeatureCardHot) obj);
                            this.a.add(i2, fi6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            ii6 ii6Var = new ii6();
                            ii6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, ii6Var);
                        } else if (obj instanceof yy6) {
                            ei6 ei6Var = new ei6();
                            ei6Var.f((yy6) obj);
                            this.a.add(i2, ei6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            di6 di6Var = new di6();
                            di6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, di6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            ns6 ns6Var = new ns6();
                            ns6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, ns6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            gi6 gi6Var = new gi6();
                            gi6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, gi6Var);
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
