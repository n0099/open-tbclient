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
    private TextView eYt;
    private RadioButton eYu;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eYt = (TextView) findViewById(d.g.custom_check_radio_button_tv);
        this.eYu = (RadioButton) findViewById(d.g.custom_check_radio_button_rb);
        aVZ();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eYu != null) {
                    a.this.eYu.toggle();
                }
            }
        });
    }

    public void aVZ() {
        if (this.eYt != null) {
            aj.a(this.eYt, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eYu != null) {
            this.eYu.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.eYt != null) {
            this.eYt.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eYu != null) {
            this.eYu.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eYu.getTag();
    }

    public void setChecked(boolean z) {
        this.eYu.setChecked(z);
    }
}
