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
/* loaded from: classes4.dex */
public class ln6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Cdo> a;
    public List<ThreadData> b;
    public Object[] c;

    public ln6() {
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
                        m66 m66Var = new m66();
                        m66Var.c(threadData);
                        this.a.add(m66Var);
                    } else {
                        n66 n66Var = new n66();
                        n66Var.c(threadData);
                        this.a.add(n66Var);
                    }
                }
            }
        }
    }

    public void c(int i, jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, jn6Var) == null) || jn6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[jn6Var.b + 10];
        }
        if (!ListUtils.isEmpty(jn6Var.c)) {
            ArrayList arrayList = new ArrayList(jn6Var.c.size());
            for (ThreadData threadData : jn6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(jn6Var);
        }
        this.a.clear();
        b();
        g();
        f(jn6Var);
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

    public final void e(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jn6Var) == null) {
            if (!ListUtils.isEmpty(jn6Var.e)) {
                for (FeatureCardHot featureCardHot : jn6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(jn6Var.f)) {
                for (FeatureCardTopic featureCardTopic : jn6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(jn6Var.g)) {
                for (kn6 kn6Var : jn6Var.g) {
                    if (kn6Var != null && kn6Var.a()) {
                        d(kn6Var.c.intValue());
                        this.c[kn6Var.c.intValue()] = kn6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(jn6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : jn6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(jn6Var.i)) {
                for (FeatureCardGod featureCardGod : jn6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(jn6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : jn6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jn6Var) == null) {
            s66 s66Var = new s66();
            s66Var.f(jn6Var.d);
            this.a.add(0, s66Var);
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
                    q66 q66Var = new q66();
                    q66Var.f((FeatureCardHot) obj);
                    this.a.add(i2, q66Var);
                } else if (obj instanceof FeatureCardTopic) {
                    t66 t66Var = new t66();
                    t66Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, t66Var);
                } else if (obj instanceof kn6) {
                    p66 p66Var = new p66();
                    p66Var.f((kn6) obj);
                    this.a.add(i2, p66Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    o66 o66Var = new o66();
                    o66Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, o66Var);
                } else if (obj instanceof FeatureCardGod) {
                    dh6 dh6Var = new dh6();
                    dh6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, dh6Var);
                } else if (obj instanceof FeatureCardGame) {
                    r66 r66Var = new r66();
                    r66Var.b((FeatureCardGame) obj);
                    this.a.add(i2, r66Var);
                }
            }
            i++;
        }
    }
}
