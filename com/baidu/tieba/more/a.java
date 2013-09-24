package com.baidu.tieba.more;

import com.baidu.tieba.guide.NewGuideActivity;
/* loaded from: classes.dex */
class a implements aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AboutActivity f1473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.f1473a = aboutActivity;
    }

    @Override // com.baidu.tieba.more.aa
    public void a(int i) {
        if (i == 0) {
            this.f1473a.finish();
        } else if (i != 1) {
            if (i == 2) {
                NewGuideActivity.a(this.f1473a, 0);
            }
        } else {
            this.f1473a.b();
        }
    }
}
