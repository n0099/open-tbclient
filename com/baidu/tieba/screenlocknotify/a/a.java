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
    private EditText dEw;
    TextView fIp;
    View fIq;
    View fIr;
    TextView fIs;
    TextView fIt;
    TextView fIu;
    private e fIv;
    private TextView fIw;
    private RelativeLayout fIx;
    View mLine;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fIp = (TextView) findViewById(d.h.friend_name_show1);
        this.fIq = findViewById(d.h.friend_name_layout);
        this.fIr = findViewById(d.h.msg_content_layout);
        this.fIs = (TextView) findViewById(d.h.last_msg_time_show1);
        this.fIt = (TextView) findViewById(d.h.one_msg_content_show1);
        this.fIu = (TextView) findViewById(d.h.unread_msg_count_show1);
        this.mLine = findViewById(d.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.g.screen_notify_item_background);
        setOrientation(1);
        this.fIx = (RelativeLayout) findViewById(d.h.screenlock_input_layout);
        this.fIw = (TextView) findViewById(d.h.screenlock_send_button);
        this.dEw = (EditText) findViewById(d.h.screenlock_edit_view);
        this.fIx.setVisibility(8);
    }

    public void f(e eVar) {
        this.fIv = eVar;
        this.fIp.setText(eVar.groupName);
        this.fIs.setText(cA(eVar.lastTime));
        this.fIt.setText(eVar.content);
        this.fIu.setText(so(eVar.fIl));
    }

    public void lJ(boolean z) {
        if (z) {
            this.fIx.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.fIx.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cA(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String so(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dEw != null) {
            return k.a(this.dEw.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dEw;
    }

    public e getData() {
        return this.fIv;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fIw.setOnClickListener(onClickListener);
        this.fIq.setOnClickListener(onClickListener2);
        this.fIr.setOnClickListener(onClickListener2);
    }
}
