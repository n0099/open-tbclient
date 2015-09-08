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
    private TextView cHb;
    private TextView cHc;
    private BdSwitchView cHd;

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
        this.cHb = (TextView) findViewById(i.f.setting_text);
        this.cHc = (TextView) findViewById(i.f.setting_tip);
        this.cHd = (BdSwitchView) findViewById(i.f.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.cHd, 10, 10, 10, 10);
        this.Mm = findViewById(i.f.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cHb.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cHb.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cHc.setVisibility(0);
        this.cHc.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.cHc.setVisibility(0);
            this.cHc.setText(i);
        }
    }

    public void mB() {
        this.cHd.mB();
    }

    public void mA() {
        this.cHd.mA();
    }

    public void mz() {
        this.cHd.mz();
    }

    public void my() {
        this.cHd.my();
    }

    public boolean hw() {
        return this.cHd.hw();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mm.setVisibility(0);
        } else {
            this.Mm.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cHd;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cHd.setOnSwitchStateChangeListener(aVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
        this.cHd.a(com.baidu.tbadk.core.util.al.cu(i.e.bg_switch_open), com.baidu.tbadk.core.util.al.cu(i.e.bg_switch_close), com.baidu.tbadk.core.util.al.cu(i.e.btn_handle));
        com.baidu.tbadk.core.util.al.i(this, i.c.cp_bg_line_d);
    }
}
