package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class da extends cw {
    /* JADX INFO: Access modifiers changed from: protected */
    public da(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cw
    /* renamed from: ao */
    public db an(ViewGroup viewGroup) {
        return new db(LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_multi_img_item, viewGroup, false), this.cJY, this.cJX, this.cJW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cw
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, cz czVar) {
        super.a(i, view, viewGroup, rVar, czVar);
        if (rVar == null || rVar.aMF() == null) {
            return null;
        }
        ((db) czVar).a(this.mContext, rVar.aMF(), this.cHL);
        return view;
    }
}
