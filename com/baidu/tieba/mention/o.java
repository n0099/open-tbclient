package com.baidu.tieba.mention;

import android.content.DialogInterface;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ h a;
    private com.baidu.tieba.data.q b = null;

    public o(h hVar) {
        this.a = hVar;
    }

    public void a(com.baidu.tieba.data.q qVar) {
        this.b = qVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (this.b != null) {
            switch (i) {
                case 0:
                    if (!this.b.j()) {
                        gVar2 = this.a.b;
                        NewPbActivity.a(gVar2, this.b.g(), this.b.h(), "mention");
                        return;
                    }
                    this.a.b(this.b);
                    return;
                case 1:
                    if (this.b.j()) {
                        this.a.a(this.b.g(), this.b.h(), this.b.i() != null ? this.b.i().getName() : null, 2);
                        return;
                    } else {
                        this.a.a(this.b.g(), this.b.h(), null, 1);
                        return;
                    }
                case 2:
                    gVar = this.a.b;
                    NewPbActivity.a(gVar, this.b.g(), null, "mention");
                    return;
                default:
                    return;
            }
        }
    }
}
