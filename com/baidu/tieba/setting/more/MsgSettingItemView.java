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
    private TextView gYg;
    private TbImageView gYh;
    private TextView gYi;
    private BdSwitchView gYj;
    private View gYk;
    private int gYl;
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
        this.gYg = (TextView) findViewById(e.g.setting_text);
        this.gYh = (TbImageView) findViewById(e.g.setting_tip_image);
        this.gYi = (TextView) findViewById(e.g.setting_tip);
        this.gYj = (BdSwitchView) findViewById(e.g.setting_switch);
        l.b(context, this.gYj, 10, 10, 10, 10);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.gYk = findViewById(e.g.space_view);
        this.gYk.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.gYl = i;
        al.c(this.gYh, this.gYl);
        this.gYh.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gYh.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gYg.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gYg.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gYi.setVisibility(0);
        this.gYi.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gYi.setVisibility(0);
            this.gYi.setText(i);
        }
    }

    public void nS() {
        this.gYj.nS();
    }

    public void nR() {
        this.gYj.nR();
    }

    public void nQ() {
        this.gYj.nQ();
    }

    public void nP() {
        this.gYj.nP();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gYj.nP();
        } else {
            this.gYj.nQ();
        }
    }

    public boolean jJ() {
        return this.gYj.jJ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gYj;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gYj.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gYj.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.j(this, e.d.cp_bg_line_d);
        if (this.gYl != 0) {
            al.c(this.gYh, this.gYl);
        }
    }

    public void setSpaceView(int i) {
        if (this.gYk != null) {
            this.gYk.setVisibility(i);
        }
    }
}
