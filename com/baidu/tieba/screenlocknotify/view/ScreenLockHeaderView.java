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
/* loaded from: classes20.dex */
public class ScreenLockHeaderView extends LinearLayout {
    TextView mEd;
    private EditText mEditText;
    View mEe;
    View mEf;
    TextView mEg;
    TextView mEh;
    TextView mEi;
    private d mEj;
    private TextView mEk;
    private RelativeLayout mEl;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.mEd = (TextView) findViewById(R.id.friend_name_show1);
        this.mEe = findViewById(R.id.friend_name_layout);
        this.mEf = findViewById(R.id.msg_content_layout);
        this.mEg = (TextView) findViewById(R.id.last_msg_time_show1);
        this.mEh = (TextView) findViewById(R.id.one_msg_content_show1);
        this.mEi = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.mEl = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.mEk = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.mEl.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.mEj = dVar;
        this.mEd.setText(dVar.groupName);
        this.mEg.setText(gX(dVar.lastTime));
        this.mEh.setText(dVar.content);
        this.mEi.setText(IS(dVar.unreadCount));
    }

    public void wR(boolean z) {
        if (z) {
            this.mEl.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.mEl.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String gX(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String IS(int i) {
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
        return this.mEj;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mEk.setOnClickListener(onClickListener);
        this.mEe.setOnClickListener(onClickListener2);
        this.mEf.setOnClickListener(onClickListener2);
    }
}
