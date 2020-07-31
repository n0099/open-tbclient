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
/* loaded from: classes20.dex */
public class MsgSettingItemView extends LinearLayout {
    private BdSwitchView kTq;
    private View kYK;
    private TextView lzU;
    private TbImageView lzV;
    private TextView lzW;
    private int lzX;

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
        this.lzU = (TextView) findViewById(R.id.setting_text);
        this.lzV = (TbImageView) findViewById(R.id.setting_tip_image);
        this.lzW = (TextView) findViewById(R.id.setting_tip);
        this.kTq = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.kTq, 10, 10, 10, 10);
        this.kYK = findViewById(R.id.space_view);
        this.kYK.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.lzX = i;
        ao.setImageResource(this.lzV, this.lzX);
        this.lzV.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.lzV.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lzU.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.lzU.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lzW.setVisibility(0);
        this.lzW.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.lzW.setVisibility(0);
            this.lzW.setText(i);
        }
    }

    public void turnOff() {
        this.kTq.turnOff();
    }

    public void turnOn() {
        this.kTq.turnOn();
    }

    public void turnOffNoCallback() {
        this.kTq.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.kTq.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.kTq.turnOnNoCallback();
        } else {
            this.kTq.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.kTq.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.kTq;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kTq.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.kTq.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        if (this.lzX != 0) {
            ao.setImageResource(this.lzV, this.lzX);
        }
    }

    public void setSpaceView(int i) {
        if (this.kYK != null) {
            this.kYK.setVisibility(i);
        }
    }
}
