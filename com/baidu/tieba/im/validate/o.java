package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.IValidateModel;
import com.baidu.tieba.im.model.ValidateModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class o implements IValidateModel {
    @Override // com.baidu.tieba.im.model.IValidateModel
    public List<ValidateItemData> convertToValidateItemDataList(LinkedList<GroupNewsPojo> linkedList) {
        return ValidateModel.convertToValidateItemDataList(linkedList);
    }

    @Override // com.baidu.tieba.im.model.IValidateModel
    public ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo) {
        return ValidateModel.convertToValidateItemData(groupNewsPojo);
    }
}
