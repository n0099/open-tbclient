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
    private TextView kYF;
    private TbImageView kYG;
    private TextView kYH;
    private int kYI;
    private BdSwitchView kqr;
    private View kvR;

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
        this.kYF = (TextView) findViewById(R.id.setting_text);
        this.kYG = (TbImageView) findViewById(R.id.setting_tip_image);
        this.kYH = (TextView) findViewById(R.id.setting_tip);
        this.kqr = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.kqr, 10, 10, 10, 10);
        this.kvR = findViewById(R.id.space_view);
        this.kvR.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.kYI = i;
        am.setImageResource(this.kYG, this.kYI);
        this.kYG.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.kYG.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.kYF.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.kYF.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.kYH.setVisibility(0);
        this.kYH.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.kYH.setVisibility(0);
            this.kYH.setText(i);
        }
    }

    public void turnOff() {
        this.kqr.turnOff();
    }

    public void turnOn() {
        this.kqr.turnOn();
    }

    public void turnOffNoCallback() {
        this.kqr.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.kqr.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.kqr.turnOnNoCallback();
        } else {
            this.kqr.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.kqr.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.kqr;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kqr.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.kqr.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.kYI != 0) {
            am.setImageResource(this.kYG, this.kYI);
        }
    }

    public void setSpaceView(int i) {
        if (this.kvR != null) {
            this.kvR.setVisibility(i);
        }
    }
}
