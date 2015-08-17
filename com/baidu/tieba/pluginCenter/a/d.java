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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView MF;
    private TextView aLO;
    private TextView anH;
    private TextView coE;
    private ImageView coF;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.MF = (TbImageView) view.findViewById(i.f.icon);
        this.anH = (TextView) view.findViewById(i.f.title);
        this.aLO = (TextView) view.findViewById(i.f.desc);
        this.coE = (TextView) view.findViewById(i.f.status);
        this.coF = (ImageView) view.findViewById(i.f.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void A(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.A(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.MF.d(pluginConfig.icon, 10, false);
            }
            this.anH.setText(pluginConfig.display_name);
            this.aLO.setText(pluginConfig.verbose);
            if (PluginPackageManager.lT().bq(pluginConfig.package_name)) {
                if (PluginPackageManager.lT().bs(pluginConfig.package_name)) {
                    this.coF.setVisibility(0);
                    this.coE.setText(i.C0057i.plugin_update);
                    return;
                }
                this.coF.setVisibility(8);
                if (PluginPackageManager.lT().br(pluginConfig.package_name)) {
                    this.coE.setText(i.C0057i.plugin_unenabled);
                    return;
                } else {
                    this.coE.setText(i.C0057i.plugin_enabled);
                    return;
                }
            }
            this.coF.setVisibility(8);
            this.coE.setText(i.C0057i.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
