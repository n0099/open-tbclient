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
/* loaded from: classes5.dex */
public class pc7 implements CustomMessageTask.CustomRunnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pc7() {
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
    public CustomResponsedMessage run(CustomMessage customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof RequestLocalHistoryMessage)) {
                ou4.f();
                kf d = ou4.d("tb.im_official_history");
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                byte[] bArr = (byte[]) d.get(currentAccount + "@" + ((String) ((RequestLocalHistoryMessage) customMessage).getData()));
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
                                ej.getDateStringMouth(date);
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
