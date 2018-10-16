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
    private TextView gPQ;
    private TbImageView gPR;
    private TextView gPS;
    private BdSwitchView gPT;
    private View gPU;
    private int gPV;
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
        this.gPQ = (TextView) findViewById(e.g.setting_text);
        this.gPR = (TbImageView) findViewById(e.g.setting_tip_image);
        this.gPS = (TextView) findViewById(e.g.setting_tip);
        this.gPT = (BdSwitchView) findViewById(e.g.setting_switch);
        l.a(context, this.gPT, 10, 10, 10, 10);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.gPU = findViewById(e.g.space_view);
        this.gPU.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.gPV = i;
        al.c(this.gPR, this.gPV);
        this.gPR.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gPR.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gPQ.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gPQ.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gPS.setVisibility(0);
        this.gPS.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gPS.setVisibility(0);
            this.gPS.setText(i);
        }
    }

    public void nV() {
        this.gPT.nV();
    }

    public void nU() {
        this.gPT.nU();
    }

    public void nT() {
        this.gPT.nT();
    }

    public void nS() {
        this.gPT.nS();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gPT.nS();
        } else {
            this.gPT.nT();
        }
    }

    public boolean jL() {
        return this.gPT.jL();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gPT;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gPT.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gPT.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        al.j(this, e.d.cp_bg_line_d);
        if (this.gPV != 0) {
            al.c(this.gPR, this.gPV);
        }
    }

    public void setSpaceView(int i) {
        if (this.gPU != null) {
            this.gPU.setVisibility(i);
        }
    }
}
