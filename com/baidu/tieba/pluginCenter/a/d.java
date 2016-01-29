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
    private TbImageView NM;
    private TextView aGI;
    private TextView apm;
    private TextView dxy;
    private ImageView dxz;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.NM = (TbImageView) view.findViewById(t.g.icon);
        this.apm = (TextView) view.findViewById(t.g.title);
        this.aGI = (TextView) view.findViewById(t.g.desc);
        this.dxy = (TextView) view.findViewById(t.g.status);
        this.dxz = (ImageView) view.findViewById(t.g.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.B(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.NM.d(pluginConfig.icon, 10, false);
            }
            this.apm.setText(pluginConfig.display_name);
            this.aGI.setText(pluginConfig.verbose);
            if (PluginPackageManager.lD().bw(pluginConfig.package_name)) {
                if (PluginPackageManager.lD().by(pluginConfig.package_name)) {
                    this.dxz.setVisibility(0);
                    this.dxy.setText(t.j.plugin_update);
                    return;
                }
                this.dxz.setVisibility(8);
                if (PluginPackageManager.lD().bx(pluginConfig.package_name)) {
                    this.dxy.setText(t.j.plugin_unenabled);
                    return;
                } else {
                    this.dxy.setText(t.j.plugin_enabled);
                    return;
                }
            }
            this.dxz.setVisibility(8);
            this.dxy.setText(t.j.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
