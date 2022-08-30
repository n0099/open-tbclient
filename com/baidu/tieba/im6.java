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
public class im6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<pn> a;
    public List<ThreadData> b;
    public Object[] c;

    public im6() {
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

    public List<pn> a() {
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
                        y46 y46Var = new y46();
                        y46Var.c(threadData);
                        this.a.add(y46Var);
                    } else {
                        z46 z46Var = new z46();
                        z46Var.c(threadData);
                        this.a.add(z46Var);
                    }
                }
            }
        }
    }

    public void c(int i, gm6 gm6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, gm6Var) == null) || gm6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[gm6Var.b + 10];
        }
        if (!ListUtils.isEmpty(gm6Var.c)) {
            ArrayList arrayList = new ArrayList(gm6Var.c.size());
            for (ThreadData threadData : gm6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(gm6Var);
        }
        this.a.clear();
        b();
        g();
        f(gm6Var);
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

    public final void e(gm6 gm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gm6Var) == null) {
            if (!ListUtils.isEmpty(gm6Var.e)) {
                for (FeatureCardHot featureCardHot : gm6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(gm6Var.f)) {
                for (FeatureCardTopic featureCardTopic : gm6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(gm6Var.g)) {
                for (hm6 hm6Var : gm6Var.g) {
                    if (hm6Var != null && hm6Var.a()) {
                        d(hm6Var.c.intValue());
                        this.c[hm6Var.c.intValue()] = hm6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(gm6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : gm6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(gm6Var.i)) {
                for (FeatureCardGod featureCardGod : gm6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(gm6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : gm6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(gm6 gm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gm6Var) == null) {
            e56 e56Var = new e56();
            e56Var.f(gm6Var.d);
            this.a.add(0, e56Var);
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
                    c56 c56Var = new c56();
                    c56Var.f((FeatureCardHot) obj);
                    this.a.add(i2, c56Var);
                } else if (obj instanceof FeatureCardTopic) {
                    f56 f56Var = new f56();
                    f56Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, f56Var);
                } else if (obj instanceof hm6) {
                    b56 b56Var = new b56();
                    b56Var.f((hm6) obj);
                    this.a.add(i2, b56Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    a56 a56Var = new a56();
                    a56Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, a56Var);
                } else if (obj instanceof FeatureCardGod) {
                    of6 of6Var = new of6();
                    of6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, of6Var);
                } else if (obj instanceof FeatureCardGame) {
                    d56 d56Var = new d56();
                    d56Var.b((FeatureCardGame) obj);
                    this.a.add(i2, d56Var);
                }
            }
            i++;
        }
    }
}
