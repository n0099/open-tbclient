package com.baidu.tieba.plugins;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
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
        setContentView(w.update_dialog);
        this.b = (LinearLayout) findViewById(v.down_dialog);
        this.n = (TextView) findViewById(v.update_tip);
        this.c = (TextView) findViewById(v.newversion);
        this.d = (TextView) findViewById(v.desc);
        this.e = (Button) findViewById(v.update_button);
        this.e.setText(this.a.getString(y.plugin_download_immediately));
        this.f = (Button) findViewById(v.update_cancel);
        this.g = (TextView) findViewById(v.downloading);
        this.o = (TextView) findViewById(v.otherApp);
        this.o.setVisibility(8);
        if (this.g != null) {
            this.k = this.g.getText().toString();
        }
        this.h = (TextView) findViewById(v.app_size);
        this.i = (LinearLayout) findViewById(v.cancel_dialog);
        this.j = (Button) findViewById(v.sure_cancel);
        this.l = (Button) findViewById(v.cancel_button);
        this.m = (TextView) findViewById(v.cancel_tip);
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
