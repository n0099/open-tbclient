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
/* loaded from: classes20.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView lRn;
    private TbImageView lRo;
    private TextView lRp;
    private int lRq;
    private BdSwitchView lji;
    private View loW;

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
        this.lRn = (TextView) findViewById(R.id.setting_text);
        this.lRo = (TbImageView) findViewById(R.id.setting_tip_image);
        this.lRp = (TextView) findViewById(R.id.setting_tip);
        this.lji = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.lji, 10, 10, 10, 10);
        this.loW = findViewById(R.id.space_view);
        this.loW.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.lRq = i;
        ap.setImageResource(this.lRo, this.lRq);
        this.lRo.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.lRo.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lRn.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.lRn.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.lRp.setVisibility(0);
        this.lRp.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.lRp.setVisibility(0);
            this.lRp.setText(i);
        }
    }

    public void turnOff() {
        this.lji.turnOff();
    }

    public void turnOn() {
        this.lji.turnOn();
    }

    public void turnOffNoCallback() {
        this.lji.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.lji.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.lji.turnOnNoCallback();
        } else {
            this.lji.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.lji.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.lji;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.lji.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.lji.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.lRq != 0) {
            ap.setImageResource(this.lRo, this.lRq);
        }
    }

    public void setSpaceView(int i) {
        if (this.loW != null) {
            this.loW.setVisibility(i);
        }
    }
}
