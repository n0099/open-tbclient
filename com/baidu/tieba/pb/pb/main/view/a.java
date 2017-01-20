package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView eqG;
    private RadioButton eqH;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eqG = (TextView) findViewById(r.h.custom_check_radio_button_tv);
        this.eqH = (RadioButton) findViewById(r.h.custom_check_radio_button_rb);
        aOt();
        setOnClickListener(new b(this));
    }

    public void aOt() {
        if (this.eqG != null) {
            ap.a(this.eqG, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eqG;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eqH != null) {
            this.eqH.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eqH;
    }

    public void setText(String str) {
        if (this.eqG != null) {
            this.eqG.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eqH != null) {
            this.eqH.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eqH.getTag();
    }

    public void setChecked(boolean z) {
        this.eqH.setChecked(z);
    }
}
