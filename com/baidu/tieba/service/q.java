package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.bw;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ba;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<String, Integer, bw> {
    ba a;
    final /* synthetic */ TiebaSyncService b;

    private q(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(TiebaSyncService tiebaSyncService, q qVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bw a(String... strArr) {
        bw bwVar;
        Exception e;
        String str;
        String str2;
        try {
            this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(BdUtilHelper.b(TiebaApplication.g().b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(BdUtilHelper.c(TiebaApplication.g().b())));
            this.a.a("_phone_screen", stringBuffer.toString());
            this.a.a("scr_w", String.valueOf(BdUtilHelper.b(TiebaApplication.g().b())));
            this.a.a("scr_h", String.valueOf(BdUtilHelper.c(TiebaApplication.g().b())));
            this.a.a("scr_dip", String.valueOf(BdUtilHelper.d(TiebaApplication.g().b())));
            if (TiebaApplication.g().M() > 0) {
                this.a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.a.a("_msg_status", SocialConstants.TRUE);
            }
            String aG = TiebaApplication.g().aG();
            if (aG != null) {
                if (aG.length() < 1) {
                    aG = SocialConstants.FALSE;
                }
                this.a.a("_active", aG);
            }
            this.a.a("_pic_quality", String.valueOf(TiebaApplication.g().af()));
            str = TiebaSyncService.a;
            if (str != null) {
                ba baVar = this.a;
                str2 = TiebaSyncService.a;
                baVar.a("_msg_type", str2);
            }
            String m = this.a.m();
            if (this.a.e()) {
                TiebaApplication.g().aI();
            }
            if (this.a.d()) {
                bwVar = new bw();
                try {
                    bwVar.a(m);
                    if (TiebaApplication.K() == null && bwVar.d().a() != null && bwVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, bwVar.d().a());
                        TiebaApplication.m(bwVar.d().a());
                    }
                    TiebaSyncService.a = null;
                    return bwVar;
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                    return bwVar;
                }
            }
            return null;
        } catch (Exception e3) {
            bwVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.k();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bw bwVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bw bwVar2;
        bw bwVar3;
        int an;
        bw bwVar4;
        bw bwVar5;
        bw bwVar6;
        bw bwVar7;
        bw bwVar8;
        bw bwVar9;
        super.a((q) bwVar);
        this.b.b = null;
        if (bwVar != null) {
            this.b.d = bwVar;
            bwVar2 = this.b.d;
            if (bwVar2.c().getHas_new_ver() == 1) {
                TiebaApplication g = TiebaApplication.g();
                bwVar4 = this.b.d;
                g.a(bwVar4.c());
                this.b.c();
                bwVar5 = this.b.d;
                if (bwVar5.c().getForce_update() == 1) {
                    Application b = TiebaApplication.g().b();
                    bwVar8 = this.b.d;
                    VersionData c = bwVar8.c();
                    bwVar9 = this.b.d;
                    UpdateDialog.a(b, c, bwVar9.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.g().G());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                        TiebaApplication.g().a(valueOf2.longValue());
                        Application b2 = TiebaApplication.g().b();
                        bwVar6 = this.b.d;
                        VersionData c2 = bwVar6.c();
                        bwVar7 = this.b.d;
                        UpdateDialog.a(b2, c2, bwVar7.b());
                    }
                }
            }
            com.baidu.tieba.data.emotions.l a = com.baidu.tieba.data.emotions.l.a();
            bwVar3 = this.b.d;
            a.a(bwVar3.e());
            int nextInt = new Random().nextInt(10000) + 1;
            int a2 = bwVar.a().a();
            if (a2 > 0 && nextInt % a2 == 0 && (an = TiebaApplication.g().an()) < 10) {
                TiebaApplication.g().h(an + 1);
                UtilHelper.d(this.b);
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
            handler2.postDelayed(runnable2, 60000L);
            return;
        }
        this.b.stopSelf();
    }
}
