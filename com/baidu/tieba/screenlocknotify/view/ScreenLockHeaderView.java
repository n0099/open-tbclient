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
/* loaded from: classes21.dex */
public class ScreenLockHeaderView extends LinearLayout {
    private EditText mEditText;
    View mLine;
    TextView mxF;
    View mxG;
    View mxH;
    TextView mxI;
    TextView mxJ;
    TextView mxK;
    private d mxL;
    private TextView mxM;
    private RelativeLayout mxN;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.mxF = (TextView) findViewById(R.id.friend_name_show1);
        this.mxG = findViewById(R.id.friend_name_layout);
        this.mxH = findViewById(R.id.msg_content_layout);
        this.mxI = (TextView) findViewById(R.id.last_msg_time_show1);
        this.mxJ = (TextView) findViewById(R.id.one_msg_content_show1);
        this.mxK = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.mxN = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.mxM = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.mxN.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.mxL = dVar;
        this.mxF.setText(dVar.groupName);
        this.mxI.setText(gy(dVar.lastTime));
        this.mxJ.setText(dVar.content);
        this.mxK.setText(Ie(dVar.unreadCount));
    }

    public void wF(boolean z) {
        if (z) {
            this.mxN.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.mxN.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String gy(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String Ie(int i) {
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
        return this.mxL;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mxM.setOnClickListener(onClickListener);
        this.mxG.setOnClickListener(onClickListener2);
        this.mxH.setOnClickListener(onClickListener2);
    }
}
