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
    private BdSwitchView kTs;
    private View kYM;
    private TextView lzW;
    private TbImageView lzX;
    private TextView lzY;
    private int lzZ;

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
        this.lzW = (TextView) findViewById(R.id.setting_text);
        this.lzX = (TbImageView) findViewById(R.id.setting_tip_image);
        this.lzY = (TextView) findViewById(R.id.setting_tip);
        this.kTs = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.kTs, 10, 10, 10, 10);
        this.kYM = findViewById(R.id.space_view);
        this.kYM.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.lzZ = i;
        ao.setImageResource(this.lzX, this.lzZ);
        this.lzX.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.lzX.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lzW.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.lzW.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lzY.setVisibility(0);
        this.lzY.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.lzY.setVisibility(0);
            this.lzY.setText(i);
        }
    }

    public void turnOff() {
        this.kTs.turnOff();
    }

    public void turnOn() {
        this.kTs.turnOn();
    }

    public void turnOffNoCallback() {
        this.kTs.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.kTs.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.kTs.turnOnNoCallback();
        } else {
            this.kTs.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.kTs.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.kTs;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kTs.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.kTs.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        if (this.lzZ != 0) {
            ao.setImageResource(this.lzX, this.lzZ);
        }
    }

    public void setSpaceView(int i) {
        if (this.kYM != null) {
            this.kYM.setVisibility(i);
        }
    }
}
