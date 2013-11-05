package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.co;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, co> {

    /* renamed from: a  reason: collision with root package name */
    ag f2321a;
    final /* synthetic */ TiebaSyncService b;

    private r(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.f2321a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(TiebaSyncService tiebaSyncService, q qVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public co a(String... strArr) {
        co coVar;
        Exception e;
        String str;
        String str2;
        try {
            this.f2321a = new ag(com.baidu.tieba.data.h.f1165a + "c/s/sync");
            this.f2321a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f2321a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().R() > 0) {
                this.f2321a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.f2321a.a("_msg_status", SocialConstants.TRUE);
            }
            String aJ = TiebaApplication.g().aJ();
            if (aJ != null) {
                if (aJ.length() < 1) {
                    aJ = SocialConstants.FALSE;
                }
                this.f2321a.a("_active", aJ);
            }
            this.f2321a.a("_pic_quality", String.valueOf(TiebaApplication.g().am()));
            str = TiebaSyncService.f2303a;
            if (str != null) {
                ag agVar = this.f2321a;
                str2 = TiebaSyncService.f2303a;
                agVar.a("_msg_type", str2);
            }
            String j = this.f2321a.j();
            if (this.f2321a.d()) {
                TiebaApplication.g().aK();
            }
            if (this.f2321a.c()) {
                coVar = new co();
                try {
                    coVar.a(j);
                    if (TiebaApplication.P() == null && coVar.d().a() != null && coVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, coVar.d().a());
                        TiebaApplication.n(coVar.d().a());
                    }
                    String unused = TiebaSyncService.f2303a = null;
                    return coVar;
                } catch (Exception e2) {
                    e = e2;
                    be.b(getClass().getName(), "doInBackground", e.getMessage());
                    return coVar;
                }
            }
            return null;
        } catch (Exception e3) {
            coVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.f2321a != null) {
            this.f2321a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(co coVar) {
        int i;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        co coVar2;
        int au;
        co coVar3;
        co coVar4;
        co coVar5;
        co coVar6;
        co coVar7;
        co coVar8;
        super.a((r) coVar);
        this.b.b = null;
        if (coVar != null) {
            this.b.d = coVar;
            coVar2 = this.b.d;
            if (coVar2.c().getHas_new_ver() == 1) {
                TiebaApplication g = TiebaApplication.g();
                coVar3 = this.b.d;
                g.a(coVar3.c());
                this.b.c();
                coVar4 = this.b.d;
                if (coVar4.c().getForce_update() == 1) {
                    TiebaApplication g2 = TiebaApplication.g();
                    coVar7 = this.b.d;
                    VersionData c = coVar7.c();
                    coVar8 = this.b.d;
                    UpdateDialog.a(g2, c, coVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.g().K());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > Util.MILLSECONDS_OF_DAY) {
                        TiebaApplication.g().a(valueOf2.longValue());
                        TiebaApplication g3 = TiebaApplication.g();
                        coVar5 = this.b.d;
                        VersionData c2 = coVar5.c();
                        coVar6 = this.b.d;
                        UpdateDialog.a(g3, c2, coVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a2 = coVar.a().a();
            if (a2 > 0 && nextInt % a2 == 0 && (au = TiebaApplication.g().au()) < 10) {
                TiebaApplication.g().l(au + 1);
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
