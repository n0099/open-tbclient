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
/* loaded from: classes7.dex */
public class ScreenLockHeaderView extends LinearLayout {
    private EditText cCD;
    View mLine;
    TextView neT;
    View neU;
    View neV;
    TextView neW;
    TextView neX;
    TextView neY;
    private d neZ;
    private TextView nfa;
    private RelativeLayout nfb;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.neT = (TextView) findViewById(R.id.friend_name_show1);
        this.neU = findViewById(R.id.friend_name_layout);
        this.neV = findViewById(R.id.msg_content_layout);
        this.neW = (TextView) findViewById(R.id.last_msg_time_show1);
        this.neX = (TextView) findViewById(R.id.one_msg_content_show1);
        this.neY = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.mLine = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.nfb = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.nfa = (TextView) findViewById(R.id.screenlock_send_button);
        this.cCD = (EditText) findViewById(R.id.screenlock_edit_view);
        this.nfb.setVisibility(8);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void f(d dVar) {
        this.neZ = dVar;
        this.neT.setText(dVar.groupName);
        this.neW.setText(hC(dVar.lastTime));
        this.neX.setText(dVar.content);
        this.neY.setText(Iu(dVar.neQ));
    }

    public void xL(boolean z) {
        if (z) {
            this.nfb.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.nfb.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String hC(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String Iu(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.cCD != null) {
            return k.charSequence2String(this.cCD.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.cCD;
    }

    public d getData() {
        return this.neZ;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.nfa.setOnClickListener(onClickListener);
        this.neU.setOnClickListener(onClickListener2);
        this.neV.setOnClickListener(onClickListener2);
    }
}
