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
    TextView gKG;
    View gKH;
    View gKI;
    TextView gKJ;
    TextView gKK;
    TextView gKL;
    private e gKM;
    private TextView gKN;
    private RelativeLayout gKO;
    View mLine;
    private EditText rE;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gKG = (TextView) findViewById(d.g.friend_name_show1);
        this.gKH = findViewById(d.g.friend_name_layout);
        this.gKI = findViewById(d.g.msg_content_layout);
        this.gKJ = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gKK = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gKL = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gKO = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gKN = (TextView) findViewById(d.g.screenlock_send_button);
        this.rE = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gKO.setVisibility(8);
    }

    public void f(e eVar) {
        this.gKM = eVar;
        this.gKG.setText(eVar.groupName);
        this.gKJ.setText(cN(eVar.dUc));
        this.gKK.setText(eVar.content);
        this.gKL.setText(uG(eVar.gKC));
    }

    public void me(boolean z) {
        if (z) {
            this.gKO.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gKO.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cN(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String uG(int i) {
        return i < 100 ? "" + i : "99+";
    }

    public String getInputMsg() {
        if (this.rE != null) {
            return k.a(this.rE.getText(), null);
        }
        return null;
    }

    public View getEditText() {
        return this.rE;
    }

    public e getData() {
        return this.gKM;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gKN.setOnClickListener(onClickListener);
        this.gKH.setOnClickListener(onClickListener2);
        this.gKI.setOnClickListener(onClickListener2);
    }
}
