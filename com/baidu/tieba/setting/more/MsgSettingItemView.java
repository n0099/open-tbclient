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
/* loaded from: classes10.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView jPO;
    private TbImageView jPP;
    private TextView jPQ;
    private int jPR;
    private BdSwitchView jgL;
    private View jmk;

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
        this.jPO = (TextView) findViewById(R.id.setting_text);
        this.jPP = (TbImageView) findViewById(R.id.setting_tip_image);
        this.jPQ = (TextView) findViewById(R.id.setting_tip);
        this.jgL = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jgL, 10, 10, 10, 10);
        this.jmk = findViewById(R.id.space_view);
        this.jmk.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.jPR = i;
        am.setImageResource(this.jPP, this.jPR);
        this.jPP.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.jPP.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jPO.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.jPO.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jPQ.setVisibility(0);
        this.jPQ.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.jPQ.setVisibility(0);
            this.jPQ.setText(i);
        }
    }

    public void turnOff() {
        this.jgL.turnOff();
    }

    public void turnOn() {
        this.jgL.turnOn();
    }

    public void turnOffNoCallback() {
        this.jgL.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jgL.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jgL.turnOnNoCallback();
        } else {
            this.jgL.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jgL.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jgL;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jgL.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jgL.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.jPR != 0) {
            am.setImageResource(this.jPP, this.jPR);
        }
    }

    public void setSpaceView(int i) {
        if (this.jmk != null) {
            this.jmk.setVisibility(i);
        }
    }
}
