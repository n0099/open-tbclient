package com.baidu.tieba.themeCenter.avatarPendant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.rd9;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel;
import com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.via;
import com.baidu.tieba.wia;
import com.baidu.tieba.xia;
import com.baidu.tieba.zia;
import com.baidu.tieba.zja;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class AvatarPendantActivity extends BaseActivity implements zia.a, SetAvatarPendantModel.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zia a;
    public AvatarPendantModel b;
    public SetAvatarPendantModel c;
    public String d;
    public boolean e;
    public AvatarPendantModel.b f;
    public NoNetworkView.b g;

    /* loaded from: classes8.dex */
    public class a implements AvatarPendantModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AvatarPendantActivity a;

        public a(AvatarPendantActivity avatarPendantActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {avatarPendantActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = avatarPendantActivity;
        }

        @Override // com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel.b
        public void a(int i, String str, zja zjaVar, List<xia> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, zjaVar, list}) == null) {
                AvatarPendantActivity avatarPendantActivity = this.a;
                avatarPendantActivity.hideLoadingView(avatarPendantActivity.a.B());
                if (i != 0) {
                    this.a.showToast(str);
                    this.a.a.H();
                } else {
                    this.a.a.I(zjaVar, list);
                }
                this.a.e = !ListUtils.isEmpty(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AvatarPendantActivity a;

        public b(AvatarPendantActivity avatarPendantActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {avatarPendantActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = avatarPendantActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void j(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                BdListViewHelper.c(this.a.a.C(), BdListViewHelper.HeadType.DEFAULT, z);
            }
        }
    }

    public AvatarPendantActivity() {
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
        this.d = "";
        this.f = new a(this);
        this.g = new b(this);
    }

    public final boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            TiebaStatic.log("c11615");
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11041)));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.D();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            y1();
            initData();
            showLoadingView(this.a.B());
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.zia.a
    public void O0(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dressItemData) == null) && w1() && dressItemData != null && dressItemData.getPropsId() >= 0 && this.e) {
            this.d = x1(dressItemData);
            TiebaStatic.log(new StatisticItem("c11614").param("obj_type", this.d));
            this.c.a0(dressItemData.getPropsId(), 1, dressItemData.getFreeUserLevel());
        }
    }

    @Override // com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel.b
    public void g1(boolean z, long j, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            if (!z) {
                z1(i2, str, i);
                return;
            }
            List<xia> a0 = this.b.a0();
            if (a0 != null && a0.size() > 0) {
                if (i == 0) {
                    TiebaStatic.log("c11681");
                } else {
                    TiebaStatic.log("c11682");
                }
                int size = a0.size();
                String str2 = "";
                for (int i3 = 0; i3 < size; i3++) {
                    if (a0.get(i3) != null && !ListUtils.isEmpty(a0.get(i3).b())) {
                        List<DressItemData> b2 = a0.get(i3).b();
                        int size2 = b2.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            if (b2.get(i4) != null && j == b2.get(i4).getPropsId()) {
                                b2.get(i4).setInUse(true);
                                str2 = b2.get(i4).getExampleImgUrl();
                            } else {
                                b2.get(i4).setInUse(false);
                            }
                        }
                    }
                }
                UserPendantData userPendantData = new UserPendantData();
                userPendantData.setPropsId(j);
                userPendantData.setImgUrl(str2);
                this.a.E(this.b.a0());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016485, userPendantData));
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AvatarPendantModel avatarPendantModel = new AvatarPendantModel(this);
            this.b = avatarPendantModel;
            avatarPendantModel.c0(this.f);
            SetAvatarPendantModel setAvatarPendantModel = new SetAvatarPendantModel();
            this.c = setAvatarPendantModel;
            setAvatarPendantModel.c0(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            this.c.onDestroy();
            this.b.b0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        zia ziaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.b != null && (ziaVar = this.a) != null) {
            showLoadingView(ziaVar.B());
            this.b.loadData();
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            zia ziaVar = new zia(this);
            this.a = ziaVar;
            ziaVar.x(this.g);
            this.a.G(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 11041) {
                this.b.loadData();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2 == this.a.z().getButton() && w1()) {
            TiebaStatic.log("c11613");
            rd9.d(getPageContext(), 2015, MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
        }
    }

    public final String x1(DressItemData dressItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, dressItemData)) == null) {
            String str = "";
            if (dressItemData == null) {
                return "";
            }
            List<xia> a0 = this.b.a0();
            if (a0 != null && a0.size() > 0) {
                int size = a0.size();
                for (int i = 0; i < size; i++) {
                    if (a0.get(i) != null && !ListUtils.isEmpty(a0.get(i).b())) {
                        List<DressItemData> b2 = a0.get(i).b();
                        int size2 = b2.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size2) {
                                break;
                            }
                            if (b2.get(i2) != null && dressItemData.getPropsId() == b2.get(i2).getPropsId()) {
                                str = a0.get(i).a();
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void z1(int i, String str, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            if (i2 == 101) {
                i3 = 9;
            } else {
                i3 = 0;
            }
            if (!StringUtils.isNull(str)) {
                if (i == wia.a) {
                    via.d(getPageContext(), 7, str, i3, MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
                } else if (i == wia.b) {
                    via.c(getPageContext(), 7, str, i3);
                }
            }
        }
    }
}
