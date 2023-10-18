package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.tracker.PvData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.hma;
import com.baidu.tieba.tracker.Tracker;
import com.baidu.tieba.tracker.core.data.EventParams;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class mq5 {
    public static /* synthetic */ Interceptable $ic;
    public static final mq5 a;
    public static final Map<String, PvData> b;
    public static final b c;
    public static final c d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends cma {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.cma
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new lq5().b();
                MessageManager.getInstance().registerListener(mq5.c);
                MessageManager.getInstance().registerListener(mq5.d);
            }
        }

        @Override // com.baidu.tieba.cma
        public void b(String ubcId, List<? extends IEventNode> events) {
            EventParams trackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ubcId, events) == null) {
                Intrinsics.checkNotNullParameter(ubcId, "ubcId");
                Intrinsics.checkNotNullParameter(events, "events");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (IEventNode iEventNode : events) {
                    IEventNode endNode = iEventNode.getEndNode();
                    if (endNode != null && (trackParams = endNode.getTrackParams()) != null) {
                        String valueOf = String.valueOf(trackParams.get("page"));
                        String valueOf2 = String.valueOf(trackParams.get("source"));
                        PvData pvData = (PvData) linkedHashMap.get(valueOf + valueOf2);
                        if (pvData == null) {
                            pvData = new PvData(valueOf, valueOf2, 0, 0);
                        }
                        if (Intrinsics.areEqual(trackParams.get("type"), hma.a.a.a())) {
                            pvData.setPv_lost(pvData.getPv_lost() + 1);
                        }
                        pvData.setPv(pvData.getPv() + 1);
                        linkedHashMap.put(valueOf + valueOf2, pvData);
                    }
                }
                mq5.a.i(linkedHashMap);
            }
        }

        @Override // com.baidu.tieba.cma
        public void c(String ubcId, IEventNode event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ubcId, event) == null) {
                Intrinsics.checkNotNullParameter(ubcId, "ubcId");
                Intrinsics.checkNotNullParameter(event, "event");
                IEventNode endNode = event.getEndNode();
                if (endNode != null) {
                    mq5 mq5Var = mq5.a;
                    mq5Var.h(mq5Var.g(event, endNode));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(CmdConfigHttp.CMD_HTTP_STATISTICS_REPORT);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                boolean z = false;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    z = true;
                }
                if (z) {
                    mq5.b.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(2001011);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if ((msg instanceof BackgroundSwitchMessage) && Intrinsics.areEqual(((BackgroundSwitchMessage) msg).getData(), Boolean.TRUE)) {
                    Tracker.i.a().k();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981336, "Lcom/baidu/tieba/mq5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981336, "Lcom/baidu/tieba/mq5;");
                return;
            }
        }
        a = new mq5();
        b = new LinkedHashMap();
        c = new b();
        d = new c();
    }

    public mq5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                Tracker a2 = Tracker.i.a();
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
                a2.n(inst);
                Tracker.i.c(new a());
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046 A[Catch: Exception -> 0x00a9, LOOP:0: B:13:0x0040->B:15:0x0046, LOOP_END, TryCatch #0 {Exception -> 0x00a9, blocks: (B:5:0x0009, B:7:0x0023, B:12:0x0035, B:13:0x0040, B:15:0x0046, B:16:0x005a, B:17:0x0062, B:19:0x0068, B:20:0x007c), top: B:29:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[Catch: Exception -> 0x00a9, LOOP:1: B:17:0x0062->B:19:0x0068, LOOP_END, TryCatch #0 {Exception -> 0x00a9, blocks: (B:5:0x0009, B:7:0x0023, B:12:0x0035, B:13:0x0040, B:15:0x0046, B:16:0x005a, B:17:0x0062, B:19:0x0068, B:20:0x007c), top: B:29:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject g(IEventNode iEventNode, IEventNode iEventNode2) {
        InterceptResult invokeLL;
        String str;
        Iterator<Object> it;
        Iterator<Object> it2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iEventNode, iEventNode2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (!Tracker.i.a().j().contains(jSONObject.optString("page", "unknown")) && !Tracker.i.a().h()) {
                str = "0";
                jSONObject.put("is_hit_white", str);
                it = iEventNode2.getTrackParams().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
                it2 = iEventNode.getTrackParams().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    jSONObject.put((String) entry2.getKey(), entry2.getValue());
                }
                jSONObject.put("start_time", String.valueOf(iEventNode.getTimeStamp()));
                jSONObject.put("end_time", String.valueOf(iEventNode2.getTimeStamp()));
                jSONObject.put("duration", String.valueOf(iEventNode2.getTimeStamp() - iEventNode.getTimeStamp()));
                return jSONObject;
            }
            str = "1";
            jSONObject.put("is_hit_white", str);
            it = iEventNode2.getTrackParams().iterator();
            while (it.hasNext()) {
            }
            it2 = iEventNode.getTrackParams().iterator();
            while (it2.hasNext()) {
            }
            jSONObject.put("start_time", String.valueOf(iEventNode.getTimeStamp()));
            jSONObject.put("end_time", String.valueOf(iEventNode2.getTimeStamp()));
            jSONObject.put("duration", String.valueOf(iEventNode2.getTimeStamp() - iEventNode.getTimeStamp()));
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('[' char), (r5v0 org.json.JSONObject), (']' char)] */
    public final void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_EXCEPTION_REPORT);
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(jSONObject);
            sb.append(']');
            httpMessage.addParam("log_data", sb.toString());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('[' char), (wrap: java.lang.Object : ?: CAST (java.lang.Object) (r5v3 java.lang.StringBuilder)), (']' char)] */
    public final void i(Map<String, PvData> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            for (Map.Entry<String, PvData> entry : map.entrySet()) {
                if (b.get(entry.getKey()) != null) {
                    entry.getValue().merge(b.get(entry.getKey()));
                } else {
                    b.put(entry.getKey(), entry.getValue());
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, PvData> entry2 : b.entrySet()) {
                if (sb.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    sb.append(",");
                }
                sb.append(DataExt.toJson(entry2.getValue()));
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_STATISTICS_REPORT);
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            sb2.append((Object) sb);
            sb2.append(']');
            httpMessage.addParam("monitor_data", sb2.toString());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
