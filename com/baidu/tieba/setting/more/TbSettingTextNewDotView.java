package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }

    public void refresh() {
        if (PluginPackageManager.pO().qb()) {
            this.eHw.setVisibility(0);
            ap.setBackgroundResource(this.eHw, R.drawable.icon_news_head_new);
            return;
        }
        this.eHw.setVisibility(4);
    }
}
