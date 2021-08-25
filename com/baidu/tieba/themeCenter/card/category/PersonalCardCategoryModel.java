package com.baidu.tieba.themeCenter.card.category;

import c.a.q0.o3.h.e;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class PersonalCardCategoryModel extends BdBaseModel<PersonalCardCategoryModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f57320e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.q0.o3.g.a.a> f57321f;

    /* renamed from: g  reason: collision with root package name */
    public int f57322g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57323h;

    /* renamed from: i  reason: collision with root package name */
    public b f57324i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.a f57325j;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardCategoryModel f57326a;

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
            this.f57326a = personalCardCategoryModel;
        }

        @Override // c.a.e.c.g.a
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
                        if (this.f57326a.f57321f == null) {
                            this.f57326a.f57321f = new ArrayList();
                        }
                        if (personalCardCategorySocktResponse.getCardCategoryList() != null) {
                            this.f57326a.f57321f.addAll(personalCardCategorySocktResponse.getCardCategoryList());
                        }
                        this.f57326a.f57320e = personalCardCategorySocktResponse.getRecommand();
                        this.f57326a.f57323h = personalCardCategorySocktResponse.isHasMore();
                    } else if (responsedMessage instanceof PersonalCardCategoryHttpResponse) {
                        PersonalCardCategoryHttpResponse personalCardCategoryHttpResponse = (PersonalCardCategoryHttpResponse) responsedMessage;
                        if (this.f57326a.f57321f == null) {
                            this.f57326a.f57321f = new ArrayList();
                        }
                        if (personalCardCategoryHttpResponse.getCardCategoryList() != null) {
                            this.f57326a.f57321f.addAll(personalCardCategoryHttpResponse.getCardCategoryList());
                        }
                        this.f57326a.f57320e = personalCardCategoryHttpResponse.getRecommand();
                        this.f57326a.f57323h = personalCardCategoryHttpResponse.isHasMore();
                    }
                    if (this.f57326a.f57324i != null) {
                        this.f57326a.f57324i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f57326a.f57320e, this.f57326a.f57321f, this.f57326a.f57323h);
                        return;
                    }
                    return;
                }
                PersonalCardCategoryModel.w(this.f57326a);
                if (this.f57326a.f57324i != null) {
                    this.f57326a.f57324i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f57326a.f57320e, this.f57326a.f57321f, this.f57326a.f57323h);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2, String str, e eVar, List<c.a.q0.o3.g.a.a> list, boolean z);
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
        this.f57322g = 1;
        this.f57323h = true;
        this.f57325j = new a(this, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, 309331);
        c.a.q0.i3.d0.a.h(309331, PersonalCardCategorySocktResponse.class, false, false);
        c.a.q0.i3.d0.a.c(309331, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, TbConfig.GET_PERSONAL_CARD_BY_CATEGORY, PersonalCardCategoryHttpResponse.class, false, false, false, false);
        registerListener(this.f57325j);
    }

    public static /* synthetic */ int w(PersonalCardCategoryModel personalCardCategoryModel) {
        int i2 = personalCardCategoryModel.f57322g;
        personalCardCategoryModel.f57322g = i2 - 1;
        return i2;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f57323h) {
            this.f57322g++;
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            personalCardCategoryRequest.setPn(this.f57322g);
            sendMessage(personalCardCategoryRequest);
        }
    }

    public void F(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            G(j2, i2);
            b bVar = this.f57324i;
            if (bVar != null) {
                bVar.a(0, null, this.f57320e, this.f57321f, this.f57323h);
            }
        }
    }

    public void G(long j2, int i2) {
        List<c.a.q0.o3.g.a.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) || (list = this.f57321f) == null || list.size() <= 0) {
            return;
        }
        for (c.a.q0.o3.g.a.a aVar : list) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                for (c.a.q0.o3.a aVar2 : aVar.a()) {
                    if (aVar2 != null) {
                        if (aVar2.a() == j2) {
                            if (i2 == 1) {
                                aVar2.s(1);
                            } else {
                                aVar2.s(0);
                            }
                        } else if (i2 == 1) {
                            aVar2.s(0);
                        } else if (aVar2.a() == c.a.q0.o3.a.k) {
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
            this.f57324i = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            this.f57322g = 1;
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
            MessageManager.getInstance().unRegisterListener(this.f57325j);
        }
    }
}
