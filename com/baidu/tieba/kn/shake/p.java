package com.baidu.tieba.kn.shake;

import android.graphics.Bitmap;
import com.baidu.tieba.util.au;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ba {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1821a;
    final /* synthetic */ String b;
    final /* synthetic */ VoteResultActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VoteResultActivity voteResultActivity, int i, String str) {
        this.c = voteResultActivity;
        this.f1821a = i;
        this.b = str;
    }

    @Override // com.baidu.tieba.util.ba
    public void a(Bitmap bitmap) {
        q qVar;
        q qVar2;
        qVar = this.c.f1806a;
        qVar.e();
        qVar2 = this.c.f1806a;
        qVar2.h();
        if (bitmap == null) {
            this.c.b(R.string.neterror);
        } else if (this.f1821a == 4 || this.f1821a == 3) {
            au.a(this.c).a(this.f1821a, bitmap);
        } else {
            au.a(this.c).a(this.f1821a, this.b, bitmap, this.c.getString(R.string.share_iamge_title_default));
        }
    }
}
