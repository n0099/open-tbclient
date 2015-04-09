package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ValidateModel;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity bnW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.bnW = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        p pVar;
        boolean z;
        p pVar2;
        int i;
        pVar = this.bnW.bnQ;
        pVar.setData(ValidateModel.convertToValidateItemDataList(linkedList));
        if (linkedList != null) {
            ValidateActivity validateActivity = this.bnW;
            i = validateActivity.offset;
            validateActivity.offset = i + linkedList.size();
        }
        z = this.bnW.bnT;
        if (!z) {
            pVar2 = this.bnW.bnQ;
            pVar2.setLoadProgressBarVisable(false);
        }
        this.bnW.anb = false;
    }
}
