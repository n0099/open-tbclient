package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.cc;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.aq;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.v f1728a;
    final /* synthetic */ TiebaSyncService b;

    private s(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.f1728a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(TiebaSyncService tiebaSyncService, s sVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public cc a(String... strArr) {
        cc ccVar;
        Exception e;
        String str;
        String str2;
        try {
            this.f1728a = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/sync");
            this.f1728a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f1728a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().S() > 0) {
                this.f1728a.a("_msg_status", "0");
            } else {
                this.f1728a.a("_msg_status", "1");
            }
            String aE = TiebaApplication.g().aE();
            if (aE != null) {
                if (aE.length() < 1) {
                    aE = "0";
                }
                this.f1728a.a("_active", aE);
            }
            this.f1728a.a("_pic_quality", String.valueOf(TiebaApplication.g().ai()));
            str = TiebaSyncService.f1708a;
            if (str != null) {
                com.baidu.tieba.util.v vVar = this.f1728a;
                str2 = TiebaSyncService.f1708a;
                vVar.a("_msg_type", str2);
            }
            String j = this.f1728a.j();
            if (this.f1728a.d()) {
                TiebaApplication.g().aF();
            }
            if (this.f1728a.c()) {
                ccVar = new cc();
                try {
                    ccVar.a(j);
                    if (TiebaApplication.Q() == null && ccVar.d().a() != null && ccVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, ccVar.d().a());
                        TiebaApplication.n(ccVar.d().a());
                    }
                    TiebaSyncService.f1708a = null;
                    return ccVar;
                } catch (Exception e2) {
                    e = e2;
                    aq.b(getClass().getName(), "doInBackground", e.getMessage());
                    return ccVar;
                }
            }
            return null;
        } catch (Exception e3) {
            ccVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.f1728a != null) {
            this.f1728a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(cc ccVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        cc ccVar2;
        int ap;
        cc ccVar3;
        cc ccVar4;
        cc ccVar5;
        cc ccVar6;
        cc ccVar7;
        cc ccVar8;
        super.a((Object) ccVar);
        this.b.b = null;
        if (ccVar != null) {
            this.b.d = ccVar;
            ccVar2 = this.b.d;
            if (ccVar2.c().getHas_new_ver() == 1) {
                TiebaApplication g = TiebaApplication.g();
                ccVar3 = this.b.d;
                g.a(ccVar3.c());
                this.b.c();
                ccVar4 = this.b.d;
                if (ccVar4.c().getForce_update() == 1) {
                    TiebaApplication g2 = TiebaApplication.g();
                    ccVar7 = this.b.d;
                    VersionData c = ccVar7.c();
                    ccVar8 = this.b.d;
                    UpdateDialog.a(g2, c, ccVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.g().L());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > Util.MILLSECONDS_OF_DAY) {
                        TiebaApplication.g().b(valueOf2.longValue());
                        TiebaApplication g3 = TiebaApplication.g();
                        ccVar5 = this.b.d;
                        VersionData c2 = ccVar5.c();
                        ccVar6 = this.b.d;
                        UpdateDialog.a(g3, c2, ccVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a2 = ccVar.a().a();
            if (a2 > 0 && nextInt % a2 == 0 && (ap = TiebaApplication.g().ap()) < 10) {
                TiebaApplication.g().j(ap + 1);
                UtilHelper.e(this.b);
            }
            this.b.stopSelf();
            return;
        }
        TiebaSyncService tiebaSyncService = this.b;
        i = tiebaSyncService.c;
        tiebaSyncService.c = i + 1;
        i2 = this.b.c;
        if (i2 < 10) {
            handler = this.b.e;
            runnable = this.b.f;
            handler.removeCallbacks(runnable);
            handler2 = this.b.e;
            runnable2 = this.b.f;
            handler2.postDelayed(runnable2, Util.MILLSECONDS_OF_MINUTE);
            return;
        }
        this.b.stopSelf();
    }
}
