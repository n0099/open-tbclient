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
/* loaded from: classes.dex */
public class a extends LinearLayout {
    View arO;
    private EditText dhM;
    TextView fiK;
    View fiL;
    View fiM;
    TextView fiN;
    TextView fiO;
    TextView fiP;
    private s fiQ;
    private TextView fiR;
    private RelativeLayout fiS;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(w.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fiK = (TextView) findViewById(w.h.friend_name_show1);
        this.fiL = findViewById(w.h.friend_name_layout);
        this.fiM = findViewById(w.h.msg_content_layout);
        this.fiN = (TextView) findViewById(w.h.last_msg_time_show1);
        this.fiO = (TextView) findViewById(w.h.one_msg_content_show1);
        this.fiP = (TextView) findViewById(w.h.unread_msg_count_show1);
        this.arO = findViewById(w.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(w.g.screen_notify_item_background);
        setOrientation(1);
        this.fiS = (RelativeLayout) findViewById(w.h.screenlock_input_layout);
        this.fiR = (TextView) findViewById(w.h.screenlock_send_button);
        this.dhM = (EditText) findViewById(w.h.screenlock_edit_view);
        this.fiS.setVisibility(8);
    }

    public void f(s sVar) {
        this.fiQ = sVar;
        this.fiK.setText(sVar.groupName);
        this.fiN.setText(cx(sVar.lastTime));
        this.fiO.setText(sVar.content);
        this.fiP.setText(re(sVar.fiG));
    }

    public void kN(boolean z) {
        if (z) {
            this.fiS.setVisibility(0);
            this.arO.setVisibility(8);
            return;
        }
        this.fiS.setVisibility(8);
        this.arO.setVisibility(0);
    }

    public String cx(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String re(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.dhM != null) {
            return j.a(this.dhM.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dhM;
    }

    public s getData() {
        return this.fiQ;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fiR.setOnClickListener(onClickListener);
        this.fiL.setOnClickListener(onClickListener2);
        this.fiM.setOnClickListener(onClickListener2);
    }
}
