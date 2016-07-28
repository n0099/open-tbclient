package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView eiQ;
    private RadioButton eiR;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(u.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eiQ = (TextView) findViewById(u.g.custom_check_radio_button_tv);
        this.eiR = (RadioButton) findViewById(u.g.custom_check_radio_button_rb);
        aLm();
        setOnClickListener(new b(this));
    }

    public void aLm() {
        if (this.eiQ != null) {
            av.a(this.eiQ, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eiQ;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eiR != null) {
            this.eiR.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eiR;
    }

    public void setText(String str) {
        if (this.eiQ != null) {
            this.eiQ.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eiR != null) {
            this.eiR.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eiR.getTag();
    }

    public void setChecked(boolean z) {
        this.eiR.setChecked(z);
    }
}
