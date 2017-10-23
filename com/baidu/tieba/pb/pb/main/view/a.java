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
    private TextView ePg;
    private RadioButton ePh;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.ePg = (TextView) findViewById(d.h.custom_check_radio_button_tv);
        this.ePh = (RadioButton) findViewById(d.h.custom_check_radio_button_rb);
        aSD();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ePh != null) {
                    a.this.ePh.toggle();
                }
            }
        });
    }

    public void aSD() {
        if (this.ePg != null) {
            aj.a(this.ePg, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.ePg;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.ePh != null) {
            this.ePh.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.ePh;
    }

    public void setText(String str) {
        if (this.ePg != null) {
            this.ePg.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.ePh != null) {
            this.ePh.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.ePh.getTag();
    }

    public void setChecked(boolean z) {
        this.ePh.setChecked(z);
    }
}
