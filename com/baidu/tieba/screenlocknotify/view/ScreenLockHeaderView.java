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
    TextView kSE;
    View kSF;
    View kSG;
    TextView kSH;
    TextView kSI;
    TextView kSJ;
    private d kSK;
    private TextView kSL;
    private RelativeLayout kSM;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.kSE = (TextView) findViewById(R.id.friend_name_show1);
        this.kSF = findViewById(R.id.friend_name_layout);
        this.kSG = findViewById(R.id.msg_content_layout);
        this.kSH = (TextView) findViewById(R.id.last_msg_time_show1);
        this.kSI = (TextView) findViewById(R.id.one_msg_content_show1);
        this.kSJ = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.kSM = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.kSL = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.kSM.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.kSK = dVar;
        this.kSE.setText(dVar.groupName);
        this.kSH.setText(fn(dVar.lastTime));
        this.kSI.setText(dVar.content);
        this.kSJ.setText(CH(dVar.unreadCount));
    }

    public void tP(boolean z) {
        if (z) {
            this.kSM.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.kSM.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String fn(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String CH(int i) {
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
        return this.kSK;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kSL.setOnClickListener(onClickListener);
        this.kSF.setOnClickListener(onClickListener2);
        this.kSG.setOnClickListener(onClickListener2);
    }
}
