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
    private View MF;
    private TextView dot;
    private TextView dou;
    private BdSwitchView dov;

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
        LayoutInflater.from(context).inflate(n.g.msg_setting_item_view, (ViewGroup) this, true);
        this.dot = (TextView) findViewById(n.f.setting_text);
        this.dou = (TextView) findViewById(n.f.setting_tip);
        this.dov = (BdSwitchView) findViewById(n.f.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.dov, 10, 10, 10, 10);
        this.MF = findViewById(n.f.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.dot.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.dot.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.dou.setVisibility(0);
        this.dou.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.dou.setVisibility(0);
            this.dou.setText(i);
        }
    }

    public void mH() {
        this.dov.mH();
    }

    public void mG() {
        this.dov.mG();
    }

    public void mF() {
        this.dov.mF();
    }

    public void mE() {
        this.dov.mE();
    }

    public boolean hA() {
        return this.dov.hA();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.MF.setVisibility(0);
        } else {
            this.MF.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.dov;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dov.setOnSwitchStateChangeListener(aVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().af(i == 1);
        tbPageContext.getLayoutMode().k(this);
        this.dov.a(com.baidu.tbadk.core.util.as.cE(n.e.bg_switch_open), com.baidu.tbadk.core.util.as.cE(n.e.bg_switch_close), com.baidu.tbadk.core.util.as.cE(n.e.btn_handle));
        com.baidu.tbadk.core.util.as.j(this, n.c.cp_bg_line_d);
    }
}
