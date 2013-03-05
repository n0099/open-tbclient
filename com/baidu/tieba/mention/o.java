package com.baidu.tieba.mention;

import android.content.DialogInterface;
import com.baidu.tieba.pb.PbActivity;
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ h a;
    private com.baidu.tieba.a.p b = null;

    public o(h hVar) {
        this.a = hVar;
    }

    public void a(com.baidu.tieba.a.p pVar) {
        this.b = pVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.e eVar;
        com.baidu.tieba.e eVar2;
        if (this.b != null) {
            switch (i) {
                case 0:
                    if (!this.b.j()) {
                        eVar2 = this.a.b;
                        PostActivity.a(eVar2, this.b.g(), this.b.h(), "mention");
                        return;
                    }
                    this.a.b(this.b);
                    return;
                case 1:
                    if (this.b.j()) {
                        this.a.a(this.b.g(), this.b.h(), this.b.i() != null ? this.b.i().b() : null, 2);
                        return;
                    } else {
                        this.a.a(this.b.g(), this.b.h(), null, 1);
                        return;
                    }
                case 2:
                    eVar = this.a.b;
                    PbActivity.a(eVar, this.b.g(), "mention");
                    return;
                default:
                    return;
            }
        }
    }
}
