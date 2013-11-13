package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.ch;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, ch> {

    /* renamed from: a  reason: collision with root package name */
    ap f2354a;
    final /* synthetic */ TiebaSyncService b;

    private r(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.f2354a = null;
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
            this.f2354a = new ap(com.baidu.tieba.data.h.f1196a + "c/s/sync");
            this.f2354a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f2354a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().P() > 0) {
                this.f2354a.a("_msg_status", SocialConstants.FALSE);
            } else {
                this.f2354a.a("_msg_status", SocialConstants.TRUE);
            }
            String aG = TiebaApplication.g().aG();
            if (aG != null) {
                if (aG.length() < 1) {
                    aG = SocialConstants.FALSE;
                }
                this.f2354a.a("_active", aG);
            }
            this.f2354a.a("_pic_quality", String.valueOf(TiebaApplication.g().aj()));
            str = TiebaSyncService.f2336a;
            if (str != null) {
                ap apVar = this.f2354a;
                str2 = TiebaSyncService.f2336a;
                apVar.a("_msg_type", str2);
            }
            String j = this.f2354a.j();
            if (this.f2354a.d()) {
                TiebaApplication.g().aI();
            }
            if (this.f2354a.c()) {
                chVar = new ch();
                try {
                    chVar.a(j);
                    if (TiebaApplication.N() == null && chVar.d().a() != null && chVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, chVar.d().a());
                        TiebaApplication.n(chVar.d().a());
                    }
                    String unused = TiebaSyncService.f2336a = null;
                    return chVar;
                } catch (Exception e2) {
                    e = e2;
                    bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        if (this.f2354a != null) {
            this.f2354a.h();
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
        int ar;
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
                TiebaApplication g = TiebaApplication.g();
                chVar3 = this.b.d;
                g.a(chVar3.c());
                this.b.c();
                chVar4 = this.b.d;
                if (chVar4.c().getForce_update() == 1) {
                    TiebaApplication g2 = TiebaApplication.g();
                    chVar7 = this.b.d;
                    VersionData c = chVar7.c();
                    chVar8 = this.b.d;
                    UpdateDialog.a(g2, c, chVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.g().I());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > Util.MILLSECONDS_OF_DAY) {
                        TiebaApplication.g().a(valueOf2.longValue());
                        TiebaApplication g3 = TiebaApplication.g();
                        chVar5 = this.b.d;
                        VersionData c2 = chVar5.c();
                        chVar6 = this.b.d;
                        UpdateDialog.a(g3, c2, chVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a2 = chVar.a().a();
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
