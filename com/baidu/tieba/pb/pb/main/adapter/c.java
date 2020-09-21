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
/* loaded from: classes21.dex */
public class c extends o<com.baidu.tieba.pb.data.o, a> {
    private static int aFO;
    private View.OnClickListener euo;
    private e kVU;
    private final LinkedList<a> kVV;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kVV = new LinkedList<>();
        if (bVar != null && bVar.dah() != null) {
            aFO = bVar.dah().dcP();
        }
        this.kVU = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cn */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.kVV.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.kVW.setOnClickOutListener(this.euo);
            aVar.kVW.setPostId(getPostId());
            aVar.kVW.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dfp();
        if (this.kVU != null) {
            this.kVU.onDestroy();
        }
    }

    private void dfp() {
        Iterator<a> it = this.kVV.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.kVW != null) {
                next.kVW.onDestroy();
            }
        }
    }

    public void Bb(String str) {
        if (this.kVV.size() > 0) {
            Iterator<a> it = this.kVV.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.kVW != null) {
                    next.kVW.Bb(str);
                }
            }
        } else if (dfq() != null) {
            this.kVU.e(dfq().bhp());
        }
    }

    private String getPostId() {
        bw dfq = dfq();
        return dfq != null ? dfq.bfP() : "";
    }

    private String getForumId() {
        return this.kKB.dah() != null ? this.kKB.dah().getForumId() : "";
    }

    private bw dfq() {
        if (this.kKB.dah() == null || this.kKB.dah().getPbData() == null) {
            return null;
        }
        return this.kKB.dah().getPbData().cYR();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.euo = onClickListener;
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout kVW;
        public View kVX;
        private int kVY;

        public a(View view) {
            super(view);
            if (view != null) {
                this.kVW = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.dYY = 4;
                cVar.dZe = 7;
                cVar.dYZ = this.kVY;
                cVar.dZc = c.aFO;
                this.kVW.setAgreeStatisticData(cVar);
                this.kVX = view.findViewById(R.id.bottom_divider_line);
                this.kVX.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bcY() != null) {
                bw bcY = oVar.bcY();
                if (bcY.bhp() != null) {
                    bcY.bhp().postId = bcY.bfP();
                }
                this.kVW.a(bcY, oVar.getAnti());
                this.kVX.setVisibility(oVar.cZK() ? 0 : 8);
                if (bcY.bee() && bcY.bfQ() != null) {
                    this.kVY = 2;
                } else {
                    this.kVY = 1;
                }
                if (oVar.kGL) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.kVX, R.color.cp_bg_line_b);
            this.kVW.onChangeSkinType();
        }
    }
}
