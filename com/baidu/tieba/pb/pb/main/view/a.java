package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView eVs;
    private RadioButton eVt;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eVs = (TextView) findViewById(d.h.custom_check_radio_button_tv);
        this.eVt = (RadioButton) findViewById(d.h.custom_check_radio_button_rb);
        aUz();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eVt != null) {
                    a.this.eVt.toggle();
                }
            }
        });
    }

    public void aUz() {
        if (this.eVs != null) {
            aj.a(this.eVs, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eVs;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eVt != null) {
            this.eVt.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eVt;
    }

    public void setText(String str) {
        if (this.eVs != null) {
            this.eVs.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eVt != null) {
            this.eVt.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eVt.getTag();
    }

    public void setChecked(boolean z) {
        this.eVt.setChecked(z);
    }
}
