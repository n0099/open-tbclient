package com.baidu.tieba.pluginCenter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Dialog {
    private TextView aKt;
    private LinearLayout atV;
    private TextView axw;
    private TextView bUA;
    private TextView bUB;
    private TextView bUC;
    private TextView bUD;
    private TextView bUE;
    private TextView bUF;
    private TextView bUG;
    private TextView bUH;
    final /* synthetic */ PluginDownloadActivity bUy;
    private LinearLayout bUz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bUy = pluginDownloadActivity;
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
        setContentView(w.update_dialog);
        findViewById(v.warning).setVisibility(8);
        findViewById(v.incremental_button).setVisibility(8);
        findViewById(v.incremental_size).setVisibility(8);
        this.bUz = (LinearLayout) findViewById(v.down_dialog);
        this.bUG = (TextView) findViewById(v.update_tip);
        this.bUA = (TextView) findViewById(v.newversion);
        this.aKt = (TextView) findViewById(v.desc);
        this.bUB = (TextView) findViewById(v.update_button);
        this.bUB.setText(this.bUy.getPageContext().getString(y.plugin_download_immediately));
        this.axw = (TextView) findViewById(v.update_cancel);
        this.bUC = (TextView) findViewById(v.downloading);
        this.bUH = (TextView) findViewById(v.otherApp);
        this.bUH.setVisibility(8);
        this.bUD = (TextView) findViewById(v.app_size);
        this.atV = (LinearLayout) findViewById(v.cancel_dialog);
        this.bUE = (TextView) findViewById(v.sure_cancel);
        this.bUF = (TextView) findViewById(v.cancel_button);
        this.bUE.setOnClickListener(new h(this));
        this.bUF.setOnClickListener(new i(this));
        pluginConfig = this.bUy.bUu;
        if (TextUtils.isEmpty(pluginConfig.display_name)) {
            this.bUG.setText("");
        } else {
            TextView textView = this.bUG;
            pluginConfig2 = this.bUy.bUu;
            textView.setText(pluginConfig2.display_name);
        }
        pluginConfig3 = this.bUy.bUu;
        if (pluginConfig3.newest != null) {
            pluginConfig4 = this.bUy.bUu;
            if (TextUtils.isEmpty(pluginConfig4.newest.version)) {
                this.bUA.setText("");
            } else {
                TextView textView2 = this.bUA;
                StringBuilder sb = new StringBuilder("版本：");
                pluginConfig5 = this.bUy.bUu;
                textView2.setText(sb.append(pluginConfig5.newest.version).toString());
            }
            pluginConfig6 = this.bUy.bUu;
            if (TextUtils.isEmpty(pluginConfig6.newest.change_log)) {
                this.aKt.setText("");
            } else {
                TextView textView3 = this.aKt;
                pluginConfig7 = this.bUy.bUu;
                textView3.setText(pluginConfig7.newest.change_log);
            }
            pluginConfig8 = this.bUy.bUu;
            String valueOf = String.valueOf(pluginConfig8.newest.size / 1024);
            if (valueOf != null && !"".equals(valueOf)) {
                this.bUD.setVisibility(0);
                this.bUD.setText(((Object) this.bUD.getText()) + valueOf + "KB");
            } else {
                this.bUD.setVisibility(8);
            }
        } else {
            this.bUA.setText("");
            this.aKt.setText("");
            this.bUD.setText("");
        }
        this.bUB.setOnClickListener(new j(this));
        this.axw.setOnClickListener(new l(this));
    }
}
