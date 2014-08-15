package com.baidu.tieba.plugins;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class a extends BaseAdapter {
    private BaseActivity a;
    private List<ConfigInfos.PluginConfig> b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseActivity baseActivity) {
        this.a = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ConfigInfos.PluginConfig getItem(int i) {
        return this.b.get(i);
    }

    public void a(List<ConfigInfos.PluginConfig> list) {
        this.b.clear();
        this.b.addAll(list);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongViewCast"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.a, v.plugin_center_list_item, null);
            b bVar2 = new b(null);
            bVar2.a = (HeadImageView) view.findViewById(u.icon);
            bVar2.c = (TextView) view.findViewById(u.description);
            bVar2.b = (TextView) view.findViewById(u.name);
            bVar2.d = (TextView) view.findViewById(u.status);
            bVar2.e = view.findViewById(u.top_divider);
            bVar2.f = view.findViewById(u.bot_divider);
            bVar2.g = (ImageView) view.findViewById(u.new_mark);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (i == 0) {
            bVar.e.setPadding(0, 0, 0, 0);
            bVar.f.setVisibility(4);
        } else if (i == getCount() - 1) {
            bVar.e.setPadding(com.baidu.adp.lib.util.j.a((Context) this.a, 15.0f), 0, com.baidu.adp.lib.util.j.a((Context) this.a, 15.0f), 0);
            bVar.f.setVisibility(0);
            bVar.f.setPadding(0, 0, 0, 0);
        } else {
            bVar.e.setPadding(com.baidu.adp.lib.util.j.a((Context) this.a, 15.0f), 0, com.baidu.adp.lib.util.j.a((Context) this.a, 15.0f), 0);
            bVar.f.setVisibility(4);
        }
        ConfigInfos.PluginConfig item = getItem(i);
        if (item != null) {
            bVar.c.setText(item.verbose);
            bVar.b.setText(item.description);
            if (com.baidu.tbadk.pluginArch.d.a().c(item.name)) {
                if (com.baidu.tbadk.pluginArch.d.a().e(item.name)) {
                    bVar.g.setVisibility(0);
                    bVar.d.setText(x.plugin_update);
                } else {
                    bVar.g.setVisibility(4);
                    if (!com.baidu.tbadk.pluginArch.d.a().d(item.name)) {
                        bVar.d.setText(this.a.getString(x.plugin_unenabled));
                    } else {
                        bVar.d.setText(this.a.getString(x.plugin_enabled));
                    }
                }
            } else {
                bVar.d.setText(this.a.getString(x.plugin_disabled));
            }
            bVar.a.setTag(item.icon);
            bVar.a.a(item.icon, 10, false);
        }
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
        return view;
    }
}
