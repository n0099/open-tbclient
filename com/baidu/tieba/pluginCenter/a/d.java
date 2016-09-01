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
    private TbImageView He;
    private TextView aKu;
    private TextView eXl;
    private ImageView eXm;
    private TextView title;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.He = (TbImageView) view.findViewById(t.g.icon);
        this.title = (TextView) view.findViewById(t.g.title);
        this.aKu = (TextView) view.findViewById(t.g.desc);
        this.eXl = (TextView) view.findViewById(t.g.status);
        this.eXm = (ImageView) view.findViewById(t.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.He.c(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.aKu.setText(pluginConfig.verbose);
            if (PluginPackageManager.iB().bp(pluginConfig.package_name)) {
                if (PluginPackageManager.iB().br(pluginConfig.package_name)) {
                    this.eXm.setVisibility(0);
                    this.eXl.setText(t.j.plugin_update);
                    return;
                }
                this.eXm.setVisibility(8);
                if (PluginPackageManager.iB().bq(pluginConfig.package_name)) {
                    this.eXl.setText(t.j.plugin_unenabled);
                    return;
                } else {
                    this.eXl.setText(t.j.plugin_enabled);
                    return;
                }
            }
            this.eXm.setVisibility(8);
            this.eXl.setText(t.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        return true;
    }
}
