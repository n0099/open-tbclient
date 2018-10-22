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
import com.baidu.tieba.e;
import com.baidu.tieba.screenlocknotify.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ScreenLockHeaderView extends LinearLayout {
    TextView gLW;
    View gLX;
    View gLY;
    TextView gLZ;
    TextView gMa;
    TextView gMb;
    private d gMc;
    private TextView gMd;
    private RelativeLayout gMe;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(e.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gLW = (TextView) findViewById(e.g.friend_name_show1);
        this.gLX = findViewById(e.g.friend_name_layout);
        this.gLY = findViewById(e.g.msg_content_layout);
        this.gLZ = (TextView) findViewById(e.g.last_msg_time_show1);
        this.gMa = (TextView) findViewById(e.g.one_msg_content_show1);
        this.gMb = (TextView) findViewById(e.g.unread_msg_count_show1);
        this.mLine = findViewById(e.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(e.f.screen_notify_item_background);
        setOrientation(1);
        this.gMe = (RelativeLayout) findViewById(e.g.screenlock_input_layout);
        this.gMd = (TextView) findViewById(e.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(e.g.screenlock_edit_view);
        this.gMe.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.gMc = dVar;
        this.gLW.setText(dVar.groupName);
        this.gLZ.setText(da(dVar.lastTime));
        this.gMa.setText(dVar.content);
        this.gMb.setText(tv(dVar.gLS));
    }

    public void mD(boolean z) {
        if (z) {
            this.gMe.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gMe.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String da(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String tv(int i) {
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
        return this.gMc;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gMd.setOnClickListener(onClickListener);
        this.gLX.setOnClickListener(onClickListener2);
        this.gLY.setOnClickListener(onClickListener2);
    }
}
