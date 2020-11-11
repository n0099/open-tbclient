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
/* loaded from: classes22.dex */
public class c extends o<com.baidu.tieba.pb.data.o, a> {
    private static int aKu;
    private View.OnClickListener eUJ;
    private e lDH;
    private final LinkedList<a> lDI;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lDI = new LinkedList<>();
        if (bVar != null && bVar.djz() != null) {
            aKu = bVar.djz().dmh();
        }
        this.lDH = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cs */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lDI.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.lDJ.setOnClickOutListener(this.eUJ);
            aVar.lDJ.setPostId(getPostId());
            aVar.lDJ.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        doI();
        if (this.lDH != null) {
            this.lDH.onDestroy();
        }
    }

    private void doI() {
        Iterator<a> it = this.lDI.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.lDJ != null) {
                next.lDJ.onDestroy();
            }
        }
    }

    public void Cu(String str) {
        if (this.lDI.size() > 0) {
            Iterator<a> it = this.lDI.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.lDJ != null) {
                    next.lDJ.Cu(str);
                }
            }
        } else if (doJ() != null) {
            this.lDH.e(doJ().bor());
        }
    }

    private String getPostId() {
        bw doJ = doJ();
        return doJ != null ? doJ.bmR() : "";
    }

    private String getForumId() {
        return this.lsm.djz() != null ? this.lsm.djz().getForumId() : "";
    }

    private bw doJ() {
        if (this.lsm.djz() == null || this.lsm.djz().getPbData() == null) {
            return null;
        }
        return this.lsm.djz().getPbData().dik();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eUJ = onClickListener;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout lDJ;
        public View lDK;
        private int lDL;

        public a(View view) {
            super(view);
            if (view != null) {
                this.lDJ = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.ezt = 4;
                cVar.ezz = 7;
                cVar.ezu = this.lDL;
                cVar.ezx = c.aKu;
                this.lDJ.setAgreeStatisticData(cVar);
                this.lDK = view.findViewById(R.id.bottom_divider_line);
                this.lDK.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bjZ() != null) {
                bw bjZ = oVar.bjZ();
                if (bjZ.bor() != null) {
                    bjZ.bor().postId = bjZ.bmR();
                }
                this.lDJ.a(bjZ, oVar.getAnti());
                this.lDK.setVisibility(oVar.djd() ? 0 : 8);
                if (bjZ.blg() && bjZ.bmS() != null) {
                    this.lDL = 2;
                } else {
                    this.lDL = 1;
                }
                if (oVar.lov) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.lDK, R.color.cp_bg_line_b);
            this.lDJ.onChangeSkinType();
        }
    }
}
