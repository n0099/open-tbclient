package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView dnA;
    private RadioButton dnB;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.dnA = (TextView) findViewById(t.g.custom_check_radio_button_tv);
        this.dnB = (RadioButton) findViewById(t.g.custom_check_radio_button_rb);
        azt();
        setOnClickListener(new b(this));
    }

    public void azt() {
        if (this.dnA != null) {
            at.a(this.dnA, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.dnA;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.dnB != null) {
            this.dnB.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.dnB;
    }

    public void setText(String str) {
        if (this.dnA != null) {
            this.dnA.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.dnB != null) {
            this.dnB.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.dnB.getTag();
    }

    public void setChecked(boolean z) {
        this.dnB.setChecked(z);
    }
}
