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
    private TextView itL;
    private TbImageView itM;
    private TextView itN;
    private BdSwitchView itO;
    private View itP;
    private int itQ;
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
        this.itL = (TextView) findViewById(d.g.setting_text);
        this.itM = (TbImageView) findViewById(d.g.setting_tip_image);
        this.itN = (TextView) findViewById(d.g.setting_tip);
        this.itO = (BdSwitchView) findViewById(d.g.setting_switch);
        l.b(context, this.itO, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.itP = findViewById(d.g.space_view);
        this.itP.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.itQ = i;
        al.c(this.itM, this.itQ);
        this.itM.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.itM.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.itL.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.itL.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.itN.setVisibility(0);
        this.itN.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.itN.setVisibility(0);
            this.itN.setText(i);
        }
    }

    public void ob() {
        this.itO.ob();
    }

    public void oa() {
        this.itO.oa();
    }

    public void nZ() {
        this.itO.nZ();
    }

    public void nY() {
        this.itO.nY();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.itO.nY();
        } else {
            this.itO.nZ();
        }
    }

    public boolean jK() {
        return this.itO.jK();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.itO;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.itO.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.itO.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        al.l(this, d.C0277d.cp_bg_line_d);
        if (this.itQ != 0) {
            al.c(this.itM, this.itQ);
        }
    }

    public void setSpaceView(int i) {
        if (this.itP != null) {
            this.itP.setVisibility(i);
        }
    }
}
