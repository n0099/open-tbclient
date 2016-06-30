package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView dWn;
    private RadioButton dWo;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(u.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.dWn = (TextView) findViewById(u.g.custom_check_radio_button_tv);
        this.dWo = (RadioButton) findViewById(u.g.custom_check_radio_button_rb);
        aIb();
        setOnClickListener(new b(this));
    }

    public void aIb() {
        if (this.dWn != null) {
            av.a(this.dWn, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.dWn;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.dWo != null) {
            this.dWo.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.dWo;
    }

    public void setText(String str) {
        if (this.dWn != null) {
            this.dWn.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.dWo != null) {
            this.dWo.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.dWo.getTag();
    }

    public void setChecked(boolean z) {
        this.dWo.setChecked(z);
    }
}
