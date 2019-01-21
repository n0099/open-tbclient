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
    private TextView hcq;
    private TbImageView hcr;
    private TextView hcs;
    private BdSwitchView hct;
    private View hcu;
    private int hcv;
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
        this.hcq = (TextView) findViewById(e.g.setting_text);
        this.hcr = (TbImageView) findViewById(e.g.setting_tip_image);
        this.hcs = (TextView) findViewById(e.g.setting_tip);
        this.hct = (BdSwitchView) findViewById(e.g.setting_switch);
        l.b(context, this.hct, 10, 10, 10, 10);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.hcu = findViewById(e.g.space_view);
        this.hcu.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.hcv = i;
        al.c(this.hcr, this.hcv);
        this.hcr.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.hcr.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.hcq.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.hcq.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.hcs.setVisibility(0);
        this.hcs.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.hcs.setVisibility(0);
            this.hcs.setText(i);
        }
    }

    public void nW() {
        this.hct.nW();
    }

    public void nV() {
        this.hct.nV();
    }

    public void nU() {
        this.hct.nU();
    }

    public void nT() {
        this.hct.nT();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.hct.nT();
        } else {
            this.hct.nU();
        }
    }

    public boolean jJ() {
        return this.hct.jJ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.hct;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.hct.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.hct.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.j(this, e.d.cp_bg_line_d);
        if (this.hcv != 0) {
            al.c(this.hcr, this.hcv);
        }
    }

    public void setSpaceView(int i) {
        if (this.hcu != null) {
            this.hcu.setVisibility(i);
        }
    }
}
