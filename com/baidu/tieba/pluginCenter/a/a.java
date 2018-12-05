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
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TextView ehG;
    private TbImageView gFP;
    private TextView gFQ;
    private ImageView gFR;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gFP = (TbImageView) view.findViewById(e.g.icon);
        this.title = (TextView) view.findViewById(e.g.title);
        this.ehG = (TextView) view.findViewById(e.g.desc);
        this.gFQ = (TextView) view.findViewById(e.g.status);
        this.gFR = (ImageView) view.findViewById(e.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.L(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.gFP.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.ehG.setText(pluginConfig.verbose);
            if (PluginPackageManager.na().bX(pluginConfig.package_name)) {
                if (PluginPackageManager.na().bZ(pluginConfig.package_name)) {
                    this.gFR.setVisibility(0);
                    this.gFQ.setText(e.j.download_update);
                    return;
                }
                this.gFR.setVisibility(8);
                if (PluginPackageManager.na().bY(pluginConfig.package_name)) {
                    this.gFQ.setText(e.j.plugin_unenabled);
                    return;
                } else {
                    this.gFQ.setText(e.j.plugin_enabled);
                    return;
                }
            }
            this.gFR.setVisibility(8);
            this.gFQ.setText(e.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
