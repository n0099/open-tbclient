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
    private EditText cDt;
    View mLine;
    TextView mXE;
    View mXF;
    View mXG;
    TextView mXH;
    TextView mXI;
    TextView mXJ;
    private d mXK;
    private TextView mXL;
    private RelativeLayout mXM;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.mXE = (TextView) findViewById(R.id.friend_name_show1);
        this.mXF = findViewById(R.id.friend_name_layout);
        this.mXG = findViewById(R.id.msg_content_layout);
        this.mXH = (TextView) findViewById(R.id.last_msg_time_show1);
        this.mXI = (TextView) findViewById(R.id.one_msg_content_show1);
        this.mXJ = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.mXM = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.mXL = (TextView) findViewById(R.id.screenlock_send_button);
        this.cDt = (EditText) findViewById(R.id.screenlock_edit_view);
        this.mXM.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.mXK = dVar;
        this.mXE.setText(dVar.groupName);
        this.mXH.setText(hx(dVar.lastTime));
        this.mXI.setText(dVar.content);
        this.mXJ.setText(JD(dVar.mXB));
    }

    public void xw(boolean z) {
        if (z) {
            this.mXM.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.mXM.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String hx(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String JD(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.cDt != null) {
            return k.charSequence2String(this.cDt.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.cDt;
    }

    public d getData() {
        return this.mXK;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mXL.setOnClickListener(onClickListener);
        this.mXF.setOnClickListener(onClickListener2);
        this.mXG.setOnClickListener(onClickListener2);
    }
}
