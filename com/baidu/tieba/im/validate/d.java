package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity biR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.biR = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: m */
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        r rVar;
        boolean z;
        r rVar2;
        int i;
        rVar = this.biR.biL;
        rVar.setData(l.o(linkedList));
        if (linkedList != null) {
            ValidateActivity validateActivity = this.biR;
            i = validateActivity.offset;
            validateActivity.offset = i + linkedList.size();
        }
        z = this.biR.biO;
        if (!z) {
            rVar2 = this.biR.biL;
            rVar2.dg(false);
        }
        this.biR.isLoading = false;
    }
}
