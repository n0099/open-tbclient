package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.a;
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
import java.util.Date;
/* loaded from: classes5.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgRemindModel.e callback;
    public MsgRemindModel mModel;
    public MsgRemindModel.e mMsgRemindModelCallback;
    public c.a.p0.p3.c.g mView;
    public final c.a.o0.e1.q.a.d.f onTimeSelectListener;

    /* loaded from: classes5.dex */
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
                        this.a.mView.o().h();
                        this.a.mView.Y(false);
                        this.a.mView.d0(false);
                        return;
                    }
                    this.a.mView.o().l();
                    this.a.mView.Y(true);
                    this.a.mView.d0(true);
                } else if (i == 9) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.mView.G().h();
                    } else {
                        this.a.mView.G().l();
                    }
                } else if (i == 7) {
                    if (z) {
                        c.a.o0.s.d.d.d().S(z2);
                    } else if (z2) {
                        this.a.mView.n().h();
                    } else {
                        this.a.mView.n().l();
                    }
                } else if (i == 6) {
                    if (z) {
                        c.a.o0.s.d.d.d().R(z2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921631));
                    } else if (z2) {
                        this.a.mView.y().h();
                    } else {
                        this.a.mView.y().l();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.o0.s.h.a.c(this.a.getPageContext());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class e implements c.a.o0.e1.q.a.d.f {
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

        @Override // c.a.o0.e1.q.a.d.f
        public void a(Date date, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view) == null) || this.a.mView == null) {
                return;
            }
            c.a.o0.s.d.d.d().V(date.getHours(), date.getMinutes());
            this.a.mView.g0();
            this.a.mView.e0();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f35889b;

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
            this.f35889b = msgRemindActivity;
            this.a = i;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) || timePicker == null) {
                return;
            }
            timePicker.clearFocus();
            boolean z = this.a == R.id.obfuscated_res_0x7f09158e;
            StringBuilder sb = new StringBuilder();
            sb.append(timePicker.getCurrentHour().intValue() < 10 ? "0" : "");
            sb.append(timePicker.getCurrentHour());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(timePicker.getCurrentMinute().intValue() >= 10 ? "" : "0");
            sb3.append(timePicker.getCurrentMinute());
            String str = sb2 + ":" + sb3.toString();
            if (z) {
                c.a.o0.s.d.d.d().Q(str);
            } else {
                c.a.o0.s.d.d.d().O(str);
            }
            this.f35889b.mView.f0();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements MsgRemindModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSwitchView f35890b;

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
                this.f35890b = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a) {
                        this.f35890b.l();
                    } else {
                        this.f35890b.h();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSwitchView f35891b;

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
                this.f35891b = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a) {
                        this.f35891b.h();
                    } else {
                        this.f35891b.l();
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
                    BdSwitchView q = this.a.mView.q();
                    if (!z) {
                        if (q != null) {
                            c.a.d.f.m.e.a().postDelayed(new b(this, z2, q), 500L);
                            return;
                        }
                        return;
                    }
                    if (z2) {
                        c.a.o0.s.d.d.d().H(300);
                        this.a.mView.a0(true);
                    } else {
                        c.a.o0.s.d.d.d().H(0);
                        this.a.mView.a0(false);
                    }
                    if (q != null) {
                        c.a.d.f.m.e.a().postDelayed(new a(this, z2, q), 500L);
                    }
                } else if (i == 2) {
                    if (z) {
                        c.a.o0.s.d.d.d().F(z2);
                    }
                    this.a.mView.h0();
                } else if (i == 3) {
                    if (z) {
                        c.a.o0.s.d.d.d().J(z2);
                    }
                    this.a.mView.k0();
                } else if (i == 4) {
                    if (z) {
                        c.a.o0.s.d.d.d().E(z2);
                        if (!z2) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                        }
                    }
                    this.a.mView.j0();
                } else if (i == 5) {
                    if (z) {
                        c.a.o0.s.d.d.d().G(z2);
                    }
                    this.a.mView.i0();
                } else if (i == 1) {
                    if (z) {
                        c.a.o0.s.d.d.d().K(z2);
                    }
                    this.a.mView.l0();
                } else if (i == 20) {
                    if (z) {
                        c.a.o0.s.d.d.d().N(z2);
                    }
                    this.a.mView.m0();
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
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this);
            aVar.setTitle(R.string.obfuscated_res_0x7f0f0f0e);
            aVar.setTitleShowCenter(true);
            aVar.setMessage(getString(R.string.obfuscated_res_0x7f0f0f0d));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new b(this));
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f07af, new c(this));
            aVar.setOnDismissListener(new d(this));
            aVar.create(getPageContext()).show();
            StatisticItem statisticItem = new StatisticItem("c13674");
            statisticItem.param("obj_source", 8);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
            if (view == this.mView.F()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.o0.s.d.d.d().U(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.mView.g0();
                    this.mView.c0(true);
                } else {
                    c.a.o0.s.d.d.d().U(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.mView.c0(false);
                }
                doMsgSwitchStat(switchState, 7);
            } else if (view == this.mView.q()) {
                this.mModel.B(14, switchState == BdSwitchView.SwitchState.ON, this.callback);
            } else if (view == this.mView.x()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.o0.s.d.d.d().P(true);
                    this.mView.b0(true);
                    return;
                }
                c.a.o0.s.d.d.d().P(false);
                this.mView.b0(false);
            } else if (view == this.mView.B()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.o0.s.d.d.d().L(true);
                } else {
                    c.a.o0.s.d.d.d().L(false);
                }
            } else if (view == this.mView.C()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.o0.s.d.d.d().M(true);
                } else {
                    c.a.o0.s.d.d.d().M(false);
                }
            } else if (view == this.mView.z()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.o0.s.d.d.d().I(true);
                } else {
                    c.a.o0.s.d.d.d().I(false);
                }
            } else if (view == this.mView.A()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.o0.s.d.d.d().T(true);
                } else {
                    c.a.o0.s.d.d.d().T(false);
                }
            } else if (view == this.mView.D()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(1, true, this.callback);
                } else {
                    this.mModel.B(1, false, this.callback);
                }
                doMsgSwitchStat(switchState, 1);
            } else if (view == this.mView.H()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(20, true, this.callback);
                } else {
                    this.mModel.B(20, false, this.callback);
                }
                doMsgSwitchStat(switchState, 2);
            } else if (view == this.mView.k()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(2, true, this.callback);
                } else {
                    this.mModel.B(2, false, this.callback);
                }
                doMsgSwitchStat(switchState, 3);
            } else if (view == this.mView.m()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(5, true, this.callback);
                } else {
                    this.mModel.B(5, false, this.callback);
                }
            } else if (view == this.mView.p()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(4, true, this.callback);
                } else {
                    this.mModel.B(4, false, this.callback);
                }
            } else if (view == this.mView.t()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(3, true, this.callback);
                } else {
                    this.mModel.B(3, false, this.callback);
                }
                doMsgSwitchStat(switchState, 4);
            } else if (view == this.mView.o()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(8, true, this.mMsgRemindModelCallback);
                    this.mView.Y(true);
                    this.mView.d0(true);
                } else {
                    this.mModel.B(8, false, this.mMsgRemindModelCallback);
                    this.mView.Y(false);
                    this.mView.d0(false);
                }
                doMsgSwitchStat(switchState, 5);
            } else if (view == this.mView.G()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(9, true, this.mMsgRemindModelCallback);
                } else {
                    this.mModel.B(9, false, this.mMsgRemindModelCallback);
                }
                doMsgSwitchStat(switchState, 6);
            } else if (view == this.mView.n()) {
                this.mModel.B(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
                doMsgSwitchStat(switchState, 9);
            } else if (view == this.mView.y()) {
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
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            if (view == this.mView.l()) {
                c.a.p0.p3.c.g gVar = this.mView;
                if (gVar.B) {
                    finish();
                } else {
                    gVar.Z(true);
                }
            } else if (view == this.mView.E()) {
                c.a.o0.s.d.f.c().l(getPageContext(), this.onTimeSelectListener);
            } else if (view == this.mView.v()) {
                this.mView.Z(false);
            } else if (view == this.mView.w()) {
                showDialog(R.id.obfuscated_res_0x7f09158e);
            } else if (view == this.mView.u()) {
                showDialog(R.id.obfuscated_res_0x7f091588);
            } else if (view == this.mView.r()) {
                TiebaStatic.log(new StatisticItem("c13286").param("uid", TbadkCoreApplication.getCurrentAccount()));
                sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.mView.s()) {
                c.a.o0.r.q.a.c().b();
            } else if (view.getId() == R.id.obfuscated_res_0x7f091e2c) {
                showPushPermissionGuide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.p0.p3.c.g gVar = new c.a.p0.p3.c.g(this);
            this.mView = gVar;
            gVar.I(this);
            this.mModel = new MsgRemindModel(this);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i == R.id.obfuscated_res_0x7f091588 || i == R.id.obfuscated_res_0x7f09158e) {
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
            c.a.p0.q4.b bVar = new c.a.p0.q4.b(getActivity(), new f(this, i), 0, 0, true);
            if (i == R.id.obfuscated_res_0x7f091588) {
                bVar.setTitle(R.string.obfuscated_res_0x7f0f0c2f);
            } else if (i == R.id.obfuscated_res_0x7f09158e) {
                bVar.setTitle(R.string.obfuscated_res_0x7f0f0c32);
            }
            bVar.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f025c), bVar);
            bVar.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f036c), bVar);
            bVar.getWindow().setSoftInputMode(2);
            return bVar;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            c.a.p0.p3.c.g gVar = this.mView;
            if (gVar != null) {
                gVar.V();
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
            c.a.p0.p3.c.g gVar = this.mView;
            if (gVar.B) {
                finish();
            } else {
                gVar.Z(true);
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
            } else if (i == R.id.obfuscated_res_0x7f09158e || i == R.id.obfuscated_res_0x7f091588) {
                if (i == R.id.obfuscated_res_0x7f09158e) {
                    split = c.a.o0.s.d.d.d().g().split(":");
                } else {
                    split = c.a.o0.s.d.d.d().f().split(":");
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
            c.a.p0.p3.c.g gVar = this.mView;
            if (gVar != null) {
                gVar.W();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            c.a.o0.s.d.d.d().D();
        }
    }
}
