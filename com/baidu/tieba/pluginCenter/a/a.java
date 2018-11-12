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
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TextView ebd;
    private TbImageView gyZ;
    private TextView gza;
    private ImageView gzb;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gyZ = (TbImageView) view.findViewById(e.g.icon);
        this.title = (TextView) view.findViewById(e.g.title);
        this.ebd = (TextView) view.findViewById(e.g.desc);
        this.gza = (TextView) view.findViewById(e.g.status);
        this.gzb = (ImageView) view.findViewById(e.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.L(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.gyZ.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.ebd.setText(pluginConfig.verbose);
            if (PluginPackageManager.nb().bX(pluginConfig.package_name)) {
                if (PluginPackageManager.nb().bZ(pluginConfig.package_name)) {
                    this.gzb.setVisibility(0);
                    this.gza.setText(e.j.download_update);
                    return;
                }
                this.gzb.setVisibility(8);
                if (PluginPackageManager.nb().bY(pluginConfig.package_name)) {
                    this.gza.setText(e.j.plugin_unenabled);
                    return;
                } else {
                    this.gza.setText(e.j.plugin_enabled);
                    return;
                }
            }
            this.gzb.setVisibility(8);
            this.gza.setText(e.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
