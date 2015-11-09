package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView cng;
    private RadioButton cnh;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(i.g.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.cng = (TextView) findViewById(i.f.custom_check_radio_button_tv);
        this.cnh = (RadioButton) findViewById(i.f.custom_check_radio_button_rb);
        ahv();
        setOnClickListener(new b(this));
    }

    public void ahv() {
        if (this.cng != null) {
            an.a(this.cng, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.cng;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.cnh != null) {
            this.cnh.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.cnh;
    }

    public void setText(String str) {
        if (this.cng != null) {
            this.cng.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.cnh != null) {
            this.cnh.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.cnh.getTag();
    }

    public void setChecked(boolean z) {
        this.cnh.setChecked(z);
    }
}
