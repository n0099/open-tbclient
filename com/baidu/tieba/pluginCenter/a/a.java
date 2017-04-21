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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TextView aOz;
    private TextView auQ;
    private TbImageView eXT;
    private TextView eXU;
    private ImageView eXV;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eXT = (TbImageView) view.findViewById(w.h.icon);
        this.auQ = (TextView) view.findViewById(w.h.title);
        this.aOz = (TextView) view.findViewById(w.h.desc);
        this.eXU = (TextView) view.findViewById(w.h.status);
        this.eXV = (ImageView) view.findViewById(w.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.eXT.c(pluginConfig.icon, 10, false);
            }
            this.auQ.setText(pluginConfig.display_name);
            this.aOz.setText(pluginConfig.verbose);
            if (PluginPackageManager.jy().bd(pluginConfig.package_name)) {
                if (PluginPackageManager.jy().bf(pluginConfig.package_name)) {
                    this.eXV.setVisibility(0);
                    this.eXU.setText(w.l.download_update);
                    return;
                }
                this.eXV.setVisibility(8);
                if (PluginPackageManager.jy().be(pluginConfig.package_name)) {
                    this.eXU.setText(w.l.plugin_unenabled);
                    return;
                } else {
                    this.eXU.setText(w.l.plugin_enabled);
                    return;
                }
            }
            this.eXV.setVisibility(8);
            this.eXU.setText(w.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        return true;
    }
}
