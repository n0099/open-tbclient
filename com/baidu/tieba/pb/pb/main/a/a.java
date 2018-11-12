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
public class a extends k<i, C0275a> {
    private View.OnClickListener aEW;
    private b fYc;
    private final LinkedList<C0275a> fYd;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fYd = new LinkedList<>();
        this.fYc = new b(this.fOe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public C0275a onCreateViewHolder(ViewGroup viewGroup) {
        C0275a c0275a = new C0275a(LayoutInflater.from(this.mContext).inflate(e.h.layout_pb_thread_praise_item, viewGroup, false));
        this.fYd.add(c0275a);
        return c0275a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0275a c0275a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0275a);
        if (iVar != null && c0275a != null) {
            c0275a.fYe.setOnClickOutListener(this.aEW);
            c0275a.fYe.setPostId(getPostId());
            c0275a.fYe.setForumId(getForumId());
            c0275a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bjZ();
        if (this.fYc != null) {
            this.fYc.onDestroy();
        }
    }

    private void bjZ() {
        Iterator<C0275a> it = this.fYd.iterator();
        while (it.hasNext()) {
            C0275a next = it.next();
            if (next != null && next.fYe != null) {
                next.fYe.onDestroy();
            }
        }
    }

    public void fY(String str) {
        Iterator<C0275a> it = this.fYd.iterator();
        while (it.hasNext()) {
            C0275a next = it.next();
            if (next != null && next.fYe != null) {
                next.fYe.fY(str);
            }
        }
    }

    private String getPostId() {
        bb bka = bka();
        return bka != null ? bka.yT() : "";
    }

    private String getForumId() {
        return this.fOe.bfx() != null ? this.fOe.bfx().getForumId() : "";
    }

    private bb bka() {
        if (this.fOe.bfx() == null || this.fOe.bfx().getPbData() == null) {
            return null;
        }
        return this.fOe.bfx().getPbData().bet();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aEW = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0275a extends q.a {
        public View eqh;
        public PbThreadCommentAndPraiseInfoLayout fYe;

        public C0275a(View view) {
            super(view);
            if (view != null) {
                this.fYe = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_bottom_func_layout);
                this.eqh = view.findViewById(e.g.bottom_divider_line);
                this.eqh.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bJG != null) {
                this.fYe.setData(iVar.bJG);
                this.eqh.setVisibility(iVar.beY() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.j(this.eqh, e.d.cp_bg_line_e);
            this.fYe.onChangeSkinType();
        }
    }
}
