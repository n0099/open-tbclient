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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView gBe;
    private TbImageView gBf;
    private TextView gBg;
    private BdSwitchView gBh;
    private View gBi;
    private int gBj;
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
        LayoutInflater.from(context).inflate(f.h.msg_setting_item_view, (ViewGroup) this, true);
        this.gBe = (TextView) findViewById(f.g.setting_text);
        this.gBf = (TbImageView) findViewById(f.g.setting_tip_image);
        this.gBg = (TextView) findViewById(f.g.setting_tip);
        this.gBh = (BdSwitchView) findViewById(f.g.setting_switch);
        l.a(context, this.gBh, 10, 10, 10, 10);
        this.mBottomLine = findViewById(f.g.bottom_line_ll);
        this.gBi = findViewById(f.g.space_view);
        this.gBi.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.gBj = i;
        am.c(this.gBf, this.gBj);
        this.gBf.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gBf.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gBe.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gBe.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gBg.setVisibility(0);
        this.gBg.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gBg.setVisibility(0);
            this.gBg.setText(i);
        }
    }

    public void mF() {
        this.gBh.mF();
    }

    public void mE() {
        this.gBh.mE();
    }

    public void mD() {
        this.gBh.mD();
    }

    public void mC() {
        this.gBh.mC();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gBh.mC();
        } else {
            this.gBh.mD();
        }
    }

    public boolean iq() {
        return this.gBh.iq();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gBh;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gBh.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gBh.setBackgroundRes(am.cT(f.C0146f.bg_switch_open), am.cT(f.C0146f.bg_switch_close), am.cT(f.C0146f.btn_handle));
        am.j(this, f.d.cp_bg_line_d);
        if (this.gBj != 0) {
            am.c(this.gBf, this.gBj);
        }
    }

    public void setSpaceView(int i) {
        if (this.gBi != null) {
            this.gBi.setVisibility(i);
        }
    }
}
