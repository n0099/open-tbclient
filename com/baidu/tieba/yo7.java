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
/* loaded from: classes8.dex */
public class yo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yn> a;
    public List<ThreadData> b;
    public Object[] c;

    public yo7() {
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

    public List<yn> a() {
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
                        xx6 xx6Var = new xx6();
                        xx6Var.c(threadData);
                        this.a.add(xx6Var);
                    } else {
                        yx6 yx6Var = new yx6();
                        yx6Var.c(threadData);
                        this.a.add(yx6Var);
                    }
                }
            }
        }
    }

    public void c(int i, wo7 wo7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wo7Var) != null) || wo7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[wo7Var.b + 10];
        }
        if (!ListUtils.isEmpty(wo7Var.c)) {
            ArrayList arrayList = new ArrayList(wo7Var.c.size());
            for (ThreadData threadData : wo7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(wo7Var);
        }
        this.a.clear();
        b();
        g();
        f(wo7Var);
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

    public final void f(wo7 wo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wo7Var) == null) {
            dy6 dy6Var = new dy6();
            dy6Var.d(wo7Var.d);
            this.a.add(0, dy6Var);
        }
    }

    public final void e(wo7 wo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wo7Var) == null) {
            if (!ListUtils.isEmpty(wo7Var.e)) {
                for (FeatureCardHot featureCardHot : wo7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(wo7Var.f)) {
                for (FeatureCardTopic featureCardTopic : wo7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(wo7Var.g)) {
                for (xo7 xo7Var : wo7Var.g) {
                    if (xo7Var != null && xo7Var.a()) {
                        d(xo7Var.c.intValue());
                        this.c[xo7Var.c.intValue()] = xo7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(wo7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : wo7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(wo7Var.i)) {
                for (FeatureCardGod featureCardGod : wo7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(wo7Var.j)) {
                for (FeatureCardGame featureCardGame : wo7Var.j) {
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
                            by6 by6Var = new by6();
                            by6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, by6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            ey6 ey6Var = new ey6();
                            ey6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, ey6Var);
                        } else if (obj instanceof xo7) {
                            ay6 ay6Var = new ay6();
                            ay6Var.d((xo7) obj);
                            this.a.add(i2, ay6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            zx6 zx6Var = new zx6();
                            zx6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, zx6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            li7 li7Var = new li7();
                            li7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, li7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            cy6 cy6Var = new cy6();
                            cy6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, cy6Var);
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
