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
    private TextView gOu;
    private TbImageView gOv;
    private TextView gOw;
    private BdSwitchView gOx;
    private int gOy;
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
        this.gOu = (TextView) findViewById(d.g.setting_text);
        this.gOv = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gOw = (TextView) findViewById(d.g.setting_tip);
        this.gOx = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gOx, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
    }

    public void setTipImageResource(int i) {
        this.gOy = i;
        aj.c(this.gOv, this.gOy);
        this.gOv.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gOv.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gOu.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gOu.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gOw.setVisibility(0);
        this.gOw.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gOw.setVisibility(0);
            this.gOw.setText(i);
        }
    }

    public void rK() {
        this.gOx.rK();
    }

    public void rJ() {
        this.gOx.rJ();
    }

    public void rI() {
        this.gOx.rI();
    }

    public void rH() {
        this.gOx.rH();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gOx.rH();
        } else {
            this.gOx.rI();
        }
    }

    public boolean nv() {
        return this.gOx.nv();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gOx;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gOx.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().aQ(i == 1);
        tbPageContext.getLayoutMode().aM(this);
        this.gOx.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.t(this, d.C0140d.cp_bg_line_d);
        if (this.gOy != 0) {
            aj.c(this.gOv, this.gOy);
        }
    }
}
