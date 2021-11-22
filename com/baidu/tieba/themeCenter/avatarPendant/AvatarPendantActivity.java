package com.baidu.tieba.themeCenter.avatarPendant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.s3.d.c;
import b.a.r0.s3.h.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel;
import com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class AvatarPendantActivity extends BaseActivity implements c.a, SetAvatarPendantModel.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AvatarPendantModel.b mCallback;
    public String mCurrentCategory;
    public boolean mHasListData;
    public AvatarPendantModel mModel;
    public NoNetworkView.b mNetListener;
    public SetAvatarPendantModel mSetAvatarPendantModel;
    public c mView;

    /* loaded from: classes9.dex */
    public class a implements AvatarPendantModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AvatarPendantActivity f55422a;

        public a(AvatarPendantActivity avatarPendantActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {avatarPendantActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55422a = avatarPendantActivity;
        }

        @Override // com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel.b
        public void a(int i2, String str, e eVar, List<b.a.r0.s3.d.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, eVar, list}) == null) {
                AvatarPendantActivity avatarPendantActivity = this.f55422a;
                avatarPendantActivity.hideLoadingView(avatarPendantActivity.mView.f());
                if (i2 == 0) {
                    this.f55422a.mView.m(eVar, list);
                } else {
                    this.f55422a.showToast(str);
                    this.f55422a.mView.l();
                }
                this.f55422a.mHasListData = !ListUtils.isEmpty(list);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AvatarPendantActivity f55423e;

        public b(AvatarPendantActivity avatarPendantActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {avatarPendantActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55423e = avatarPendantActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                BdListViewHelper.c(this.f55423e.mView.g(), BdListViewHelper.HeadType.DEFAULT, z);
            }
        }
    }

    public AvatarPendantActivity() {
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
        this.mCurrentCategory = "";
        this.mCallback = new a(this);
        this.mNetListener = new b(this);
    }

    private boolean checkLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            TiebaStatic.log("c11615");
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11041)));
            return false;
        }
        return invokeV.booleanValue;
    }

    private String getCurrentCategory(DressItemData dressItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dressItemData)) == null) {
            String str = "";
            if (dressItemData == null) {
                return "";
            }
            List<b.a.r0.s3.d.a> B = this.mModel.B();
            if (B != null && B.size() > 0) {
                int size = B.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (B.get(i2) != null && !ListUtils.isEmpty(B.get(i2).b())) {
                        List<DressItemData> b2 = B.get(i2).b();
                        int size2 = b2.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size2) {
                                break;
                            }
                            if (b2.get(i3) != null && dressItemData.getPropsId() == b2.get(i3).getPropsId()) {
                                str = B.get(i2).a();
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            AvatarPendantModel avatarPendantModel = new AvatarPendantModel(this);
            this.mModel = avatarPendantModel;
            avatarPendantModel.D(this.mCallback);
            SetAvatarPendantModel setAvatarPendantModel = new SetAvatarPendantModel();
            this.mSetAvatarPendantModel = setAvatarPendantModel;
            setAvatarPendantModel.D(this);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            c cVar = new c(this);
            this.mView = cVar;
            cVar.c(this.mNetListener);
            this.mView.k(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 11041) {
                this.mModel.loadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mView.h();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && view == this.mView.e().getButton() && checkLogin()) {
            TiebaStatic.log("c11613");
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 22);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            initUI();
            initData();
            showLoadingView(this.mView.f());
            this.mModel.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.mSetAvatarPendantModel.onDestroy();
            this.mModel.C();
        }
    }

    @Override // b.a.r0.s3.d.c.a
    public void onItemClick(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dressItemData) == null) && checkLogin() && dressItemData != null && dressItemData.getPropsId() >= 0 && this.mHasListData) {
            this.mCurrentCategory = getCurrentCategory(dressItemData);
            TiebaStatic.log(new StatisticItem("c11614").param("obj_type", this.mCurrentCategory));
            this.mSetAvatarPendantModel.B(dressItemData.getPropsId(), 1, dressItemData.getFreeUserLevel());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.mModel == null || (cVar = this.mView) == null) {
            return;
        }
        showLoadingView(cVar.f());
        this.mModel.loadData();
    }

    @Override // com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel.b
    public void onSetPendantCallback(boolean z, long j, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            if (!z) {
                showErrorDialog(i3, str, i2);
                return;
            }
            List<b.a.r0.s3.d.a> B = this.mModel.B();
            if (B == null || B.size() <= 0) {
                return;
            }
            if (i2 == 0) {
                TiebaStatic.log("c11681");
            } else {
                TiebaStatic.log("c11682");
            }
            int size = B.size();
            String str2 = "";
            for (int i4 = 0; i4 < size; i4++) {
                if (B.get(i4) != null && !ListUtils.isEmpty(B.get(i4).b())) {
                    List<DressItemData> b2 = B.get(i4).b();
                    int size2 = b2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        if (b2.get(i5) != null && j == b2.get(i5).getPropsId()) {
                            b2.get(i5).setInUse(true);
                            str2 = b2.get(i5).getExampleImgUrl();
                        } else {
                            b2.get(i5).setInUse(false);
                        }
                    }
                }
            }
            UserPendantData userPendantData = new UserPendantData();
            userPendantData.setPropsId(j);
            userPendantData.setImgUrl(str2);
            this.mView.i(this.mModel.B());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016485, userPendantData));
        }
    }

    public void showErrorDialog(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            int i4 = i3 == 101 ? 9 : 0;
            if (StringUtils.isNull(str)) {
                return;
            }
            if (i2 == b.a.r0.s3.c.f24866a) {
                b.a.r0.s3.b.d(getPageContext(), 7, str, i4, MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            } else if (i2 == b.a.r0.s3.c.f24867b) {
                b.a.r0.s3.b.c(getPageContext(), 7, str, i4);
            }
        }
    }
}
