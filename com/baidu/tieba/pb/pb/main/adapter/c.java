package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.o;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class c extends o<com.baidu.tieba.pb.data.o, a> {
    private static int azq;
    private View.OnClickListener eio;
    private e kxI;
    private final LinkedList<a> kxJ;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kxJ = new LinkedList<>();
        if (bVar != null && bVar.cLP() != null) {
            azq = bVar.cLP().cOv();
        }
        this.kxI = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cq */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.kxJ.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.kxK.setOnClickOutListener(this.eio);
            aVar.kxK.setPostId(getPostId());
            aVar.kxK.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        cQU();
        if (this.kxI != null) {
            this.kxI.onDestroy();
        }
    }

    private void cQU() {
        Iterator<a> it = this.kxJ.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.kxK != null) {
                next.kxK.onDestroy();
            }
        }
    }

    public void yq(String str) {
        if (this.kxJ.size() > 0) {
            Iterator<a> it = this.kxJ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.kxK != null) {
                    next.kxK.yq(str);
                }
            }
        } else if (cQV() != null) {
            this.kxI.e(cQV().aYc());
        }
    }

    private String getPostId() {
        bv cQV = cQV();
        return cQV != null ? cQV.aWC() : "";
    }

    private String getForumId() {
        return this.kmE.cLP() != null ? this.kmE.cLP().getForumId() : "";
    }

    private bv cQV() {
        if (this.kmE.cLP() == null || this.kmE.cLP().getPbData() == null) {
            return null;
        }
        return this.kmE.cLP().getPbData().cKx();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eio = onClickListener;
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        public PbThreadCommentAndPraiseInfoLayout kxK;
        public View kxL;
        private int kxM;

        public a(View view) {
            super(view);
            if (view != null) {
                this.kxK = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.dNB = 4;
                cVar.dNH = 7;
                cVar.dNC = this.kxM;
                cVar.dNF = c.azq;
                this.kxK.setAgreeStatisticData(cVar);
                this.kxL = view.findViewById(R.id.bottom_divider_line);
                this.kxL.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.aTN() != null) {
                bv aTN = oVar.aTN();
                if (aTN.aYc() != null) {
                    aTN.aYc().postId = aTN.aWC();
                }
                this.kxK.a(aTN, oVar.getAnti());
                this.kxL.setVisibility(oVar.cLr() ? 0 : 8);
                if (aTN.aUR() && aTN.aWD() != null) {
                    this.kxM = 2;
                } else {
                    this.kxM = 1;
                }
                if (oVar.kiP) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ao.setBackgroundColor(this.kxL, R.color.cp_bg_line_b);
            this.kxK.onChangeSkinType();
        }
    }
}
