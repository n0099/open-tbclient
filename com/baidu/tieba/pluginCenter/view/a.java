package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView jSS;
    private TbImageView mmY;
    private TextView mmZ;
    private TextView mna;
    private CircleProgressBar mnb;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mmY = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.jSS = (TextView) view.findViewById(R.id.desc);
        this.mmZ = (TextView) view.findViewById(R.id.status);
        this.mmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bBX().dispatchMvcEvent(bVar);
            }
        });
        this.mna = (TextView) view.findViewById(R.id.install);
        this.mna.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bBX().dispatchMvcEvent(bVar);
            }
        });
        this.mnb = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void au(PluginConfigWrapper pluginConfigWrapper) {
        super.au(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.mmY.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.jSS.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pT().cC(pluginConfigWrapper.package_name)) {
                this.mna.setVisibility(8);
                this.mnb.setVisibility(8);
                this.mmZ.setVisibility(0);
                this.mmZ.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.mnb.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.mmZ.setVisibility(8);
                this.mna.setVisibility(8);
                this.mnb.setVisibility(0);
            } else {
                this.mmZ.setVisibility(8);
                this.mna.setVisibility(0);
                this.mnb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.mnb.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.mnb.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        return true;
    }
}
