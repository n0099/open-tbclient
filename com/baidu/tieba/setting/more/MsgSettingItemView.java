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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MsgSettingItemView extends LinearLayout {
    private View Nn;
    private TextView dLK;
    private TextView dLL;
    private BdSwitchView dLM;

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
        this.dLK = (TextView) findViewById(t.g.setting_text);
        this.dLL = (TextView) findViewById(t.g.setting_tip);
        this.dLM = (BdSwitchView) findViewById(t.g.setting_switch);
        com.baidu.adp.lib.util.k.a(context, this.dLM, 10, 10, 10, 10);
        this.Nn = findViewById(t.g.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.dLK.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.dLK.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.dLL.setVisibility(0);
        this.dLL.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.dLL.setVisibility(0);
            this.dLL.setText(i);
        }
    }

    public void mt() {
        this.dLM.mt();
    }

    public void ms() {
        this.dLM.ms();
    }

    public void mr() {
        this.dLM.mr();
    }

    public void mq() {
        this.dLM.mq();
    }

    public boolean hI() {
        return this.dLM.hI();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Nn.setVisibility(0);
        } else {
            this.Nn.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.dLM;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dLM.setOnSwitchStateChangeListener(aVar);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ac(i == 1);
        tbPageContext.getLayoutMode().x(this);
        this.dLM.a(com.baidu.tbadk.core.util.ar.cO(t.f.bg_switch_open), com.baidu.tbadk.core.util.ar.cO(t.f.bg_switch_close), com.baidu.tbadk.core.util.ar.cO(t.f.btn_handle));
        com.baidu.tbadk.core.util.ar.l(this, t.d.cp_bg_line_d);
    }
}
