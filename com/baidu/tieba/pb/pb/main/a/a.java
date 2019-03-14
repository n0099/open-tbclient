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
public class a extends k<i, C0357a> {
    private View.OnClickListener bRw;
    private b hyL;
    private final LinkedList<C0357a> hyM;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hyM = new LinkedList<>();
        this.hyL = new b(this.hoW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public C0357a onCreateViewHolder(ViewGroup viewGroup) {
        C0357a c0357a = new C0357a(LayoutInflater.from(this.mContext).inflate(d.h.layout_pb_thread_praise_item, viewGroup, false));
        this.hyM.add(c0357a);
        return c0357a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0357a c0357a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0357a);
        if (iVar != null && c0357a != null) {
            c0357a.hyN.setOnClickOutListener(this.bRw);
            c0357a.hyN.setPostId(getPostId());
            c0357a.hyN.setForumId(getForumId());
            c0357a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bNE();
        if (this.hyL != null) {
            this.hyL.onDestroy();
        }
    }

    private void bNE() {
        Iterator<C0357a> it = this.hyM.iterator();
        while (it.hasNext()) {
            C0357a next = it.next();
            if (next != null && next.hyN != null) {
                next.hyN.onDestroy();
            }
        }
    }

    public void nr(String str) {
        Iterator<C0357a> it = this.hyM.iterator();
        while (it.hasNext()) {
            C0357a next = it.next();
            if (next != null && next.hyN != null) {
                next.hyN.nr(str);
            }
        }
    }

    private String getPostId() {
        bg bNF = bNF();
        return bNF != null ? bNF.Zh() : "";
    }

    private String getForumId() {
        return this.hoW.bJa() != null ? this.hoW.bJa().getForumId() : "";
    }

    private bg bNF() {
        if (this.hoW.bJa() == null || this.hoW.bJa().getPbData() == null) {
            return null;
        }
        return this.hoW.bJa().getPbData().bHZ();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRw = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0357a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hyN;
        public View hyO;

        public C0357a(View view) {
            super(view);
            if (view != null) {
                this.hyN = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxj = 4;
                dVar.bxo = 7;
                this.hyN.setAgreeStatisticData(dVar);
                this.hyO = view.findViewById(d.g.bottom_divider_line);
                this.hyO.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bTl != null) {
                if (iVar.bTl.aaH() != null) {
                    iVar.bTl.aaH().postId = iVar.bTl.Zh();
                }
                this.hyN.setData(iVar.bTl);
                this.hyO.setVisibility(iVar.bIB() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.l(this.hyO, d.C0277d.cp_bg_line_e);
            this.hyN.onChangeSkinType();
        }
    }
}
