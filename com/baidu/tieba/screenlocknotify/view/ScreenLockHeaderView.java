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
    TextView ncO;
    View ncP;
    View ncQ;
    TextView ncR;
    TextView ncS;
    TextView ncT;
    private d ncU;
    private TextView ncV;
    private RelativeLayout ncW;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.ncO = (TextView) findViewById(R.id.friend_name_show1);
        this.ncP = findViewById(R.id.friend_name_layout);
        this.ncQ = findViewById(R.id.msg_content_layout);
        this.ncR = (TextView) findViewById(R.id.last_msg_time_show1);
        this.ncS = (TextView) findViewById(R.id.one_msg_content_show1);
        this.ncT = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.ncW = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.ncV = (TextView) findViewById(R.id.screenlock_send_button);
        this.cBd = (EditText) findViewById(R.id.screenlock_edit_view);
        this.ncW.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.ncU = dVar;
        this.ncO.setText(dVar.groupName);
        this.ncR.setText(hC(dVar.lastTime));
        this.ncS.setText(dVar.content);
        this.ncT.setText(Iq(dVar.ncL));
    }

    public void xL(boolean z) {
        if (z) {
            this.ncW.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.ncW.setVisibility(8);
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
        return this.ncU;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ncV.setOnClickListener(onClickListener);
        this.ncP.setOnClickListener(onClickListener2);
        this.ncQ.setOnClickListener(onClickListener2);
    }
}
