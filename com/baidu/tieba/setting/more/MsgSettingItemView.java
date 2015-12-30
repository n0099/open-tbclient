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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MsgSettingItemView extends LinearLayout {
    private View MV;
    private TextView dvG;
    private TextView dvH;
    private BdSwitchView dvI;

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
        LayoutInflater.from(context).inflate(n.h.msg_setting_item_view, (ViewGroup) this, true);
        this.dvG = (TextView) findViewById(n.g.setting_text);
        this.dvH = (TextView) findViewById(n.g.setting_tip);
        this.dvI = (BdSwitchView) findViewById(n.g.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.dvI, 10, 10, 10, 10);
        this.MV = findViewById(n.g.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.dvG.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.dvG.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.dvH.setVisibility(0);
        this.dvH.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.dvH.setVisibility(0);
            this.dvH.setText(i);
        }
    }

    public void mf() {
        this.dvI.mf();
    }

    public void me() {
        this.dvI.me();
    }

    public void md() {
        this.dvI.md();
    }

    public void mc() {
        this.dvI.mc();
    }

    public boolean hA() {
        return this.dvI.hA();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.MV.setVisibility(0);
        } else {
            this.MV.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.dvI;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dvI.setOnSwitchStateChangeListener(aVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ac(i == 1);
        tbPageContext.getLayoutMode().k(this);
        this.dvI.a(com.baidu.tbadk.core.util.as.cx(n.f.bg_switch_open), com.baidu.tbadk.core.util.as.cx(n.f.bg_switch_close), com.baidu.tbadk.core.util.as.cx(n.f.btn_handle));
        com.baidu.tbadk.core.util.as.j(this, n.d.cp_bg_line_d);
    }
}
