package com.baidu.tieba.kn.shake;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1819a;
    final /* synthetic */ TbImageView b;
    final /* synthetic */ VoteResultActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VoteResultActivity voteResultActivity, String str, TbImageView tbImageView) {
        this.c = voteResultActivity;
        this.f1819a = str;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (this.f1819a.equals(str)) {
            this.b.setTag(str);
            this.b.invalidate();
        }
    }
}
