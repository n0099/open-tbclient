package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView dpP;
    private RadioButton dpQ;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.dpP = (TextView) findViewById(t.g.custom_check_radio_button_tv);
        this.dpQ = (RadioButton) findViewById(t.g.custom_check_radio_button_rb);
        azN();
        setOnClickListener(new b(this));
    }

    public void azN() {
        if (this.dpP != null) {
            at.a(this.dpP, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.dpP;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.dpQ != null) {
            this.dpQ.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.dpQ;
    }

    public void setText(String str) {
        if (this.dpP != null) {
            this.dpP.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.dpQ != null) {
            this.dpQ.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.dpQ.getTag();
    }

    public void setChecked(boolean z) {
        this.dpQ.setChecked(z);
    }
}
