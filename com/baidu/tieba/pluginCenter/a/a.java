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
    private TextView aSE;
    private TextView axQ;
    private TbImageView fBf;
    private TextView fBg;
    private ImageView fBh;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fBf = (TbImageView) view.findViewById(d.h.icon);
        this.axQ = (TextView) view.findViewById(d.h.title);
        this.aSE = (TextView) view.findViewById(d.h.desc);
        this.fBg = (TextView) view.findViewById(d.h.status);
        this.fBh = (ImageView) view.findViewById(d.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.E(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fBf.c(pluginConfig.icon, 10, false);
            }
            this.axQ.setText(pluginConfig.display_name);
            this.aSE.setText(pluginConfig.verbose);
            if (PluginPackageManager.jE().bq(pluginConfig.package_name)) {
                if (PluginPackageManager.jE().bs(pluginConfig.package_name)) {
                    this.fBh.setVisibility(0);
                    this.fBg.setText(d.l.download_update);
                    return;
                }
                this.fBh.setVisibility(8);
                if (PluginPackageManager.jE().br(pluginConfig.package_name)) {
                    this.fBg.setText(d.l.plugin_unenabled);
                    return;
                } else {
                    this.fBg.setText(d.l.plugin_enabled);
                    return;
                }
            }
            this.fBh.setVisibility(8);
            this.fBg.setText(d.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
