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
public class vp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<bn> a;
    public List<ThreadData> b;
    public Object[] c;

    public vp7() {
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

    public List<bn> a() {
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
                        zx6 zx6Var = new zx6();
                        zx6Var.c(threadData);
                        this.a.add(zx6Var);
                    } else {
                        ay6 ay6Var = new ay6();
                        ay6Var.c(threadData);
                        this.a.add(ay6Var);
                    }
                }
            }
        }
    }

    public void c(int i, tp7 tp7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, tp7Var) != null) || tp7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[tp7Var.b + 10];
        }
        if (!ListUtils.isEmpty(tp7Var.c)) {
            ArrayList arrayList = new ArrayList(tp7Var.c.size());
            for (ThreadData threadData : tp7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(tp7Var);
        }
        this.a.clear();
        b();
        g();
        f(tp7Var);
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

    public final void f(tp7 tp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tp7Var) == null) {
            fy6 fy6Var = new fy6();
            fy6Var.d(tp7Var.d);
            this.a.add(0, fy6Var);
        }
    }

    public final void e(tp7 tp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tp7Var) == null) {
            if (!ListUtils.isEmpty(tp7Var.e)) {
                for (FeatureCardHot featureCardHot : tp7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(tp7Var.f)) {
                for (FeatureCardTopic featureCardTopic : tp7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(tp7Var.g)) {
                for (up7 up7Var : tp7Var.g) {
                    if (up7Var != null && up7Var.a()) {
                        d(up7Var.c.intValue());
                        this.c[up7Var.c.intValue()] = up7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(tp7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : tp7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(tp7Var.i)) {
                for (FeatureCardGod featureCardGod : tp7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(tp7Var.j)) {
                for (FeatureCardGame featureCardGame : tp7Var.j) {
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
                            dy6 dy6Var = new dy6();
                            dy6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, dy6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            gy6 gy6Var = new gy6();
                            gy6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, gy6Var);
                        } else if (obj instanceof up7) {
                            cy6 cy6Var = new cy6();
                            cy6Var.d((up7) obj);
                            this.a.add(i2, cy6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            by6 by6Var = new by6();
                            by6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, by6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            cj7 cj7Var = new cj7();
                            cj7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, cj7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            ey6 ey6Var = new ey6();
                            ey6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, ey6Var);
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
