package com.baidu.tieba.pluginCenter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Dialog {
    private TextView aML;
    private LinearLayout avE;
    private TextView azr;
    private TextView bXA;
    private TextView bXB;
    private TextView bXC;
    final /* synthetic */ PluginDownloadActivity bXt;
    private LinearLayout bXu;
    private TextView bXv;
    private TextView bXw;
    private TextView bXx;
    private TextView bXy;
    private TextView bXz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bXt = pluginDownloadActivity;
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
        setContentView(r.update_dialog);
        findViewById(q.warning).setVisibility(8);
        findViewById(q.incremental_button).setVisibility(8);
        findViewById(q.incremental_size).setVisibility(8);
        this.bXu = (LinearLayout) findViewById(q.down_dialog);
        this.bXB = (TextView) findViewById(q.update_tip);
        this.bXv = (TextView) findViewById(q.newversion);
        this.aML = (TextView) findViewById(q.desc);
        this.bXw = (TextView) findViewById(q.update_button);
        this.bXw.setText(this.bXt.getPageContext().getString(t.plugin_download_immediately));
        this.azr = (TextView) findViewById(q.update_cancel);
        this.bXx = (TextView) findViewById(q.downloading);
        this.bXC = (TextView) findViewById(q.otherApp);
        this.bXC.setVisibility(8);
        this.bXy = (TextView) findViewById(q.app_size);
        this.avE = (LinearLayout) findViewById(q.cancel_dialog);
        this.bXz = (TextView) findViewById(q.sure_cancel);
        this.bXA = (TextView) findViewById(q.cancel_button);
        this.bXz.setOnClickListener(new j(this));
        this.bXA.setOnClickListener(new k(this));
        pluginConfig = this.bXt.bXp;
        if (TextUtils.isEmpty(pluginConfig.display_name)) {
            this.bXB.setText("");
        } else {
            TextView textView = this.bXB;
            pluginConfig2 = this.bXt.bXp;
            textView.setText(pluginConfig2.display_name);
        }
        pluginConfig3 = this.bXt.bXp;
        if (pluginConfig3.newest != null) {
            pluginConfig4 = this.bXt.bXp;
            if (TextUtils.isEmpty(pluginConfig4.newest.version)) {
                this.bXv.setText("");
            } else {
                TextView textView2 = this.bXv;
                StringBuilder sb = new StringBuilder("版本：");
                pluginConfig5 = this.bXt.bXp;
                textView2.setText(sb.append(pluginConfig5.newest.version).toString());
            }
            pluginConfig6 = this.bXt.bXp;
            if (TextUtils.isEmpty(pluginConfig6.newest.change_log)) {
                this.aML.setText("");
            } else {
                TextView textView3 = this.aML;
                pluginConfig7 = this.bXt.bXp;
                textView3.setText(pluginConfig7.newest.change_log);
            }
            pluginConfig8 = this.bXt.bXp;
            String valueOf = String.valueOf(pluginConfig8.newest.size / 1024);
            if (valueOf != null && !"".equals(valueOf)) {
                this.bXy.setVisibility(0);
                this.bXy.setText(((Object) this.bXy.getText()) + valueOf + "KB");
            } else {
                this.bXy.setVisibility(8);
            }
        } else {
            this.bXv.setText("");
            this.aML.setText("");
            this.bXy.setText("");
        }
        this.bXw.setOnClickListener(new l(this));
        this.azr.setOnClickListener(new n(this));
    }
}
