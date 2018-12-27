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
    private TextView ekx;
    private TbImageView gIG;
    private TextView gIH;
    private ImageView gII;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gIG = (TbImageView) view.findViewById(e.g.icon);
        this.title = (TextView) view.findViewById(e.g.title);
        this.ekx = (TextView) view.findViewById(e.g.desc);
        this.gIH = (TextView) view.findViewById(e.g.status);
        this.gII = (ImageView) view.findViewById(e.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.L(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.gIG.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.ekx.setText(pluginConfig.verbose);
            if (PluginPackageManager.na().bX(pluginConfig.package_name)) {
                if (PluginPackageManager.na().bZ(pluginConfig.package_name)) {
                    this.gII.setVisibility(0);
                    this.gIH.setText(e.j.download_update);
                    return;
                }
                this.gII.setVisibility(8);
                if (PluginPackageManager.na().bY(pluginConfig.package_name)) {
                    this.gIH.setText(e.j.plugin_unenabled);
                    return;
                } else {
                    this.gIH.setText(e.j.plugin_enabled);
                    return;
                }
            }
            this.gII.setVisibility(8);
            this.gIH.setText(e.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
