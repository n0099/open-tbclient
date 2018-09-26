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
/* loaded from: classes2.dex */
public class a extends k<i, C0214a> {
    private View.OnClickListener azy;
    private b fPc;
    private final LinkedList<C0214a> fPd;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fPd = new LinkedList<>();
        this.fPc = new b(this.fFd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public C0214a onCreateViewHolder(ViewGroup viewGroup) {
        C0214a c0214a = new C0214a(LayoutInflater.from(this.mContext).inflate(e.h.layout_pb_thread_praise_item, viewGroup, false));
        this.fPd.add(c0214a);
        return c0214a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0214a c0214a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0214a);
        if (iVar != null && c0214a != null) {
            c0214a.fPe.setOnClickOutListener(this.azy);
            c0214a.fPe.setPostId(getPostId());
            c0214a.fPe.setForumId(getForumId());
            c0214a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bhq();
        if (this.fPc != null) {
            this.fPc.onDestroy();
        }
    }

    private void bhq() {
        Iterator<C0214a> it = this.fPd.iterator();
        while (it.hasNext()) {
            C0214a next = it.next();
            if (next != null && next.fPe != null) {
                next.fPe.onDestroy();
            }
        }
    }

    public void fJ(String str) {
        Iterator<C0214a> it = this.fPd.iterator();
        while (it.hasNext()) {
            C0214a next = it.next();
            if (next != null && next.fPe != null) {
                next.fPe.fJ(str);
            }
        }
    }

    private String getPostId() {
        bb bhr = bhr();
        return bhr != null ? bhr.wD() : "";
    }

    private String getForumId() {
        return this.fFd.bcO() != null ? this.fFd.bcO().getForumId() : "";
    }

    private bb bhr() {
        if (this.fFd.bcO() == null || this.fFd.bcO().getPbData() == null) {
            return null;
        }
        return this.fFd.bcO().getPbData().bbJ();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.azy = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0214a extends q.a {
        public View egT;
        public PbThreadCommentAndPraiseInfoLayout fPe;

        public C0214a(View view) {
            super(view);
            if (view != null) {
                this.fPe = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_bottom_func_layout);
                this.egT = view.findViewById(e.g.bottom_divider_line);
                this.egT.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bAn != null) {
                this.fPe.setData(iVar.bAn);
                this.egT.setVisibility(iVar.bco() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.j(this.egT, e.d.cp_bg_line_e);
            this.fPe.onChangeSkinType();
        }
    }
}
