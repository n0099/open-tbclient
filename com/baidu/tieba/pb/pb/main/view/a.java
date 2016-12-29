package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView ehy;
    private RadioButton ehz;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.ehy = (TextView) findViewById(r.g.custom_check_radio_button_tv);
        this.ehz = (RadioButton) findViewById(r.g.custom_check_radio_button_rb);
        aMB();
        setOnClickListener(new b(this));
    }

    public void aMB() {
        if (this.ehy != null) {
            ar.a(this.ehy, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.ehy;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.ehz != null) {
            this.ehz.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.ehz;
    }

    public void setText(String str) {
        if (this.ehy != null) {
            this.ehy.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.ehz != null) {
            this.ehz.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.ehz.getTag();
    }

    public void setChecked(boolean z) {
        this.ehz.setChecked(z);
    }
}
