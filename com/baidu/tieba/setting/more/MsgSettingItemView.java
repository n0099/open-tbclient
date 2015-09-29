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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class MsgSettingItemView extends LinearLayout {
    private View Mm;
    private TextView cOc;
    private TextView cOd;
    private BdSwitchView cOe;

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
        LayoutInflater.from(context).inflate(i.g.msg_setting_item_view, (ViewGroup) this, true);
        this.cOc = (TextView) findViewById(i.f.setting_text);
        this.cOd = (TextView) findViewById(i.f.setting_tip);
        this.cOe = (BdSwitchView) findViewById(i.f.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.cOe, 10, 10, 10, 10);
        this.Mm = findViewById(i.f.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cOc.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cOc.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cOd.setVisibility(0);
        this.cOd.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.cOd.setVisibility(0);
            this.cOd.setText(i);
        }
    }

    public void mC() {
        this.cOe.mC();
    }

    public void mB() {
        this.cOe.mB();
    }

    public void mA() {
        this.cOe.mA();
    }

    public void mz() {
        this.cOe.mz();
    }

    public boolean hx() {
        return this.cOe.hx();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mm.setVisibility(0);
        } else {
            this.Mm.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cOe;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cOe.setOnSwitchStateChangeListener(aVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
        this.cOe.a(com.baidu.tbadk.core.util.am.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.am.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.am.cw(i.e.btn_handle));
        com.baidu.tbadk.core.util.am.j(this, i.c.cp_bg_line_d);
    }
}
