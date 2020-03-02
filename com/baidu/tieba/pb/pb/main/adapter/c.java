package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.l;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class c extends l<k, a> {
    private static int Yv;
    private View.OnClickListener dgC;
    private d iQq;
    private final LinkedList<a> iQr;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iQr = new LinkedList<>();
        if (bVar != null && bVar.clB() != null) {
            Yv = bVar.clB().coh();
        }
        this.iQq = new d(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.iQr.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (k) aVar);
        if (kVar != null && aVar != null) {
            aVar.iQs.setOnClickOutListener(this.dgC);
            aVar.iQs.setPostId(getPostId());
            aVar.iQs.setForumId(getForumId());
            aVar.b(kVar);
        }
        return view;
    }

    public void onDestroy() {
        cqD();
        if (this.iQq != null) {
            this.iQq.onDestroy();
        }
    }

    private void cqD() {
        Iterator<a> it = this.iQr.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iQs != null) {
                next.iQs.onDestroy();
            }
        }
    }

    public void tX(String str) {
        Iterator<a> it = this.iQr.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iQs != null) {
                next.iQs.tX(str);
            }
        }
    }

    private String getPostId() {
        bj cqE = cqE();
        return cqE != null ? cqE.aCE() : "";
    }

    private String getForumId() {
        return this.iGg.clB() != null ? this.iGg.clB().getForumId() : "";
    }

    private bj cqE() {
        if (this.iGg.clB() == null || this.iGg.clB().getPbData() == null) {
            return null;
        }
        return this.iGg.clB().getPbData().cku();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dgC = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout iQs;
        public View iQt;
        private int iQu;

        public a(View view) {
            super(view);
            if (view != null) {
                this.iQs = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cNB = 4;
                dVar.cNH = 7;
                dVar.cNC = this.iQu;
                dVar.cNF = c.Yv;
                this.iQs.setAgreeStatisticData(dVar);
                this.iQt = view.findViewById(R.id.bottom_divider_line);
                this.iQt.setVisibility(0);
            }
        }

        public void b(k kVar) {
            if (kVar != null && kVar.aAg() != null) {
                bj aAg = kVar.aAg();
                if (aAg.aEa() != null) {
                    aAg.aEa().postId = aAg.aCE();
                }
                this.iQs.a(aAg, kVar.getAnti());
                this.iQt.setVisibility(kVar.cld() ? 0 : 8);
                if (aAg.aBb() && aAg.aCF() != null) {
                    this.iQu = 2;
                } else {
                    this.iQu = 1;
                }
                if (kVar.iCL) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.iQt, R.color.cp_bg_line_b);
            this.iQs.onChangeSkinType();
        }
    }
}
