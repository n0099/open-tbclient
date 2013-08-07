package com.baidu.tieba.kn.shake;

import com.baidu.tieba.view.ImageViewDrawer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1258a;
    private final /* synthetic */ String b;
    private final /* synthetic */ ImageViewDrawer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(VoteResultActivity voteResultActivity, String str, ImageViewDrawer imageViewDrawer) {
        this.f1258a = voteResultActivity;
        this.b = str;
        this.c = imageViewDrawer;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (this.b.equals(str)) {
            this.c.setTag(str);
            this.c.invalidate();
        }
    }
}
