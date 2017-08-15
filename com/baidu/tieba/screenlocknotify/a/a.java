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
    View auN;
    private EditText dAX;
    TextView fNb;
    View fNc;
    View fNd;
    TextView fNe;
    TextView fNf;
    TextView fNg;
    private e fNh;
    private TextView fNi;
    private RelativeLayout fNj;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fNb = (TextView) findViewById(d.h.friend_name_show1);
        this.fNc = findViewById(d.h.friend_name_layout);
        this.fNd = findViewById(d.h.msg_content_layout);
        this.fNe = (TextView) findViewById(d.h.last_msg_time_show1);
        this.fNf = (TextView) findViewById(d.h.one_msg_content_show1);
        this.fNg = (TextView) findViewById(d.h.unread_msg_count_show1);
        this.auN = findViewById(d.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.g.screen_notify_item_background);
        setOrientation(1);
        this.fNj = (RelativeLayout) findViewById(d.h.screenlock_input_layout);
        this.fNi = (TextView) findViewById(d.h.screenlock_send_button);
        this.dAX = (EditText) findViewById(d.h.screenlock_edit_view);
        this.fNj.setVisibility(8);
    }

    public void f(e eVar) {
        this.fNh = eVar;
        this.fNb.setText(eVar.groupName);
        this.fNe.setText(cG(eVar.lastTime));
        this.fNf.setText(eVar.content);
        this.fNg.setText(sn(eVar.fMX));
    }

    public void lK(boolean z) {
        if (z) {
            this.fNj.setVisibility(0);
            this.auN.setVisibility(8);
            return;
        }
        this.fNj.setVisibility(8);
        this.auN.setVisibility(0);
    }

    public String cG(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sn(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dAX != null) {
            return j.a(this.dAX.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dAX;
    }

    public e getData() {
        return this.fNh;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fNi.setOnClickListener(onClickListener);
        this.fNc.setOnClickListener(onClickListener2);
        this.fNd.setOnClickListener(onClickListener2);
    }
}
