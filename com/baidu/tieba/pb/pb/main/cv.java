package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class cv extends cw {
    /* JADX INFO: Access modifiers changed from: protected */
    public cv(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    @Override // com.baidu.tieba.pb.pb.main.cw
    protected PbRecBaseViewHolder au(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aLw().m(this.mContext, 3);
    }
}
