package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.c, com.baidu.tieba.personCenter.e.b> {
    private m eFl;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public com.baidu.tieba.personCenter.e.b a(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.e.b(LayoutInflater.from(this.mContext).inflate(r.h.item_person_center_list_normal_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.c cVar, com.baidu.tieba.personCenter.e.b bVar) {
        if (cVar != null && bVar != null) {
            a(bVar, cVar);
            b(bVar, cVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.personCenter.e.b bVar, com.baidu.tieba.personCenter.c.c cVar) {
        bVar.eFI.setText(this.mContext.getString(cVar.eFF));
        ((com.baidu.tieba.personCenter.b.c) bVar.eFK.getTag()).a(this.mContext, bVar.eFK, cVar.bJr);
        bVar.eFK.setVisibility(cVar.bJr == null ? 8 : 0);
        a aVar = new a();
        aVar.a(cVar);
        bVar.getView().setOnClickListener(aVar);
    }

    private void b(com.baidu.tieba.personCenter.e.b bVar, com.baidu.tieba.personCenter.c.c cVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        av.c(bVar.eFH, cVar.iconId, skinType);
        if (bVar.ahV != skinType) {
            bVar.ahV = skinType;
            av.k(bVar.getView(), r.f.item_person_header_attention_bg_selector);
            av.c(bVar.eFI, r.d.cp_cont_b, 1);
            av.c(bVar.eFJ, r.f.icon_arrow_tab, skinType);
            if (cVar.bJr != null) {
                ((com.baidu.tieba.personCenter.b.c) bVar.eFK.getTag()).onChangeSkinType(skinType);
            }
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.eFl = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.c.c eFm;

        a() {
        }

        public void a(com.baidu.tieba.personCenter.c.c cVar) {
            this.eFm = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.eFl != null) {
                c.this.eFl.a(view, this.eFm.eFE);
            }
        }
    }
}
