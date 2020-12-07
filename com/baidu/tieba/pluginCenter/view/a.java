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
    private TextView khg;
    private TbImageView mBw;
    private TextView mBx;
    private TextView mBy;
    private CircleProgressBar mBz;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mBw = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.khg = (TextView) view.findViewById(R.id.desc);
        this.mBx = (TextView) view.findViewById(R.id.status);
        this.mBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bEP().dispatchMvcEvent(bVar);
            }
        });
        this.mBy = (TextView) view.findViewById(R.id.install);
        this.mBy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bEP().dispatchMvcEvent(bVar);
            }
        });
        this.mBz = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void au(PluginConfigWrapper pluginConfigWrapper) {
        super.au(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.mBw.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.khg.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pV().cH(pluginConfigWrapper.package_name)) {
                this.mBy.setVisibility(8);
                this.mBz.setVisibility(8);
                this.mBx.setVisibility(0);
                this.mBx.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.mBz.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.mBx.setVisibility(8);
                this.mBy.setVisibility(8);
                this.mBz.setVisibility(0);
            } else {
                this.mBx.setVisibility(8);
                this.mBy.setVisibility(0);
                this.mBz.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.mBz.setCircleForegroundColor(ap.getColor(R.color.CAM_X0302));
        this.mBz.setCircleBackgroundColor(ap.getColor(R.color.CAM_X0109));
        return true;
    }
}
