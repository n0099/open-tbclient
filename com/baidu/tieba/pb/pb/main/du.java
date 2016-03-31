package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class du extends dq {
    /* JADX INFO: Access modifiers changed from: protected */
    public du(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dq
    /* renamed from: ax */
    public dv aw(ViewGroup viewGroup) {
        return new dv(LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_multi_img_item, viewGroup, false), this.ddp, this.ddo, this.ddn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dq
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, dt dtVar) {
        super.a(i, view, viewGroup, sVar, dtVar);
        if (sVar == null || sVar.aTC() == null) {
            return null;
        }
        ((dv) dtVar).a(this.mContext, sVar.aTC(), this.daU);
        return view;
    }
}
