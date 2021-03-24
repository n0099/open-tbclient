package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import d.b.h0.r.s.a;
import java.util.Date;
/* loaded from: classes5.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public MsgRemindModel mModel;
    public d.b.i0.u2.c.g mView;
    public MsgRemindModel.e mMsgRemindModelCallback = new a();
    public final d.b.h0.b1.o.a.d.e onTimeSelectListener = new e();
    public MsgRemindModel.e callback = new g();

    /* loaded from: classes5.dex */
    public class a implements MsgRemindModel.e {
        public a() {
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (z) {
                    return;
                }
                if (z2) {
                    MsgRemindActivity.this.mView.q().h();
                    MsgRemindActivity.this.mView.g0(false);
                    MsgRemindActivity.this.mView.n0(false);
                    return;
                }
                MsgRemindActivity.this.mView.q().k();
                MsgRemindActivity.this.mView.g0(true);
                MsgRemindActivity.this.mView.n0(true);
            } else if (i == 9) {
                if (z) {
                    return;
                }
                if (z2) {
                    MsgRemindActivity.this.mView.M().h();
                } else {
                    MsgRemindActivity.this.mView.M().k();
                }
            } else if (i == 7) {
                if (z) {
                    d.b.h0.s.d.d.d().P(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mView.o().h();
                } else {
                    MsgRemindActivity.this.mView.o().k();
                }
            } else if (i == 6) {
                if (z) {
                    d.b.h0.s.d.d.d().O(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mView.B().h();
                } else {
                    MsgRemindActivity.this.mView.B().k();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.h0.s.h.a.c(MsgRemindActivity.this.getPageContext());
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            StatisticItem statisticItem = new StatisticItem("c13673");
            statisticItem.param("obj_source", 8);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d.b.h0.b1.o.a.d.e {
        public e() {
        }

        @Override // d.b.h0.b1.o.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.mView != null) {
                d.b.h0.s.d.d.d().S(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.mView.r0();
                MsgRemindActivity.this.mView.o0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TimePickerDialog.OnTimeSetListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f21027a;

        public f(int i) {
            this.f21027a = i;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (timePicker == null) {
                return;
            }
            timePicker.clearFocus();
            boolean z = this.f21027a == R.id.no_disturb_start_time;
            StringBuilder sb = new StringBuilder();
            sb.append(timePicker.getCurrentHour().intValue() < 10 ? "0" : "");
            sb.append(timePicker.getCurrentHour());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(timePicker.getCurrentMinute().intValue() >= 10 ? "" : "0");
            sb3.append(timePicker.getCurrentMinute());
            String str = sb2 + ":" + sb3.toString();
            if (z) {
                d.b.h0.s.d.d.d().N(str);
            } else {
                d.b.h0.s.d.d.d().L(str);
            }
            MsgRemindActivity.this.mView.p0();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements MsgRemindModel.e {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f21030e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BdSwitchView f21031f;

            public a(g gVar, boolean z, BdSwitchView bdSwitchView) {
                this.f21030e = z;
                this.f21031f = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f21030e) {
                    this.f21031f.k();
                } else {
                    this.f21031f.h();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f21032e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BdSwitchView f21033f;

            public b(g gVar, boolean z, BdSwitchView bdSwitchView) {
                this.f21032e = z;
                this.f21033f = bdSwitchView;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f21032e) {
                    this.f21033f.h();
                } else {
                    this.f21033f.k();
                }
            }
        }

        public g() {
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i, boolean z, boolean z2) {
            if (i == 14) {
                BdSwitchView s = MsgRemindActivity.this.mView.s();
                if (!z) {
                    if (s != null) {
                        d.b.b.e.m.e.a().postDelayed(new b(this, z2, s), 500L);
                        return;
                    }
                    return;
                }
                if (z2) {
                    d.b.h0.s.d.d.d().E(300);
                    MsgRemindActivity.this.mView.i0(true);
                } else {
                    d.b.h0.s.d.d.d().E(0);
                    MsgRemindActivity.this.mView.i0(false);
                }
                if (s != null) {
                    d.b.b.e.m.e.a().postDelayed(new a(this, z2, s), 500L);
                }
            } else if (i == 2) {
                if (z) {
                    d.b.h0.s.d.d.d().C(z2);
                }
                MsgRemindActivity.this.mView.s0();
            } else if (i == 3) {
                if (z) {
                    d.b.h0.s.d.d.d().G(z2);
                }
                MsgRemindActivity.this.mView.v0();
            } else if (i == 4) {
                if (z) {
                    d.b.h0.s.d.d.d().B(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.mView.u0();
            } else if (i == 5) {
                if (z) {
                    d.b.h0.s.d.d.d().D(z2);
                }
                MsgRemindActivity.this.mView.t0();
            } else if (i == 1) {
                if (z) {
                    d.b.h0.s.d.d.d().H(z2);
                }
                MsgRemindActivity.this.mView.w0();
            } else if (i == 20) {
                if (z) {
                    d.b.h0.s.d.d.d().K(z2);
                }
                MsgRemindActivity.this.mView.x0();
            }
        }
    }

    private void doMsgSwitchStat(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new StatisticItem("c13889").param("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).param("obj_source", i));
    }

    private void showPushPermissionGuide() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this);
        aVar.setTitle(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getString(R.string.push_permission_guide_des));
        aVar.setNegativeButton(R.string.know, new b());
        aVar.setPositiveButton(R.string.go_to_set, new c());
        aVar.setOnDismissListener(new d());
        aVar.create(getPageContext()).show();
        StatisticItem statisticItem = new StatisticItem("c13674");
        statisticItem.param("obj_source", 8);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mView.L()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                d.b.h0.s.d.d.d().R(true);
                TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                this.mView.r0();
                this.mView.m0(true);
            } else {
                d.b.h0.s.d.d.d().R(false);
                TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                this.mView.m0(false);
            }
            doMsgSwitchStat(switchState, 7);
        } else if (view == this.mView.s()) {
            this.mModel.v(14, switchState == BdSwitchView.SwitchState.ON, this.callback);
        } else if (view == this.mView.A()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                d.b.h0.s.d.d.d().M(true);
                this.mView.j0(true);
                return;
            }
            d.b.h0.s.d.d.d().M(false);
            this.mView.j0(false);
        } else if (view == this.mView.G()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                d.b.h0.s.d.d.d().I(true);
            } else {
                d.b.h0.s.d.d.d().I(false);
            }
        } else if (view == this.mView.I()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                d.b.h0.s.d.d.d().J(true);
            } else {
                d.b.h0.s.d.d.d().J(false);
            }
        } else if (view == this.mView.E()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                d.b.h0.s.d.d.d().F(true);
            } else {
                d.b.h0.s.d.d.d().F(false);
            }
        } else if (view == this.mView.F()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                d.b.h0.s.d.d.d().Q(true);
            } else {
                d.b.h0.s.d.d.d().Q(false);
            }
        } else if (view == this.mView.J()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(1, true, this.callback);
            } else {
                this.mModel.v(1, false, this.callback);
            }
            doMsgSwitchStat(switchState, 1);
        } else if (view == this.mView.O()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(20, true, this.callback);
            } else {
                this.mModel.v(20, false, this.callback);
            }
            doMsgSwitchStat(switchState, 2);
        } else if (view == this.mView.l()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(2, true, this.callback);
            } else {
                this.mModel.v(2, false, this.callback);
            }
            doMsgSwitchStat(switchState, 3);
        } else if (view == this.mView.n()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(5, true, this.callback);
            } else {
                this.mModel.v(5, false, this.callback);
            }
        } else if (view == this.mView.r()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(4, true, this.callback);
            } else {
                this.mModel.v(4, false, this.callback);
            }
        } else if (view == this.mView.w()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(3, true, this.callback);
            } else {
                this.mModel.v(3, false, this.callback);
            }
            doMsgSwitchStat(switchState, 4);
        } else if (view == this.mView.q()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(8, true, this.mMsgRemindModelCallback);
                this.mView.g0(true);
                this.mView.n0(true);
            } else {
                this.mModel.v(8, false, this.mMsgRemindModelCallback);
                this.mView.g0(false);
                this.mView.n0(false);
            }
            doMsgSwitchStat(switchState, 5);
        } else if (view == this.mView.M()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mModel.v(9, true, this.mMsgRemindModelCallback);
            } else {
                this.mModel.v(9, false, this.mMsgRemindModelCallback);
            }
            doMsgSwitchStat(switchState, 6);
        } else if (view == this.mView.o()) {
            this.mModel.v(7, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
            doMsgSwitchStat(switchState, 9);
        } else if (view == this.mView.B()) {
            this.mModel.v(6, switchState == BdSwitchView.SwitchState.OFF, this.mMsgRemindModelCallback);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mView.m().performClick();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mView.m()) {
            d.b.i0.u2.c.g gVar = this.mView;
            if (gVar.B) {
                finish();
            } else {
                gVar.h0(true);
            }
        } else if (view == this.mView.K()) {
            d.b.h0.s.d.f.c().l(getPageContext(), this.onTimeSelectListener);
        } else if (view == this.mView.y()) {
            this.mView.h0(false);
        } else if (view == this.mView.z()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.mView.x()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.mView.u()) {
            TiebaStatic.log(new StatisticItem("c13286").param("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mView.v()) {
            d.b.h0.r.p.a.c().b();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            showPushPermissionGuide();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.b.i0.u2.c.g gVar = new d.b.i0.u2.c.g(this);
        this.mView = gVar;
        gVar.P(this);
        this.mModel = new MsgRemindModel(this);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == R.id.no_disturb_end_time || i == R.id.no_disturb_start_time) {
            return onCreateDisturbTimeDialog(i);
        }
        return null;
    }

    public Dialog onCreateDisturbTimeDialog(int i) {
        d.b.i0.t3.b bVar = new d.b.i0.t3.b(getActivity(), new f(i), 0, 0, true);
        if (i == R.id.no_disturb_end_time) {
            bVar.setTitle(R.string.no_disturb_end_time);
        } else if (i == R.id.no_disturb_start_time) {
            bVar.setTitle(R.string.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(R.string.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(R.string.cancel), bVar);
        bVar.getWindow().setSoftInputMode(2);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.u2.c.g gVar = this.mView;
        if (gVar != null) {
            gVar.c0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        d.b.i0.u2.c.g gVar = this.mView;
        if (gVar.B) {
            finish();
        } else {
            gVar.h0(true);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == R.id.no_disturb_start_time || i == R.id.no_disturb_end_time) {
                if (i == R.id.no_disturb_start_time) {
                    split = d.b.h0.s.d.d.d().g().split(":");
                } else {
                    split = d.b.h0.s.d.d.d().f().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.i0.u2.c.g gVar = this.mView;
        if (gVar != null) {
            gVar.d0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        d.b.h0.s.d.d.d().A();
    }
}
