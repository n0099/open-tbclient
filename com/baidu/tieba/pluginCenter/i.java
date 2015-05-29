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
    private TextView aMK;
    private LinearLayout avE;
    private TextView azq;
    private TextView bXA;
    private TextView bXB;
    final /* synthetic */ PluginDownloadActivity bXs;
    private LinearLayout bXt;
    private TextView bXu;
    private TextView bXv;
    private TextView bXw;
    private TextView bXx;
    private TextView bXy;
    private TextView bXz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bXs = pluginDownloadActivity;
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
        this.bXt = (LinearLayout) findViewById(q.down_dialog);
        this.bXA = (TextView) findViewById(q.update_tip);
        this.bXu = (TextView) findViewById(q.newversion);
        this.aMK = (TextView) findViewById(q.desc);
        this.bXv = (TextView) findViewById(q.update_button);
        this.bXv.setText(this.bXs.getPageContext().getString(t.plugin_download_immediately));
        this.azq = (TextView) findViewById(q.update_cancel);
        this.bXw = (TextView) findViewById(q.downloading);
        this.bXB = (TextView) findViewById(q.otherApp);
        this.bXB.setVisibility(8);
        this.bXx = (TextView) findViewById(q.app_size);
        this.avE = (LinearLayout) findViewById(q.cancel_dialog);
        this.bXy = (TextView) findViewById(q.sure_cancel);
        this.bXz = (TextView) findViewById(q.cancel_button);
        this.bXy.setOnClickListener(new j(this));
        this.bXz.setOnClickListener(new k(this));
        pluginConfig = this.bXs.bXo;
        if (TextUtils.isEmpty(pluginConfig.display_name)) {
            this.bXA.setText("");
        } else {
            TextView textView = this.bXA;
            pluginConfig2 = this.bXs.bXo;
            textView.setText(pluginConfig2.display_name);
        }
        pluginConfig3 = this.bXs.bXo;
        if (pluginConfig3.newest != null) {
            pluginConfig4 = this.bXs.bXo;
            if (TextUtils.isEmpty(pluginConfig4.newest.version)) {
                this.bXu.setText("");
            } else {
                TextView textView2 = this.bXu;
                StringBuilder sb = new StringBuilder("版本：");
                pluginConfig5 = this.bXs.bXo;
                textView2.setText(sb.append(pluginConfig5.newest.version).toString());
            }
            pluginConfig6 = this.bXs.bXo;
            if (TextUtils.isEmpty(pluginConfig6.newest.change_log)) {
                this.aMK.setText("");
            } else {
                TextView textView3 = this.aMK;
                pluginConfig7 = this.bXs.bXo;
                textView3.setText(pluginConfig7.newest.change_log);
            }
            pluginConfig8 = this.bXs.bXo;
            String valueOf = String.valueOf(pluginConfig8.newest.size / 1024);
            if (valueOf != null && !"".equals(valueOf)) {
                this.bXx.setVisibility(0);
                this.bXx.setText(((Object) this.bXx.getText()) + valueOf + "KB");
            } else {
                this.bXx.setVisibility(8);
            }
        } else {
            this.bXu.setText("");
            this.aMK.setText("");
            this.bXx.setText("");
        }
        this.bXv.setOnClickListener(new l(this));
        this.azq.setOnClickListener(new n(this));
    }
}
