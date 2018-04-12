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
import com.baidu.tieba.screenlocknotify.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ScreenLockHeaderView extends LinearLayout {
    TextView gfH;
    View gfI;
    View gfJ;
    TextView gfK;
    TextView gfL;
    TextView gfM;
    private e gfN;
    private TextView gfO;
    private RelativeLayout gfP;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.i.screenlock_show_item_header, (ViewGroup) this, true);
        this.gfH = (TextView) findViewById(d.g.friend_name_show1);
        this.gfI = findViewById(d.g.friend_name_layout);
        this.gfJ = findViewById(d.g.msg_content_layout);
        this.gfK = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gfL = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gfM = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gfP = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gfO = (TextView) findViewById(d.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gfP.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(e eVar) {
        this.gfN = eVar;
        this.gfH.setText(eVar.groupName);
        this.gfK.setText(cR(eVar.dok));
        this.gfL.setText(eVar.content);
        this.gfM.setText(si(eVar.gfD));
    }

    public void lK(boolean z) {
        if (z) {
            this.gfP.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gfP.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cR(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String si(int i) {
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

    public e getData() {
        return this.gfN;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gfO.setOnClickListener(onClickListener);
        this.gfI.setOnClickListener(onClickListener2);
        this.gfJ.setOnClickListener(onClickListener2);
    }
}
