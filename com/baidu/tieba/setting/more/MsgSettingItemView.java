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
/* loaded from: classes25.dex */
public class MsgSettingItemView extends LinearLayout {
    private BdSwitchView lsl;
    private View lxZ;
    private TextView maM;
    private TbImageView maN;
    private TextView maO;
    private int maP;

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
        this.maM = (TextView) findViewById(R.id.setting_text);
        this.maN = (TbImageView) findViewById(R.id.setting_tip_image);
        this.maO = (TextView) findViewById(R.id.setting_tip);
        this.lsl = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.lsl, 10, 10, 10, 10);
        this.lxZ = findViewById(R.id.space_view);
        this.lxZ.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.maP = i;
        ap.setImageResource(this.maN, this.maP);
        this.maN.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.maN.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.maM.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.maM.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.maO.setVisibility(0);
        this.maO.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.maO.setVisibility(0);
            this.maO.setText(i);
        }
    }

    public void turnOff() {
        this.lsl.turnOff();
    }

    public void turnOn() {
        this.lsl.turnOn();
    }

    public void turnOffNoCallback() {
        this.lsl.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.lsl.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.lsl.turnOnNoCallback();
        } else {
            this.lsl.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.lsl.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.lsl;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.lsl.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.lsl.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.maP != 0) {
            ap.setImageResource(this.maN, this.maP);
        }
    }

    public void setSpaceView(int i) {
        if (this.lxZ != null) {
            this.lxZ.setVisibility(i);
        }
    }
}
