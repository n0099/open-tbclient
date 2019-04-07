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
import com.baidu.tieba.d;
import com.baidu.tieba.screenlocknotify.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ScreenLockHeaderView extends LinearLayout {
    private TextView dKC;
    TextView ipF;
    View ipG;
    View ipH;
    TextView ipI;
    TextView ipJ;
    TextView ipK;
    private d ipL;
    private RelativeLayout ipM;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.ipF = (TextView) findViewById(d.g.friend_name_show1);
        this.ipG = findViewById(d.g.friend_name_layout);
        this.ipH = findViewById(d.g.msg_content_layout);
        this.ipI = (TextView) findViewById(d.g.last_msg_time_show1);
        this.ipJ = (TextView) findViewById(d.g.one_msg_content_show1);
        this.ipK = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.ipM = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.dKC = (TextView) findViewById(d.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(d.g.screenlock_edit_view);
        this.ipM.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(com.baidu.tieba.screenlocknotify.d dVar) {
        this.ipL = dVar;
        this.ipF.setText(dVar.groupName);
        this.ipI.setText(dM(dVar.lastTime));
        this.ipJ.setText(dVar.content);
        this.ipK.setText(yj(dVar.ipB));
    }

    public void pu(boolean z) {
        if (z) {
            this.ipM.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.ipM.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String dM(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String yj(int i) {
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

    public com.baidu.tieba.screenlocknotify.d getData() {
        return this.ipL;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.dKC.setOnClickListener(onClickListener);
        this.ipG.setOnClickListener(onClickListener2);
        this.ipH.setOnClickListener(onClickListener2);
    }
}
