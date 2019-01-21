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
    private TextView ele;
    private TbImageView gJL;
    private TextView gJM;
    private ImageView gJN;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gJL = (TbImageView) view.findViewById(e.g.icon);
        this.title = (TextView) view.findViewById(e.g.title);
        this.ele = (TextView) view.findViewById(e.g.desc);
        this.gJM = (TextView) view.findViewById(e.g.status);
        this.gJN = (ImageView) view.findViewById(e.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.L(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.gJL.startLoad(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.ele.setText(pluginConfig.verbose);
            if (PluginPackageManager.nd().bY(pluginConfig.package_name)) {
                if (PluginPackageManager.nd().ca(pluginConfig.package_name)) {
                    this.gJN.setVisibility(0);
                    this.gJM.setText(e.j.download_update);
                    return;
                }
                this.gJN.setVisibility(8);
                if (PluginPackageManager.nd().bZ(pluginConfig.package_name)) {
                    this.gJM.setText(e.j.plugin_unenabled);
                    return;
                } else {
                    this.gJM.setText(e.j.plugin_enabled);
                    return;
                }
            }
            this.gJN.setVisibility(8);
            this.gJM.setText(e.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
