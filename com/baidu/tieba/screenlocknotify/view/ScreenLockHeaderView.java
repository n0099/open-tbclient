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
    TextView kTN;
    View kTO;
    View kTP;
    TextView kTQ;
    TextView kTR;
    TextView kTS;
    private d kTT;
    private TextView kTU;
    private RelativeLayout kTV;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.kTN = (TextView) findViewById(R.id.friend_name_show1);
        this.kTO = findViewById(R.id.friend_name_layout);
        this.kTP = findViewById(R.id.msg_content_layout);
        this.kTQ = (TextView) findViewById(R.id.last_msg_time_show1);
        this.kTR = (TextView) findViewById(R.id.one_msg_content_show1);
        this.kTS = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.kTV = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.kTU = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.kTV.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.kTT = dVar;
        this.kTN.setText(dVar.groupName);
        this.kTQ.setText(fn(dVar.lastTime));
        this.kTR.setText(dVar.content);
        this.kTS.setText(CJ(dVar.unreadCount));
    }

    public void tP(boolean z) {
        if (z) {
            this.kTV.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.kTV.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String fn(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String CJ(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.mEditText != null) {
            return k.charSequence2String(this.mEditText.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.mEditText;
    }

    public d getData() {
        return this.kTT;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kTU.setOnClickListener(onClickListener);
        this.kTO.setOnClickListener(onClickListener2);
        this.kTP.setOnClickListener(onClickListener2);
    }
}
