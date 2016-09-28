package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView exd;
    private RadioButton exe;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.exd = (TextView) findViewById(r.g.custom_check_radio_button_tv);
        this.exe = (RadioButton) findViewById(r.g.custom_check_radio_button_rb);
        aQM();
        setOnClickListener(new b(this));
    }

    public void aQM() {
        if (this.exd != null) {
            av.a(this.exd, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.exd;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.exe != null) {
            this.exe.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.exe;
    }

    public void setText(String str) {
        if (this.exd != null) {
            this.exd.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.exe != null) {
            this.exe.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.exe.getTag();
    }

    public void setChecked(boolean z) {
        this.exe.setChecked(z);
    }
}
