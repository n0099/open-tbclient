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
    private BdSwitchView lTU;
    private View lZL;
    private TextView mCS;
    private TbImageView mCT;
    private TextView mCU;
    private int mCV;

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
        this.mCS = (TextView) findViewById(R.id.setting_text);
        this.mCT = (TbImageView) findViewById(R.id.setting_tip_image);
        this.mCU = (TextView) findViewById(R.id.setting_tip);
        this.lTU = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.lTU, 10, 10, 10, 10);
        this.lZL = findViewById(R.id.space_view);
        this.lZL.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.mCV = i;
        ap.setImageResource(this.mCT, this.mCV);
        this.mCT.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.mCT.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mCS.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.mCS.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mCU.setVisibility(0);
        this.mCU.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.mCU.setVisibility(0);
            this.mCU.setText(i);
        }
    }

    public void turnOff() {
        this.lTU.turnOff();
    }

    public void turnOn() {
        this.lTU.turnOn();
    }

    public void turnOffNoCallback() {
        this.lTU.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.lTU.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.lTU.turnOnNoCallback();
        } else {
            this.lTU.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.lTU.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.lTU;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.lTU.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.lTU.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.mCV != 0) {
            ap.setImageResource(this.mCT, this.mCV);
        }
    }

    public void setSpaceView(int i) {
        if (this.lZL != null) {
            this.lZL.setVisibility(i);
        }
    }
}
