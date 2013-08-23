package com.baidu.tieba.mention;

import android.content.DialogInterface;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1337a;
    private com.baidu.tieba.data.u b = null;

    public o(i iVar) {
        this.f1337a = iVar;
    }

    public void a(com.baidu.tieba.data.u uVar) {
        this.b = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (this.b != null) {
            switch (i) {
                case 0:
                    if (!this.b.j()) {
                        gVar2 = this.f1337a.b;
                        NewPbActivity.a(gVar2, this.b.g(), this.b.h(), "mention");
                        return;
                    }
                    this.f1337a.a(this.b);
                    return;
                case 1:
                    if (this.b.j()) {
                        this.f1337a.a(this.b.g(), this.b.h(), this.b.i() != null ? this.b.i().getName() : null, 2);
                        return;
                    } else {
                        this.f1337a.a(this.b.g(), this.b.h(), null, 1);
                        return;
                    }
                case 2:
                    gVar = this.f1337a.b;
                    NewPbActivity.a(gVar, this.b.g(), null, "mention");
                    return;
                default:
                    return;
            }
        }
    }
}
