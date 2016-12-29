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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView Hf;
    private TextView aKd;
    private TextView apY;
    private TextView eKA;
    private ImageView eKB;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Hf = (TbImageView) view.findViewById(r.g.icon);
        this.apY = (TextView) view.findViewById(r.g.title);
        this.aKd = (TextView) view.findViewById(r.g.desc);
        this.eKA = (TextView) view.findViewById(r.g.status);
        this.eKB = (ImageView) view.findViewById(r.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.Hf.c(pluginConfig.icon, 10, false);
            }
            this.apY.setText(pluginConfig.display_name);
            this.aKd.setText(pluginConfig.verbose);
            if (PluginPackageManager.iB().bp(pluginConfig.package_name)) {
                if (PluginPackageManager.iB().br(pluginConfig.package_name)) {
                    this.eKB.setVisibility(0);
                    this.eKA.setText(r.j.plugin_update);
                    return;
                }
                this.eKB.setVisibility(8);
                if (PluginPackageManager.iB().bq(pluginConfig.package_name)) {
                    this.eKA.setText(r.j.plugin_unenabled);
                    return;
                } else {
                    this.eKA.setText(r.j.plugin_enabled);
                    return;
                }
            }
            this.eKB.setVisibility(8);
            this.eKA.setText(r.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
