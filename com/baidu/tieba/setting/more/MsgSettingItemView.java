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
    private TextView jUF;
    private TbImageView jUG;
    private TextView jUH;
    private int jUI;
    private BdSwitchView jlA;
    private View jrb;

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
        this.jUF = (TextView) findViewById(R.id.setting_text);
        this.jUG = (TbImageView) findViewById(R.id.setting_tip_image);
        this.jUH = (TextView) findViewById(R.id.setting_tip);
        this.jlA = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jlA, 10, 10, 10, 10);
        this.jrb = findViewById(R.id.space_view);
        this.jrb.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.jUI = i;
        am.setImageResource(this.jUG, this.jUI);
        this.jUG.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.jUG.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jUF.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.jUF.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jUH.setVisibility(0);
        this.jUH.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.jUH.setVisibility(0);
            this.jUH.setText(i);
        }
    }

    public void turnOff() {
        this.jlA.turnOff();
    }

    public void turnOn() {
        this.jlA.turnOn();
    }

    public void turnOffNoCallback() {
        this.jlA.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jlA.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jlA.turnOnNoCallback();
        } else {
            this.jlA.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jlA.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jlA;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jlA.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jlA.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.jUI != 0) {
            am.setImageResource(this.jUG, this.jUI);
        }
    }

    public void setSpaceView(int i) {
        if (this.jrb != null) {
            this.jrb.setVisibility(i);
        }
    }
}
