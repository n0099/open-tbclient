package com.baidu.tieba.kn.shake;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoteResultActivity f1291a;
    private final /* synthetic */ String b;
    private final /* synthetic */ TbImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(VoteResultActivity voteResultActivity, String str, TbImageView tbImageView) {
        this.f1291a = voteResultActivity;
        this.b = str;
        this.c = tbImageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (this.b.equals(str)) {
            this.c.setTag(str);
            this.c.invalidate();
        }
    }
}
