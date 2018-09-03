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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TextView dKF;
    private TbImageView giE;
    private TextView giF;
    private ImageView giG;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.giE = (TbImageView) view.findViewById(f.g.icon);
        this.title = (TextView) view.findViewById(f.g.title);
        this.dKF = (TextView) view.findViewById(f.g.desc);
        this.giF = (TextView) view.findViewById(f.g.status);
        this.giG = (ImageView) view.findViewById(f.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.G(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.giE.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.dKF.setText(pluginConfig.verbose);
            if (PluginPackageManager.lN().bH(pluginConfig.package_name)) {
                if (PluginPackageManager.lN().bJ(pluginConfig.package_name)) {
                    this.giG.setVisibility(0);
                    this.giF.setText(f.j.download_update);
                    return;
                }
                this.giG.setVisibility(8);
                if (PluginPackageManager.lN().bI(pluginConfig.package_name)) {
                    this.giF.setText(f.j.plugin_unenabled);
                    return;
                } else {
                    this.giF.setText(f.j.plugin_enabled);
                    return;
                }
            }
            this.giG.setVisibility(8);
            this.giF.setText(f.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
