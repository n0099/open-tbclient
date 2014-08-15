package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements CustomMessageTask.CustomRunnable<Object> {
    public static final List<String> a(List<com.baidu.adp.lib.cache.v<String>> list) {
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (com.baidu.adp.lib.cache.v<String> vVar : list) {
                String str = vVar.a;
                if (!TextUtils.isEmpty(str)) {
                    linkedList.add(str);
                }
            }
        }
        return linkedList;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestSearchPersonHistoryReadMessage)) {
            return null;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        List<String> a = a(com.baidu.adp.lib.util.o.a(com.baidu.tbadk.core.a.a.a().b("tb.searchperson_history", currentAccount)));
        ResponseSearchPersonHistoryReadMessage responseSearchPersonHistoryReadMessage = new ResponseSearchPersonHistoryReadMessage();
        responseSearchPersonHistoryReadMessage.datas.addAll(a);
        return responseSearchPersonHistoryReadMessage;
    }
}
