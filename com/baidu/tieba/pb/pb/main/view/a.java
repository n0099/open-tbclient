package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView eDx;
    private RadioButton eDy;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eDx = (TextView) findViewById(r.g.custom_check_radio_button_tv);
        this.eDy = (RadioButton) findViewById(r.g.custom_check_radio_button_rb);
        aSK();
        setOnClickListener(new b(this));
    }

    public void aSK() {
        if (this.eDx != null) {
            at.a(this.eDx, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eDx;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eDy != null) {
            this.eDy.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eDy;
    }

    public void setText(String str) {
        if (this.eDx != null) {
            this.eDx.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eDy != null) {
            this.eDy.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eDy.getTag();
    }

    public void setChecked(boolean z) {
        this.eDy.setChecked(z);
    }
}
