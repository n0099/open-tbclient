package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.ResponseLocationJsonHttpMessage;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.plugins.PluginCenterActivity;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private ay a = null;
    private av b = null;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ay(this);
        this.b = new av(this);
        if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
            this.a.d().c();
        } else {
            this.a.d().d();
        }
        if (TbadkApplication.m252getInst().getLocationShared()) {
            this.a.a().a();
        } else {
            this.a.a().b();
        }
        if (!TbadkApplication.m252getInst().isHao123HelperShouldOpen()) {
            this.a.c().setVisibility(8);
        }
        if (TbadkApplication.m252getInst().isTiebaHelperOpen()) {
            this.a.b().c();
        } else {
            this.a.b().d();
        }
        this.a.e().setTip(getString(com.baidu.tieba.x.calc_cache_size));
        this.a.e().b();
        this.b.a(new ak(this, this));
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SET_PRIVATE);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(new al(this, CmdConfigHttp.SET_PRIVATE_CMD));
        registerListener(new ao(this, 2008016));
        a();
    }

    private void a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_LOCATION_PRI_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_USER_LOCATION);
        tbHttpMessageTask.setResponsedClass(ResponseLocationJsonHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(new ap(this, CmdConfigHttp.GET_LOCATION_PRI_CMD));
        sendMessage(new HttpMessage(CmdConfigHttp.GET_LOCATION_PRI_CMD));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, SystemHelpSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.c();
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    private void b() {
        this.a.g().a();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.e()) {
            if (this.b != null) {
                if (TextUtils.isEmpty(this.a.e().getTip())) {
                    showToast(com.baidu.tieba.x.no_cache_delete);
                } else {
                    new AlertDialog.Builder(this).setTitle(com.baidu.tieba.x.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.x.alert_clear_all_cache).setPositiveButton(com.baidu.tieba.x.alert_yes_button, new ar(this)).setNegativeButton(com.baidu.tieba.x.alert_no_button, new as(this)).create().show();
                }
            }
        } else if (view == this.a.f()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.x.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.x.alert_clear_cache).setPositiveButton(com.baidu.tieba.x.alert_yes_button, new at(this)).setNegativeButton(com.baidu.tieba.x.alert_no_button, new au(this)).create().show();
        } else if (view == this.a.g()) {
            startActivity(new Intent(this, PluginCenterActivity.class));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        Hao123Plugin hao123Plugin;
        Hao123Plugin hao123Plugin2;
        if (view != null) {
            if (view.equals(this.a.d())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.b.a(true);
                } else {
                    this.b.a(false);
                }
            } else if (view.equals(this.a.a())) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                httpMessage.addParam("opt", "location");
                if (BdSwitchView.SwitchState.ON == switchState) {
                    httpMessage.addParam("val", String.valueOf(1));
                } else {
                    httpMessage.addParam("val", String.valueOf(3));
                }
                sendMessage(httpMessage);
                showProgressBar();
            } else if (view.equals(this.a.b())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    TbadkApplication.m252getInst().setTiebaHelperOpen(true);
                    com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("hao123");
                    if (a != null && (hao123Plugin2 = (Hao123Plugin) a.a(Hao123Plugin.class)) != null) {
                        hao123Plugin2.openFloating(this);
                    }
                    if (TbadkApplication.isLogin() && !this.c) {
                        this.c = true;
                        new com.baidu.tieba.model.n().a(true);
                    }
                    com.baidu.tbadk.core.f.a(this, "tb_zs_setting");
                    return;
                }
                TbadkApplication.m252getInst().setTiebaHelperOpen(false);
                com.baidu.tbadk.pluginArch.c a2 = com.baidu.tbadk.pluginArch.d.a().a("hao123");
                if (a2 != null && (hao123Plugin = (Hao123Plugin) a2.a(Hao123Plugin.class)) != null) {
                    hao123Plugin.closeFloating(this);
                }
            }
        }
    }
}
