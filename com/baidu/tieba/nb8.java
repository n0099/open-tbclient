package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.officialBar.RequestLocalHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseLocalHistoryMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes6.dex */
public class nb8 implements CustomMessageTask.CustomRunnable<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nb8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof RequestLocalHistoryMessage)) {
                c55.d();
                we<byte[]> b = c55.b("tb.im_official_history");
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                byte[] bArr = b.get(currentAccount + "@" + ((RequestLocalHistoryMessage) customMessage).getData());
                if (bArr == null) {
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                try {
                    QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHistoryMsgResIdl.class);
                    if (queryHistoryMsgResIdl.data.res != null) {
                        for (MsgInfo msgInfo : queryHistoryMsgResIdl.data.res) {
                            ResponseHistoryMessage.a aVar = new ResponseHistoryMessage.a();
                            if (msgInfo != null) {
                                Date date = new Date();
                                date.setTime(msgInfo.sendTime.longValue() * 1000);
                                vi.getDateStringMouth(date);
                                msgInfo.type.intValue();
                                String str = msgInfo.content;
                                msgInfo.id.intValue();
                                linkedList.add(aVar);
                            }
                        }
                    }
                    return new ResponseLocalHistoryMessage(linkedList);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
