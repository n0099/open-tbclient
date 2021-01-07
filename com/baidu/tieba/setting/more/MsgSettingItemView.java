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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class MsgSettingItemView extends LinearLayout {
    private BdSwitchView mtE;
    private View mzy;
    private TextView ncT;
    private TbImageView ncU;
    private TextView ncV;
    private int ncW;

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
        this.ncT = (TextView) findViewById(R.id.setting_text);
        this.ncU = (TbImageView) findViewById(R.id.setting_tip_image);
        this.ncV = (TextView) findViewById(R.id.setting_tip);
        this.mtE = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.mtE, 10, 10, 10, 10);
        this.mzy = findViewById(R.id.space_view);
        this.mzy.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.ncW = i;
        ao.setImageResource(this.ncU, this.ncW);
        this.ncU.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.ncU.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.ncT.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.ncT.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.ncV.setVisibility(0);
        this.ncV.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.ncV.setVisibility(0);
            this.ncV.setText(i);
        }
    }

    public void turnOff() {
        this.mtE.turnOff();
    }

    public void turnOn() {
        this.mtE.turnOn();
    }

    public void turnOffNoCallback() {
        this.mtE.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.mtE.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.mtE.turnOnNoCallback();
        } else {
            this.mtE.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.mtE.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.mtE;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mtE.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.mtE.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        if (this.ncW != 0) {
            ao.setImageResource(this.ncU, this.ncW);
        }
    }

    public void setSpaceView(int i) {
        if (this.mzy != null) {
            this.mzy.setVisibility(i);
        }
    }
}
