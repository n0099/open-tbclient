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
public class SignRemindActivity extends com.baidu.tieba.g {
    private LinearLayout a;
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
        com.baidu.tieba.util.x.b(this.g, i);
        com.baidu.tieba.util.x.d(this.j, i);
        com.baidu.tieba.util.x.a(this.k, i);
        com.baidu.tieba.util.x.f(this.l, i);
        ImageView imageView = (ImageView) findViewById(R.id.arrow);
        if (i == 1) {
            int a = com.baidu.tieba.util.x.a(i);
            com.baidu.tieba.util.x.h(this.a, (int) R.drawable.more_all_1);
            com.baidu.tieba.util.x.h(this.b, (int) R.drawable.more_all_1);
            this.e.setTextColor(-11446171);
            this.f.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            i2 = a;
        } else {
            int color = getResources().getColor(R.color.more_color);
            com.baidu.tieba.util.x.h(this.a, (int) R.drawable.more_all);
            com.baidu.tieba.util.x.h(this.b, (int) R.drawable.more_all);
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
        this.a = (LinearLayout) findViewById(R.id.sign_remind);
        this.b = (LinearLayout) findViewById(R.id.sign_remind_on);
        this.c = (TextView) findViewById(R.id.sign_remind_text);
        this.d = (TextView) findViewById(R.id.sign_remind_on_text);
        this.e = (TextView) findViewById(R.id.sign_remind_time);
        this.f = (BdSwitchView) findViewById(R.id.sign_remind_on_switch);
    }

    protected void c() {
        this.k.setOnClickListener(new ah(this));
        this.f.setOnSwitchStateChangeListener(new ai(this));
        this.a.setOnClickListener(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        TiebaApplication f = TiebaApplication.f();
        if (f.ai()) {
            this.e.setText(getString(R.string.sign_remind_time, new Object[]{f.aj() > 9 ? String.valueOf(f.aj()) : "0" + f.aj(), f.ak() > 9 ? String.valueOf(f.ak()) : "0" + f.ak()}));
            this.a.setVisibility(0);
            if (!this.f.c()) {
                this.f.a();
                return;
            }
            return;
        }
        this.e.setText(R.string.close);
        this.a.setVisibility(8);
        if (this.f.c()) {
            this.f.b();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TiebaApplication f = TiebaApplication.f();
            ((TimePickerDialog) dialog).updateTime(f.aj(), f.ak());
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new ak(this, TiebaApplication.f()), 0, 0, true);
        timePickerDialog.setTitle(R.string.sign_remind);
        return timePickerDialog;
    }
}
