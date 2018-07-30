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
    private TextView dKJ;
    private TbImageView giF;
    private TextView giG;
    private ImageView giH;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.giF = (TbImageView) view.findViewById(d.g.icon);
        this.title = (TextView) view.findViewById(d.g.title);
        this.dKJ = (TextView) view.findViewById(d.g.desc);
        this.giG = (TextView) view.findViewById(d.g.status);
        this.giH = (ImageView) view.findViewById(d.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.G(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.giF.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.dKJ.setText(pluginConfig.verbose);
            if (PluginPackageManager.lN().bH(pluginConfig.package_name)) {
                if (PluginPackageManager.lN().bJ(pluginConfig.package_name)) {
                    this.giH.setVisibility(0);
                    this.giG.setText(d.j.download_update);
                    return;
                }
                this.giH.setVisibility(8);
                if (PluginPackageManager.lN().bI(pluginConfig.package_name)) {
                    this.giG.setText(d.j.plugin_unenabled);
                    return;
                } else {
                    this.giG.setText(d.j.plugin_enabled);
                    return;
                }
            }
            this.giH.setVisibility(8);
            this.giG.setText(d.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
