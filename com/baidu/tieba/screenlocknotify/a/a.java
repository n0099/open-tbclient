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
import com.baidu.tieba.screenlocknotify.s;
import com.baidu.tieba.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends LinearLayout {
    View arQ;
    private EditText dbN;
    TextView feF;
    View feG;
    View feH;
    TextView feI;
    TextView feJ;
    TextView feK;
    private s feL;
    private TextView feM;
    private RelativeLayout feN;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(w.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.feF = (TextView) findViewById(w.h.friend_name_show1);
        this.feG = findViewById(w.h.friend_name_layout);
        this.feH = findViewById(w.h.msg_content_layout);
        this.feI = (TextView) findViewById(w.h.last_msg_time_show1);
        this.feJ = (TextView) findViewById(w.h.one_msg_content_show1);
        this.feK = (TextView) findViewById(w.h.unread_msg_count_show1);
        this.arQ = findViewById(w.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(w.g.screen_notify_item_background);
        setOrientation(1);
        this.feN = (RelativeLayout) findViewById(w.h.screenlock_input_layout);
        this.feM = (TextView) findViewById(w.h.screenlock_send_button);
        this.dbN = (EditText) findViewById(w.h.screenlock_edit_view);
        this.feN.setVisibility(8);
    }

    public void f(s sVar) {
        this.feL = sVar;
        this.feF.setText(sVar.groupName);
        this.feI.setText(ci(sVar.lastTime));
        this.feJ.setText(sVar.content);
        this.feK.setText(qW(sVar.feB));
    }

    public void kt(boolean z) {
        if (z) {
            this.feN.setVisibility(0);
            this.arQ.setVisibility(8);
            return;
        }
        this.feN.setVisibility(8);
        this.arQ.setVisibility(0);
    }

    public String ci(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String qW(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.dbN != null) {
            return j.a(this.dbN.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dbN;
    }

    public s getData() {
        return this.feL;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.feM.setOnClickListener(onClickListener);
        this.feG.setOnClickListener(onClickListener2);
        this.feH.setOnClickListener(onClickListener2);
    }
}
