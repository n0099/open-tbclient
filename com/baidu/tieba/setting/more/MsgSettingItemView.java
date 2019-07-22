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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView iSX;
    private TbImageView iSY;
    private TextView iSZ;
    private BdSwitchView iTa;
    private View iTb;
    private int iTc;
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
        LayoutInflater.from(context).inflate(R.layout.msg_setting_item_view, (ViewGroup) this, true);
        this.iSX = (TextView) findViewById(R.id.setting_text);
        this.iSY = (TbImageView) findViewById(R.id.setting_tip_image);
        this.iSZ = (TextView) findViewById(R.id.setting_tip);
        this.iTa = (BdSwitchView) findViewById(R.id.setting_switch);
        l.b(context, this.iTa, 10, 10, 10, 10);
        this.mBottomLine = findViewById(R.id.bottom_line_ll);
        this.iTb = findViewById(R.id.space_view);
        this.iTb.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iTc = i;
        am.c(this.iSY, this.iTc);
        this.iSY.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iSY.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iSX.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iSX.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iSZ.setVisibility(0);
        this.iSZ.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iSZ.setVisibility(0);
            this.iSZ.setText(i);
        }
    }

    public void nn() {
        this.iTa.nn();
    }

    public void nm() {
        this.iTa.nm();
    }

    public void nl() {
        this.iTa.nl();
    }

    public void nk() {
        this.iTa.nk();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iTa.nk();
        } else {
            this.iTa.nl();
        }
    }

    public boolean iN() {
        return this.iTa.iN();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.iTa;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iTa.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iTa.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        am.l(this, R.color.cp_bg_line_d);
        if (this.iTc != 0) {
            am.c(this.iSY, this.iTc);
        }
    }

    public void setSpaceView(int i) {
        if (this.iTb != null) {
            this.iTb.setVisibility(i);
        }
    }
}
