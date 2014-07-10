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
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private BaseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseActivity baseActivity) {
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
        c cVar;
        if (view == null) {
            view = View.inflate(this.a, w.plugin_center_list_item, null);
            cVar = new c(null);
            cVar.a = (HeadImageView) view.findViewById(v.icon);
            cVar.c = (TextView) view.findViewById(v.description);
            cVar.b = (TextView) view.findViewById(v.name);
            cVar.d = (TextView) view.findViewById(v.status);
            cVar.e = view.findViewById(v.top_divider);
            cVar.f = view.findViewById(v.bot_divider);
            cVar.g = (ImageView) view.findViewById(v.new_mark);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        if (i == 0) {
            cVar.e.setPadding(0, 0, 0, 0);
            cVar.f.setVisibility(4);
        } else if (i == getCount() - 1) {
            cVar.e.setPadding(com.baidu.adp.lib.util.j.a((Context) this.a, 15.0f), 0, com.baidu.adp.lib.util.j.a((Context) this.a, 15.0f), 0);
            cVar.f.setVisibility(0);
            cVar.f.setPadding(0, 0, 0, 0);
        } else {
            cVar.e.setPadding(com.baidu.adp.lib.util.j.a((Context) this.a, 15.0f), 0, com.baidu.adp.lib.util.j.a((Context) this.a, 15.0f), 0);
            cVar.f.setVisibility(4);
        }
        PluginsConfig p = com.baidu.tbadk.tbplugin.m.a().p();
        if (p != null) {
            PluginsConfig.PluginConfig pluginConfig = p.plugin_config.get(i);
            cVar.c.setText(pluginConfig.verbose);
            cVar.b.setText(pluginConfig.description);
            if (com.baidu.tbadk.tbplugin.m.a().b(pluginConfig.name)) {
                if (com.baidu.tbadk.tbplugin.m.a().c(pluginConfig.name)) {
                    cVar.g.setVisibility(0);
                    cVar.d.setText(y.plugin_update);
                } else {
                    cVar.g.setVisibility(4);
                    if (com.baidu.tbadk.tbplugin.m.a().e(pluginConfig.name)) {
                        cVar.d.setText(this.a.getString(y.plugin_unenabled));
                    } else {
                        cVar.d.setText(this.a.getString(y.plugin_enabled));
                    }
                }
            } else {
                cVar.d.setText(this.a.getString(y.plugin_disabled));
            }
            cVar.a.setTag(pluginConfig.icon);
            cVar.a.a(pluginConfig.icon, 10, false);
        }
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
        return view;
    }
}
