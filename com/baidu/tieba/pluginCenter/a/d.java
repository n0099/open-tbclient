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
    private TbImageView Er;
    private TextView aGn;
    private TextView eEr;
    private ImageView eEs;
    private TextView title;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Er = (TbImageView) view.findViewById(u.g.icon);
        this.title = (TextView) view.findViewById(u.g.title);
        this.aGn = (TextView) view.findViewById(u.g.desc);
        this.eEr = (TextView) view.findViewById(u.g.status);
        this.eEs = (ImageView) view.findViewById(u.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.B(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.Er.c(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.aGn.setText(pluginConfig.verbose);
            if (PluginPackageManager.hH().bn(pluginConfig.package_name)) {
                if (PluginPackageManager.hH().bp(pluginConfig.package_name)) {
                    this.eEs.setVisibility(0);
                    this.eEr.setText(u.j.plugin_update);
                    return;
                }
                this.eEs.setVisibility(8);
                if (PluginPackageManager.hH().bo(pluginConfig.package_name)) {
                    this.eEr.setText(u.j.plugin_unenabled);
                    return;
                } else {
                    this.eEr.setText(u.j.plugin_enabled);
                    return;
                }
            }
            this.eEs.setVisibility(8);
            this.eEr.setText(u.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        return true;
    }
}
