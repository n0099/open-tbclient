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
    TextView gIb;
    View gIc;
    View gId;
    TextView gIe;
    TextView gIf;
    TextView gIg;
    private e gIh;
    private TextView gIi;
    private RelativeLayout gIj;
    View mLine;
    private EditText rE;

    public a(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(d.h.screenlock_show_item_header, (ViewGroup) this, true);
        this.gIb = (TextView) findViewById(d.g.friend_name_show1);
        this.gIc = findViewById(d.g.friend_name_layout);
        this.gId = findViewById(d.g.msg_content_layout);
        this.gIe = (TextView) findViewById(d.g.last_msg_time_show1);
        this.gIf = (TextView) findViewById(d.g.one_msg_content_show1);
        this.gIg = (TextView) findViewById(d.g.unread_msg_count_show1);
        this.mLine = findViewById(d.g.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(d.f.screen_notify_item_background);
        setOrientation(1);
        this.gIj = (RelativeLayout) findViewById(d.g.screenlock_input_layout);
        this.gIi = (TextView) findViewById(d.g.screenlock_send_button);
        this.rE = (EditText) findViewById(d.g.screenlock_edit_view);
        this.gIj.setVisibility(8);
    }

    public void f(e eVar) {
        this.gIh = eVar;
        this.gIb.setText(eVar.groupName);
        this.gIe.setText(cO(eVar.lastTime));
        this.gIf.setText(eVar.content);
        this.gIg.setText(uG(eVar.gHX));
    }

    public void lW(boolean z) {
        if (z) {
            this.gIj.setVisibility(0);
            this.mLine.setVisibility(8);
            return;
        }
        this.gIj.setVisibility(8);
        this.mLine.setVisibility(0);
    }

    public String cO(long j) {
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
        return this.gIh;
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gIi.setOnClickListener(onClickListener);
        this.gIc.setOnClickListener(onClickListener2);
        this.gId.setOnClickListener(onClickListener2);
    }
}
