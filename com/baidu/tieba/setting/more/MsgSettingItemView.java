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
/* loaded from: classes20.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView lRC;
    private TbImageView lRD;
    private TextView lRE;
    private int lRF;
    private BdSwitchView ljp;
    private View lph;

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
        this.lRC = (TextView) findViewById(R.id.setting_text);
        this.lRD = (TbImageView) findViewById(R.id.setting_tip_image);
        this.lRE = (TextView) findViewById(R.id.setting_tip);
        this.ljp = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.ljp, 10, 10, 10, 10);
        this.lph = findViewById(R.id.space_view);
        this.lph.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.lRF = i;
        ap.setImageResource(this.lRD, this.lRF);
        this.lRD.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.lRD.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lRC.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.lRC.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lRE.setVisibility(0);
        this.lRE.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.lRE.setVisibility(0);
            this.lRE.setText(i);
        }
    }

    public void turnOff() {
        this.ljp.turnOff();
    }

    public void turnOn() {
        this.ljp.turnOn();
    }

    public void turnOffNoCallback() {
        this.ljp.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.ljp.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.ljp.turnOnNoCallback();
        } else {
            this.ljp.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.ljp.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.ljp;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ljp.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.ljp.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.lRF != 0) {
            ap.setImageResource(this.lRD, this.lRF);
        }
    }

    public void setSpaceView(int i) {
        if (this.lph != null) {
            this.lph.setVisibility(i);
        }
    }
}
