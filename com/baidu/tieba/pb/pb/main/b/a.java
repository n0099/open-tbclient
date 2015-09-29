package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView clG;
    private RadioButton clH;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(i.g.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.clG = (TextView) findViewById(i.f.custom_check_radio_button_tv);
        this.clH = (RadioButton) findViewById(i.f.custom_check_radio_button_rb);
        agT();
        setOnClickListener(new b(this));
    }

    public void agT() {
        if (this.clG != null) {
            am.a(this.clG, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.clG;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.clH != null) {
            this.clH.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.clH;
    }

    public void setText(String str) {
        if (this.clG != null) {
            this.clG.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.clH != null) {
            this.clH.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.clH.getTag();
    }

    public void setChecked(boolean z) {
        this.clH.setChecked(z);
    }
}
