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
    public static String ccj = "has_shown_funtion_intro";
    protected RelativeLayout aBy;
    protected TextView afF;
    protected TextView afG;
    protected boolean afI;
    protected ImageView afJ;
    protected Context mContext;

    public SettingTextVersionView(Context context) {
        super(context);
        this.afI = true;
        this.mContext = context;
        initUI();
    }

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afI = true;
        this.mContext = context;
        initUI();
        d(attributeSet);
    }

    public void initUI() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.setting_text_tip_left_view, this, true);
        this.aBy = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.afF = (TextView) findViewById(com.baidu.tieba.v.text);
        this.afG = (TextView) findViewById(com.baidu.tieba.v.tip);
        this.afJ = (ImageView) findViewById(com.baidu.tieba.v.arrow2);
    }

    public void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.afF.setText(string);
        }
        if (color > -1) {
            this.afF.setTextColor(color);
        }
        if (string2 != null) {
            this.afG.setText(string2);
        }
        if (color2 > -1) {
            this.afG.setTextColor(color2);
        }
        this.afI = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        if (!this.afI) {
            this.afJ.setVisibility(4);
        }
    }

    public void YY() {
        com.baidu.tbadk.core.util.ba.i(this.aBy, com.baidu.tieba.u.setting_item_selector);
        com.baidu.tbadk.core.util.ba.b(this.afF, com.baidu.tieba.s.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ba.b(this.afG, com.baidu.tieba.s.cp_cont_d, 1);
    }

    public void refresh() {
        YY();
        VersionData versionData = TbadkCoreApplication.m411getInst().getVersionData();
        boolean z = versionData != null && versionData.hasNewVer();
        boolean z2 = TbConfig.MAIN_PACKAGE_NAME.equals(TbadkCoreApplication.m411getInst().getApplicationInfo().packageName) ? com.baidu.tbadk.core.sharedPref.b.rB().getBoolean(ccj, false) : true;
        if (z || (!z && !z2)) {
            com.baidu.tbadk.core.util.ba.i((View) this.afG, com.baidu.tieba.u.icon_news_head_new);
            this.afG.setText((CharSequence) null);
            return;
        }
        this.afG.setText(TbConfig.getVersion());
        this.afG.setBackgroundDrawable(null);
    }

    public void hideArrow() {
        this.afJ.setVisibility(8);
    }

    public void setText(String str) {
        this.afF.setText(str);
    }

    public void setText(int i) {
        this.afF.setText(i);
    }

    public void setTip(String str) {
        this.afG.setText(str);
    }

    public CharSequence getTip() {
        return this.afG.getText();
    }

    public void hideTip() {
        if (this.afG != null) {
            this.afG.setVisibility(8);
        }
    }

    public void recycle() {
    }
}
