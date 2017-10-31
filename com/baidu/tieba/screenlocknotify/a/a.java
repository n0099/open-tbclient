package com.baidu.tieba.screenlocknotify.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
import com.baidu.tieba.screenlocknotify.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends LinearLayout {
    private EditText dMk;
    TextView fRe;
    View fRf;
    View fRg;
    TextView fRh;
    TextView fRi;
    TextView fRj;
    private e fRk;
    private TextView fRl;
    private RelativeLayout fRm;
    View mLine;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.fRe = (TextView) findViewById(d.g.friend_name_show1);
        this.fRf = findViewById(d.g.friend_name_layout);
        this.fRg = findViewById(d.g.msg_content_layout);
        this.fRh = (TextView) findViewById(d.g.last_msg_time_show1);
        this.fRi = (TextView) findViewById(d.g.one_msg_content_show1);
        this.fRj = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.fRm = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.fRl = (TextView) findViewById(d.g.screenlock_send_button);
        this.dMk = (EditText) findViewById(d.g.screenlock_edit_view);
        this.fRm.setVisibility(8);
    }

    public void f(e eVar) {
        this.fRk = eVar;
        this.fRe.setText(eVar.groupName);
        this.fRh.setText(cB(eVar.lastTime));
        this.fRi.setText(eVar.content);
        this.fRj.setText(sG(eVar.fRa));
    }

    public void lE(boolean z) {
        if (z) {
            this.fRm.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.fRm.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cB(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sG(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dMk != null) {
            return k.a(this.dMk.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dMk;
    }

    public e getData() {
        return this.fRk;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fRl.setOnClickListener(onClickListener);
        this.fRf.setOnClickListener(onClickListener2);
        this.fRg.setOnClickListener(onClickListener2);
    }
}
