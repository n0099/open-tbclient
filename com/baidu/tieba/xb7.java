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
public class xb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<hn> a;
    public List<ThreadData> b;
    public Object[] c;

    public xb7() {
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

    public List<hn> a() {
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
                        on6 on6Var = new on6();
                        on6Var.c(threadData);
                        this.a.add(on6Var);
                    } else {
                        pn6 pn6Var = new pn6();
                        pn6Var.c(threadData);
                        this.a.add(pn6Var);
                    }
                }
            }
        }
    }

    public void c(int i, vb7 vb7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, vb7Var) != null) || vb7Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[vb7Var.b + 10];
        }
        if (!ListUtils.isEmpty(vb7Var.c)) {
            ArrayList arrayList = new ArrayList(vb7Var.c.size());
            for (ThreadData threadData : vb7Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(vb7Var);
        }
        this.a.clear();
        b();
        g();
        f(vb7Var);
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

    public final void f(vb7 vb7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vb7Var) == null) {
            un6 un6Var = new un6();
            un6Var.d(vb7Var.d);
            this.a.add(0, un6Var);
        }
    }

    public final void e(vb7 vb7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vb7Var) == null) {
            if (!ListUtils.isEmpty(vb7Var.e)) {
                for (FeatureCardHot featureCardHot : vb7Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(vb7Var.f)) {
                for (FeatureCardTopic featureCardTopic : vb7Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(vb7Var.g)) {
                for (wb7 wb7Var : vb7Var.g) {
                    if (wb7Var != null && wb7Var.a()) {
                        d(wb7Var.c.intValue());
                        this.c[wb7Var.c.intValue()] = wb7Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(vb7Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : vb7Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(vb7Var.i)) {
                for (FeatureCardGod featureCardGod : vb7Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (!ListUtils.isEmpty(vb7Var.j)) {
                for (FeatureCardGame featureCardGame : vb7Var.j) {
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
                            sn6 sn6Var = new sn6();
                            sn6Var.d((FeatureCardHot) obj);
                            this.a.add(i2, sn6Var);
                        } else if (obj instanceof FeatureCardTopic) {
                            vn6 vn6Var = new vn6();
                            vn6Var.b((FeatureCardTopic) obj);
                            this.a.add(i2, vn6Var);
                        } else if (obj instanceof wb7) {
                            rn6 rn6Var = new rn6();
                            rn6Var.d((wb7) obj);
                            this.a.add(i2, rn6Var);
                        } else if (obj instanceof FeatureCardCompetition) {
                            qn6 qn6Var = new qn6();
                            qn6Var.b((FeatureCardCompetition) obj);
                            this.a.add(i2, qn6Var);
                        } else if (obj instanceof FeatureCardGod) {
                            l57 l57Var = new l57();
                            l57Var.e((FeatureCardGod) obj);
                            this.a.add(i2, l57Var);
                        } else if (obj instanceof FeatureCardGame) {
                            tn6 tn6Var = new tn6();
                            tn6Var.b((FeatureCardGame) obj);
                            this.a.add(i2, tn6Var);
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
