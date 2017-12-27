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
    private TextView bKh;
    private TextView blr;
    private TbImageView gFM;
    private TextView gFN;
    private ImageView gFO;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gFM = (TbImageView) view.findViewById(d.g.icon);
        this.blr = (TextView) view.findViewById(d.g.title);
        this.bKh = (TextView) view.findViewById(d.g.desc);
        this.gFN = (TextView) view.findViewById(d.g.status);
        this.gFO = (ImageView) view.findViewById(d.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.aI(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.gFM.startLoad(pluginConfig.icon, 10, false);
            }
            this.blr.setText(pluginConfig.display_name);
            this.bKh.setText(pluginConfig.verbose);
            if (PluginPackageManager.qR().bv(pluginConfig.package_name)) {
                if (PluginPackageManager.qR().bx(pluginConfig.package_name)) {
                    this.gFO.setVisibility(0);
                    this.gFN.setText(d.j.download_update);
                    return;
                }
                this.gFO.setVisibility(8);
                if (PluginPackageManager.qR().bw(pluginConfig.package_name)) {
                    this.gFN.setText(d.j.plugin_unenabled);
                    return;
                } else {
                    this.gFN.setText(d.j.plugin_enabled);
                    return;
                }
            }
            this.gFO.setVisibility(8);
            this.gFN.setText(d.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
