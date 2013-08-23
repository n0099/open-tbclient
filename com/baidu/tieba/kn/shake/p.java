package com.baidu.tieba.kn.shake;

import android.graphics.Bitmap;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.an;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements an {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1292a;
    private final /* synthetic */ int b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VoteResultActivity voteResultActivity, int i, String str) {
        this.f1292a = voteResultActivity;
        this.b = i;
        this.c = str;
    }

    @Override // com.baidu.tieba.util.an
    public void a(Bitmap bitmap) {
        q qVar;
        q qVar2;
        qVar = this.f1292a.f1277a;
        qVar.c();
        qVar2 = this.f1292a.f1277a;
        qVar2.f();
        if (bitmap == null) {
            this.f1292a.c(R.string.neterror);
        } else if (this.b == 4 || this.b == 3) {
            ah.a(this.f1292a).a(this.b, bitmap);
        } else {
            ah.a(this.f1292a).a(this.b, this.c, bitmap, this.f1292a.getString(R.string.share_iamge_title_default));
        }
    }
}
