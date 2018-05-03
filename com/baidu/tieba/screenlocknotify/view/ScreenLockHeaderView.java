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
    TextView gfE;
    View gfF;
    View gfG;
    TextView gfH;
    TextView gfI;
    TextView gfJ;
    private e gfK;
    private TextView gfL;
    private RelativeLayout gfM;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.i.screenlock_show_item_header, (ViewGroup) this, true);
        this.gfE = (TextView) findViewById(d.g.friend_name_show1);
        this.gfF = findViewById(d.g.friend_name_layout);
        this.gfG = findViewById(d.g.msg_content_layout);
        this.gfH = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gfI = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gfJ = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gfM = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gfL = (TextView) findViewById(d.g.screenlock_send_button);
        this.mEditText = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gfM.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(e eVar) {
        this.gfK = eVar;
        this.gfE.setText(eVar.groupName);
        this.gfH.setText(cR(eVar.doh));
        this.gfI.setText(eVar.content);
        this.gfJ.setText(sh(eVar.gfA));
    }

    public void lK(boolean z) {
        if (z) {
            this.gfM.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gfM.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cR(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sh(int i) {
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
        return this.gfK;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gfL.setOnClickListener(onClickListener);
        this.gfF.setOnClickListener(onClickListener2);
        this.gfG.setOnClickListener(onClickListener2);
    }
}
