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
    private d bqe;
    private com.baidu.tieba.model.a bqf;
    private c bqg = null;
    private String bqh = String.valueOf(com.baidu.tieba.data.e.ajC) + "mo/q/topic_page/110_1";

    public static void ae(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bqe = new d(this, new a(this));
        this.bqe.Ug();
        nY();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bqe != null) {
            this.bqe.Ug();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Jx();
        if (this.bqf != null) {
            this.bqf.cancelLoadData();
        }
        if (this.bqe != null) {
            this.bqe.hideProgress();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bqe != null) {
            this.bqe.cu(i);
        }
    }

    public void checkUpdata() {
        if (this.bqf == null) {
            this.bqf = new com.baidu.tieba.model.a(this, new b(this));
        } else {
            this.bqf.cancelLoadData();
        }
        this.bqf.Td();
        if (this.bqe != null) {
            this.bqe.Uf();
        }
    }

    public void x(Object obj) {
        Hao123Plugin hao123Plugin;
        if (this.bqe != null) {
            this.bqe.hideProgress();
        }
        bb bbVar = obj != null ? (bb) obj : null;
        if (bbVar != null) {
            com.baidu.tieba.aj.wm().a(bbVar.Ud());
            TbadkApplication.m251getInst().refreshNewVersion(false);
            if (bbVar.Ud().hasNewVer()) {
                if (bbVar.Ud().forceUpdate()) {
                    UpdateDialog.a(com.baidu.tieba.aj.wm().getApp(), bbVar.Ud(), bbVar.Uc());
                } else {
                    TbadkApplication.m251getInst().setUpdateNotifyTime(Long.valueOf(new Date().getTime()).longValue());
                    UpdateDialog.a(com.baidu.tieba.aj.wm().getApp(), bbVar.Ud(), bbVar.Uc());
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.y.neednot_update));
            }
            if (this.bqe != null) {
                this.bqe.Ug();
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
        this.bqg = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.bqg, intentFilter);
    }

    private void Jx() {
        if (this.bqg != null) {
            unregisterReceiver(this.bqg);
        }
    }
}
