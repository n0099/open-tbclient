package com.baidu.tieba.recommend;

import android.content.DialogInterface;
import com.baidu.tieba.a.ax;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {
    final /* synthetic */ GuessActivity a;
    private final /* synthetic */ ax b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GuessActivity guessActivity, ax axVar) {
        this.a = guessActivity;
        this.b = axVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        switch (i) {
            case 0:
                str = this.a.f;
                if (str != null) {
                    GuessActivity guessActivity = this.a;
                    str2 = this.a.f;
                    PbActivity.a(guessActivity, str2, (String) null);
                    return;
                }
                return;
            case 1:
                this.a.c(this.b);
                return;
            case 2:
                this.a.o();
                return;
            default:
                return;
        }
    }
}
