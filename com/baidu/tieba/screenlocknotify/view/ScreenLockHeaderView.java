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
    TextView gNA;
    private d gNB;
    private TextView gNC;
    private RelativeLayout gND;
    TextView gNv;
    View gNw;
    View gNx;
    TextView gNy;
    TextView gNz;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(e.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gNv = (TextView) findViewById(e.g.friend_name_show1);
        this.gNw = findViewById(e.g.friend_name_layout);
        this.gNx = findViewById(e.g.msg_content_layout);
        this.gNy = (TextView) findViewById(e.g.last_msg_time_show1);
        this.gNz = (TextView) findViewById(e.g.one_msg_content_show1);
        this.gNA = (TextView) findViewById(e.g.unread_msg_count_show1);
        this.mLine = findViewById(e.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(e.f.screen_notify_item_background);
        setOrientation(1);
        this.gND = (RelativeLayout) findViewById(e.g.screenlock_input_layout);
        this.gNC = (TextView) findViewById(e.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(e.g.screenlock_edit_view);
        this.gND.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.gNB = dVar;
        this.gNv.setText(dVar.groupName);
        this.gNy.setText(cV(dVar.lastTime));
        this.gNz.setText(dVar.content);
        this.gNA.setText(tO(dVar.gNr));
    }

    public void mO(boolean z) {
        if (z) {
            this.gND.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gND.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cV(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String tO(int i) {
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
        return this.gNB;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gNC.setOnClickListener(onClickListener);
        this.gNw.setOnClickListener(onClickListener2);
        this.gNx.setOnClickListener(onClickListener2);
    }
}
