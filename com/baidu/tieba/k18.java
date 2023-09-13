package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.NegFeedBackDecorItem;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class k18 extends pm<x18, ThreadCardViewHolder<x18>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public in c;
    public String d;
    public NEGFeedBackView.NEGFeedbackEventCallback e;

    /* loaded from: classes6.dex */
    public class a implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k18 a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackWindowShow(NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, negativeFeedBackData) == null) {
            }
        }

        public a(k18 k18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k18Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, negativeFeedBackData) == null) && arrayList != null && negativeFeedBackData != null) {
                CustomMessage customMessage = new CustomMessage(2921425, this.a.b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921425);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                new b().execute(new Integer[0]);
                TiebaStatic.log(new StatisticItem("c13572"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends BdAsyncTask<Integer, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        public b() {
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
            this.a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, numArr)) == null) {
                try {
                    NetWork netWork = new NetWork();
                    this.a = netWork;
                    netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                    this.a.addPostData("dislike_from", "concernpage");
                    this.a.addPostData("dislike_type", "1");
                    this.a.getNetContext().getRequest().mIsNeedTbs = true;
                    return this.a.postNetData();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((b) str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
        }
    }

    public void x(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, inVar) == null) {
            this.c = inVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            i28 i28Var = new i28(this.b, this.a);
            i28Var.t(true);
            bVar.n(i28Var);
            bVar.l().c(0);
            bVar.l().g(0);
            bVar.l().f(0);
            bVar.l().i(0);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.c));
            threadCardViewHolder.i(this.a);
            NegFeedBackDecorItem p = threadCardViewHolder.p(false);
            p.setNegEventCallback(this.e);
            p.setAutoProcess(false);
            p.setHeadText(this.mContext.getString(R.string.obfuscated_res_0x7f0f04bf));
            p.showWithNone(true);
            p.isConcernRecommend = true;
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, x18 x18Var, ThreadCardViewHolder<x18> threadCardViewHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, x18Var, threadCardViewHolder})) == null) {
            if (x18Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                StatisticItem statisticItem = new StatisticItem("c13565");
                if (x18Var.e()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                statisticItem.param("obj_source", i2);
                ep6.b().a(statisticItem);
                threadCardViewHolder.a().r(i);
                if (threadCardViewHolder.a() instanceof n56) {
                    threadCardViewHolder.a().b(this.d);
                }
                threadCardViewHolder.e(x18Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
