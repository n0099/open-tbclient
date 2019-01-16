package com.baidu.tieba.screenlocknotify.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.e;
import com.baidu.tieba.screenlocknotify.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ScreenLockHeaderView extends LinearLayout {
    private TextView cwu;
    TextView gYl;
    View gYm;
    View gYn;
    TextView gYo;
    TextView gYp;
    TextView gYq;
    private d gYr;
    private RelativeLayout gYs;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(e.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gYl = (TextView) findViewById(e.g.friend_name_show1);
        this.gYm = findViewById(e.g.friend_name_layout);
        this.gYn = findViewById(e.g.msg_content_layout);
        this.gYo = (TextView) findViewById(e.g.last_msg_time_show1);
        this.gYp = (TextView) findViewById(e.g.one_msg_content_show1);
        this.gYq = (TextView) findViewById(e.g.unread_msg_count_show1);
        this.mLine = findViewById(e.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(e.f.screen_notify_item_background);
        setOrientation(1);
        this.gYs = (RelativeLayout) findViewById(e.g.screenlock_input_layout);
        this.cwu = (TextView) findViewById(e.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(e.g.screenlock_edit_view);
        this.gYs.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.gYr = dVar;
        this.gYl.setText(dVar.groupName);
        this.gYo.setText(dh(dVar.lastTime));
        this.gYp.setText(dVar.content);
        this.gYq.setText(uy(dVar.gYh));
    }

    public void mV(boolean z) {
        if (z) {
            this.gYs.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gYs.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String dh(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String uy(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.mEditText != null) {
            return k.a(this.mEditText.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.mEditText;
    }

    public d getData() {
        return this.gYr;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.cwu.setOnClickListener(onClickListener);
        this.gYm.setOnClickListener(onClickListener2);
        this.gYn.setOnClickListener(onClickListener2);
    }
}
