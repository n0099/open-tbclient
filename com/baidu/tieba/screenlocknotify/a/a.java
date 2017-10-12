package com.baidu.tieba.screenlocknotify.a;

import android.content.Context;
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
/* loaded from: classes2.dex */
public class a extends LinearLayout {
    View aYL;
    private EditText dEK;
    TextView fID;
    View fIE;
    View fIF;
    TextView fIG;
    TextView fIH;
    TextView fII;
    private e fIJ;
    private TextView fIK;
    private RelativeLayout fIL;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.j.screenlock_show_item_header, (ViewGroup) this, true);
        this.fID = (TextView) findViewById(d.h.friend_name_show1);
        this.fIE = findViewById(d.h.friend_name_layout);
        this.fIF = findViewById(d.h.msg_content_layout);
        this.fIG = (TextView) findViewById(d.h.last_msg_time_show1);
        this.fIH = (TextView) findViewById(d.h.one_msg_content_show1);
        this.fII = (TextView) findViewById(d.h.unread_msg_count_show1);
        this.aYL = findViewById(d.h.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.g.screen_notify_item_background);
        setOrientation(1);
        this.fIL = (RelativeLayout) findViewById(d.h.screenlock_input_layout);
        this.fIK = (TextView) findViewById(d.h.screenlock_send_button);
        this.dEK = (EditText) findViewById(d.h.screenlock_edit_view);
        this.fIL.setVisibility(8);
    }

    public void f(e eVar) {
        this.fIJ = eVar;
        this.fID.setText(eVar.groupName);
        this.fIG.setText(cz(eVar.lastTime));
        this.fIH.setText(eVar.content);
        this.fII.setText(sp(eVar.fIz));
    }

    public void lK(boolean z) {
        if (z) {
            this.fIL.setVisibility(0);
            this.aYL.setVisibility(8);
            return;
        }
        this.fIL.setVisibility(8);
        this.aYL.setVisibility(0);
    }

    public String cz(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String sp(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.dEK != null) {
            return k.a(this.dEK.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.dEK;
    }

    public e getData() {
        return this.fIJ;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fIK.setOnClickListener(onClickListener);
        this.fIE.setOnClickListener(onClickListener2);
        this.fIF.setOnClickListener(onClickListener2);
    }
}
