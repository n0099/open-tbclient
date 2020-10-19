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
    private BdSwitchView lHy;
    private View lNp;
    private TextView mqq;
    private TbImageView mqr;
    private TextView mqs;
    private int mqt;

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
        this.mqq = (TextView) findViewById(R.id.setting_text);
        this.mqr = (TbImageView) findViewById(R.id.setting_tip_image);
        this.mqs = (TextView) findViewById(R.id.setting_tip);
        this.lHy = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.lHy, 10, 10, 10, 10);
        this.lNp = findViewById(R.id.space_view);
        this.lNp.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.mqt = i;
        ap.setImageResource(this.mqr, this.mqt);
        this.mqr.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.mqr.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mqq.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.mqq.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mqs.setVisibility(0);
        this.mqs.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.mqs.setVisibility(0);
            this.mqs.setText(i);
        }
    }

    public void turnOff() {
        this.lHy.turnOff();
    }

    public void turnOn() {
        this.lHy.turnOn();
    }

    public void turnOffNoCallback() {
        this.lHy.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.lHy.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.lHy.turnOnNoCallback();
        } else {
            this.lHy.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.lHy.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.lHy;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.lHy.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.lHy.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.mqt != 0) {
            ap.setImageResource(this.mqr, this.mqt);
        }
    }

    public void setSpaceView(int i) {
        if (this.lNp != null) {
            this.lNp.setVisibility(i);
        }
    }
}
