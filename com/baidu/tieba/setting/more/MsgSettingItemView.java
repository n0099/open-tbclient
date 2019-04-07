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
    private TextView itK;
    private TbImageView itL;
    private TextView itM;
    private BdSwitchView itN;
    private View itO;
    private int itP;
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
        this.itK = (TextView) findViewById(d.g.setting_text);
        this.itL = (TbImageView) findViewById(d.g.setting_tip_image);
        this.itM = (TextView) findViewById(d.g.setting_tip);
        this.itN = (BdSwitchView) findViewById(d.g.setting_switch);
        l.b(context, this.itN, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.itO = findViewById(d.g.space_view);
        this.itO.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.itP = i;
        al.c(this.itL, this.itP);
        this.itL.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.itL.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.itK.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.itK.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.itM.setVisibility(0);
        this.itM.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.itM.setVisibility(0);
            this.itM.setText(i);
        }
    }

    public void ob() {
        this.itN.ob();
    }

    public void oa() {
        this.itN.oa();
    }

    public void nZ() {
        this.itN.nZ();
    }

    public void nY() {
        this.itN.nY();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.itN.nY();
        } else {
            this.itN.nZ();
        }
    }

    public boolean jK() {
        return this.itN.jK();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.itN;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.itN.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.itN.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        al.l(this, d.C0277d.cp_bg_line_d);
        if (this.itP != 0) {
            al.c(this.itL, this.itP);
        }
    }

    public void setSpaceView(int i) {
        if (this.itO != null) {
            this.itO.setVisibility(i);
        }
    }
}
