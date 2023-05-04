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
public class od7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<in> a;
    public List<ThreadData> b;
    public Object[] c;

    public od7() {
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

    public List<in> a() {
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
                        hp6 hp6Var = new hp6();
                        hp6Var.c(threadData);
                        this.a.add(hp6Var);
                    } else {
                        ip6 ip6Var = new ip6();
                        ip6Var.c(threadData);
                        this.a.add(ip6Var);
                    }
                }
            }
        }
    }

    public void c(int i, md7 md7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, md7Var) != null) || md7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[md7Var.b + 10];
        }
        if (!ListUtils.isEmpty(md7Var.c)) {
            ArrayList arrayList = new ArrayList(md7Var.c.size());
            for (ThreadData threadData : md7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(md7Var);
        }
        this.a.clear();
        b();
        g();
        f(md7Var);
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

    public final void f(md7 md7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, md7Var) == null) {
            np6 np6Var = new np6();
            np6Var.d(md7Var.d);
            this.a.add(0, np6Var);
        }
    }

    public final void e(md7 md7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, md7Var) == null) {
            if (!ListUtils.isEmpty(md7Var.e)) {
                for (FeatureCardHot featureCardHot : md7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(md7Var.f)) {
                for (FeatureCardTopic featureCardTopic : md7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(md7Var.g)) {
                for (nd7 nd7Var : md7Var.g) {
                    if (nd7Var != null && nd7Var.a()) {
                        d(nd7Var.c.intValue());
                        this.c[nd7Var.c.intValue()] = nd7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(md7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : md7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(md7Var.i)) {
                for (FeatureCardGod featureCardGod : md7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(md7Var.j)) {
                for (FeatureCardGame featureCardGame : md7Var.j) {
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
                            lp6 lp6Var = new lp6();
                            lp6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, lp6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            op6 op6Var = new op6();
                            op6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, op6Var);
                        } else if (obj instanceof nd7) {
                            kp6 kp6Var = new kp6();
                            kp6Var.d((nd7) obj);
                            this.a.add(i2, kp6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            jp6 jp6Var = new jp6();
                            jp6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, jp6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            c77 c77Var = new c77();
                            c77Var.e((FeatureCardGod) obj);
                            this.a.add(i2, c77Var);
                        } else if (obj instanceof FeatureCardGame) {
                            mp6 mp6Var = new mp6();
                            mp6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, mp6Var);
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
