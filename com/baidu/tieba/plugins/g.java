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
    private LinearLayout adm;
    private TextView agU;
    private TextView aqa;
    final /* synthetic */ PluginDownloadActivity bHj;
    private LinearLayout bHk;
    private TextView bHl;
    private TextView bHm;
    private TextView bHn;
    private TextView bHo;
    private TextView bHp;
    private TextView bHq;
    private TextView bHr;
    private TextView bHs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
        super(context, i);
        this.bHj = pluginDownloadActivity;
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
        this.bHk = (LinearLayout) findViewById(v.down_dialog);
        this.bHr = (TextView) findViewById(v.update_tip);
        this.bHl = (TextView) findViewById(v.newversion);
        this.aqa = (TextView) findViewById(v.desc);
        this.bHm = (TextView) findViewById(v.update_button);
        this.bHm.setText(this.bHj.getString(y.plugin_download_immediately));
        this.agU = (TextView) findViewById(v.update_cancel);
        this.bHn = (TextView) findViewById(v.downloading);
        this.bHs = (TextView) findViewById(v.otherApp);
        this.bHs.setVisibility(8);
        this.bHo = (TextView) findViewById(v.app_size);
        this.adm = (LinearLayout) findViewById(v.cancel_dialog);
        this.bHp = (TextView) findViewById(v.sure_cancel);
        this.bHq = (TextView) findViewById(v.cancel_button);
        this.bHp.setOnClickListener(new h(this));
        this.bHq.setOnClickListener(new i(this));
        TextView textView = this.bHr;
        pluginConfig = this.bHj.bHe;
        textView.setText(pluginConfig.description);
        TextView textView2 = this.bHl;
        StringBuilder sb = new StringBuilder("版本：");
        pluginConfig2 = this.bHj.bHe;
        textView2.setText(sb.append(pluginConfig2.newest.version).toString());
        TextView textView3 = this.aqa;
        pluginConfig3 = this.bHj.bHe;
        textView3.setText(pluginConfig3.newest.changelog);
        pluginConfig4 = this.bHj.bHe;
        String valueOf = String.valueOf(pluginConfig4.newest.size / 1024);
        if (valueOf != null && !"".equals(valueOf)) {
            this.bHo.setVisibility(0);
            this.bHo.setText(((Object) this.bHo.getText()) + valueOf + "KB");
        } else {
            this.bHo.setVisibility(8);
        }
        this.bHm.setOnClickListener(new j(this));
        this.agU.setOnClickListener(new l(this));
    }
}
