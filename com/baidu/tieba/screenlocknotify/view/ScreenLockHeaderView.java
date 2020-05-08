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
    TextView kAC;
    View kAD;
    View kAE;
    TextView kAF;
    TextView kAG;
    TextView kAH;
    private d kAI;
    private TextView kAJ;
    private RelativeLayout kAK;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.kAC = (TextView) findViewById(R.id.friend_name_show1);
        this.kAD = findViewById(R.id.friend_name_layout);
        this.kAE = findViewById(R.id.msg_content_layout);
        this.kAF = (TextView) findViewById(R.id.last_msg_time_show1);
        this.kAG = (TextView) findViewById(R.id.one_msg_content_show1);
        this.kAH = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.kAK = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.kAJ = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.kAK.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.kAI = dVar;
        this.kAC.setText(dVar.groupName);
        this.kAF.setText(fn(dVar.lastTime));
        this.kAG.setText(dVar.content);
        this.kAH.setText(BX(dVar.unreadCount));
    }

    public void tr(boolean z) {
        if (z) {
            this.kAK.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.kAK.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String fn(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String BX(int i) {
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
        return this.kAI;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kAJ.setOnClickListener(onClickListener);
        this.kAD.setOnClickListener(onClickListener2);
        this.kAE.setOnClickListener(onClickListener2);
    }
}
