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
    TextView iRq;
    View iRr;
    View iRs;
    TextView iRt;
    TextView iRu;
    TextView iRv;
    private d iRw;
    private TextView iRx;
    private RelativeLayout iRy;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.iRq = (TextView) findViewById(R.id.friend_name_show1);
        this.iRr = findViewById(R.id.friend_name_layout);
        this.iRs = findViewById(R.id.msg_content_layout);
        this.iRt = (TextView) findViewById(R.id.last_msg_time_show1);
        this.iRu = (TextView) findViewById(R.id.one_msg_content_show1);
        this.iRv = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.iRy = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.iRx = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.iRy.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.iRw = dVar;
        this.iRq.setText(dVar.groupName);
        this.iRt.setText(dS(dVar.lastTime));
        this.iRu.setText(dVar.content);
        this.iRv.setText(yH(dVar.iRm));
    }

    public void qm(boolean z) {
        if (z) {
            this.iRy.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.iRy.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String dS(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String yH(int i) {
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
        return this.iRw;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.iRx.setOnClickListener(onClickListener);
        this.iRr.setOnClickListener(onClickListener2);
        this.iRs.setOnClickListener(onClickListener2);
    }
}
