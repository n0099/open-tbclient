package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.yd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class rv6 extends yd5 {
    public static /* synthetic */ Interceptable $ic;
    public static rv6 c;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<be5> a;
    public final CustomMessageListener b;

    @Override // com.baidu.tieba.yd5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv6 a;

        /* renamed from: com.baidu.tieba.rv6$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0424a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0424a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.g();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rv6 rv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv6Var, Integer.valueOf(i)};
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
            this.a = rv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.d();
                km6.a(new RunnableC0424a(this), "UpdateUserCollect", 1);
            }
        }
    }

    public rv6() {
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
        this.b = new a(this, 2005016);
        MessageManager.getInstance().registerListener(this.b);
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                Iterator<be5> it = this.a.iterator();
                while (it.hasNext()) {
                    be5 next = it.next();
                    if (next instanceof pv6) {
                        ((pv6) next).x();
                    }
                }
            }
        }
    }

    public static rv6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (rv6.class) {
                    if (c == null) {
                        c = new rv6();
                    }
                }
            }
            return c;
        }
        return (rv6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yd5
    public void b(yd5.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && FileHelper.checkSD()) {
            LinkedList<be5> linkedList = this.a;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<be5> it = this.a.iterator();
                while (it.hasNext()) {
                    be5 next = it.next();
                    if (aVar != null) {
                        aVar.a(next);
                    }
                }
                return;
            }
            this.a = new LinkedList<>();
            pv6 pv6Var = new pv6();
            this.a.add(pv6Var);
            if (aVar != null) {
                aVar.a(pv6Var);
            }
        }
    }

    @Override // com.baidu.tieba.yd5
    public void d() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        List<CollectEmotionData> q = gv6.o().q(TbadkCoreApplication.getCurrentAccount());
        if (q != null && q.size() != 0) {
            if (q != null && q.size() != 0) {
                i = q.size() - 1;
            } else {
                i = 0;
            }
            StatisticItem statisticItem = new StatisticItem("c12224");
            statisticItem.param("obj_param1", i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return;
        }
        CollectEmotionData collectEmotionData = new CollectEmotionData();
        collectEmotionData.pid = "setting_icon";
        collectEmotionData.setOrderId(301);
        collectEmotionData.setSharpText(lg5.f);
        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
        gv6.o().a(collectEmotionData);
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = lg5.a();
        emotionGroupData.groupName = "用户收藏表情";
        emotionGroupData.groupDesc = "用户收藏表情";
        emotionGroupData.emotionsCount = 301;
        emotionGroupData.status = 1;
        emotionGroupData.downloadUrl = "";
        gv6.o().h(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        gv6.o().g(emotionGroupData);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            LinkedList<be5> linkedList = this.a;
            if (linkedList == null) {
                return false;
            }
            Iterator<be5> it = linkedList.iterator();
            while (it.hasNext()) {
                be5 next = it.next();
                if (next instanceof pv6) {
                    return ((pv6) next).v(str);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
