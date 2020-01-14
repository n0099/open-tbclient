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
/* loaded from: classes11.dex */
public class MsgSettingItemView extends LinearLayout {
    private TextView jTw;
    private TbImageView jTx;
    private TextView jTy;
    private int jTz;
    private BdSwitchView jkt;
    private View jpS;

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
        this.jTw = (TextView) findViewById(R.id.setting_text);
        this.jTx = (TbImageView) findViewById(R.id.setting_tip_image);
        this.jTy = (TextView) findViewById(R.id.setting_tip);
        this.jkt = (BdSwitchView) findViewById(R.id.setting_switch);
        l.addToParentArea(context, this.jkt, 10, 10, 10, 10);
        this.jpS = findViewById(R.id.space_view);
        this.jpS.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.jTz = i;
        am.setImageResource(this.jTx, this.jTz);
        this.jTx.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.jTx.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jTw.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.jTw.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.jTy.setVisibility(0);
        this.jTy.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.jTy.setVisibility(0);
            this.jTy.setText(i);
        }
    }

    public void turnOff() {
        this.jkt.turnOff();
    }

    public void turnOn() {
        this.jkt.turnOn();
    }

    public void turnOffNoCallback() {
        this.jkt.turnOffNoCallback();
    }

    public void turnOnNoCallback() {
        this.jkt.turnOnNoCallback();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.jkt.turnOnNoCallback();
        } else {
            this.jkt.turnOffNoCallback();
        }
    }

    public boolean isOn() {
        return this.jkt.isOn();
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public BdSwitchView getSwitchView() {
        return this.jkt;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jkt.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.jkt.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        if (this.jTz != 0) {
            am.setImageResource(this.jTx, this.jTz);
        }
    }

    public void setSpaceView(int i) {
        if (this.jpS != null) {
            this.jpS.setVisibility(i);
        }
    }
}
