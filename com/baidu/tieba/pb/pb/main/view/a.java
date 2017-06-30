package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView eGg;
    private RadioButton eGh;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eGg = (TextView) findViewById(w.h.custom_check_radio_button_tv);
        this.eGh = (RadioButton) findViewById(w.h.custom_check_radio_button_rb);
        aRs();
        setOnClickListener(new b(this));
    }

    public void aRs() {
        if (this.eGg != null) {
            as.a(this.eGg, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eGg;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eGh != null) {
            this.eGh.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eGh;
    }

    public void setText(String str) {
        if (this.eGg != null) {
            this.eGg.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eGh != null) {
            this.eGh.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eGh.getTag();
    }

    public void setChecked(boolean z) {
        this.eGh.setChecked(z);
    }
}
