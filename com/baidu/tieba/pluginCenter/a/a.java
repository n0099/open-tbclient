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
    private TextView bMB;
    private TbImageView gwV;
    private TextView gwW;
    private ImageView gwX;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gwV = (TbImageView) view.findViewById(d.g.icon);
        this.title = (TextView) view.findViewById(d.g.title);
        this.bMB = (TextView) view.findViewById(d.g.desc);
        this.gwW = (TextView) view.findViewById(d.g.status);
        this.gwX = (ImageView) view.findViewById(d.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.aI(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.gwV.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.bMB.setText(pluginConfig.verbose);
            if (PluginPackageManager.qS().bv(pluginConfig.package_name)) {
                if (PluginPackageManager.qS().bx(pluginConfig.package_name)) {
                    this.gwX.setVisibility(0);
                    this.gwW.setText(d.j.download_update);
                    return;
                }
                this.gwX.setVisibility(8);
                if (PluginPackageManager.qS().bw(pluginConfig.package_name)) {
                    this.gwW.setText(d.j.plugin_unenabled);
                    return;
                } else {
                    this.gwW.setText(d.j.plugin_enabled);
                    return;
                }
            }
            this.gwX.setVisibility(8);
            this.gwW.setText(d.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
