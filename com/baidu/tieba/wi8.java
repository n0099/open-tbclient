package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.ChatGroupSource;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.immessagecenter.chatgroup.message.ChatGroupListResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class wi8 extends ui8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c m;
    public boolean n;
    public long o;
    public final BdUniqueId p;
    public final HttpMessageListener q;

    /* loaded from: classes8.dex */
    public interface c {
        void a(List list, int i);
    }

    @Override // com.baidu.tieba.ui8
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wi8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wi8 wi8Var, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wi8Var, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wi8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if ((httpResponsedMessage instanceof ChatGroupListResponseMessage) && httpResponsedMessage.getCmd() == 1003552) {
                    ChatGroupListResponseMessage chatGroupListResponseMessage = (ChatGroupListResponseMessage) httpResponsedMessage;
                    List data = chatGroupListResponseMessage.getData();
                    this.a.o = chatGroupListResponseMessage.getGroupId();
                    if (this.a.n) {
                        this.a.C(data);
                    }
                    if (this.a.m != null) {
                        this.a.m.a(data, httpResponsedMessage.getError());
                    }
                } else if (this.a.m != null) {
                    this.a.m.a(null, -1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends wy5<List<GroupChatRoomPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(wi8 wi8Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wi8Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wy5
        public List<GroupChatRoomPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return vd8.j().h(this.a, this.b);
            }
            return (List) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wi8(@NonNull Context context, c cVar) {
        this(context, cVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (c) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wi8(@NonNull Context context, c cVar, boolean z) {
        super(context, ChatGroupSource.GROUP_CHAT_LIST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ChatGroupSource) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = false;
        this.p = BdUniqueId.gen();
        this.q = new a(this, CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST, true);
        this.m = cVar;
        this.n = z;
        E();
        this.q.setTag(this.p);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void F(@NonNull String str, @NonNull final String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            final HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST);
            httpMessage.setTag(this.p);
            az5.b(new b(this, str, str2), new ay5() { // from class: com.baidu.tieba.ti8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ay5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        wi8.D(HttpMessage.this, str2, (List) obj);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void D(HttpMessage httpMessage, String str, List list) {
        if (list != null && !list.isEmpty()) {
            String d = ap8.d(list);
            if (!TextUtils.isEmpty(d)) {
                httpMessage.addParam("chatroom_new_msg", d);
            }
        }
        httpMessage.addParam("fid", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void C(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
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
        n(arrayList);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (messageManager.findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) == null) {
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST, TbConfig.SERVER_ADDRESS + TbConfig.GET_CHAT_GROUP_ROOM_LIST);
                tbHttpMessageTask.setResponsedClass(ChatGroupListResponseMessage.class);
                tbHttpMessageTask.setIsNeedDialog(true);
                messageManager.registerTask(tbHttpMessageTask);
            }
        }
    }

    @Override // com.baidu.tieba.ui8
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.ui8
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.o();
            this.m = null;
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }
}
