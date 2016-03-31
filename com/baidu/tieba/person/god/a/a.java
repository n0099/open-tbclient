package com.baidu.tieba.person.god.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.person.data.j;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.person.a.c<j, com.baidu.tieba.person.b.a> {
    private v duM;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.tieba.person.b.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(t.h.person_info_group_title, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.person.b.a aVar) {
        a(aVar, view);
        if (jVar != null && this.bcn) {
            a(aVar, jVar, view);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.a aVar, j jVar, View view) {
        if (jVar != null && aVar != null) {
            if (jVar.dww) {
                aVar.dxW.setVisibility(8);
                return;
            }
            aVar.dxW.setVisibility(0);
            aVar.dxW.setOnClickListener(new View$OnClickListenerC0076a(jVar));
            if (jVar.dwv > 0) {
                aVar.dxY.setVisibility(8);
                aVar.dxX.setVisibility(0);
                aVar.cuQ.setVisibility(0);
                aVar.apE.setText(jVar.title);
                aVar.dxX.setText(ay.z(jVar.dwv));
                aVar.dxW.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(t.e.ds70);
                return;
            }
            aVar.dxY.setVisibility(0);
            aVar.dxX.setVisibility(8);
            aVar.cuQ.setVisibility(8);
            aVar.dxW.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(t.e.ds100);
        }
    }

    private void a(com.baidu.tieba.person.b.a aVar, View view) {
        if (aVar.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.k(view, t.f.addresslist_item_bg);
            at.l(aVar.aXO, t.d.cp_bg_line_c);
            at.b(aVar.apE, t.d.cp_cont_f, 1);
            at.b(aVar.dxX, t.d.cp_cont_c, 1);
            at.b(aVar.dxY, t.d.cp_cont_d, 1);
            at.c(aVar.cuQ, t.f.icon_arrow_tab);
            aVar.aik = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    public void b(v vVar) {
        this.duM = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.person.god.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0076a implements View.OnClickListener {
        private j dxb;

        public View$OnClickListenerC0076a(j jVar) {
            this.dxb = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mContext != null && a.this.duM != null) {
                a.this.duM.a(view, this.dxb, j.TC, null, 0, view.getId());
            }
        }
    }
}
