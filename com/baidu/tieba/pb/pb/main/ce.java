package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class ce extends cf {
    /* JADX INFO: Access modifiers changed from: protected */
    public ce(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.cf
    protected PbRecBaseViewHolder aF(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aLD().m(this.mContext, 3);
    }
}
