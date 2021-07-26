package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
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
import d.a.p0.s.s.a;
import java.util.Date;
/* loaded from: classes4.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgRemindModel.e callback;
    public MsgRemindModel mModel;
    public MsgRemindModel.e mMsgRemindModelCallback;
    public d.a.q0.z2.c.g mView;
    public final d.a.p0.d1.o.a.d.e onTimeSelectListener;

    /* loaded from: classes4.dex */
    public class a implements MsgRemindModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f20908a;

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
            this.f20908a = msgRemindActivity;
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
                        this.f20908a.mView.o().h();
                        this.f20908a.mView.c0(false);
                        this.f20908a.mView.i0(false);
                        return;
                    }
                    this.f20908a.mView.o().k();
                    this.f20908a.mView.c0(true);
                    this.f20908a.mView.i0(true);
                } else if (i2 == 9) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.f20908a.mView.J().h();
                    } else {
                        this.f20908a.mView.J().k();
                    }
                } else if (i2 == 7) {
                    if (z) {
                        d.a.p0.t.d.d.d().P(z2);
                    } else if (z2) {
                        this.f20908a.mView.n().h();
                    } else {
                        this.f20908a.mView.n().k();
                    }
                } else if (i2 == 6) {
                    if (z) {
                        d.a.p0.t.d.d.d().O(z2);
                    } else if (z2) {
                        this.f20908a.mView.y().h();
                    } else {
                        this.f20908a.mView.y().k();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f20909e;

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
            this.f20909e = msgRemindActivity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f20910e;

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
            this.f20910e = msgRemindActivity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.a.p0.t.h.a.c(this.f20910e.getPageContext());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f20911e;

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
            this.f20911e = msgRemindActivity;
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
    public class e implements d.a.p0.d1.o.a.d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f20912a;

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
            this.f20912a = msgRemindActivity;
        }

        @Override // d.a.p0.d1.o.a.d.e
        public void a(Date date, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view) == null) || this.f20912a.mView == null) {
                return;
            }
            d.a.p0.t.d.d.d().S(date.getHours(), date.getMinutes());
            this.f20912a.mView.l0();
            this.f20912a.mView.j0();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f20914b;

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
            this.f20914b = msgRemindActivity;
            this.f20913a = i2;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i2, i3) == null) || timePicker == null) {
                return;
            }
            timePicker.clearFocus();
            boolean z = this.f20913a == R.id.no_disturb_start_time;
            StringBuilder sb = new StringBuilder();
            sb.append(timePicker.getCurrentHour().intValue() < 10 ? "0" : "");
            sb.append(timePicker.getCurrentHour());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(timePicker.getCurrentMinute().intValue() >= 10 ? "" : "0");
            sb3.append(timePicker.getCurrentMinute());
            String str = sb2 + ":" + sb3.toString();
            if (z) {
                d.a.p0.t.d.d.d().N(str);
            } else {
                d.a.p0.t.d.d.d().L(str);
            }
            this.f20914b.mView.k0();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements MsgRemindModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgRemindActivity f20915a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f20916e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BdSwitchView f20917f;

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
                this.f20916e = z;
                this.f20917f = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f20916e) {
                        this.f20917f.k();
                    } else {
                        this.f20917f.h();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f20918e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BdSwitchView f20919f;

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
                this.f20918e = z;
                this.f20919f = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f20918e) {
                        this.f20919f.h();
                    } else {
                        this.f20919f.k();
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
            this.f20915a = msgRemindActivity;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i2 == 14) {
                    BdSwitchView q = this.f20915a.mView.q();
                    if (!z) {
                        if (q != null) {
                            d.a.d.e.m.e.a().postDelayed(new b(this, z2, q), 500L);
                            return;
                        }
                        return;
                    }
                    if (z2) {
                        d.a.p0.t.d.d.d().E(300);
                        this.f20915a.mView.e0(true);
                    } else {
                        d.a.p0.t.d.d.d().E(0);
                        this.f20915a.mView.e0(false);
                    }
                    if (q != null) {
                        d.a.d.e.m.e.a().postDelayed(new a(this, z2, q), 500L);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        d.a.p0.t.d.d.d().C(z2);
                    }
                    this.f20915a.mView.m0();
                } else if (i2 == 3) {
                    if (z) {
                        d.a.p0.t.d.d.d().G(z2);
                    }
                    this.f20915a.mView.p0();
                } else if (i2 == 4) {
                    if (z) {
                        d.a.p0.t.d.d.d().B(z2);
                        if (!z2) {
                            TiebaStatic.eventStat(this.f20915a.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                        }
                    }
                    this.f20915a.mView.o0();
                } else if (i2 == 5) {
                    if (z) {
                        d.a.p0.t.d.d.d().D(z2);
                    }
                    this.f20915a.mView.n0();
                } else if (i2 == 1) {
                    if (z) {
                        d.a.p0.t.d.d.d().H(z2);
                    }
                    this.f20915a.mView.r0();
                } else if (i2 == 20) {
                    if (z) {
                        d.a.p0.t.d.d.d().K(z2);
                    }
                    this.f20915a.mView.t0();
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
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this);
            aVar.setTitle(R.string.push_permission_guide_title);
            aVar.setTitleShowCenter(true);
            aVar.setMessage(getString(R.string.push_permission_guide_des));
            aVar.setNegativeButton(R.string.know, new b(this));
            aVar.setPositiveButton(R.string.go_to_set, new c(this));
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
            if (view == this.mView.I()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    d.a.p0.t.d.d.d().R(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.mView.l0();
                    this.mView.g0(true);
                } else {
                    d.a.p0.t.d.d.d().R(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.mView.g0(false);
                }
                doMsgSwitchStat(switchState, 7);
            } else if (view == this.mView.q()) {
                this.mModel.z(14, switchState == BdSwitchView.SwitchState.ON, this.callback);
            } else if (view == this.mView.x()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    d.a.p0.t.d.d.d().M(true);
                    this.mView.f0(true);
                    return;
                }
                d.a.p0.t.d.d.d().M(false);
                this.mView.f0(false);
            } else if (view == this.mView.B()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    d.a.p0.t.d.d.d().I(true);
                } else {
                    d.a.p0.t.d.d.d().I(false);
                }
            } else if (view == this.mView.F()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    d.a.p0.t.d.d.d().J(true);
                } else {
                    d.a.p0.t.d.d.d().J(false);
                }
            } else if (view == this.mView.z()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    d.a.p0.t.d.d.d().F(true);
                } else {
                    d.a.p0.t.d.d.d().F(false);
                }
            } else if (view == this.mView.A()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    d.a.p0.t.d.d.d().Q(true);
                } else {
                    d.a.p0.t.d.d.d().Q(false);
                }
            } else if (view == this.mView.G()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(1, true, this.callback);
                } else {
                    this.mModel.z(1, false, this.callback);
                }
                doMsgSwitchStat(switchState, 1);
            } else if (view == this.mView.K()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(20, true, this.callback);
                } else {
                    this.mModel.z(20, false, this.callback);
                }
                doMsgSwitchStat(switchState, 2);
            } else if (view == this.mView.k()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(2, true, this.callback);
                } else {
                    this.mModel.z(2, false, this.callback);
                }
                doMsgSwitchStat(switchState, 3);
            } else if (view == this.mView.m()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(5, true, this.callback);
                } else {
                    this.mModel.z(5, false, this.callback);
                }
            } else if (view == this.mView.p()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(4, true, this.callback);
                } else {
                    this.mModel.z(4, false, this.callback);
                }
            } else if (view == this.mView.t()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(3, true, this.callback);
                } else {
                    this.mModel.z(3, false, this.callback);
                }
                doMsgSwitchStat(switchState, 4);
            } else if (view == this.mView.o()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(8, true, this.mMsgRemindModelCallback);
                    this.mView.c0(true);
                    this.mView.i0(true);
                } else {
                    this.mModel.z(8, false, this.mMsgRemindModelCallback);
                    this.mView.c0(false);
                    this.mView.i0(false);
                }
                doMsgSwitchStat(switchState, 5);
            } else if (view == this.mView.J()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.z(9, true, this.mMsgRemindModelCallback);
                } else {
                    this.mModel.z(9, false, this.mMsgRemindModelCallback);
                }
                doMsgSwitchStat(switchState, 6);
            } else if (view == this.mView.n()) {
                this.mModel.z(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
                doMsgSwitchStat(switchState, 9);
            } else if (view == this.mView.y()) {
                this.mModel.z(6, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
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
            if (view == this.mView.l()) {
                d.a.q0.z2.c.g gVar = this.mView;
                if (gVar.B) {
                    finish();
                } else {
                    gVar.d0(true);
                }
            } else if (view == this.mView.H()) {
                d.a.p0.t.d.f.c().l(getPageContext(), this.onTimeSelectListener);
            } else if (view == this.mView.v()) {
                this.mView.d0(false);
            } else if (view == this.mView.w()) {
                showDialog(R.id.no_disturb_start_time);
            } else if (view == this.mView.u()) {
                showDialog(R.id.no_disturb_end_time);
            } else if (view == this.mView.r()) {
                TiebaStatic.log(new StatisticItem("c13286").param("uid", TbadkCoreApplication.getCurrentAccount()));
                sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.mView.s()) {
                d.a.p0.s.p.a.c().b();
            } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
                showPushPermissionGuide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            d.a.q0.z2.c.g gVar = new d.a.q0.z2.c.g(this);
            this.mView = gVar;
            gVar.L(this);
            this.mModel = new MsgRemindModel(this);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 == R.id.no_disturb_end_time || i2 == R.id.no_disturb_start_time) {
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
            d.a.q0.z3.b bVar = new d.a.q0.z3.b(getActivity(), new f(this, i2), 0, 0, true);
            if (i2 == R.id.no_disturb_end_time) {
                bVar.setTitle(R.string.no_disturb_end_time);
            } else if (i2 == R.id.no_disturb_start_time) {
                bVar.setTitle(R.string.no_disturb_start_time);
            }
            bVar.setButton(-1, getPageContext().getString(R.string.alert_yes_button), bVar);
            bVar.setButton(-2, getPageContext().getString(R.string.cancel), bVar);
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
            d.a.q0.z2.c.g gVar = this.mView;
            if (gVar != null) {
                gVar.Z();
            }
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
            d.a.q0.z2.c.g gVar = this.mView;
            if (gVar.B) {
                finish();
            } else {
                gVar.d0(true);
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
                if (i2 == R.id.no_disturb_start_time || i2 == R.id.no_disturb_end_time) {
                    if (i2 == R.id.no_disturb_start_time) {
                        split = d.a.p0.t.d.d.d().g().split(":");
                    } else {
                        split = d.a.p0.t.d.d.d().f().split(":");
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
            d.a.q0.z2.c.g gVar = this.mView;
            if (gVar != null) {
                gVar.a0();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            d.a.p0.t.d.d.d().A();
        }
    }
}
