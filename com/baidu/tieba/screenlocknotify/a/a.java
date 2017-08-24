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
    View auO;
    private EditText dAX;
    TextView fNc;
    View fNd;
    View fNe;
    TextView fNf;
    TextView fNg;
    TextView fNh;
    private e fNi;
    private TextView fNj;
    private RelativeLayout fNk;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fNc = (TextView) findViewById(d.h.friend_name_show1);
        this.fNd = findViewById(d.h.friend_name_layout);
        this.fNe = findViewById(d.h.msg_content_layout);
        this.fNf = (TextView) findViewById(d.h.last_msg_time_show1);
        this.fNg = (TextView) findViewById(d.h.one_msg_content_show1);
        this.fNh = (TextView) findViewById(d.h.unread_msg_count_show1);
        this.auO = findViewById(d.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.g.screen_notify_item_background);
        setOrientation(1);
        this.fNk = (RelativeLayout) findViewById(d.h.screenlock_input_layout);
        this.fNj = (TextView) findViewById(d.h.screenlock_send_button);
        this.dAX = (EditText) findViewById(d.h.screenlock_edit_view);
        this.fNk.setVisibility(8);
    }

    public void f(e eVar) {
        this.fNi = eVar;
        this.fNc.setText(eVar.groupName);
        this.fNf.setText(cG(eVar.lastTime));
        this.fNg.setText(eVar.content);
        this.fNh.setText(sn(eVar.fMY));
    }

    public void lK(boolean z) {
        if (z) {
            this.fNk.setVisibility(0);
            this.auO.setVisibility(8);
            return;
        }
        this.fNk.setVisibility(8);
        this.auO.setVisibility(0);
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
        return this.fNi;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fNj.setOnClickListener(onClickListener);
        this.fNd.setOnClickListener(onClickListener2);
        this.fNe.setOnClickListener(onClickListener2);
    }
}
