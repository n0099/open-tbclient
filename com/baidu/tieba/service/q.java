package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.ce;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<String, Integer, ce> {

    /* renamed from: a  reason: collision with root package name */
    z f1800a;
    final /* synthetic */ TiebaSyncService b;

    private q(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.f1800a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(TiebaSyncService tiebaSyncService, q qVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ce a(String... strArr) {
        ce ceVar;
        Exception e;
        String str;
        String str2;
        try {
            this.f1800a = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/sync");
            this.f1800a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f1800a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().Q() > 0) {
                this.f1800a.a("_msg_status", "0");
            } else {
                this.f1800a.a("_msg_status", "1");
            }
            String aE = TiebaApplication.g().aE();
            if (aE != null) {
                if (aE.length() < 1) {
                    aE = "0";
                }
                this.f1800a.a("_active", aE);
            }
            this.f1800a.a("_pic_quality", String.valueOf(TiebaApplication.g().ak()));
            str = TiebaSyncService.f1782a;
            if (str != null) {
                z zVar = this.f1800a;
                str2 = TiebaSyncService.f1782a;
                zVar.a("_msg_type", str2);
            }
            String j = this.f1800a.j();
            if (this.f1800a.d()) {
                TiebaApplication.g().aF();
            }
            if (this.f1800a.c()) {
                ceVar = new ce();
                try {
                    ceVar.a(j);
                    if (TiebaApplication.O() == null && ceVar.d().a() != null && ceVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, ceVar.d().a());
                        TiebaApplication.n(ceVar.d().a());
                    }
                    TiebaSyncService.f1782a = null;
                    return ceVar;
                } catch (Exception e2) {
                    e = e2;
                    av.b(getClass().getName(), "doInBackground", e.getMessage());
                    return ceVar;
                }
            }
            return null;
        } catch (Exception e3) {
            ceVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.f1800a != null) {
            this.f1800a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ce ceVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        ce ceVar2;
        int ar;
        ce ceVar3;
        ce ceVar4;
        ce ceVar5;
        ce ceVar6;
        ce ceVar7;
        ce ceVar8;
        super.a((q) ceVar);
        this.b.b = null;
        if (ceVar != null) {
            this.b.d = ceVar;
            ceVar2 = this.b.d;
            if (ceVar2.c().getHas_new_ver() == 1) {
                TiebaApplication g = TiebaApplication.g();
                ceVar3 = this.b.d;
                g.a(ceVar3.c());
                this.b.c();
                ceVar4 = this.b.d;
                if (ceVar4.c().getForce_update() == 1) {
                    TiebaApplication g2 = TiebaApplication.g();
                    ceVar7 = this.b.d;
                    VersionData c = ceVar7.c();
                    ceVar8 = this.b.d;
                    UpdateDialog.a(g2, c, ceVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.g().J());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > Util.MILLSECONDS_OF_DAY) {
                        TiebaApplication.g().a(valueOf2.longValue());
                        TiebaApplication g3 = TiebaApplication.g();
                        ceVar5 = this.b.d;
                        VersionData c2 = ceVar5.c();
                        ceVar6 = this.b.d;
                        UpdateDialog.a(g3, c2, ceVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a2 = ceVar.a().a();
            if (a2 > 0 && nextInt % a2 == 0 && (ar = TiebaApplication.g().ar()) < 10) {
                TiebaApplication.g().l(ar + 1);
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
