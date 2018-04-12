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
    private TextView gjA;
    private TbImageView gjB;
    private TextView gjC;
    private BdSwitchView gjD;
    private int gjE;
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
        this.gjA = (TextView) findViewById(d.g.setting_text);
        this.gjB = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gjC = (TextView) findViewById(d.g.setting_tip);
        this.gjD = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gjD, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
    }

    public void setTipImageResource(int i) {
        this.gjE = i;
        ak.c(this.gjB, this.gjE);
        this.gjB.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gjB.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gjA.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gjA.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gjC.setVisibility(0);
        this.gjC.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gjC.setVisibility(0);
            this.gjC.setText(i);
        }
    }

    public void jP() {
        this.gjD.jP();
    }

    public void jO() {
        this.gjD.jO();
    }

    public void jN() {
        this.gjD.jN();
    }

    public void jM() {
        this.gjD.jM();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gjD.jM();
        } else {
            this.gjD.jN();
        }
    }

    public boolean fz() {
        return this.gjD.fz();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gjD;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gjD.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().u(this);
        this.gjD.setBackgroundRes(ak.cO(d.f.bg_switch_open), ak.cO(d.f.bg_switch_close), ak.cO(d.f.btn_handle));
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (this.gjE != 0) {
            ak.c(this.gjB, this.gjE);
        }
    }
}
