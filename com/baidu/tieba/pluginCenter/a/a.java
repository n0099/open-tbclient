package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TextView aRs;
    private TextView awz;
    private TbImageView fzT;
    private TextView fzU;
    private ImageView fzV;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fzT = (TbImageView) view.findViewById(d.h.icon);
        this.awz = (TextView) view.findViewById(d.h.title);
        this.aRs = (TextView) view.findViewById(d.h.desc);
        this.fzU = (TextView) view.findViewById(d.h.status);
        this.fzV = (ImageView) view.findViewById(d.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fzT.c(pluginConfig.icon, 10, false);
            }
            this.awz.setText(pluginConfig.display_name);
            this.aRs.setText(pluginConfig.verbose);
            if (PluginPackageManager.ju().bk(pluginConfig.package_name)) {
                if (PluginPackageManager.ju().bm(pluginConfig.package_name)) {
                    this.fzV.setVisibility(0);
                    this.fzU.setText(d.l.download_update);
                    return;
                }
                this.fzV.setVisibility(8);
                if (PluginPackageManager.ju().bl(pluginConfig.package_name)) {
                    this.fzU.setText(d.l.plugin_unenabled);
                    return;
                } else {
                    this.fzU.setText(d.l.plugin_enabled);
                    return;
                }
            }
            this.fzV.setVisibility(8);
            this.fzU.setText(d.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
