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
/* loaded from: classes8.dex */
public class MsgSettingItemView extends LinearLayout {
    private View mEn;
    private BdSwitchView myo;
    private int niA;
    private TextView nix;
    private TbImageView niy;
    private TextView niz;

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
        this.nix = (TextView) findViewById(R.id.setting_text);
        this.niy = (TbImageView) findViewById(R.id.setting_tip_image);
        this.niz = (TextView) findViewById(R.id.setting_tip);
        this.myo = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.myo, 10, 10, 10, 10);
        this.mEn = findViewById(R.id.space_view);
        this.mEn.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.niA = i;
        ap.setImageResource(this.niy, this.niA);
        this.niy.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.niy.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.nix.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.nix.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.niz.setVisibility(0);
        this.niz.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.niz.setVisibility(0);
            this.niz.setText(i);
        }
    }

    public void turnOff() {
        this.myo.turnOff();
    }

    public void turnOn() {
        this.myo.turnOn();
    }

    public void turnOffNoCallback() {
        this.myo.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.myo.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.myo.turnOnNoCallback();
        } else {
            this.myo.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.myo.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.myo;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.myo.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.myo.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.niA != 0) {
            ap.setImageResource(this.niy, this.niA);
        }
    }

    public void setSpaceView(int i) {
        if (this.mEn != null) {
            this.mEn.setVisibility(i);
        }
    }
}
