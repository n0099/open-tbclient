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
/* loaded from: classes7.dex */
public class MsgSettingItemView extends LinearLayout {
    private BdSwitchView mAq;
    private View mGq;
    private TextView nkB;
    private TbImageView nkC;
    private TextView nkD;
    private int nkE;

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
        this.nkB = (TextView) findViewById(R.id.setting_text);
        this.nkC = (TbImageView) findViewById(R.id.setting_tip_image);
        this.nkD = (TextView) findViewById(R.id.setting_tip);
        this.mAq = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.mAq, 10, 10, 10, 10);
        this.mGq = findViewById(R.id.space_view);
        this.mGq.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.nkE = i;
        ap.setImageResource(this.nkC, this.nkE);
        this.nkC.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.nkC.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.nkB.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.nkB.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.nkD.setVisibility(0);
        this.nkD.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.nkD.setVisibility(0);
            this.nkD.setText(i);
        }
    }

    public void turnOff() {
        this.mAq.turnOff();
    }

    public void turnOn() {
        this.mAq.turnOn();
    }

    public void turnOffNoCallback() {
        this.mAq.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.mAq.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.mAq.turnOnNoCallback();
        } else {
            this.mAq.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.mAq.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.mAq;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mAq.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.mAq.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.nkE != 0) {
            ap.setImageResource(this.nkC, this.nkE);
        }
    }

    public void setSpaceView(int i) {
        if (this.mGq != null) {
            this.mGq.setVisibility(i);
        }
    }
}
