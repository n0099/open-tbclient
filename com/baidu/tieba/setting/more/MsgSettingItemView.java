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
/* loaded from: classes26.dex */
public class MsgSettingItemView extends LinearLayout {
    private int mXA;
    private TextView mXx;
    private TbImageView mXy;
    private TextView mXz;
    private BdSwitchView mor;
    private View muk;

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
        this.mXx = (TextView) findViewById(R.id.setting_text);
        this.mXy = (TbImageView) findViewById(R.id.setting_tip_image);
        this.mXz = (TextView) findViewById(R.id.setting_tip);
        this.mor = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.mor, 10, 10, 10, 10);
        this.muk = findViewById(R.id.space_view);
        this.muk.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.mXA = i;
        ap.setImageResource(this.mXy, this.mXA);
        this.mXy.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.mXy.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mXx.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.mXx.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mXz.setVisibility(0);
        this.mXz.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.mXz.setVisibility(0);
            this.mXz.setText(i);
        }
    }

    public void turnOff() {
        this.mor.turnOff();
    }

    public void turnOn() {
        this.mor.turnOn();
    }

    public void turnOffNoCallback() {
        this.mor.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.mor.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.mor.turnOnNoCallback();
        } else {
            this.mor.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.mor.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.mor;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mor.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.mor.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.mXA != 0) {
            ap.setImageResource(this.mXy, this.mXA);
        }
    }

    public void setSpaceView(int i) {
        if (this.muk != null) {
            this.muk.setVisibility(i);
        }
    }
}
