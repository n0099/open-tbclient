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
    private e jUS;
    private final LinkedList<a> jUT;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jUT = new LinkedList<>();
        if (bVar != null && bVar.cDO() != null) {
            avV = bVar.cDO().cGt();
        }
        this.jUS = new e(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cb */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.jUT.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.m mVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) mVar, (com.baidu.tieba.pb.data.m) aVar);
        if (mVar != null && aVar != null) {
            aVar.jUU.setOnClickOutListener(this.dUP);
            aVar.jUU.setPostId(getPostId());
            aVar.jUU.setForumId(getForumId());
            aVar.b(mVar);
        }
        return view;
    }

    public void onDestroy() {
        cIP();
        if (this.jUS != null) {
            this.jUS.onDestroy();
        }
    }

    private void cIP() {
        Iterator<a> it = this.jUT.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.jUU != null) {
                next.jUU.onDestroy();
            }
        }
    }

    public void wU(String str) {
        if (this.jUT.size() > 0) {
            Iterator<a> it = this.jUT.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.jUU != null) {
                    next.jUU.wU(str);
                }
            }
        } else if (cIQ() != null) {
            this.jUS.d(cIQ().aSp());
        }
    }

    private String getPostId() {
        bk cIQ = cIQ();
        return cIQ != null ? cIQ.aQP() : "";
    }

    private String getForumId() {
        return this.jKg.cDO() != null ? this.jKg.cDO().getForumId() : "";
    }

    private bk cIQ() {
        if (this.jKg.cDO() == null || this.jKg.cDO().getPbData() == null) {
            return null;
        }
        return this.jKg.cDO().getPbData().cCy();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dUP = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        public PbThreadCommentAndPraiseInfoLayout jUU;
        public View jUV;
        private int jUW;

        public a(View view) {
            super(view);
            if (view != null) {
                this.jUU = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                cVar.dAZ = 4;
                cVar.dBf = 7;
                cVar.dBa = this.jUW;
                cVar.dBd = c.avV;
                this.jUU.setAgreeStatisticData(cVar);
                this.jUV = view.findViewById(R.id.bottom_divider_line);
                this.jUV.setVisibility(0);
            }
        }

        public void b(com.baidu.tieba.pb.data.m mVar) {
            if (mVar != null && mVar.aOi() != null) {
                bk aOi = mVar.aOi();
                if (aOi.aSp() != null) {
                    aOi.aSp().postId = aOi.aQP();
                }
                this.jUU.a(aOi, mVar.getAnti());
                this.jUV.setVisibility(mVar.cDq() ? 0 : 8);
                if (aOi.aPk() && aOi.aQQ() != null) {
                    this.jUW = 2;
                } else {
                    this.jUW = 1;
                }
                if (mVar.jGx) {
                    getView().setPadding(0, 0, 0, l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.jUV, R.color.cp_bg_line_b);
            this.jUU.onChangeSkinType();
        }
    }
}
