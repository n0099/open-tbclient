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
public class MsgRemindActivity extends com.baidu.tieba.e {
    private RadioGroup c = null;
    private TextView d = null;
    private CheckBox e = null;
    private CheckBox f = null;
    private CheckBox g = null;
    private LinearLayout h = null;
    private BdSwitchView i = null;
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
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.msg_remind_activity);
        b();
        c();
        m();
        n();
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        int color;
        super.b(i);
        com.baidu.tieba.d.ac.b(this.l, i);
        com.baidu.tieba.d.ac.d(this.m, i);
        com.baidu.tieba.d.ac.a(this.y, i);
        com.baidu.tieba.d.ac.f(this.n, i);
        if (i == 1) {
            color = com.baidu.tieba.d.ac.a(i);
            com.baidu.tieba.d.ac.h((View) this.p, (int) R.drawable.more_up_1);
            com.baidu.tieba.d.ac.h((View) this.q, (int) R.drawable.more_middle_1);
            com.baidu.tieba.d.ac.h((View) this.r, (int) R.drawable.more_middle_1);
            com.baidu.tieba.d.ac.h((View) this.s, (int) R.drawable.more_down_1);
            com.baidu.tieba.d.ac.h((View) this.t, (int) R.drawable.more_up_1);
            com.baidu.tieba.d.ac.h((View) this.u, (int) R.drawable.more_middle_1);
            com.baidu.tieba.d.ac.h((View) this.v, (int) R.drawable.more_down_1);
            this.h.setBackgroundResource(R.drawable.more_up_1);
            this.j.setBackgroundResource(R.drawable.more_down_1);
            this.i.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.NIGHT);
            this.k.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.NIGHT);
        } else {
            color = getResources().getColor(R.color.more_color);
            com.baidu.tieba.d.ac.h((View) this.p, (int) R.drawable.more_up);
            com.baidu.tieba.d.ac.h((View) this.q, (int) R.drawable.more_middle);
            com.baidu.tieba.d.ac.h((View) this.r, (int) R.drawable.more_middle);
            com.baidu.tieba.d.ac.h((View) this.s, (int) R.drawable.more_down);
            com.baidu.tieba.d.ac.h((View) this.t, (int) R.drawable.more_up);
            com.baidu.tieba.d.ac.h((View) this.u, (int) R.drawable.more_middle);
            com.baidu.tieba.d.ac.h((View) this.v, (int) R.drawable.more_down);
            this.h.setBackgroundResource(R.drawable.more_up);
            this.j.setBackgroundResource(R.drawable.more_down);
            this.i.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.DAY);
            this.k.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.DAY);
        }
        this.o.setTextColor(color);
        this.p.setTextColor(color);
        this.q.setTextColor(color);
        this.r.setTextColor(color);
        this.s.setTextColor(color);
        this.d.setTextColor(color);
        this.t.setTextColor(color);
        this.u.setTextColor(color);
        this.v.setTextColor(color);
        this.w.setTextColor(color);
        this.x.setTextColor(color);
    }

    void b() {
        this.l = (RelativeLayout) findViewById(R.id.parent);
        this.c = (RadioGroup) findViewById(R.id.frequency_radio);
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
        this.c.setOnCheckedChangeListener(new ac(this));
        ad adVar = new ad(this);
        this.d = (TextView) findViewById(R.id.content_text);
        this.e = (CheckBox) findViewById(R.id.check_replyme);
        this.f = (CheckBox) findViewById(R.id.check_atme);
        this.g = (CheckBox) findViewById(R.id.check_newfans);
        this.e.setOnCheckedChangeListener(adVar);
        this.f.setOnCheckedChangeListener(adVar);
        this.g.setOnCheckedChangeListener(adVar);
        this.h = (LinearLayout) findViewById(R.id.remind_tone);
        this.h.setClickable(false);
        this.i = (BdSwitchView) findViewById(R.id.remind_tone_switch);
        this.i.setOnSwitchStateChangeListener(new ae(this));
        this.j = (LinearLayout) findViewById(R.id.remind_vibrate);
        this.j.setClickable(false);
        this.k = (BdSwitchView) findViewById(R.id.remind_vibrate_switch);
        this.k.setOnSwitchStateChangeListener(new af(this));
        this.y = (ImageView) findViewById(R.id.back);
        this.y.setOnClickListener(new ag(this));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    private void c() {
        int P = TiebaApplication.d().P();
        if (P == 30) {
            this.c.check(R.id.radio_30sec);
        } else if (P == 120) {
            this.c.check(R.id.radio_2min);
        } else if (P == 300) {
            this.c.check(R.id.radio_5min);
        } else {
            this.c.check(R.id.radio_no);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (TiebaApplication.d().P() <= 0) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.e.setVisibility(0);
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.j.setVisibility(0);
    }

    private void m() {
        if (TiebaApplication.d().X()) {
            this.e.setChecked(true);
        }
        if (TiebaApplication.d().W()) {
            this.f.setChecked(true);
        }
        if (TiebaApplication.d().V()) {
            this.g.setChecked(true);
        }
    }

    private void n() {
        if (TiebaApplication.d().S()) {
            this.i.a();
        } else {
            this.i.b();
        }
    }

    private void o() {
        if (TiebaApplication.d().T()) {
            this.k.a();
        } else {
            this.k.b();
        }
    }
}
