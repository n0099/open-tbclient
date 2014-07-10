package com.baidu.tieba.pb.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BroadcastReceiver {
    final /* synthetic */ ImagePbActivity this$0;

    private u(ImagePbActivity imagePbActivity) {
        this.this$0 = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(ImagePbActivity imagePbActivity, u uVar) {
        this(imagePbActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i;
        int i2;
        com.baidu.tieba.data.w wVar;
        com.baidu.tieba.data.w wVar2;
        com.baidu.tieba.data.w wVar3;
        com.baidu.tieba.data.w wVar4;
        com.baidu.tieba.data.w wVar5;
        com.baidu.tieba.data.w wVar6;
        com.baidu.tieba.data.w wVar7;
        r rVar;
        com.baidu.tieba.data.w wVar8;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra >= 0) {
            this.this$0.I = intExtra;
            wVar4 = this.this$0.F;
            if (wVar4 != null) {
                int i3 = intExtra + 5;
                wVar5 = this.this$0.F;
                if (i3 >= wVar5.g().size()) {
                    wVar6 = this.this$0.F;
                    int size = wVar6.g().size();
                    wVar7 = this.this$0.F;
                    if (size != wVar7.j()) {
                        rVar = this.this$0.b;
                        if (rVar == null) {
                            ImagePbActivity imagePbActivity = this.this$0;
                            wVar8 = this.this$0.F;
                            imagePbActivity.a(wVar8.k(), 0, 10, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        i = this.this$0.I;
        if (i != 0) {
            i2 = this.this$0.I;
            wVar = this.this$0.F;
            if (i2 >= wVar.j() - 1) {
                wVar2 = this.this$0.F;
                int size2 = wVar2.g().size();
                wVar3 = this.this$0.F;
                if (size2 != wVar3.j()) {
                    return;
                }
            } else {
                return;
            }
        }
        this.this$0.a(intent.getIntExtra("state", -1));
    }
}
