package com.baidu.tieba.plugins;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class a extends BaseAdapter {
    private List<ConfigInfos.PluginConfig> bGV = new ArrayList();
    private BaseActivity mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bGV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: he */
    public ConfigInfos.PluginConfig getItem(int i) {
        return this.bGV.get(i);
    }

    public void aj(List<ConfigInfos.PluginConfig> list) {
        this.bGV.clear();
        this.bGV.addAll(list);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.mActivity, w.plugin_center_list_item, null);
            b bVar2 = new b(null);
            bVar2.aBW = (HeadImageView) view.findViewById(v.icon);
            bVar2.bGW = (TextView) view.findViewById(v.description);
            bVar2.awi = (TextView) view.findViewById(v.name);
            bVar2.atL = (TextView) view.findViewById(v.status);
            bVar2.bGX = view.findViewById(v.top_divider);
            bVar2.bGY = view.findViewById(v.bot_divider);
            bVar2.bGZ = (ImageView) view.findViewById(v.new_mark);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (i == 0) {
            bVar.bGX.setPadding(0, 0, 0, 0);
            bVar.bGY.setVisibility(4);
        } else if (i == getCount() - 1) {
            bVar.bGX.setPadding(m.dip2px(this.mActivity, 15.0f), 0, m.dip2px(this.mActivity, 15.0f), 0);
            bVar.bGY.setVisibility(0);
            bVar.bGY.setPadding(0, 0, 0, 0);
        } else {
            bVar.bGX.setPadding(m.dip2px(this.mActivity, 15.0f), 0, m.dip2px(this.mActivity, 15.0f), 0);
            bVar.bGY.setVisibility(4);
        }
        ConfigInfos.PluginConfig item = getItem(i);
        if (item != null) {
            bVar.bGW.setText(item.verbose);
            bVar.awi.setText(item.description);
            if (PluginCenter.getInstance().checkPluginInstalled(item.name)) {
                if (PluginCenter.getInstance().hasUpdate(item.name)) {
                    bVar.bGZ.setVisibility(0);
                    bVar.atL.setText(y.plugin_update);
                } else {
                    bVar.bGZ.setVisibility(4);
                    if (!PluginCenter.getInstance().isEnabled(item.name)) {
                        bVar.atL.setText(this.mActivity.getString(y.plugin_unenabled));
                    } else {
                        bVar.atL.setText(this.mActivity.getString(y.plugin_enabled));
                    }
                }
            } else {
                bVar.atL.setText(this.mActivity.getString(y.plugin_disabled));
            }
            bVar.aBW.setTag(item.icon);
            bVar.aBW.c(item.icon, 10, false);
        }
        this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
        return view;
    }
}
