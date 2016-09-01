package com.baidu.tieba.pb.pb.main.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView euX;
    private RadioButton euY;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.euX = (TextView) findViewById(t.g.custom_check_radio_button_tv);
        this.euY = (RadioButton) findViewById(t.g.custom_check_radio_button_rb);
        aQd();
        setOnClickListener(new b(this));
    }

    public void aQd() {
        if (this.euX != null) {
            av.a(this.euX, "cp_link_tip_a");
        }
    }

    public TextView getTv() {
        return this.euX;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.euY != null) {
            this.euY.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public RadioButton getRb() {
        return this.euY;
    }

    public void setText(String str) {
        if (this.euX != null) {
            this.euX.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.euY != null) {
            this.euY.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.euY.getTag();
    }

    public void setChecked(boolean z) {
        this.euY.setChecked(z);
    }
}
