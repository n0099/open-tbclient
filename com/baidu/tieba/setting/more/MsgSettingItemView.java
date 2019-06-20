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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView iMF;
    private TbImageView iMG;
    private TextView iMH;
    private BdSwitchView iMI;
    private View iMJ;
    private int iMK;
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
        LayoutInflater.from(context).inflate(R.layout.msg_setting_item_view, (ViewGroup) this, true);
        this.iMF = (TextView) findViewById(R.id.setting_text);
        this.iMG = (TbImageView) findViewById(R.id.setting_tip_image);
        this.iMH = (TextView) findViewById(R.id.setting_tip);
        this.iMI = (BdSwitchView) findViewById(R.id.setting_switch);
        l.b(context, this.iMI, 10, 10, 10, 10);
        this.mBottomLine = findViewById(R.id.bottom_line_ll);
        this.iMJ = findViewById(R.id.space_view);
        this.iMJ.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iMK = i;
        al.c(this.iMG, this.iMK);
        this.iMG.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iMG.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iMF.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iMF.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iMH.setVisibility(0);
        this.iMH.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iMH.setVisibility(0);
            this.iMH.setText(i);
        }
    }

    public void mW() {
        this.iMI.mW();
    }

    public void mV() {
        this.iMI.mV();
    }

    public void mU() {
        this.iMI.mU();
    }

    public void mT() {
        this.iMI.mT();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iMI.mT();
        } else {
            this.iMI.mU();
        }
    }

    public boolean iE() {
        return this.iMI.iE();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.iMI;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iMI.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iMI.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        al.l(this, R.color.cp_bg_line_d);
        if (this.iMK != 0) {
            al.c(this.iMG, this.iMK);
        }
    }

    public void setSpaceView(int i) {
        if (this.iMJ != null) {
            this.iMJ.setVisibility(i);
        }
    }
}
