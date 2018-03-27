package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView gOv;
    private TbImageView gOw;
    private TextView gOx;
    private BdSwitchView gOy;
    private int gOz;
    private View mBottomLine;

    public MsgSettingItemView(Context context) {
        super(context);
        init(context);
    }

    public MsgSettingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.msg_setting_item_view, (ViewGroup) this, true);
        this.gOv = (TextView) findViewById(d.g.setting_text);
        this.gOw = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gOx = (TextView) findViewById(d.g.setting_tip);
        this.gOy = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gOy, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
    }

    public void setTipImageResource(int i) {
        this.gOz = i;
        aj.c(this.gOw, this.gOz);
        this.gOw.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gOw.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gOv.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gOv.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gOx.setVisibility(0);
        this.gOx.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gOx.setVisibility(0);
            this.gOx.setText(i);
        }
    }

    public void rK() {
        this.gOy.rK();
    }

    public void rJ() {
        this.gOy.rJ();
    }

    public void rI() {
        this.gOy.rI();
    }

    public void rH() {
        this.gOy.rH();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gOy.rH();
        } else {
            this.gOy.rI();
        }
    }

    public boolean nv() {
        return this.gOy.nv();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gOy;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gOy.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().aQ(i == 1);
        tbPageContext.getLayoutMode().aM(this);
        this.gOy.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.t(this, d.C0141d.cp_bg_line_d);
        if (this.gOz != 0) {
            aj.c(this.gOw, this.gOz);
        }
    }
}
