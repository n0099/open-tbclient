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
    private TextView dEz;
    private TbImageView gec;
    private TextView ged;
    private ImageView gee;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gec = (TbImageView) view.findViewById(d.g.icon);
        this.title = (TextView) view.findViewById(d.g.title);
        this.dEz = (TextView) view.findViewById(d.g.desc);
        this.ged = (TextView) view.findViewById(d.g.status);
        this.gee = (ImageView) view.findViewById(d.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.G(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.gec.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.dEz.setText(pluginConfig.verbose);
            if (PluginPackageManager.lL().bE(pluginConfig.package_name)) {
                if (PluginPackageManager.lL().bG(pluginConfig.package_name)) {
                    this.gee.setVisibility(0);
                    this.ged.setText(d.k.download_update);
                    return;
                }
                this.gee.setVisibility(8);
                if (PluginPackageManager.lL().bF(pluginConfig.package_name)) {
                    this.ged.setText(d.k.plugin_unenabled);
                    return;
                } else {
                    this.ged.setText(d.k.plugin_enabled);
                    return;
                }
            }
            this.gee.setVisibility(8);
            this.ged.setText(d.k.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
