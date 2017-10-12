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
    private TextView aTm;
    private TextView awk;
    private TbImageView fyQ;
    private TextView fyR;
    private ImageView fyS;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fyQ = (TbImageView) view.findViewById(d.h.icon);
        this.awk = (TextView) view.findViewById(d.h.title);
        this.aTm = (TextView) view.findViewById(d.h.desc);
        this.fyR = (TextView) view.findViewById(d.h.status);
        this.fyS = (ImageView) view.findViewById(d.h.new_mark);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(PluginNetConfigInfos.PluginConfig pluginConfig) {
        super.D(pluginConfig);
        if (pluginConfig != null) {
            if (!StringUtils.isNull(pluginConfig.icon)) {
                this.fyQ.c(pluginConfig.icon, 10, false);
            }
            this.awk.setText(pluginConfig.display_name);
            this.aTm.setText(pluginConfig.verbose);
            if (PluginPackageManager.jv().bn(pluginConfig.package_name)) {
                if (PluginPackageManager.jv().bp(pluginConfig.package_name)) {
                    this.fyS.setVisibility(0);
                    this.fyR.setText(d.l.download_update);
                    return;
                }
                this.fyS.setVisibility(8);
                if (PluginPackageManager.jv().bo(pluginConfig.package_name)) {
                    this.fyR.setText(d.l.plugin_unenabled);
                    return;
                } else {
                    this.fyR.setText(d.l.plugin_enabled);
                    return;
                }
            }
            this.fyS.setVisibility(8);
            this.fyR.setText(d.l.plugin_disabled);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
