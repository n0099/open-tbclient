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
    private TextView ePu;
    private RadioButton ePv;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.ePu = (TextView) findViewById(d.h.custom_check_radio_button_tv);
        this.ePv = (RadioButton) findViewById(d.h.custom_check_radio_button_rb);
        aSI();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ePv != null) {
                    a.this.ePv.toggle();
                }
            }
        });
    }

    public void aSI() {
        if (this.ePu != null) {
            aj.a(this.ePu, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.ePu;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.ePv != null) {
            this.ePv.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.ePv;
    }

    public void setText(String str) {
        if (this.ePu != null) {
            this.ePu.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.ePv != null) {
            this.ePv.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.ePv.getTag();
    }

    public void setChecked(boolean z) {
        this.ePv.setChecked(z);
    }
}
