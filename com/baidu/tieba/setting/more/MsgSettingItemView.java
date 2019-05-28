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
    private TextView iMB;
    private TbImageView iMC;
    private TextView iMD;
    private BdSwitchView iME;
    private View iMF;
    private int iMG;
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
        this.iMB = (TextView) findViewById(R.id.setting_text);
        this.iMC = (TbImageView) findViewById(R.id.setting_tip_image);
        this.iMD = (TextView) findViewById(R.id.setting_tip);
        this.iME = (BdSwitchView) findViewById(R.id.setting_switch);
        l.b(context, this.iME, 10, 10, 10, 10);
        this.mBottomLine = findViewById(R.id.bottom_line_ll);
        this.iMF = findViewById(R.id.space_view);
        this.iMF.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iMG = i;
        al.c(this.iMC, this.iMG);
        this.iMC.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iMC.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iMB.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iMB.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iMD.setVisibility(0);
        this.iMD.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iMD.setVisibility(0);
            this.iMD.setText(i);
        }
    }

    public void mW() {
        this.iME.mW();
    }

    public void mV() {
        this.iME.mV();
    }

    public void mU() {
        this.iME.mU();
    }

    public void mT() {
        this.iME.mT();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iME.mT();
        } else {
            this.iME.mU();
        }
    }

    public boolean iE() {
        return this.iME.iE();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.iME;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iME.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iME.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        al.l(this, R.color.cp_bg_line_d);
        if (this.iMG != 0) {
            al.c(this.iMC, this.iMG);
        }
    }

    public void setSpaceView(int i) {
        if (this.iMF != null) {
            this.iMF.setVisibility(i);
        }
    }
}
