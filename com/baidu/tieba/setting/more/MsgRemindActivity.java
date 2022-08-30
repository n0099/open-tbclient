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
import com.baidu.tieba.cf8;
import com.baidu.tieba.fb5;
import com.baidu.tieba.gj5;
import com.baidu.tieba.go4;
import com.baidu.tieba.l05;
import com.baidu.tieba.pz4;
import com.baidu.tieba.ri;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.sz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cf8 a;
    public MsgRemindModel b;
    public final gj5 c;
    public MsgRemindModel.f d;

    /* loaded from: classes5.dex */
    public class a implements gj5 {
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

        @Override // com.baidu.tieba.gj5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || this.a.a == null) {
                return;
            }
            pz4.d().Y(date.getHours(), date.getMinutes());
            this.a.a.O();
            this.a.a.N();
        }
    }

    /* loaded from: classes5.dex */
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
                    this.a.a.P();
                } else if (i == 3) {
                    this.a.a.Q();
                } else if (i == 1) {
                    this.a.a.S();
                } else if (i == 20) {
                    this.a.a.T();
                } else if (i == 30) {
                    this.a.a.R();
                } else if (i == 10) {
                    this.a.a.U();
                } else if (i == 7) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.a.o().j();
                    } else {
                        this.a.a.o().m();
                    }
                } else if (i == 6) {
                    if (z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921631));
                    } else if (z2) {
                        this.a.a.u().j();
                    } else {
                        this.a.a.u().m();
                    }
                } else if (i != 33 || z) {
                } else {
                    if (z2) {
                        this.a.a.p().j();
                    } else {
                        this.a.a.p().m();
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

    public final void A1(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, switchState, i) == null) {
            B1(switchState, i, "");
        }
    }

    public final void B1(BdSwitchView.SwitchState switchState, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, switchState, i, str) == null) {
            int i2 = switchState == BdSwitchView.SwitchState.ON ? 1 : 2;
            StatisticItem param = new StatisticItem("c13889").param("obj_locate", 2).param("obj_type", NotificationManagerCompat.from(this).areNotificationsEnabled() ? 1 : 2);
            StatisticItem param2 = param.param("obj_source", i + "_" + i2).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (i == 9 && !TextUtils.isEmpty(str) && switchState == BdSwitchView.SwitchState.ON) {
                param2.param("obj_param1", str);
            }
            TiebaStatic.log(param2);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void i0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, switchState) == null) {
            if (view2 == this.a.x()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    pz4.d().X(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.a.O();
                    this.a.L(true);
                } else {
                    pz4.d().X(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.a.L(false);
                }
                B1(switchState, 9, this.a.y());
            } else if (view2 == this.a.t()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.E(30, true, this.d);
                } else {
                    this.b.E(30, false, this.d);
                }
                A1(switchState, 10);
            } else if (view2 == this.a.v()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.E(1, true, this.d);
                } else {
                    this.b.E(1, false, this.d);
                }
                A1(switchState, 1);
            } else if (view2 == this.a.A()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.E(20, true, this.d);
                } else {
                    this.b.E(20, false, this.d);
                }
                A1(switchState, 2);
            } else if (view2 == this.a.n()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.E(2, true, this.d);
                } else {
                    this.b.E(2, false, this.d);
                }
                A1(switchState, 4);
            } else if (view2 == this.a.q()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.E(10, true, this.d);
                } else {
                    this.b.E(10, false, this.d);
                }
                A1(switchState, 11);
            } else if (view2 == this.a.s()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.b.E(3, true, this.d);
                } else {
                    this.b.E(3, false, this.d);
                }
                A1(switchState, 3);
            } else if (view2 == this.a.o()) {
                this.b.E(7, switchState == BdSwitchView.SwitchState.OFF, this.d);
                A1(switchState, 7);
            } else if (view2 == this.a.u()) {
                this.b.E(6, switchState == BdSwitchView.SwitchState.OFF, this.d);
                A1(switchState, 8);
            } else if (view2 == this.a.p()) {
                this.b.E(33, switchState == BdSwitchView.SwitchState.ON, this.d);
                A1(switchState, 13);
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
            if (view2 == this.a.w()) {
                sz4.c().k(3, getPageContext(), this.c);
            } else if (view2 == this.a.r()) {
                go4.c().b();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            cf8 cf8Var = new cf8(this);
            this.a = cf8Var;
            cf8Var.B(this);
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
            l05.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (!fb5.a(this)) {
                this.a.M(false);
                showNetRefreshView(this.a.z(), getString(R.string.obfuscated_res_0x7f0f1608), getString(R.string.obfuscated_res_0x7f0f07d9), getString(R.string.obfuscated_res_0x7f0f07d8), true, getNetRefreshListener());
                setNetRefreshViewPicResId(R.drawable.new_pic_emotion_03);
                setNetRefreshViewEmotionMarginTop(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                return;
            }
            this.a.M(true);
            hideNetRefreshView(this.a.z());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            pz4.d().G();
        }
    }
}
