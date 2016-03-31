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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView NV;
    private TextView aJE;
    private TextView apE;
    private TextView dSe;
    private ImageView dSf;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.NV = (TbImageView) view.findViewById(t.g.icon);
        this.apE = (TextView) view.findViewById(t.g.title);
        this.aJE = (TextView) view.findViewById(t.g.desc);
        this.dSe = (TextView) view.findViewById(t.g.status);
        this.dSf = (ImageView) view.findViewById(t.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.B(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.NV.c(pluginConfig.icon, 10, false);
            }
            this.apE.setText(pluginConfig.display_name);
            this.aJE.setText(pluginConfig.verbose);
            if (PluginPackageManager.ls().bu(pluginConfig.package_name)) {
                if (PluginPackageManager.ls().bw(pluginConfig.package_name)) {
                    this.dSf.setVisibility(0);
                    this.dSe.setText(t.j.plugin_update);
                    return;
                }
                this.dSf.setVisibility(8);
                if (PluginPackageManager.ls().bv(pluginConfig.package_name)) {
                    this.dSe.setText(t.j.plugin_unenabled);
                    return;
                } else {
                    this.dSe.setText(t.j.plugin_enabled);
                    return;
                }
            }
            this.dSf.setVisibility(8);
            this.dSe.setText(t.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
