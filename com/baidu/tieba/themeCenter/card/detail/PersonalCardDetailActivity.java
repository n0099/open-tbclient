package com.baidu.tieba.themeCenter.card.detail;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.m0.d;
/* loaded from: classes4.dex */
public class PersonalCardDetailActivity extends BaseActivity<PersonalCardDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.n3.a cardData;
    public PersonalCardDetailModel.b mCallback;
    public long mCardId;
    public View.OnClickListener mClickListener;
    public PersonalCardDetailModel mModel;
    public SetPersonalCardModel.b mSetCardCallback;
    public SetPersonalCardModel mSetCardModel;
    public d.a.q0.n3.g.b.a mView;

    /* loaded from: classes4.dex */
    public class a implements PersonalCardDetailModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardDetailActivity f21612a;

        public a(PersonalCardDetailActivity personalCardDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21612a = personalCardDetailActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.b
        public void a(int i2, String str, d.a.q0.n3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, aVar) == null) {
                PersonalCardDetailActivity personalCardDetailActivity = this.f21612a;
                personalCardDetailActivity.hideLoadingView(personalCardDetailActivity.mView.c());
                if (i2 != 0) {
                    this.f21612a.showToast(str);
                }
                this.f21612a.cardData = aVar;
                this.f21612a.mView.h(i2, aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SetPersonalCardModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardDetailActivity f21613a;

        public b(PersonalCardDetailActivity personalCardDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21613a = personalCardDetailActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.b
        public void a(boolean z, long j, int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                if (z) {
                    if (j != this.f21613a.mCardId) {
                        if (i2 == 1) {
                            this.f21613a.cardData.s(0);
                            this.f21613a.mView.i(this.f21613a.cardData);
                            return;
                        }
                        return;
                    }
                    if (i2 == 1) {
                        this.f21613a.cardData.s(1);
                    } else if (i2 == 2) {
                        this.f21613a.cardData.s(0);
                    }
                    this.f21613a.mView.i(this.f21613a.cardData);
                    return;
                }
                PersonalCardDetailActivity personalCardDetailActivity = this.f21613a;
                personalCardDetailActivity.showErrorDialog(i3, str, personalCardDetailActivity.cardData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalCardDetailActivity f21614e;

        public c(PersonalCardDetailActivity personalCardDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21614e = personalCardDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f21614e.mView.d()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.f21614e.mSetCardModel == null) {
                        this.f21614e.mSetCardModel = new SetPersonalCardModel();
                    }
                    if (this.f21614e.cardData.g() == 1) {
                        this.f21614e.mSetCardModel.C(this.f21614e.mCardId, 2);
                        return;
                    } else {
                        this.f21614e.mSetCardModel.C(this.f21614e.mCardId, 1);
                        return;
                    }
                }
                ViewHelper.skipToLoginActivity(this.f21614e.getPageContext().getPageActivity());
            }
        }
    }

    public PersonalCardDetailActivity() {
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
        this.mCallback = new a(this);
        this.mSetCardCallback = new b(this);
        this.mClickListener = new c(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b013" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.f52762a = true;
                pageStayDurationItem.f52770i = String.valueOf(this.mCardId);
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.n3.g.b.a aVar = this.mView;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mCardId = getIntent().getLongExtra(PersonalCardDetailActivityConfig.CARD_ID, 0L);
            this.mView = new d.a.q0.n3.g.b.a(this, this.mClickListener);
            PersonalCardDetailModel personalCardDetailModel = new PersonalCardDetailModel();
            this.mModel = personalCardDetailModel;
            personalCardDetailModel.A(this.mCallback);
            SetPersonalCardModel setPersonalCardModel = new SetPersonalCardModel();
            this.mSetCardModel = setPersonalCardModel;
            setPersonalCardModel.B(this.mSetCardCallback);
            showLoadingView(this.mView.c(), false);
            this.mModel.z(this.mCardId);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            PersonalCardDetailModel personalCardDetailModel = this.mModel;
            if (personalCardDetailModel != null) {
                personalCardDetailModel.onDestroy();
            }
            SetPersonalCardModel setPersonalCardModel = this.mSetCardModel;
            if (setPersonalCardModel != null) {
                setPersonalCardModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        d.a.q0.n3.g.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mModel == null || (aVar = this.mView) == null) {
            return;
        }
        showLoadingView(aVar.c(), false);
        this.mModel.z(this.mCardId);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.onUserChanged(z);
            if (z) {
                d.a.p0.a0.b.a().d();
                showLoadingView(this.mView.c(), false);
                this.mModel.z(this.mCardId);
            }
        }
    }

    public void showErrorDialog(int i2, String str, d.a.q0.n3.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i2, str, aVar) == null) || aVar == null) {
            return;
        }
        int i3 = aVar.f() == 101 ? 9 : 0;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == d.a.q0.n3.c.f61482a) {
            d.a.q0.n3.b.d(getPageContext(), 6, str, i3, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
        } else if (i2 == d.a.q0.n3.c.f61483b) {
            d.a.q0.n3.b.c(getPageContext(), 6, str, i3);
        }
    }
}
