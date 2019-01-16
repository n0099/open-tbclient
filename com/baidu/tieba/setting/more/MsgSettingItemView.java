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
    private TextView hcp;
    private TbImageView hcq;
    private TextView hcr;
    private BdSwitchView hcs;
    private View hct;
    private int hcu;
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
        this.hcp = (TextView) findViewById(e.g.setting_text);
        this.hcq = (TbImageView) findViewById(e.g.setting_tip_image);
        this.hcr = (TextView) findViewById(e.g.setting_tip);
        this.hcs = (BdSwitchView) findViewById(e.g.setting_switch);
        l.b(context, this.hcs, 10, 10, 10, 10);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.hct = findViewById(e.g.space_view);
        this.hct.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.hcu = i;
        al.c(this.hcq, this.hcu);
        this.hcq.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.hcq.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.hcp.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.hcp.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.hcr.setVisibility(0);
        this.hcr.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.hcr.setVisibility(0);
            this.hcr.setText(i);
        }
    }

    public void nW() {
        this.hcs.nW();
    }

    public void nV() {
        this.hcs.nV();
    }

    public void nU() {
        this.hcs.nU();
    }

    public void nT() {
        this.hcs.nT();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.hcs.nT();
        } else {
            this.hcs.nU();
        }
    }

    public boolean jJ() {
        return this.hcs.jJ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.hcs;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.hcs.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.hcs.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.j(this, e.d.cp_bg_line_d);
        if (this.hcu != 0) {
            al.c(this.hcq, this.hcu);
        }
    }

    public void setSpaceView(int i) {
        if (this.hct != null) {
            this.hct.setVisibility(i);
        }
    }
}
