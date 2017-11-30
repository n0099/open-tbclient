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
    private TextView ffi;
    private RadioButton ffj;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.ffi = (TextView) findViewById(d.g.custom_check_radio_button_tv);
        this.ffj = (RadioButton) findViewById(d.g.custom_check_radio_button_rb);
        aWY();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ffj != null) {
                    a.this.ffj.toggle();
                }
            }
        });
    }

    public void aWY() {
        if (this.ffi != null) {
            aj.a(this.ffi, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.ffj != null) {
            this.ffj.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.ffi != null) {
            this.ffi.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.ffj != null) {
            this.ffj.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.ffj.getTag();
    }

    public void setChecked(boolean z) {
        this.ffj.setChecked(z);
    }
}
