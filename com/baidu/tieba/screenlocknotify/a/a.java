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
import com.baidu.tieba.r;
import com.baidu.tieba.screenlocknotify.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    View ame;
    private EditText deH;
    private s faA;
    private TextView faB;
    private RelativeLayout faC;
    TextView fau;
    View fav;
    View faw;
    TextView fax;
    TextView fay;
    TextView faz;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(r.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fau = (TextView) findViewById(r.h.friend_name_show1);
        this.fav = findViewById(r.h.friend_name_layout);
        this.faw = findViewById(r.h.msg_content_layout);
        this.fax = (TextView) findViewById(r.h.last_msg_time_show1);
        this.fay = (TextView) findViewById(r.h.one_msg_content_show1);
        this.faz = (TextView) findViewById(r.h.unread_msg_count_show1);
        this.ame = findViewById(r.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(r.g.screen_notify_item_background);
        setOrientation(1);
        this.faC = (RelativeLayout) findViewById(r.h.screenlock_input_layout);
        this.faB = (TextView) findViewById(r.h.screenlock_send_button);
        this.deH = (EditText) findViewById(r.h.screenlock_edit_view);
        this.faC.setVisibility(8);
    }

    public void f(s sVar) {
        this.faA = sVar;
        this.fau.setText(sVar.groupName);
        this.fax.setText(cv(sVar.lastTime));
        this.fay.setText(sVar.content);
        this.faz.setText(rb(sVar.faq));
    }

    public void kD(boolean z) {
        if (z) {
            this.faC.setVisibility(0);
            this.ame.setVisibility(8);
            return;
        }
        this.faC.setVisibility(8);
        this.ame.setVisibility(0);
    }

    public String cv(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String rb(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.deH != null) {
            return j.a(this.deH.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.deH;
    }

    public s getData() {
        return this.faA;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.faB.setOnClickListener(onClickListener);
        this.fav.setOnClickListener(onClickListener2);
        this.faw.setOnClickListener(onClickListener2);
    }
}
