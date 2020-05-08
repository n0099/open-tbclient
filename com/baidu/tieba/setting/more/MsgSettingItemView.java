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
    private BdSwitchView jXs;
    private TextView kFu;
    private TbImageView kFv;
    private TextView kFw;
    private int kFx;
    private View kcU;

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
        this.kFu = (TextView) findViewById(R.id.setting_text);
        this.kFv = (TbImageView) findViewById(R.id.setting_tip_image);
        this.kFw = (TextView) findViewById(R.id.setting_tip);
        this.jXs = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jXs, 10, 10, 10, 10);
        this.kcU = findViewById(R.id.space_view);
        this.kcU.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.kFx = i;
        am.setImageResource(this.kFv, this.kFx);
        this.kFv.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.kFv.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.kFu.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.kFu.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.kFw.setVisibility(0);
        this.kFw.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.kFw.setVisibility(0);
            this.kFw.setText(i);
        }
    }

    public void turnOff() {
        this.jXs.turnOff();
    }

    public void turnOn() {
        this.jXs.turnOn();
    }

    public void turnOffNoCallback() {
        this.jXs.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jXs.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jXs.turnOnNoCallback();
        } else {
            this.jXs.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jXs.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jXs;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jXs.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jXs.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.kFx != 0) {
            am.setImageResource(this.kFv, this.kFx);
        }
    }

    public void setSpaceView(int i) {
        if (this.kcU != null) {
            this.kcU.setVisibility(i);
        }
    }
}
