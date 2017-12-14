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
    private EditText dVi;
    private TextView geA;
    private RelativeLayout geB;
    TextView get;
    View geu;
    View gev;
    TextView gew;
    TextView gex;
    TextView gey;
    private e gez;
    View mLine;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.get = (TextView) findViewById(d.g.friend_name_show1);
        this.geu = findViewById(d.g.friend_name_layout);
        this.gev = findViewById(d.g.msg_content_layout);
        this.gew = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gex = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gey = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.geB = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.geA = (TextView) findViewById(d.g.screenlock_send_button);
        this.dVi = (EditText) findViewById(d.g.screenlock_edit_view);
        this.geB.setVisibility(8);
    }

    public void f(e eVar) {
        this.gez = eVar;
        this.get.setText(eVar.groupName);
        this.gew.setText(cL(eVar.lastTime));
        this.gex.setText(eVar.content);
        this.gey.setText(th(eVar.gep));
    }

    public void mn(boolean z) {
        if (z) {
            this.geB.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.geB.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cL(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String th(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dVi != null) {
            return k.a(this.dVi.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dVi;
    }

    public e getData() {
        return this.gez;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.geA.setOnClickListener(onClickListener);
        this.geu.setOnClickListener(onClickListener2);
        this.gev.setOnClickListener(onClickListener2);
    }
}
