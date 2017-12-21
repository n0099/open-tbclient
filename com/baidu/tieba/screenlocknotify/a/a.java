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
    private EditText dVm;
    View geA;
    TextView geB;
    TextView geC;
    TextView geD;
    private e geE;
    private TextView geF;
    private RelativeLayout geG;
    TextView gey;
    View gez;
    View mLine;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gey = (TextView) findViewById(d.g.friend_name_show1);
        this.gez = findViewById(d.g.friend_name_layout);
        this.geA = findViewById(d.g.msg_content_layout);
        this.geB = (TextView) findViewById(d.g.last_msg_time_show1);
        this.geC = (TextView) findViewById(d.g.one_msg_content_show1);
        this.geD = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.geG = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.geF = (TextView) findViewById(d.g.screenlock_send_button);
        this.dVm = (EditText) findViewById(d.g.screenlock_edit_view);
        this.geG.setVisibility(8);
    }

    public void f(e eVar) {
        this.geE = eVar;
        this.gey.setText(eVar.groupName);
        this.geB.setText(cL(eVar.lastTime));
        this.geC.setText(eVar.content);
        this.geD.setText(th(eVar.geu));
    }

    public void mn(boolean z) {
        if (z) {
            this.geG.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.geG.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cL(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String th(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dVm != null) {
            return k.a(this.dVm.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dVm;
    }

    public e getData() {
        return this.geE;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.geF.setOnClickListener(onClickListener);
        this.gez.setOnClickListener(onClickListener2);
        this.geA.setOnClickListener(onClickListener2);
    }
}
