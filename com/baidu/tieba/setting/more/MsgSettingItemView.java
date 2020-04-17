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
    private BdSwitchView jXo;
    private TextView kFq;
    private TbImageView kFr;
    private TextView kFs;
    private int kFt;
    private View kcQ;

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
        this.kFq = (TextView) findViewById(R.id.setting_text);
        this.kFr = (TbImageView) findViewById(R.id.setting_tip_image);
        this.kFs = (TextView) findViewById(R.id.setting_tip);
        this.jXo = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jXo, 10, 10, 10, 10);
        this.kcQ = findViewById(R.id.space_view);
        this.kcQ.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.kFt = i;
        am.setImageResource(this.kFr, this.kFt);
        this.kFr.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.kFr.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.kFq.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.kFq.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.kFs.setVisibility(0);
        this.kFs.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.kFs.setVisibility(0);
            this.kFs.setText(i);
        }
    }

    public void turnOff() {
        this.jXo.turnOff();
    }

    public void turnOn() {
        this.jXo.turnOn();
    }

    public void turnOffNoCallback() {
        this.jXo.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jXo.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jXo.turnOnNoCallback();
        } else {
            this.jXo.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jXo.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jXo;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jXo.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jXo.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.kFt != 0) {
            am.setImageResource(this.kFr, this.kFt);
        }
    }

    public void setSpaceView(int i) {
        if (this.kcQ != null) {
            this.kcQ.setVisibility(i);
        }
    }
}
