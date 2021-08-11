package com.baidu.tieba.themeCenter.card.category;

import android.os.Bundle;
import c.a.p0.o3.h.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class PersonalCardCategoryActivity extends BaseActivity<PersonalCardCategoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalCardItemView.b mCardViewController;
    public PersonalCardCategoryModel.b mDataCallback;
    public PersonalCardCategoryModel mModel;
    public BdListView.p mScrollToBottomListener;
    public SetPersonalCardModel.b mSetCardCallback;
    public SetPersonalCardModel mSetCardModel;
    public c.a.p0.o3.g.a.c mView;

    /* loaded from: classes7.dex */
    public class a implements PersonalCardItemView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardCategoryActivity f57150a;

        public a(PersonalCardCategoryActivity personalCardCategoryActivity) {
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
            this.f57150a = personalCardCategoryActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.b
        public void a(c.a.p0.o3.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            if (aVar.a() == c.a.p0.o3.a.k) {
                if (aVar.g() == 1 || this.f57150a.mSetCardModel == null) {
                    return;
                }
                this.f57150a.mSetCardModel.C(aVar.a(), 1);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f57150a.getPageContext().getPageActivity(), aVar.a())));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements PersonalCardCategoryModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardCategoryActivity f57151a;

        public b(PersonalCardCategoryActivity personalCardCategoryActivity) {
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
            this.f57151a = personalCardCategoryActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel.b
        public void a(int i2, String str, e eVar, List<c.a.p0.o3.g.a.a> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, eVar, list, Boolean.valueOf(z)}) == null) {
                PersonalCardCategoryActivity personalCardCategoryActivity = this.f57151a;
                personalCardCategoryActivity.hideLoadingView(personalCardCategoryActivity.mView.c());
                if (i2 != 0) {
                    this.f57151a.showToast(str);
                }
                this.f57151a.mView.j(i2, eVar, list, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements SetPersonalCardModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardCategoryActivity f57152a;

        public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
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
            this.f57152a = personalCardCategoryActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.b
        public void a(boolean z, long j2, int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) && z && this.f57152a.mModel != null) {
                this.f57152a.mModel.F(j2, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalCardCategoryActivity f57153e;

        public d(PersonalCardCategoryActivity personalCardCategoryActivity) {
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
            this.f57153e = personalCardCategoryActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57153e.mModel == null) {
                return;
            }
            this.f57153e.mModel.E();
        }
    }

    public PersonalCardCategoryActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCardViewController = new a(this);
        this.mDataCallback = new b(this);
        this.mSetCardCallback = new c(this);
        this.mScrollToBottomListener = new d(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.o0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b012" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public c.a.o0.m0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.o0.m0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.f13335a = true;
            }
            return pageStayDurationItem;
        }
        return (c.a.o0.m0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.p0.o3.g.a.c cVar = this.mView;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.p0.o3.g.a.c cVar = new c.a.p0.o3.g.a.c(this);
            this.mView = cVar;
            cVar.h(this.mScrollToBottomListener);
            this.mView.g(this.mCardViewController);
            PersonalCardCategoryModel personalCardCategoryModel = new PersonalCardCategoryModel(this);
            this.mModel = personalCardCategoryModel;
            personalCardCategoryModel.H(this.mDataCallback);
            SetPersonalCardModel setPersonalCardModel = new SetPersonalCardModel();
            this.mSetCardModel = setPersonalCardModel;
            setPersonalCardModel.B(this.mSetCardCallback);
            showLoadingView(this.mView.c());
            this.mModel.LoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            PersonalCardCategoryModel personalCardCategoryModel = this.mModel;
            if (personalCardCategoryModel != null) {
                personalCardCategoryModel.onDestroy();
            }
            SetPersonalCardModel setPersonalCardModel = this.mSetCardModel;
            if (setPersonalCardModel != null) {
                setPersonalCardModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        c.a.p0.o3.g.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mModel == null || (cVar = this.mView) == null) {
            return;
        }
        showLoadingView(cVar.c());
        this.mModel.LoadData();
    }
}
