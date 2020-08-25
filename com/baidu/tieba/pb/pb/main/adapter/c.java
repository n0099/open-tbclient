package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.o;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class c extends o<com.baidu.tieba.pb.data.o, a> {
    private static int aEB;
    private View.OnClickListener esf;
    private e kNn;
    private final LinkedList<a> kNo;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kNo = new LinkedList<>();
        if (bVar != null && bVar.cWD() != null) {
            aEB = bVar.cWD().cZl();
        }
        this.kNn = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cm */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.kNo.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.kNp.setOnClickOutListener(this.esf);
            aVar.kNp.setPostId(getPostId());
            aVar.kNp.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dbK();
        if (this.kNn != null) {
            this.kNn.onDestroy();
        }
    }

    private void dbK() {
        Iterator<a> it = this.kNo.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.kNp != null) {
                next.kNp.onDestroy();
            }
        }
    }

    public void AE(String str) {
        if (this.kNo.size() > 0) {
            Iterator<a> it = this.kNo.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.kNp != null) {
                    next.kNp.AE(str);
                }
            }
        } else if (dbL() != null) {
            this.kNn.e(dbL().bgv());
        }
    }

    private String getPostId() {
        bw dbL = dbL();
        return dbL != null ? dbL.beV() : "";
    }

    private String getForumId() {
        return this.kBW.cWD() != null ? this.kBW.cWD().getForumId() : "";
    }

    private bw dbL() {
        if (this.kBW.cWD() == null || this.kBW.cWD().getPbData() == null) {
            return null;
        }
        return this.kBW.cWD().getPbData().cVl();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.esf = onClickListener;
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout kNp;
        public View kNq;
        private int kNr;

        public a(View view) {
            super(view);
            if (view != null) {
                this.kNp = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.dWK = 4;
                cVar.dWQ = 7;
                cVar.dWL = this.kNr;
                cVar.dWO = c.aEB;
                this.kNp.setAgreeStatisticData(cVar);
                this.kNq = view.findViewById(R.id.bottom_divider_line);
                this.kNq.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bce() != null) {
                bw bce = oVar.bce();
                if (bce.bgv() != null) {
                    bce.bgv().postId = bce.beV();
                }
                this.kNp.a(bce, oVar.getAnti());
                this.kNq.setVisibility(oVar.cWf() ? 0 : 8);
                if (bce.bdk() && bce.beW() != null) {
                    this.kNr = 2;
                } else {
                    this.kNr = 1;
                }
                if (oVar.kyh) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.kNq, R.color.cp_bg_line_b);
            this.kNp.onChangeSkinType();
        }
    }
}
