package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class bv extends bw {
    /* JADX INFO: Access modifiers changed from: protected */
    public bv(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.bw
    protected PbRecBaseViewHolder ad(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.avO().l(this.mContext, 3);
    }
}
