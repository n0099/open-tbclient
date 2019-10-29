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
/* loaded from: classes3.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView iWj;
    private TbImageView iWk;
    private TextView iWl;
    private BdSwitchView iWm;
    private View iWn;
    private int iWo;

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
        this.iWj = (TextView) findViewById(R.id.setting_text);
        this.iWk = (TbImageView) findViewById(R.id.setting_tip_image);
        this.iWl = (TextView) findViewById(R.id.setting_tip);
        this.iWm = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.iWm, 10, 10, 10, 10);
        this.iWn = findViewById(R.id.space_view);
        this.iWn.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iWo = i;
        am.setImageResource(this.iWk, this.iWo);
        this.iWk.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iWk.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iWj.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iWj.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iWl.setVisibility(0);
        this.iWl.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iWl.setVisibility(0);
            this.iWl.setText(i);
        }
    }

    public void turnOff() {
        this.iWm.turnOff();
    }

    public void turnOn() {
        this.iWm.turnOn();
    }

    public void turnOffNoCallback() {
        this.iWm.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.iWm.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iWm.turnOnNoCallback();
        } else {
            this.iWm.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.iWm.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.iWm;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iWm.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iWm.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.iWo != 0) {
            am.setImageResource(this.iWk, this.iWo);
        }
    }

    public void setSpaceView(int i) {
        if (this.iWn != null) {
            this.iWn.setVisibility(i);
        }
    }
}
