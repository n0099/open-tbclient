package com.baidu.tieba.kn.ladders;

import com.baidu.tieba.kn.ladders.KnLaddersModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1217a;
    private final /* synthetic */ KnLaddersModel.PlayerInfo b;
    private final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, KnLaddersModel.PlayerInfo playerInfo, h hVar) {
        this.f1217a = aVar;
        this.b = playerInfo;
        this.c = hVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (str.equals(this.b.big_head_url)) {
            this.c.c.invalidate();
        }
    }
}
