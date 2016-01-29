package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView cSI;
    private RadioButton cSJ;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.cSI = (TextView) findViewById(t.g.custom_check_radio_button_tv);
        this.cSJ = (RadioButton) findViewById(t.g.custom_check_radio_button_rb);
        arL();
        setOnClickListener(new b(this));
    }

    public void arL() {
        if (this.cSI != null) {
            ar.a(this.cSI, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.cSI;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.cSJ != null) {
            this.cSJ.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.cSJ;
    }

    public void setText(String str) {
        if (this.cSI != null) {
            this.cSI.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.cSJ != null) {
            this.cSJ.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.cSJ.getTag();
    }

    public void setChecked(boolean z) {
        this.cSJ.setChecked(z);
    }
}
