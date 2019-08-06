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
    private TextView iUb;
    private TbImageView iUc;
    private TextView iUd;
    private BdSwitchView iUe;
    private View iUf;
    private int iUg;
    private View mBottomLine;

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
        this.iUb = (TextView) findViewById(R.id.setting_text);
        this.iUc = (TbImageView) findViewById(R.id.setting_tip_image);
        this.iUd = (TextView) findViewById(R.id.setting_tip);
        this.iUe = (BdSwitchView) findViewById(R.id.setting_switch);
        l.b(context, this.iUe, 10, 10, 10, 10);
        this.mBottomLine = findViewById(R.id.bottom_line_ll);
        this.iUf = findViewById(R.id.space_view);
        this.iUf.setVisibility(0);
    }

    public void setTipImageResource(int i) {
        this.iUg = i;
        am.c(this.iUc, this.iUg);
        this.iUc.setVisibility(0);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.iUc.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iUb.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.iUb.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.iUd.setVisibility(0);
        this.iUd.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.iUd.setVisibility(0);
            this.iUd.setText(i);
        }
    }

    public void nn() {
        this.iUe.nn();
    }

    public void nm() {
        this.iUe.nm();
    }

    public void nl() {
        this.iUe.nl();
    }

    public void nk() {
        this.iUe.nk();
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.iUe.nk();
        } else {
            this.iUe.nl();
        }
    }

    public boolean iN() {
        return this.iUe.iN();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.iUe;
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iUe.setOnSwitchStateChangeListener(aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().setNightMode(i == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
        this.iUe.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        am.l(this, R.color.cp_bg_line_d);
        if (this.iUg != 0) {
            am.c(this.iUc, this.iUg);
        }
    }

    public void setSpaceView(int i) {
        if (this.iUf != null) {
            this.iUf.setVisibility(i);
        }
    }
}
