package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class a extends BaseAdapter {
    private List<PluginNetConfigInfos.PluginConfig> bUk = new ArrayList();
    private BaseActivity mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bUk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hF */
    public PluginNetConfigInfos.PluginConfig getItem(int i) {
        return this.bUk.get(i);
    }

    public void addAll(List<PluginNetConfigInfos.PluginConfig> list) {
        this.bUk.clear();
        this.bUk.addAll(list);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.mActivity.getPageContext().getPageActivity(), w.plugin_center_list_item, null);
            b bVar2 = new b(null);
            bVar2.aKs = (HeadImageView) view.findViewById(v.icon);
            bVar2.bUl = (TextView) view.findViewById(v.description);
            bVar2.aXK = (TextView) view.findViewById(v.name);
            bVar2.aGe = (TextView) view.findViewById(v.status);
            bVar2.bUm = view.findViewById(v.top_divider);
            bVar2.bUn = view.findViewById(v.bot_divider);
            bVar2.bUo = (ImageView) view.findViewById(v.new_mark);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (i == 0) {
            bVar.bUm.setPadding(0, 0, 0, 0);
            bVar.bUn.setVisibility(4);
        } else if (i == getCount() - 1) {
            bVar.bUm.setPadding(n.dip2px(this.mActivity.getPageContext().getPageActivity(), 15.0f), 0, n.dip2px(this.mActivity.getPageContext().getPageActivity(), 15.0f), 0);
            bVar.bUn.setVisibility(0);
            bVar.bUn.setPadding(0, 0, 0, 0);
        } else {
            bVar.bUm.setPadding(n.dip2px(this.mActivity.getPageContext().getPageActivity(), 15.0f), 0, n.dip2px(this.mActivity.getPageContext().getPageActivity(), 15.0f), 0);
            bVar.bUn.setVisibility(4);
        }
        PluginNetConfigInfos.PluginConfig item = getItem(i);
        if (item != null) {
            bVar.bUl.setText(item.verbose);
            bVar.aXK.setText(item.display_name);
            if (PluginPackageManager.ls().bm(item.package_name)) {
                if (PluginPackageManager.ls().bo(item.package_name)) {
                    bVar.bUo.setVisibility(0);
                    bVar.aGe.setText(y.plugin_update);
                } else {
                    bVar.bUo.setVisibility(4);
                    if (PluginPackageManager.ls().bn(item.package_name)) {
                        bVar.aGe.setText(this.mActivity.getPageContext().getString(y.plugin_unenabled));
                    } else {
                        bVar.aGe.setText(this.mActivity.getPageContext().getString(y.plugin_enabled));
                    }
                }
            } else {
                bVar.aGe.setText(this.mActivity.getPageContext().getString(y.plugin_disabled));
            }
            bVar.aKs.setTag(item.icon);
            bVar.aKs.c(item.icon, 10, false);
        }
        this.mActivity.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
        return view;
    }
}
