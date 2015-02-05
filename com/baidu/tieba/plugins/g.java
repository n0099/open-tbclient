package com.baidu.tieba.plugins;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Dialog {
    private LinearLayout alP;
    private TextView apc;
    private TextView awh;
    final /* synthetic */ PluginDownloadActivity bMn;
    private LinearLayout bMo;
    private TextView bMp;
    private TextView bMq;
    private TextView bMr;
    private TextView bMs;
    private TextView bMt;
    private TextView bMu;
    private TextView bMv;
    private TextView bMw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bMn = pluginDownloadActivity;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        PluginNetConfigInfos.PluginConfig pluginConfig2;
        PluginNetConfigInfos.PluginConfig pluginConfig3;
        PluginNetConfigInfos.PluginConfig pluginConfig4;
        PluginNetConfigInfos.PluginConfig pluginConfig5;
        PluginNetConfigInfos.PluginConfig pluginConfig6;
        PluginNetConfigInfos.PluginConfig pluginConfig7;
        PluginNetConfigInfos.PluginConfig pluginConfig8;
        super.onCreate(bundle);
        setContentView(x.update_dialog);
        findViewById(w.warning).setVisibility(8);
        findViewById(w.incremental_button).setVisibility(8);
        findViewById(w.incremental_size).setVisibility(8);
        this.bMo = (LinearLayout) findViewById(w.down_dialog);
        this.bMv = (TextView) findViewById(w.update_tip);
        this.bMp = (TextView) findViewById(w.newversion);
        this.awh = (TextView) findViewById(w.desc);
        this.bMq = (TextView) findViewById(w.update_button);
        this.bMq.setText(this.bMn.getPageContext().getString(z.plugin_download_immediately));
        this.apc = (TextView) findViewById(w.update_cancel);
        this.bMr = (TextView) findViewById(w.downloading);
        this.bMw = (TextView) findViewById(w.otherApp);
        this.bMw.setVisibility(8);
        this.bMs = (TextView) findViewById(w.app_size);
        this.alP = (LinearLayout) findViewById(w.cancel_dialog);
        this.bMt = (TextView) findViewById(w.sure_cancel);
        this.bMu = (TextView) findViewById(w.cancel_button);
        this.bMt.setOnClickListener(new h(this));
        this.bMu.setOnClickListener(new i(this));
        pluginConfig = this.bMn.bMj;
        if (TextUtils.isEmpty(pluginConfig.display_name)) {
            this.bMv.setText("");
        } else {
            TextView textView = this.bMv;
            pluginConfig2 = this.bMn.bMj;
            textView.setText(pluginConfig2.display_name);
        }
        pluginConfig3 = this.bMn.bMj;
        if (pluginConfig3.newest != null) {
            pluginConfig4 = this.bMn.bMj;
            if (TextUtils.isEmpty(pluginConfig4.newest.version)) {
                this.bMp.setText("");
            } else {
                TextView textView2 = this.bMp;
                StringBuilder sb = new StringBuilder("版本：");
                pluginConfig5 = this.bMn.bMj;
                textView2.setText(sb.append(pluginConfig5.newest.version).toString());
            }
            pluginConfig6 = this.bMn.bMj;
            if (TextUtils.isEmpty(pluginConfig6.newest.change_log)) {
                this.awh.setText("");
            } else {
                TextView textView3 = this.awh;
                pluginConfig7 = this.bMn.bMj;
                textView3.setText(pluginConfig7.newest.change_log);
            }
            pluginConfig8 = this.bMn.bMj;
            String valueOf = String.valueOf(pluginConfig8.newest.size / 1024);
            if (valueOf != null && !"".equals(valueOf)) {
                this.bMs.setVisibility(0);
                this.bMs.setText(((Object) this.bMs.getText()) + valueOf + "KB");
            } else {
                this.bMs.setVisibility(8);
            }
        } else {
            this.bMp.setText("");
            this.awh.setText("");
            this.bMs.setText("");
        }
        this.bMq.setOnClickListener(new j(this));
        this.apc.setOnClickListener(new l(this));
    }
}
