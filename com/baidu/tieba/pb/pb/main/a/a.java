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
    private b hyQ;
    private final LinkedList<C0284a> hyR;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hyR = new LinkedList<>();
        this.hyQ = new b(this.hpc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public C0284a onCreateViewHolder(ViewGroup viewGroup) {
        C0284a c0284a = new C0284a(LayoutInflater.from(this.mContext).inflate(d.h.layout_pb_thread_praise_item, viewGroup, false));
        this.hyR.add(c0284a);
        return c0284a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0284a c0284a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0284a);
        if (iVar != null && c0284a != null) {
            c0284a.hyS.setOnClickOutListener(this.bRv);
            c0284a.hyS.setPostId(getPostId());
            c0284a.hyS.setForumId(getForumId());
            c0284a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bND();
        if (this.hyQ != null) {
            this.hyQ.onDestroy();
        }
    }

    private void bND() {
        Iterator<C0284a> it = this.hyR.iterator();
        while (it.hasNext()) {
            C0284a next = it.next();
            if (next != null && next.hyS != null) {
                next.hyS.onDestroy();
            }
        }
    }

    public void nr(String str) {
        Iterator<C0284a> it = this.hyR.iterator();
        while (it.hasNext()) {
            C0284a next = it.next();
            if (next != null && next.hyS != null) {
                next.hyS.nr(str);
            }
        }
    }

    private String getPostId() {
        bg bNE = bNE();
        return bNE != null ? bNE.Zh() : "";
    }

    private String getForumId() {
        return this.hpc.bJa() != null ? this.hpc.bJa().getForumId() : "";
    }

    private bg bNE() {
        if (this.hpc.bJa() == null || this.hpc.bJa().getPbData() == null) {
            return null;
        }
        return this.hpc.bJa().getPbData().bHZ();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRv = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0284a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hyS;
        public View hyT;

        public C0284a(View view) {
            super(view);
            if (view != null) {
                this.hyS = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxh = 4;
                dVar.bxm = 7;
                this.hyS.setAgreeStatisticData(dVar);
                this.hyT = view.findViewById(d.g.bottom_divider_line);
                this.hyT.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bTk != null) {
                if (iVar.bTk.aaH() != null) {
                    iVar.bTk.aaH().postId = iVar.bTk.Zh();
                }
                this.hyS.setData(iVar.bTk);
                this.hyT.setVisibility(iVar.bIB() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.l(this.hyT, d.C0236d.cp_bg_line_e);
            this.hyS.onChangeSkinType();
        }
    }
}
