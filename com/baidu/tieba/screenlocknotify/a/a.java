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
    private EditText dMp;
    TextView fSg;
    View fSh;
    View fSi;
    TextView fSj;
    TextView fSk;
    TextView fSl;
    private e fSm;
    private TextView fSn;
    private RelativeLayout fSo;
    View mLine;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.fSg = (TextView) findViewById(d.g.friend_name_show1);
        this.fSh = findViewById(d.g.friend_name_layout);
        this.fSi = findViewById(d.g.msg_content_layout);
        this.fSj = (TextView) findViewById(d.g.last_msg_time_show1);
        this.fSk = (TextView) findViewById(d.g.one_msg_content_show1);
        this.fSl = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.fSo = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.fSn = (TextView) findViewById(d.g.screenlock_send_button);
        this.dMp = (EditText) findViewById(d.g.screenlock_edit_view);
        this.fSo.setVisibility(8);
    }

    public void f(e eVar) {
        this.fSm = eVar;
        this.fSg.setText(eVar.groupName);
        this.fSj.setText(cD(eVar.lastTime));
        this.fSk.setText(eVar.content);
        this.fSl.setText(sJ(eVar.fSc));
    }

    public void lM(boolean z) {
        if (z) {
            this.fSo.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.fSo.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cD(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sJ(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dMp != null) {
            return k.a(this.dMp.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dMp;
    }

    public e getData() {
        return this.fSm;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fSn.setOnClickListener(onClickListener);
        this.fSh.setOnClickListener(onClickListener2);
        this.fSi.setOnClickListener(onClickListener2);
    }
}
