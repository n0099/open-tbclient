package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.PkModule;
import tbclient.TopicModule;
/* loaded from: classes7.dex */
public class o78 extends kn6 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c0;
    public static final BdUniqueId d0;
    public transient /* synthetic */ FieldHolder $fh;
    public int R;
    public long S;

    /* renamed from: T  reason: collision with root package name */
    public String f1139T;
    public String U;
    public long V;
    public String W;
    public p78 X;
    public rba Y;
    public int Z;
    public String a0;
    public ThreadData b0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947985273, "Lcom/baidu/tieba/o78;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947985273, "Lcom/baidu/tieba/o78;");
                return;
            }
        }
        c0 = BdUniqueId.gen();
        d0 = BdUniqueId.gen();
    }

    public o78() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Z = 0;
    }

    @Override // com.baidu.tieba.kn6, com.baidu.tieba.q05
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NegativeFeedBackData negFeedBackData = super.getNegFeedBackData();
            if (negFeedBackData != null) {
                negFeedBackData.setTopicID(this.S);
            }
            return negFeedBackData;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn6, com.baidu.tieba.q05
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b0;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.ym
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.Z == 0) {
                return c0;
            }
            return d0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static boolean G(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) {
            if (threadData == null || threadData.getType() != ThreadData.TYPE_TOPIC) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void K(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            this.b0 = threadData;
        }
    }

    public void H(NewTopicList newTopicList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, newTopicList) != null) || newTopicList == null) {
            return;
        }
        this.S = newTopicList.topic_id.longValue();
        this.f1139T = newTopicList.topic_name;
        this.U = newTopicList.topic_desc;
        this.V = newTopicList.discuss_num.longValue();
        this.W = newTopicList.topic_image;
        PkModule pkModule = newTopicList.pk_module;
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            p78 p78Var = new p78();
            this.X = p78Var;
            p78Var.a = this.S;
            p78Var.f = 1;
            p78Var.b(newTopicList.pk_module);
        }
        if (newTopicList.top_agree_post != null) {
            rba rbaVar = new rba();
            this.Y = rbaVar;
            rbaVar.H0(newTopicList.top_agree_post);
        }
    }

    public void I(TopicModule topicModule) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topicModule) != null) || topicModule == null) {
            return;
        }
        this.S = topicModule.topic_id.longValue();
        this.f1139T = topicModule.topic_name;
        this.U = topicModule.topic_desc;
        this.W = topicModule.topic_image;
        this.a0 = topicModule.topic_avatar;
        tbclient.PkModule pkModule = topicModule.pk_module;
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            p78 p78Var = new p78();
            this.X = p78Var;
            p78Var.a = this.S;
            p78Var.f = 3;
            p78Var.c(topicModule.pk_module);
        }
    }
}
