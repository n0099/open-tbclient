package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements CustomMessageTask.CustomRunnable<Object> {
    public static final List<String> cW(List<l.b<String>> list) {
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (l.b<String> bVar : list) {
                String str = bVar.key;
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
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        List<String> cW = cW(r.b(com.baidu.tbadk.core.c.a.BB().an("tb.searchperson_history", currentAccount)));
        ResponseSearchPersonHistoryReadMessage responseSearchPersonHistoryReadMessage = new ResponseSearchPersonHistoryReadMessage();
        responseSearchPersonHistoryReadMessage.datas.addAll(cW);
        return responseSearchPersonHistoryReadMessage;
    }
}
