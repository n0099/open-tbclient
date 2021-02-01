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
import com.baidu.tieba.R;
import com.baidu.tieba.screenlocknotify.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes8.dex */
public class ScreenLockHeaderView extends LinearLayout {
    private EditText cBd;
    View mLine;
    TextView nco;
    View ncp;
    View ncq;
    TextView ncr;
    TextView ncs;
    TextView nct;
    private d ncu;
    private TextView ncv;
    private RelativeLayout ncw;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.nco = (TextView) findViewById(R.id.friend_name_show1);
        this.ncp = findViewById(R.id.friend_name_layout);
        this.ncq = findViewById(R.id.msg_content_layout);
        this.ncr = (TextView) findViewById(R.id.last_msg_time_show1);
        this.ncs = (TextView) findViewById(R.id.one_msg_content_show1);
        this.nct = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.ncw = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.ncv = (TextView) findViewById(R.id.screenlock_send_button);
        this.cBd = (EditText) findViewById(R.id.screenlock_edit_view);
        this.ncw.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.ncu = dVar;
        this.nco.setText(dVar.groupName);
        this.ncr.setText(hC(dVar.lastTime));
        this.ncs.setText(dVar.content);
        this.nct.setText(Iq(dVar.ncl));
    }

    public void xL(boolean z) {
        if (z) {
            this.ncw.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.ncw.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String hC(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String Iq(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.cBd != null) {
            return k.charSequence2String(this.cBd.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.cBd;
    }

    public d getData() {
        return this.ncu;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ncv.setOnClickListener(onClickListener);
        this.ncp.setOnClickListener(onClickListener2);
        this.ncq.setOnClickListener(onClickListener2);
    }
}
