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
    private TextView bKp;
    private TextView blA;
    private TbImageView guV;
    private TextView guW;
    private ImageView guX;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.guV = (TbImageView) view.findViewById(d.g.icon);
        this.blA = (TextView) view.findViewById(d.g.title);
        this.bKp = (TextView) view.findViewById(d.g.desc);
        this.guW = (TextView) view.findViewById(d.g.status);
        this.guX = (ImageView) view.findViewById(d.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.aI(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.guV.startLoad(pluginConfig.icon, 10, false);
            }
            this.blA.setText(pluginConfig.display_name);
            this.bKp.setText(pluginConfig.verbose);
            if (PluginPackageManager.qR().bv(pluginConfig.package_name)) {
                if (PluginPackageManager.qR().bx(pluginConfig.package_name)) {
                    this.guX.setVisibility(0);
                    this.guW.setText(d.j.download_update);
                    return;
                }
                this.guX.setVisibility(8);
                if (PluginPackageManager.qR().bw(pluginConfig.package_name)) {
                    this.guW.setText(d.j.plugin_unenabled);
                    return;
                } else {
                    this.guW.setText(d.j.plugin_enabled);
                    return;
                }
            }
            this.guX.setVisibility(8);
            this.guW.setText(d.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
