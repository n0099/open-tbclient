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
    TextView gSA;
    TextView gSB;
    TextView gSC;
    private e gSD;
    private TextView gSE;
    private RelativeLayout gSF;
    TextView gSx;
    View gSy;
    View gSz;
    View mLine;
    private EditText rE;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gSx = (TextView) findViewById(d.g.friend_name_show1);
        this.gSy = findViewById(d.g.friend_name_layout);
        this.gSz = findViewById(d.g.msg_content_layout);
        this.gSA = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gSB = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gSC = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gSF = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gSE = (TextView) findViewById(d.g.screenlock_send_button);
        this.rE = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gSF.setVisibility(8);
    }

    public void f(e eVar) {
        this.gSD = eVar;
        this.gSx.setText(eVar.groupName);
        this.gSA.setText(cU(eVar.lastTime));
        this.gSB.setText(eVar.content);
        this.gSC.setText(wf(eVar.gSt));
    }

    public void mS(boolean z) {
        if (z) {
            this.gSF.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gSF.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cU(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String wf(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.rE != null) {
            return k.a(this.rE.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.rE;
    }

    public e getData() {
        return this.gSD;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gSE.setOnClickListener(onClickListener);
        this.gSy.setOnClickListener(onClickListener2);
        this.gSz.setOnClickListener(onClickListener2);
    }
}
