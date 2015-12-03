package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }

    public void refresh() {
        if (PluginPackageManager.lU().md()) {
            this.anJ.setVisibility(0);
            com.baidu.tbadk.core.util.as.i((View) this.anJ, n.e.icon_news_head_new);
            return;
        }
        this.anJ.setVisibility(4);
    }
}
