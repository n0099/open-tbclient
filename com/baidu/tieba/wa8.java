package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.OfficialFeedHeadResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class wa8 implements CustomMessageTask.CustomRunnable<OfficialFeedHeadResponsedMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public n88 b;

    public wa8() {
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
        this.a = 2001154;
        this.b = n88.w();
    }

    public final LoadHistoryResponsedMessage a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
            loadHistoryResponsedMessage.setError(-18);
            return loadHistoryResponsedMessage;
        }
        return (LoadHistoryResponsedMessage) invokeI.objValue;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<OfficialFeedHeadResponsedMessage.a> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customMessage)) == null) {
            if (this.b == null) {
                return a(this.a);
            }
            List<r88> x = n88.x();
            if (x != null && x.size() > 0) {
                HashMap hashMap = new HashMap(x.size());
                for (r88 r88Var : x) {
                    hashMap.put(r88Var.b(), r88Var);
                }
                LinkedList<ChatMessage> l = this.b.l(hashMap, 80);
                if (l == null) {
                    return a(this.a);
                }
                OfficialFeedHeadResponsedMessage.a aVar = new OfficialFeedHeadResponsedMessage.a();
                OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = new OfficialFeedHeadResponsedMessage(this.a);
                aVar.b = l;
                aVar.a = x;
                try {
                    officialFeedHeadResponsedMessage.decodeInBackGround(2001105, aVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return officialFeedHeadResponsedMessage;
            }
            return a(this.a);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
