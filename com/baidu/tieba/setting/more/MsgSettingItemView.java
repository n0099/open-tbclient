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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes26.dex */
public class MsgSettingItemView extends LinearLayout {
    private TbImageView mXA;
    private TextView mXB;
    private int mXC;
    private TextView mXz;
    private BdSwitchView mot;
    private View mum;

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
        this.mXz = (TextView) findViewById(R.id.setting_text);
        this.mXA = (TbImageView) findViewById(R.id.setting_tip_image);
        this.mXB = (TextView) findViewById(R.id.setting_tip);
        this.mot = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.mot, 10, 10, 10, 10);
        this.mum = findViewById(R.id.space_view);
        this.mum.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.mXC = i;
        ap.setImageResource(this.mXA, this.mXC);
        this.mXA.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.mXA.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mXz.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.mXz.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mXB.setVisibility(0);
        this.mXB.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.mXB.setVisibility(0);
            this.mXB.setText(i);
        }
    }

    public void turnOff() {
        this.mot.turnOff();
    }

    public void turnOn() {
        this.mot.turnOn();
    }

    public void turnOffNoCallback() {
        this.mot.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.mot.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.mot.turnOnNoCallback();
        } else {
            this.mot.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.mot.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.mot;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mot.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.mot.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.mXC != 0) {
            ap.setImageResource(this.mXA, this.mXC);
        }
    }

    public void setSpaceView(int i) {
        if (this.mum != null) {
            this.mum.setVisibility(i);
        }
    }
}
