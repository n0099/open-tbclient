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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView gBb;
    private TbImageView gBc;
    private TextView gBd;
    private BdSwitchView gBe;
    private View gBf;
    private int gBg;
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
        LayoutInflater.from(context).inflate(d.h.msg_setting_item_view, (ViewGroup) this, true);
        this.gBb = (TextView) findViewById(d.g.setting_text);
        this.gBc = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gBd = (TextView) findViewById(d.g.setting_tip);
        this.gBe = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gBe, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.gBf = findViewById(d.g.space_view);
        this.gBf.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.gBg = i;
        am.c(this.gBc, this.gBg);
        this.gBc.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gBc.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gBb.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gBb.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gBd.setVisibility(0);
        this.gBd.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gBd.setVisibility(0);
            this.gBd.setText(i);
        }
    }

    public void mF() {
        this.gBe.mF();
    }

    public void mE() {
        this.gBe.mE();
    }

    public void mD() {
        this.gBe.mD();
    }

    public void mC() {
        this.gBe.mC();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gBe.mC();
        } else {
            this.gBe.mD();
        }
    }

    public boolean iq() {
        return this.gBe.iq();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gBe;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gBe.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gBe.setBackgroundRes(am.cT(d.f.bg_switch_open), am.cT(d.f.bg_switch_close), am.cT(d.f.btn_handle));
        am.j(this, d.C0140d.cp_bg_line_d);
        if (this.gBg != 0) {
            am.c(this.gBc, this.gBg);
        }
    }

    public void setSpaceView(int i) {
        if (this.gBf != null) {
            this.gBf.setVisibility(i);
        }
    }
}
