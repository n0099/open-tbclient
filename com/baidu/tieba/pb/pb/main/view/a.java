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
    private TextView eVQ;
    private RadioButton eVR;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eVQ = (TextView) findViewById(d.h.custom_check_radio_button_tv);
        this.eVR = (RadioButton) findViewById(d.h.custom_check_radio_button_rb);
        aVc();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eVR != null) {
                    a.this.eVR.toggle();
                }
            }
        });
    }

    public void aVc() {
        if (this.eVQ != null) {
            ai.a(this.eVQ, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eVQ;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eVR != null) {
            this.eVR.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eVR;
    }

    public void setText(String str) {
        if (this.eVQ != null) {
            this.eVQ.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eVR != null) {
            this.eVR.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eVR.getTag();
    }

    public void setChecked(boolean z) {
        this.eVR.setChecked(z);
    }
}
