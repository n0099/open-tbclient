package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class yr7 extends as7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData h;
    public boolean i;
    public String j;
    public PraiseModel k;
    public final CustomMessageListener l;

    /* loaded from: classes8.dex */
    public class a implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr7 a;

        public a(yr7 yr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr7Var;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(int i, String str) {
            FrsFragment frsFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && (frsFragment = this.a.b) != null && frsFragment.getPageContext() != null && this.a.i && !TextUtils.isEmpty(str)) {
                if (AntiHelper.m(i, str)) {
                    AntiHelper.u(this.a.b.getPageContext().getPageActivity(), str);
                } else {
                    this.a.b.showToast(str);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.i) {
                    int i = 1;
                    if (this.a.h != null && this.a.h.getPraise().getIsLike() == 1) {
                        i = 0;
                    }
                    this.a.h(i);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yr7 yr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr7Var, Integer.valueOf(i)};
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
            this.a = yr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ThreadData)) {
                ThreadData threadData = (ThreadData) customResponsedMessage.getData();
                this.a.j = threadData.getId();
                if (!TextUtils.isEmpty(this.a.j) && threadData.getPraise() != null) {
                    this.a.h(threadData.getPraise().getIsLike());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yr7(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b bVar = new b(this, 2004004);
        this.l = bVar;
        this.b.registerListener(bVar);
        this.k = e();
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.i = z;
        }
    }

    public final PraiseModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.k == null) {
                this.k = new PraiseModel(this.b.getPageContext(), new a(this));
            }
            return this.k;
        }
        return (PraiseModel) invokeV.objValue;
    }

    public void g(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, threadData, i) != null) || threadData == null) {
            return;
        }
        if (i == 1) {
            PraiseData praise = threadData.getPraise();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    threadData.setPraise(praiseData);
                    return;
                }
                threadData.getPraise().getUser().add(0, metaData);
                threadData.getPraise().setNum(threadData.getPraise().getNum() + 1);
                threadData.getPraise().setIsLike(i);
            }
        } else if (threadData.getPraise() != null) {
            threadData.getPraise().setIsLike(i);
            threadData.getPraise().setNum(threadData.getPraise().getNum() - 1);
            ArrayList<MetaData> user = threadData.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        threadData.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void h(int i) {
        FrsViewData m1;
        ArrayList<cn> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (m1 = this.b.m1()) != null && this.a != null && (threadList = m1.getThreadList()) != null) {
            Iterator<cn> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cn next = it.next();
                if (next instanceof h45) {
                    ThreadData threadData = ((h45) next).t;
                    if (threadData == this.h) {
                        g(threadData, i);
                        this.h = null;
                        break;
                    } else if (threadData.getId() != null && threadData.getId().equals(this.j)) {
                        g(threadData, i);
                        this.j = null;
                        break;
                    }
                }
            }
            this.a.a0().g(threadList, m1);
            this.a.a0().notifyDataSetChanged();
        }
    }
}
