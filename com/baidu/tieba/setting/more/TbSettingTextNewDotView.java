package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }

    public void refresh() {
        if (PluginPackageManager.ls().lG()) {
            this.aqt.setVisibility(0);
            com.baidu.tbadk.core.util.at.k(this.aqt, t.f.icon_news_head_new);
            return;
        }
        this.aqt.setVisibility(4);
    }
}
