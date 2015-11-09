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
    private View Mo;
    private TextView cPX;
    private TextView cPY;
    private BdSwitchView cPZ;

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
        this.cPX = (TextView) findViewById(i.f.setting_text);
        this.cPY = (TextView) findViewById(i.f.setting_tip);
        this.cPZ = (BdSwitchView) findViewById(i.f.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.cPZ, 10, 10, 10, 10);
        this.Mo = findViewById(i.f.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cPX.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cPX.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cPY.setVisibility(0);
        this.cPY.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.cPY.setVisibility(0);
            this.cPY.setText(i);
        }
    }

    public void mD() {
        this.cPZ.mD();
    }

    public void mC() {
        this.cPZ.mC();
    }

    public void mB() {
        this.cPZ.mB();
    }

    public void mA() {
        this.cPZ.mA();
    }

    public boolean hy() {
        return this.cPZ.hy();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mo.setVisibility(0);
        } else {
            this.Mo.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cPZ;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cPZ.setOnSwitchStateChangeListener(aVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
        this.cPZ.a(com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.an.cw(i.e.btn_handle));
        com.baidu.tbadk.core.util.an.j(this, i.c.cp_bg_line_d);
    }
}
