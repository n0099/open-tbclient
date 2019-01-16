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
    private View.OnClickListener aIZ;
    private b giP;
    private final LinkedList<C0286a> giQ;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.giQ = new LinkedList<>();
        this.giP = new b(this.fYJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public C0286a onCreateViewHolder(ViewGroup viewGroup) {
        C0286a c0286a = new C0286a(LayoutInflater.from(this.mContext).inflate(e.h.layout_pb_thread_praise_item, viewGroup, false));
        this.giQ.add(c0286a);
        return c0286a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0286a c0286a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0286a);
        if (iVar != null && c0286a != null) {
            c0286a.giR.setOnClickOutListener(this.aIZ);
            c0286a.giR.setPostId(getPostId());
            c0286a.giR.setForumId(getForumId());
            c0286a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bnl();
        if (this.giP != null) {
            this.giP.onDestroy();
        }
    }

    private void bnl() {
        Iterator<C0286a> it = this.giQ.iterator();
        while (it.hasNext()) {
            C0286a next = it.next();
            if (next != null && next.giR != null) {
                next.giR.onDestroy();
            }
        }
    }

    public void gF(String str) {
        Iterator<C0286a> it = this.giQ.iterator();
        while (it.hasNext()) {
            C0286a next = it.next();
            if (next != null && next.giR != null) {
                next.giR.gF(str);
            }
        }
    }

    private String getPostId() {
        bb bnm = bnm();
        return bnm != null ? bnm.Ak() : "";
    }

    private String getForumId() {
        return this.fYJ.biD() != null ? this.fYJ.biD().getForumId() : "";
    }

    private bb bnm() {
        if (this.fYJ.biD() == null || this.fYJ.biD().getPbData() == null) {
            return null;
        }
        return this.fYJ.biD().getPbData().bhz();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aIZ = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0286a extends q.a {
        public View eAF;
        public PbThreadCommentAndPraiseInfoLayout giR;

        public C0286a(View view) {
            super(view);
            if (view != null) {
                this.giR = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_bottom_func_layout);
                this.eAF = view.findViewById(e.g.bottom_divider_line);
                this.eAF.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bOk != null) {
                this.giR.setData(iVar.bOk);
                this.eAF.setVisibility(iVar.bie() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.j(this.eAF, e.d.cp_bg_line_e);
            this.giR.onChangeSkinType();
        }
    }
}
