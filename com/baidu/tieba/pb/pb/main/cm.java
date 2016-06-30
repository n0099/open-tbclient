package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class cm extends cn {
    /* JADX INFO: Access modifiers changed from: protected */
    public cm(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.cn
    protected PbRecBaseViewHolder bf(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aUI().n(this.mContext, 3);
    }
}
