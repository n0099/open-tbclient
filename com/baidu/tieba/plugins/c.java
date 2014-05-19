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
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private BaseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseActivity baseActivity) {
        this.a = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (com.baidu.tbadk.tbplugin.m.a().p() == null) {
            return 0;
        }
        return com.baidu.tbadk.tbplugin.m.a().p().plugin_config.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (com.baidu.tbadk.tbplugin.m.a().p() == null) {
            return null;
        }
        return com.baidu.tbadk.tbplugin.m.a().p().plugin_config.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongViewCast"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            view = View.inflate(this.a, com.baidu.tieba.s.plugin_center_list_item, null);
            dVar = new d(null);
            dVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.r.icon);
            dVar.c = (TextView) view.findViewById(com.baidu.tieba.r.description);
            dVar.b = (TextView) view.findViewById(com.baidu.tieba.r.name);
            dVar.d = (TextView) view.findViewById(com.baidu.tieba.r.status);
            dVar.e = view.findViewById(com.baidu.tieba.r.top_divider);
            dVar.f = view.findViewById(com.baidu.tieba.r.bot_divider);
            dVar.g = (ImageView) view.findViewById(com.baidu.tieba.r.new_mark);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        if (i == 0) {
            dVar.e.setPadding(0, 0, 0, 0);
            dVar.f.setVisibility(4);
        } else if (i == getCount() - 1) {
            dVar.e.setPadding(com.baidu.adp.lib.util.h.a((Context) this.a, 15.0f), 0, com.baidu.adp.lib.util.h.a((Context) this.a, 15.0f), 0);
            dVar.f.setVisibility(0);
            dVar.f.setPadding(0, 0, 0, 0);
        } else {
            dVar.e.setPadding(com.baidu.adp.lib.util.h.a((Context) this.a, 15.0f), 0, com.baidu.adp.lib.util.h.a((Context) this.a, 15.0f), 0);
            dVar.f.setVisibility(4);
        }
        PluginsConfig p = com.baidu.tbadk.tbplugin.m.a().p();
        if (p != null) {
            PluginsConfig.PluginConfig pluginConfig = p.plugin_config.get(i);
            dVar.c.setText(pluginConfig.verbose);
            dVar.b.setText(pluginConfig.description);
            if (com.baidu.tbadk.tbplugin.m.a().b(pluginConfig.name)) {
                dVar.d.setText(this.a.getString(u.plugin_enabled));
                if (com.baidu.tbadk.tbplugin.m.a().c(pluginConfig.name)) {
                    dVar.g.setVisibility(0);
                    dVar.d.setText(u.plugin_update);
                } else {
                    dVar.g.setVisibility(4);
                }
            } else {
                dVar.d.setText(this.a.getString(u.plugin_disabled));
            }
            dVar.a.setTag(pluginConfig.icon);
        }
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
        return view;
    }
}
