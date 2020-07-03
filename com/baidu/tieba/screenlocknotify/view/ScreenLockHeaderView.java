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
    TextView lnG;
    View lnH;
    View lnI;
    TextView lnJ;
    TextView lnK;
    TextView lnL;
    private d lnM;
    private TextView lnN;
    private RelativeLayout lnO;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.lnG = (TextView) findViewById(R.id.friend_name_show1);
        this.lnH = findViewById(R.id.friend_name_layout);
        this.lnI = findViewById(R.id.msg_content_layout);
        this.lnJ = (TextView) findViewById(R.id.last_msg_time_show1);
        this.lnK = (TextView) findViewById(R.id.one_msg_content_show1);
        this.lnL = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.lnO = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.lnN = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.lnO.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.lnM = dVar;
        this.lnG.setText(dVar.groupName);
        this.lnJ.setText(fq(dVar.lastTime));
        this.lnK.setText(dVar.content);
        this.lnL.setText(DL(dVar.unreadCount));
    }

    public void ue(boolean z) {
        if (z) {
            this.lnO.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.lnO.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String fq(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String DL(int i) {
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
        return this.lnM;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lnN.setOnClickListener(onClickListener);
        this.lnH.setOnClickListener(onClickListener2);
        this.lnI.setOnClickListener(onClickListener2);
    }
}
