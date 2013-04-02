package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class MsgRemindActivity extends com.baidu.tieba.e {
    private AlertDialog k;
    private AlertDialog n;
    private RadioGroup c = null;
    private TextView d = null;
    private CheckBox e = null;
    private CheckBox f = null;
    private CheckBox g = null;
    private View.OnClickListener h = null;
    private LinearLayout i = null;
    private TextView j = null;
    private LinearLayout l = null;
    private TextView m = null;
    private RelativeLayout o = null;
    private RelativeLayout p = null;
    private TextView q = null;
    private TextView r = null;
    private RadioButton s = null;
    private RadioButton t = null;
    private RadioButton u = null;
    private RadioButton v = null;
    private CheckBox w = null;
    private CheckBox x = null;
    private CheckBox y = null;
    private TextView z = null;
    private TextView A = null;
    private Button B = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.msg_remind_activity);
        i();
        j();
        l();
        m();
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        int color;
        super.b(i);
        com.baidu.tieba.c.ae.a(this.o, i);
        com.baidu.tieba.c.ae.c(this.p, i);
        com.baidu.tieba.c.ae.e((TextView) this.B, i);
        com.baidu.tieba.c.ae.c(this.q, i);
        if (i == 1) {
            color = com.baidu.tieba.c.ae.a(i);
            com.baidu.tieba.c.ae.h(this.s, R.drawable.more_up_1);
            com.baidu.tieba.c.ae.h(this.t, R.drawable.more_middle_1);
            com.baidu.tieba.c.ae.h(this.u, R.drawable.more_middle_1);
            com.baidu.tieba.c.ae.h(this.v, R.drawable.more_down_1);
            com.baidu.tieba.c.ae.h(this.w, R.drawable.more_up_1);
            com.baidu.tieba.c.ae.h(this.x, R.drawable.more_middle_1);
            com.baidu.tieba.c.ae.h(this.y, R.drawable.more_down_1);
            this.i.setBackgroundResource(R.drawable.more_up_1);
            this.l.setBackgroundResource(R.drawable.more_down_1);
        } else {
            color = getResources().getColor(R.color.more_color);
            com.baidu.tieba.c.ae.h(this.s, R.drawable.more_up);
            com.baidu.tieba.c.ae.h(this.t, R.drawable.more_middle);
            com.baidu.tieba.c.ae.h(this.u, R.drawable.more_middle);
            com.baidu.tieba.c.ae.h(this.v, R.drawable.more_down);
            com.baidu.tieba.c.ae.h(this.w, R.drawable.more_up);
            com.baidu.tieba.c.ae.h(this.x, R.drawable.more_middle);
            com.baidu.tieba.c.ae.h(this.y, R.drawable.more_down);
            this.i.setBackgroundResource(R.drawable.more_up);
            this.l.setBackgroundResource(R.drawable.more_down);
        }
        this.r.setTextColor(color);
        this.s.setTextColor(color);
        this.t.setTextColor(color);
        this.u.setTextColor(color);
        this.v.setTextColor(color);
        this.d.setTextColor(color);
        this.w.setTextColor(color);
        this.x.setTextColor(color);
        this.y.setTextColor(color);
        this.z.setTextColor(color);
        this.j.setTextColor(color);
        this.A.setTextColor(color);
        this.m.setTextColor(color);
    }

    void i() {
        this.o = (RelativeLayout) findViewById(R.id.parent);
        this.c = (RadioGroup) findViewById(R.id.frequency_radio);
        this.p = (RelativeLayout) findViewById(R.id.title);
        this.q = (TextView) findViewById(R.id.title_text);
        this.r = (TextView) findViewById(R.id.frequency_text);
        this.s = (RadioButton) findViewById(R.id.radio_30sec);
        this.t = (RadioButton) findViewById(R.id.radio_2min);
        this.u = (RadioButton) findViewById(R.id.radio_5min);
        this.v = (RadioButton) findViewById(R.id.radio_no);
        this.w = (CheckBox) findViewById(R.id.check_replyme);
        this.x = (CheckBox) findViewById(R.id.check_atme);
        this.y = (CheckBox) findViewById(R.id.check_newfans);
        this.z = (TextView) findViewById(R.id.tone_text);
        this.A = (TextView) findViewById(R.id.vibrate_text);
        this.c.setOnCheckedChangeListener(new ah(this));
        ai aiVar = new ai(this);
        this.d = (TextView) findViewById(R.id.content_text);
        this.e = (CheckBox) findViewById(R.id.check_replyme);
        this.f = (CheckBox) findViewById(R.id.check_atme);
        this.g = (CheckBox) findViewById(R.id.check_newfans);
        this.e.setOnCheckedChangeListener(aiVar);
        this.f.setOnCheckedChangeListener(aiVar);
        this.g.setOnCheckedChangeListener(aiVar);
        this.h = new aj(this);
        this.i = (LinearLayout) findViewById(R.id.remind_tone);
        this.i.setOnClickListener(this.h);
        this.j = (TextView) findViewById(R.id.text_remind_tone);
        this.l = (LinearLayout) findViewById(R.id.remind_vibrate);
        this.l.setOnClickListener(this.h);
        this.m = (TextView) findViewById(R.id.text_remind_vibrate);
        this.B = (Button) findViewById(R.id.back);
        this.B.setOnClickListener(new ao(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        if (this.k != null) {
            this.k.dismiss();
        }
        if (this.n != null) {
            this.n.dismiss();
        }
        super.onPause();
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    private void j() {
        int M = TiebaApplication.b().M();
        if (M == 30) {
            this.c.check(R.id.radio_30sec);
        } else if (M == 120) {
            this.c.check(R.id.radio_2min);
        } else if (M == 300) {
            this.c.check(R.id.radio_5min);
        } else {
            this.c.check(R.id.radio_no);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (TiebaApplication.b().M() <= 0) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
            this.i.setVisibility(8);
            this.l.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.e.setVisibility(0);
        this.g.setVisibility(0);
        this.i.setVisibility(0);
        this.l.setVisibility(0);
    }

    private void l() {
        if (TiebaApplication.b().U()) {
            this.e.setChecked(true);
        }
        if (TiebaApplication.b().T()) {
            this.f.setChecked(true);
        }
        if (TiebaApplication.b().S()) {
            this.g.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (TiebaApplication.b().P()) {
            this.j.setText(getString(R.string.remind_tone_open));
        } else {
            this.j.setText(getString(R.string.remind_tone_close));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (TiebaApplication.b().Q()) {
            this.m.setText(getString(R.string.remind_tone_open));
        } else {
            this.m.setText(getString(R.string.remind_tone_close));
        }
    }
}
