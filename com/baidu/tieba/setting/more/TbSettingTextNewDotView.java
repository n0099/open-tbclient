package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }

    public void refresh() {
        if (PluginPackageManager.jd().jq()) {
            this.dpc.setVisibility(0);
            am.setBackgroundResource(this.dpc, R.drawable.icon_news_head_new);
            return;
        }
        this.dpc.setVisibility(4);
    }
}
