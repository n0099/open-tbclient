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
    View auM;
    private EditText dza;
    TextView fLh;
    View fLi;
    View fLj;
    TextView fLk;
    TextView fLl;
    TextView fLm;
    private e fLn;
    private TextView fLo;
    private RelativeLayout fLp;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fLh = (TextView) findViewById(d.h.friend_name_show1);
        this.fLi = findViewById(d.h.friend_name_layout);
        this.fLj = findViewById(d.h.msg_content_layout);
        this.fLk = (TextView) findViewById(d.h.last_msg_time_show1);
        this.fLl = (TextView) findViewById(d.h.one_msg_content_show1);
        this.fLm = (TextView) findViewById(d.h.unread_msg_count_show1);
        this.auM = findViewById(d.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.g.screen_notify_item_background);
        setOrientation(1);
        this.fLp = (RelativeLayout) findViewById(d.h.screenlock_input_layout);
        this.fLo = (TextView) findViewById(d.h.screenlock_send_button);
        this.dza = (EditText) findViewById(d.h.screenlock_edit_view);
        this.fLp.setVisibility(8);
    }

    public void f(e eVar) {
        this.fLn = eVar;
        this.fLh.setText(eVar.groupName);
        this.fLk.setText(cG(eVar.lastTime));
        this.fLl.setText(eVar.content);
        this.fLm.setText(sd(eVar.fLd));
    }

    public void lH(boolean z) {
        if (z) {
            this.fLp.setVisibility(0);
            this.auM.setVisibility(8);
            return;
        }
        this.fLp.setVisibility(8);
        this.auM.setVisibility(0);
    }

    public String cG(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sd(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dza != null) {
            return j.a(this.dza.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dza;
    }

    public e getData() {
        return this.fLn;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fLo.setOnClickListener(onClickListener);
        this.fLi.setOnClickListener(onClickListener2);
        this.fLj.setOnClickListener(onClickListener2);
    }
}
