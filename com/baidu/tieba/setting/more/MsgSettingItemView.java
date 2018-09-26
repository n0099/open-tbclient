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
    private TextView gIu;
    private TbImageView gIv;
    private TextView gIw;
    private BdSwitchView gIx;
    private View gIy;
    private int gIz;
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
        this.gIu = (TextView) findViewById(e.g.setting_text);
        this.gIv = (TbImageView) findViewById(e.g.setting_tip_image);
        this.gIw = (TextView) findViewById(e.g.setting_tip);
        this.gIx = (BdSwitchView) findViewById(e.g.setting_switch);
        l.a(context, this.gIx, 10, 10, 10, 10);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.gIy = findViewById(e.g.space_view);
        this.gIy.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.gIz = i;
        al.c(this.gIv, this.gIz);
        this.gIv.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.gIv.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gIu.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gIu.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gIw.setVisibility(0);
        this.gIw.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.gIw.setVisibility(0);
            this.gIw.setText(i);
        }
    }

    public void nL() {
        this.gIx.nL();
    }

    public void nK() {
        this.gIx.nK();
    }

    public void nJ() {
        this.gIx.nJ();
    }

    public void nI() {
        this.gIx.nI();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.gIx.nI();
        } else {
            this.gIx.nJ();
        }
    }

    public boolean jw() {
        return this.gIx.jw();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.gIx;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.gIx.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.gIx.setBackgroundRes(al.dc(e.f.bg_switch_open), al.dc(e.f.bg_switch_close), al.dc(e.f.btn_handle));
        al.j(this, e.d.cp_bg_line_d);
        if (this.gIz != 0) {
            al.c(this.gIv, this.gIz);
        }
    }

    public void setSpaceView(int i) {
        if (this.gIy != null) {
            this.gIy.setVisibility(i);
        }
    }
}
