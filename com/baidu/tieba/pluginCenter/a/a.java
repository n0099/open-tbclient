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
    private TextView aWs;
    private TextView axm;
    private TbImageView fSc;
    private TextView fSd;
    private ImageView fSe;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fSc = (TbImageView) view.findViewById(d.g.icon);
        this.axm = (TextView) view.findViewById(d.g.title);
        this.aWs = (TextView) view.findViewById(d.g.desc);
        this.fSd = (TextView) view.findViewById(d.g.status);
        this.fSe = (ImageView) view.findViewById(d.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.D(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fSc.startLoad(pluginConfig.icon, 10, false);
            }
            this.axm.setText(pluginConfig.display_name);
            this.aWs.setText(pluginConfig.verbose);
            if (PluginPackageManager.js().bn(pluginConfig.package_name)) {
                if (PluginPackageManager.js().bp(pluginConfig.package_name)) {
                    this.fSe.setVisibility(0);
                    this.fSd.setText(d.j.download_update);
                    return;
                }
                this.fSe.setVisibility(8);
                if (PluginPackageManager.js().bo(pluginConfig.package_name)) {
                    this.fSd.setText(d.j.plugin_unenabled);
                    return;
                } else {
                    this.fSd.setText(d.j.plugin_enabled);
                    return;
                }
            }
            this.fSe.setVisibility(8);
            this.fSd.setText(d.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
