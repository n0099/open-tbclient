package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.DealInfoIMData;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends t<Boolean> {
    final /* synthetic */ PersonalMsglistModel drm;
    private final /* synthetic */ String dro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalMsglistModel personalMsglistModel, String str) {
        this.drm = personalMsglistModel;
        this.dro = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        boolean z;
        LinkedHashMap<String, String> a = l.asu().a(this.drm.getUser().getUserId(), 26, "", 0);
        if (a == null) {
            z = true;
        } else {
            z = true;
            for (String str : a.keySet()) {
                DealInfoIMData parseData = DealInfoIMData.parseData(a.get(str));
                if (parseData != null && parseData.orderId.equals(this.dro)) {
                    z = false;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
