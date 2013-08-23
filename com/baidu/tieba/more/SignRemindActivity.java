package com.baidu.tieba.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SignRemindActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1430a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private TextView e;
    private BdSwitchView f;
    private RelativeLayout g = null;
    private View j = null;
    private ImageView k = null;
    private TextView l = null;

    public static void a(Context context) {
        context.startActivity(new Intent(context, SignRemindActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.more_sign_remind_activity);
        b();
        d();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        int i2;
        super.a(i);
        ao.b(this.g, i);
        ao.d(this.j, i);
        ao.a(this.k, i);
        ao.f(this.l, i);
        ImageView imageView = (ImageView) findViewById(R.id.arrow);
        if (i == 1) {
            int a2 = ao.a(i);
            ao.g(this.f1430a, (int) R.drawable.more_all_1);
            ao.g(this.b, (int) R.drawable.more_all_1);
            this.e.setTextColor(-11446171);
            this.f.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            i2 = a2;
        } else {
            int color = getResources().getColor(R.color.more_color);
            ao.g(this.f1430a, (int) R.drawable.more_all);
            ao.g(this.b, (int) R.drawable.more_all);
            this.e.setTextColor(-5065030);
            this.f.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            i2 = color;
        }
        this.c.setTextColor(i2);
        this.d.setTextColor(i2);
    }

    void b() {
        this.g = (RelativeLayout) findViewById(R.id.parent);
        this.j = findViewById(R.id.title);
        this.k = (ImageView) findViewById(R.id.back);
        this.l = (TextView) findViewById(R.id.title_text);
        this.f1430a = (LinearLayout) findViewById(R.id.sign_remind);
        this.b = (LinearLayout) findViewById(R.id.sign_remind_on);
        this.c = (TextView) findViewById(R.id.sign_remind_text);
        this.d = (TextView) findViewById(R.id.sign_remind_on_text);
        this.e = (TextView) findViewById(R.id.sign_remind_time);
        this.f = (BdSwitchView) findViewById(R.id.sign_remind_on_switch);
    }

    protected void c() {
        this.k.setOnClickListener(new ai(this));
        this.f.setOnSwitchStateChangeListener(new aj(this));
        this.f1430a.setOnClickListener(new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        TiebaApplication g = TiebaApplication.g();
        if (g.ac()) {
            this.e.setText(getString(R.string.sign_remind_time, new Object[]{g.ad() > 9 ? String.valueOf(g.ad()) : "0" + g.ad(), g.ae() > 9 ? String.valueOf(g.ae()) : "0" + g.ae()}));
            this.f1430a.setVisibility(0);
            if (!this.f.c()) {
                this.f.a();
                return;
            }
            return;
        }
        this.e.setText(R.string.close);
        this.f1430a.setVisibility(8);
        if (this.f.c()) {
            this.f.b();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TiebaApplication g = TiebaApplication.g();
            ((TimePickerDialog) dialog).updateTime(g.ad(), g.ae());
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new al(this, TiebaApplication.g()), 0, 0, true);
        timePickerDialog.setTitle(R.string.sign_remind);
        return timePickerDialog;
    }
}
