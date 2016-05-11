package com.baidu.tieba.person.god.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.person.data.k;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.person.a.c<k, com.baidu.tieba.person.b.a> {
    private w dxI;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public com.baidu.tieba.person.b.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(t.h.person_info_group_title, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.person.b.a aVar) {
        a(aVar, view);
        if (kVar != null && this.bUL) {
            a(aVar, kVar, view);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.a aVar, k kVar, View view) {
        if (kVar != null && aVar != null) {
            if (kVar.dzA) {
                aVar.dBb.setVisibility(8);
                return;
            }
            aVar.dBb.setVisibility(0);
            aVar.dBb.setOnClickListener(new View$OnClickListenerC0069a(kVar));
            if (kVar.dzz > 0) {
                aVar.dBd.setVisibility(8);
                aVar.dBc.setVisibility(0);
                aVar.cvN.setVisibility(0);
                aVar.title.setText(kVar.title);
                aVar.dBc.setText(ay.A(kVar.dzz));
                aVar.dBb.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(t.e.ds70);
                return;
            }
            aVar.dBd.setVisibility(0);
            aVar.dBc.setVisibility(8);
            aVar.cvN.setVisibility(8);
            aVar.dBb.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(t.e.ds100);
        }
    }

    private void a(com.baidu.tieba.person.b.a aVar, View view) {
        if (aVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            at.k(view, t.f.addresslist_item_bg);
            at.l(aVar.aTI, t.d.cp_bg_line_c);
            at.c(aVar.title, t.d.cp_cont_f, 1);
            at.c(aVar.dBc, t.d.cp_cont_c, 1);
            at.c(aVar.dBd, t.d.cp_cont_d, 1);
            at.c(aVar.cvN, t.f.icon_arrow_tab);
            aVar.aej = TbadkCoreApplication.m11getInst().getSkinType();
        }
    }

    public void d(w wVar) {
        this.dxI = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.person.god.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0069a implements View.OnClickListener {
        private k dAh;

        public View$OnClickListenerC0069a(k kVar) {
            this.dAh = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mContext != null && a.this.dxI != null) {
                a.this.dxI.a(view, this.dAh, k.Oq, null, 0, view.getId());
            }
        }
    }
}
