package com.baidu.tieba.pb.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
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
        com.baidu.tieba.data.u uVar;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        com.baidu.tieba.data.u uVar4;
        com.baidu.tieba.data.u uVar5;
        com.baidu.tieba.data.u uVar6;
        com.baidu.tieba.data.u uVar7;
        r rVar;
        com.baidu.tieba.data.u uVar8;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra >= 0) {
            this.this$0.I = intExtra;
            uVar4 = this.this$0.F;
            if (uVar4 != null) {
                int i3 = intExtra + 5;
                uVar5 = this.this$0.F;
                if (i3 >= uVar5.g().size()) {
                    uVar6 = this.this$0.F;
                    int size = uVar6.g().size();
                    uVar7 = this.this$0.F;
                    if (size != uVar7.j()) {
                        rVar = this.this$0.b;
                        if (rVar == null) {
                            ImagePbActivity imagePbActivity = this.this$0;
                            uVar8 = this.this$0.F;
                            imagePbActivity.a(uVar8.k(), 0, 10, false);
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
            uVar = this.this$0.F;
            if (i2 >= uVar.j() - 1) {
                uVar2 = this.this$0.F;
                int size2 = uVar2.g().size();
                uVar3 = this.this$0.F;
                if (size2 != uVar3.j()) {
                    return;
                }
            } else {
                return;
            }
        }
        int intExtra2 = intent.getIntExtra("state", -1);
        this.this$0.a(intExtra2);
        BdLog.i(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
    }
}
