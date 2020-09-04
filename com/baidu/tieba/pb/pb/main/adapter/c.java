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
    private static int aED;
    private View.OnClickListener esj;
    private e kNu;
    private final LinkedList<a> kNv;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kNv = new LinkedList<>();
        if (bVar != null && bVar.cWE() != null) {
            aED = bVar.cWE().cZm();
        }
        this.kNu = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cm */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.kNv.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.kNw.setOnClickOutListener(this.esj);
            aVar.kNw.setPostId(getPostId());
            aVar.kNw.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dbL();
        if (this.kNu != null) {
            this.kNu.onDestroy();
        }
    }

    private void dbL() {
        Iterator<a> it = this.kNv.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.kNw != null) {
                next.kNw.onDestroy();
            }
        }
    }

    public void AF(String str) {
        if (this.kNv.size() > 0) {
            Iterator<a> it = this.kNv.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.kNw != null) {
                    next.kNw.AF(str);
                }
            }
        } else if (dbM() != null) {
            this.kNu.e(dbM().bgv());
        }
    }

    private String getPostId() {
        bw dbM = dbM();
        return dbM != null ? dbM.beV() : "";
    }

    private String getForumId() {
        return this.kCd.cWE() != null ? this.kCd.cWE().getForumId() : "";
    }

    private bw dbM() {
        if (this.kCd.cWE() == null || this.kCd.cWE().getPbData() == null) {
            return null;
        }
        return this.kCd.cWE().getPbData().cVm();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.esj = onClickListener;
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout kNw;
        public View kNx;
        private int kNy;

        public a(View view) {
            super(view);
            if (view != null) {
                this.kNw = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.dWO = 4;
                cVar.dWU = 7;
                cVar.dWP = this.kNy;
                cVar.dWS = c.aED;
                this.kNw.setAgreeStatisticData(cVar);
                this.kNx = view.findViewById(R.id.bottom_divider_line);
                this.kNx.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bce() != null) {
                bw bce = oVar.bce();
                if (bce.bgv() != null) {
                    bce.bgv().postId = bce.beV();
                }
                this.kNw.a(bce, oVar.getAnti());
                this.kNx.setVisibility(oVar.cWg() ? 0 : 8);
                if (bce.bdk() && bce.beW() != null) {
                    this.kNy = 2;
                } else {
                    this.kNy = 1;
                }
                if (oVar.kyo) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.kNx, R.color.cp_bg_line_b);
            this.kNw.onChangeSkinType();
        }
    }
}
