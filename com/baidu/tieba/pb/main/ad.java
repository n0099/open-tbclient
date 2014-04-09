package com.baidu.tieba.pb.main;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
final class ad implements com.baidu.tbadk.core.dialog.g {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.g
    public final void a(com.baidu.tbadk.core.dialog.d dVar, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        bf bfVar;
        String str5;
        String str6;
        String str7;
        bf bfVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.a(this.a, "pb_phone_call", "call");
            PbActivity pbActivity = this.a;
            str6 = this.a.I;
            pbActivity.I = str6.trim();
            PbActivity pbActivity2 = this.a;
            str7 = this.a.I;
            Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str7));
            intent.addFlags(268435456);
            try {
                pbActivity2.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                com.baidu.adp.lib.util.f.b(e.getMessage());
            } catch (SecurityException e2) {
                com.baidu.adp.lib.util.f.b(e2.getMessage());
            }
            bfVar2 = this.a.x;
            String f = bfVar2.f();
            str8 = this.a.I;
            new a(f, str8, "1").start();
            dVar.c();
        } else if (i == 1) {
            TiebaStatic.a(this.a, "pb_phone_sms", "sms");
            PbActivity pbActivity3 = this.a;
            str3 = this.a.I;
            pbActivity3.I = str3.trim();
            PbActivity pbActivity4 = this.a;
            str4 = this.a.I;
            Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str4));
            intent2.putExtra("sms_body", "");
            intent2.addFlags(268435456);
            try {
                pbActivity4.startActivity(intent2);
            } catch (ActivityNotFoundException e3) {
                com.baidu.adp.lib.util.f.b(e3.getMessage());
            } catch (SecurityException e4) {
                com.baidu.adp.lib.util.f.b(e4.getMessage());
            }
            bfVar = this.a.x;
            String f2 = bfVar.f();
            str5 = this.a.I;
            new a(f2, str5, "2").start();
            dVar.c();
        } else if (i == 2) {
            PbActivity pbActivity5 = this.a;
            str = this.a.I;
            pbActivity5.I = str.trim();
            PbActivity pbActivity6 = this.a;
            str2 = this.a.I;
            com.baidu.tieba.util.r.b(pbActivity6, str2);
            dVar.c();
        }
    }
}
