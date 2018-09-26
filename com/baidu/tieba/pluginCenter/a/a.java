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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TextView dRP;
    private TbImageView gpW;
    private TextView gpX;
    private ImageView gpY;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gpW = (TbImageView) view.findViewById(e.g.icon);
        this.title = (TextView) view.findViewById(e.g.title);
        this.dRP = (TextView) view.findViewById(e.g.desc);
        this.gpX = (TextView) view.findViewById(e.g.status);
        this.gpY = (ImageView) view.findViewById(e.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void H(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.H(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.gpW.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.dRP.setText(pluginConfig.verbose);
            if (PluginPackageManager.mT().bY(pluginConfig.package_name)) {
                if (PluginPackageManager.mT().ca(pluginConfig.package_name)) {
                    this.gpY.setVisibility(0);
                    this.gpX.setText(e.j.download_update);
                    return;
                }
                this.gpY.setVisibility(8);
                if (PluginPackageManager.mT().bZ(pluginConfig.package_name)) {
                    this.gpX.setText(e.j.plugin_unenabled);
                    return;
                } else {
                    this.gpX.setText(e.j.plugin_enabled);
                    return;
                }
            }
            this.gpY.setVisibility(8);
            this.gpX.setText(e.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
