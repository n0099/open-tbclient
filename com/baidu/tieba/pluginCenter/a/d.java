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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView El;
    private TextView aFL;
    private TextView dUW;
    private ImageView dUX;
    private TextView title;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.El = (TbImageView) view.findViewById(t.g.icon);
        this.title = (TextView) view.findViewById(t.g.title);
        this.aFL = (TextView) view.findViewById(t.g.desc);
        this.dUW = (TextView) view.findViewById(t.g.status);
        this.dUX = (ImageView) view.findViewById(t.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.B(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.El.c(pluginConfig.icon, 10, false);
            }
            this.title.setText(pluginConfig.display_name);
            this.aFL.setText(pluginConfig.verbose);
            if (PluginPackageManager.hF().bn(pluginConfig.package_name)) {
                if (PluginPackageManager.hF().bp(pluginConfig.package_name)) {
                    this.dUX.setVisibility(0);
                    this.dUW.setText(t.j.plugin_update);
                    return;
                }
                this.dUX.setVisibility(8);
                if (PluginPackageManager.hF().bo(pluginConfig.package_name)) {
                    this.dUW.setText(t.j.plugin_unenabled);
                    return;
                } else {
                    this.dUW.setText(t.j.plugin_enabled);
                    return;
                }
            }
            this.dUX.setVisibility(8);
            this.dUW.setText(t.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
