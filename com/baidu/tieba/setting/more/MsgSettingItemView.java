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
    private BdSwitchView mtF;
    private View mzz;
    private TextView ncU;
    private TbImageView ncV;
    private TextView ncW;
    private int ncX;

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
        this.ncU = (TextView) findViewById(R.id.setting_text);
        this.ncV = (TbImageView) findViewById(R.id.setting_tip_image);
        this.ncW = (TextView) findViewById(R.id.setting_tip);
        this.mtF = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.mtF, 10, 10, 10, 10);
        this.mzz = findViewById(R.id.space_view);
        this.mzz.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.ncX = i;
        ao.setImageResource(this.ncV, this.ncX);
        this.ncV.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.ncV.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.ncU.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.ncU.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.ncW.setVisibility(0);
        this.ncW.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.ncW.setVisibility(0);
            this.ncW.setText(i);
        }
    }

    public void turnOff() {
        this.mtF.turnOff();
    }

    public void turnOn() {
        this.mtF.turnOn();
    }

    public void turnOffNoCallback() {
        this.mtF.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.mtF.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.mtF.turnOnNoCallback();
        } else {
            this.mtF.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.mtF.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.mtF;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mtF.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.mtF.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        if (this.ncX != 0) {
            ao.setImageResource(this.ncV, this.ncX);
        }
    }

    public void setSpaceView(int i) {
        if (this.mzz != null) {
            this.mzz.setVisibility(i);
        }
    }
}
