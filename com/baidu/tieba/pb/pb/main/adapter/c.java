package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.o;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class c extends o<com.baidu.tieba.pb.data.o, a> {
    private static int aLC;
    private View.OnClickListener fbo;
    private e lRQ;
    private final LinkedList<a> lRR;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lRR = new LinkedList<>();
        if (bVar != null && bVar.dok() != null) {
            aLC = bVar.dok().dqU();
        }
        this.lRQ = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cr */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lRR.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.lRS.setOnClickOutListener(this.fbo);
            aVar.lRS.setPostId(getPostId());
            aVar.lRS.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dty();
        if (this.lRQ != null) {
            this.lRQ.onDestroy();
        }
    }

    private void dty() {
        Iterator<a> it = this.lRR.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.lRS != null) {
                next.lRS.onDestroy();
            }
        }
    }

    public void CB(String str) {
        if (this.lRR.size() > 0) {
            Iterator<a> it = this.lRR.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.lRS != null) {
                    next.lRS.CB(str);
                }
            }
        } else if (dtz() != null) {
            this.lRQ.e(dtz().bqI());
        }
    }

    private String getPostId() {
        by dtz = dtz();
        return dtz != null ? dtz.bpg() : "";
    }

    private String getForumId() {
        return this.lGo.dok() != null ? this.lGo.dok().getForumId() : "";
    }

    private by dtz() {
        if (this.lGo.dok() == null || this.lGo.dok().getPbData() == null) {
            return null;
        }
        return this.lGo.dok().getPbData().dmT();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fbo = onClickListener;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout lRS;
        public View lRT;
        private int lRU;

        public a(View view) {
            super(view);
            if (view != null) {
                this.lRS = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.eEJ = 4;
                dVar.eEP = 7;
                dVar.eEK = this.lRU;
                dVar.eEN = c.aLC;
                this.lRS.setAgreeStatisticData(dVar);
                this.lRT = view.findViewById(R.id.bottom_divider_line);
                this.lRT.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bmn() != null) {
                by bmn = oVar.bmn();
                if (bmn.bqI() != null) {
                    bmn.bqI().postId = bmn.bpg();
                }
                this.lRS.a(bmn, oVar.getAnti());
                this.lRT.setVisibility(oVar.dnP() ? 0 : 8);
                if (bmn.bnv() && bmn.bph() != null) {
                    this.lRU = 2;
                } else {
                    this.lRU = 1;
                }
                if (oVar.lCj) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.lRT, R.color.CAM_X0203);
            this.lRS.onChangeSkinType();
        }
    }
}
