package com.baidu.tieba.pb.history;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.u;
import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.aj;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<Object> {
    public static final List<aj> a(List<u<String>> list) {
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (u<String> uVar : list) {
                String str = uVar.b;
                aj ajVar = new aj();
                try {
                    if (ajVar.a(new JSONObject(str))) {
                        linkedList.add(ajVar);
                    }
                } catch (JSONException e) {
                }
            }
        }
        return linkedList;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestPbHistoryReadMessage)) {
            return null;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        List<aj> a = a(o.a(com.baidu.tbadk.core.a.b.a().a(currentAccount)));
        ResponsePbHistoryReadMessage responsePbHistoryReadMessage = new ResponsePbHistoryReadMessage();
        responsePbHistoryReadMessage.datas.addAll(a);
        return responsePbHistoryReadMessage;
    }
}
