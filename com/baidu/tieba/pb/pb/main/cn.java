package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class cn extends co {
    /* JADX INFO: Access modifiers changed from: protected */
    public cn(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.co
    protected PbRecBaseViewHolder bn(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aXW().n(this.mContext, 3);
    }
}
