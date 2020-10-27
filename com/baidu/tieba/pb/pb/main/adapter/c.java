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
    private static int aJu;
    private View.OnClickListener eOU;
    private e lxK;
    private final LinkedList<a> lxL;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lxL = new LinkedList<>();
        if (bVar != null && bVar.dgX() != null) {
            aJu = bVar.dgX().djF();
        }
        this.lxK = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cq */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lxL.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) aVar);
        if (oVar != null && aVar != null) {
            aVar.lxM.setOnClickOutListener(this.eOU);
            aVar.lxM.setPostId(getPostId());
            aVar.lxM.setForumId(getForumId());
            aVar.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dmf();
        if (this.lxK != null) {
            this.lxK.onDestroy();
        }
    }

    private void dmf() {
        Iterator<a> it = this.lxL.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.lxM != null) {
                next.lxM.onDestroy();
            }
        }
    }

    public void Cg(String str) {
        if (this.lxL.size() > 0) {
            Iterator<a> it = this.lxL.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.lxM != null) {
                    next.lxM.Cg(str);
                }
            }
        } else if (dmg() != null) {
            this.lxK.e(dmg().blR());
        }
    }

    private String getPostId() {
        bw dmg = dmg();
        return dmg != null ? dmg.bkr() : "";
    }

    private String getForumId() {
        return this.lml.dgX() != null ? this.lml.dgX().getForumId() : "";
    }

    private bw dmg() {
        if (this.lml.dgX() == null || this.lml.dgX().getPbData() == null) {
            return null;
        }
        return this.lml.dgX().getPbData().dfI();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eOU = onClickListener;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public PbThreadCommentAndPraiseInfoLayout lxM;
        public View lxN;
        private int lxO;

        public a(View view) {
            super(view);
            if (view != null) {
                this.lxM = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.etA = 4;
                cVar.etG = 7;
                cVar.etB = this.lxO;
                cVar.etE = c.aJu;
                this.lxM.setAgreeStatisticData(cVar);
                this.lxN = view.findViewById(R.id.bottom_divider_line);
                this.lxN.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.o oVar) {
            if (oVar != null && oVar.bhz() != null) {
                bw bhz = oVar.bhz();
                if (bhz.blR() != null) {
                    bhz.blR().postId = bhz.bkr();
                }
                this.lxM.a(bhz, oVar.getAnti());
                this.lxN.setVisibility(oVar.dgB() ? 0 : 8);
                if (bhz.biG() && bhz.bks() != null) {
                    this.lxO = 2;
                } else {
                    this.lxO = 1;
                }
                if (oVar.liv) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.lxN, R.color.cp_bg_line_b);
            this.lxM.onChangeSkinType();
        }
    }
}
