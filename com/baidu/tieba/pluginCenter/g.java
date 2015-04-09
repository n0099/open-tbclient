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
    private TextView aKD;
    private LinearLayout aud;
    private TextView axE;
    final /* synthetic */ PluginDownloadActivity bUO;
    private LinearLayout bUP;
    private TextView bUQ;
    private TextView bUR;
    private TextView bUS;
    private TextView bUT;
    private TextView bUU;
    private TextView bUV;
    private TextView bUW;
    private TextView bUX;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bUO = pluginDownloadActivity;
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
        this.bUP = (LinearLayout) findViewById(v.down_dialog);
        this.bUW = (TextView) findViewById(v.update_tip);
        this.bUQ = (TextView) findViewById(v.newversion);
        this.aKD = (TextView) findViewById(v.desc);
        this.bUR = (TextView) findViewById(v.update_button);
        this.bUR.setText(this.bUO.getPageContext().getString(y.plugin_download_immediately));
        this.axE = (TextView) findViewById(v.update_cancel);
        this.bUS = (TextView) findViewById(v.downloading);
        this.bUX = (TextView) findViewById(v.otherApp);
        this.bUX.setVisibility(8);
        this.bUT = (TextView) findViewById(v.app_size);
        this.aud = (LinearLayout) findViewById(v.cancel_dialog);
        this.bUU = (TextView) findViewById(v.sure_cancel);
        this.bUV = (TextView) findViewById(v.cancel_button);
        this.bUU.setOnClickListener(new h(this));
        this.bUV.setOnClickListener(new i(this));
        pluginConfig = this.bUO.bUK;
        if (TextUtils.isEmpty(pluginConfig.display_name)) {
            this.bUW.setText("");
        } else {
            TextView textView = this.bUW;
            pluginConfig2 = this.bUO.bUK;
            textView.setText(pluginConfig2.display_name);
        }
        pluginConfig3 = this.bUO.bUK;
        if (pluginConfig3.newest != null) {
            pluginConfig4 = this.bUO.bUK;
            if (TextUtils.isEmpty(pluginConfig4.newest.version)) {
                this.bUQ.setText("");
            } else {
                TextView textView2 = this.bUQ;
                StringBuilder sb = new StringBuilder("版本：");
                pluginConfig5 = this.bUO.bUK;
                textView2.setText(sb.append(pluginConfig5.newest.version).toString());
            }
            pluginConfig6 = this.bUO.bUK;
            if (TextUtils.isEmpty(pluginConfig6.newest.change_log)) {
                this.aKD.setText("");
            } else {
                TextView textView3 = this.aKD;
                pluginConfig7 = this.bUO.bUK;
                textView3.setText(pluginConfig7.newest.change_log);
            }
            pluginConfig8 = this.bUO.bUK;
            String valueOf = String.valueOf(pluginConfig8.newest.size / 1024);
            if (valueOf != null && !"".equals(valueOf)) {
                this.bUT.setVisibility(0);
                this.bUT.setText(((Object) this.bUT.getText()) + valueOf + "KB");
            } else {
                this.bUT.setVisibility(8);
            }
        } else {
            this.bUQ.setText("");
            this.aKD.setText("");
            this.bUT.setText("");
        }
        this.bUR.setOnClickListener(new j(this));
        this.axE.setOnClickListener(new l(this));
    }
}
