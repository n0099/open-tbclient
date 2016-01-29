package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeHttpResponseMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeSocketResponseMessage;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
class k extends com.baidu.adp.framework.listener.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i, int i2) {
        super(i, i2);
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        List<String> list = Collections.EMPTY_LIST;
        if (responsedMessage instanceof GetStoreRemindTimeHttpResponseMessage) {
            list = ((GetStoreRemindTimeHttpResponseMessage) responsedMessage).getTimeList();
        } else if (responsedMessage instanceof GetStoreRemindTimeSocketResponseMessage) {
            list = ((GetStoreRemindTimeSocketResponseMessage) responsedMessage).getTimeList();
        }
        if (!list.isEmpty()) {
            com.baidu.tbadk.core.sharedPref.b.uO().putString("collect_update_time_key", new JSONArray((Collection) list).toString());
            e.ana().ane();
        }
    }
}
