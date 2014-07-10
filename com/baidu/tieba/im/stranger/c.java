package com.baidu.tieba.im.stranger;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ ImMessageCenterPojo b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        this.b = imMessageCenterPojo;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.p.d().a(this.b.getGid(), TbadkApplication.getCurrentAccount(), this.c);
        return null;
    }
}
