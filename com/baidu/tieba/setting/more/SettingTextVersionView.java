package com.baidu.tieba.setting.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
public class SettingTextVersionView extends FrameLayout {
    public static String cbU = "has_shown_funtion_intro";
    protected RelativeLayout aBq;
    protected boolean afA;
    protected ImageView afB;
    protected TextView afx;
    protected TextView afy;
    protected Context mContext;

    public SettingTextVersionView(Context context) {
        super(context);
        this.afA = true;
        this.mContext = context;
        initUI();
    }

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afA = true;
        this.mContext = context;
        initUI();
        d(attributeSet);
    }

    public void initUI() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.setting_text_tip_left_view, this, true);
        this.aBq = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.afx = (TextView) findViewById(com.baidu.tieba.v.text);
        this.afy = (TextView) findViewById(com.baidu.tieba.v.tip);
        this.afB = (ImageView) findViewById(com.baidu.tieba.v.arrow2);
    }

    public void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.afx.setText(string);
        }
        if (color > -1) {
            this.afx.setTextColor(color);
        }
        if (string2 != null) {
            this.afy.setText(string2);
        }
        if (color2 > -1) {
            this.afy.setTextColor(color2);
        }
        this.afA = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        if (!this.afA) {
            this.afB.setVisibility(4);
        }
    }

    public void YM() {
        com.baidu.tbadk.core.util.ba.i(this.aBq, com.baidu.tieba.u.setting_item_selector);
        com.baidu.tbadk.core.util.ba.b(this.afx, com.baidu.tieba.s.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ba.b(this.afy, com.baidu.tieba.s.cp_cont_d, 1);
    }

    public void refresh() {
        YM();
        VersionData versionData = TbadkCoreApplication.m411getInst().getVersionData();
        boolean z = versionData != null && versionData.hasNewVer();
        boolean z2 = TbConfig.MAIN_PACKAGE_NAME.equals(TbadkCoreApplication.m411getInst().getApplicationInfo().packageName) ? com.baidu.tbadk.core.sharedPref.b.rB().getBoolean(cbU, false) : true;
        if (z || (!z && !z2)) {
            com.baidu.tbadk.core.util.ba.i((View) this.afy, com.baidu.tieba.u.icon_news_head_new);
            this.afy.setText((CharSequence) null);
            return;
        }
        this.afy.setText(TbConfig.getVersion());
        this.afy.setBackgroundDrawable(null);
    }

    public void hideArrow() {
        this.afB.setVisibility(8);
    }

    public void setText(String str) {
        this.afx.setText(str);
    }

    public void setText(int i) {
        this.afx.setText(i);
    }

    public void setTip(String str) {
        this.afy.setText(str);
    }

    public CharSequence getTip() {
        return this.afy.getText();
    }

    public void hideTip() {
        if (this.afy != null) {
            this.afy.setVisibility(8);
        }
    }

    public void recycle() {
    }
}
