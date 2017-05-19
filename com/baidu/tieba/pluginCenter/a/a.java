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
    private TextView aOS;
    private TextView auU;
    private TbImageView eTT;
    private TextView eTU;
    private ImageView eTV;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eTT = (TbImageView) view.findViewById(w.h.icon);
        this.auU = (TextView) view.findViewById(w.h.title);
        this.aOS = (TextView) view.findViewById(w.h.desc);
        this.eTU = (TextView) view.findViewById(w.h.status);
        this.eTV = (ImageView) view.findViewById(w.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.eTT.c(pluginConfig.icon, 10, false);
            }
            this.auU.setText(pluginConfig.display_name);
            this.aOS.setText(pluginConfig.verbose);
            if (PluginPackageManager.jx().bd(pluginConfig.package_name)) {
                if (PluginPackageManager.jx().bf(pluginConfig.package_name)) {
                    this.eTV.setVisibility(0);
                    this.eTU.setText(w.l.download_update);
                    return;
                }
                this.eTV.setVisibility(8);
                if (PluginPackageManager.jx().be(pluginConfig.package_name)) {
                    this.eTU.setText(w.l.plugin_unenabled);
                    return;
                } else {
                    this.eTU.setText(w.l.plugin_enabled);
                    return;
                }
            }
            this.eTV.setVisibility(8);
            this.eTU.setText(w.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        return true;
    }
}
