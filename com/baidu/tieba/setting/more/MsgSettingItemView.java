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
    private TextView gRq;
    private TbImageView gRr;
    private TextView gRs;
    private BdSwitchView gRt;
    private View gRu;
    private int gRv;
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
        this.gRq = (TextView) findViewById(e.g.setting_text);
        this.gRr = (TbImageView) findViewById(e.g.setting_tip_image);
        this.gRs = (TextView) findViewById(e.g.setting_tip);
        this.gRt = (BdSwitchView) findViewById(e.g.setting_switch);
        l.b(context, this.gRt, 10, 10, 10, 10);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.gRu = findViewById(e.g.space_view);
        this.gRu.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.gRv = i;
        al.c(this.gRr, this.gRv);
        this.gRr.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gRr.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gRq.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gRq.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gRs.setVisibility(0);
        this.gRs.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gRs.setVisibility(0);
            this.gRs.setText(i);
        }
    }

    public void nT() {
        this.gRt.nT();
    }

    public void nS() {
        this.gRt.nS();
    }

    public void nR() {
        this.gRt.nR();
    }

    public void nQ() {
        this.gRt.nQ();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gRt.nQ();
        } else {
            this.gRt.nR();
        }
    }

    public boolean jJ() {
        return this.gRt.jJ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gRt;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gRt.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gRt.setBackgroundRes(al.dA(e.f.bg_switch_open), al.dA(e.f.bg_switch_close), al.dA(e.f.btn_handle));
        al.j(this, e.d.cp_bg_line_d);
        if (this.gRv != 0) {
            al.c(this.gRr, this.gRv);
        }
    }

    public void setSpaceView(int i) {
        if (this.gRu != null) {
            this.gRu.setVisibility(i);
        }
    }
}
