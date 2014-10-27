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
    private List<ConfigInfos.PluginConfig> bGH = new ArrayList();
    private BaseActivity mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bGH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: he */
    public ConfigInfos.PluginConfig getItem(int i) {
        return this.bGH.get(i);
    }

    public void aj(List<ConfigInfos.PluginConfig> list) {
        this.bGH.clear();
        this.bGH.addAll(list);
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
            bVar2.aBM = (HeadImageView) view.findViewById(v.icon);
            bVar2.bGI = (TextView) view.findViewById(v.description);
            bVar2.avZ = (TextView) view.findViewById(v.name);
            bVar2.atC = (TextView) view.findViewById(v.status);
            bVar2.bGJ = view.findViewById(v.top_divider);
            bVar2.bGK = view.findViewById(v.bot_divider);
            bVar2.bGL = (ImageView) view.findViewById(v.new_mark);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (i == 0) {
            bVar.bGJ.setPadding(0, 0, 0, 0);
            bVar.bGK.setVisibility(4);
        } else if (i == getCount() - 1) {
            bVar.bGJ.setPadding(m.dip2px(this.mActivity, 15.0f), 0, m.dip2px(this.mActivity, 15.0f), 0);
            bVar.bGK.setVisibility(0);
            bVar.bGK.setPadding(0, 0, 0, 0);
        } else {
            bVar.bGJ.setPadding(m.dip2px(this.mActivity, 15.0f), 0, m.dip2px(this.mActivity, 15.0f), 0);
            bVar.bGK.setVisibility(4);
        }
        ConfigInfos.PluginConfig item = getItem(i);
        if (item != null) {
            bVar.bGI.setText(item.verbose);
            bVar.avZ.setText(item.description);
            if (PluginCenter.getInstance().checkPluginInstalled(item.name)) {
                if (PluginCenter.getInstance().hasUpdate(item.name)) {
                    bVar.bGL.setVisibility(0);
                    bVar.atC.setText(y.plugin_update);
                } else {
                    bVar.bGL.setVisibility(4);
                    if (!PluginCenter.getInstance().isEnabled(item.name)) {
                        bVar.atC.setText(this.mActivity.getString(y.plugin_unenabled));
                    } else {
                        bVar.atC.setText(this.mActivity.getString(y.plugin_enabled));
                    }
                }
            } else {
                bVar.atC.setText(this.mActivity.getString(y.plugin_disabled));
            }
            bVar.aBM.setTag(item.icon);
            bVar.aBM.c(item.icon, 10, false);
        }
        this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
        return view;
    }
}
