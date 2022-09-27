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
public class yn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Cdo> a;
    public List<ThreadData> b;
    public Object[] c;

    public yn6() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.b.size(); i++) {
                ThreadData threadData = this.b.get(i);
                if (threadData != null) {
                    if (i % 4 == 0) {
                        z66 z66Var = new z66();
                        z66Var.c(threadData);
                        this.a.add(z66Var);
                    } else {
                        a76 a76Var = new a76();
                        a76Var.c(threadData);
                        this.a.add(a76Var);
                    }
                }
            }
        }
    }

    public void c(int i, wn6 wn6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wn6Var) == null) || wn6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[wn6Var.b + 10];
        }
        if (!ListUtils.isEmpty(wn6Var.c)) {
            ArrayList arrayList = new ArrayList(wn6Var.c.size());
            for (ThreadData threadData : wn6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(wn6Var);
        }
        this.a.clear();
        b();
        g();
        f(wn6Var);
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

    public final void e(wn6 wn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wn6Var) == null) {
            if (!ListUtils.isEmpty(wn6Var.e)) {
                for (FeatureCardHot featureCardHot : wn6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(wn6Var.f)) {
                for (FeatureCardTopic featureCardTopic : wn6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(wn6Var.g)) {
                for (xn6 xn6Var : wn6Var.g) {
                    if (xn6Var != null && xn6Var.a()) {
                        d(xn6Var.c.intValue());
                        this.c[xn6Var.c.intValue()] = xn6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(wn6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : wn6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(wn6Var.i)) {
                for (FeatureCardGod featureCardGod : wn6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(wn6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : wn6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(wn6 wn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wn6Var) == null) {
            f76 f76Var = new f76();
            f76Var.f(wn6Var.d);
            this.a.add(0, f76Var);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.c) == null || objArr.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            Object[] objArr2 = this.c;
            if (i >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i];
            if (obj != null) {
                int i2 = i - 1;
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 >= this.a.size()) {
                    i2 = this.a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    d76 d76Var = new d76();
                    d76Var.f((FeatureCardHot) obj);
                    this.a.add(i2, d76Var);
                } else if (obj instanceof FeatureCardTopic) {
                    g76 g76Var = new g76();
                    g76Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, g76Var);
                } else if (obj instanceof xn6) {
                    c76 c76Var = new c76();
                    c76Var.f((xn6) obj);
                    this.a.add(i2, c76Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    b76 b76Var = new b76();
                    b76Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, b76Var);
                } else if (obj instanceof FeatureCardGod) {
                    qh6 qh6Var = new qh6();
                    qh6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, qh6Var);
                } else if (obj instanceof FeatureCardGame) {
                    e76 e76Var = new e76();
                    e76Var.b((FeatureCardGame) obj);
                    this.a.add(i2, e76Var);
                }
            }
            i++;
        }
    }
}
