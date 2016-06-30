package com.baidu.tieba.person.god.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.person.data.k;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.a.a<k, com.baidu.tieba.person.b.a> {
    private w ege;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public com.baidu.tieba.person.b.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(u.h.person_info_group_title, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.person.b.a aVar) {
        a(aVar, view);
        if (kVar != null && this.aMF) {
            a(aVar, kVar, view);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.a aVar, k kVar, View view) {
        if (kVar != null && aVar != null) {
            if (kVar.eie) {
                aVar.ejG.setVisibility(8);
                return;
            }
            aVar.ejG.setVisibility(0);
            aVar.ejG.setOnClickListener(new View$OnClickListenerC0073a(kVar));
            if (kVar.eid > 0) {
                aVar.ejI.setVisibility(8);
                aVar.ejH.setVisibility(0);
                aVar.dbd.setVisibility(0);
                aVar.title.setText(kVar.title);
                aVar.ejH.setText(ba.B(kVar.eid));
                aVar.ejG.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(u.e.ds70);
                return;
            }
            aVar.ejI.setVisibility(0);
            aVar.ejH.setVisibility(8);
            aVar.dbd.setVisibility(8);
            aVar.ejG.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(u.e.ds100);
        }
    }

    private void a(com.baidu.tieba.person.b.a aVar, View view) {
        if (aVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            av.k(view, u.f.addresslist_item_bg);
            av.l(aVar.aXd, u.d.cp_bg_line_c);
            av.c(aVar.title, u.d.cp_cont_f, 1);
            av.c(aVar.ejH, u.d.cp_cont_c, 1);
            av.c(aVar.ejI, u.d.cp_cont_d, 1);
            av.c(aVar.dbd, u.f.icon_arrow_tab);
            aVar.aeK = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    public void d(w wVar) {
        this.ege = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.person.god.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0073a implements View.OnClickListener {
        private k eiN;

        public View$OnClickListenerC0073a(k kVar) {
            this.eiN = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mContext != null && a.this.ege != null) {
                a.this.ege.a(view, this.eiN, k.Op, null, 0, view.getId());
            }
        }
    }
}
