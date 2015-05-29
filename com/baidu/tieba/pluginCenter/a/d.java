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
import com.baidu.tieba.q;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.j.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.e.c> {
    private TbImageView Ms;
    private TextView aEo;
    private TextView aiA;
    private TextView bXK;
    private ImageView bXL;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Ms = (TbImageView) view.findViewById(q.icon);
        this.aiA = (TextView) view.findViewById(q.title);
        this.aEo = (TextView) view.findViewById(q.desc);
        this.bXK = (TextView) view.findViewById(q.status);
        this.bXL = (ImageView) view.findViewById(q.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void z(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.z(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.Ms.c(pluginConfig.icon, 10, false);
            }
            this.aiA.setText(pluginConfig.display_name);
            this.aEo.setText(pluginConfig.verbose);
            if (PluginPackageManager.lM().bw(pluginConfig.package_name)) {
                if (PluginPackageManager.lM().by(pluginConfig.package_name)) {
                    this.bXL.setVisibility(0);
                    this.bXK.setText(t.plugin_update);
                    return;
                }
                this.bXL.setVisibility(8);
                if (PluginPackageManager.lM().bx(pluginConfig.package_name)) {
                    this.bXK.setText(t.plugin_unenabled);
                    return;
                } else {
                    this.bXK.setText(t.plugin_enabled);
                    return;
                }
            }
            this.bXL.setVisibility(8);
            this.bXK.setText(t.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
