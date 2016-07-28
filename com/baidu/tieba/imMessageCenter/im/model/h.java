package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.DealInfoIMData;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends t<Boolean> {
    final /* synthetic */ PersonalMsglistModel dfF;
    private final /* synthetic */ String dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalMsglistModel personalMsglistModel, String str) {
        this.dfF = personalMsglistModel;
        this.dfH = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        boolean z;
        LinkedHashMap<String, String> a = l.anF().a(this.dfF.getUser().getUserId(), 26, "", 0);
        if (a == null) {
            z = true;
        } else {
            z = true;
            for (String str : a.keySet()) {
                DealInfoIMData parseData = DealInfoIMData.parseData(a.get(str));
                if (parseData != null && parseData.orderId.equals(this.dfH)) {
                    z = false;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
