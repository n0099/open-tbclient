package com.baidu.tieba.kn.shake;

import android.graphics.Bitmap;
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.ag;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1259a;
    private final /* synthetic */ int b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VoteResultActivity voteResultActivity, int i, String str) {
        this.f1259a = voteResultActivity;
        this.b = i;
        this.c = str;
    }

    @Override // com.baidu.tieba.util.ag
    public void a(Bitmap bitmap) {
        q qVar;
        q qVar2;
        qVar = this.f1259a.f1244a;
        qVar.c();
        qVar2 = this.f1259a.f1244a;
        qVar2.f();
        if (bitmap == null) {
            this.f1259a.c(R.string.neterror);
        } else if (this.b == 4 || this.b == 3) {
            aa.a(this.f1259a).a(this.b, bitmap);
        } else {
            aa.a(this.f1259a).a(this.b, this.c, bitmap, this.f1259a.getString(R.string.share_iamge_title_default));
        }
    }
}
