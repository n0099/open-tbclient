package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
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
    private static int aqV;
    private View.OnClickListener dGD;
    private d jCq;
    private final LinkedList<a> jCr;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jCr = new LinkedList<>();
        if (bVar != null && bVar.cwB() != null) {
            aqV = bVar.cwB().czh();
        }
        this.jCq = new d(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.jCr.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (k) aVar);
        if (kVar != null && aVar != null) {
            aVar.jCs.setOnClickOutListener(this.dGD);
            aVar.jCs.setPostId(getPostId());
            aVar.jCs.setForumId(getForumId());
            aVar.b(kVar);
        }
        return view;
    }

    public void onDestroy() {
        cBD();
        if (this.jCq != null) {
            this.jCq.onDestroy();
        }
    }

    private void cBD() {
        Iterator<a> it = this.jCr.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.jCs != null) {
                next.jCs.onDestroy();
            }
        }
    }

    public void vo(String str) {
        if (this.jCr.size() > 0) {
            Iterator<a> it = this.jCr.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.jCs != null) {
                    next.jCs.vo(str);
                }
            }
        } else if (cBE() != null) {
            this.jCq.d(cBE().aMq());
        }
    }

    private String getPostId() {
        bj cBE = cBE();
        return cBE != null ? cBE.aKS() : "";
    }

    private String getForumId() {
        return this.jse.cwB() != null ? this.jse.cwB().getForumId() : "";
    }

    private bj cBE() {
        if (this.jse.cwB() == null || this.jse.cwB().getPbData() == null) {
            return null;
        }
        return this.jse.cwB().getPbData().cvs();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dGD = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        public PbThreadCommentAndPraiseInfoLayout jCs;
        public View jCt;
        private int jCu;

        public a(View view) {
            super(view);
            if (view != null) {
                this.jCs = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.dmX = 4;
                dVar.dnd = 7;
                dVar.dmY = this.jCu;
                dVar.dnb = c.aqV;
                this.jCs.setAgreeStatisticData(dVar);
                this.jCt = view.findViewById(R.id.bottom_divider_line);
                this.jCt.setVisibility(0);
            }
        }

        public void b(k kVar) {
            if (kVar != null && kVar.aIu() != null) {
                bj aIu = kVar.aIu();
                if (aIu.aMq() != null) {
                    aIu.aMq().postId = aIu.aKS();
                }
                this.jCs.a(aIu, kVar.getAnti());
                this.jCt.setVisibility(kVar.cwd() ? 0 : 8);
                if (aIu.aJp() && aIu.aKT() != null) {
                    this.jCu = 2;
                } else {
                    this.jCu = 1;
                }
                if (kVar.joI) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.jCt, R.color.cp_bg_line_b);
            this.jCs.onChangeSkinType();
        }
    }
}
