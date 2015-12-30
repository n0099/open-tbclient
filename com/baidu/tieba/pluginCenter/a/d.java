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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView Nm;
    private TextView aFP;
    private TextView ahk;
    private TextView djE;
    private ImageView djF;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Nm = (TbImageView) view.findViewById(n.g.icon);
        this.ahk = (TextView) view.findViewById(n.g.title);
        this.aFP = (TextView) view.findViewById(n.g.desc);
        this.djE = (TextView) view.findViewById(n.g.status);
        this.djF = (ImageView) view.findViewById(n.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.B(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.Nm.d(pluginConfig.icon, 10, false);
            }
            this.ahk.setText(pluginConfig.display_name);
            this.aFP.setText(pluginConfig.verbose);
            if (PluginPackageManager.ls().bw(pluginConfig.package_name)) {
                if (PluginPackageManager.ls().by(pluginConfig.package_name)) {
                    this.djF.setVisibility(0);
                    this.djE.setText(n.j.plugin_update);
                    return;
                }
                this.djF.setVisibility(8);
                if (PluginPackageManager.ls().bx(pluginConfig.package_name)) {
                    this.djE.setText(n.j.plugin_unenabled);
                    return;
                } else {
                    this.djE.setText(n.j.plugin_enabled);
                    return;
                }
            }
            this.djF.setVisibility(8);
            this.djE.setText(n.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
