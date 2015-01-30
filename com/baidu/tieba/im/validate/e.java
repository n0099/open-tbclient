package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ValidateModel;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity bpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ValidateActivity validateActivity) {
        this.bpQ = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        m mVar;
        boolean z;
        m mVar2;
        int i;
        mVar = this.bpQ.bpK;
        mVar.setData(ValidateModel.convertToValidateItemDataList(linkedList));
        if (linkedList != null) {
            ValidateActivity validateActivity = this.bpQ;
            i = validateActivity.offset;
            validateActivity.offset = i + linkedList.size();
        }
        z = this.bpQ.bpN;
        if (!z) {
            mVar2 = this.bpQ.bpK;
            mVar2.setLoadProgressBarVisable(false);
        }
        this.bpQ.aeC = false;
    }
}
