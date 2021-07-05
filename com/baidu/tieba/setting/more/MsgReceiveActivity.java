package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.s.d.d;
import d.a.s0.z2.c.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OfficialAccountPushModel.b mCallback;
    public MsgRemindModel mModel;
    public MsgRemindModel.e mMsgRemindModelCallback;
    public OfficialAccountPushModel mOfficialPushModel;
    public f mView;

    /* loaded from: classes5.dex */
    public class a implements MsgRemindModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgReceiveActivity f20742a;

        public a(MsgReceiveActivity msgReceiveActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgReceiveActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20742a = msgReceiveActivity;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i2 == 8) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.f20742a.mView.k().h();
                        this.f20742a.mView.q(false);
                        this.f20742a.mView.s(false);
                        return;
                    }
                    this.f20742a.mView.k().k();
                    this.f20742a.mView.q(true);
                    this.f20742a.mView.s(true);
                } else if (i2 == 9) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.f20742a.mView.m().h();
                    } else {
                        this.f20742a.mView.m().k();
                    }
                } else if (i2 == 7) {
                    if (z) {
                        d.d().P(z2);
                    } else if (z2) {
                        this.f20742a.mView.i().h();
                    } else {
                        this.f20742a.mView.i().k();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements OfficialAccountPushModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgReceiveActivity f20743a;

        public b(MsgReceiveActivity msgReceiveActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgReceiveActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20743a = msgReceiveActivity;
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, arrayList, i2, str) == null) && i2 == OfficialAccountPushModel.NET_SUCCESS && this.f20743a.mView != null) {
                this.f20743a.mView.r(arrayList);
            }
        }
    }

    public MsgReceiveActivity() {
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
        this.mMsgRemindModelCallback = new a(this);
        this.mCallback = new b(this);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
            if (view == this.mView.k()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(8, true, this.mMsgRemindModelCallback);
                    this.mView.q(true);
                    this.mView.s(true);
                    return;
                }
                this.mModel.z(8, false, this.mMsgRemindModelCallback);
                this.mView.q(false);
                this.mView.s(false);
            } else if (view == this.mView.m()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(9, true, this.mMsgRemindModelCallback);
                } else {
                    this.mModel.z(9, false, this.mMsgRemindModelCallback);
                }
            } else if (view == this.mView.i()) {
                this.mModel.z(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.onClick(view);
            if (view == this.mView.h()) {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            f fVar = new f(this);
            this.mView = fVar;
            fVar.n();
            this.mModel = new MsgRemindModel(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            OfficialAccountPushModel officialAccountPushModel = this.mOfficialPushModel;
            if (officialAccountPushModel != null) {
                officialAccountPushModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            if (this.mOfficialPushModel == null) {
                this.mOfficialPushModel = new OfficialAccountPushModel(this.mCallback);
            }
            this.mOfficialPushModel.x();
        }
    }
}
