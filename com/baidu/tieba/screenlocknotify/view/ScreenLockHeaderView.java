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
/* loaded from: classes3.dex */
public class ScreenLockHeaderView extends LinearLayout {
    private TextView dYV;
    TextView iOS;
    View iOT;
    View iOU;
    TextView iOV;
    TextView iOW;
    TextView iOX;
    private d iOY;
    private RelativeLayout iOZ;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.iOS = (TextView) findViewById(R.id.friend_name_show1);
        this.iOT = findViewById(R.id.friend_name_layout);
        this.iOU = findViewById(R.id.msg_content_layout);
        this.iOV = (TextView) findViewById(R.id.last_msg_time_show1);
        this.iOW = (TextView) findViewById(R.id.one_msg_content_show1);
        this.iOX = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.iOZ = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.dYV = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.iOZ.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.iOY = dVar;
        this.iOS.setText(dVar.groupName);
        this.iOV.setText(eu(dVar.lastTime));
        this.iOW.setText(dVar.content);
        this.iOX.setText(zW(dVar.iOO));
    }

    public void qz(boolean z) {
        if (z) {
            this.iOZ.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.iOZ.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String eu(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String zW(int i) {
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
        return this.iOY;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.dYV.setOnClickListener(onClickListener);
        this.iOT.setOnClickListener(onClickListener2);
        this.iOU.setOnClickListener(onClickListener2);
    }
}
