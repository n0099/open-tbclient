package com.baidu.tieba;
/* loaded from: classes.dex */
class m extends com.baidu.adp.lib.a.a {
    final /* synthetic */ GuideActivity a;

    private m(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(GuideActivity guideActivity, m mVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(String... strArr) {
        return Boolean.valueOf(GuideActivity.g(this.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        if (!bool.booleanValue()) {
            GuideActivity.h(this.a);
        }
    }
}
