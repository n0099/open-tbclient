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
    View amY;
    private EditText cXt;
    TextView eQZ;
    View eRa;
    View eRb;
    TextView eRc;
    TextView eRd;
    TextView eRe;
    private s eRf;
    private TextView eRg;
    private RelativeLayout eRh;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(r.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.eQZ = (TextView) findViewById(r.g.friend_name_show1);
        this.eRa = findViewById(r.g.friend_name_layout);
        this.eRb = findViewById(r.g.msg_content_layout);
        this.eRc = (TextView) findViewById(r.g.last_msg_time_show1);
        this.eRd = (TextView) findViewById(r.g.one_msg_content_show1);
        this.eRe = (TextView) findViewById(r.g.unread_msg_count_show1);
        this.amY = findViewById(r.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(r.f.screen_notify_item_background);
        setOrientation(1);
        this.eRh = (RelativeLayout) findViewById(r.g.screenlock_input_layout);
        this.eRg = (TextView) findViewById(r.g.screenlock_send_button);
        this.cXt = (EditText) findViewById(r.g.screenlock_edit_view);
        this.eRh.setVisibility(8);
    }

    public void f(s sVar) {
        this.eRf = sVar;
        this.eQZ.setText(sVar.groupName);
        this.eRc.setText(cC(sVar.lastTime));
        this.eRd.setText(sVar.content);
        this.eRe.setText(qr(sVar.eQV));
    }

    public void kr(boolean z) {
        if (z) {
            this.eRh.setVisibility(0);
            this.amY.setVisibility(8);
            return;
        }
        this.eRh.setVisibility(8);
        this.amY.setVisibility(0);
    }

    public String cC(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String qr(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.cXt != null) {
            return j.a(this.cXt.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.cXt;
    }

    public s getData() {
        return this.eRf;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.eRg.setOnClickListener(onClickListener);
        this.eRa.setOnClickListener(onClickListener2);
        this.eRb.setOnClickListener(onClickListener2);
    }
}
