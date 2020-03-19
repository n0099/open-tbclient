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
    private static int YF;
    private View.OnClickListener dhc;
    private d iSd;
    private final LinkedList<a> iSe;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iSe = new LinkedList<>();
        if (bVar != null && bVar.clX() != null) {
            YF = bVar.clX().coD();
        }
        this.iSd = new d(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.iSe.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (k) aVar);
        if (kVar != null && aVar != null) {
            aVar.iSf.setOnClickOutListener(this.dhc);
            aVar.iSf.setPostId(getPostId());
            aVar.iSf.setForumId(getForumId());
            aVar.b(kVar);
        }
        return view;
    }

    public void onDestroy() {
        cqZ();
        if (this.iSd != null) {
            this.iSd.onDestroy();
        }
    }

    private void cqZ() {
        Iterator<a> it = this.iSe.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iSf != null) {
                next.iSf.onDestroy();
            }
        }
    }

    public void tY(String str) {
        Iterator<a> it = this.iSe.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iSf != null) {
                next.iSf.tY(str);
            }
        }
    }

    private String getPostId() {
        bj cra = cra();
        return cra != null ? cra.aCH() : "";
    }

    private String getForumId() {
        return this.iHT.clX() != null ? this.iHT.clX().getForumId() : "";
    }

    private bj cra() {
        if (this.iHT.clX() == null || this.iHT.clX().getPbData() == null) {
            return null;
        }
        return this.iHT.clX().getPbData().ckP();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dhc = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout iSf;
        public View iSg;
        private int iSh;

        public a(View view) {
            super(view);
            if (view != null) {
                this.iSf = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cNP = 4;
                dVar.cNV = 7;
                dVar.cNQ = this.iSh;
                dVar.cNT = c.YF;
                this.iSf.setAgreeStatisticData(dVar);
                this.iSg = view.findViewById(R.id.bottom_divider_line);
                this.iSg.setVisibility(0);
            }
        }

        public void b(k kVar) {
            if (kVar != null && kVar.aAj() != null) {
                bj aAj = kVar.aAj();
                if (aAj.aEe() != null) {
                    aAj.aEe().postId = aAj.aCH();
                }
                this.iSf.a(aAj, kVar.getAnti());
                this.iSg.setVisibility(kVar.clz() ? 0 : 8);
                if (aAj.aBe() && aAj.aCI() != null) {
                    this.iSh = 2;
                } else {
                    this.iSh = 1;
                }
                if (kVar.iEy) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.iSg, R.color.cp_bg_line_b);
            this.iSf.onChangeSkinType();
        }
    }
}
