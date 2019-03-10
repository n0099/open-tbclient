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
    private TextView iuh;
    private TbImageView iui;
    private TextView iuj;
    private BdSwitchView iuk;
    private View iul;
    private int ium;
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
        this.iuh = (TextView) findViewById(d.g.setting_text);
        this.iui = (TbImageView) findViewById(d.g.setting_tip_image);
        this.iuj = (TextView) findViewById(d.g.setting_tip);
        this.iuk = (BdSwitchView) findViewById(d.g.setting_switch);
        l.b(context, this.iuk, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.iul = findViewById(d.g.space_view);
        this.iul.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.ium = i;
        al.c(this.iui, this.ium);
        this.iui.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iui.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iuh.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iuh.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iuj.setVisibility(0);
        this.iuj.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iuj.setVisibility(0);
            this.iuj.setText(i);
        }
    }

    public void ob() {
        this.iuk.ob();
    }

    public void oa() {
        this.iuk.oa();
    }

    public void nZ() {
        this.iuk.nZ();
    }

    public void nY() {
        this.iuk.nY();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iuk.nY();
        } else {
            this.iuk.nZ();
        }
    }

    public boolean jK() {
        return this.iuk.jK();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.iuk;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iuk.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iuk.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        al.l(this, d.C0236d.cp_bg_line_d);
        if (this.ium != 0) {
            al.c(this.iui, this.ium);
        }
    }

    public void setSpaceView(int i) {
        if (this.iul != null) {
            this.iul.setVisibility(i);
        }
    }
}
