package com.baidu.tieba.plugins;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Dialog {
    final /* synthetic */ PluginDownloadActivity a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private Button e;
    private Button f;
    private TextView g;
    private TextView h;
    private LinearLayout i;
    private Button j;
    private String k;
    private Button l;
    private TextView m;
    private TextView n;
    private TextView o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.a = pluginDownloadActivity;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        PluginsConfig.PluginConfig pluginConfig;
        PluginsConfig.PluginConfig pluginConfig2;
        PluginsConfig.PluginConfig pluginConfig3;
        PluginsConfig.PluginConfig pluginConfig4;
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.update_dialog);
        this.b = (LinearLayout) findViewById(com.baidu.tieba.r.down_dialog);
        this.n = (TextView) findViewById(com.baidu.tieba.r.update_tip);
        this.c = (TextView) findViewById(com.baidu.tieba.r.newversion);
        this.d = (TextView) findViewById(com.baidu.tieba.r.desc);
        this.e = (Button) findViewById(com.baidu.tieba.r.update_button);
        this.e.setText(this.a.getString(u.plugin_download_immediately));
        this.f = (Button) findViewById(com.baidu.tieba.r.update_cancel);
        this.g = (TextView) findViewById(com.baidu.tieba.r.downloading);
        this.o = (TextView) findViewById(com.baidu.tieba.r.otherApp);
        this.o.setVisibility(8);
        if (this.g != null) {
            this.k = this.g.getText().toString();
        }
        this.h = (TextView) findViewById(com.baidu.tieba.r.app_size);
        this.i = (LinearLayout) findViewById(com.baidu.tieba.r.cancel_dialog);
        this.j = (Button) findViewById(com.baidu.tieba.r.sure_cancel);
        this.l = (Button) findViewById(com.baidu.tieba.r.cancel_button);
        this.m = (TextView) findViewById(com.baidu.tieba.r.cancel_tip);
        this.j.setOnClickListener(new p(this));
        this.l.setOnClickListener(new q(this));
        TextView textView = this.n;
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
        this.e.setOnClickListener(new r(this));
        this.f.setOnClickListener(new t(this));
    }
}
