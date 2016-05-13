package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dl extends dh {
    /* JADX INFO: Access modifiers changed from: protected */
    public dl(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh
    /* renamed from: aI */
    public dm aH(ViewGroup viewGroup) {
        return new dm(LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_multi_img_item, viewGroup, false), this.dfJ, this.dfI, this.dfH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, dk dkVar) {
        super.a(i, view, viewGroup, sVar, dkVar);
        if (sVar == null || sVar.aUi() == null) {
            return null;
        }
        ((dm) dkVar).a(this.mContext, sVar.aUi(), this.ddo);
        return view;
    }
}
