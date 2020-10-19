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
    private static int aIS;
    private View.OnClickListener eGy;
    private e llh;
    private final LinkedList<a> lli;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lli = new LinkedList<>();
        if (bVar != null && bVar.ddQ() != null) {
            aIS = bVar.ddQ().dgy();
        }
        this.llh = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lli.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.llj.setOnClickOutListener(this.eGy);
            aVar.llj.setPostId(getPostId());
            aVar.llj.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        diY();
        if (this.llh != null) {
            this.llh.onDestroy();
        }
    }

    private void diY() {
        Iterator<a> it = this.lli.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.llj != null) {
                next.llj.onDestroy();
            }
        }
    }

    public void BN(String str) {
        if (this.lli.size() > 0) {
            Iterator<a> it = this.lli.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.llj != null) {
                    next.llj.BN(str);
                }
            }
        } else if (diZ() != null) {
            this.llh.e(diZ().bjY());
        }
    }

    private String getPostId() {
        bw diZ = diZ();
        return diZ != null ? diZ.biy() : "";
    }

    private String getForumId() {
        return this.kZM.ddQ() != null ? this.kZM.ddQ().getForumId() : "";
    }

    private bw diZ() {
        if (this.kZM.ddQ() == null || this.kZM.ddQ().getPbData() == null) {
            return null;
        }
        return this.kZM.ddQ().getPbData().dcA();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eGy = onClickListener;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout llj;
        public View llk;
        private int lll;

        public a(View view) {
            super(view);
            if (view != null) {
                this.llj = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.ela = 4;
                cVar.elg = 7;
                cVar.elb = this.lll;
                cVar.ele = c.aIS;
                this.llj.setAgreeStatisticData(cVar);
                this.llk = view.findViewById(R.id.bottom_divider_line);
                this.llk.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bfG() != null) {
                bw bfG = oVar.bfG();
                if (bfG.bjY() != null) {
                    bfG.bjY().postId = bfG.biy();
                }
                this.llj.a(bfG, oVar.getAnti());
                this.llk.setVisibility(oVar.ddt() ? 0 : 8);
                if (bfG.bgN() && bfG.biz() != null) {
                    this.lll = 2;
                } else {
                    this.lll = 1;
                }
                if (oVar.kVW) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.llk, R.color.cp_bg_line_b);
            this.llj.onChangeSkinType();
        }
    }
}
