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
    private BdSwitchView lZQ;
    private TextView mIX;
    private TbImageView mIY;
    private TextView mIZ;
    private int mJa;
    private View mfL;

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
        this.mIX = (TextView) findViewById(R.id.setting_text);
        this.mIY = (TbImageView) findViewById(R.id.setting_tip_image);
        this.mIZ = (TextView) findViewById(R.id.setting_tip);
        this.lZQ = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.lZQ, 10, 10, 10, 10);
        this.mfL = findViewById(R.id.space_view);
        this.mfL.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.mJa = i;
        ap.setImageResource(this.mIY, this.mJa);
        this.mIY.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.mIY.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mIX.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.mIX.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mIZ.setVisibility(0);
        this.mIZ.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.mIZ.setVisibility(0);
            this.mIZ.setText(i);
        }
    }

    public void turnOff() {
        this.lZQ.turnOff();
    }

    public void turnOn() {
        this.lZQ.turnOn();
    }

    public void turnOffNoCallback() {
        this.lZQ.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.lZQ.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.lZQ.turnOnNoCallback();
        } else {
            this.lZQ.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.lZQ.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.lZQ;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.lZQ.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.lZQ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.mJa != 0) {
            ap.setImageResource(this.mIY, this.mJa);
        }
    }

    public void setSpaceView(int i) {
        if (this.mfL != null) {
            this.mfL.setVisibility(i);
        }
    }
}
