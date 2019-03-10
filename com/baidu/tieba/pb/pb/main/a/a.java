package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends k<i, C0284a> {
    private View.OnClickListener bRv;
    private b hyR;
    private final LinkedList<C0284a> hyS;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hyS = new LinkedList<>();
        this.hyR = new b(this.hpd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public C0284a onCreateViewHolder(ViewGroup viewGroup) {
        C0284a c0284a = new C0284a(LayoutInflater.from(this.mContext).inflate(d.h.layout_pb_thread_praise_item, viewGroup, false));
        this.hyS.add(c0284a);
        return c0284a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0284a c0284a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0284a);
        if (iVar != null && c0284a != null) {
            c0284a.hyT.setOnClickOutListener(this.bRv);
            c0284a.hyT.setPostId(getPostId());
            c0284a.hyT.setForumId(getForumId());
            c0284a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bNE();
        if (this.hyR != null) {
            this.hyR.onDestroy();
        }
    }

    private void bNE() {
        Iterator<C0284a> it = this.hyS.iterator();
        while (it.hasNext()) {
            C0284a next = it.next();
            if (next != null && next.hyT != null) {
                next.hyT.onDestroy();
            }
        }
    }

    public void nr(String str) {
        Iterator<C0284a> it = this.hyS.iterator();
        while (it.hasNext()) {
            C0284a next = it.next();
            if (next != null && next.hyT != null) {
                next.hyT.nr(str);
            }
        }
    }

    private String getPostId() {
        bg bNF = bNF();
        return bNF != null ? bNF.Zh() : "";
    }

    private String getForumId() {
        return this.hpd.bJb() != null ? this.hpd.bJb().getForumId() : "";
    }

    private bg bNF() {
        if (this.hpd.bJb() == null || this.hpd.bJb().getPbData() == null) {
            return null;
        }
        return this.hpd.bJb().getPbData().bIa();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRv = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0284a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hyT;
        public View hyU;

        public C0284a(View view) {
            super(view);
            if (view != null) {
                this.hyT = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxh = 4;
                dVar.bxm = 7;
                this.hyT.setAgreeStatisticData(dVar);
                this.hyU = view.findViewById(d.g.bottom_divider_line);
                this.hyU.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bTk != null) {
                if (iVar.bTk.aaH() != null) {
                    iVar.bTk.aaH().postId = iVar.bTk.Zh();
                }
                this.hyT.setData(iVar.bTk);
                this.hyU.setVisibility(iVar.bIC() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.l(this.hyU, d.C0236d.cp_bg_line_e);
            this.hyT.onChangeSkinType();
        }
    }
}
