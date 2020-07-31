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
/* loaded from: classes15.dex */
public class ScreenLockHeaderView extends LinearLayout {
    TextView lvb;
    View lvc;
    View lvd;
    TextView lve;
    TextView lvf;
    TextView lvg;
    private d lvh;
    private TextView lvi;
    private RelativeLayout lvj;
    private EditText mEditText;
    View mLine;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.lvb = (TextView) findViewById(R.id.friend_name_show1);
        this.lvc = findViewById(R.id.friend_name_layout);
        this.lvd = findViewById(R.id.msg_content_layout);
        this.lve = (TextView) findViewById(R.id.last_msg_time_show1);
        this.lvf = (TextView) findViewById(R.id.one_msg_content_show1);
        this.lvg = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.lvj = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.lvi = (TextView) findViewById(R.id.screenlock_send_button);
        this.mEditText = (EditText) findViewById(R.id.screenlock_edit_view);
        this.lvj.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.lvh = dVar;
        this.lvb.setText(dVar.groupName);
        this.lve.setText(fD(dVar.lastTime));
        this.lvf.setText(dVar.content);
        this.lvg.setText(Eh(dVar.unreadCount));
    }

    public void uI(boolean z) {
        if (z) {
            this.lvj.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.lvj.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String fD(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String Eh(int i) {
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
        return this.lvh;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lvi.setOnClickListener(onClickListener);
        this.lvc.setOnClickListener(onClickListener2);
        this.lvd.setOnClickListener(onClickListener2);
    }
}
