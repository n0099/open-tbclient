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
    TextView lVA;
    TextView lVB;
    TextView lVC;
    private d lVD;
    private TextView lVE;
    private RelativeLayout lVF;
    TextView lVx;
    View lVy;
    View lVz;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.lVx = (TextView) findViewById(R.id.friend_name_show1);
        this.lVy = findViewById(R.id.friend_name_layout);
        this.lVz = findViewById(R.id.msg_content_layout);
        this.lVA = (TextView) findViewById(R.id.last_msg_time_show1);
        this.lVB = (TextView) findViewById(R.id.one_msg_content_show1);
        this.lVC = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.lVF = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.lVE = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.lVF.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.lVD = dVar;
        this.lVx.setText(dVar.groupName);
        this.lVA.setText(gf(dVar.lastTime));
        this.lVB.setText(dVar.content);
        this.lVC.setText(Hf(dVar.unreadCount));
    }

    public void vH(boolean z) {
        if (z) {
            this.lVF.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.lVF.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String gf(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String Hf(int i) {
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
        return this.lVD;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lVE.setOnClickListener(onClickListener);
        this.lVy.setOnClickListener(onClickListener2);
        this.lVz.setOnClickListener(onClickListener2);
    }
}
