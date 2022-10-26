package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoHttpResMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoRequestMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVertical.ClassInfo;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.SubClassItem;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class iz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public e b;
    public boolean c;
    public boolean d;
    public boolean e;
    public List f;
    public List g;
    public int h;
    public List i;
    public boolean j;
    public DataRes.Builder k;
    public qb l;

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i, boolean z, boolean z2);

        void b(int i, String str, boolean z);
    }

    /* loaded from: classes4.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(iz6 iz6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = iz6Var;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            int i;
            ClassInfo classInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.c = false;
                if (responsedMessage == null) {
                    this.a.e = false;
                    if (this.a.b != null) {
                        this.a.b.b(-1, "", this.a.d);
                        return;
                    }
                    return;
                }
                DataRes dataRes = null;
                if (responsedMessage instanceof GameVideoSocketResMessage) {
                    dataRes = ((GameVideoSocketResMessage) responsedMessage).mResultData;
                } else if (responsedMessage instanceof GameVideoHttpResMessage) {
                    dataRes = ((GameVideoHttpResMessage) responsedMessage).mResultData;
                }
                if (dataRes != null && (classInfo = dataRes.class_info) != null && !ListUtils.isEmpty(classInfo.sub_class_list)) {
                    this.a.k(dataRes.class_info.sub_class_list);
                    iz6 iz6Var = this.a;
                    boolean z = true;
                    if (dataRes.need_rechoose.intValue() != 1) {
                        z = false;
                    }
                    iz6Var.j = z;
                }
                if (dataRes != null && ListUtils.getCount(dataRes.thread_list) > 0) {
                    i = ListUtils.getCount(dataRes.thread_list);
                    this.a.n(dataRes);
                    if (!ListUtils.isEmpty(dataRes.thread_list)) {
                        this.a.z(dataRes);
                    }
                } else {
                    i = 0;
                }
                if (this.a.b != null) {
                    if (responsedMessage.getError() != 0) {
                        this.a.b.b(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.d);
                    } else {
                        this.a.b.a(i, this.a.d, false);
                    }
                }
                this.a.e = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ii5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz6 a;

        public b(iz6 iz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ii5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ou4.f();
                kf e = ou4.e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (e != null && (bArr = (byte[]) e.get(String.valueOf(this.a.h))) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e2) {
                        BdLog.e(e2);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements oh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz6 a;

        public c(iz6 iz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oh5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) && dataRes != null) {
                this.a.k = new DataRes.Builder(dataRes);
                int count = ListUtils.getCount(dataRes.thread_list);
                if (count > 0) {
                    this.a.n(dataRes);
                    this.a.k(dataRes.class_info.sub_class_list);
                    if (this.a.b != null) {
                        this.a.b.a(count, false, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ii5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ iz6 b;

        public d(iz6 iz6Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz6Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iz6Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.ii5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                ou4.f();
                try {
                    ou4.e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(this.b.h), builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    public iz6(TbPageContext tbPageContext, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GAME_VIDEO, 309646);
        this.a = tbPageContext;
        this.b = eVar;
        this.f = new LinkedList();
        this.g = new LinkedList();
        this.i = new LinkedList();
    }

    public final void A(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
            mi5.b(new d(this, builder), null);
        }
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) {
            s(dataRes.thread_list, !this.d);
            List y = y();
            this.f = y;
            hz6.b(dataRes, y);
        }
    }

    public final void k(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.i == null) {
            this.i = new LinkedList();
        }
        this.i.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            gz6 gz6Var = new gz6();
            gz6Var.a((SubClassItem) it.next());
            this.i.add(gz6Var);
        }
    }

    public List l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public List m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            mi5.b(new b(this), new c(this));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.e = true;
            this.f.clear();
            this.g.clear();
        }
    }

    public void q(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || this.c) {
            return;
        }
        this.h = i;
        this.c = true;
        this.d = false;
        if (this.e) {
            p();
            this.e = false;
        }
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i;
        if (!BdNetTypeUtil.isWifiNet()) {
            if (BdNetTypeUtil.is4GNet()) {
                i2 = 4;
            } else if (BdNetTypeUtil.is3GNet()) {
                i2 = 3;
            } else if (BdNetTypeUtil.is2GNet()) {
                i2 = 2;
            }
            gameVideoRequestMessage.new_net_type = i2;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.a.sendMessage(gameVideoRequestMessage);
        }
        i2 = 1;
        gameVideoRequestMessage.new_net_type = i2;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || this.c) {
            return;
        }
        this.h = i;
        int i2 = 1;
        this.c = true;
        this.d = true;
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i;
        if (!BdNetTypeUtil.isWifiNet()) {
            if (BdNetTypeUtil.is4GNet()) {
                i2 = 4;
            } else if (BdNetTypeUtil.is3GNet()) {
                i2 = 3;
            } else if (BdNetTypeUtil.is2GNet()) {
                i2 = 2;
            }
        }
        gameVideoRequestMessage.new_net_type = i2;
        gameVideoRequestMessage.load_type = 2;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(gameVideoRequestMessage);
    }

    public void v(String str) {
        DataRes.Builder builder;
        Long l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && (builder = this.k) != null && !ListUtils.isEmpty(builder.thread_list)) {
            long g = eh.g(str, 0L);
            for (int i = 0; i < this.k.thread_list.size(); i++) {
                ThreadInfo threadInfo = (ThreadInfo) this.k.thread_list.get(i);
                if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g) {
                    this.k.thread_list.remove(i);
                    A(this.k);
                    return;
                }
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || ListUtils.isEmpty(this.f)) {
            return;
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            eo eoVar = (eo) it.next();
            if (eoVar instanceof w26) {
                w26 w26Var = (w26) eoVar;
                if (w26Var.getThreadData() != null && w26Var.getThreadData().getTid() != null && w26Var.getThreadData().getTid().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public final void z(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dataRes) == null) {
            DataRes.Builder builder = new DataRes.Builder();
            builder.need_rechoose = dataRes.need_rechoose;
            builder.class_info = dataRes.class_info;
            builder.thread_personalized = dataRes.thread_personalized;
            if (ListUtils.getCount(this.g) >= 12) {
                if (this.d) {
                    List list = this.g;
                    builder.thread_list = list.subList(list.size() - 12, this.g.size());
                } else {
                    builder.thread_list = this.g.subList(0, 12);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.g);
                builder.thread_list = arrayList;
            }
            this.k = builder;
            A(builder);
        }
    }

    public final void s(List list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048585, this, list, z) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.g);
            this.g.clear();
            this.g.addAll(linkedList);
            return;
        }
        this.g.addAll(list);
    }

    public final List y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.g)) {
                return linkedList;
            }
            int i = 0;
            for (ThreadInfo threadInfo : this.g) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                if (f36.R(threadData)) {
                    e36 e36Var = new e36();
                    e36Var.a = threadData;
                    e36Var.g = threadData.getTid();
                    e36Var.position = i;
                    e36Var.m = true;
                    linkedList.add(e36Var);
                    f36 f36Var = new f36(threadData);
                    f36Var.g = threadData.getTid();
                    f36Var.position = i;
                    f36Var.s = true;
                    linkedList.add(f36Var);
                    if (threadInfo.top_agree_post != null) {
                        e36 e36Var2 = new e36();
                        e36Var2.a = threadData;
                        e36Var2.g = threadData.getTid();
                        e36Var2.position = i;
                        e36Var2.y = true;
                        linkedList.add(e36Var2);
                    }
                    e36 e36Var3 = new e36();
                    e36Var3.a = threadData;
                    e36Var3.g = threadData.getTid();
                    e36Var3.position = i;
                    e36Var3.A = true;
                    linkedList.add(e36Var3);
                    i++;
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }
}
