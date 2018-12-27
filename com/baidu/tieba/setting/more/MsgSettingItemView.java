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
    private TextView hbk;
    private TbImageView hbl;
    private TextView hbm;
    private BdSwitchView hbn;
    private View hbo;
    private int hbp;
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
        this.hbk = (TextView) findViewById(e.g.setting_text);
        this.hbl = (TbImageView) findViewById(e.g.setting_tip_image);
        this.hbm = (TextView) findViewById(e.g.setting_tip);
        this.hbn = (BdSwitchView) findViewById(e.g.setting_switch);
        l.b(context, this.hbn, 10, 10, 10, 10);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.hbo = findViewById(e.g.space_view);
        this.hbo.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.hbp = i;
        al.c(this.hbl, this.hbp);
        this.hbl.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.hbl.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.hbk.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.hbk.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.hbm.setVisibility(0);
        this.hbm.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.hbm.setVisibility(0);
            this.hbm.setText(i);
        }
    }

    public void nS() {
        this.hbn.nS();
    }

    public void nR() {
        this.hbn.nR();
    }

    public void nQ() {
        this.hbn.nQ();
    }

    public void nP() {
        this.hbn.nP();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.hbn.nP();
        } else {
            this.hbn.nQ();
        }
    }

    public boolean jJ() {
        return this.hbn.jJ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.hbn;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.hbn.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.hbn.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.j(this, e.d.cp_bg_line_d);
        if (this.hbp != 0) {
            al.c(this.hbl, this.hbp);
        }
    }

    public void setSpaceView(int i) {
        if (this.hbo != null) {
            this.hbo.setVisibility(i);
        }
    }
}
