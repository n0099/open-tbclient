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
    TextView gKH;
    View gKI;
    View gKJ;
    TextView gKK;
    TextView gKL;
    TextView gKM;
    private e gKN;
    private TextView gKO;
    private RelativeLayout gKP;
    View mLine;
    private EditText rD;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gKH = (TextView) findViewById(d.g.friend_name_show1);
        this.gKI = findViewById(d.g.friend_name_layout);
        this.gKJ = findViewById(d.g.msg_content_layout);
        this.gKK = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gKL = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gKM = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gKP = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gKO = (TextView) findViewById(d.g.screenlock_send_button);
        this.rD = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gKP.setVisibility(8);
    }

    public void f(e eVar) {
        this.gKN = eVar;
        this.gKH.setText(eVar.groupName);
        this.gKK.setText(cN(eVar.dTV));
        this.gKL.setText(eVar.content);
        this.gKM.setText(uH(eVar.gKD));
    }

    public void mj(boolean z) {
        if (z) {
            this.gKP.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gKP.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cN(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String uH(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.rD != null) {
            return k.a(this.rD.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.rD;
    }

    public e getData() {
        return this.gKN;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gKO.setOnClickListener(onClickListener);
        this.gKI.setOnClickListener(onClickListener2);
        this.gKJ.setOnClickListener(onClickListener2);
    }
}
