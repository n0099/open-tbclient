package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PersonalCardCategoryModel extends BdBaseModel<PersonalCardCategoryModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f21600e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.q0.n3.g.a.a> f21601f;

    /* renamed from: g  reason: collision with root package name */
    public int f21602g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21603h;

    /* renamed from: i  reason: collision with root package name */
    public b f21604i;
    public d.a.d.c.g.a j;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardCategoryModel f21605a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalCardCategoryModel personalCardCategoryModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardCategoryModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21605a = personalCardCategoryModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PersonalCardCategorySocktResponse;
            if (z || (responsedMessage instanceof PersonalCardCategoryHttpResponse)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        PersonalCardCategorySocktResponse personalCardCategorySocktResponse = (PersonalCardCategorySocktResponse) responsedMessage;
                        if (this.f21605a.f21601f == null) {
                            this.f21605a.f21601f = new ArrayList();
                        }
                        if (personalCardCategorySocktResponse.getCardCategoryList() != null) {
                            this.f21605a.f21601f.addAll(personalCardCategorySocktResponse.getCardCategoryList());
                        }
                        this.f21605a.f21600e = personalCardCategorySocktResponse.getRecommand();
                        this.f21605a.f21603h = personalCardCategorySocktResponse.isHasMore();
                    } else if (responsedMessage instanceof PersonalCardCategoryHttpResponse) {
                        PersonalCardCategoryHttpResponse personalCardCategoryHttpResponse = (PersonalCardCategoryHttpResponse) responsedMessage;
                        if (this.f21605a.f21601f == null) {
                            this.f21605a.f21601f = new ArrayList();
                        }
                        if (personalCardCategoryHttpResponse.getCardCategoryList() != null) {
                            this.f21605a.f21601f.addAll(personalCardCategoryHttpResponse.getCardCategoryList());
                        }
                        this.f21605a.f21600e = personalCardCategoryHttpResponse.getRecommand();
                        this.f21605a.f21603h = personalCardCategoryHttpResponse.isHasMore();
                    }
                    if (this.f21605a.f21604i != null) {
                        this.f21605a.f21604i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f21605a.f21600e, this.f21605a.f21601f, this.f21605a.f21603h);
                        return;
                    }
                    return;
                }
                PersonalCardCategoryModel.w(this.f21605a);
                if (this.f21605a.f21604i != null) {
                    this.f21605a.f21604i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f21605a.f21600e, this.f21605a.f21601f, this.f21605a.f21603h);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, e eVar, List<d.a.q0.n3.g.a.a> list, boolean z);
    }

    public PersonalCardCategoryModel(PersonalCardCategoryActivity personalCardCategoryActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardCategoryActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21602g = 1;
        this.f21603h = true;
        this.j = new a(this, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, 309331);
        d.a.q0.h3.d0.a.h(309331, PersonalCardCategorySocktResponse.class, false, false);
        d.a.q0.h3.d0.a.c(309331, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, TbConfig.GET_PERSONAL_CARD_BY_CATEGORY, PersonalCardCategoryHttpResponse.class, false, false, false, false);
        registerListener(this.j);
    }

    public static /* synthetic */ int w(PersonalCardCategoryModel personalCardCategoryModel) {
        int i2 = personalCardCategoryModel.f21602g;
        personalCardCategoryModel.f21602g = i2 - 1;
        return i2;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21603h) {
            this.f21602g++;
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            personalCardCategoryRequest.setPn(this.f21602g);
            sendMessage(personalCardCategoryRequest);
        }
    }

    public void F(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            G(j, i2);
            b bVar = this.f21604i;
            if (bVar != null) {
                bVar.a(0, null, this.f21600e, this.f21601f, this.f21603h);
            }
        }
    }

    public void G(long j, int i2) {
        List<d.a.q0.n3.g.a.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) || (list = this.f21601f) == null || list.size() <= 0) {
            return;
        }
        for (d.a.q0.n3.g.a.a aVar : list) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                for (d.a.q0.n3.a aVar2 : aVar.a()) {
                    if (aVar2 != null) {
                        if (aVar2.a() == j) {
                            if (i2 == 1) {
                                aVar2.s(1);
                            } else {
                                aVar2.s(0);
                            }
                        } else if (i2 == 1) {
                            aVar2.s(0);
                        } else if (aVar2.a() == d.a.q0.n3.a.k) {
                            aVar2.s(1);
                        }
                    }
                }
            }
        }
    }

    public void H(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f21604i = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            this.f21602g = 1;
            personalCardCategoryRequest.setPn(1);
            sendMessage(personalCardCategoryRequest);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }
}
