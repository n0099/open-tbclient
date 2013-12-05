package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.ci;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bd;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, ci> {

    /* renamed from: a  reason: collision with root package name */
    am f2456a;
    final /* synthetic */ TiebaSyncService b;

    private r(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.f2456a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(TiebaSyncService tiebaSyncService, q qVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ci a(String... strArr) {
        ci ciVar;
        Exception e;
        String str;
        String str2;
        try {
            this.f2456a = new am(com.baidu.tieba.data.h.f1248a + "c/s/sync");
            this.f2456a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.b(TiebaApplication.h())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.c(TiebaApplication.h())));
            this.f2456a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.h().N() > 0) {
                this.f2456a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.f2456a.a("_msg_status", SocialConstants.TRUE);
            }
            String aJ = TiebaApplication.h().aJ();
            if (aJ != null) {
                if (aJ.length() < 1) {
                    aJ = SocialConstants.FALSE;
                }
                this.f2456a.a("_active", aJ);
            }
            this.f2456a.a("_pic_quality", String.valueOf(TiebaApplication.h().ah()));
            str = TiebaSyncService.f2438a;
            if (str != null) {
                am amVar = this.f2456a;
                str2 = TiebaSyncService.f2438a;
                amVar.a("_msg_type", str2);
            }
            String l = this.f2456a.l();
            if (this.f2456a.d()) {
                TiebaApplication.h().aL();
            }
            if (this.f2456a.c()) {
                ciVar = new ci();
                try {
                    ciVar.a(l);
                    if (TiebaApplication.L() == null && ciVar.d().a() != null && ciVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, ciVar.d().a());
                        TiebaApplication.o(ciVar.d().a());
                    }
                    String unused = TiebaSyncService.f2438a = null;
                    return ciVar;
                } catch (Exception e2) {
                    e = e2;
                    bd.b(getClass().getName(), "doInBackground", e.getMessage());
                    return ciVar;
                }
            }
            return null;
        } catch (Exception e3) {
            ciVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.f2456a != null) {
            this.f2456a.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ci ciVar) {
        int i;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        ci ciVar2;
        int ap;
        ci ciVar3;
        ci ciVar4;
        ci ciVar5;
        ci ciVar6;
        ci ciVar7;
        ci ciVar8;
        super.a((r) ciVar);
        this.b.b = null;
        if (ciVar != null) {
            this.b.d = ciVar;
            ciVar2 = this.b.d;
            if (ciVar2.c().getHas_new_ver() == 1) {
                TiebaApplication h = TiebaApplication.h();
                ciVar3 = this.b.d;
                h.a(ciVar3.c());
                this.b.c();
                ciVar4 = this.b.d;
                if (ciVar4.c().getForce_update() == 1) {
                    TiebaApplication h2 = TiebaApplication.h();
                    ciVar7 = this.b.d;
                    VersionData c = ciVar7.c();
                    ciVar8 = this.b.d;
                    UpdateDialog.a(h2, c, ciVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.h().H());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > Util.MILLSECONDS_OF_DAY) {
                        TiebaApplication.h().a(valueOf2.longValue());
                        TiebaApplication h3 = TiebaApplication.h();
                        ciVar5 = this.b.d;
                        VersionData c2 = ciVar5.c();
                        ciVar6 = this.b.d;
                        UpdateDialog.a(h3, c2, ciVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a2 = ciVar.a().a();
            if (a2 > 0 && nextInt % a2 == 0 && (ap = TiebaApplication.h().ap()) < 10) {
                TiebaApplication.h().h(ap + 1);
                UtilHelper.c(this.b);
            }
            this.b.stopSelf();
            return;
        }
        TiebaSyncService.d(this.b);
        i = this.b.c;
        if (i < 10) {
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
