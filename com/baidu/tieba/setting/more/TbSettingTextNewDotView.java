package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void i() {
        if (PluginPackageManager.O().g0()) {
            this.j.setVisibility(0);
            SkinManager.setBackgroundResource(this.j, R.drawable.icon_news_head_new);
            return;
        }
        this.j.setVisibility(4);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }
}
