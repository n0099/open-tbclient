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
    private TextView cyD;
    private TextView cyE;
    private BdSwitchView cyF;

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
        this.cyD = (TextView) findViewById(i.f.setting_text);
        this.cyE = (TextView) findViewById(i.f.setting_tip);
        this.cyF = (BdSwitchView) findViewById(i.f.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.cyF, 10, 10, 10, 10);
        this.Mn = findViewById(i.f.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cyD.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cyD.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cyE.setVisibility(0);
        this.cyE.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.cyE.setVisibility(0);
            this.cyE.setText(i);
        }
    }

    public void mE() {
        this.cyF.mE();
    }

    public void mD() {
        this.cyF.mD();
    }

    public void mC() {
        this.cyF.mC();
    }

    public void mB() {
        this.cyF.mB();
    }

    public boolean hz() {
        return this.cyF.hz();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mn.setVisibility(0);
        } else {
            this.Mn.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cyF;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cyF.setOnSwitchStateChangeListener(aVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
        this.cyF.a(com.baidu.tbadk.core.util.al.cq(i.e.bg_switch_open), com.baidu.tbadk.core.util.al.cq(i.e.bg_switch_close), com.baidu.tbadk.core.util.al.cq(i.e.btn_handle));
        com.baidu.tbadk.core.util.al.j(this, i.c.cp_bg_line_d);
    }
}
