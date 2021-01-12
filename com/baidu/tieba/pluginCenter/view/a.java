package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes7.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView kpP;
    private TbImageView mCf;
    private TextView mCg;
    private TextView mCh;
    private CircleProgressBar mCi;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mCf = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.kpP = (TextView) view.findViewById(R.id.desc);
        this.mCg = (TextView) view.findViewById(R.id.status);
        this.mCg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bDq().dispatchMvcEvent(bVar);
            }
        });
        this.mCh = (TextView) view.findViewById(R.id.install);
        this.mCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bDq().dispatchMvcEvent(bVar);
            }
        });
        this.mCi = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void aw(PluginConfigWrapper pluginConfigWrapper) {
        super.aw(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.mCf.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.kpP.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.px().cA(pluginConfigWrapper.package_name)) {
                this.mCh.setVisibility(8);
                this.mCi.setVisibility(8);
                this.mCg.setVisibility(0);
                this.mCg.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.mCi.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.mCg.setVisibility(8);
                this.mCh.setVisibility(8);
                this.mCi.setVisibility(0);
            } else {
                this.mCg.setVisibility(8);
                this.mCh.setVisibility(0);
                this.mCi.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.mCi.setCircleForegroundColor(ao.getColor(R.color.CAM_X0302));
        this.mCi.setCircleBackgroundColor(ao.getColor(R.color.CAM_X0109));
        return true;
    }
}
