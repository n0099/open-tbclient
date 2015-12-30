package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class by extends bz {
    /* JADX INFO: Access modifiers changed from: protected */
    public by(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.bz
    protected PbRecBaseViewHolder Y(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.axH().l(this.mContext, 3);
    }
}
