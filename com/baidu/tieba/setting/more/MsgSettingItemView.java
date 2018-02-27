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
    private TextView gOf;
    private TbImageView gOg;
    private TextView gOh;
    private BdSwitchView gOi;
    private int gOj;
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
        this.gOf = (TextView) findViewById(d.g.setting_text);
        this.gOg = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gOh = (TextView) findViewById(d.g.setting_tip);
        this.gOi = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gOi, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
    }

    public void setTipImageResource(int i) {
        this.gOj = i;
        aj.c(this.gOg, this.gOj);
        this.gOg.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gOg.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gOf.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gOf.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gOh.setVisibility(0);
        this.gOh.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gOh.setVisibility(0);
            this.gOh.setText(i);
        }
    }

    public void rK() {
        this.gOi.rK();
    }

    public void rJ() {
        this.gOi.rJ();
    }

    public void rI() {
        this.gOi.rI();
    }

    public void rH() {
        this.gOi.rH();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gOi.rH();
        } else {
            this.gOi.rI();
        }
    }

    public boolean nv() {
        return this.gOi.nv();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gOi;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gOi.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().aQ(i == 1);
        tbPageContext.getLayoutMode().aM(this);
        this.gOi.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.t(this, d.C0141d.cp_bg_line_d);
        if (this.gOj != 0) {
            aj.c(this.gOg, this.gOj);
        }
    }
}
