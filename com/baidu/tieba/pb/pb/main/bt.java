package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class bt extends bu {
    /* JADX INFO: Access modifiers changed from: protected */
    public bt(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.bu
    protected PbRecBaseViewHolder J(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aqc().l(this.mContext, 3);
    }
}
