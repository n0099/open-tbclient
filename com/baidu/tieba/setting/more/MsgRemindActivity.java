package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.t.a;
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
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.view.CancelableTimePickerDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes13.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgRemindModel.e callback;
    public MsgRemindModel mModel;
    public MsgRemindModel.e mMsgRemindModelCallback;
    public c.a.u0.o3.l.g mView;
    public final c.a.t0.f1.q.a.d.f onTimeSelectListener;

    /* loaded from: classes13.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgRemindActivity;
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
                        this.a.mView.m().turnOffNoCallback();
                        this.a.mView.U(false);
                        this.a.mView.Z(false);
                        return;
                    }
                    this.a.mView.m().turnOnNoCallback();
                    this.a.mView.U(true);
                    this.a.mView.Z(true);
                } else if (i2 == 9) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.mView.E().turnOffNoCallback();
                    } else {
                        this.a.mView.E().turnOnNoCallback();
                    }
                } else if (i2 == 7) {
                    if (z) {
                        c.a.t0.t.d.d.d().S(z2);
                    } else if (z2) {
                        this.a.mView.l().turnOffNoCallback();
                    } else {
                        this.a.mView.l().turnOnNoCallback();
                    }
                } else if (i2 == 6) {
                    if (z) {
                        c.a.t0.t.d.d.d().R(z2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921631));
                    } else if (z2) {
                        this.a.mView.w().turnOffNoCallback();
                    } else {
                        this.a.mView.w().turnOnNoCallback();
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f47987e;

        public b(MsgRemindActivity msgRemindActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47987e = msgRemindActivity;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f47988e;

        public c(MsgRemindActivity msgRemindActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47988e = msgRemindActivity;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.t0.t.h.a.c(this.f47988e.getPageContext());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f47989e;

        public d(MsgRemindActivity msgRemindActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47989e = msgRemindActivity;
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

    /* loaded from: classes13.dex */
    public class e implements c.a.t0.f1.q.a.d.f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgRemindActivity;
        }

        @Override // c.a.t0.f1.q.a.d.f
        public void a(Date date, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view) == null) || this.a.mView == null) {
                return;
            }
            c.a.t0.t.d.d.d().V(date.getHours(), date.getMinutes());
            this.a.mView.c0();
            this.a.mView.a0();
        }
    }

    /* loaded from: classes13.dex */
    public class f implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f47990b;

        public f(MsgRemindActivity msgRemindActivity, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47990b = msgRemindActivity;
            this.a = i2;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i2, i3) == null) || timePicker == null) {
                return;
            }
            timePicker.clearFocus();
            boolean z = this.a == c.a.u0.o3.e.no_disturb_start_time;
            StringBuilder sb = new StringBuilder();
            sb.append(timePicker.getCurrentHour().intValue() < 10 ? "0" : "");
            sb.append(timePicker.getCurrentHour());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(timePicker.getCurrentMinute().intValue() >= 10 ? "" : "0");
            sb3.append(timePicker.getCurrentMinute());
            String str = sb2 + ":" + sb3.toString();
            if (z) {
                c.a.t0.t.d.d.d().Q(str);
            } else {
                c.a.t0.t.d.d.d().O(str);
            }
            this.f47990b.mView.b0();
        }
    }

    /* loaded from: classes13.dex */
    public class g implements MsgRemindModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        /* loaded from: classes13.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f47991e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BdSwitchView f47992f;

            public a(g gVar, boolean z, BdSwitchView bdSwitchView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Boolean.valueOf(z), bdSwitchView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47991e = z;
                this.f47992f = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f47991e) {
                        this.f47992f.turnOnNoCallback();
                    } else {
                        this.f47992f.turnOffNoCallback();
                    }
                }
            }
        }

        /* loaded from: classes13.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f47993e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BdSwitchView f47994f;

            public b(g gVar, boolean z, BdSwitchView bdSwitchView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Boolean.valueOf(z), bdSwitchView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47993e = z;
                this.f47994f = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f47993e) {
                        this.f47994f.turnOffNoCallback();
                    } else {
                        this.f47994f.turnOnNoCallback();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgRemindActivity;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i2 == 14) {
                    BdSwitchView o = this.a.mView.o();
                    if (!z) {
                        if (o != null) {
                            c.a.d.f.m.e.a().postDelayed(new b(this, z2, o), 500L);
                            return;
                        }
                        return;
                    }
                    if (z2) {
                        c.a.t0.t.d.d.d().H(300);
                        this.a.mView.W(true);
                    } else {
                        c.a.t0.t.d.d.d().H(0);
                        this.a.mView.W(false);
                    }
                    if (o != null) {
                        c.a.d.f.m.e.a().postDelayed(new a(this, z2, o), 500L);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        c.a.t0.t.d.d.d().F(z2);
                    }
                    this.a.mView.d0();
                } else if (i2 == 3) {
                    if (z) {
                        c.a.t0.t.d.d.d().J(z2);
                    }
                    this.a.mView.g0();
                } else if (i2 == 4) {
                    if (z) {
                        c.a.t0.t.d.d.d().E(z2);
                        if (!z2) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                        }
                    }
                    this.a.mView.f0();
                } else if (i2 == 5) {
                    if (z) {
                        c.a.t0.t.d.d.d().G(z2);
                    }
                    this.a.mView.e0();
                } else if (i2 == 1) {
                    if (z) {
                        c.a.t0.t.d.d.d().K(z2);
                    }
                    this.a.mView.h0();
                } else if (i2 == 20) {
                    if (z) {
                        c.a.t0.t.d.d.d().N(z2);
                    }
                    this.a.mView.i0();
                }
            }
        }
    }

    public MsgRemindActivity() {
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
        this.onTimeSelectListener = new e(this);
        this.callback = new g(this);
    }

    private void doMsgSwitchStat(BdSwitchView.SwitchState switchState, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, switchState, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13889").param("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).param("obj_source", i2));
        }
    }

    private void showPushPermissionGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(this);
            aVar.setTitle(c.a.u0.o3.g.push_permission_guide_title);
            aVar.setTitleShowCenter(true);
            aVar.setMessage(getString(c.a.u0.o3.g.push_permission_guide_des));
            aVar.setNegativeButton(c.a.u0.o3.g.know, new b(this));
            aVar.setPositiveButton(c.a.u0.o3.g.go_to_set, new c(this));
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
            if (view == this.mView.D()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.t0.t.d.d.d().U(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.mView.c0();
                    this.mView.Y(true);
                } else {
                    c.a.t0.t.d.d.d().U(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.mView.Y(false);
                }
                doMsgSwitchStat(switchState, 7);
            } else if (view == this.mView.o()) {
                this.mModel.z(14, switchState == BdSwitchView.SwitchState.ON, this.callback);
            } else if (view == this.mView.v()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.t0.t.d.d.d().P(true);
                    this.mView.X(true);
                    return;
                }
                c.a.t0.t.d.d.d().P(false);
                this.mView.X(false);
            } else if (view == this.mView.z()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.t0.t.d.d.d().L(true);
                } else {
                    c.a.t0.t.d.d.d().L(false);
                }
            } else if (view == this.mView.A()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.t0.t.d.d.d().M(true);
                } else {
                    c.a.t0.t.d.d.d().M(false);
                }
            } else if (view == this.mView.x()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.t0.t.d.d.d().I(true);
                } else {
                    c.a.t0.t.d.d.d().I(false);
                }
            } else if (view == this.mView.y()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    c.a.t0.t.d.d.d().T(true);
                } else {
                    c.a.t0.t.d.d.d().T(false);
                }
            } else if (view == this.mView.B()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(1, true, this.callback);
                } else {
                    this.mModel.z(1, false, this.callback);
                }
                doMsgSwitchStat(switchState, 1);
            } else if (view == this.mView.F()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(20, true, this.callback);
                } else {
                    this.mModel.z(20, false, this.callback);
                }
                doMsgSwitchStat(switchState, 2);
            } else if (view == this.mView.i()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(2, true, this.callback);
                } else {
                    this.mModel.z(2, false, this.callback);
                }
                doMsgSwitchStat(switchState, 3);
            } else if (view == this.mView.k()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(5, true, this.callback);
                } else {
                    this.mModel.z(5, false, this.callback);
                }
            } else if (view == this.mView.n()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(4, true, this.callback);
                } else {
                    this.mModel.z(4, false, this.callback);
                }
            } else if (view == this.mView.r()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(3, true, this.callback);
                } else {
                    this.mModel.z(3, false, this.callback);
                }
                doMsgSwitchStat(switchState, 4);
            } else if (view == this.mView.m()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(8, true, this.mMsgRemindModelCallback);
                    this.mView.U(true);
                    this.mView.Z(true);
                } else {
                    this.mModel.z(8, false, this.mMsgRemindModelCallback);
                    this.mView.U(false);
                    this.mView.Z(false);
                }
                doMsgSwitchStat(switchState, 5);
            } else if (view == this.mView.E()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(9, true, this.mMsgRemindModelCallback);
                } else {
                    this.mModel.z(9, false, this.mMsgRemindModelCallback);
                }
                doMsgSwitchStat(switchState, 6);
            } else if (view == this.mView.l()) {
                this.mModel.z(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
                doMsgSwitchStat(switchState, 9);
            } else if (view == this.mView.w()) {
                this.mModel.z(6, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mView.j().performClick();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            if (view == this.mView.j()) {
                c.a.u0.o3.l.g gVar = this.mView;
                if (gVar.B) {
                    finish();
                } else {
                    gVar.V(true);
                }
            } else if (view == this.mView.C()) {
                c.a.t0.t.d.f.c().l(getPageContext(), this.onTimeSelectListener);
            } else if (view == this.mView.t()) {
                this.mView.V(false);
            } else if (view == this.mView.u()) {
                showDialog(c.a.u0.o3.e.no_disturb_start_time);
            } else if (view == this.mView.s()) {
                showDialog(c.a.u0.o3.e.no_disturb_end_time);
            } else if (view == this.mView.p()) {
                TiebaStatic.log(new StatisticItem("c13286").param("uid", TbadkCoreApplication.getCurrentAccount()));
                sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.mView.q()) {
                c.a.t0.s.q.a.c().b();
            } else if (view.getId() == c.a.u0.o3.e.system_msg_permission_switch_cover) {
                showPushPermissionGuide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.u0.o3.l.g gVar = new c.a.u0.o3.l.g(this);
            this.mView = gVar;
            gVar.G(this);
            this.mModel = new MsgRemindModel(this);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 == c.a.u0.o3.e.no_disturb_end_time || i2 == c.a.u0.o3.e.no_disturb_start_time) {
                return onCreateDisturbTimeDialog(i2);
            }
            return null;
        }
        return (Dialog) invokeI.objValue;
    }

    public Dialog onCreateDisturbTimeDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            CancelableTimePickerDialog cancelableTimePickerDialog = new CancelableTimePickerDialog(getActivity(), new f(this, i2), 0, 0, true);
            if (i2 == c.a.u0.o3.e.no_disturb_end_time) {
                cancelableTimePickerDialog.setTitle(c.a.u0.o3.g.no_disturb_end_time);
            } else if (i2 == c.a.u0.o3.e.no_disturb_start_time) {
                cancelableTimePickerDialog.setTitle(c.a.u0.o3.g.no_disturb_start_time);
            }
            cancelableTimePickerDialog.setButton(-1, getPageContext().getString(c.a.u0.o3.g.alert_yes_button), cancelableTimePickerDialog);
            cancelableTimePickerDialog.setButton(-2, getPageContext().getString(c.a.u0.o3.g.cancel), cancelableTimePickerDialog);
            cancelableTimePickerDialog.getWindow().setSoftInputMode(2);
            return cancelableTimePickerDialog;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            c.a.u0.o3.l.g gVar = this.mView;
            if (gVar != null) {
                gVar.R();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921660));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                return super.onKeyDown(i2, keyEvent);
            }
            c.a.u0.o3.l.g gVar = this.mView;
            if (gVar.B) {
                finish();
            } else {
                gVar.V(true);
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, dialog) == null) {
            if (dialog instanceof TimePickerDialog) {
                if (i2 == c.a.u0.o3.e.no_disturb_start_time || i2 == c.a.u0.o3.e.no_disturb_end_time) {
                    if (i2 == c.a.u0.o3.e.no_disturb_start_time) {
                        split = c.a.t0.t.d.d.d().g().split(":");
                    } else {
                        split = c.a.t0.t.d.d.d().f().split(":");
                    }
                    ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                    return;
                }
                return;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            c.a.u0.o3.l.g gVar = this.mView;
            if (gVar != null) {
                gVar.S();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            c.a.t0.t.d.d.d().D();
        }
    }
}
