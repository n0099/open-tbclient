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
    View iQA;
    View iQB;
    TextView iQC;
    TextView iQD;
    TextView iQE;
    private d iQF;
    private TextView iQG;
    private RelativeLayout iQH;
    TextView iQz;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.iQz = (TextView) findViewById(R.id.friend_name_show1);
        this.iQA = findViewById(R.id.friend_name_layout);
        this.iQB = findViewById(R.id.msg_content_layout);
        this.iQC = (TextView) findViewById(R.id.last_msg_time_show1);
        this.iQD = (TextView) findViewById(R.id.one_msg_content_show1);
        this.iQE = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.iQH = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.iQG = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.iQH.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.iQF = dVar;
        this.iQz.setText(dVar.groupName);
        this.iQC.setText(dR(dVar.lastTime));
        this.iQD.setText(dVar.content);
        this.iQE.setText(yG(dVar.iQv));
    }

    public void qm(boolean z) {
        if (z) {
            this.iQH.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.iQH.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String dR(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String yG(int i) {
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
        return this.iQF;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.iQG.setOnClickListener(onClickListener);
        this.iQA.setOnClickListener(onClickListener2);
        this.iQB.setOnClickListener(onClickListener2);
    }
}
