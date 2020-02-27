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
    private static int Yv;
    private View.OnClickListener dgB;
    private d iQo;
    private final LinkedList<a> iQp;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iQp = new LinkedList<>();
        if (bVar != null && bVar.clz() != null) {
            Yv = bVar.clz().cof();
        }
        this.iQo = new d(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.iQp.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (k) aVar);
        if (kVar != null && aVar != null) {
            aVar.iQq.setOnClickOutListener(this.dgB);
            aVar.iQq.setPostId(getPostId());
            aVar.iQq.setForumId(getForumId());
            aVar.b(kVar);
        }
        return view;
    }

    public void onDestroy() {
        cqB();
        if (this.iQo != null) {
            this.iQo.onDestroy();
        }
    }

    private void cqB() {
        Iterator<a> it = this.iQp.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iQq != null) {
                next.iQq.onDestroy();
            }
        }
    }

    public void tX(String str) {
        Iterator<a> it = this.iQp.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iQq != null) {
                next.iQq.tX(str);
            }
        }
    }

    private String getPostId() {
        bj cqC = cqC();
        return cqC != null ? cqC.aCC() : "";
    }

    private String getForumId() {
        return this.iGe.clz() != null ? this.iGe.clz().getForumId() : "";
    }

    private bj cqC() {
        if (this.iGe.clz() == null || this.iGe.clz().getPbData() == null) {
            return null;
        }
        return this.iGe.clz().getPbData().cks();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dgB = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout iQq;
        public View iQr;
        private int iQs;

        public a(View view) {
            super(view);
            if (view != null) {
                this.iQq = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cNA = 4;
                dVar.cNG = 7;
                dVar.cNB = this.iQs;
                dVar.cNE = c.Yv;
                this.iQq.setAgreeStatisticData(dVar);
                this.iQr = view.findViewById(R.id.bottom_divider_line);
                this.iQr.setVisibility(0);
            }
        }

        public void b(k kVar) {
            if (kVar != null && kVar.aAe() != null) {
                bj aAe = kVar.aAe();
                if (aAe.aDY() != null) {
                    aAe.aDY().postId = aAe.aCC();
                }
                this.iQq.a(aAe, kVar.getAnti());
                this.iQr.setVisibility(kVar.clb() ? 0 : 8);
                if (aAe.aAZ() && aAe.aCD() != null) {
                    this.iQs = 2;
                } else {
                    this.iQs = 1;
                }
                if (kVar.iCJ) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.iQr, R.color.cp_bg_line_b);
            this.iQq.onChangeSkinType();
        }
    }
}
