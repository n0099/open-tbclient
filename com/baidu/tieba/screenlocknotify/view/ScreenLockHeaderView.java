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
/* loaded from: classes21.dex */
public class ScreenLockHeaderView extends LinearLayout {
    TextView mDG;
    View mDH;
    View mDI;
    TextView mDJ;
    TextView mDK;
    TextView mDL;
    private d mDM;
    private TextView mDN;
    private RelativeLayout mDO;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.mDG = (TextView) findViewById(R.id.friend_name_show1);
        this.mDH = findViewById(R.id.friend_name_layout);
        this.mDI = findViewById(R.id.msg_content_layout);
        this.mDJ = (TextView) findViewById(R.id.last_msg_time_show1);
        this.mDK = (TextView) findViewById(R.id.one_msg_content_show1);
        this.mDL = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.mDO = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.mDN = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.mDO.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.mDM = dVar;
        this.mDG.setText(dVar.groupName);
        this.mDJ.setText(gU(dVar.lastTime));
        this.mDK.setText(dVar.content);
        this.mDL.setText(Ir(dVar.unreadCount));
    }

    public void wO(boolean z) {
        if (z) {
            this.mDO.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.mDO.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String gU(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String Ir(int i) {
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
        return this.mDM;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mDN.setOnClickListener(onClickListener);
        this.mDH.setOnClickListener(onClickListener2);
        this.mDI.setOnClickListener(onClickListener2);
    }
}
