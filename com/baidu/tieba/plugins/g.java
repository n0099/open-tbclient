package com.baidu.tieba.plugins;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Dialog {
    final /* synthetic */ PluginDownloadActivity a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.a = pluginDownloadActivity;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ConfigInfos.PluginConfig pluginConfig;
        ConfigInfos.PluginConfig pluginConfig2;
        ConfigInfos.PluginConfig pluginConfig3;
        ConfigInfos.PluginConfig pluginConfig4;
        super.onCreate(bundle);
        setContentView(v.update_dialog);
        findViewById(u.warning).setVisibility(8);
        findViewById(u.incremental_button).setVisibility(8);
        findViewById(u.incremental_size).setVisibility(8);
        this.b = (LinearLayout) findViewById(u.down_dialog);
        this.l = (TextView) findViewById(u.update_tip);
        this.c = (TextView) findViewById(u.newversion);
        this.d = (TextView) findViewById(u.desc);
        this.e = (TextView) findViewById(u.update_button);
        this.e.setText(this.a.getString(x.plugin_download_immediately));
        this.f = (TextView) findViewById(u.update_cancel);
        this.g = (TextView) findViewById(u.downloading);
        this.m = (TextView) findViewById(u.otherApp);
        this.m.setVisibility(8);
        this.h = (TextView) findViewById(u.app_size);
        this.i = (LinearLayout) findViewById(u.cancel_dialog);
        this.j = (TextView) findViewById(u.sure_cancel);
        this.k = (TextView) findViewById(u.cancel_button);
        this.j.setOnClickListener(new h(this));
        this.k.setOnClickListener(new i(this));
        TextView textView = this.l;
        pluginConfig = this.a.b;
        textView.setText(pluginConfig.description);
        TextView textView2 = this.c;
        StringBuilder sb = new StringBuilder("版本：");
        pluginConfig2 = this.a.b;
        textView2.setText(sb.append(pluginConfig2.newest.version).toString());
        TextView textView3 = this.d;
        pluginConfig3 = this.a.b;
        textView3.setText(pluginConfig3.newest.changelog);
        pluginConfig4 = this.a.b;
        String valueOf = String.valueOf(pluginConfig4.newest.size / 1024);
        if (valueOf != null && !"".equals(valueOf)) {
            this.h.setVisibility(0);
            this.h.setText(((Object) this.h.getText()) + valueOf + "KB");
        } else {
            this.h.setVisibility(8);
        }
        this.e.setOnClickListener(new j(this));
        this.f.setOnClickListener(new l(this));
    }
}
