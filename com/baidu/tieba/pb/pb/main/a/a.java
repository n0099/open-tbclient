package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.data.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class a extends k<i, C0286a> {
    private View.OnClickListener aIx;
    private b ghL;
    private final LinkedList<C0286a> ghM;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.ghM = new LinkedList<>();
        this.ghL = new b(this.fXM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public C0286a onCreateViewHolder(ViewGroup viewGroup) {
        C0286a c0286a = new C0286a(LayoutInflater.from(this.mContext).inflate(e.h.layout_pb_thread_praise_item, viewGroup, false));
        this.ghM.add(c0286a);
        return c0286a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0286a c0286a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0286a);
        if (iVar != null && c0286a != null) {
            c0286a.ghN.setOnClickOutListener(this.aIx);
            c0286a.ghN.setPostId(getPostId());
            c0286a.ghN.setForumId(getForumId());
            c0286a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bmD();
        if (this.ghL != null) {
            this.ghL.onDestroy();
        }
    }

    private void bmD() {
        Iterator<C0286a> it = this.ghM.iterator();
        while (it.hasNext()) {
            C0286a next = it.next();
            if (next != null && next.ghN != null) {
                next.ghN.onDestroy();
            }
        }
    }

    public void gr(String str) {
        Iterator<C0286a> it = this.ghM.iterator();
        while (it.hasNext()) {
            C0286a next = it.next();
            if (next != null && next.ghN != null) {
                next.ghN.gr(str);
            }
        }
    }

    private String getPostId() {
        bb bmE = bmE();
        return bmE != null ? bmE.zX() : "";
    }

    private String getForumId() {
        return this.fXM.bhZ() != null ? this.fXM.bhZ().getForumId() : "";
    }

    private bb bmE() {
        if (this.fXM.bhZ() == null || this.fXM.bhZ().getPbData() == null) {
            return null;
        }
        return this.fXM.bhZ().getPbData().bgV();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aIx = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0286a extends q.a {
        public View ezU;
        public PbThreadCommentAndPraiseInfoLayout ghN;

        public C0286a(View view) {
            super(view);
            if (view != null) {
                this.ghN = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_bottom_func_layout);
                this.ezU = view.findViewById(e.g.bottom_divider_line);
                this.ezU.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bNy != null) {
                this.ghN.setData(iVar.bNy);
                this.ezU.setVisibility(iVar.bhA() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.j(this.ezU, e.d.cp_bg_line_e);
            this.ghN.onChangeSkinType();
        }
    }
}
