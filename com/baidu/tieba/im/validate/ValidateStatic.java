package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.IValidateModel;
import com.baidu.tieba.im.model.ValidateModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ValidateStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001287, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.validate.ValidateStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001287, Integer.valueOf(e.f.icon_new_test));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001299, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.validate.ValidateStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001299, new a());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    /* loaded from: classes3.dex */
    static class a implements IValidateModel {
        a() {
        }

        @Override // com.baidu.tieba.im.model.IValidateModel
        public List<ValidateItemData> convertToValidateItemDataList(LinkedList<GroupNewsPojo> linkedList) {
            return ValidateModel.convertToValidateItemDataList(linkedList);
        }

        @Override // com.baidu.tieba.im.model.IValidateModel
        public ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo) {
            return ValidateModel.convertToValidateItemData(groupNewsPojo);
        }
    }
}
