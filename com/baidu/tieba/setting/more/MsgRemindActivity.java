package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.iw4;
import com.baidu.tieba.ka5;
import com.baidu.tieba.o95;
import com.baidu.tieba.q95;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.sm5;
import com.baidu.tieba.tv5;
import com.baidu.tieba.xd9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xd9 a;
    public MsgRemindModel b;
    public final tv5 c;
    public MsgRemindModel.f d;

    /* loaded from: classes6.dex */
    public class a implements tv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        public a(MsgRemindActivity msgRemindActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgRemindActivity;
        }

        @Override // com.baidu.tieba.tv5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) && this.a.a != null) {
                o95.d().c0(date.getHours(), date.getMinutes());
                this.a.a.e0();
                this.a.a.d0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements MsgRemindModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        public b(MsgRemindActivity msgRemindActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgRemindActivity;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.f
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i == 2) {
                    this.a.a.f0();
                } else if (i == 3) {
                    this.a.a.h0();
                } else if (i == 1) {
                    this.a.a.k0();
                } else if (i == 20) {
                    this.a.a.l0();
                } else if (i == 30) {
                    this.a.a.j0();
                } else if (i == 10) {
                    this.a.a.n0();
                } else if (i == 35) {
                    this.a.a.m0();
                } else if (i == 7) {
                    if (!z) {
                        if (z2) {
                            this.a.a.C().j();
                        } else {
                            this.a.a.C().m();
                        }
                    }
                } else if (i == 6) {
                    if (!z) {
                        if (z2) {
                            this.a.a.J().j();
                            return;
                        } else {
                            this.a.a.J().m();
                            return;
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921631));
                } else if (i == 33) {
                    if (!z) {
                        if (z2) {
                            this.a.a.D().j();
                        } else {
                            this.a.a.D().m();
                        }
                    }
                } else if (i == 34) {
                    this.a.a.g0();
                }
            }
        }
    }

    public MsgRemindActivity() {
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
        this.c = new a(this);
        this.d = new b(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921660));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onNetRefreshButtonClicked();
            ka5.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
            o95.d().I();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            xd9 xd9Var = new xd9(this);
            this.a = xd9Var;
            xd9Var.R(this);
            this.b = new MsgRemindModel(getPageContext());
        }
    }

    public final void A1(BdSwitchView.SwitchState switchState, int i, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, switchState, i, str) == null) {
            int i3 = 1;
            if (switchState == BdSwitchView.SwitchState.ON) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
            StatisticItem param = new StatisticItem("c13889").param("obj_locate", 2);
            if (!areNotificationsEnabled) {
                i3 = 2;
            }
            StatisticItem param2 = param.param("obj_type", i3);
            StatisticItem param3 = param2.param("obj_source", i + "_" + i2).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (i == 9 && !TextUtils.isEmpty(str) && switchState == BdSwitchView.SwitchState.ON) {
                param3.param("obj_param1", str);
            }
            TiebaStatic.log(param3);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void c0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, switchState) == null) {
            boolean z = false;
            if (view2 == this.a.N()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    o95.d().b0(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.a.e0();
                    this.a.b0(true);
                } else {
                    o95.d().b0(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.a.b0(false);
                }
                A1(switchState, 9, this.a.O());
            } else if (view2 == this.a.I()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.V(30, true, this.d);
                } else {
                    this.b.V(30, false, this.d);
                }
                z1(switchState, 10);
            } else if (view2 == this.a.K()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.V(1, true, this.d);
                } else {
                    this.b.V(1, false, this.d);
                }
                z1(switchState, 1);
            } else if (view2 == this.a.Q()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.V(20, true, this.d);
                } else {
                    this.b.V(20, false, this.d);
                }
                z1(switchState, 2);
            } else if (view2 == this.a.A()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.V(2, true, this.d);
                } else {
                    this.b.V(2, false, this.d);
                }
                z1(switchState, 4);
            } else if (view2 == this.a.E()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.V(10, true, this.d);
                } else {
                    this.b.V(10, false, this.d);
                }
                z1(switchState, 11);
            } else if (view2 == this.a.F()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.V(35, true, this.d);
                } else {
                    this.b.V(35, false, this.d);
                }
                z1(switchState, 35);
            } else if (view2 == this.a.H()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.V(3, true, this.d);
                } else {
                    this.b.V(3, false, this.d);
                }
                z1(switchState, 3);
            } else if (view2 == this.a.C()) {
                MsgRemindModel msgRemindModel = this.b;
                if (switchState == BdSwitchView.SwitchState.OFF) {
                    z = true;
                }
                msgRemindModel.V(7, z, this.d);
                z1(switchState, 7);
            } else if (view2 == this.a.J()) {
                MsgRemindModel msgRemindModel2 = this.b;
                if (switchState == BdSwitchView.SwitchState.OFF) {
                    z = true;
                }
                msgRemindModel2.V(6, z, this.d);
                z1(switchState, 8);
            } else if (view2 == this.a.D()) {
                MsgRemindModel msgRemindModel3 = this.b;
                if (switchState == BdSwitchView.SwitchState.ON) {
                    z = true;
                }
                msgRemindModel3.V(33, z, this.d);
                z1(switchState, 13);
            } else if (view2 == this.a.B()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.V(34, true, this.d);
                } else {
                    this.b.V(34, false, this.d);
                }
                z1(switchState, 15);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.a.M()) {
                q95.c().k(3, getPageContext(), this.c, false);
            } else if (view2 == this.a.G()) {
                iw4.c().b();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            boolean a2 = sm5.a(this);
            if (getIntent() != null && getIntent().getBooleanExtra("not_need_account", false)) {
                return;
            }
            if (!a2) {
                this.a.c0(false);
                showNetRefreshView(this.a.P(), getString(R.string.obfuscated_res_0x7f0f1746), getString(R.string.obfuscated_res_0x7f0f0839), getString(R.string.go_to_open), true, getNetRefreshListener());
                setNetRefreshViewPicResId(R.drawable.new_pic_emotion_03);
                setNetRefreshViewEmotionMarginTop(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                return;
            }
            this.a.c0(true);
            hideNetRefreshView(this.a.P());
        }
    }

    public final void z1(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, switchState, i) == null) {
            A1(switchState, i, "");
        }
    }
}
