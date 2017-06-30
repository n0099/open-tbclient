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
    View asD;
    private EditText dpg;
    TextView fwL;
    View fwM;
    View fwN;
    TextView fwO;
    TextView fwP;
    TextView fwQ;
    private s fwR;
    private TextView fwS;
    private RelativeLayout fwT;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(w.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fwL = (TextView) findViewById(w.h.friend_name_show1);
        this.fwM = findViewById(w.h.friend_name_layout);
        this.fwN = findViewById(w.h.msg_content_layout);
        this.fwO = (TextView) findViewById(w.h.last_msg_time_show1);
        this.fwP = (TextView) findViewById(w.h.one_msg_content_show1);
        this.fwQ = (TextView) findViewById(w.h.unread_msg_count_show1);
        this.asD = findViewById(w.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(w.g.screen_notify_item_background);
        setOrientation(1);
        this.fwT = (RelativeLayout) findViewById(w.h.screenlock_input_layout);
        this.fwS = (TextView) findViewById(w.h.screenlock_send_button);
        this.dpg = (EditText) findViewById(w.h.screenlock_edit_view);
        this.fwT.setVisibility(8);
    }

    public void f(s sVar) {
        this.fwR = sVar;
        this.fwL.setText(sVar.groupName);
        this.fwO.setText(cC(sVar.lastTime));
        this.fwP.setText(sVar.content);
        this.fwQ.setText(rM(sVar.fwH));
    }

    public void lm(boolean z) {
        if (z) {
            this.fwT.setVisibility(0);
            this.asD.setVisibility(8);
            return;
        }
        this.fwT.setVisibility(8);
        this.asD.setVisibility(0);
    }

    public String cC(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String rM(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.dpg != null) {
            return j.a(this.dpg.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dpg;
    }

    public s getData() {
        return this.fwR;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fwS.setOnClickListener(onClickListener);
        this.fwM.setOnClickListener(onClickListener2);
        this.fwN.setOnClickListener(onClickListener2);
    }
}
