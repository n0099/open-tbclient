package com.baidu.tieba.square.flist;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes5.dex */
public class ForumRankActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2902028, new CustomMessageTask.CustomRunnable<ForumRankActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ForumRankActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ForumRankActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ba.adA().a(new ba.a() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.2
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                String str2 = null;
                if (strArr.length > 2) {
                    str2 = strArr[2];
                }
                if (!StringUtils.isNull(str) && str.startsWith("list:")) {
                    String substring = str.substring(5);
                    if (!TextUtils.isEmpty(substring)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring, str2)));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }
}
