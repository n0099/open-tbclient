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
import com.baidu.tieba.bl5;
import com.baidu.tieba.ej;
import com.baidu.tieba.i95;
import com.baidu.tieba.m85;
import com.baidu.tieba.o85;
import com.baidu.tieba.ov8;
import com.baidu.tieba.qt5;
import com.baidu.tieba.rw4;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ov8 a;
    public MsgRemindModel b;
    public final qt5 c;
    public MsgRemindModel.f d;

    /* loaded from: classes6.dex */
    public class a implements qt5 {
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

        @Override // com.baidu.tieba.qt5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) && this.a.a != null) {
                m85.d().a0(date.getHours(), date.getMinutes());
                this.a.a.R();
                this.a.a.Q();
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
                    this.a.a.S();
                } else if (i == 3) {
                    this.a.a.U();
                } else if (i == 1) {
                    this.a.a.W();
                } else if (i == 20) {
                    this.a.a.X();
                } else if (i == 30) {
                    this.a.a.V();
                } else if (i == 10) {
                    this.a.a.Y();
                } else if (i == 7) {
                    if (!z) {
                        if (z2) {
                            this.a.a.q().j();
                        } else {
                            this.a.a.q().m();
                        }
                    }
                } else if (i == 6) {
                    if (!z) {
                        if (z2) {
                            this.a.a.w().j();
                            return;
                        } else {
                            this.a.a.w().m();
                            return;
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921631));
                } else if (i == 33) {
                    if (!z) {
                        if (z2) {
                            this.a.a.r().j();
                        } else {
                            this.a.a.r().m();
                        }
                    }
                } else if (i == 34) {
                    this.a.a.T();
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
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921660));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onNetRefreshButtonClicked();
            i95.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStop();
            m85.d().H();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            ov8 ov8Var = new ov8(this);
            this.a = ov8Var;
            ov8Var.D(this);
            this.b = new MsgRemindModel(getPageContext());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void d0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
            boolean z = false;
            if (view2 == this.a.z()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    m85.d().Z(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.a.R();
                    this.a.O(true);
                } else {
                    m85.d().Z(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.a.O(false);
                }
                y1(switchState, 9, this.a.A());
            } else if (view2 == this.a.v()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.L(30, true, this.d);
                } else {
                    this.b.L(30, false, this.d);
                }
                x1(switchState, 10);
            } else if (view2 == this.a.x()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.L(1, true, this.d);
                } else {
                    this.b.L(1, false, this.d);
                }
                x1(switchState, 1);
            } else if (view2 == this.a.C()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.L(20, true, this.d);
                } else {
                    this.b.L(20, false, this.d);
                }
                x1(switchState, 2);
            } else if (view2 == this.a.o()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.L(2, true, this.d);
                } else {
                    this.b.L(2, false, this.d);
                }
                x1(switchState, 4);
            } else if (view2 == this.a.s()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.L(10, true, this.d);
                } else {
                    this.b.L(10, false, this.d);
                }
                x1(switchState, 11);
            } else if (view2 == this.a.u()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.L(3, true, this.d);
                } else {
                    this.b.L(3, false, this.d);
                }
                x1(switchState, 3);
            } else if (view2 == this.a.q()) {
                MsgRemindModel msgRemindModel = this.b;
                if (switchState == BdSwitchView.SwitchState.OFF) {
                    z = true;
                }
                msgRemindModel.L(7, z, this.d);
                x1(switchState, 7);
            } else if (view2 == this.a.w()) {
                MsgRemindModel msgRemindModel2 = this.b;
                if (switchState == BdSwitchView.SwitchState.OFF) {
                    z = true;
                }
                msgRemindModel2.L(6, z, this.d);
                x1(switchState, 8);
            } else if (view2 == this.a.r()) {
                MsgRemindModel msgRemindModel3 = this.b;
                if (switchState == BdSwitchView.SwitchState.ON) {
                    z = true;
                }
                msgRemindModel3.L(33, z, this.d);
                x1(switchState, 13);
            } else if (view2 == this.a.p()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.L(34, true, this.d);
                } else {
                    this.b.L(34, false, this.d);
                }
                x1(switchState, 15);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.a.y()) {
                o85.c().k(3, getPageContext(), this.c, false);
            } else if (view2 == this.a.t()) {
                rw4.c().b();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            boolean a2 = bl5.a(this);
            if (getIntent() != null && getIntent().getBooleanExtra("not_need_account", false)) {
                return;
            }
            if (!a2) {
                this.a.P(false);
                showNetRefreshView(this.a.B(), getString(R.string.obfuscated_res_0x7f0f1736), getString(R.string.obfuscated_res_0x7f0f083c), getString(R.string.go_to_open), true, getNetRefreshListener());
                setNetRefreshViewPicResId(R.drawable.new_pic_emotion_03);
                setNetRefreshViewEmotionMarginTop(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                return;
            }
            this.a.P(true);
            hideNetRefreshView(this.a.B());
        }
    }

    public final void x1(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, switchState, i) == null) {
            y1(switchState, i, "");
        }
    }

    public final void y1(BdSwitchView.SwitchState switchState, int i, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, switchState, i, str) == null) {
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
}
