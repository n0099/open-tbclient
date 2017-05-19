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
    private TextView epL;
    private RadioButton epM;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.epL = (TextView) findViewById(w.h.custom_check_radio_button_tv);
        this.epM = (RadioButton) findViewById(w.h.custom_check_radio_button_rb);
        aMk();
        setOnClickListener(new b(this));
    }

    public void aMk() {
        if (this.epL != null) {
            aq.a(this.epL, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.epL;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.epM != null) {
            this.epM.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.epM;
    }

    public void setText(String str) {
        if (this.epL != null) {
            this.epL.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.epM != null) {
            this.epM.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.epM.getTag();
    }

    public void setChecked(boolean z) {
        this.epM.setChecked(z);
    }
}
