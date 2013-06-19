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
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SignRemindActivity extends com.baidu.tieba.e {
    private LinearLayout c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private TextView g;
    private BdSwitchView h;
    private RelativeLayout i = null;
    private View j = null;
    private ImageView k = null;
    private TextView l = null;

    public static void a(Context context) {
        context.startActivity(new Intent(context, SignRemindActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.more_sign_remind_activity);
        b();
        d();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        int i2;
        super.b(i);
        com.baidu.tieba.d.ac.b(this.i, i);
        com.baidu.tieba.d.ac.d(this.j, i);
        com.baidu.tieba.d.ac.a(this.k, i);
        com.baidu.tieba.d.ac.f(this.l, i);
        ImageView imageView = (ImageView) findViewById(R.id.arrow);
        if (i == 1) {
            int a = com.baidu.tieba.d.ac.a(i);
            com.baidu.tieba.d.ac.h(this.c, (int) R.drawable.more_all_1);
            com.baidu.tieba.d.ac.h(this.d, (int) R.drawable.more_all_1);
            this.g.setTextColor(-11446171);
            this.h.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.NIGHT);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            i2 = a;
        } else {
            int color = getResources().getColor(R.color.more_color);
            com.baidu.tieba.d.ac.h(this.c, (int) R.drawable.more_all);
            com.baidu.tieba.d.ac.h(this.d, (int) R.drawable.more_all);
            this.g.setTextColor(-5065030);
            this.h.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.DAY);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            i2 = color;
        }
        this.e.setTextColor(i2);
        this.f.setTextColor(i2);
    }

    void b() {
        this.i = (RelativeLayout) findViewById(R.id.parent);
        this.j = findViewById(R.id.title);
        this.k = (ImageView) findViewById(R.id.back);
        this.l = (TextView) findViewById(R.id.title_text);
        this.c = (LinearLayout) findViewById(R.id.sign_remind);
        this.d = (LinearLayout) findViewById(R.id.sign_remind_on);
        this.e = (TextView) findViewById(R.id.sign_remind_text);
        this.f = (TextView) findViewById(R.id.sign_remind_on_text);
        this.g = (TextView) findViewById(R.id.sign_remind_time);
        this.h = (BdSwitchView) findViewById(R.id.sign_remind_on_switch);
    }

    protected void c() {
        this.k.setOnClickListener(new ah(this));
        this.h.setOnSwitchStateChangeListener(new ai(this));
        this.c.setOnClickListener(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        TiebaApplication e = TiebaApplication.e();
        if (e.ah()) {
            this.g.setText(getString(R.string.sign_remind_time, new Object[]{e.ai() > 9 ? String.valueOf(e.ai()) : "0" + e.ai(), e.aj() > 9 ? String.valueOf(e.aj()) : "0" + e.aj()}));
            this.c.setVisibility(0);
            if (!this.h.c()) {
                this.h.a();
                return;
            }
            return;
        }
        this.g.setText(R.string.close);
        this.c.setVisibility(8);
        if (this.h.c()) {
            this.h.b();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TiebaApplication e = TiebaApplication.e();
            ((TimePickerDialog) dialog).updateTime(e.ai(), e.aj());
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new ak(this, TiebaApplication.e()), 0, 0, true);
        timePickerDialog.setTitle(R.string.sign_remind);
        return timePickerDialog;
    }
}
