package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ValidateModel;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.bpP = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        m mVar;
        boolean z;
        m mVar2;
        int i;
        mVar = this.bpP.bpJ;
        mVar.setData(ValidateModel.convertToValidateItemDataList(linkedList));
        if (linkedList != null) {
            ValidateActivity validateActivity = this.bpP;
            i = validateActivity.offset;
            validateActivity.offset = i + linkedList.size();
        }
        z = this.bpP.bpM;
        if (!z) {
            mVar2 = this.bpP.bpJ;
            mVar2.setLoadProgressBarVisable(false);
        }
        this.bpP.aez = false;
    }
}
