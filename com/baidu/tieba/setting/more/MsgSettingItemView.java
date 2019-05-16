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
    private TbImageView iMA;
    private TextView iMB;
    private BdSwitchView iMC;
    private View iMD;
    private int iME;
    private TextView iMz;
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
        this.iMz = (TextView) findViewById(R.id.setting_text);
        this.iMA = (TbImageView) findViewById(R.id.setting_tip_image);
        this.iMB = (TextView) findViewById(R.id.setting_tip);
        this.iMC = (BdSwitchView) findViewById(R.id.setting_switch);
        l.b(context, this.iMC, 10, 10, 10, 10);
        this.mBottomLine = findViewById(R.id.bottom_line_ll);
        this.iMD = findViewById(R.id.space_view);
        this.iMD.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iME = i;
        al.c(this.iMA, this.iME);
        this.iMA.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iMA.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iMz.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iMz.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iMB.setVisibility(0);
        this.iMB.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iMB.setVisibility(0);
            this.iMB.setText(i);
        }
    }

    public void mW() {
        this.iMC.mW();
    }

    public void mV() {
        this.iMC.mV();
    }

    public void mU() {
        this.iMC.mU();
    }

    public void mT() {
        this.iMC.mT();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iMC.mT();
        } else {
            this.iMC.mU();
        }
    }

    public boolean iE() {
        return this.iMC.iE();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.iMC;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iMC.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iMC.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        al.l(this, R.color.cp_bg_line_d);
        if (this.iME != 0) {
            al.c(this.iMA, this.iME);
        }
    }

    public void setSpaceView(int i) {
        if (this.iMD != null) {
            this.iMD.setVisibility(i);
        }
    }
}
