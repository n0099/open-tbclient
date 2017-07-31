package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView eTV;
    private RadioButton eTW;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eTV = (TextView) findViewById(d.h.custom_check_radio_button_tv);
        this.eTW = (RadioButton) findViewById(d.h.custom_check_radio_button_rb);
        aUA();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eTW != null) {
                    a.this.eTW.toggle();
                }
            }
        });
    }

    public void aUA() {
        if (this.eTV != null) {
            ai.a(this.eTV, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eTV;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eTW != null) {
            this.eTW.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eTW;
    }

    public void setText(String str) {
        if (this.eTV != null) {
            this.eTV.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eTW != null) {
            this.eTW.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eTW.getTag();
    }

    public void setChecked(boolean z) {
        this.eTW.setChecked(z);
    }
}
