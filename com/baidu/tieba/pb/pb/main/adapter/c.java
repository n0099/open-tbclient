package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.m;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class c extends m<com.baidu.tieba.pb.data.m, a> {
    private static int ayd;
    private View.OnClickListener ece;
    private e koI;
    private final LinkedList<a> koJ;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.koJ = new LinkedList<>();
        if (bVar != null && bVar.cIe() != null) {
            ayd = bVar.cIe().cKJ();
        }
        this.koI = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cn */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.koJ.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.m mVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) mVar, (com.baidu.tieba.pb.data.m) aVar);
        if (mVar != null && aVar != null) {
            aVar.koK.setOnClickOutListener(this.ece);
            aVar.koK.setPostId(getPostId());
            aVar.koK.setForumId(getForumId());
            aVar.b(mVar);
        }
        return view;
    }

    public void onDestroy() {
        cNg();
        if (this.koI != null) {
            this.koI.onDestroy();
        }
    }

    private void cNg() {
        Iterator<a> it = this.koJ.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.koK != null) {
                next.koK.onDestroy();
            }
        }
    }

    public void xl(String str) {
        if (this.koJ.size() > 0) {
            Iterator<a> it = this.koJ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.koK != null) {
                    next.koK.xl(str);
                }
            }
        } else if (cNh() != null) {
            this.koI.d(cNh().aUg());
        }
    }

    private String getPostId() {
        bu cNh = cNh();
        return cNh != null ? cNh.aSG() : "";
    }

    private String getForumId() {
        return this.kdO.cIe() != null ? this.kdO.cIe().getForumId() : "";
    }

    private bu cNh() {
        if (this.kdO.cIe() == null || this.kdO.cIe().getPbData() == null) {
            return null;
        }
        return this.kdO.cIe().getPbData().cGN();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ece = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        public PbThreadCommentAndPraiseInfoLayout koK;
        public View koL;
        private int koM;

        public a(View view) {
            super(view);
            if (view != null) {
                this.koK = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.dHq = 4;
                cVar.dHw = 7;
                cVar.dHr = this.koM;
                cVar.dHu = c.ayd;
                this.koK.setAgreeStatisticData(cVar);
                this.koL = view.findViewById(R.id.bottom_divider_line);
                this.koL.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.m mVar) {
            if (mVar != null && mVar.aPS() != null) {
                bu aPS = mVar.aPS();
                if (aPS.aUg() != null) {
                    aPS.aUg().postId = aPS.aSG();
                }
                this.koK.a(aPS, mVar.getAnti());
                this.koL.setVisibility(mVar.cHG() ? 0 : 8);
                if (aPS.aQV() && aPS.aSH() != null) {
                    this.koM = 2;
                } else {
                    this.koM = 1;
                }
                if (mVar.kah) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            an.setBackgroundColor(this.koL, R.color.cp_bg_line_b);
            this.koK.onChangeSkinType();
        }
    }
}
