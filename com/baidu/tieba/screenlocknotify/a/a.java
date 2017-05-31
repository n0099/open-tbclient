package com.baidu.tieba.screenlocknotify.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.screenlocknotify.s;
import com.baidu.tieba.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends LinearLayout {
    View arA;
    private EditText dhk;
    TextView fmA;
    TextView fmB;
    TextView fmC;
    private s fmD;
    private TextView fmE;
    private RelativeLayout fmF;
    TextView fmx;
    View fmy;
    View fmz;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(w.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fmx = (TextView) findViewById(w.h.friend_name_show1);
        this.fmy = findViewById(w.h.friend_name_layout);
        this.fmz = findViewById(w.h.msg_content_layout);
        this.fmA = (TextView) findViewById(w.h.last_msg_time_show1);
        this.fmB = (TextView) findViewById(w.h.one_msg_content_show1);
        this.fmC = (TextView) findViewById(w.h.unread_msg_count_show1);
        this.arA = findViewById(w.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(w.g.screen_notify_item_background);
        setOrientation(1);
        this.fmF = (RelativeLayout) findViewById(w.h.screenlock_input_layout);
        this.fmE = (TextView) findViewById(w.h.screenlock_send_button);
        this.dhk = (EditText) findViewById(w.h.screenlock_edit_view);
        this.fmF.setVisibility(8);
    }

    public void f(s sVar) {
        this.fmD = sVar;
        this.fmx.setText(sVar.groupName);
        this.fmA.setText(cn(sVar.lastTime));
        this.fmB.setText(sVar.content);
        this.fmC.setText(rt(sVar.fmt));
    }

    public void kN(boolean z) {
        if (z) {
            this.fmF.setVisibility(0);
            this.arA.setVisibility(8);
            return;
        }
        this.fmF.setVisibility(8);
        this.arA.setVisibility(0);
    }

    public String cn(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String rt(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.dhk != null) {
            return j.a(this.dhk.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dhk;
    }

    public s getData() {
        return this.fmD;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fmE.setOnClickListener(onClickListener);
        this.fmy.setOnClickListener(onClickListener2);
        this.fmz.setOnClickListener(onClickListener2);
    }
}
