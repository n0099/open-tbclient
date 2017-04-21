package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView eui;
    private RadioButton euj;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eui = (TextView) findViewById(w.h.custom_check_radio_button_tv);
        this.euj = (RadioButton) findViewById(w.h.custom_check_radio_button_rb);
        aOV();
        setOnClickListener(new b(this));
    }

    public void aOV() {
        if (this.eui != null) {
            aq.a(this.eui, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eui;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.euj != null) {
            this.euj.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.euj;
    }

    public void setText(String str) {
        if (this.eui != null) {
            this.eui.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.euj != null) {
            this.euj.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.euj.getTag();
    }

    public void setChecked(boolean z) {
        this.euj.setChecked(z);
    }
}
