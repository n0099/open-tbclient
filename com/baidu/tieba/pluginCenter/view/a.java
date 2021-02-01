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
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView kxW;
    private TbImageView mLo;
    private TextView mLp;
    private TextView mLq;
    private CircleProgressBar mLr;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mLo = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.kxW = (TextView) view.findViewById(R.id.desc);
        this.mLp = (TextView) view.findViewById(R.id.status);
        this.mLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bDI().dispatchMvcEvent(bVar);
            }
        });
        this.mLq = (TextView) view.findViewById(R.id.install);
        this.mLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bDI().dispatchMvcEvent(bVar);
            }
        });
        this.mLr = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void aw(PluginConfigWrapper pluginConfigWrapper) {
        super.aw(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.mLo.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.kxW.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pv().cA(pluginConfigWrapper.package_name)) {
                this.mLq.setVisibility(8);
                this.mLr.setVisibility(8);
                this.mLp.setVisibility(0);
                this.mLp.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.mLr.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.mLp.setVisibility(8);
                this.mLq.setVisibility(8);
                this.mLr.setVisibility(0);
            } else {
                this.mLp.setVisibility(8);
                this.mLq.setVisibility(0);
                this.mLr.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.mLr.setCircleForegroundColor(ap.getColor(R.color.CAM_X0302));
        this.mLr.setCircleBackgroundColor(ap.getColor(R.color.CAM_X0109));
        return true;
    }
}
