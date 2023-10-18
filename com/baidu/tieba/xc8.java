package com.baidu.tieba;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.yf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class xc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public d b;
    public String c;
    public CustomMessageListener d;
    public Runnable e;
    public NetMessageListener f;

    /* loaded from: classes8.dex */
    public interface d {
        void a(List<zf8> list);

        void onReadCountLoad(LongSparseArray<ge8> longSparseArray);
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xc8 xc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc8Var, Integer.valueOf(i)};
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
            this.a = xc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001147) {
                this.a.g(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2012123) {
                SafeHandler.getInst().removeCallbacks(this.a.e);
                SafeHandler.getInst().postDelayed(this.a.e, 1000L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc8 a;

        public b(xc8 xc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xc8 xc8Var = this.a;
                xc8Var.f(xc8Var.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(xc8 xc8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc8Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc8Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        @RequiresApi(api = 16)
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            fe8 fe8Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            LongSparseArray<ge8> longSparseArray = null;
            if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                fe8Var = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
            } else {
                fe8Var = null;
            }
            if (fe8Var == null) {
                return;
            }
            List<ge8> b = fe8Var.b();
            if (b != null && b.size() > 0) {
                longSparseArray = new LongSparseArray<>(b.size());
                for (ge8 ge8Var : b) {
                    longSparseArray.put(ge8Var.b(), ge8Var);
                }
            }
            if (this.a.b != null && longSparseArray != null) {
                this.a.b.onReadCountLoad(longSparseArray);
            }
        }
    }

    public xc8(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, 0);
        this.e = new b(this);
        this.f = new c(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
        this.a = tbPageContext;
        tbPageContext.registerListener(2001147, this.d);
        tbPageContext.registerListener(2012123, this.d);
        tbPageContext.registerListener(this.f);
    }

    public final void h(List<zf8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list.size());
            for (zf8 zf8Var : list) {
                if (zf8Var.f()) {
                    arrayList.add(Long.valueOf(zf8Var.d().h));
                }
            }
            BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
            broadcastMajorHistoryRequestMessage.queryType = 2;
            broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
            this.a.sendMessage(broadcastMajorHistoryRequestMessage);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.c = 150;
            aVar.d = str;
            this.a.sendMessage(new LoadOfficialHistoryMessage(aVar));
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.e);
        }
    }

    public final void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            return;
        }
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
        if (loadHistoryResponsedMessage.getData() == null) {
            return;
        }
        List<ChatMessage> list = loadHistoryResponsedMessage.getData().b;
        ArrayList arrayList = new ArrayList();
        for (ChatMessage chatMessage : list) {
            List<yf8.a> b2 = yf8.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
            if (b2 != null && b2.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                for (int i = 0; i < b2.size(); i++) {
                    yf8.a aVar = b2.get(i);
                    zf8 a2 = zf8.a(chatMessage, aVar);
                    if (a2 != null && a2.d() != null && !StringUtils.isNull(a2.d().a)) {
                        if (i == 0 && !StringUtils.isNull(aVar.c)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        a2.h(z);
                        arrayList.add(a2);
                    }
                }
            }
        }
        h(arrayList);
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(arrayList);
        }
    }
}
