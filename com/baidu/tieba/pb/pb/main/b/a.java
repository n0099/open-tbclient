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
    private TextView clR;
    private RadioButton clS;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(i.g.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.clR = (TextView) findViewById(i.f.custom_check_radio_button_tv);
        this.clS = (RadioButton) findViewById(i.f.custom_check_radio_button_rb);
        agT();
        setOnClickListener(new b(this));
    }

    public void agT() {
        if (this.clR != null) {
            an.a(this.clR, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.clR;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.clS != null) {
            this.clS.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.clS;
    }

    public void setText(String str) {
        if (this.clR != null) {
            this.clR.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.clS != null) {
            this.clS.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.clS.getTag();
    }

    public void setChecked(boolean z) {
        this.clS.setChecked(z);
    }
}
