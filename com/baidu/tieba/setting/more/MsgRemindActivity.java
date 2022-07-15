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
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kh5;
import com.repackage.kz4;
import com.repackage.lc8;
import com.repackage.mn4;
import com.repackage.pi;
import com.repackage.py4;
import com.repackage.sy4;
import com.repackage.z95;
import java.util.Date;
/* loaded from: classes4.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lc8 a;
    public MsgRemindModel b;
    public final kh5 c;
    public MsgRemindModel.f d;

    /* loaded from: classes4.dex */
    public class a implements kh5 {
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

        @Override // com.repackage.kh5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || this.a.a == null) {
                return;
            }
            py4.d().W(date.getHours(), date.getMinutes());
            this.a.a.I();
            this.a.a.H();
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.a.J();
                } else if (i == 3) {
                    this.a.a.L();
                } else if (i == 1) {
                    this.a.a.N();
                } else if (i == 20) {
                    this.a.a.O();
                } else if (i == 30) {
                    this.a.a.M();
                } else if (i == 10) {
                    this.a.a.P();
                } else if (i == 7) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.a.l().j();
                    } else {
                        this.a.a.l().m();
                    }
                } else if (i == 6) {
                    if (z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921631));
                    } else if (z2) {
                        this.a.a.q().j();
                    } else {
                        this.a.a.q().m();
                    }
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

    public final void B1(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, switchState, i) == null) {
            C1(switchState, i, "");
        }
    }

    public final void C1(BdSwitchView.SwitchState switchState, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, switchState, i, str) == null) {
            int i2 = switchState == BdSwitchView.SwitchState.ON ? 1 : 2;
            StatisticItem param = new StatisticItem("c13889").param("obj_locate", 2).param("obj_type", NotificationManagerCompat.from(this).areNotificationsEnabled() ? 1 : 2);
            StatisticItem param2 = param.param("obj_source", i + "_" + i2);
            if (i == 9 && !TextUtils.isEmpty(str) && switchState == BdSwitchView.SwitchState.ON) {
                param2.param("obj_param1", str);
            }
            TiebaStatic.log(param2);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void j0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, switchState) == null) {
            if (view2 == this.a.t()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    py4.d().V(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.a.I();
                    this.a.F(true);
                } else {
                    py4.d().V(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.a.F(false);
                }
                C1(switchState, 9, this.a.u());
            } else if (view2 == this.a.p()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.F(30, true, this.d);
                } else {
                    this.b.F(30, false, this.d);
                }
                B1(switchState, 10);
            } else if (view2 == this.a.r()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.F(1, true, this.d);
                } else {
                    this.b.F(1, false, this.d);
                }
                B1(switchState, 1);
            } else if (view2 == this.a.w()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.F(20, true, this.d);
                } else {
                    this.b.F(20, false, this.d);
                }
                B1(switchState, 2);
            } else if (view2 == this.a.k()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.F(2, true, this.d);
                } else {
                    this.b.F(2, false, this.d);
                }
                B1(switchState, 4);
            } else if (view2 == this.a.m()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.F(10, true, this.d);
                } else {
                    this.b.F(10, false, this.d);
                }
                B1(switchState, 11);
            } else if (view2 == this.a.o()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.F(3, true, this.d);
                } else {
                    this.b.F(3, false, this.d);
                }
                B1(switchState, 3);
            } else if (view2 == this.a.l()) {
                this.b.F(7, switchState == BdSwitchView.SwitchState.OFF, this.d);
                B1(switchState, 7);
            } else if (view2 == this.a.q()) {
                this.b.F(6, switchState == BdSwitchView.SwitchState.OFF, this.d);
                B1(switchState, 8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.a.s()) {
                sy4.c().l(3, getPageContext(), this.c);
            } else if (view2 == this.a.n()) {
                mn4.c().b();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            lc8 lc8Var = new lc8(this);
            this.a = lc8Var;
            lc8Var.x(this);
            this.b = new MsgRemindModel(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921660));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onNetRefreshButtonClicked();
            kz4.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (!z95.a(this)) {
                this.a.G(false);
                showNetRefreshView(this.a.v(), getString(R.string.obfuscated_res_0x7f0f1609), getString(R.string.obfuscated_res_0x7f0f07ca), getString(R.string.obfuscated_res_0x7f0f07c9), true, getNetRefreshListener());
                setNetRefreshViewPicResId(R.drawable.new_pic_emotion_03);
                setNetRefreshViewEmotionMarginTop(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                return;
            }
            this.a.G(true);
            hideNetRefreshView(this.a.v());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            py4.d().F();
        }
    }
}
