package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
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
public final class xd9 extends sn6 {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId X0;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimilarContent S0;
    public int T0;
    public final List<String> U0;
    public final String V0;
    public final ThreadData W0;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof xd9) && Intrinsics.areEqual(this.S0, ((xd9) obj).S0);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.S0.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "PbFirstFloorSimilarData(similarContent=" + this.S0 + ')';
        }
        return (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948296668, "Lcom/baidu/tieba/xd9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948296668, "Lcom/baidu/tieba/xd9;");
                return;
            }
        }
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        X0 = gen;
    }

    public final List<String> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.U0;
        }
        return (List) invokeV.objValue;
    }

    public final String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.V0;
        }
        return (String) invokeV.objValue;
    }

    public final ThreadData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.W0;
        }
        return (ThreadData) invokeV.objValue;
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.T0 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.T0 == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kn6, com.baidu.tieba.q05
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new NegativeFeedBackData();
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sn6, com.baidu.tieba.kn6, com.baidu.tieba.q05
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.W0;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sn6, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.ym
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return X0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public xd9(SimilarContent similarContent) {
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
        this.S0 = similarContent;
        this.U0 = new ArrayList();
        if (ListUtils.isNotEmpty(this.S0.similar_label_list)) {
            ((ArrayList) this.U0).addAll(this.S0.similar_label_list);
        }
        ThreadData threadData = new ThreadData();
        this.W0 = threadData;
        threadData.parserProtobuf(this.S0.similar_thread);
        SimpleForum simpleForum = this.S0.similar_forum;
        if (simpleForum != null) {
            ThreadData threadData2 = this.W0;
            Long l = simpleForum.id;
            Intrinsics.checkNotNullExpressionValue(l, "similarContent.similar_forum.id");
            threadData2.setFid(l.longValue());
            s35 s35Var = new s35();
            s35Var.l(this.S0.similar_forum);
            this.W0.setForumData(s35Var);
        }
        this.W0.setSimilarPageType(true);
        String str = this.S0.similar_url;
        Intrinsics.checkNotNullExpressionValue(str, "similarContent.similar_url");
        this.V0 = str;
        Integer num = this.S0.user_type;
        Intrinsics.checkNotNullExpressionValue(num, "similarContent.user_type");
        this.T0 = num.intValue();
    }
}
