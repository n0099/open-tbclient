package com.baidu.tieba;

import androidx.collection.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class k58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<cn> a;
    public final v68 b;
    public LongSparseArray<ThreadInfo> c;
    public List<ThreadInfo> d;
    public BdUniqueId e;
    public c f;
    public CustomMessageListener g;
    public final CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k58 k58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, Integer.valueOf(i)};
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
            this.a = k58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long j = JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L);
                long j2 = JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L);
                if (j != 0 && j2 != 0) {
                    SafeHandler.getInst().removeCallbacks(this.a.f);
                    k58 k58Var = this.a;
                    k58Var.f = new c(k58Var, j2, j);
                    SafeHandler.getInst().postDelayed(this.a.f, 500L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k58 k58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, Integer.valueOf(i)};
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
            this.a = k58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.a.a) && !ListUtils.isEmpty(this.a.d)) {
                    Iterator it = this.a.a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        cn cnVar = (cn) it.next();
                        if (cnVar instanceof up6) {
                            up6 up6Var = (up6) cnVar;
                            if (up6Var.getThreadData() != null && up6Var.getThreadData().getTid() != null && up6Var.getThreadData().getTid().equals(str)) {
                                it.remove();
                                o78.b(this.a.a);
                                this.a.b.B(new ArrayList(this.a.a));
                                break;
                            }
                        }
                    }
                    long j = JavaTypesHelper.toLong(str, 0L);
                    Iterator it2 = this.a.d.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo threadInfo = (ThreadInfo) it2.next();
                        if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == j) {
                            it2.remove();
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;
        public final /* synthetic */ k58 c;

        public c(k58 k58Var, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k58Var;
            this.a = j;
            this.b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.c.e);
                requestGetMyPostNetMessage.setParams(this.a, this.b, 0L, equipmentWidth, equipmentHeight, f, i);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    public k58(List<cn> list, v68 v68Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, v68Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LongSparseArray<>();
        this.g = new a(this, 2921030);
        this.h = new b(this, 2921031);
        this.a = list;
        this.b = v68Var;
    }

    public void j(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.d = list;
        }
    }

    public void g(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.e = bdUniqueId;
            this.g.setTag(bdUniqueId);
            this.g.setSelfListener(false);
            this.h.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f != null) {
            SafeHandler.getInst().removeCallbacks(this.f);
        }
    }
}
