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
    private TextView jUr;
    private TbImageView jUs;
    private TextView jUt;
    private int jUu;
    private BdSwitchView jlm;
    private View jqN;

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
        this.jUr = (TextView) findViewById(R.id.setting_text);
        this.jUs = (TbImageView) findViewById(R.id.setting_tip_image);
        this.jUt = (TextView) findViewById(R.id.setting_tip);
        this.jlm = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jlm, 10, 10, 10, 10);
        this.jqN = findViewById(R.id.space_view);
        this.jqN.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.jUu = i;
        am.setImageResource(this.jUs, this.jUu);
        this.jUs.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.jUs.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jUr.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.jUr.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jUt.setVisibility(0);
        this.jUt.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.jUt.setVisibility(0);
            this.jUt.setText(i);
        }
    }

    public void turnOff() {
        this.jlm.turnOff();
    }

    public void turnOn() {
        this.jlm.turnOn();
    }

    public void turnOffNoCallback() {
        this.jlm.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jlm.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jlm.turnOnNoCallback();
        } else {
            this.jlm.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jlm.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jlm;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jlm.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jlm.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.jUu != 0) {
            am.setImageResource(this.jUs, this.jUu);
        }
    }

    public void setSpaceView(int i) {
        if (this.jqN != null) {
            this.jqN.setVisibility(i);
        }
    }
}
