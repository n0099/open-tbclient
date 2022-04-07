package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.by4;
import com.repackage.dr4;
import com.repackage.ge8;
import com.repackage.jw8;
import com.repackage.pg;
import com.repackage.pn4;
import com.repackage.ty4;
import com.repackage.xf5;
import com.repackage.zx4;
import java.util.Date;
/* loaded from: classes4.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgRemindModel.e callback;
    public MsgRemindModel mModel;
    public MsgRemindModel.e mMsgRemindModelCallback;
    public ge8 mView;
    public final xf5 onTimeSelectListener;

    /* loaded from: classes4.dex */
    public class a implements MsgRemindModel.e {
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

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i == 8) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.mView.o().i();
                        this.a.mView.Z(false);
                        this.a.mView.e0(false);
                        return;
                    }
                    this.a.mView.o().l();
                    this.a.mView.Z(true);
                    this.a.mView.e0(true);
                } else if (i == 9) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.mView.H().i();
                    } else {
                        this.a.mView.H().l();
                    }
                } else if (i == 7) {
                    if (z) {
                        zx4.d().S(z2);
                    } else if (z2) {
                        this.a.mView.n().i();
                    } else {
                        this.a.mView.n().l();
                    }
                } else if (i == 6) {
                    if (z) {
                        zx4.d().R(z2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921631));
                    } else if (z2) {
                        this.a.mView.z().i();
                    } else {
                        this.a.mView.z().l();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        public c(MsgRemindActivity msgRemindActivity) {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                ty4.c(this.a.getPageContext());
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        public d(MsgRemindActivity msgRemindActivity) {
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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                StatisticItem statisticItem = new StatisticItem("c13673");
                statisticItem.param("obj_source", 8);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements xf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        public e(MsgRemindActivity msgRemindActivity) {
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

        @Override // com.repackage.xf5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || this.a.mView == null) {
                return;
            }
            zx4.d().V(date.getHours(), date.getMinutes());
            this.a.mView.h0();
            this.a.mView.f0();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ MsgRemindActivity b;

        public f(MsgRemindActivity msgRemindActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = msgRemindActivity;
            this.a = i;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) || timePicker == null) {
                return;
            }
            timePicker.clearFocus();
            boolean z = this.a == R.id.obfuscated_res_0x7f091589;
            StringBuilder sb = new StringBuilder();
            sb.append(timePicker.getCurrentHour().intValue() < 10 ? "0" : "");
            sb.append(timePicker.getCurrentHour());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(timePicker.getCurrentMinute().intValue() >= 10 ? "" : "0");
            sb3.append(timePicker.getCurrentMinute());
            String str = sb2 + ":" + sb3.toString();
            if (z) {
                zx4.d().Q(str);
            } else {
                zx4.d().O(str);
            }
            this.b.mView.g0();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements MsgRemindModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ BdSwitchView b;

            public a(g gVar, boolean z, BdSwitchView bdSwitchView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Boolean.valueOf(z), bdSwitchView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = z;
                this.b = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a) {
                        this.b.l();
                    } else {
                        this.b.i();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ BdSwitchView b;

            public b(g gVar, boolean z, BdSwitchView bdSwitchView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Boolean.valueOf(z), bdSwitchView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = z;
                this.b = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a) {
                        this.b.i();
                    } else {
                        this.b.l();
                    }
                }
            }
        }

        public g(MsgRemindActivity msgRemindActivity) {
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

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i == 14) {
                    BdSwitchView r = this.a.mView.r();
                    if (!z) {
                        if (r != null) {
                            pg.a().postDelayed(new b(this, z2, r), 500L);
                            return;
                        }
                        return;
                    }
                    if (z2) {
                        zx4.d().H(300);
                        this.a.mView.b0(true);
                    } else {
                        zx4.d().H(0);
                        this.a.mView.b0(false);
                    }
                    if (r != null) {
                        pg.a().postDelayed(new a(this, z2, r), 500L);
                    }
                } else if (i == 2) {
                    if (z) {
                        zx4.d().F(z2);
                    }
                    this.a.mView.i0();
                } else if (i == 3) {
                    if (z) {
                        zx4.d().J(z2);
                    }
                    this.a.mView.l0();
                } else if (i == 4) {
                    if (z) {
                        zx4.d().E(z2);
                        if (!z2) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                        }
                    }
                    this.a.mView.k0();
                } else if (i == 5) {
                    if (z) {
                        zx4.d().G(z2);
                    }
                    this.a.mView.j0();
                } else if (i == 1) {
                    if (z) {
                        zx4.d().K(z2);
                    }
                    this.a.mView.m0();
                } else if (i == 20) {
                    if (z) {
                        zx4.d().N(z2);
                    }
                    this.a.mView.n0();
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
        this.mMsgRemindModelCallback = new a(this);
        this.onTimeSelectListener = new e(this);
        this.callback = new g(this);
    }

    private void doMsgSwitchStat(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, switchState, i) == null) {
            TiebaStatic.log(new StatisticItem("c13889").param("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).param("obj_source", i));
        }
    }

    private void showPushPermissionGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            dr4 dr4Var = new dr4(this);
            dr4Var.setTitle(R.string.obfuscated_res_0x7f0f0f12);
            dr4Var.setTitleShowCenter(true);
            dr4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f0f11));
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new b(this));
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07b4, new c(this));
            dr4Var.setOnDismissListener(new d(this));
            dr4Var.create(getPageContext()).show();
            StatisticItem statisticItem = new StatisticItem("c13674");
            statisticItem.param("obj_source", 8);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
            if (view2 == this.mView.G()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    zx4.d().U(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.mView.h0();
                    this.mView.d0(true);
                } else {
                    zx4.d().U(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.mView.d0(false);
                }
                doMsgSwitchStat(switchState, 7);
            } else if (view2 == this.mView.r()) {
                this.mModel.B(14, switchState == BdSwitchView.SwitchState.ON, this.callback);
            } else if (view2 == this.mView.y()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    zx4.d().P(true);
                    this.mView.c0(true);
                    return;
                }
                zx4.d().P(false);
                this.mView.c0(false);
            } else if (view2 == this.mView.C()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    zx4.d().L(true);
                } else {
                    zx4.d().L(false);
                }
            } else if (view2 == this.mView.D()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    zx4.d().M(true);
                } else {
                    zx4.d().M(false);
                }
            } else if (view2 == this.mView.A()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    zx4.d().I(true);
                } else {
                    zx4.d().I(false);
                }
            } else if (view2 == this.mView.B()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    zx4.d().T(true);
                } else {
                    zx4.d().T(false);
                }
            } else if (view2 == this.mView.E()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(1, true, this.callback);
                } else {
                    this.mModel.B(1, false, this.callback);
                }
                doMsgSwitchStat(switchState, 1);
            } else if (view2 == this.mView.I()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(20, true, this.callback);
                } else {
                    this.mModel.B(20, false, this.callback);
                }
                doMsgSwitchStat(switchState, 2);
            } else if (view2 == this.mView.k()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(2, true, this.callback);
                } else {
                    this.mModel.B(2, false, this.callback);
                }
                doMsgSwitchStat(switchState, 3);
            } else if (view2 == this.mView.m()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(5, true, this.callback);
                } else {
                    this.mModel.B(5, false, this.callback);
                }
            } else if (view2 == this.mView.p()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(4, true, this.callback);
                } else {
                    this.mModel.B(4, false, this.callback);
                }
            } else if (view2 == this.mView.u()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(3, true, this.callback);
                } else {
                    this.mModel.B(3, false, this.callback);
                }
                doMsgSwitchStat(switchState, 4);
            } else if (view2 == this.mView.o()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(8, true, this.mMsgRemindModelCallback);
                    this.mView.Z(true);
                    this.mView.e0(true);
                } else {
                    this.mModel.B(8, false, this.mMsgRemindModelCallback);
                    this.mView.Z(false);
                    this.mView.e0(false);
                }
                doMsgSwitchStat(switchState, 5);
            } else if (view2 == this.mView.H()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(9, true, this.mMsgRemindModelCallback);
                } else {
                    this.mModel.B(9, false, this.mMsgRemindModelCallback);
                }
                doMsgSwitchStat(switchState, 6);
            } else if (view2 == this.mView.n()) {
                this.mModel.B(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
                doMsgSwitchStat(switchState, 9);
            } else if (view2 == this.mView.z()) {
                this.mModel.B(6, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mView.l().performClick();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mView.l()) {
                ge8 ge8Var = this.mView;
                if (ge8Var.B) {
                    finish();
                } else {
                    ge8Var.a0(true);
                }
            } else if (view2 == this.mView.F()) {
                by4.c().l(getPageContext(), this.onTimeSelectListener);
            } else if (view2 == this.mView.w()) {
                this.mView.a0(false);
            } else if (view2 == this.mView.x()) {
                showDialog(R.id.obfuscated_res_0x7f091589);
            } else if (view2 == this.mView.v()) {
                showDialog(R.id.obfuscated_res_0x7f091583);
            } else if (view2 == this.mView.s()) {
                TiebaStatic.log(new StatisticItem("c13286").param("uid", TbadkCoreApplication.getCurrentAccount()));
                sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
            } else if (view2 == this.mView.t()) {
                pn4.c().b();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091e18) {
                showPushPermissionGuide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            ge8 ge8Var = new ge8(this);
            this.mView = ge8Var;
            ge8Var.K(this);
            this.mModel = new MsgRemindModel(this);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i == R.id.obfuscated_res_0x7f091583 || i == R.id.obfuscated_res_0x7f091589) {
                return onCreateDisturbTimeDialog(i);
            }
            return null;
        }
        return (Dialog) invokeI.objValue;
    }

    public Dialog onCreateDisturbTimeDialog(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            jw8 jw8Var = new jw8(getActivity(), new f(this, i), 0, 0, true);
            if (i == R.id.obfuscated_res_0x7f091583) {
                jw8Var.setTitle(R.string.obfuscated_res_0x7f0f0c32);
            } else if (i == R.id.obfuscated_res_0x7f091589) {
                jw8Var.setTitle(R.string.obfuscated_res_0x7f0f0c35);
            }
            jw8Var.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f025d), jw8Var);
            jw8Var.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f036e), jw8Var);
            jw8Var.getWindow().setSoftInputMode(2);
            return jw8Var;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            ge8 ge8Var = this.mView;
            if (ge8Var != null) {
                ge8Var.W();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921660));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent)) == null) {
            if (i != 4) {
                return super.onKeyDown(i, keyEvent);
            }
            ge8 ge8Var = this.mView;
            if (ge8Var.B) {
                finish();
            } else {
                ge8Var.a0(true);
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, dialog) == null) {
            if (!(dialog instanceof TimePickerDialog)) {
                super.onPrepareDialog(i, dialog);
            } else if (i == R.id.obfuscated_res_0x7f091589 || i == R.id.obfuscated_res_0x7f091583) {
                if (i == R.id.obfuscated_res_0x7f091589) {
                    split = zx4.d().g().split(":");
                } else {
                    split = zx4.d().f().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            ge8 ge8Var = this.mView;
            if (ge8Var != null) {
                ge8Var.X();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            zx4.d().D();
        }
    }
}
