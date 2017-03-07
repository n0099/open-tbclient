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
/* loaded from: classes.dex */
public class a extends LinearLayout {
    View ary;
    private EditText dgY;
    TextView feQ;
    View feR;
    View feS;
    TextView feT;
    TextView feU;
    TextView feV;
    private s feW;
    private TextView feX;
    private RelativeLayout feY;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(w.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.feQ = (TextView) findViewById(w.h.friend_name_show1);
        this.feR = findViewById(w.h.friend_name_layout);
        this.feS = findViewById(w.h.msg_content_layout);
        this.feT = (TextView) findViewById(w.h.last_msg_time_show1);
        this.feU = (TextView) findViewById(w.h.one_msg_content_show1);
        this.feV = (TextView) findViewById(w.h.unread_msg_count_show1);
        this.ary = findViewById(w.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(w.g.screen_notify_item_background);
        setOrientation(1);
        this.feY = (RelativeLayout) findViewById(w.h.screenlock_input_layout);
        this.feX = (TextView) findViewById(w.h.screenlock_send_button);
        this.dgY = (EditText) findViewById(w.h.screenlock_edit_view);
        this.feY.setVisibility(8);
    }

    public void f(s sVar) {
        this.feW = sVar;
        this.feQ.setText(sVar.groupName);
        this.feT.setText(cx(sVar.lastTime));
        this.feU.setText(sVar.content);
        this.feV.setText(ra(sVar.feM));
    }

    public void kB(boolean z) {
        if (z) {
            this.feY.setVisibility(0);
            this.ary.setVisibility(8);
            return;
        }
        this.feY.setVisibility(8);
        this.ary.setVisibility(0);
    }

    public String cx(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String ra(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public String getInputMsg() {
        if (this.dgY != null) {
            return j.a(this.dgY.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dgY;
    }

    public s getData() {
        return this.feW;
    }

    public void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.feX.setOnClickListener(onClickListener);
        this.feR.setOnClickListener(onClickListener2);
        this.feS.setOnClickListener(onClickListener2);
    }
}
