package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.m;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class c extends m<com.baidu.tieba.pb.data.m, a> {
    private static int avV;
    private View.OnClickListener dUP;
    private e jTM;
    private final LinkedList<a> jTN;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jTN = new LinkedList<>();
        if (bVar != null && bVar.cDy() != null) {
            avV = bVar.cDy().cGd();
        }
        this.jTM = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cb */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.jTN.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.m mVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) mVar, (com.baidu.tieba.pb.data.m) aVar);
        if (mVar != null && aVar != null) {
            aVar.jTO.setOnClickOutListener(this.dUP);
            aVar.jTO.setPostId(getPostId());
            aVar.jTO.setForumId(getForumId());
            aVar.b(mVar);
        }
        return view;
    }

    public void onDestroy() {
        cIz();
        if (this.jTM != null) {
            this.jTM.onDestroy();
        }
    }

    private void cIz() {
        Iterator<a> it = this.jTN.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.jTO != null) {
                next.jTO.onDestroy();
            }
        }
    }

    public void wU(String str) {
        if (this.jTN.size() > 0) {
            Iterator<a> it = this.jTN.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.jTO != null) {
                    next.jTO.wU(str);
                }
            }
        } else if (cIA() != null) {
            this.jTM.d(cIA().aSp());
        }
    }

    private String getPostId() {
        bk cIA = cIA();
        return cIA != null ? cIA.aQP() : "";
    }

    private String getForumId() {
        return this.jJa.cDy() != null ? this.jJa.cDy().getForumId() : "";
    }

    private bk cIA() {
        if (this.jJa.cDy() == null || this.jJa.cDy().getPbData() == null) {
            return null;
        }
        return this.jJa.cDy().getPbData().cCi();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dUP = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        public PbThreadCommentAndPraiseInfoLayout jTO;
        public View jTP;
        private int jTQ;

        public a(View view) {
            super(view);
            if (view != null) {
                this.jTO = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.dAZ = 4;
                cVar.dBf = 7;
                cVar.dBa = this.jTQ;
                cVar.dBd = c.avV;
                this.jTO.setAgreeStatisticData(cVar);
                this.jTP = view.findViewById(R.id.bottom_divider_line);
                this.jTP.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.m mVar) {
            if (mVar != null && mVar.aOi() != null) {
                bk aOi = mVar.aOi();
                if (aOi.aSp() != null) {
                    aOi.aSp().postId = aOi.aQP();
                }
                this.jTO.a(aOi, mVar.getAnti());
                this.jTP.setVisibility(mVar.cDa() ? 0 : 8);
                if (aOi.aPk() && aOi.aQQ() != null) {
                    this.jTQ = 2;
                } else {
                    this.jTQ = 1;
                }
                if (mVar.jFr) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.jTP, R.color.cp_bg_line_b);
            this.jTO.onChangeSkinType();
        }
    }
}
