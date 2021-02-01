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
/* loaded from: classes8.dex */
public class MsgSettingItemView extends LinearLayout {
    private View mDY;
    private BdSwitchView mxZ;
    private TextView nhW;
    private TbImageView nhX;
    private TextView nhY;
    private int nhZ;

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
        this.nhW = (TextView) findViewById(R.id.setting_text);
        this.nhX = (TbImageView) findViewById(R.id.setting_tip_image);
        this.nhY = (TextView) findViewById(R.id.setting_tip);
        this.mxZ = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.mxZ, 10, 10, 10, 10);
        this.mDY = findViewById(R.id.space_view);
        this.mDY.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.nhZ = i;
        ap.setImageResource(this.nhX, this.nhZ);
        this.nhX.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.nhX.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.nhW.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.nhW.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.nhY.setVisibility(0);
        this.nhY.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.nhY.setVisibility(0);
            this.nhY.setText(i);
        }
    }

    public void turnOff() {
        this.mxZ.turnOff();
    }

    public void turnOn() {
        this.mxZ.turnOn();
    }

    public void turnOffNoCallback() {
        this.mxZ.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.mxZ.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.mxZ.turnOnNoCallback();
        } else {
            this.mxZ.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.mxZ.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.mxZ;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mxZ.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.mxZ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.nhZ != 0) {
            ap.setImageResource(this.nhX, this.nhZ);
        }
    }

    public void setSpaceView(int i) {
        if (this.mDY != null) {
            this.mDY.setVisibility(i);
        }
    }
}
