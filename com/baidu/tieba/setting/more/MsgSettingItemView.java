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
/* loaded from: classes11.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView jTr;
    private TbImageView jTs;
    private TextView jTt;
    private int jTu;
    private BdSwitchView jko;
    private View jpN;

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
        this.jTr = (TextView) findViewById(R.id.setting_text);
        this.jTs = (TbImageView) findViewById(R.id.setting_tip_image);
        this.jTt = (TextView) findViewById(R.id.setting_tip);
        this.jko = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jko, 10, 10, 10, 10);
        this.jpN = findViewById(R.id.space_view);
        this.jpN.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.jTu = i;
        am.setImageResource(this.jTs, this.jTu);
        this.jTs.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.jTs.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jTr.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.jTr.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jTt.setVisibility(0);
        this.jTt.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.jTt.setVisibility(0);
            this.jTt.setText(i);
        }
    }

    public void turnOff() {
        this.jko.turnOff();
    }

    public void turnOn() {
        this.jko.turnOn();
    }

    public void turnOffNoCallback() {
        this.jko.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jko.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jko.turnOnNoCallback();
        } else {
            this.jko.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jko.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jko;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jko.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jko.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.jTu != 0) {
            am.setImageResource(this.jTs, this.jTu);
        }
    }

    public void setSpaceView(int i) {
        if (this.jpN != null) {
            this.jpN.setVisibility(i);
        }
    }
}
