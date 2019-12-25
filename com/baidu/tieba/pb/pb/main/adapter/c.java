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
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.m;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class c extends m<l, a> {
    private static int Wq;
    private View.OnClickListener dcl;
    private d iLp;
    private final LinkedList<a> iLq;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iLq = new LinkedList<>();
        if (bVar != null && bVar.ciU() != null) {
            Wq = bVar.ciU().clG();
        }
        this.iLp = new d(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.iLq.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (l) aVar);
        if (lVar != null && aVar != null) {
            aVar.iLr.setOnClickOutListener(this.dcl);
            aVar.iLr.setPostId(getPostId());
            aVar.iLr.setForumId(getForumId());
            aVar.b(lVar);
        }
        return view;
    }

    public void onDestroy() {
        coc();
        if (this.iLp != null) {
            this.iLp.onDestroy();
        }
    }

    private void coc() {
        Iterator<a> it = this.iLq.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iLr != null) {
                next.iLr.onDestroy();
            }
        }
    }

    public void tD(String str) {
        Iterator<a> it = this.iLq.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iLr != null) {
                next.iLr.tD(str);
            }
        }
    }

    private String getPostId() {
        bj cod = cod();
        return cod != null ? cod.azU() : "";
    }

    private String getForumId() {
        return this.iAW.ciU() != null ? this.iAW.ciU().getForumId() : "";
    }

    private bj cod() {
        if (this.iAW.ciU() == null || this.iAW.ciU().getPbData() == null) {
            return null;
        }
        return this.iAW.ciU().getPbData().chK();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dcl = onClickListener;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout iLr;
        public View iLs;
        private int iLt;

        public a(View view) {
            super(view);
            if (view != null) {
                this.iLr = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cJm = 4;
                dVar.cJs = 7;
                dVar.cJn = this.iLt;
                dVar.cJq = c.Wq;
                this.iLr.setAgreeStatisticData(dVar);
                this.iLs = view.findViewById(R.id.bottom_divider_line);
                this.iLs.setVisibility(0);
            }
        }

        public void b(l lVar) {
            if (lVar != null && lVar.Nl != null) {
                if (lVar.Nl.aBt() != null) {
                    lVar.Nl.aBt().postId = lVar.Nl.azU();
                }
                this.iLr.setData(lVar.Nl);
                this.iLs.setVisibility(lVar.civ() ? 0 : 8);
                if (lVar.Nl.aAE() && lVar.Nl.azV() != null) {
                    this.iLt = 2;
                } else {
                    this.iLt = 1;
                }
                if (lVar.ixm) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.iLs, R.color.cp_bg_line_b);
            this.iLr.onChangeSkinType();
        }
    }
}
