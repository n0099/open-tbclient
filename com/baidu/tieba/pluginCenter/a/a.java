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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView Hg;
    private TextView aKM;
    private TextView fhh;
    private ImageView fhi;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Hg = (TbImageView) view.findViewById(r.g.icon);
        this.title = (TextView) view.findViewById(r.g.title);
        this.aKM = (TextView) view.findViewById(r.g.desc);
        this.fhh = (TextView) view.findViewById(r.g.status);
        this.fhi = (ImageView) view.findViewById(r.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.Hg.c(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.aKM.setText(pluginConfig.verbose);
            if (PluginPackageManager.iB().bp(pluginConfig.package_name)) {
                if (PluginPackageManager.iB().br(pluginConfig.package_name)) {
                    this.fhi.setVisibility(0);
                    this.fhh.setText(r.j.plugin_update);
                    return;
                }
                this.fhi.setVisibility(8);
                if (PluginPackageManager.iB().bq(pluginConfig.package_name)) {
                    this.fhh.setText(r.j.plugin_unenabled);
                    return;
                } else {
                    this.fhh.setText(r.j.plugin_enabled);
                    return;
                }
            }
            this.fhi.setVisibility(8);
            this.fhh.setText(r.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
