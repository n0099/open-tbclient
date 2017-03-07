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
    private TextView aOh;
    private TextView auy;
    private TbImageView eXD;
    private TextView eXE;
    private ImageView eXF;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eXD = (TbImageView) view.findViewById(w.h.icon);
        this.auy = (TextView) view.findViewById(w.h.title);
        this.aOh = (TextView) view.findViewById(w.h.desc);
        this.eXE = (TextView) view.findViewById(w.h.status);
        this.eXF = (ImageView) view.findViewById(w.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.eXD.c(pluginConfig.icon, 10, false);
            }
            this.auy.setText(pluginConfig.display_name);
            this.aOh.setText(pluginConfig.verbose);
            if (PluginPackageManager.jt().bi(pluginConfig.package_name)) {
                if (PluginPackageManager.jt().bk(pluginConfig.package_name)) {
                    this.eXF.setVisibility(0);
                    this.eXE.setText(w.l.download_update);
                    return;
                }
                this.eXF.setVisibility(8);
                if (PluginPackageManager.jt().bj(pluginConfig.package_name)) {
                    this.eXE.setText(w.l.plugin_unenabled);
                    return;
                } else {
                    this.eXE.setText(w.l.plugin_enabled);
                    return;
                }
            }
            this.eXF.setVisibility(8);
            this.eXE.setText(w.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
