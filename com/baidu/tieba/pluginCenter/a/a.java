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
    private TextView aQj;
    private TextView avH;
    private TbImageView fne;
    private TextView fnf;
    private ImageView fng;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fne = (TbImageView) view.findViewById(w.h.icon);
        this.avH = (TextView) view.findViewById(w.h.title);
        this.aQj = (TextView) view.findViewById(w.h.desc);
        this.fnf = (TextView) view.findViewById(w.h.status);
        this.fng = (ImageView) view.findViewById(w.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fne.c(pluginConfig.icon, 10, false);
            }
            this.avH.setText(pluginConfig.display_name);
            this.aQj.setText(pluginConfig.verbose);
            if (PluginPackageManager.jw().bi(pluginConfig.package_name)) {
                if (PluginPackageManager.jw().bk(pluginConfig.package_name)) {
                    this.fng.setVisibility(0);
                    this.fnf.setText(w.l.download_update);
                    return;
                }
                this.fng.setVisibility(8);
                if (PluginPackageManager.jw().bj(pluginConfig.package_name)) {
                    this.fnf.setText(w.l.plugin_unenabled);
                    return;
                } else {
                    this.fnf.setText(w.l.plugin_enabled);
                    return;
                }
            }
            this.fng.setVisibility(8);
            this.fnf.setText(w.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        return true;
    }
}
