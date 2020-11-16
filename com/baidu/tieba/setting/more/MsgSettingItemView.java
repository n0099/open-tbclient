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
/* loaded from: classes25.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView mJw;
    private TbImageView mJx;
    private TextView mJy;
    private int mJz;
    private BdSwitchView maj;
    private View mge;

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
        this.mJw = (TextView) findViewById(R.id.setting_text);
        this.mJx = (TbImageView) findViewById(R.id.setting_tip_image);
        this.mJy = (TextView) findViewById(R.id.setting_tip);
        this.maj = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.maj, 10, 10, 10, 10);
        this.mge = findViewById(R.id.space_view);
        this.mge.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.mJz = i;
        ap.setImageResource(this.mJx, this.mJz);
        this.mJx.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.mJx.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mJw.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.mJw.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mJy.setVisibility(0);
        this.mJy.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.mJy.setVisibility(0);
            this.mJy.setText(i);
        }
    }

    public void turnOff() {
        this.maj.turnOff();
    }

    public void turnOn() {
        this.maj.turnOn();
    }

    public void turnOffNoCallback() {
        this.maj.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.maj.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.maj.turnOnNoCallback();
        } else {
            this.maj.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.maj.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.maj;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.maj.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.maj.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        if (this.mJz != 0) {
            ap.setImageResource(this.mJx, this.mJz);
        }
    }

    public void setSpaceView(int i) {
        if (this.mge != null) {
            this.mge.setVisibility(i);
        }
    }
}
