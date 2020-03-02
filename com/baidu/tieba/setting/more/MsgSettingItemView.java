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
    private TextView jUt;
    private TbImageView jUu;
    private TextView jUv;
    private int jUw;
    private BdSwitchView jlo;
    private View jqP;

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
        this.jUt = (TextView) findViewById(R.id.setting_text);
        this.jUu = (TbImageView) findViewById(R.id.setting_tip_image);
        this.jUv = (TextView) findViewById(R.id.setting_tip);
        this.jlo = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jlo, 10, 10, 10, 10);
        this.jqP = findViewById(R.id.space_view);
        this.jqP.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.jUw = i;
        am.setImageResource(this.jUu, this.jUw);
        this.jUu.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.jUu.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jUt.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.jUt.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jUv.setVisibility(0);
        this.jUv.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.jUv.setVisibility(0);
            this.jUv.setText(i);
        }
    }

    public void turnOff() {
        this.jlo.turnOff();
    }

    public void turnOn() {
        this.jlo.turnOn();
    }

    public void turnOffNoCallback() {
        this.jlo.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jlo.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jlo.turnOnNoCallback();
        } else {
            this.jlo.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jlo.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jlo;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jlo.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jlo.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.jUw != 0) {
            am.setImageResource(this.jUu, this.jUw);
        }
    }

    public void setSpaceView(int i) {
        if (this.jqP != null) {
            this.jqP.setVisibility(i);
        }
    }
}
