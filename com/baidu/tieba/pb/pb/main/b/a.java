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
    private TextView cGr;
    private RadioButton cGs;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(n.g.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.cGr = (TextView) findViewById(n.f.custom_check_radio_button_tv);
        this.cGs = (RadioButton) findViewById(n.f.custom_check_radio_button_rb);
        alZ();
        setOnClickListener(new b(this));
    }

    public void alZ() {
        if (this.cGr != null) {
            as.a(this.cGr, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.cGr;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.cGs != null) {
            this.cGs.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.cGs;
    }

    public void setText(String str) {
        if (this.cGr != null) {
            this.cGr.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.cGs != null) {
            this.cGs.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.cGs.getTag();
    }

    public void setChecked(boolean z) {
        this.cGs.setChecked(z);
    }
}
