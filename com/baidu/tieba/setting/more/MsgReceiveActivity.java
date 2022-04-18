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
import com.repackage.me8;
import com.repackage.yx4;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OfficialAccountPushModel.b mCallback;
    public MsgRemindModel mModel;
    public MsgRemindModel.e mMsgRemindModelCallback;
    public OfficialAccountPushModel mOfficialPushModel;
    public me8 mView;

    /* loaded from: classes4.dex */
    public class a implements MsgRemindModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgReceiveActivity a;

        public a(MsgReceiveActivity msgReceiveActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgReceiveActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgReceiveActivity;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i == 8) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.mView.j().i();
                        this.a.mView.r(false);
                        this.a.mView.t(false);
                        return;
                    }
                    this.a.mView.j().l();
                    this.a.mView.r(true);
                    this.a.mView.t(true);
                } else if (i == 9) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.mView.l().i();
                    } else {
                        this.a.mView.l().l();
                    }
                } else if (i == 7) {
                    if (z) {
                        yx4.d().S(z2);
                    } else if (z2) {
                        this.a.mView.i().i();
                    } else {
                        this.a.mView.i().l();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements OfficialAccountPushModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgReceiveActivity a;

        public b(MsgReceiveActivity msgReceiveActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgReceiveActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgReceiveActivity;
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, arrayList, i, str) == null) && i == OfficialAccountPushModel.NET_SUCCESS && this.a.mView != null) {
                this.a.mView.s(arrayList);
            }
        }
    }

    public MsgReceiveActivity() {
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
        this.mMsgRemindModelCallback = new a(this);
        this.mCallback = new b(this);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
            if (view2 == this.mView.j()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(8, true, this.mMsgRemindModelCallback);
                    this.mView.r(true);
                    this.mView.t(true);
                    return;
                }
                this.mModel.B(8, false, this.mMsgRemindModelCallback);
                this.mView.r(false);
                this.mView.t(false);
            } else if (view2 == this.mView.l()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(9, true, this.mMsgRemindModelCallback);
                } else {
                    this.mModel.B(9, false, this.mMsgRemindModelCallback);
                }
            } else if (view2 == this.mView.i()) {
                this.mModel.B(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mView.h()) {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            me8 me8Var = new me8(this);
            this.mView = me8Var;
            me8Var.m();
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
            this.mOfficialPushModel.z();
        }
    }
}
