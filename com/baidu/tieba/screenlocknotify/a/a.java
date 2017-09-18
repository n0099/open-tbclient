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
    View aWX;
    private EditText dIv;
    TextView fLT;
    View fLU;
    View fLV;
    TextView fLW;
    TextView fLX;
    TextView fLY;
    private e fLZ;
    private TextView fMa;
    private RelativeLayout fMb;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fLT = (TextView) findViewById(d.h.friend_name_show1);
        this.fLU = findViewById(d.h.friend_name_layout);
        this.fLV = findViewById(d.h.msg_content_layout);
        this.fLW = (TextView) findViewById(d.h.last_msg_time_show1);
        this.fLX = (TextView) findViewById(d.h.one_msg_content_show1);
        this.fLY = (TextView) findViewById(d.h.unread_msg_count_show1);
        this.aWX = findViewById(d.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.g.screen_notify_item_background);
        setOrientation(1);
        this.fMb = (RelativeLayout) findViewById(d.h.screenlock_input_layout);
        this.fMa = (TextView) findViewById(d.h.screenlock_send_button);
        this.dIv = (EditText) findViewById(d.h.screenlock_edit_view);
        this.fMb.setVisibility(8);
    }

    public void f(e eVar) {
        this.fLZ = eVar;
        this.fLT.setText(eVar.groupName);
        this.fLW.setText(cB(eVar.lastTime));
        this.fLX.setText(eVar.content);
        this.fLY.setText(sm(eVar.fLP));
    }

    public void lR(boolean z) {
        if (z) {
            this.fMb.setVisibility(0);
            this.aWX.setVisibility(8);
            return;
        }
        this.fMb.setVisibility(8);
        this.aWX.setVisibility(0);
    }

    public String cB(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sm(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dIv != null) {
            return j.a(this.dIv.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dIv;
    }

    public e getData() {
        return this.fLZ;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fMa.setOnClickListener(onClickListener);
        this.fLU.setOnClickListener(onClickListener2);
        this.fLV.setOnClickListener(onClickListener2);
    }
}
