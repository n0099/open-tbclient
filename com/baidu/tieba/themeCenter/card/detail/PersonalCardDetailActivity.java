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
import com.baidu.tieba.a4a;
import com.baidu.tieba.a5a;
import com.baidu.tieba.b4a;
import com.baidu.tieba.c4a;
import com.baidu.tieba.sk5;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
import com.baidu.tieba.vr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonalCardDetailActivity extends BaseActivity<PersonalCardDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalCardDetailModel a;
    public SetPersonalCardModel b;
    public a5a c;
    public long d;
    public a4a e;
    public PersonalCardDetailModel.b f;
    public SetPersonalCardModel.b g;
    public View.OnClickListener h;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.sr5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "b013" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
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
        public void a(int i, String str, a4a a4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, a4aVar) == null) {
                PersonalCardDetailActivity personalCardDetailActivity = this.a;
                personalCardDetailActivity.hideLoadingView(personalCardDetailActivity.c.c());
                if (i != 0) {
                    this.a.showToast(str);
                }
                this.a.e = a4aVar;
                this.a.c.h(i, a4aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    if (j == this.a.d) {
                        if (i == 1) {
                            this.a.e.s(1);
                        } else if (i == 2) {
                            this.a.e.s(0);
                        }
                        this.a.c.i(this.a.e);
                        return;
                    } else if (i == 1) {
                        this.a.e.s(0);
                        this.a.c.i(this.a.e);
                        return;
                    } else {
                        return;
                    }
                }
                PersonalCardDetailActivity personalCardDetailActivity = this.a;
                personalCardDetailActivity.E1(i2, str, personalCardDetailActivity.e);
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2 == this.a.c.d()) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                    return;
                }
                if (this.a.b == null) {
                    this.a.b = new SetPersonalCardModel();
                }
                if (this.a.e.g() == 1) {
                    this.a.b.a0(this.a.d, 2);
                } else {
                    this.a.b.a0(this.a.d, 1);
                }
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
        this.f = new a(this);
        this.g = new b(this);
        this.h = new c(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            a5a a5aVar = this.c;
            if (a5aVar != null) {
                a5aVar.a();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onUserChanged(z);
            if (z) {
                sk5.d().h();
                showLoadingView(this.c.c(), false);
                this.a.X(this.d);
            }
        }
    }

    public void E1(int i, String str, a4a a4aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(1048576, this, i, str, a4aVar) != null) || a4aVar == null) {
            return;
        }
        if (a4aVar.f() == 101) {
            i2 = 9;
        } else {
            i2 = 0;
        }
        if (!StringUtils.isNull(str)) {
            if (i == c4a.a) {
                b4a.d(getPageContext(), 6, str, i2, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            } else if (i == c4a.b) {
                b4a.c(getPageContext(), 6, str, i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public vr5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            vr5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
                pageStayDurationItem.i = String.valueOf(this.d);
            }
            return pageStayDurationItem;
        }
        return (vr5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            PersonalCardDetailModel personalCardDetailModel = this.a;
            if (personalCardDetailModel != null) {
                personalCardDetailModel.onDestroy();
            }
            SetPersonalCardModel setPersonalCardModel = this.b;
            if (setPersonalCardModel != null) {
                setPersonalCardModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        a5a a5aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null && (a5aVar = this.c) != null) {
            showLoadingView(a5aVar.c(), false);
            this.a.X(this.d);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.d = getIntent().getLongExtra(PersonalCardDetailActivityConfig.CARD_ID, 0L);
            this.c = new a5a(this, this.h);
            PersonalCardDetailModel personalCardDetailModel = new PersonalCardDetailModel();
            this.a = personalCardDetailModel;
            personalCardDetailModel.Y(this.f);
            SetPersonalCardModel setPersonalCardModel = new SetPersonalCardModel();
            this.b = setPersonalCardModel;
            setPersonalCardModel.Z(this.g);
            showLoadingView(this.c.c(), false);
            this.a.X(this.d);
        }
    }
}
