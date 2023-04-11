package com.baidu.tieba.themeCenter.card.category;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tieba.as9;
import com.baidu.tieba.cs9;
import com.baidu.tieba.dr9;
import com.baidu.tieba.is9;
import com.baidu.tieba.ol5;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class PersonalCardCategoryActivity extends BaseActivity<PersonalCardCategoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cs9 a;
    public PersonalCardCategoryModel b;
    public SetPersonalCardModel c;
    public PersonalCardItemView.b d;
    public PersonalCardCategoryModel.b e;
    public SetPersonalCardModel.b f;
    public BdListView.p g;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.ll5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b012" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements PersonalCardItemView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardCategoryActivity a;

        public a(PersonalCardCategoryActivity personalCardCategoryActivity) {
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
            this.a = personalCardCategoryActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.b
        public void a(dr9 dr9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, dr9Var) != null) || dr9Var == null) {
                return;
            }
            if (dr9Var.a() == dr9.k) {
                if (dr9Var.g() != 1 && this.a.c != null) {
                    this.a.c.W(dr9Var.a(), 1);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.a.getPageContext().getPageActivity(), dr9Var.a())));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements PersonalCardCategoryModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardCategoryActivity a;

        public b(PersonalCardCategoryActivity personalCardCategoryActivity) {
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
            this.a = personalCardCategoryActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel.b
        public void a(int i, String str, is9 is9Var, List<as9> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, is9Var, list, Boolean.valueOf(z)}) == null) {
                PersonalCardCategoryActivity personalCardCategoryActivity = this.a;
                personalCardCategoryActivity.hideLoadingView(personalCardCategoryActivity.a.c());
                if (i != 0) {
                    this.a.showToast(str);
                }
                this.a.a.j(i, is9Var, list, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements SetPersonalCardModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardCategoryActivity a;

        public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
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
            this.a = personalCardCategoryActivity;
        }

        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.b
        public void a(boolean z, long j, int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && z && this.a.b != null) {
                this.a.b.Z(j, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardCategoryActivity a;

        public d(PersonalCardCategoryActivity personalCardCategoryActivity) {
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
            this.a = personalCardCategoryActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.Y();
            }
        }
    }

    public PersonalCardCategoryActivity() {
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
        this.d = new a(this);
        this.e = new b(this);
        this.f = new c(this);
        this.g = new d(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            cs9 cs9Var = this.a;
            if (cs9Var != null) {
                cs9Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public ol5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ol5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
            }
            return pageStayDurationItem;
        }
        return (ol5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            PersonalCardCategoryModel personalCardCategoryModel = this.b;
            if (personalCardCategoryModel != null) {
                personalCardCategoryModel.onDestroy();
            }
            SetPersonalCardModel setPersonalCardModel = this.c;
            if (setPersonalCardModel != null) {
                setPersonalCardModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        cs9 cs9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b != null && (cs9Var = this.a) != null) {
            showLoadingView(cs9Var.c());
            this.b.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            cs9 cs9Var = new cs9(this);
            this.a = cs9Var;
            cs9Var.h(this.g);
            this.a.g(this.d);
            PersonalCardCategoryModel personalCardCategoryModel = new PersonalCardCategoryModel(this);
            this.b = personalCardCategoryModel;
            personalCardCategoryModel.b0(this.e);
            SetPersonalCardModel setPersonalCardModel = new SetPersonalCardModel();
            this.c = setPersonalCardModel;
            setPersonalCardModel.V(this.f);
            showLoadingView(this.a.c());
            this.b.loadData();
        }
    }
}
