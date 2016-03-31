package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MsgSettingItemView extends LinearLayout {
    private View Nu;
    private TextView eei;
    private TbImageView eej;
    private TextView eek;
    private BdSwitchView eel;
    private int eem;

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
        LayoutInflater.from(context).inflate(t.h.msg_setting_item_view, (ViewGroup) this, true);
        this.eei = (TextView) findViewById(t.g.setting_text);
        this.eej = (TbImageView) findViewById(t.g.setting_tip_image);
        this.eek = (TextView) findViewById(t.g.setting_tip);
        this.eel = (BdSwitchView) findViewById(t.g.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.eel, 10, 10, 10, 10);
        this.Nu = findViewById(t.g.bottom_line_ll);
    }

    public void setTipImageResource(int i) {
        this.eem = i;
        com.baidu.tbadk.core.util.at.c(this.eej, this.eem);
        this.eej.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.eej.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.eei.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.eei.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.eek.setVisibility(0);
        this.eek.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.eek.setVisibility(0);
            this.eek.setText(i);
        }
    }

    public void ml() {
        this.eel.ml();
    }

    public void mk() {
        this.eel.mk();
    }

    public void mj() {
        this.eel.mj();
    }

    public void mi() {
        this.eel.mi();
    }

    public boolean hO() {
        return this.eel.hO();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Nu.setVisibility(0);
        } else {
            this.Nu.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.eel;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.eel.setOnSwitchStateChangeListener(aVar);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().x(this);
        this.eel.a(com.baidu.tbadk.core.util.at.cR(t.f.bg_switch_open), com.baidu.tbadk.core.util.at.cR(t.f.bg_switch_close), com.baidu.tbadk.core.util.at.cR(t.f.btn_handle));
        com.baidu.tbadk.core.util.at.l(this, t.d.cp_bg_line_d);
        if (this.eem != 0) {
            com.baidu.tbadk.core.util.at.c(this.eej, this.eem);
        }
    }
}
