package com.baidu.tieba.more;

import com.baidu.tieba.GuideActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AboutActivity f1976a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.f1976a = aboutActivity;
    }

    @Override // com.baidu.tieba.more.ac
    public void a(int i) {
        if (i == 0) {
            this.f1976a.finish();
        } else if (i == 1) {
            this.f1976a.b();
        } else if (i == 2) {
            GuideActivity.a(this.f1976a, 0);
        }
    }
}
