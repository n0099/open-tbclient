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
    private e lRS;
    private final LinkedList<a> lRT;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lRT = new LinkedList<>();
        if (bVar != null && bVar.dol() != null) {
            aLC = bVar.dol().dqV();
        }
        this.lRS = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cr */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lRT.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.lRU.setOnClickOutListener(this.fbo);
            aVar.lRU.setPostId(getPostId());
            aVar.lRU.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dtz();
        if (this.lRS != null) {
            this.lRS.onDestroy();
        }
    }

    private void dtz() {
        Iterator<a> it = this.lRT.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.lRU != null) {
                next.lRU.onDestroy();
            }
        }
    }

    public void CB(String str) {
        if (this.lRT.size() > 0) {
            Iterator<a> it = this.lRT.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.lRU != null) {
                    next.lRU.CB(str);
                }
            }
        } else if (dtA() != null) {
            this.lRS.e(dtA().bqI());
        }
    }

    private String getPostId() {
        by dtA = dtA();
        return dtA != null ? dtA.bpg() : "";
    }

    private String getForumId() {
        return this.lGq.dol() != null ? this.lGq.dol().getForumId() : "";
    }

    private by dtA() {
        if (this.lGq.dol() == null || this.lGq.dol().getPbData() == null) {
            return null;
        }
        return this.lGq.dol().getPbData().dmU();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fbo = onClickListener;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout lRU;
        public View lRV;
        private int lRW;

        public a(View view) {
            super(view);
            if (view != null) {
                this.lRU = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.eEJ = 4;
                dVar.eEP = 7;
                dVar.eEK = this.lRW;
                dVar.eEN = c.aLC;
                this.lRU.setAgreeStatisticData(dVar);
                this.lRV = view.findViewById(R.id.bottom_divider_line);
                this.lRV.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bmn() != null) {
                by bmn = oVar.bmn();
                if (bmn.bqI() != null) {
                    bmn.bqI().postId = bmn.bpg();
                }
                this.lRU.a(bmn, oVar.getAnti());
                this.lRV.setVisibility(oVar.dnQ() ? 0 : 8);
                if (bmn.bnv() && bmn.bph() != null) {
                    this.lRW = 2;
                } else {
                    this.lRW = 1;
                }
                if (oVar.lCl) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.lRV, R.color.CAM_X0203);
            this.lRU.onChangeSkinType();
        }
    }
}
