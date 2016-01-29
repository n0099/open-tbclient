package com.baidu.tieba.person.god.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.person.data.j;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.person.a.c<j, com.baidu.tieba.person.b.a> {
    private v dai;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.person.b.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(t.h.person_info_group_title, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.person.b.a aVar) {
        a(aVar, view);
        if (jVar != null && this.aXE) {
            a(aVar, jVar, view);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.a aVar, j jVar, View view) {
        if (jVar != null && aVar != null) {
            if (jVar.dbT) {
                aVar.ddv.setVisibility(8);
                return;
            }
            aVar.ddv.setVisibility(0);
            aVar.ddv.setOnClickListener(new View$OnClickListenerC0079a(jVar));
            if (jVar.dbS > 0) {
                aVar.ddx.setVisibility(8);
                aVar.ddw.setVisibility(0);
                aVar.ckk.setVisibility(0);
                aVar.apm.setText(jVar.title);
                aVar.ddw.setText(aw.x(jVar.dbS));
                aVar.ddv.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(t.e.ds70);
                return;
            }
            aVar.ddx.setVisibility(0);
            aVar.ddw.setVisibility(8);
            aVar.ckk.setVisibility(8);
            aVar.ddv.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(t.e.ds100);
        }
    }

    private void a(com.baidu.tieba.person.b.a aVar, View view) {
        if (aVar.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            ar.k(view, t.f.addresslist_item_bg);
            ar.l(aVar.aUc, t.d.cp_bg_line_c);
            ar.b(aVar.apm, t.d.cp_cont_f, 1);
            ar.b(aVar.ddw, t.d.cp_cont_c, 1);
            ar.b(aVar.ddx, t.d.cp_cont_d, 1);
            ar.c(aVar.ckk, t.f.icon_arrow_tab);
            aVar.ahU = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    public void b(v vVar) {
        this.dai = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.person.god.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0079a implements View.OnClickListener {
        private j dcz;

        public View$OnClickListenerC0079a(j jVar) {
            this.dcz = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mContext != null && a.this.dai != null) {
                a.this.dai.a(view, this.dcz, j.aRS, null, 0, view.getId());
            }
        }
    }
}
