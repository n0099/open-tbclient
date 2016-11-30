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
    View anv;
    private EditText dsz;
    TextView fne;
    View fnf;
    View fng;
    TextView fnh;
    TextView fni;
    TextView fnj;
    private s fnk;
    private TextView fnl;
    private RelativeLayout fnm;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(r.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.fne = (TextView) findViewById(r.g.friend_name_show1);
        this.fnf = findViewById(r.g.friend_name_layout);
        this.fng = findViewById(r.g.msg_content_layout);
        this.fnh = (TextView) findViewById(r.g.last_msg_time_show1);
        this.fni = (TextView) findViewById(r.g.one_msg_content_show1);
        this.fnj = (TextView) findViewById(r.g.unread_msg_count_show1);
        this.anv = findViewById(r.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(r.f.screen_notify_item_background);
        setOrientation(1);
        this.fnm = (RelativeLayout) findViewById(r.g.screenlock_input_layout);
        this.fnl = (TextView) findViewById(r.g.screenlock_send_button);
        this.dsz = (EditText) findViewById(r.g.screenlock_edit_view);
        this.fnm.setVisibility(8);
    }

    public void f(s sVar) {
        this.fnk = sVar;
        this.fne.setText(sVar.groupName);
        this.fnh.setText(cU(sVar.lastTime));
        this.fni.setText(sVar.content);
        this.fnj.setText(rq(sVar.fna));
    }

    public void kI(boolean z) {
        if (z) {
            this.fnm.setVisibility(0);
            this.anv.setVisibility(8);
            return;
        }
        this.fnm.setVisibility(8);
        this.anv.setVisibility(0);
    }

    public String cU(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String rq(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.dsz != null) {
            return j.a(this.dsz.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dsz;
    }

    public s getData() {
        return this.fnk;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fnl.setOnClickListener(onClickListener);
        this.fnf.setOnClickListener(onClickListener2);
        this.fng.setOnClickListener(onClickListener2);
    }
}
