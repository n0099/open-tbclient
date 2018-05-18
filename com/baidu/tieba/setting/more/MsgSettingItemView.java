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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView gkD;
    private TbImageView gkE;
    private TextView gkF;
    private BdSwitchView gkG;
    private int gkH;
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
        this.gkD = (TextView) findViewById(d.g.setting_text);
        this.gkE = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gkF = (TextView) findViewById(d.g.setting_tip);
        this.gkG = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gkG, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
    }

    public void setTipImageResource(int i) {
        this.gkH = i;
        ak.c(this.gkE, this.gkH);
        this.gkE.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gkE.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gkD.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gkD.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gkF.setVisibility(0);
        this.gkF.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gkF.setVisibility(0);
            this.gkF.setText(i);
        }
    }

    public void jP() {
        this.gkG.jP();
    }

    public void jO() {
        this.gkG.jO();
    }

    public void jN() {
        this.gkG.jN();
    }

    public void jM() {
        this.gkG.jM();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gkG.jM();
        } else {
            this.gkG.jN();
        }
    }

    public boolean fz() {
        return this.gkG.fz();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gkG;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gkG.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().u(this);
        this.gkG.setBackgroundRes(ak.cO(d.f.bg_switch_open), ak.cO(d.f.bg_switch_close), ak.cO(d.f.btn_handle));
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (this.gkH != 0) {
            ak.c(this.gkE, this.gkH);
        }
    }
}
