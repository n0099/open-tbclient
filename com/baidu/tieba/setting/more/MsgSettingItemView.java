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
    private View Mn;
    private TextView cOB;
    private TextView cOC;
    private BdSwitchView cOD;

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
        this.cOB = (TextView) findViewById(i.f.setting_text);
        this.cOC = (TextView) findViewById(i.f.setting_tip);
        this.cOD = (BdSwitchView) findViewById(i.f.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.cOD, 10, 10, 10, 10);
        this.Mn = findViewById(i.f.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cOB.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cOB.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cOC.setVisibility(0);
        this.cOC.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.cOC.setVisibility(0);
            this.cOC.setText(i);
        }
    }

    public void mC() {
        this.cOD.mC();
    }

    public void mB() {
        this.cOD.mB();
    }

    public void mA() {
        this.cOD.mA();
    }

    public void mz() {
        this.cOD.mz();
    }

    public boolean hx() {
        return this.cOD.hx();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mn.setVisibility(0);
        } else {
            this.Mn.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cOD;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cOD.setOnSwitchStateChangeListener(aVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
        this.cOD.a(com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.an.cw(i.e.btn_handle));
        com.baidu.tbadk.core.util.an.j(this, i.c.cp_bg_line_d);
    }
}
