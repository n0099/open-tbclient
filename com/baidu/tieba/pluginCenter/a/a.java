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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginNetConfigInfos.PluginConfig, com.baidu.tbadk.mvc.d.b> {
    private TbImageView Gp;
    private TextView aIK;
    private TextView apd;
    private TextView eTX;
    private ImageView eTY;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Gp = (TbImageView) view.findViewById(r.h.icon);
        this.apd = (TextView) view.findViewById(r.h.title);
        this.aIK = (TextView) view.findViewById(r.h.desc);
        this.eTX = (TextView) view.findViewById(r.h.status);
        this.eTY = (ImageView) view.findViewById(r.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.Gp.c(pluginConfig.icon, 10, false);
            }
            this.apd.setText(pluginConfig.display_name);
            this.aIK.setText(pluginConfig.verbose);
            if (PluginPackageManager.iz().bo(pluginConfig.package_name)) {
                if (PluginPackageManager.iz().bq(pluginConfig.package_name)) {
                    this.eTY.setVisibility(0);
                    this.eTX.setText(r.l.download_update);
                    return;
                }
                this.eTY.setVisibility(8);
                if (PluginPackageManager.iz().bp(pluginConfig.package_name)) {
                    this.eTX.setText(r.l.plugin_unenabled);
                    return;
                } else {
                    this.eTX.setText(r.l.plugin_enabled);
                    return;
                }
            }
            this.eTY.setVisibility(8);
            this.eTX.setText(r.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
