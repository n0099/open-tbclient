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
    private TextView erQ;
    private RadioButton erR;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.erQ = (TextView) findViewById(w.h.custom_check_radio_button_tv);
        this.erR = (RadioButton) findViewById(w.h.custom_check_radio_button_rb);
        aNU();
        setOnClickListener(new b(this));
    }

    public void aNU() {
        if (this.erQ != null) {
            aq.a(this.erQ, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.erQ;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.erR != null) {
            this.erR.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.erR;
    }

    public void setText(String str) {
        if (this.erQ != null) {
            this.erQ.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.erR != null) {
            this.erR.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.erR.getTag();
    }

    public void setChecked(boolean z) {
        this.erR.setChecked(z);
    }
}
