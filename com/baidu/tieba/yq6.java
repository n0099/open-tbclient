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
public class yq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xn> a;
    public List<ThreadData> b;
    public Object[] c;

    public yq6() {
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

    public List<xn> a() {
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
                        y96 y96Var = new y96();
                        y96Var.c(threadData);
                        this.a.add(y96Var);
                    } else {
                        z96 z96Var = new z96();
                        z96Var.c(threadData);
                        this.a.add(z96Var);
                    }
                }
            }
        }
    }

    public void c(int i, wq6 wq6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wq6Var) != null) || wq6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[wq6Var.b + 10];
        }
        if (!ListUtils.isEmpty(wq6Var.c)) {
            ArrayList arrayList = new ArrayList(wq6Var.c.size());
            for (ThreadData threadData : wq6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(wq6Var);
        }
        this.a.clear();
        b();
        g();
        f(wq6Var);
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

    public final void f(wq6 wq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wq6Var) == null) {
            ea6 ea6Var = new ea6();
            ea6Var.f(wq6Var.d);
            this.a.add(0, ea6Var);
        }
    }

    public final void e(wq6 wq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wq6Var) == null) {
            if (!ListUtils.isEmpty(wq6Var.e)) {
                for (FeatureCardHot featureCardHot : wq6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(wq6Var.f)) {
                for (FeatureCardTopic featureCardTopic : wq6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(wq6Var.g)) {
                for (xq6 xq6Var : wq6Var.g) {
                    if (xq6Var != null && xq6Var.a()) {
                        d(xq6Var.c.intValue());
                        this.c[xq6Var.c.intValue()] = xq6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(wq6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : wq6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(wq6Var.i)) {
                for (FeatureCardGod featureCardGod : wq6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(wq6Var.j)) {
                for (FeatureCardGame featureCardGame : wq6Var.j) {
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
                            ca6 ca6Var = new ca6();
                            ca6Var.f((FeatureCardHot) obj);
                            this.a.add(i2, ca6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            fa6 fa6Var = new fa6();
                            fa6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, fa6Var);
                        } else if (obj instanceof xq6) {
                            ba6 ba6Var = new ba6();
                            ba6Var.f((xq6) obj);
                            this.a.add(i2, ba6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            aa6 aa6Var = new aa6();
                            aa6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, aa6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            pk6 pk6Var = new pk6();
                            pk6Var.g((FeatureCardGod) obj);
                            this.a.add(i2, pk6Var);
                        } else if (obj instanceof FeatureCardGame) {
                            da6 da6Var = new da6();
                            da6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, da6Var);
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
