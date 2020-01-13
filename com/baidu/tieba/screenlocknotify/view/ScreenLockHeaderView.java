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
/* loaded from: classes6.dex */
public class ScreenLockHeaderView extends LinearLayout {
    private TextView jOA;
    private RelativeLayout jOB;
    TextView jOt;
    View jOu;
    View jOv;
    TextView jOw;
    TextView jOx;
    TextView jOy;
    private d jOz;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.jOt = (TextView) findViewById(R.id.friend_name_show1);
        this.jOu = findViewById(R.id.friend_name_layout);
        this.jOv = findViewById(R.id.msg_content_layout);
        this.jOw = (TextView) findViewById(R.id.last_msg_time_show1);
        this.jOx = (TextView) findViewById(R.id.one_msg_content_show1);
        this.jOy = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.jOB = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.jOA = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.jOB.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.jOz = dVar;
        this.jOt.setText(dVar.groupName);
        this.jOw.setText(eD(dVar.lastTime));
        this.jOx.setText(dVar.content);
        this.jOy.setText(Bg(dVar.unreadCount));
    }

    public void sh(boolean z) {
        if (z) {
            this.jOB.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.jOB.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String eD(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String Bg(int i) {
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
        return this.jOz;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jOA.setOnClickListener(onClickListener);
        this.jOu.setOnClickListener(onClickListener2);
        this.jOv.setOnClickListener(onClickListener2);
    }
}
