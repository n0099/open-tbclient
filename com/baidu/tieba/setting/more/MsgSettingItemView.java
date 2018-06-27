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
    private TextView gzT;
    private TbImageView gzU;
    private TextView gzV;
    private BdSwitchView gzW;
    private View gzX;
    private int gzY;
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
        LayoutInflater.from(context).inflate(d.i.msg_setting_item_view, (ViewGroup) this, true);
        this.gzT = (TextView) findViewById(d.g.setting_text);
        this.gzU = (TbImageView) findViewById(d.g.setting_tip_image);
        this.gzV = (TextView) findViewById(d.g.setting_tip);
        this.gzW = (BdSwitchView) findViewById(d.g.setting_switch);
        l.a(context, this.gzW, 10, 10, 10, 10);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.gzX = findViewById(d.g.space_view);
        this.gzX.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.gzY = i;
        am.c(this.gzU, this.gzY);
        this.gzU.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gzU.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gzT.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gzT.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gzV.setVisibility(0);
        this.gzV.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gzV.setVisibility(0);
            this.gzV.setText(i);
        }
    }

    public void mD() {
        this.gzW.mD();
    }

    public void mC() {
        this.gzW.mC();
    }

    public void mB() {
        this.gzW.mB();
    }

    public void mA() {
        this.gzW.mA();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gzW.mA();
        } else {
            this.gzW.mB();
        }
    }

    public boolean ip() {
        return this.gzW.ip();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gzW;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gzW.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gzW.setBackgroundRes(am.cR(d.f.bg_switch_open), am.cR(d.f.bg_switch_close), am.cR(d.f.btn_handle));
        am.j(this, d.C0142d.cp_bg_line_d);
        if (this.gzY != 0) {
            am.c(this.gzU, this.gzY);
        }
    }

    public void setSpaceView(int i) {
        if (this.gzX != null) {
            this.gzX.setVisibility(i);
        }
    }
}
