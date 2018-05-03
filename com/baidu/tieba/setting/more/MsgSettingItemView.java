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
    private BdSwitchView gjA;
    private int gjB;
    private TextView gjx;
    private TbImageView gjy;
    private TextView gjz;
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
        this.gjx = (TextView) findViewById(d.g.setting_text);
        this.gjy = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gjz = (TextView) findViewById(d.g.setting_tip);
        this.gjA = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gjA, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
    }

    public void setTipImageResource(int i) {
        this.gjB = i;
        ak.c(this.gjy, this.gjB);
        this.gjy.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gjy.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gjx.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gjx.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gjz.setVisibility(0);
        this.gjz.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gjz.setVisibility(0);
            this.gjz.setText(i);
        }
    }

    public void jP() {
        this.gjA.jP();
    }

    public void jO() {
        this.gjA.jO();
    }

    public void jN() {
        this.gjA.jN();
    }

    public void jM() {
        this.gjA.jM();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gjA.jM();
        } else {
            this.gjA.jN();
        }
    }

    public boolean fz() {
        return this.gjA.fz();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gjA;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gjA.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().u(this);
        this.gjA.setBackgroundRes(ak.cN(d.f.bg_switch_open), ak.cN(d.f.bg_switch_close), ak.cN(d.f.btn_handle));
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (this.gjB != 0) {
            ak.c(this.gjy, this.gjB);
        }
    }
}
