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
public class rk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xn> a;
    public List<ThreadData> b;
    public Object[] c;

    public rk7() {
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
                        rv6 rv6Var = new rv6();
                        rv6Var.c(threadData);
                        this.a.add(rv6Var);
                    } else {
                        sv6 sv6Var = new sv6();
                        sv6Var.c(threadData);
                        this.a.add(sv6Var);
                    }
                }
            }
        }
    }

    public void c(int i, pk7 pk7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, pk7Var) != null) || pk7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[pk7Var.b + 10];
        }
        if (!ListUtils.isEmpty(pk7Var.c)) {
            ArrayList arrayList = new ArrayList(pk7Var.c.size());
            for (ThreadData threadData : pk7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(pk7Var);
        }
        this.a.clear();
        b();
        g();
        f(pk7Var);
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

    public final void f(pk7 pk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pk7Var) == null) {
            xv6 xv6Var = new xv6();
            xv6Var.d(pk7Var.d);
            this.a.add(0, xv6Var);
        }
    }

    public final void e(pk7 pk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pk7Var) == null) {
            if (!ListUtils.isEmpty(pk7Var.e)) {
                for (FeatureCardHot featureCardHot : pk7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(pk7Var.f)) {
                for (FeatureCardTopic featureCardTopic : pk7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(pk7Var.g)) {
                for (qk7 qk7Var : pk7Var.g) {
                    if (qk7Var != null && qk7Var.a()) {
                        d(qk7Var.c.intValue());
                        this.c[qk7Var.c.intValue()] = qk7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(pk7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : pk7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(pk7Var.i)) {
                for (FeatureCardGod featureCardGod : pk7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(pk7Var.j)) {
                for (FeatureCardGame featureCardGame : pk7Var.j) {
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
                            vv6 vv6Var = new vv6();
                            vv6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, vv6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            yv6 yv6Var = new yv6();
                            yv6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, yv6Var);
                        } else if (obj instanceof qk7) {
                            uv6 uv6Var = new uv6();
                            uv6Var.d((qk7) obj);
                            this.a.add(i2, uv6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            tv6 tv6Var = new tv6();
                            tv6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, tv6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            fe7 fe7Var = new fe7();
                            fe7Var.e((FeatureCardGod) obj);
                            this.a.add(i2, fe7Var);
                        } else if (obj instanceof FeatureCardGame) {
                            wv6 wv6Var = new wv6();
                            wv6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, wv6Var);
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
