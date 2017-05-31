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
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TextView aOR;
    private TextView auE;
    private TbImageView fcO;
    private TextView fcP;
    private ImageView fcQ;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fcO = (TbImageView) view.findViewById(w.h.icon);
        this.auE = (TextView) view.findViewById(w.h.title);
        this.aOR = (TextView) view.findViewById(w.h.desc);
        this.fcP = (TextView) view.findViewById(w.h.status);
        this.fcQ = (ImageView) view.findViewById(w.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fcO.c(pluginConfig.icon, 10, false);
            }
            this.auE.setText(pluginConfig.display_name);
            this.aOR.setText(pluginConfig.verbose);
            if (PluginPackageManager.jx().bd(pluginConfig.package_name)) {
                if (PluginPackageManager.jx().bf(pluginConfig.package_name)) {
                    this.fcQ.setVisibility(0);
                    this.fcP.setText(w.l.download_update);
                    return;
                }
                this.fcQ.setVisibility(8);
                if (PluginPackageManager.jx().be(pluginConfig.package_name)) {
                    this.fcP.setText(w.l.plugin_unenabled);
                    return;
                } else {
                    this.fcP.setText(w.l.plugin_enabled);
                    return;
                }
            }
            this.fcQ.setVisibility(8);
            this.fcP.setText(w.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        return true;
    }
}
