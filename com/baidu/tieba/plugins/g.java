package com.baidu.tieba.plugins;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Dialog {
    private LinearLayout adh;
    private TextView agL;
    private TextView apR;
    final /* synthetic */ PluginDownloadActivity bGV;
    private LinearLayout bGW;
    private TextView bGX;
    private TextView bGY;
    private TextView bGZ;
    private TextView bHa;
    private TextView bHb;
    private TextView bHc;
    private TextView bHd;
    private TextView bHe;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bGV = pluginDownloadActivity;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ConfigInfos.PluginConfig pluginConfig;
        ConfigInfos.PluginConfig pluginConfig2;
        ConfigInfos.PluginConfig pluginConfig3;
        ConfigInfos.PluginConfig pluginConfig4;
        super.onCreate(bundle);
        setContentView(w.update_dialog);
        findViewById(v.warning).setVisibility(8);
        findViewById(v.incremental_button).setVisibility(8);
        findViewById(v.incremental_size).setVisibility(8);
        this.bGW = (LinearLayout) findViewById(v.down_dialog);
        this.bHd = (TextView) findViewById(v.update_tip);
        this.bGX = (TextView) findViewById(v.newversion);
        this.apR = (TextView) findViewById(v.desc);
        this.bGY = (TextView) findViewById(v.update_button);
        this.bGY.setText(this.bGV.getString(y.plugin_download_immediately));
        this.agL = (TextView) findViewById(v.update_cancel);
        this.bGZ = (TextView) findViewById(v.downloading);
        this.bHe = (TextView) findViewById(v.otherApp);
        this.bHe.setVisibility(8);
        this.bHa = (TextView) findViewById(v.app_size);
        this.adh = (LinearLayout) findViewById(v.cancel_dialog);
        this.bHb = (TextView) findViewById(v.sure_cancel);
        this.bHc = (TextView) findViewById(v.cancel_button);
        this.bHb.setOnClickListener(new h(this));
        this.bHc.setOnClickListener(new i(this));
        TextView textView = this.bHd;
        pluginConfig = this.bGV.bGQ;
        textView.setText(pluginConfig.description);
        TextView textView2 = this.bGX;
        StringBuilder sb = new StringBuilder("版本：");
        pluginConfig2 = this.bGV.bGQ;
        textView2.setText(sb.append(pluginConfig2.newest.version).toString());
        TextView textView3 = this.apR;
        pluginConfig3 = this.bGV.bGQ;
        textView3.setText(pluginConfig3.newest.changelog);
        pluginConfig4 = this.bGV.bGQ;
        String valueOf = String.valueOf(pluginConfig4.newest.size / 1024);
        if (valueOf != null && !"".equals(valueOf)) {
            this.bHa.setVisibility(0);
            this.bHa.setText(((Object) this.bHa.getText()) + valueOf + "KB");
        } else {
            this.bHa.setVisibility(8);
        }
        this.bGY.setOnClickListener(new j(this));
        this.agL.setOnClickListener(new l(this));
    }
}
