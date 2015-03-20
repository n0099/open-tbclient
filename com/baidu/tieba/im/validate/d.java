package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ValidateModel;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity bnG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.bnG = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        p pVar;
        boolean z;
        p pVar2;
        int i;
        pVar = this.bnG.bnA;
        pVar.setData(ValidateModel.convertToValidateItemDataList(linkedList));
        if (linkedList != null) {
            ValidateActivity validateActivity = this.bnG;
            i = validateActivity.offset;
            validateActivity.offset = i + linkedList.size();
        }
        z = this.bnG.bnD;
        if (!z) {
            pVar2 = this.bnG.bnA;
            pVar2.setLoadProgressBarVisable(false);
        }
        this.bnG.amT = false;
    }
}
