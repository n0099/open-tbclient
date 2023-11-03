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
/* loaded from: classes9.dex */
public class yw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<oi> a;
    public List<ThreadData> b;
    public Object[] c;

    public yw7() {
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

    public List<oi> a() {
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
                        yt6 yt6Var = new yt6();
                        yt6Var.c(threadData);
                        this.a.add(yt6Var);
                    } else {
                        zt6 zt6Var = new zt6();
                        zt6Var.c(threadData);
                        this.a.add(zt6Var);
                    }
                }
            }
        }
    }

    public void c(int i, ww7 ww7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ww7Var) != null) || ww7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[ww7Var.b + 10];
        }
        if (!ListUtils.isEmpty(ww7Var.c)) {
            ArrayList arrayList = new ArrayList(ww7Var.c.size());
            for (ThreadData threadData : ww7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(ww7Var);
        }
        this.a.clear();
        b();
        g();
        f(ww7Var);
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

    public final void f(ww7 ww7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ww7Var) == null) {
            eu6 eu6Var = new eu6();
            eu6Var.d(ww7Var.d);
            this.a.add(0, eu6Var);
        }
    }

    public final void e(ww7 ww7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ww7Var) == null) {
            if (!ListUtils.isEmpty(ww7Var.e)) {
                for (FeatureCardHot featureCardHot : ww7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(ww7Var.f)) {
                for (FeatureCardTopic featureCardTopic : ww7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(ww7Var.g)) {
                for (xw7 xw7Var : ww7Var.g) {
                    if (xw7Var != null && xw7Var.a()) {
                        d(xw7Var.c.intValue());
                        this.c[xw7Var.c.intValue()] = xw7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(ww7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : ww7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(ww7Var.i)) {
                for (FeatureCardGod featureCardGod : ww7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(ww7Var.j)) {
                for (FeatureCardGame featureCardGame : ww7Var.j) {
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
                            cu6 cu6Var = new cu6();
                            cu6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, cu6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            fu6 fu6Var = new fu6();
                            fu6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, fu6Var);
                        } else if (obj instanceof xw7) {
                            bu6 bu6Var = new bu6();
                            bu6Var.d((xw7) obj);
                            this.a.add(i2, bu6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            au6 au6Var = new au6();
                            au6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, au6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            cq7 cq7Var = new cq7();
                            cq7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, cq7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            du6 du6Var = new du6();
                            du6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, du6Var);
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
