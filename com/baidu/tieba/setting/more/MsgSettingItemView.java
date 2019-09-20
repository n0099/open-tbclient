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
    private View iWA;
    private int iWB;
    private TextView iWw;
    private TbImageView iWx;
    private TextView iWy;
    private BdSwitchView iWz;

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
        this.iWw = (TextView) findViewById(R.id.setting_text);
        this.iWx = (TbImageView) findViewById(R.id.setting_tip_image);
        this.iWy = (TextView) findViewById(R.id.setting_tip);
        this.iWz = (BdSwitchView) findViewById(R.id.setting_switch);
        l.b(context, this.iWz, 10, 10, 10, 10);
        this.iWA = findViewById(R.id.space_view);
        this.iWA.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iWB = i;
        am.c(this.iWx, this.iWB);
        this.iWx.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iWx.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iWw.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iWw.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iWy.setVisibility(0);
        this.iWy.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iWy.setVisibility(0);
            this.iWy.setText(i);
        }
    }

    public void nn() {
        this.iWz.nn();
    }

    public void nm() {
        this.iWz.nm();
    }

    public void nl() {
        this.iWz.nl();
    }

    public void nk() {
        this.iWz.nk();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iWz.nk();
        } else {
            this.iWz.nl();
        }
    }

    public boolean iN() {
        return this.iWz.iN();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.iWz;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iWz.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iWz.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        if (this.iWB != 0) {
            am.c(this.iWx, this.iWB);
        }
    }

    public void setSpaceView(int i) {
        if (this.iWA != null) {
            this.iWA.setVisibility(i);
        }
    }
}
