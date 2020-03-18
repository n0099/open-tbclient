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
/* loaded from: classes13.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView jWh;
    private TbImageView jWi;
    private TextView jWj;
    private int jWk;
    private BdSwitchView jna;
    private View jsA;

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
        this.jWh = (TextView) findViewById(R.id.setting_text);
        this.jWi = (TbImageView) findViewById(R.id.setting_tip_image);
        this.jWj = (TextView) findViewById(R.id.setting_tip);
        this.jna = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jna, 10, 10, 10, 10);
        this.jsA = findViewById(R.id.space_view);
        this.jsA.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.jWk = i;
        am.setImageResource(this.jWi, this.jWk);
        this.jWi.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.jWi.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jWh.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.jWh.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jWj.setVisibility(0);
        this.jWj.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.jWj.setVisibility(0);
            this.jWj.setText(i);
        }
    }

    public void turnOff() {
        this.jna.turnOff();
    }

    public void turnOn() {
        this.jna.turnOn();
    }

    public void turnOffNoCallback() {
        this.jna.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jna.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jna.turnOnNoCallback();
        } else {
            this.jna.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jna.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jna;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jna.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jna.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.jWk != 0) {
            am.setImageResource(this.jWi, this.jWk);
        }
    }

    public void setSpaceView(int i) {
        if (this.jsA != null) {
            this.jsA.setVisibility(i);
        }
    }
}
