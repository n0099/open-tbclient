package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.view.m;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.c, com.baidu.tieba.personCenter.e.b> {
    private m eAx;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public com.baidu.tieba.personCenter.e.b onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.e.b(LayoutInflater.from(this.mContext).inflate(w.j.item_person_center_list_normal_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.c cVar, com.baidu.tieba.personCenter.e.b bVar) {
        if (cVar != null && bVar != null) {
            a(bVar, cVar);
            b(bVar, cVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.personCenter.e.b bVar, com.baidu.tieba.personCenter.c.c cVar) {
        bVar.eAW.setText(cVar.title);
        ((com.baidu.tieba.personCenter.b.c) bVar.eAY.getTag()).a(this.mContext, bVar.eAY, cVar.bGY);
        bVar.eAY.setVisibility(cVar.bGY == null ? 8 : 0);
        a aVar = new a();
        aVar.a(cVar);
        bVar.getView().setOnClickListener(aVar);
    }

    private void b(com.baidu.tieba.personCenter.e.b bVar, com.baidu.tieba.personCenter.c.c cVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        aq.c(bVar.eAV, cVar.iconId, skinType);
        if (bVar.amZ != skinType) {
            bVar.amZ = skinType;
            aq.j(bVar.getView(), w.g.item_person_header_attention_bg_selector);
            aq.c(bVar.eAW, w.e.cp_cont_b, 1);
            aq.c(bVar.eAX, w.g.icon_arrow_tab, skinType);
            if (cVar.bGY != null) {
                ((com.baidu.tieba.personCenter.b.c) bVar.eAY.getTag()).onChangeSkinType(skinType);
            }
        }
    }

    public void setOnViewResponseListener(m mVar) {
        this.eAx = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.c.c eAy;

        a() {
        }

        public void a(com.baidu.tieba.personCenter.c.c cVar) {
            this.eAy = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.eAx != null) {
                c.this.eAx.a(view, this.eAy.eAU);
            }
        }
    }
}
