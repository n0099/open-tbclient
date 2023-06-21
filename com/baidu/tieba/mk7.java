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
public class mk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wn> a;
    public List<ThreadData> b;
    public Object[] c;

    public mk7() {
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

    public List<wn> a() {
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
                        mv6 mv6Var = new mv6();
                        mv6Var.c(threadData);
                        this.a.add(mv6Var);
                    } else {
                        nv6 nv6Var = new nv6();
                        nv6Var.c(threadData);
                        this.a.add(nv6Var);
                    }
                }
            }
        }
    }

    public void c(int i, kk7 kk7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, kk7Var) != null) || kk7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[kk7Var.b + 10];
        }
        if (!ListUtils.isEmpty(kk7Var.c)) {
            ArrayList arrayList = new ArrayList(kk7Var.c.size());
            for (ThreadData threadData : kk7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(kk7Var);
        }
        this.a.clear();
        b();
        g();
        f(kk7Var);
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

    public final void f(kk7 kk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kk7Var) == null) {
            sv6 sv6Var = new sv6();
            sv6Var.d(kk7Var.d);
            this.a.add(0, sv6Var);
        }
    }

    public final void e(kk7 kk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kk7Var) == null) {
            if (!ListUtils.isEmpty(kk7Var.e)) {
                for (FeatureCardHot featureCardHot : kk7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(kk7Var.f)) {
                for (FeatureCardTopic featureCardTopic : kk7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(kk7Var.g)) {
                for (lk7 lk7Var : kk7Var.g) {
                    if (lk7Var != null && lk7Var.a()) {
                        d(lk7Var.c.intValue());
                        this.c[lk7Var.c.intValue()] = lk7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(kk7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : kk7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(kk7Var.i)) {
                for (FeatureCardGod featureCardGod : kk7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(kk7Var.j)) {
                for (FeatureCardGame featureCardGame : kk7Var.j) {
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
                            qv6 qv6Var = new qv6();
                            qv6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, qv6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            tv6 tv6Var = new tv6();
                            tv6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, tv6Var);
                        } else if (obj instanceof lk7) {
                            pv6 pv6Var = new pv6();
                            pv6Var.d((lk7) obj);
                            this.a.add(i2, pv6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            ov6 ov6Var = new ov6();
                            ov6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, ov6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            ae7 ae7Var = new ae7();
                            ae7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, ae7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            rv6 rv6Var = new rv6();
                            rv6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, rv6Var);
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
