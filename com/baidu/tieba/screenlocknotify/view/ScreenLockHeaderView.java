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
    private TextView dVd;
    TextView iIA;
    View iIB;
    View iIC;
    TextView iID;
    TextView iIE;
    TextView iIF;
    private d iIG;
    private RelativeLayout iIH;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.iIA = (TextView) findViewById(R.id.friend_name_show1);
        this.iIB = findViewById(R.id.friend_name_layout);
        this.iIC = findViewById(R.id.msg_content_layout);
        this.iID = (TextView) findViewById(R.id.last_msg_time_show1);
        this.iIE = (TextView) findViewById(R.id.one_msg_content_show1);
        this.iIF = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.iIH = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.dVd = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.iIH.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.iIG = dVar;
        this.iIA.setText(dVar.groupName);
        this.iID.setText(ek(dVar.lastTime));
        this.iIE.setText(dVar.content);
        this.iIF.setText(zq(dVar.iIw));
    }

    public void qk(boolean z) {
        if (z) {
            this.iIH.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.iIH.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String ek(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String zq(int i) {
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
        return this.iIG;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.dVd.setOnClickListener(onClickListener);
        this.iIB.setOnClickListener(onClickListener2);
        this.iIC.setOnClickListener(onClickListener2);
    }
}
