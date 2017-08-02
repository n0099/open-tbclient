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
    private TextView eSI;
    private RadioButton eSJ;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eSI = (TextView) findViewById(d.h.custom_check_radio_button_tv);
        this.eSJ = (RadioButton) findViewById(d.h.custom_check_radio_button_rb);
        aUp();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eSJ != null) {
                    a.this.eSJ.toggle();
                }
            }
        });
    }

    public void aUp() {
        if (this.eSI != null) {
            ai.a(this.eSI, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eSI;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eSJ != null) {
            this.eSJ.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eSJ;
    }

    public void setText(String str) {
        if (this.eSI != null) {
            this.eSI.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eSJ != null) {
            this.eSJ.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eSJ.getTag();
    }

    public void setChecked(boolean z) {
        this.eSJ.setChecked(z);
    }
}
