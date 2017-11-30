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
    private EditText dUd;
    TextView gbM;
    View gbN;
    View gbO;
    TextView gbP;
    TextView gbQ;
    TextView gbR;
    private e gbS;
    private TextView gbT;
    private RelativeLayout gbU;
    View mLine;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gbM = (TextView) findViewById(d.g.friend_name_show1);
        this.gbN = findViewById(d.g.friend_name_layout);
        this.gbO = findViewById(d.g.msg_content_layout);
        this.gbP = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gbQ = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gbR = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gbU = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gbT = (TextView) findViewById(d.g.screenlock_send_button);
        this.dUd = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gbU.setVisibility(8);
    }

    public void f(e eVar) {
        this.gbS = eVar;
        this.gbM.setText(eVar.groupName);
        this.gbP.setText(cK(eVar.lastTime));
        this.gbQ.setText(eVar.content);
        this.gbR.setText(sW(eVar.gbI));
    }

    public void ml(boolean z) {
        if (z) {
            this.gbU.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gbU.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cK(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sW(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dUd != null) {
            return k.a(this.dUd.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dUd;
    }

    public e getData() {
        return this.gbS;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gbT.setOnClickListener(onClickListener);
        this.gbN.setOnClickListener(onClickListener2);
        this.gbO.setOnClickListener(onClickListener2);
    }
}
