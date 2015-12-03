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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView MW;
    private TextView aEp;
    private TextView agd;
    private TextView ddZ;
    private ImageView dea;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.MW = (TbImageView) view.findViewById(n.f.icon);
        this.agd = (TextView) view.findViewById(n.f.title);
        this.aEp = (TextView) view.findViewById(n.f.desc);
        this.ddZ = (TextView) view.findViewById(n.f.status);
        this.dea = (ImageView) view.findViewById(n.f.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.B(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.MW.d(pluginConfig.icon, 10, false);
            }
            this.agd.setText(pluginConfig.display_name);
            this.aEp.setText(pluginConfig.verbose);
            if (PluginPackageManager.lU().bt(pluginConfig.package_name)) {
                if (PluginPackageManager.lU().bv(pluginConfig.package_name)) {
                    this.dea.setVisibility(0);
                    this.ddZ.setText(n.i.plugin_update);
                    return;
                }
                this.dea.setVisibility(8);
                if (PluginPackageManager.lU().bu(pluginConfig.package_name)) {
                    this.ddZ.setText(n.i.plugin_unenabled);
                    return;
                } else {
                    this.ddZ.setText(n.i.plugin_enabled);
                    return;
                }
            }
            this.dea.setVisibility(8);
            this.ddZ.setText(n.i.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
