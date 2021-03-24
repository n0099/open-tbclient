package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.AboutModel;
import d.b.b.a.e;
import d.b.i0.u2.c.d;
import d.b.i0.u2.c.i;
import java.util.Date;
/* loaded from: classes5.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    public d.b.i0.u2.c.j.a collectorManager;
    public AboutModel mModel;
    public d.b.i0.u2.c.a mView;
    public i mVisitPreviewServerDialog;
    public c receiver = null;
    public String functionIntroUrl = TbConfig.SERVER_ADDRESS_WEB_VIEW + TbConfig.FUNCTION_INTRO_WEBVIEW;
    public int REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON = 1;

    /* loaded from: classes5.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.b.i0.u2.c.d
        public void a(int i) {
            String str;
            String fileDireciory;
            if (i == 0) {
                AboutActivity.this.finish();
            } else if (i == 1) {
                AboutActivity.this.checkUpdata();
            } else if (i == 2) {
                AboutActivity.this.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
            } else if (i == 3) {
                d.b.h0.r.d0.b.i().s(SettingTextFunctionIntroView.m, true);
                d.b.h0.l.a.o(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.functionIntroUrl, true, false, false);
            } else if (i != 4) {
                if (i == 5) {
                    if (AboutActivity.this.mVisitPreviewServerDialog == null) {
                        AboutActivity aboutActivity = AboutActivity.this;
                        aboutActivity.mVisitPreviewServerDialog = new i(aboutActivity.getActivity());
                        AboutActivity.this.mVisitPreviewServerDialog.create(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.mVisitPreviewServerDialog.show();
                } else if (i == 6) {
                    if (PermissionUtil.checkWriteExternalStorage(AboutActivity.this)) {
                        AboutActivity.this.startCollectLog();
                        return;
                    }
                    AboutActivity aboutActivity2 = AboutActivity.this;
                    PermissionUtil.requestWriteExternalStorgePermission(aboutActivity2, aboutActivity2.REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON);
                }
            } else {
                if (TbConfig.getDebugSwitch()) {
                    str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_DEBUG_FILE;
                } else {
                    str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE;
                }
                if (TbConfig.getDebugSwitch()) {
                    fileDireciory = FileHelper.getFileDireciory(TbConfig.FATAL_ERROR_DEBUG_FILE);
                } else {
                    fileDireciory = FileHelper.getFileDireciory(TbConfig.FATAL_ERROR_FILE);
                }
                FileHelper.copyFile(str, fileDireciory);
                FileHelper.CopyDir(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/newStat", FileHelper.getCacheDir() + "newStat", false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends e {
        public b() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            AboutActivity.this.handlCallBack(obj);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.mView != null) {
                AboutActivity.this.mView.s();
            }
        }

        public /* synthetic */ c(AboutActivity aboutActivity, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        d.b.i0.h1.c.b().a(true);
        AboutModel aboutModel = this.mModel;
        if (aboutModel == null) {
            this.mModel = new AboutModel(this, new b());
        } else {
            aboutModel.cancelLoadData();
        }
        this.mModel.w();
        d.b.i0.u2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlCallBack(Object obj) {
        d.b.i0.u2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.o();
        }
        d.b.h0.s.e.e eVar = obj != null ? (d.b.h0.s.e.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.p());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.p().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.p().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.p(), eVar.h())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.p(), eVar.h()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            }
            d.b.i0.u2.c.a aVar2 = this.mView;
            if (aVar2 != null) {
                aVar2.s();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    private void regReceiver() {
        this.receiver = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.receiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCollectLog() {
        if (this.collectorManager.d()) {
            return;
        }
        this.collectorManager.g();
    }

    private void unregReceiver() {
        c cVar = this.receiver;
        if (cVar != null) {
            unregisterReceiver(cVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.u2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.v(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.collectorManager = new d.b.i0.u2.c.j.a(this);
        d.b.i0.u2.c.a aVar = new d.b.i0.u2.c.a(this, new a());
        this.mView = aVar;
        aVar.s();
        regReceiver();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        AboutModel aboutModel = this.mModel;
        if (aboutModel != null) {
            aboutModel.cancelLoadData();
        }
        d.b.i0.u2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.o();
        }
        i iVar = this.mVisitPreviewServerDialog;
        if (iVar != null) {
            iVar.dismiss();
        }
        d.b.i0.u2.c.j.a aVar2 = this.collectorManager;
        if (aVar2 != null) {
            aVar2.i();
            this.collectorManager = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == this.REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON) {
            if (PermissionUtil.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                startCollectLog();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.i0.u2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.s();
        }
    }
}
