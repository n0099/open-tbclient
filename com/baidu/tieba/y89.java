package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import tbclient.PbPage.SimilarContent;
import tbclient.SimpleForum;
/* loaded from: classes8.dex */
public final class y89 extends gp6 {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId W0;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimilarContent R0;
    public int S0;
    public final List<String> T0;
    public final String U0;
    public final ThreadData V0;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof y89) && Intrinsics.areEqual(this.R0, ((y89) obj).R0);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.R0.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "PbFirstFloorSimilarData(similarContent=" + this.R0 + ')';
        }
        return (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284175, "Lcom/baidu/tieba/y89;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284175, "Lcom/baidu/tieba/y89;");
                return;
            }
        }
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        W0 = gen;
    }

    public final List<String> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.T0;
        }
        return (List) invokeV.objValue;
    }

    public final String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.U0;
        }
        return (String) invokeV.objValue;
    }

    public final ThreadData d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.V0;
        }
        return (ThreadData) invokeV.objValue;
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.S0 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.S0 == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yo6, com.baidu.tieba.l15
    public k35 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new k35();
        }
        return (k35) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gp6, com.baidu.tieba.yo6, com.baidu.tieba.l15
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.V0;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gp6, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return W0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public y89(SimilarContent similarContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {similarContent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(similarContent, "similarContent");
        this.R0 = similarContent;
        this.T0 = new ArrayList();
        if (ListUtils.isNotEmpty(this.R0.similar_label_list)) {
            ((ArrayList) this.T0).addAll(this.R0.similar_label_list);
        }
        ThreadData threadData = new ThreadData();
        this.V0 = threadData;
        threadData.parserProtobuf(this.R0.similar_thread);
        SimpleForum simpleForum = this.R0.similar_forum;
        if (simpleForum != null) {
            ThreadData threadData2 = this.V0;
            Long l = simpleForum.id;
            Intrinsics.checkNotNullExpressionValue(l, "similarContent.similar_forum.id");
            threadData2.setFid(l.longValue());
            n45 n45Var = new n45();
            n45Var.l(this.R0.similar_forum);
            this.V0.setForumData(n45Var);
        }
        this.V0.setSimilarPageType(true);
        String str = this.R0.similar_url;
        Intrinsics.checkNotNullExpressionValue(str, "similarContent.similar_url");
        this.U0 = str;
        Integer num = this.R0.user_type;
        Intrinsics.checkNotNullExpressionValue(num, "similarContent.user_type");
        this.S0 = num.intValue();
    }
}
