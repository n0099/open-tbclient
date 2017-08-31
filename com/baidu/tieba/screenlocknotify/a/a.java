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
import com.baidu.tieba.d;
import com.baidu.tieba.screenlocknotify.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends LinearLayout {
    View aXa;
    private EditText dHA;
    TextView fLa;
    View fLb;
    View fLc;
    TextView fLd;
    TextView fLe;
    TextView fLf;
    private e fLg;
    private TextView fLh;
    private RelativeLayout fLi;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fLa = (TextView) findViewById(d.h.friend_name_show1);
        this.fLb = findViewById(d.h.friend_name_layout);
        this.fLc = findViewById(d.h.msg_content_layout);
        this.fLd = (TextView) findViewById(d.h.last_msg_time_show1);
        this.fLe = (TextView) findViewById(d.h.one_msg_content_show1);
        this.fLf = (TextView) findViewById(d.h.unread_msg_count_show1);
        this.aXa = findViewById(d.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.g.screen_notify_item_background);
        setOrientation(1);
        this.fLi = (RelativeLayout) findViewById(d.h.screenlock_input_layout);
        this.fLh = (TextView) findViewById(d.h.screenlock_send_button);
        this.dHA = (EditText) findViewById(d.h.screenlock_edit_view);
        this.fLi.setVisibility(8);
    }

    public void f(e eVar) {
        this.fLg = eVar;
        this.fLa.setText(eVar.groupName);
        this.fLd.setText(cB(eVar.lastTime));
        this.fLe.setText(eVar.content);
        this.fLf.setText(sk(eVar.fKW));
    }

    public void lQ(boolean z) {
        if (z) {
            this.fLi.setVisibility(0);
            this.aXa.setVisibility(8);
            return;
        }
        this.fLi.setVisibility(8);
        this.aXa.setVisibility(0);
    }

    public String cB(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sk(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dHA != null) {
            return j.a(this.dHA.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dHA;
    }

    public e getData() {
        return this.fLg;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fLh.setOnClickListener(onClickListener);
        this.fLb.setOnClickListener(onClickListener2);
        this.fLc.setOnClickListener(onClickListener2);
    }
}
