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
    private TextView iug;
    private TbImageView iuh;
    private TextView iui;
    private BdSwitchView iuj;
    private View iuk;
    private int iul;
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
        LayoutInflater.from(context).inflate(d.h.msg_setting_item_view, (ViewGroup) this, true);
        this.iug = (TextView) findViewById(d.g.setting_text);
        this.iuh = (TbImageView) findViewById(d.g.setting_tip_image);
        this.iui = (TextView) findViewById(d.g.setting_tip);
        this.iuj = (BdSwitchView) findViewById(d.g.setting_switch);
        l.b(context, this.iuj, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.iuk = findViewById(d.g.space_view);
        this.iuk.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iul = i;
        al.c(this.iuh, this.iul);
        this.iuh.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iuh.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iug.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iug.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iui.setVisibility(0);
        this.iui.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iui.setVisibility(0);
            this.iui.setText(i);
        }
    }

    public void ob() {
        this.iuj.ob();
    }

    public void oa() {
        this.iuj.oa();
    }

    public void nZ() {
        this.iuj.nZ();
    }

    public void nY() {
        this.iuj.nY();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iuj.nY();
        } else {
            this.iuj.nZ();
        }
    }

    public boolean jK() {
        return this.iuj.jK();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.iuj;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iuj.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iuj.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        al.l(this, d.C0236d.cp_bg_line_d);
        if (this.iul != 0) {
            al.c(this.iuh, this.iul);
        }
    }

    public void setSpaceView(int i) {
        if (this.iuk != null) {
            this.iuk.setVisibility(i);
        }
    }
}
