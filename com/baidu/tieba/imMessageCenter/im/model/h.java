package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.DealInfoIMData;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.l;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends s<Boolean> {
    final /* synthetic */ PersonalMsglistModel dyo;
    private final /* synthetic */ String dyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalMsglistModel personalMsglistModel, String str) {
        this.dyo = personalMsglistModel;
        this.dyq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        boolean z;
        LinkedHashMap<String, String> a = l.auQ().a(this.dyo.getUser().getUserId(), 26, "", 0);
        if (a == null) {
            z = true;
        } else {
            z = true;
            for (String str : a.keySet()) {
                DealInfoIMData parseData = DealInfoIMData.parseData(a.get(str));
                if (parseData != null && parseData.orderId.equals(this.dyq)) {
                    z = false;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
