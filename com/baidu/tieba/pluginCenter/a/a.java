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
    private TextView aTd;
    private TextView awv;
    private TbImageView fHr;
    private TextView fHs;
    private ImageView fHt;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fHr = (TbImageView) view.findViewById(d.g.icon);
        this.awv = (TextView) view.findViewById(d.g.title);
        this.aTd = (TextView) view.findViewById(d.g.desc);
        this.fHs = (TextView) view.findViewById(d.g.status);
        this.fHt = (ImageView) view.findViewById(d.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.D(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fHr.startLoad(pluginConfig.icon, 10, false);
            }
            this.awv.setText(pluginConfig.display_name);
            this.aTd.setText(pluginConfig.verbose);
            if (PluginPackageManager.js().bn(pluginConfig.package_name)) {
                if (PluginPackageManager.js().bp(pluginConfig.package_name)) {
                    this.fHt.setVisibility(0);
                    this.fHs.setText(d.j.download_update);
                    return;
                }
                this.fHt.setVisibility(8);
                if (PluginPackageManager.js().bo(pluginConfig.package_name)) {
                    this.fHs.setText(d.j.plugin_unenabled);
                    return;
                } else {
                    this.fHs.setText(d.j.plugin_enabled);
                    return;
                }
            }
            this.fHt.setVisibility(8);
            this.fHs.setText(d.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
