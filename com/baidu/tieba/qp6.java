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
public class qp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wn> a;
    public List<ThreadData> b;
    public Object[] c;

    public qp6() {
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
                        q86 q86Var = new q86();
                        q86Var.c(threadData);
                        this.a.add(q86Var);
                    } else {
                        r86 r86Var = new r86();
                        r86Var.c(threadData);
                        this.a.add(r86Var);
                    }
                }
            }
        }
    }

    public void c(int i, op6 op6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, op6Var) != null) || op6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[op6Var.b + 10];
        }
        if (!ListUtils.isEmpty(op6Var.c)) {
            ArrayList arrayList = new ArrayList(op6Var.c.size());
            for (ThreadData threadData : op6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(op6Var);
        }
        this.a.clear();
        b();
        g();
        f(op6Var);
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

    public final void f(op6 op6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, op6Var) == null) {
            w86 w86Var = new w86();
            w86Var.f(op6Var.d);
            this.a.add(0, w86Var);
        }
    }

    public final void e(op6 op6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, op6Var) == null) {
            if (!ListUtils.isEmpty(op6Var.e)) {
                for (FeatureCardHot featureCardHot : op6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(op6Var.f)) {
                for (FeatureCardTopic featureCardTopic : op6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(op6Var.g)) {
                for (pp6 pp6Var : op6Var.g) {
                    if (pp6Var != null && pp6Var.a()) {
                        d(pp6Var.c.intValue());
                        this.c[pp6Var.c.intValue()] = pp6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(op6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : op6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(op6Var.i)) {
                for (FeatureCardGod featureCardGod : op6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(op6Var.j)) {
                for (FeatureCardGame featureCardGame : op6Var.j) {
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
                            u86 u86Var = new u86();
                            u86Var.f((FeatureCardHot) obj);
                            this.a.add(i2, u86Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            x86 x86Var = new x86();
                            x86Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, x86Var);
                        } else if (obj instanceof pp6) {
                            t86 t86Var = new t86();
                            t86Var.f((pp6) obj);
                            this.a.add(i2, t86Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            s86 s86Var = new s86();
                            s86Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, s86Var);
                        } else if (obj instanceof FeatureCardGod) {
                            hj6 hj6Var = new hj6();
                            hj6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, hj6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            v86 v86Var = new v86();
                            v86Var.b((FeatureCardGame) obj);
                            this.a.add(i2, v86Var);
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
