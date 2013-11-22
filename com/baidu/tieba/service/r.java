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
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, ci> {

    /* renamed from: a  reason: collision with root package name */
    ap f2339a;
    final /* synthetic */ TiebaSyncService b;

    private r(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.f2339a = null;
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
            this.f2339a = new ap(com.baidu.tieba.data.h.f1201a + "c/s/sync");
            this.f2339a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f2339a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().P() > 0) {
                this.f2339a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.f2339a.a("_msg_status", SocialConstants.TRUE);
            }
            String aI = TiebaApplication.g().aI();
            if (aI != null) {
                if (aI.length() < 1) {
                    aI = SocialConstants.FALSE;
                }
                this.f2339a.a("_active", aI);
            }
            this.f2339a.a("_pic_quality", String.valueOf(TiebaApplication.g().aj()));
            str = TiebaSyncService.f2321a;
            if (str != null) {
                ap apVar = this.f2339a;
                str2 = TiebaSyncService.f2321a;
                apVar.a("_msg_type", str2);
            }
            String l = this.f2339a.l();
            if (this.f2339a.d()) {
                TiebaApplication.g().aK();
            }
            if (this.f2339a.c()) {
                ciVar = new ci();
                try {
                    ciVar.a(l);
                    if (TiebaApplication.N() == null && ciVar.d().a() != null && ciVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, ciVar.d().a());
                        TiebaApplication.n(ciVar.d().a());
                    }
                    String unused = TiebaSyncService.f2321a = null;
                    return ciVar;
                } catch (Exception e2) {
                    e = e2;
                    bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        if (this.f2339a != null) {
            this.f2339a.j();
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
        int ar;
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
                TiebaApplication g = TiebaApplication.g();
                ciVar3 = this.b.d;
                g.a(ciVar3.c());
                this.b.c();
                ciVar4 = this.b.d;
                if (ciVar4.c().getForce_update() == 1) {
                    TiebaApplication g2 = TiebaApplication.g();
                    ciVar7 = this.b.d;
                    VersionData c = ciVar7.c();
                    ciVar8 = this.b.d;
                    UpdateDialog.a(g2, c, ciVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.g().I());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > Util.MILLSECONDS_OF_DAY) {
                        TiebaApplication.g().a(valueOf2.longValue());
                        TiebaApplication g3 = TiebaApplication.g();
                        ciVar5 = this.b.d;
                        VersionData c2 = ciVar5.c();
                        ciVar6 = this.b.d;
                        UpdateDialog.a(g3, c2, ciVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a2 = ciVar.a().a();
            if (a2 > 0 && nextInt % a2 == 0 && (ar = TiebaApplication.g().ar()) < 10) {
                TiebaApplication.g().i(ar + 1);
                UtilHelper.e(this.b);
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
