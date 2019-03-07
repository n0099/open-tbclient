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
    private TextView dLp;
    TextView iqb;
    View iqc;
    View iqd;
    TextView iqe;
    TextView iqf;
    TextView iqg;
    private d iqh;
    private RelativeLayout iqi;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.iqb = (TextView) findViewById(d.g.friend_name_show1);
        this.iqc = findViewById(d.g.friend_name_layout);
        this.iqd = findViewById(d.g.msg_content_layout);
        this.iqe = (TextView) findViewById(d.g.last_msg_time_show1);
        this.iqf = (TextView) findViewById(d.g.one_msg_content_show1);
        this.iqg = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.iqi = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.dLp = (TextView) findViewById(d.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(d.g.screenlock_edit_view);
        this.iqi.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(com.baidu.tieba.screenlocknotify.d dVar) {
        this.iqh = dVar;
        this.iqb.setText(dVar.groupName);
        this.iqe.setText(dM(dVar.lastTime));
        this.iqf.setText(dVar.content);
        this.iqg.setText(yn(dVar.ipX));
    }

    public void pu(boolean z) {
        if (z) {
            this.iqi.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.iqi.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String dM(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String yn(int i) {
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
        return this.iqh;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.dLp.setOnClickListener(onClickListener);
        this.iqc.setOnClickListener(onClickListener2);
        this.iqd.setOnClickListener(onClickListener2);
    }
}
