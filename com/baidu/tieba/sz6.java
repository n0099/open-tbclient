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
import com.baidu.tieba.sd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class sz6 extends sd5 {
    public static /* synthetic */ Interceptable $ic;
    public static sz6 c;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<vd5> a;
    public final CustomMessageListener b;

    @Override // com.baidu.tieba.sd5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz6 a;

        /* renamed from: com.baidu.tieba.sz6$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0471a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0471a(a aVar) {
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
        public a(sz6 sz6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var, Integer.valueOf(i)};
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
            this.a = sz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.d();
                kp6.a(new RunnableC0471a(this), "UpdateUserCollect", 1);
            }
        }
    }

    public sz6() {
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
                Iterator<vd5> it = this.a.iterator();
                while (it.hasNext()) {
                    vd5 next = it.next();
                    if (next instanceof qz6) {
                        ((qz6) next).x();
                    }
                }
            }
        }
    }

    public static sz6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (sz6.class) {
                    if (c == null) {
                        c = new sz6();
                    }
                }
            }
            return c;
        }
        return (sz6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sd5
    public void b(sd5.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && FileHelper.checkSD()) {
            LinkedList<vd5> linkedList = this.a;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<vd5> it = this.a.iterator();
                while (it.hasNext()) {
                    vd5 next = it.next();
                    if (aVar != null) {
                        aVar.a(next);
                    }
                }
                return;
            }
            this.a = new LinkedList<>();
            qz6 qz6Var = new qz6();
            this.a.add(qz6Var);
            if (aVar != null) {
                aVar.a(qz6Var);
            }
        }
    }

    @Override // com.baidu.tieba.sd5
    public void d() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        List<CollectEmotionData> q = hz6.o().q(TbadkCoreApplication.getCurrentAccount());
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
        collectEmotionData.setSharpText(ih5.f);
        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
        hz6.o().a(collectEmotionData);
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = ih5.a();
        emotionGroupData.groupName = "用户收藏表情";
        emotionGroupData.groupDesc = "用户收藏表情";
        emotionGroupData.emotionsCount = 301;
        emotionGroupData.status = 1;
        emotionGroupData.downloadUrl = "";
        hz6.o().h(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        hz6.o().g(emotionGroupData);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            LinkedList<vd5> linkedList = this.a;
            if (linkedList == null) {
                return false;
            }
            Iterator<vd5> it = linkedList.iterator();
            while (it.hasNext()) {
                vd5 next = it.next();
                if (next instanceof qz6) {
                    return ((qz6) next).v(str);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
