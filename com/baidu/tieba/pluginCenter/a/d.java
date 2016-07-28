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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView ER;
    private TextView aHe;
    private TextView eQa;
    private ImageView eQb;
    private TextView title;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ER = (TbImageView) view.findViewById(u.g.icon);
        this.title = (TextView) view.findViewById(u.g.title);
        this.aHe = (TextView) view.findViewById(u.g.desc);
        this.eQa = (TextView) view.findViewById(u.g.status);
        this.eQb = (ImageView) view.findViewById(u.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.ER.c(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.aHe.setText(pluginConfig.verbose);
            if (PluginPackageManager.hG().bo(pluginConfig.package_name)) {
                if (PluginPackageManager.hG().bq(pluginConfig.package_name)) {
                    this.eQb.setVisibility(0);
                    this.eQa.setText(u.j.plugin_update);
                    return;
                }
                this.eQb.setVisibility(8);
                if (PluginPackageManager.hG().bp(pluginConfig.package_name)) {
                    this.eQa.setText(u.j.plugin_unenabled);
                    return;
                } else {
                    this.eQa.setText(u.j.plugin_enabled);
                    return;
                }
            }
            this.eQb.setVisibility(8);
            this.eQa.setText(u.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        return true;
    }
}
