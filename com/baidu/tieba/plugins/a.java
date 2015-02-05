package com.baidu.tieba.plugins;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class a extends BaseAdapter {
    private List<PluginNetConfigInfos.PluginConfig> bLZ = new ArrayList();
    private BaseActivity mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bLZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hw */
    public PluginNetConfigInfos.PluginConfig getItem(int i) {
        return this.bLZ.get(i);
    }

    public void addAll(List<PluginNetConfigInfos.PluginConfig> list) {
        this.bLZ.clear();
        this.bLZ.addAll(list);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.mActivity.getPageContext().getPageActivity(), x.plugin_center_list_item, null);
            b bVar2 = new b(null);
            bVar2.aEw = (HeadImageView) view.findViewById(w.icon);
            bVar2.bMa = (TextView) view.findViewById(w.description);
            bVar2.aAn = (TextView) view.findViewById(w.name);
            bVar2.axR = (TextView) view.findViewById(w.status);
            bVar2.bMb = view.findViewById(w.top_divider);
            bVar2.bMc = view.findViewById(w.bot_divider);
            bVar2.bMd = (ImageView) view.findViewById(w.new_mark);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (i == 0) {
            bVar.bMb.setPadding(0, 0, 0, 0);
            bVar.bMc.setVisibility(4);
        } else if (i == getCount() - 1) {
            bVar.bMb.setPadding(com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 15.0f), 0, com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 15.0f), 0);
            bVar.bMc.setVisibility(0);
            bVar.bMc.setPadding(0, 0, 0, 0);
        } else {
            bVar.bMb.setPadding(com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 15.0f), 0, com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 15.0f), 0);
            bVar.bMc.setVisibility(4);
        }
        PluginNetConfigInfos.PluginConfig item = getItem(i);
        if (item != null) {
            bVar.bMa.setText(item.verbose);
            bVar.aAn.setText(item.display_name);
            if (PluginPackageManager.hV().bf(item.package_name)) {
                if (PluginPackageManager.hV().bh(item.package_name)) {
                    bVar.bMd.setVisibility(0);
                    bVar.axR.setText(z.plugin_update);
                } else {
                    bVar.bMd.setVisibility(4);
                    if (PluginPackageManager.hV().bg(item.package_name)) {
                        bVar.axR.setText(this.mActivity.getPageContext().getString(z.plugin_unenabled));
                    } else {
                        bVar.axR.setText(this.mActivity.getPageContext().getString(z.plugin_enabled));
                    }
                }
            } else {
                bVar.axR.setText(this.mActivity.getPageContext().getString(z.plugin_disabled));
            }
            bVar.aEw.setTag(item.icon);
            bVar.aEw.d(item.icon, 10, false);
        }
        this.mActivity.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
        return view;
    }
}
