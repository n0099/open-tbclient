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
    private TextView eVO;
    private RadioButton eVP;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eVO = (TextView) findViewById(d.h.custom_check_radio_button_tv);
        this.eVP = (RadioButton) findViewById(d.h.custom_check_radio_button_rb);
        aVh();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eVP != null) {
                    a.this.eVP.toggle();
                }
            }
        });
    }

    public void aVh() {
        if (this.eVO != null) {
            ai.a(this.eVO, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.eVO;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eVP != null) {
            this.eVP.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.eVP;
    }

    public void setText(String str) {
        if (this.eVO != null) {
            this.eVO.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eVP != null) {
            this.eVP.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eVP.getTag();
    }

    public void setChecked(boolean z) {
        this.eVP.setChecked(z);
    }
}
