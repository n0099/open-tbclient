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
import com.baidu.tieba.d;
import com.baidu.tieba.screenlocknotify.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ScreenLockHeaderView extends LinearLayout {
    TextView gxd;
    View gxe;
    View gxf;
    TextView gxg;
    TextView gxh;
    TextView gxi;
    private d gxj;
    private TextView gxk;
    private RelativeLayout gxl;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gxd = (TextView) findViewById(d.g.friend_name_show1);
        this.gxe = findViewById(d.g.friend_name_layout);
        this.gxf = findViewById(d.g.msg_content_layout);
        this.gxg = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gxh = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gxi = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gxl = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gxk = (TextView) findViewById(d.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gxl.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(com.baidu.tieba.screenlocknotify.d dVar) {
        this.gxj = dVar;
        this.gxd.setText(dVar.groupName);
        this.gxg.setText(cP(dVar.lastTime));
        this.gxh.setText(dVar.content);
        this.gxi.setText(sA(dVar.gwZ));
    }

    public void lM(boolean z) {
        if (z) {
            this.gxl.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gxl.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cP(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sA(int i) {
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

    public com.baidu.tieba.screenlocknotify.d getData() {
        return this.gxj;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gxk.setOnClickListener(onClickListener);
        this.gxe.setOnClickListener(onClickListener2);
        this.gxf.setOnClickListener(onClickListener2);
    }
}
