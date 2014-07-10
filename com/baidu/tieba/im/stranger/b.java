package com.baidu.tieba.im.stranger;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, int i) {
        this.b = str;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.p.d().a(this.b, TbadkApplication.getCurrentAccount(), this.c);
        return null;
    }
}
