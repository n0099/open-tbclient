package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView cKq;
    private RadioButton cKr;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(n.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.cKq = (TextView) findViewById(n.g.custom_check_radio_button_tv);
        this.cKr = (RadioButton) findViewById(n.g.custom_check_radio_button_rb);
        anl();
        setOnClickListener(new b(this));
    }

    public void anl() {
        if (this.cKq != null) {
            as.a(this.cKq, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.cKq;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.cKr != null) {
            this.cKr.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.cKr;
    }

    public void setText(String str) {
        if (this.cKq != null) {
            this.cKq.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.cKr != null) {
            this.cKr.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.cKr.getTag();
    }

    public void setChecked(boolean z) {
        this.cKr.setChecked(z);
    }
}
