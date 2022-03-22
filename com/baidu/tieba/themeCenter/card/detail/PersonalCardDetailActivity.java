package com.baidu.tieba.themeCenter.card.detail;

import android.os.Bundle;
import android.view.View;
import c.a.o0.p0.d;
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
/* loaded from: classes6.dex */
public class PersonalCardDetailActivity extends BaseActivity<PersonalCardDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.f4.a cardData;
    public PersonalCardDetailModel.b mCallback;
    public long mCardId;
    public View.OnClickListener mClickListener;
    public PersonalCardDetailModel mModel;
    public SetPersonalCardModel.b mSetCardCallback;
    public SetPersonalCardModel mSetCardModel;
    public c.a.p0.f4.g.b.a mView;

    /* loaded from: classes6.dex */
    public class a implements PersonalCardDetailModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardDetailActivity a;

        public a(PersonalCardDetailActivity personalCardDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalCardDetailActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.b
        public void a(int i, String str, c.a.p0.f4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, aVar) == null) {
                PersonalCardDetailActivity personalCardDetailActivity = this.a;
                personalCardDetailActivity.hideLoadingView(personalCardDetailActivity.mView.c());
                if (i != 0) {
                    this.a.showToast(str);
                }
                this.a.cardData = aVar;
                this.a.mView.h(i, aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SetPersonalCardModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardDetailActivity a;

        public b(PersonalCardDetailActivity personalCardDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalCardDetailActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.b
        public void a(boolean z, long j, int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                if (z) {
                    if (j != this.a.mCardId) {
                        if (i == 1) {
                            this.a.cardData.s(0);
                            this.a.mView.i(this.a.cardData);
                            return;
                        }
                        return;
                    }
                    if (i == 1) {
                        this.a.cardData.s(1);
                    } else if (i == 2) {
                        this.a.cardData.s(0);
                    }
                    this.a.mView.i(this.a.cardData);
                    return;
                }
                PersonalCardDetailActivity personalCardDetailActivity = this.a;
                personalCardDetailActivity.showErrorDialog(i2, str, personalCardDetailActivity.cardData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardDetailActivity a;

        public c(PersonalCardDetailActivity personalCardDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalCardDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.a.mView.d()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.a.mSetCardModel == null) {
                        this.a.mSetCardModel = new SetPersonalCardModel();
                    }
                    if (this.a.cardData.g() == 1) {
                        this.a.mSetCardModel.E(this.a.mCardId, 2);
                        return;
                    } else {
                        this.a.mSetCardModel.E(this.a.mCardId, 1);
                        return;
                    }
                }
                ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
            }
        }
    }

    public PersonalCardDetailActivity() {
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
        this.mCallback = new a(this);
        this.mSetCardCallback = new b(this);
        this.mClickListener = new c(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.o0.p0.a
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
                pageStayDurationItem.a = true;
                pageStayDurationItem.i = String.valueOf(this.mCardId);
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            c.a.p0.f4.g.b.a aVar = this.mView;
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
            this.mView = new c.a.p0.f4.g.b.a(this, this.mClickListener);
            PersonalCardDetailModel personalCardDetailModel = new PersonalCardDetailModel();
            this.mModel = personalCardDetailModel;
            personalCardDetailModel.C(this.mCallback);
            SetPersonalCardModel setPersonalCardModel = new SetPersonalCardModel();
            this.mSetCardModel = setPersonalCardModel;
            setPersonalCardModel.D(this.mSetCardCallback);
            showLoadingView(this.mView.c(), false);
            this.mModel.B(this.mCardId);
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
        c.a.p0.f4.g.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mModel == null || (aVar = this.mView) == null) {
            return;
        }
        showLoadingView(aVar.c(), false);
        this.mModel.B(this.mCardId);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.onUserChanged(z);
            if (z) {
                c.a.o0.z.b.d().h();
                showLoadingView(this.mView.c(), false);
                this.mModel.B(this.mCardId);
            }
        }
    }

    public void showErrorDialog(int i, String str, c.a.p0.f4.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i, str, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f() == 101 ? 9 : 0;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i == c.a.p0.f4.c.a) {
            c.a.p0.f4.b.d(getPageContext(), 6, str, i2, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
        } else if (i == c.a.p0.f4.c.f14994b) {
            c.a.p0.f4.b.c(getPageContext(), 6, str, i2);
        }
    }
}
