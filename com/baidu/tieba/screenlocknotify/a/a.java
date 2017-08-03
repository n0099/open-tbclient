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
    View atu;
    private EditText dxI;
    TextView fJV;
    View fJW;
    View fJX;
    TextView fJY;
    TextView fJZ;
    TextView fKa;
    private e fKb;
    private TextView fKc;
    private RelativeLayout fKd;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fJV = (TextView) findViewById(d.h.friend_name_show1);
        this.fJW = findViewById(d.h.friend_name_layout);
        this.fJX = findViewById(d.h.msg_content_layout);
        this.fJY = (TextView) findViewById(d.h.last_msg_time_show1);
        this.fJZ = (TextView) findViewById(d.h.one_msg_content_show1);
        this.fKa = (TextView) findViewById(d.h.unread_msg_count_show1);
        this.atu = findViewById(d.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.g.screen_notify_item_background);
        setOrientation(1);
        this.fKd = (RelativeLayout) findViewById(d.h.screenlock_input_layout);
        this.fKc = (TextView) findViewById(d.h.screenlock_send_button);
        this.dxI = (EditText) findViewById(d.h.screenlock_edit_view);
        this.fKd.setVisibility(8);
    }

    public void f(e eVar) {
        this.fKb = eVar;
        this.fJV.setText(eVar.groupName);
        this.fJY.setText(cG(eVar.lastTime));
        this.fJZ.setText(eVar.content);
        this.fKa.setText(sd(eVar.fJR));
    }

    public void lH(boolean z) {
        if (z) {
            this.fKd.setVisibility(0);
            this.atu.setVisibility(8);
            return;
        }
        this.fKd.setVisibility(8);
        this.atu.setVisibility(0);
    }

    public String cG(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sd(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dxI != null) {
            return j.a(this.dxI.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dxI;
    }

    public e getData() {
        return this.fKb;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fKc.setOnClickListener(onClickListener);
        this.fJW.setOnClickListener(onClickListener2);
        this.fJX.setOnClickListener(onClickListener2);
    }
}
