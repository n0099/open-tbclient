package com.baidu.tieba.kn.ladders;

import com.baidu.tieba.kn.ladders.KnLaddersModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnLaddersModel.PlayerInfo f1746a;
    final /* synthetic */ h b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, KnLaddersModel.PlayerInfo playerInfo, h hVar) {
        this.c = aVar;
        this.f1746a = playerInfo;
        this.b = hVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (str.equals(this.f1746a.big_head_url)) {
            this.b.c.invalidate();
        }
    }
}
