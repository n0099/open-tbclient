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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView gPR;
    private TbImageView gPS;
    private TextView gPT;
    private BdSwitchView gPU;
    private View gPV;
    private int gPW;
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
        LayoutInflater.from(context).inflate(e.h.msg_setting_item_view, (ViewGroup) this, true);
        this.gPR = (TextView) findViewById(e.g.setting_text);
        this.gPS = (TbImageView) findViewById(e.g.setting_tip_image);
        this.gPT = (TextView) findViewById(e.g.setting_tip);
        this.gPU = (BdSwitchView) findViewById(e.g.setting_switch);
        l.a(context, this.gPU, 10, 10, 10, 10);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.gPV = findViewById(e.g.space_view);
        this.gPV.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.gPW = i;
        al.c(this.gPS, this.gPW);
        this.gPS.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gPS.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gPR.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gPR.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gPT.setVisibility(0);
        this.gPT.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gPT.setVisibility(0);
            this.gPT.setText(i);
        }
    }

    public void nV() {
        this.gPU.nV();
    }

    public void nU() {
        this.gPU.nU();
    }

    public void nT() {
        this.gPU.nT();
    }

    public void nS() {
        this.gPU.nS();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gPU.nS();
        } else {
            this.gPU.nT();
        }
    }

    public boolean jL() {
        return this.gPU.jL();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gPU;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gPU.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gPU.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        al.j(this, e.d.cp_bg_line_d);
        if (this.gPW != 0) {
            al.c(this.gPS, this.gPW);
        }
    }

    public void setSpaceView(int i) {
        if (this.gPV != null) {
            this.gPV.setVisibility(i);
        }
    }
}
