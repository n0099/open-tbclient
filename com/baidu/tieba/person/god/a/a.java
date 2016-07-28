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
import com.baidu.tieba.person.data.j;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.a.a<j, com.baidu.tieba.person.holder.c> {
    private w eqf;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bU */
    public com.baidu.tieba.person.holder.c a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.c(LayoutInflater.from(this.mContext).inflate(u.h.person_info_group_title, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.person.holder.c cVar) {
        a(cVar, view);
        if (jVar != null && this.aNz) {
            a(cVar, jVar, view);
            this.aNz = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.c cVar, j jVar, View view) {
        if (jVar != null && cVar != null) {
            if (jVar.esi) {
                cVar.eug.setVisibility(8);
                return;
            }
            cVar.eug.setVisibility(0);
            cVar.eug.setOnClickListener(new View$OnClickListenerC0073a(jVar));
            if (jVar.esh > 0) {
                cVar.eui.setVisibility(8);
                cVar.euh.setVisibility(0);
                cVar.dea.setVisibility(0);
                cVar.title.setText(jVar.title);
                cVar.euh.setText(ba.w(jVar.esh));
                cVar.eug.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(u.e.ds70);
                return;
            }
            cVar.eui.setVisibility(0);
            cVar.euh.setVisibility(8);
            cVar.dea.setVisibility(8);
            cVar.eug.getLayoutParams().height = this.mContext.getResources().getDimensionPixelOffset(u.e.ds100);
        }
    }

    private void a(com.baidu.tieba.person.holder.c cVar, View view) {
        if (cVar.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            av.k(view, u.f.addresslist_item_bg);
            av.l(cVar.aYb, u.d.cp_bg_line_c);
            av.c(cVar.title, u.d.cp_cont_f, 1);
            av.c(cVar.euh, u.d.cp_cont_c, 1);
            av.c(cVar.eui, u.d.cp_cont_d, 1);
            av.c(cVar.dea, u.f.icon_arrow_tab);
            cVar.afy = TbadkCoreApplication.m10getInst().getSkinType();
        }
    }

    public void d(w wVar) {
        this.eqf = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.person.god.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0073a implements View.OnClickListener {
        private j esR;

        public View$OnClickListenerC0073a(j jVar) {
            this.esR = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mContext != null && a.this.eqf != null) {
                a.this.eqf.a(view, this.esR, j.OB, null, 0, view.getId());
            }
        }
    }
}
