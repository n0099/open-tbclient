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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView gwb;
    private TbImageView gwc;
    private TextView gwd;
    private BdSwitchView gwe;
    private int gwf;
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
        LayoutInflater.from(context).inflate(d.i.msg_setting_item_view, (ViewGroup) this, true);
        this.gwb = (TextView) findViewById(d.g.setting_text);
        this.gwc = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gwd = (TextView) findViewById(d.g.setting_tip);
        this.gwe = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gwe, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
    }

    public void setTipImageResource(int i) {
        this.gwf = i;
        al.c(this.gwc, this.gwf);
        this.gwc.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gwc.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gwb.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gwb.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gwd.setVisibility(0);
        this.gwd.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gwd.setVisibility(0);
            this.gwd.setText(i);
        }
    }

    public void mD() {
        this.gwe.mD();
    }

    public void mC() {
        this.gwe.mC();
    }

    public void mB() {
        this.gwe.mB();
    }

    public void mA() {
        this.gwe.mA();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gwe.mA();
        } else {
            this.gwe.mB();
        }
    }

    public boolean ip() {
        return this.gwe.ip();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gwe;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gwe.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gwe.setBackgroundRes(al.cQ(d.f.bg_switch_open), al.cQ(d.f.bg_switch_close), al.cQ(d.f.btn_handle));
        al.j(this, d.C0141d.cp_bg_line_d);
        if (this.gwf != 0) {
            al.c(this.gwc, this.gwf);
        }
    }
}
