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
    private EditText dfv;
    TextView fgr;
    View fgs;
    View fgt;
    TextView fgu;
    TextView fgv;
    TextView fgw;
    private s fgx;
    private TextView fgy;
    private RelativeLayout fgz;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(w.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fgr = (TextView) findViewById(w.h.friend_name_show1);
        this.fgs = findViewById(w.h.friend_name_layout);
        this.fgt = findViewById(w.h.msg_content_layout);
        this.fgu = (TextView) findViewById(w.h.last_msg_time_show1);
        this.fgv = (TextView) findViewById(w.h.one_msg_content_show1);
        this.fgw = (TextView) findViewById(w.h.unread_msg_count_show1);
        this.arO = findViewById(w.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(w.g.screen_notify_item_background);
        setOrientation(1);
        this.fgz = (RelativeLayout) findViewById(w.h.screenlock_input_layout);
        this.fgy = (TextView) findViewById(w.h.screenlock_send_button);
        this.dfv = (EditText) findViewById(w.h.screenlock_edit_view);
        this.fgz.setVisibility(8);
    }

    public void f(s sVar) {
        this.fgx = sVar;
        this.fgr.setText(sVar.groupName);
        this.fgu.setText(cx(sVar.lastTime));
        this.fgv.setText(sVar.content);
        this.fgw.setText(qY(sVar.fgn));
    }

    public void kD(boolean z) {
        if (z) {
            this.fgz.setVisibility(0);
            this.arO.setVisibility(8);
            return;
        }
        this.fgz.setVisibility(8);
        this.arO.setVisibility(0);
    }

    public String cx(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String qY(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.dfv != null) {
            return j.a(this.dfv.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dfv;
    }

    public s getData() {
        return this.fgx;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fgy.setOnClickListener(onClickListener);
        this.fgs.setOnClickListener(onClickListener2);
        this.fgt.setOnClickListener(onClickListener2);
    }
}
