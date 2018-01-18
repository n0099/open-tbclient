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
    TextView gHG;
    View gHH;
    View gHI;
    TextView gHJ;
    TextView gHK;
    TextView gHL;
    private e gHM;
    private TextView gHN;
    private RelativeLayout gHO;
    View mLine;
    private EditText rE;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gHG = (TextView) findViewById(d.g.friend_name_show1);
        this.gHH = findViewById(d.g.friend_name_layout);
        this.gHI = findViewById(d.g.msg_content_layout);
        this.gHJ = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gHK = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gHL = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gHO = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gHN = (TextView) findViewById(d.g.screenlock_send_button);
        this.rE = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gHO.setVisibility(8);
    }

    public void f(e eVar) {
        this.gHM = eVar;
        this.gHG.setText(eVar.groupName);
        this.gHJ.setText(cM(eVar.lastTime));
        this.gHK.setText(eVar.content);
        this.gHL.setText(uG(eVar.gHC));
    }

    public void lU(boolean z) {
        if (z) {
            this.gHO.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gHO.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cM(long j) {
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
        return this.gHM;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gHN.setOnClickListener(onClickListener);
        this.gHH.setOnClickListener(onClickListener2);
        this.gHI.setOnClickListener(onClickListener2);
    }
}
