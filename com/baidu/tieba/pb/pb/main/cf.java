package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class cf extends cg {
    /* JADX INFO: Access modifiers changed from: protected */
    public cf(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.cg
    protected PbRecBaseViewHolder al(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aEE().j(this.mContext, 3);
    }
}
