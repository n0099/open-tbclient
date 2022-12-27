package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.az8;
import com.baidu.tieba.qb;
import com.baidu.tieba.sy8;
import com.baidu.tieba.ur8;
import com.baidu.tieba.vx8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PersonalCardCategoryModel extends BdBaseModel<PersonalCardCategoryModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public az8 a;
    public List<sy8> b;
    public int c;
    public boolean d;
    public b e;
    public qb f;

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i, String str, az8 az8Var, List<sy8> list, boolean z);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardCategoryModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalCardCategoryModel personalCardCategoryModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardCategoryModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = personalCardCategoryModel;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PersonalCardCategorySocktResponse;
            if (!z && !(responsedMessage instanceof PersonalCardCategoryHttpResponse)) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                PersonalCardCategoryModel.G(this.a);
                if (this.a.e != null) {
                    this.a.e.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.a, this.a.b, this.a.d);
                    return;
                }
                return;
            }
            if (z) {
                PersonalCardCategorySocktResponse personalCardCategorySocktResponse = (PersonalCardCategorySocktResponse) responsedMessage;
                if (this.a.b == null) {
                    this.a.b = new ArrayList();
                }
                if (personalCardCategorySocktResponse.getCardCategoryList() != null) {
                    this.a.b.addAll(personalCardCategorySocktResponse.getCardCategoryList());
                }
                this.a.a = personalCardCategorySocktResponse.getRecommand();
                this.a.d = personalCardCategorySocktResponse.isHasMore();
            } else if (responsedMessage instanceof PersonalCardCategoryHttpResponse) {
                PersonalCardCategoryHttpResponse personalCardCategoryHttpResponse = (PersonalCardCategoryHttpResponse) responsedMessage;
                if (this.a.b == null) {
                    this.a.b = new ArrayList();
                }
                if (personalCardCategoryHttpResponse.getCardCategoryList() != null) {
                    this.a.b.addAll(personalCardCategoryHttpResponse.getCardCategoryList());
                }
                this.a.a = personalCardCategoryHttpResponse.getRecommand();
                this.a.d = personalCardCategoryHttpResponse.isHasMore();
            }
            if (this.a.e != null) {
                this.a.e.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.a, this.a.b, this.a.d);
            }
        }
    }

    public PersonalCardCategoryModel(PersonalCardCategoryActivity personalCardCategoryActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardCategoryActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 1;
        this.d = true;
        this.f = new a(this, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, 309331);
        ur8.h(309331, PersonalCardCategorySocktResponse.class, false, false);
        ur8.c(309331, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, TbConfig.GET_PERSONAL_CARD_BY_CATEGORY, PersonalCardCategoryHttpResponse.class, false, false, false, false);
        registerListener(this.f);
    }

    public static /* synthetic */ int G(PersonalCardCategoryModel personalCardCategoryModel) {
        int i = personalCardCategoryModel.c;
        personalCardCategoryModel.c = i - 1;
        return i;
    }

    public void R(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.d) {
            return;
        }
        this.c++;
        PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
        personalCardCategoryRequest.setPn(this.c);
        sendMessage(personalCardCategoryRequest);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            this.c = 1;
            personalCardCategoryRequest.setPn(1);
            sendMessage(personalCardCategoryRequest);
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
        }
    }

    public void P(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            Q(j, i);
            b bVar = this.e;
            if (bVar != null) {
                bVar.a(0, null, this.a, this.b, this.d);
            }
        }
    }

    public void Q(long j, int i) {
        List<sy8> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && (list = this.b) != null && list.size() > 0) {
            for (sy8 sy8Var : list) {
                if (sy8Var != null && sy8Var.a() != null && sy8Var.a().size() > 0) {
                    for (vx8 vx8Var : sy8Var.a()) {
                        if (vx8Var != null) {
                            if (vx8Var.a() == j) {
                                if (i == 1) {
                                    vx8Var.s(1);
                                } else {
                                    vx8Var.s(0);
                                }
                            } else if (i == 1) {
                                vx8Var.s(0);
                            } else if (vx8Var.a() == vx8.k) {
                                vx8Var.s(1);
                            }
                        }
                    }
                }
            }
        }
    }
}
