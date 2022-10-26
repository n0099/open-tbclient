package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskHTTPResMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ym4 implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue a;
    public BdUniqueId b;
    public mp4 c;
    public wm4 d;
    public boolean e;
    public final Handler f;
    public qb g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ym4 ym4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym4Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = ym4Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.ym4$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            vm4 vm4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.e = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.a.r(responsedMessage);
                    return;
                }
                e eVar = null;
                eVar = null;
                if (responsedMessage instanceof CompleteTaskHTTPResMsg) {
                    vm4Var = ((CompleteTaskHTTPResMsg) responsedMessage).getData();
                } else if (responsedMessage instanceof CompleteTaskSocketResMsg) {
                    vm4Var = ((CompleteTaskSocketResMsg) responsedMessage).getData();
                } else {
                    vm4Var = null;
                }
                if (vm4Var == null) {
                    return;
                }
                if (this.a.d == null) {
                    this.a.d = new wm4();
                }
                this.a.d.d(vm4Var);
                this.a.d.e();
                Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    rl4 rl4Var = fVar.a;
                    if (vm4Var != null && vm4Var.x == 1) {
                        rl4Var.z = true;
                    }
                    this.a.t(rl4Var);
                    eVar = fVar;
                } else if (obj instanceof e) {
                    e eVar2 = (e) obj;
                    this.a.s(eVar2.a);
                    eVar = eVar2;
                } else if (obj instanceof g) {
                    dm4.b().g();
                }
                if (eVar != null) {
                    this.a.a.remove(eVar);
                }
                this.a.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ym4 ym4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym4Var, Integer.valueOf(i)};
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
            this.a = ym4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d)) {
                d dVar = (d) customResponsedMessage.getData();
                this.a.k(dVar.a);
                this.a.l(dVar.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List a;
        public List b;
        public List c;

        public d() {
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

        public void a(rl4 rl4Var) {
            List list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, rl4Var) == null) && (list = this.b) != null) {
                list.add(rl4Var);
            }
        }

        public void b(xl4 xl4Var) {
            List list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xl4Var) == null) && (list = this.a) != null) {
                list.add(xl4Var);
            }
        }

        public void c(rl4 rl4Var) {
            List list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rl4Var) == null) && (list = this.c) != null) {
                list.add(rl4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
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
        }
    }

    /* loaded from: classes6.dex */
    public class f extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public rl4 a;

        public f(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl4Var;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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
    }

    public ym4(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.e = false;
        this.f = new Handler(Looper.getMainLooper(), this);
        this.g = new a(this, CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
        this.h = new b(this, 2921379);
        this.b = bdUniqueId;
        p();
        q();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message.what == 1) {
                x();
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void o(rl4 rl4Var) {
        mp4 mp4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, rl4Var) == null) && rl4Var != null && (mp4Var = this.c) != null) {
            mp4Var.a(rl4Var);
        }
    }

    public final void t(rl4 rl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, rl4Var) != null) || rl4Var == null) {
            return;
        }
        o(rl4Var);
    }

    public void w(mp4 mp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mp4Var) == null) {
            this.c = mp4Var;
        }
    }

    public final void k(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        LinkedList<rl4> linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            xl4 xl4Var = (xl4) it.next();
            if (xl4Var != null && xl4Var.c() != null) {
                rl4 c2 = xl4Var.c();
                if (c2.N()) {
                    c2.f0(c2.F());
                    o(c2);
                } else if (c2.d() != 0 && c2.q() != 0) {
                    linkedList.add(c2);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (rl4 rl4Var : linkedList) {
            if (rl4Var != null) {
                HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(rl4Var.d()));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    hashMap.put(Integer.valueOf(rl4Var.d()), hashSet);
                }
                hashSet.add(Integer.valueOf(rl4Var.q()));
            }
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            Iterator it2 = ((HashSet) entry.getValue()).iterator();
            while (it2.hasNext()) {
                sb.append(it2.next() + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            try {
                jSONObject.put(String.valueOf(entry.getKey()), sb);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        for (rl4 rl4Var2 : linkedList) {
            if (rl4Var2 != null) {
                xm4.a(jSONObject2, rl4Var2.d(), rl4Var2.q(), rl4Var2.E());
            }
        }
        e eVar = new e(jSONObject.toString());
        eVar.b = jSONObject2.toString();
        this.a.add(eVar);
        u();
    }

    public final void l(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rl4 rl4Var = (rl4) it.next();
            if (rl4Var.N()) {
                rl4Var.f0(rl4Var.F());
                o(rl4Var);
            } else {
                this.a.add(new f(rl4Var));
            }
        }
        u();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.baidu.tieba.ym4$f */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(ResponsedMessage responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, responsedMessage) != null) || responsedMessage == null) {
            return;
        }
        e eVar = null;
        Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
        if (obj instanceof f) {
            f fVar = (f) obj;
            o(fVar.a);
            eVar = fVar;
        } else if (obj instanceof e) {
            eVar = (e) obj;
        }
        if (eVar != null) {
            this.a.remove(eVar);
        }
        u();
    }

    public void m() {
        wm4 wm4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (wm4Var = this.d) != null) {
            wm4Var.a();
        }
    }

    public BdUniqueId n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f.sendMessage(obtain);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            zm8.h(309627, CompleteTaskSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, zm8.a(TbConfig.COMPLETE_TASK_URL, 309627));
            tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g.setTag(n());
            this.h.setTag(n());
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public final void s(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || str == null) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject == null) {
            return;
        }
        LinkedList<rl4> linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string = jSONObject.getString(next);
                if (string != null && (split = string.split(",")) != null) {
                    for (String str2 : split) {
                        rl4 rl4Var = new rl4();
                        rl4Var.T(eh.e(next, 0));
                        rl4Var.c0(eh.e(str2, 0));
                        if (rl4Var.d() != 0 && rl4Var.q() != 0) {
                            linkedList.add(rl4Var);
                        }
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        for (rl4 rl4Var2 : linkedList) {
            o(rl4Var2);
        }
    }

    public void v(String str, int i, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(1048588, this, str, i, str2, obj) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        this.e = true;
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i);
        completeTaskReqMsg.setTag(this.b);
        completeTaskReqMsg.completeId = str;
        completeTaskReqMsg.setToken(str2);
        completeTaskReqMsg.extra = obj;
        completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }

    public final boolean x() {
        InterceptResult invokeV;
        c cVar;
        e eVar;
        String str;
        rl4 rl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                if (this.e || (cVar = (c) this.a.peek()) == null) {
                    return false;
                }
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    if (fVar == null || (rl4Var = fVar.a) == null) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(String.valueOf(rl4Var.d()), String.valueOf(rl4Var.q()));
                    v(jSONObject.toString(), 1, rl4Var.E(), fVar);
                    return true;
                } else if (!(cVar instanceof e) || (eVar = (e) cVar) == null || (str = eVar.a) == null) {
                    return false;
                } else {
                    v(str, 1, eVar.b, eVar);
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            return invokeV.booleanValue;
        }
        return false;
    }
}
