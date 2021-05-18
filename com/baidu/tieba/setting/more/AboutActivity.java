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
import d.a.c.a.e;
import d.a.k0.v2.c.d;
import d.a.k0.v2.c.i;
import java.util.Date;
/* loaded from: classes5.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    public d.a.k0.v2.c.j.a collectorManager;
    public AboutModel mModel;
    public d.a.k0.v2.c.a mView;
    public i mVisitPreviewServerDialog;
    public c receiver = null;
    public String functionIntroUrl = TbConfig.SERVER_ADDRESS_WEB_VIEW + TbConfig.FUNCTION_INTRO_WEBVIEW;
    public int REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON = 1;

    /* loaded from: classes5.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.a.k0.v2.c.d
        public void a(int i2) {
            String str;
            String fileDireciory;
            if (i2 == 0) {
                AboutActivity.this.finish();
            } else if (i2 == 1) {
                AboutActivity.this.checkUpdata();
            } else if (i2 == 2) {
                AboutActivity.this.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
            } else if (i2 == 3) {
                d.a.j0.r.d0.b.j().t(SettingTextFunctionIntroView.m, true);
                d.a.j0.l.a.o(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.functionIntroUrl, true, false, false);
            } else if (i2 != 4) {
                if (i2 == 5) {
                    if (AboutActivity.this.mVisitPreviewServerDialog == null) {
                        AboutActivity aboutActivity = AboutActivity.this;
                        aboutActivity.mVisitPreviewServerDialog = new i(aboutActivity.getActivity());
                        AboutActivity.this.mVisitPreviewServerDialog.create(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.mVisitPreviewServerDialog.show();
                } else if (i2 == 6) {
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

        @Override // d.a.c.a.e
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
                AboutActivity.this.mView.t();
            }
        }

        public /* synthetic */ c(AboutActivity aboutActivity, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        d.a.k0.i1.c.b().a(true);
        AboutModel aboutModel = this.mModel;
        if (aboutModel == null) {
            this.mModel = new AboutModel(this, new b());
        } else {
            aboutModel.cancelLoadData();
        }
        this.mModel.w();
        d.a.k0.v2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlCallBack(Object obj) {
        d.a.k0.v2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.p();
        }
        d.a.j0.s.e.e eVar = obj != null ? (d.a.j0.s.e.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.s());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.s().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.s().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.s(), eVar.j())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.s(), eVar.j()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            }
            d.a.k0.v2.c.a aVar2 = this.mView;
            if (aVar2 != null) {
                aVar2.t();
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
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.k0.v2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.v(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.collectorManager = new d.a.k0.v2.c.j.a(this);
        d.a.k0.v2.c.a aVar = new d.a.k0.v2.c.a(this, new a());
        this.mView = aVar;
        aVar.t();
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
        d.a.k0.v2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.p();
        }
        i iVar = this.mVisitPreviewServerDialog;
        if (iVar != null) {
            iVar.dismiss();
        }
        d.a.k0.v2.c.j.a aVar2 = this.collectorManager;
        if (aVar2 != null) {
            aVar2.i();
            this.collectorManager = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == this.REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON) {
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
        d.a.k0.v2.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.t();
        }
    }
}
