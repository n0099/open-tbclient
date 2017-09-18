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
    private TextView aSn;
    private TextView axa;
    private TbImageView fCw;
    private TextView fCx;
    private ImageView fCy;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fCw = (TbImageView) view.findViewById(d.h.icon);
        this.axa = (TextView) view.findViewById(d.h.title);
        this.aSn = (TextView) view.findViewById(d.h.desc);
        this.fCx = (TextView) view.findViewById(d.h.status);
        this.fCy = (ImageView) view.findViewById(d.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.D(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fCw.c(pluginConfig.icon, 10, false);
            }
            this.axa.setText(pluginConfig.display_name);
            this.aSn.setText(pluginConfig.verbose);
            if (PluginPackageManager.jw().bn(pluginConfig.package_name)) {
                if (PluginPackageManager.jw().bp(pluginConfig.package_name)) {
                    this.fCy.setVisibility(0);
                    this.fCx.setText(d.l.download_update);
                    return;
                }
                this.fCy.setVisibility(8);
                if (PluginPackageManager.jw().bo(pluginConfig.package_name)) {
                    this.fCx.setText(d.l.plugin_unenabled);
                    return;
                } else {
                    this.fCx.setText(d.l.plugin_enabled);
                    return;
                }
            }
            this.fCy.setVisibility(8);
            this.fCx.setText(d.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
