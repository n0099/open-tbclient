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
    private TextView eaM;
    TextView iSs;
    View iSt;
    View iSu;
    TextView iSv;
    TextView iSw;
    TextView iSx;
    private d iSy;
    private RelativeLayout iSz;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.iSs = (TextView) findViewById(R.id.friend_name_show1);
        this.iSt = findViewById(R.id.friend_name_layout);
        this.iSu = findViewById(R.id.msg_content_layout);
        this.iSv = (TextView) findViewById(R.id.last_msg_time_show1);
        this.iSw = (TextView) findViewById(R.id.one_msg_content_show1);
        this.iSx = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.iSz = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.eaM = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.iSz.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.iSy = dVar;
        this.iSs.setText(dVar.groupName);
        this.iSv.setText(ex(dVar.lastTime));
        this.iSw.setText(dVar.content);
        this.iSx.setText(Ab(dVar.iSo));
    }

    public void qD(boolean z) {
        if (z) {
            this.iSz.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.iSz.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String ex(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String Ab(int i) {
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
        return this.iSy;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.eaM.setOnClickListener(onClickListener);
        this.iSt.setOnClickListener(onClickListener2);
        this.iSu.setOnClickListener(onClickListener2);
    }
}
