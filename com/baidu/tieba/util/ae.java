package com.baidu.tieba.util;

import com.baidu.tieba.data.be;
/* loaded from: classes.dex */
class ae implements com.baidu.tieba.model.aj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1750a;
    private final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar, af afVar) {
        this.f1750a = aaVar;
        this.b = afVar;
    }

    @Override // com.baidu.tieba.model.aj
    public void a() {
    }

    @Override // com.baidu.tieba.model.aj
    public void a(be beVar) {
        if (beVar != null && beVar.b() == 0) {
            if (this.b != null) {
                this.b.a(beVar.a());
            }
        } else if (this.b != null) {
            this.b.a(null);
        }
    }
}
