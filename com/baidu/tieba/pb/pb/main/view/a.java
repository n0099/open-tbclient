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
    private TextView eXY;
    private RadioButton eXZ;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.eXY = (TextView) findViewById(d.g.custom_check_radio_button_tv);
        this.eXZ = (RadioButton) findViewById(d.g.custom_check_radio_button_rb);
        aVR();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eXZ != null) {
                    a.this.eXZ.toggle();
                }
            }
        });
    }

    public void aVR() {
        if (this.eXY != null) {
            aj.a(this.eXY, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eXZ != null) {
            this.eXZ.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.eXY != null) {
            this.eXY.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eXZ != null) {
            this.eXZ.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eXZ.getTag();
    }

    public void setChecked(boolean z) {
        this.eXZ.setChecked(z);
    }
}
