package com.baidu.tieba.themeCenter.card.category;

import b.a.r0.r3.h.e;
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
/* loaded from: classes9.dex */
public class PersonalCardCategoryModel extends BdBaseModel<PersonalCardCategoryModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f54582e;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a.r0.r3.g.a.a> f54583f;

    /* renamed from: g  reason: collision with root package name */
    public int f54584g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54585h;

    /* renamed from: i  reason: collision with root package name */
    public b f54586i;
    public b.a.e.c.g.a j;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardCategoryModel f54587a;

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
            this.f54587a = personalCardCategoryModel;
        }

        @Override // b.a.e.c.g.a
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
                        if (this.f54587a.f54583f == null) {
                            this.f54587a.f54583f = new ArrayList();
                        }
                        if (personalCardCategorySocktResponse.getCardCategoryList() != null) {
                            this.f54587a.f54583f.addAll(personalCardCategorySocktResponse.getCardCategoryList());
                        }
                        this.f54587a.f54582e = personalCardCategorySocktResponse.getRecommand();
                        this.f54587a.f54585h = personalCardCategorySocktResponse.isHasMore();
                    } else if (responsedMessage instanceof PersonalCardCategoryHttpResponse) {
                        PersonalCardCategoryHttpResponse personalCardCategoryHttpResponse = (PersonalCardCategoryHttpResponse) responsedMessage;
                        if (this.f54587a.f54583f == null) {
                            this.f54587a.f54583f = new ArrayList();
                        }
                        if (personalCardCategoryHttpResponse.getCardCategoryList() != null) {
                            this.f54587a.f54583f.addAll(personalCardCategoryHttpResponse.getCardCategoryList());
                        }
                        this.f54587a.f54582e = personalCardCategoryHttpResponse.getRecommand();
                        this.f54587a.f54585h = personalCardCategoryHttpResponse.isHasMore();
                    }
                    if (this.f54587a.f54586i != null) {
                        this.f54587a.f54586i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f54587a.f54582e, this.f54587a.f54583f, this.f54587a.f54585h);
                        return;
                    }
                    return;
                }
                PersonalCardCategoryModel.w(this.f54587a);
                if (this.f54587a.f54586i != null) {
                    this.f54587a.f54586i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f54587a.f54582e, this.f54587a.f54583f, this.f54587a.f54585h);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i2, String str, e eVar, List<b.a.r0.r3.g.a.a> list, boolean z);
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
        this.f54584g = 1;
        this.f54585h = true;
        this.j = new a(this, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, 309331);
        b.a.r0.l3.f0.a.h(309331, PersonalCardCategorySocktResponse.class, false, false);
        b.a.r0.l3.f0.a.c(309331, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, TbConfig.GET_PERSONAL_CARD_BY_CATEGORY, PersonalCardCategoryHttpResponse.class, false, false, false, false);
        registerListener(this.j);
    }

    public static /* synthetic */ int w(PersonalCardCategoryModel personalCardCategoryModel) {
        int i2 = personalCardCategoryModel.f54584g;
        personalCardCategoryModel.f54584g = i2 - 1;
        return i2;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f54585h) {
            this.f54584g++;
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            personalCardCategoryRequest.setPn(this.f54584g);
            sendMessage(personalCardCategoryRequest);
        }
    }

    public void F(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            G(j, i2);
            b bVar = this.f54586i;
            if (bVar != null) {
                bVar.a(0, null, this.f54582e, this.f54583f, this.f54585h);
            }
        }
    }

    public void G(long j, int i2) {
        List<b.a.r0.r3.g.a.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) || (list = this.f54583f) == null || list.size() <= 0) {
            return;
        }
        for (b.a.r0.r3.g.a.a aVar : list) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                for (b.a.r0.r3.a aVar2 : aVar.a()) {
                    if (aVar2 != null) {
                        if (aVar2.a() == j) {
                            if (i2 == 1) {
                                aVar2.s(1);
                            } else {
                                aVar2.s(0);
                            }
                        } else if (i2 == 1) {
                            aVar2.s(0);
                        } else if (aVar2.a() == b.a.r0.r3.a.k) {
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
            this.f54586i = bVar;
        }
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            this.f54584g = 1;
            personalCardCategoryRequest.setPn(1);
            sendMessage(personalCardCategoryRequest);
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
