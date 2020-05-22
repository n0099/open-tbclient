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
    private TextView kXw;
    private TbImageView kXx;
    private TextView kXy;
    private int kXz;
    private BdSwitchView kpl;
    private View kuL;

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
        this.kXw = (TextView) findViewById(R.id.setting_text);
        this.kXx = (TbImageView) findViewById(R.id.setting_tip_image);
        this.kXy = (TextView) findViewById(R.id.setting_tip);
        this.kpl = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.kpl, 10, 10, 10, 10);
        this.kuL = findViewById(R.id.space_view);
        this.kuL.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.kXz = i;
        am.setImageResource(this.kXx, this.kXz);
        this.kXx.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.kXx.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.kXw.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.kXw.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.kXy.setVisibility(0);
        this.kXy.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.kXy.setVisibility(0);
            this.kXy.setText(i);
        }
    }

    public void turnOff() {
        this.kpl.turnOff();
    }

    public void turnOn() {
        this.kpl.turnOn();
    }

    public void turnOffNoCallback() {
        this.kpl.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.kpl.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.kpl.turnOnNoCallback();
        } else {
            this.kpl.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.kpl.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.kpl;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kpl.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.kpl.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.kXz != 0) {
            am.setImageResource(this.kXx, this.kXz);
        }
    }

    public void setSpaceView(int i) {
        if (this.kuL != null) {
            this.kuL.setVisibility(i);
        }
    }
}
