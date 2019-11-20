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
    private TextView iVs;
    private TbImageView iVt;
    private TextView iVu;
    private BdSwitchView iVv;
    private View iVw;
    private int iVx;

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
        this.iVs = (TextView) findViewById(R.id.setting_text);
        this.iVt = (TbImageView) findViewById(R.id.setting_tip_image);
        this.iVu = (TextView) findViewById(R.id.setting_tip);
        this.iVv = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.iVv, 10, 10, 10, 10);
        this.iVw = findViewById(R.id.space_view);
        this.iVw.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iVx = i;
        am.setImageResource(this.iVt, this.iVx);
        this.iVt.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iVt.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iVs.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iVs.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iVu.setVisibility(0);
        this.iVu.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iVu.setVisibility(0);
            this.iVu.setText(i);
        }
    }

    public void turnOff() {
        this.iVv.turnOff();
    }

    public void turnOn() {
        this.iVv.turnOn();
    }

    public void turnOffNoCallback() {
        this.iVv.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.iVv.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iVv.turnOnNoCallback();
        } else {
            this.iVv.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.iVv.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.iVv;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iVv.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iVv.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.iVx != 0) {
            am.setImageResource(this.iVt, this.iVx);
        }
    }

    public void setSpaceView(int i) {
        if (this.iVw != null) {
            this.iVw.setVisibility(i);
        }
    }
}
