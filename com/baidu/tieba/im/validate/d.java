package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.bjf = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: m */
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        r rVar;
        boolean z;
        r rVar2;
        int i;
        rVar = this.bjf.biZ;
        rVar.setData(l.o(linkedList));
        if (linkedList != null) {
            ValidateActivity validateActivity = this.bjf;
            i = validateActivity.offset;
            validateActivity.offset = i + linkedList.size();
        }
        z = this.bjf.bjc;
        if (!z) {
            rVar2 = this.bjf.biZ;
            rVar2.dg(false);
        }
        this.bjf.isLoading = false;
    }
}
