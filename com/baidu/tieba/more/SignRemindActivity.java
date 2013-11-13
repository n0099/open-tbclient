package com.baidu.tieba.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SignRemindActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1966a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private TextView e;
    private BdSwitchView f;
    private RelativeLayout g = null;
    private View h = null;
    private ImageView i = null;
    private TextView j = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.more_sign_remind_activity);
        a();
        c();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        bd.b(this.g, i);
        bd.d(this.h, i);
        bd.a(this.i, i);
        bd.e(this.j, i);
        ImageView imageView = (ImageView) findViewById(R.id.arrow);
        if (i == 1) {
            int a2 = bd.a(i);
            bd.e(this.f1966a, (int) R.drawable.more_all_1);
            bd.e(this.b, (int) R.drawable.more_all_1);
            this.e.setTextColor(-11446171);
            this.f.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            i2 = a2;
        } else {
            int color = getResources().getColor(R.color.more_color);
            bd.e(this.f1966a, (int) R.drawable.more_all);
            bd.e(this.b, (int) R.drawable.more_all);
            this.e.setTextColor(-5065030);
            this.f.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            i2 = color;
        }
        this.c.setTextColor(i2);
        this.d.setTextColor(i2);
    }

    void a() {
        this.g = (RelativeLayout) findViewById(R.id.parent);
        this.h = findViewById(R.id.title);
        this.i = (ImageView) findViewById(R.id.back);
        this.j = (TextView) findViewById(R.id.title_text);
        this.f1966a = (LinearLayout) findViewById(R.id.sign_remind);
        this.b = (LinearLayout) findViewById(R.id.sign_remind_on);
        this.c = (TextView) findViewById(R.id.sign_remind_text);
        this.d = (TextView) findViewById(R.id.sign_remind_on_text);
        this.e = (TextView) findViewById(R.id.sign_remind_time);
        this.f = (BdSwitchView) findViewById(R.id.sign_remind_on_switch);
    }

    protected void b() {
        this.i.setOnClickListener(new ao(this));
        this.f.setOnSwitchStateChangeListener(new ap(this));
        this.f1966a.setOnClickListener(new aq(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        TiebaApplication g = TiebaApplication.g();
        if (g.ae()) {
            this.e.setText(getString(R.string.sign_remind_time, new Object[]{g.af() > 9 ? String.valueOf(g.af()) : SocialConstants.FALSE + g.af(), g.ag() > 9 ? String.valueOf(g.ag()) : SocialConstants.FALSE + g.ag()}));
            this.f1966a.setVisibility(0);
            if (!this.f.c()) {
                this.f.a();
                return;
            }
            return;
        }
        this.e.setText(R.string.close);
        this.f1966a.setVisibility(8);
        if (this.f.c()) {
            this.f.b();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TiebaApplication g = TiebaApplication.g();
            ((TimePickerDialog) dialog).updateTime(g.af(), g.ag());
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new ar(this, TiebaApplication.g()), 0, 0, true);
        timePickerDialog.setTitle(R.string.sign_remind);
        return timePickerDialog;
    }
}
