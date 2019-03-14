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
    private TextView iua;
    private TbImageView iub;
    private TextView iuc;
    private BdSwitchView iud;
    private View iue;
    private int iuf;
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
        this.iua = (TextView) findViewById(d.g.setting_text);
        this.iub = (TbImageView) findViewById(d.g.setting_tip_image);
        this.iuc = (TextView) findViewById(d.g.setting_tip);
        this.iud = (BdSwitchView) findViewById(d.g.setting_switch);
        l.b(context, this.iud, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.iue = findViewById(d.g.space_view);
        this.iue.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iuf = i;
        al.c(this.iub, this.iuf);
        this.iub.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iub.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iua.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iua.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iuc.setVisibility(0);
        this.iuc.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iuc.setVisibility(0);
            this.iuc.setText(i);
        }
    }

    public void ob() {
        this.iud.ob();
    }

    public void oa() {
        this.iud.oa();
    }

    public void nZ() {
        this.iud.nZ();
    }

    public void nY() {
        this.iud.nY();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iud.nY();
        } else {
            this.iud.nZ();
        }
    }

    public boolean jK() {
        return this.iud.jK();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.iud;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iud.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iud.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        al.l(this, d.C0277d.cp_bg_line_d);
        if (this.iuf != 0) {
            al.c(this.iub, this.iuf);
        }
    }

    public void setSpaceView(int i) {
        if (this.iue != null) {
            this.iue.setVisibility(i);
        }
    }
}
