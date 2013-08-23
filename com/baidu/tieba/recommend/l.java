package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1687a;
    private final /* synthetic */ TbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar, TbImageView tbImageView) {
        this.f1687a = hVar;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (this.b != null) {
            this.b.invalidate();
        }
    }
}
