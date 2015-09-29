package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class bh extends bi {
    /* JADX INFO: Access modifiers changed from: protected */
    public bh(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.bi
    protected PbRecBaseViewHolder J(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.apA().l(this.mContext, 3);
    }
}
