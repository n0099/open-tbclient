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
import com.baidu.tieba.f;
import com.baidu.tieba.screenlocknotify.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ScreenLockHeaderView extends LinearLayout {
    TextView gxg;
    View gxh;
    View gxi;
    TextView gxj;
    TextView gxk;
    TextView gxl;
    private d gxm;
    private TextView gxn;
    private RelativeLayout gxo;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(f.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gxg = (TextView) findViewById(f.g.friend_name_show1);
        this.gxh = findViewById(f.g.friend_name_layout);
        this.gxi = findViewById(f.g.msg_content_layout);
        this.gxj = (TextView) findViewById(f.g.last_msg_time_show1);
        this.gxk = (TextView) findViewById(f.g.one_msg_content_show1);
        this.gxl = (TextView) findViewById(f.g.unread_msg_count_show1);
        this.mLine = findViewById(f.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(f.C0146f.screen_notify_item_background);
        setOrientation(1);
        this.gxo = (RelativeLayout) findViewById(f.g.screenlock_input_layout);
        this.gxn = (TextView) findViewById(f.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(f.g.screenlock_edit_view);
        this.gxo.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.gxm = dVar;
        this.gxg.setText(dVar.groupName);
        this.gxj.setText(cP(dVar.lastTime));
        this.gxk.setText(dVar.content);
        this.gxl.setText(sA(dVar.gxc));
    }

    public void lM(boolean z) {
        if (z) {
            this.gxo.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gxo.setVisibility(8);
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

    public d getData() {
        return this.gxm;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gxn.setOnClickListener(onClickListener);
        this.gxh.setOnClickListener(onClickListener2);
        this.gxi.setOnClickListener(onClickListener2);
    }
}
