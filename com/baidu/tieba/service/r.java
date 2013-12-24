package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.ch;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.an;
import com.baidu.tieba.util.be;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, ch> {
    an a;
    final /* synthetic */ TiebaSyncService b;

    private r(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(TiebaSyncService tiebaSyncService, q qVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ch a(String... strArr) {
        ch chVar;
        Exception e;
        String str;
        String str2;
        try {
            this.a = new an(com.baidu.tieba.data.h.a + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.b(TiebaApplication.h())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.c(TiebaApplication.h())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.h().N() > 0) {
                this.a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.a.a("_msg_status", SocialConstants.TRUE);
            }
            String aJ = TiebaApplication.h().aJ();
            if (aJ != null) {
                if (aJ.length() < 1) {
                    aJ = SocialConstants.FALSE;
                }
                this.a.a("_active", aJ);
            }
            this.a.a("_pic_quality", String.valueOf(TiebaApplication.h().ah()));
            str = TiebaSyncService.a;
            if (str != null) {
                an anVar = this.a;
                str2 = TiebaSyncService.a;
                anVar.a("_msg_type", str2);
            }
            String l = this.a.l();
            if (this.a.d()) {
                TiebaApplication.h().aL();
            }
            if (this.a.c()) {
                chVar = new ch();
                try {
                    chVar.a(l);
                    if (TiebaApplication.L() == null && chVar.d().a() != null && chVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, chVar.d().a());
                        TiebaApplication.o(chVar.d().a());
                    }
                    String unused = TiebaSyncService.a = null;
                    return chVar;
                } catch (Exception e2) {
                    e = e2;
                    be.b(getClass().getName(), "doInBackground", e.getMessage());
                    return chVar;
                }
            }
            return null;
        } catch (Exception e3) {
            chVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ch chVar) {
        int i;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        ch chVar2;
        int ap;
        ch chVar3;
        ch chVar4;
        ch chVar5;
        ch chVar6;
        ch chVar7;
        ch chVar8;
        super.a((r) chVar);
        this.b.b = null;
        if (chVar != null) {
            this.b.d = chVar;
            chVar2 = this.b.d;
            if (chVar2.c().getHas_new_ver() == 1) {
                TiebaApplication h = TiebaApplication.h();
                chVar3 = this.b.d;
                h.a(chVar3.c());
                this.b.c();
                chVar4 = this.b.d;
                if (chVar4.c().getForce_update() == 1) {
                    TiebaApplication h2 = TiebaApplication.h();
                    chVar7 = this.b.d;
                    VersionData c = chVar7.c();
                    chVar8 = this.b.d;
                    UpdateDialog.a(h2, c, chVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.h().H());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                        TiebaApplication.h().a(valueOf2.longValue());
                        TiebaApplication h3 = TiebaApplication.h();
                        chVar5 = this.b.d;
                        VersionData c2 = chVar5.c();
                        chVar6 = this.b.d;
                        UpdateDialog.a(h3, c2, chVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(10000) + 1;
            int a = chVar.a().a();
            if (a > 0 && nextInt % a == 0 && (ap = TiebaApplication.h().ap()) < 10) {
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
            handler2.postDelayed(runnable2, 60000L);
            return;
        }
        this.b.stopSelf();
    }
}
