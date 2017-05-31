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
    private TextView ewK;
    private RadioButton ewL;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.ewK = (TextView) findViewById(w.h.custom_check_radio_button_tv);
        this.ewL = (RadioButton) findViewById(w.h.custom_check_radio_button_rb);
        aNs();
        setOnClickListener(new b(this));
    }

    public void aNs() {
        if (this.ewK != null) {
            aq.a(this.ewK, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.ewK;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.ewL != null) {
            this.ewL.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.ewL;
    }

    public void setText(String str) {
        if (this.ewK != null) {
            this.ewK.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.ewL != null) {
            this.ewL.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.ewL.getTag();
    }

    public void setChecked(boolean z) {
        this.ewL.setChecked(z);
    }
}
