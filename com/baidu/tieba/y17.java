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
public class y17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Cdo> a;
    public List<ThreadData> b;
    public Object[] c;

    public y17() {
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
                        nk6 nk6Var = new nk6();
                        nk6Var.c(threadData);
                        this.a.add(nk6Var);
                    } else {
                        ok6 ok6Var = new ok6();
                        ok6Var.c(threadData);
                        this.a.add(ok6Var);
                    }
                }
            }
        }
    }

    public void c(int i, w17 w17Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, w17Var) != null) || w17Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[w17Var.b + 10];
        }
        if (!ListUtils.isEmpty(w17Var.c)) {
            ArrayList arrayList = new ArrayList(w17Var.c.size());
            for (ThreadData threadData : w17Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(w17Var);
        }
        this.a.clear();
        b();
        g();
        f(w17Var);
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

    public final void f(w17 w17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, w17Var) == null) {
            tk6 tk6Var = new tk6();
            tk6Var.f(w17Var.d);
            this.a.add(0, tk6Var);
        }
    }

    public final void e(w17 w17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, w17Var) == null) {
            if (!ListUtils.isEmpty(w17Var.e)) {
                for (FeatureCardHot featureCardHot : w17Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(w17Var.f)) {
                for (FeatureCardTopic featureCardTopic : w17Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(w17Var.g)) {
                for (x17 x17Var : w17Var.g) {
                    if (x17Var != null && x17Var.a()) {
                        d(x17Var.c.intValue());
                        this.c[x17Var.c.intValue()] = x17Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(w17Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : w17Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(w17Var.i)) {
                for (FeatureCardGod featureCardGod : w17Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(w17Var.j)) {
                for (FeatureCardGame featureCardGame : w17Var.j) {
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
                            rk6 rk6Var = new rk6();
                            rk6Var.f((FeatureCardHot) obj);
                            this.a.add(i2, rk6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            uk6 uk6Var = new uk6();
                            uk6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, uk6Var);
                        } else if (obj instanceof x17) {
                            qk6 qk6Var = new qk6();
                            qk6Var.f((x17) obj);
                            this.a.add(i2, qk6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            pk6 pk6Var = new pk6();
                            pk6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, pk6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            mv6 mv6Var = new mv6();
                            mv6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, mv6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            sk6 sk6Var = new sk6();
                            sk6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, sk6Var);
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
