package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView ipO;
    private TbImageView kDs;
    private TextView kDt;
    private TextView kDu;
    private CircleProgressBar kDv;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.kDs = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.ipO = (TextView) view.findViewById(R.id.desc);
        this.kDt = (TextView) view.findViewById(R.id.status);
        this.kDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bfm().dispatchMvcEvent(bVar);
            }
        });
        this.kDu = (TextView) view.findViewById(R.id.install);
        this.kDu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bfm().dispatchMvcEvent(bVar);
            }
        });
        this.kDv = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void an(PluginConfigWrapper pluginConfigWrapper) {
        super.an(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.kDs.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.ipO.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.nX().cv(pluginConfigWrapper.package_name)) {
                this.kDu.setVisibility(8);
                this.kDv.setVisibility(8);
                this.kDt.setVisibility(0);
                this.kDt.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.kDv.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.kDt.setVisibility(8);
                this.kDu.setVisibility(8);
                this.kDv.setVisibility(0);
            } else {
                this.kDt.setVisibility(8);
                this.kDu.setVisibility(0);
                this.kDv.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.kDv.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.kDv.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
