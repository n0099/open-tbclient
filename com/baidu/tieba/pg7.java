package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.message.ChatGroupListResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class pg7 extends ng7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b f;
    public final HttpMessageListener g;

    /* loaded from: classes5.dex */
    public interface b {
        void a(List list, int i);
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pg7 pg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if ((httpResponsedMessage instanceof ChatGroupListResponseMessage) && httpResponsedMessage.getCmd() == 1003552) {
                    List data = ((ChatGroupListResponseMessage) httpResponsedMessage).getData();
                    this.a.p(data);
                    if (this.a.f != null) {
                        this.a.f.a(data, httpResponsedMessage.getError());
                    }
                } else if (this.a.f != null) {
                    this.a.f.a(null, -1);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pg7(@NonNull Context context, b bVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST);
        this.f = bVar;
        q();
        MessageManager.getInstance().registerListener(this.g);
    }

    @Override // com.baidu.tieba.ng7
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.h();
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public final void p(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        List<ChatRoomInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof ChatGroupInfo) {
                List<ChatRoomInfo> roomInfoList = ((ChatGroupInfo) obj).getRoomInfoList();
                if (!ListUtils.isEmpty(roomInfoList)) {
                    arrayList.addAll(roomInfoList);
                }
            }
        }
        g(arrayList);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST, TbConfig.SERVER_ADDRESS + TbConfig.GET_CHAT_GROUP_ROOM_LIST);
            tbHttpMessageTask.setResponsedClass(ChatGroupListResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void r(@Nullable List<Long> list, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, str, str2) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST);
            List<ChatRoomInfo> e = e(str, str2);
            if (!ListUtils.isEmpty(list)) {
                String l = l(e, list);
                if (!TextUtils.isEmpty(l)) {
                    httpMessage.addParam("chatroom_new_msg", l);
                }
            }
            httpMessage.addParam("fid", str2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
