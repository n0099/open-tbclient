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
    private TextView eUy;
    private RadioButton eUz;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eUy = (TextView) findViewById(d.h.custom_check_radio_button_tv);
        this.eUz = (RadioButton) findViewById(d.h.custom_check_radio_button_rb);
        aUo();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eUz != null) {
                    a.this.eUz.toggle();
                }
            }
        });
    }

    public void aUo() {
        if (this.eUy != null) {
            aj.a(this.eUy, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eUy;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eUz != null) {
            this.eUz.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eUz;
    }

    public void setText(String str) {
        if (this.eUy != null) {
            this.eUy.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eUz != null) {
            this.eUz.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eUz.getTag();
    }

    public void setChecked(boolean z) {
        this.eUz.setChecked(z);
    }
}
