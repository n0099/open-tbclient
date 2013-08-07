package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgRemindActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private RadioGroup f1392a = null;
    private TextView b = null;
    private CheckBox c = null;
    private CheckBox d = null;
    private CheckBox e = null;
    private LinearLayout f = null;
    private BdSwitchView g = null;
    private LinearLayout j = null;
    private BdSwitchView k = null;
    private RelativeLayout l = null;
    private RelativeLayout m = null;
    private TextView n = null;
    private TextView o = null;
    private RadioButton p = null;
    private RadioButton q = null;
    private RadioButton r = null;
    private RadioButton s = null;
    private CheckBox t = null;
    private CheckBox u = null;
    private CheckBox v = null;
    private TextView w = null;
    private TextView x = null;
    private ImageView y = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.msg_remind_activity);
        b();
        c();
        k();
        l();
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        int color;
        super.a(i);
        com.baidu.tieba.util.ah.b(this.l, i);
        com.baidu.tieba.util.ah.d(this.m, i);
        com.baidu.tieba.util.ah.a(this.y, i);
        com.baidu.tieba.util.ah.f(this.n, i);
        if (i == 1) {
            color = com.baidu.tieba.util.ah.a(i);
            com.baidu.tieba.util.ah.h((View) this.p, (int) R.drawable.more_up_1);
            com.baidu.tieba.util.ah.h((View) this.q, (int) R.drawable.more_middle_1);
            com.baidu.tieba.util.ah.h((View) this.r, (int) R.drawable.more_middle_1);
            com.baidu.tieba.util.ah.h((View) this.s, (int) R.drawable.more_down_1);
            com.baidu.tieba.util.ah.h((View) this.t, (int) R.drawable.more_up_1);
            com.baidu.tieba.util.ah.h((View) this.u, (int) R.drawable.more_middle_1);
            com.baidu.tieba.util.ah.h((View) this.v, (int) R.drawable.more_down_1);
            this.f.setBackgroundResource(R.drawable.more_up_1);
            this.j.setBackgroundResource(R.drawable.more_down_1);
            this.g.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            this.k.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
        } else {
            color = getResources().getColor(R.color.more_color);
            com.baidu.tieba.util.ah.h((View) this.p, (int) R.drawable.more_up);
            com.baidu.tieba.util.ah.h((View) this.q, (int) R.drawable.more_middle);
            com.baidu.tieba.util.ah.h((View) this.r, (int) R.drawable.more_middle);
            com.baidu.tieba.util.ah.h((View) this.s, (int) R.drawable.more_down);
            com.baidu.tieba.util.ah.h((View) this.t, (int) R.drawable.more_up);
            com.baidu.tieba.util.ah.h((View) this.u, (int) R.drawable.more_middle);
            com.baidu.tieba.util.ah.h((View) this.v, (int) R.drawable.more_down);
            this.f.setBackgroundResource(R.drawable.more_up);
            this.j.setBackgroundResource(R.drawable.more_down);
            this.g.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
            this.k.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
        }
        this.o.setTextColor(color);
        this.p.setTextColor(color);
        this.q.setTextColor(color);
        this.r.setTextColor(color);
        this.s.setTextColor(color);
        this.b.setTextColor(color);
        this.t.setTextColor(color);
        this.u.setTextColor(color);
        this.v.setTextColor(color);
        this.w.setTextColor(color);
        this.x.setTextColor(color);
    }

    void b() {
        this.l = (RelativeLayout) findViewById(R.id.parent);
        this.f1392a = (RadioGroup) findViewById(R.id.frequency_radio);
        this.m = (RelativeLayout) findViewById(R.id.title);
        this.n = (TextView) findViewById(R.id.title_text);
        this.o = (TextView) findViewById(R.id.frequency_text);
        this.p = (RadioButton) findViewById(R.id.radio_30sec);
        this.q = (RadioButton) findViewById(R.id.radio_2min);
        this.r = (RadioButton) findViewById(R.id.radio_5min);
        this.s = (RadioButton) findViewById(R.id.radio_no);
        this.t = (CheckBox) findViewById(R.id.check_replyme);
        this.u = (CheckBox) findViewById(R.id.check_atme);
        this.v = (CheckBox) findViewById(R.id.check_newfans);
        this.w = (TextView) findViewById(R.id.tone_text);
        this.x = (TextView) findViewById(R.id.vibrate_text);
        this.f1392a.setOnCheckedChangeListener(new ad(this));
        ae aeVar = new ae(this);
        this.b = (TextView) findViewById(R.id.content_text);
        this.c = (CheckBox) findViewById(R.id.check_replyme);
        this.d = (CheckBox) findViewById(R.id.check_atme);
        this.e = (CheckBox) findViewById(R.id.check_newfans);
        this.c.setOnCheckedChangeListener(aeVar);
        this.d.setOnCheckedChangeListener(aeVar);
        this.e.setOnCheckedChangeListener(aeVar);
        this.f = (LinearLayout) findViewById(R.id.remind_tone);
        this.f.setClickable(false);
        this.g = (BdSwitchView) findViewById(R.id.remind_tone_switch);
        this.g.setOnSwitchStateChangeListener(new af(this));
        this.j = (LinearLayout) findViewById(R.id.remind_vibrate);
        this.j.setClickable(false);
        this.k = (BdSwitchView) findViewById(R.id.remind_vibrate_switch);
        this.k.setOnSwitchStateChangeListener(new ag(this));
        this.y = (ImageView) findViewById(R.id.back);
        this.y.setOnClickListener(new ah(this));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    private void c() {
        int S = TiebaApplication.f().S();
        if (S == 30) {
            this.f1392a.check(R.id.radio_30sec);
        } else if (S == 120) {
            this.f1392a.check(R.id.radio_2min);
        } else if (S == 300) {
            this.f1392a.check(R.id.radio_5min);
        } else {
            this.f1392a.check(R.id.radio_no);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (TiebaApplication.f().S() <= 0) {
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        this.b.setVisibility(0);
        this.d.setVisibility(0);
        this.c.setVisibility(0);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        this.j.setVisibility(0);
    }

    private void k() {
        if (TiebaApplication.f().aa()) {
            this.c.setChecked(true);
        }
        if (TiebaApplication.f().Z()) {
            this.d.setChecked(true);
        }
        if (TiebaApplication.f().Y()) {
            this.e.setChecked(true);
        }
    }

    private void l() {
        if (TiebaApplication.f().V()) {
            this.g.a();
        } else {
            this.g.b();
        }
    }

    private void m() {
        if (TiebaApplication.f().W()) {
            this.k.a();
        } else {
            this.k.b();
        }
    }
}
