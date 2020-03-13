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
    private View.OnClickListener dgP;
    private d iQC;
    private final LinkedList<a> iQD;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iQD = new LinkedList<>();
        if (bVar != null && bVar.clC() != null) {
            Yv = bVar.clC().coi();
        }
        this.iQC = new d(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.iQD.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (k) aVar);
        if (kVar != null && aVar != null) {
            aVar.iQE.setOnClickOutListener(this.dgP);
            aVar.iQE.setPostId(getPostId());
            aVar.iQE.setForumId(getForumId());
            aVar.b(kVar);
        }
        return view;
    }

    public void onDestroy() {
        cqE();
        if (this.iQC != null) {
            this.iQC.onDestroy();
        }
    }

    private void cqE() {
        Iterator<a> it = this.iQD.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iQE != null) {
                next.iQE.onDestroy();
            }
        }
    }

    public void tY(String str) {
        Iterator<a> it = this.iQD.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iQE != null) {
                next.iQE.tY(str);
            }
        }
    }

    private String getPostId() {
        bj cqF = cqF();
        return cqF != null ? cqF.aCE() : "";
    }

    private String getForumId() {
        return this.iGs.clC() != null ? this.iGs.clC().getForumId() : "";
    }

    private bj cqF() {
        if (this.iGs.clC() == null || this.iGs.clC().getPbData() == null) {
            return null;
        }
        return this.iGs.clC().getPbData().ckv();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dgP = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout iQE;
        public View iQF;
        private int iQG;

        public a(View view) {
            super(view);
            if (view != null) {
                this.iQE = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cNC = 4;
                dVar.cNI = 7;
                dVar.cND = this.iQG;
                dVar.cNG = c.Yv;
                this.iQE.setAgreeStatisticData(dVar);
                this.iQF = view.findViewById(R.id.bottom_divider_line);
                this.iQF.setVisibility(0);
            }
        }

        public void b(k kVar) {
            if (kVar != null && kVar.aAg() != null) {
                bj aAg = kVar.aAg();
                if (aAg.aEa() != null) {
                    aAg.aEa().postId = aAg.aCE();
                }
                this.iQE.a(aAg, kVar.getAnti());
                this.iQF.setVisibility(kVar.cle() ? 0 : 8);
                if (aAg.aBb() && aAg.aCF() != null) {
                    this.iQG = 2;
                } else {
                    this.iQG = 1;
                }
                if (kVar.iCX) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.iQF, R.color.cp_bg_line_b);
            this.iQE.onChangeSkinType();
        }
    }
}
