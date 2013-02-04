package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class MsgRemindActivity extends com.baidu.tieba.e {
    private AlertDialog j;
    private AlertDialog m;
    private RadioGroup b = null;
    private TextView c = null;
    private CheckBox d = null;
    private CheckBox e = null;
    private CheckBox f = null;
    private View.OnClickListener g = null;
    private LinearLayout h = null;
    private TextView i = null;
    private LinearLayout k = null;
    private TextView l = null;
    private Button n = null;

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    private void h() {
        int G = TiebaApplication.a().G();
        if (G == 30) {
            this.b.check(R.id.radio_30sec);
        } else if (G == 120) {
            this.b.check(R.id.radio_2min);
        } else if (G == 300) {
            this.b.check(R.id.radio_5min);
        } else {
            this.b.check(R.id.radio_no);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (TiebaApplication.a().G() <= 0) {
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.h.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        this.e.setVisibility(0);
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.h.setVisibility(0);
        this.k.setVisibility(0);
    }

    private void j() {
        if (TiebaApplication.a().O()) {
            this.d.setChecked(true);
        }
        if (TiebaApplication.a().N()) {
            this.e.setChecked(true);
        }
        if (TiebaApplication.a().M()) {
            this.f.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (TiebaApplication.a().J()) {
            this.i.setText(getString(R.string.remind_tone_open));
        } else {
            this.i.setText(getString(R.string.remind_tone_close));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (TiebaApplication.a().K()) {
            this.l.setText(getString(R.string.remind_tone_open));
        } else {
            this.l.setText(getString(R.string.remind_tone_close));
        }
    }

    void g() {
        this.b = (RadioGroup) findViewById(R.id.frequency_radio);
        this.b.setOnCheckedChangeListener(new ah(this));
        ai aiVar = new ai(this);
        this.c = (TextView) findViewById(R.id.content_text);
        this.d = (CheckBox) findViewById(R.id.check_replyme);
        this.e = (CheckBox) findViewById(R.id.check_atme);
        this.f = (CheckBox) findViewById(R.id.check_newfans);
        this.d.setOnCheckedChangeListener(aiVar);
        this.e.setOnCheckedChangeListener(aiVar);
        this.f.setOnCheckedChangeListener(aiVar);
        this.g = new aj(this);
        this.h = (LinearLayout) findViewById(R.id.remind_tone);
        this.h.setOnClickListener(this.g);
        this.i = (TextView) findViewById(R.id.text_remind_tone);
        this.k = (LinearLayout) findViewById(R.id.remind_vibrate);
        this.k.setOnClickListener(this.g);
        this.l = (TextView) findViewById(R.id.text_remind_vibrate);
        this.n = (Button) findViewById(R.id.back);
        this.n.setOnClickListener(new ao(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.msg_remind_activity);
        g();
        h();
        j();
        k();
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        if (this.j != null) {
            this.j.dismiss();
        }
        if (this.m != null) {
            this.m.dismiss();
        }
        super.onPause();
    }
}
