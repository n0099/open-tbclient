package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.o;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class c extends o<com.baidu.tieba.pb.data.o, a> {
    private static int aIJ;
    private View.OnClickListener eTR;
    private e lDZ;
    private final LinkedList<a> lEa;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lEa = new LinkedList<>();
        if (bVar != null && bVar.diV() != null) {
            aIJ = bVar.diV().dlE();
        }
        this.lDZ = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: co */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lEa.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.lEb.setOnClickOutListener(this.eTR);
            aVar.lEb.setPostId(getPostId());
            aVar.lEb.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        doh();
        if (this.lDZ != null) {
            this.lDZ.onDestroy();
        }
    }

    private void doh() {
        Iterator<a> it = this.lEa.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.lEb != null) {
                next.lEb.onDestroy();
            }
        }
    }

    public void BT(String str) {
        if (this.lEa.size() > 0) {
            Iterator<a> it = this.lEa.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.lEb != null) {
                    next.lEb.BT(str);
                }
            }
        } else if (doi() != null) {
            this.lDZ.e(doi().bnv());
        }
    }

    private String getPostId() {
        bx doi = doi();
        return doi != null ? doi.blT() : "";
    }

    private String getForumId() {
        return this.lsC.diV() != null ? this.lsC.diV().getForumId() : "";
    }

    private bx doi() {
        if (this.lsC.diV() == null || this.lsC.diV().getPbData() == null) {
            return null;
        }
        return this.lsC.diV().getPbData().dhH();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eTR = onClickListener;
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout lEb;
        public View lEc;
        private int lEd;

        public a(View view) {
            super(view);
            if (view != null) {
                this.lEb = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.exI = 4;
                dVar.exO = 7;
                dVar.exJ = this.lEd;
                dVar.exM = c.aIJ;
                this.lEb.setAgreeStatisticData(dVar);
                this.lEc = view.findViewById(R.id.bottom_divider_line);
                this.lEc.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bjd() != null) {
                bx bjd = oVar.bjd();
                if (bjd.bnv() != null) {
                    bjd.bnv().postId = bjd.blT();
                }
                this.lEb.a(bjd, oVar.getAnti());
                this.lEc.setVisibility(oVar.diA() ? 0 : 8);
                if (bjd.bki() && bjd.blU() != null) {
                    this.lEd = 2;
                } else {
                    this.lEd = 1;
                }
                if (oVar.loN) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.lEc, R.color.CAM_X0203);
            this.lEb.onChangeSkinType();
        }
    }
}
