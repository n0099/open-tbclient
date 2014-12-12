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
    private LinearLayout akY;
    private TextView aok;
    private TextView avk;
    final /* synthetic */ PluginDownloadActivity bKD;
    private LinearLayout bKE;
    private TextView bKF;
    private TextView bKG;
    private TextView bKH;
    private TextView bKI;
    private TextView bKJ;
    private TextView bKK;
    private TextView bKL;
    private TextView bKM;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bKD = pluginDownloadActivity;
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
        this.bKE = (LinearLayout) findViewById(w.down_dialog);
        this.bKL = (TextView) findViewById(w.update_tip);
        this.bKF = (TextView) findViewById(w.newversion);
        this.avk = (TextView) findViewById(w.desc);
        this.bKG = (TextView) findViewById(w.update_button);
        this.bKG.setText(this.bKD.getPageContext().getString(z.plugin_download_immediately));
        this.aok = (TextView) findViewById(w.update_cancel);
        this.bKH = (TextView) findViewById(w.downloading);
        this.bKM = (TextView) findViewById(w.otherApp);
        this.bKM.setVisibility(8);
        this.bKI = (TextView) findViewById(w.app_size);
        this.akY = (LinearLayout) findViewById(w.cancel_dialog);
        this.bKJ = (TextView) findViewById(w.sure_cancel);
        this.bKK = (TextView) findViewById(w.cancel_button);
        this.bKJ.setOnClickListener(new h(this));
        this.bKK.setOnClickListener(new i(this));
        pluginConfig = this.bKD.bKz;
        if (TextUtils.isEmpty(pluginConfig.display_name)) {
            this.bKL.setText("");
        } else {
            TextView textView = this.bKL;
            pluginConfig2 = this.bKD.bKz;
            textView.setText(pluginConfig2.display_name);
        }
        pluginConfig3 = this.bKD.bKz;
        if (pluginConfig3.newest != null) {
            pluginConfig4 = this.bKD.bKz;
            if (TextUtils.isEmpty(pluginConfig4.newest.version)) {
                this.bKF.setText("");
            } else {
                TextView textView2 = this.bKF;
                StringBuilder sb = new StringBuilder("版本：");
                pluginConfig5 = this.bKD.bKz;
                textView2.setText(sb.append(pluginConfig5.newest.version).toString());
            }
            pluginConfig6 = this.bKD.bKz;
            if (TextUtils.isEmpty(pluginConfig6.newest.change_log)) {
                this.avk.setText("");
            } else {
                TextView textView3 = this.avk;
                pluginConfig7 = this.bKD.bKz;
                textView3.setText(pluginConfig7.newest.change_log);
            }
            pluginConfig8 = this.bKD.bKz;
            String valueOf = String.valueOf(pluginConfig8.newest.size / 1024);
            if (valueOf != null && !"".equals(valueOf)) {
                this.bKI.setVisibility(0);
                this.bKI.setText(((Object) this.bKI.getText()) + valueOf + "KB");
            } else {
                this.bKI.setVisibility(8);
            }
        } else {
            this.bKF.setText("");
            this.avk.setText("");
            this.bKI.setText("");
        }
        this.bKG.setOnClickListener(new j(this));
        this.aok.setOnClickListener(new l(this));
    }
}
