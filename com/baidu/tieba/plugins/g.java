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
    private LinearLayout alS;
    private TextView apf;
    private TextView awk;
    final /* synthetic */ PluginDownloadActivity bMo;
    private LinearLayout bMp;
    private TextView bMq;
    private TextView bMr;
    private TextView bMs;
    private TextView bMt;
    private TextView bMu;
    private TextView bMv;
    private TextView bMw;
    private TextView bMx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bMo = pluginDownloadActivity;
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
        this.bMp = (LinearLayout) findViewById(w.down_dialog);
        this.bMw = (TextView) findViewById(w.update_tip);
        this.bMq = (TextView) findViewById(w.newversion);
        this.awk = (TextView) findViewById(w.desc);
        this.bMr = (TextView) findViewById(w.update_button);
        this.bMr.setText(this.bMo.getPageContext().getString(z.plugin_download_immediately));
        this.apf = (TextView) findViewById(w.update_cancel);
        this.bMs = (TextView) findViewById(w.downloading);
        this.bMx = (TextView) findViewById(w.otherApp);
        this.bMx.setVisibility(8);
        this.bMt = (TextView) findViewById(w.app_size);
        this.alS = (LinearLayout) findViewById(w.cancel_dialog);
        this.bMu = (TextView) findViewById(w.sure_cancel);
        this.bMv = (TextView) findViewById(w.cancel_button);
        this.bMu.setOnClickListener(new h(this));
        this.bMv.setOnClickListener(new i(this));
        pluginConfig = this.bMo.bMk;
        if (TextUtils.isEmpty(pluginConfig.display_name)) {
            this.bMw.setText("");
        } else {
            TextView textView = this.bMw;
            pluginConfig2 = this.bMo.bMk;
            textView.setText(pluginConfig2.display_name);
        }
        pluginConfig3 = this.bMo.bMk;
        if (pluginConfig3.newest != null) {
            pluginConfig4 = this.bMo.bMk;
            if (TextUtils.isEmpty(pluginConfig4.newest.version)) {
                this.bMq.setText("");
            } else {
                TextView textView2 = this.bMq;
                StringBuilder sb = new StringBuilder("版本：");
                pluginConfig5 = this.bMo.bMk;
                textView2.setText(sb.append(pluginConfig5.newest.version).toString());
            }
            pluginConfig6 = this.bMo.bMk;
            if (TextUtils.isEmpty(pluginConfig6.newest.change_log)) {
                this.awk.setText("");
            } else {
                TextView textView3 = this.awk;
                pluginConfig7 = this.bMo.bMk;
                textView3.setText(pluginConfig7.newest.change_log);
            }
            pluginConfig8 = this.bMo.bMk;
            String valueOf = String.valueOf(pluginConfig8.newest.size / 1024);
            if (valueOf != null && !"".equals(valueOf)) {
                this.bMt.setVisibility(0);
                this.bMt.setText(((Object) this.bMt.getText()) + valueOf + "KB");
            } else {
                this.bMt.setVisibility(8);
            }
        } else {
            this.bMq.setText("");
            this.awk.setText("");
            this.bMt.setText("");
        }
        this.bMr.setOnClickListener(new j(this));
        this.apf.setOnClickListener(new l(this));
    }
}
