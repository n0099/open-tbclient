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
    private TextView dvm;
    private TbImageView fSP;
    private TextView fSQ;
    private ImageView fSR;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        this.fSP = (TbImageView) view2.findViewById(d.g.icon);
        this.title = (TextView) view2.findViewById(d.g.title);
        this.dvm = (TextView) view2.findViewById(d.g.desc);
        this.fSQ = (TextView) view2.findViewById(d.g.status);
        this.fSR = (ImageView) view2.findViewById(d.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.D(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fSP.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.dvm.setText(pluginConfig.verbose);
            if (PluginPackageManager.iX().bs(pluginConfig.package_name)) {
                if (PluginPackageManager.iX().bu(pluginConfig.package_name)) {
                    this.fSR.setVisibility(0);
                    this.fSQ.setText(d.k.download_update);
                    return;
                }
                this.fSR.setVisibility(8);
                if (PluginPackageManager.iX().bt(pluginConfig.package_name)) {
                    this.fSQ.setText(d.k.plugin_unenabled);
                    return;
                } else {
                    this.fSQ.setText(d.k.plugin_enabled);
                    return;
                }
            }
            this.fSR.setVisibility(8);
            this.fSQ.setText(d.k.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
