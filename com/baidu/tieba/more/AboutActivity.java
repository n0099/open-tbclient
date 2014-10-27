package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.model.bb;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity {
    private d bpQ;
    private com.baidu.tieba.model.a bpR;
    private c bpS = null;
    private String bpT = String.valueOf(com.baidu.tieba.data.e.ajt) + "mo/q/topic_page/110_1";

    public static void ae(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bpQ = new d(this, new a(this));
        this.bpQ.Ud();
        nY();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bpQ != null) {
            this.bpQ.Ud();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Jt();
        if (this.bpR != null) {
            this.bpR.cancelLoadData();
        }
        if (this.bpQ != null) {
            this.bpQ.hideProgress();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bpQ != null) {
            this.bpQ.cu(i);
        }
    }

    public void checkUpdata() {
        if (this.bpR == null) {
            this.bpR = new com.baidu.tieba.model.a(this, new b(this));
        } else {
            this.bpR.cancelLoadData();
        }
        this.bpR.Ta();
        if (this.bpQ != null) {
            this.bpQ.Uc();
        }
    }

    public void x(Object obj) {
        Hao123Plugin hao123Plugin;
        if (this.bpQ != null) {
            this.bpQ.hideProgress();
        }
        bb bbVar = obj != null ? (bb) obj : null;
        if (bbVar != null) {
            com.baidu.tieba.aj.wk().a(bbVar.Ua());
            TbadkApplication.m251getInst().refreshNewVersion(false);
            if (bbVar.Ua().hasNewVer()) {
                if (bbVar.Ua().forceUpdate()) {
                    UpdateDialog.a(com.baidu.tieba.aj.wk().getApp(), bbVar.Ua(), bbVar.TZ());
                } else {
                    TbadkApplication.m251getInst().setUpdateNotifyTime(Long.valueOf(new Date().getTime()).longValue());
                    UpdateDialog.a(com.baidu.tieba.aj.wk().getApp(), bbVar.Ua(), bbVar.TZ());
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.y.neednot_update));
            }
            if (this.bpQ != null) {
                this.bpQ.Ud();
            }
            if (!TbadkApplication.m251getInst().isHao123HelperShouldOpen() && TbadkApplication.m251getInst().isTiebaHelperOpen()) {
                TbadkApplication.m251getInst().setTiebaHelperOpen(false);
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
                if (pluginByName != null && pluginByName.checkEnable() && (hao123Plugin = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
                    hao123Plugin.closeFloating(this);
                    return;
                }
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.y.neterror));
    }

    private void nY() {
        this.bpS = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.bpS, intentFilter);
    }

    private void Jt() {
        if (this.bpS != null) {
            unregisterReceiver(this.bpS);
        }
    }
}
