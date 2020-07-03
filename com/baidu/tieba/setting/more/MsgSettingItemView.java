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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class MsgSettingItemView extends LinearLayout {
    private BdSwitchView kKp;
    private View kPO;
    private TextView lsC;
    private TbImageView lsD;
    private TextView lsE;
    private int lsF;

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
        this.lsC = (TextView) findViewById(R.id.setting_text);
        this.lsD = (TbImageView) findViewById(R.id.setting_tip_image);
        this.lsE = (TextView) findViewById(R.id.setting_tip);
        this.kKp = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.kKp, 10, 10, 10, 10);
        this.kPO = findViewById(R.id.space_view);
        this.kPO.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.lsF = i;
        an.setImageResource(this.lsD, this.lsF);
        this.lsD.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.lsD.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lsC.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.lsC.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lsE.setVisibility(0);
        this.lsE.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.lsE.setVisibility(0);
            this.lsE.setText(i);
        }
    }

    public void turnOff() {
        this.kKp.turnOff();
    }

    public void turnOn() {
        this.kKp.turnOn();
    }

    public void turnOffNoCallback() {
        this.kKp.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.kKp.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.kKp.turnOnNoCallback();
        } else {
            this.kKp.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.kKp.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.kKp;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kKp.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.kKp.setBackgroundRes(an.getBitmap(R.drawable.bg_switch_open), an.getBitmap(R.drawable.bg_switch_close), an.getBitmap(R.drawable.btn_handle));
        if (this.lsF != 0) {
            an.setImageResource(this.lsD, this.lsF);
        }
    }

    public void setSpaceView(int i) {
        if (this.kPO != null) {
            this.kPO.setVisibility(i);
        }
    }
}
