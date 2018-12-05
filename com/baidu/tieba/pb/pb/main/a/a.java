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
    private View.OnClickListener aIw;
    private b geT;
    private final LinkedList<C0286a> geU;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.geU = new LinkedList<>();
        this.geT = new b(this.fUU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public C0286a onCreateViewHolder(ViewGroup viewGroup) {
        C0286a c0286a = new C0286a(LayoutInflater.from(this.mContext).inflate(e.h.layout_pb_thread_praise_item, viewGroup, false));
        this.geU.add(c0286a);
        return c0286a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0286a c0286a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0286a);
        if (iVar != null && c0286a != null) {
            c0286a.geV.setOnClickOutListener(this.aIw);
            c0286a.geV.setPostId(getPostId());
            c0286a.geV.setForumId(getForumId());
            c0286a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        blS();
        if (this.geT != null) {
            this.geT.onDestroy();
        }
    }

    private void blS() {
        Iterator<C0286a> it = this.geU.iterator();
        while (it.hasNext()) {
            C0286a next = it.next();
            if (next != null && next.geV != null) {
                next.geV.onDestroy();
            }
        }
    }

    public void gq(String str) {
        Iterator<C0286a> it = this.geU.iterator();
        while (it.hasNext()) {
            C0286a next = it.next();
            if (next != null && next.geV != null) {
                next.geV.gq(str);
            }
        }
    }

    private String getPostId() {
        bb blT = blT();
        return blT != null ? blT.zX() : "";
    }

    private String getForumId() {
        return this.fUU.bho() != null ? this.fUU.bho().getForumId() : "";
    }

    private bb blT() {
        if (this.fUU.bho() == null || this.fUU.bho().getPbData() == null) {
            return null;
        }
        return this.fUU.bho().getPbData().bgk();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aIw = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0286a extends q.a {
        public View exb;
        public PbThreadCommentAndPraiseInfoLayout geV;

        public C0286a(View view) {
            super(view);
            if (view != null) {
                this.geV = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_bottom_func_layout);
                this.exb = view.findViewById(e.g.bottom_divider_line);
                this.exb.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bNv != null) {
                this.geV.setData(iVar.bNv);
                this.exb.setVisibility(iVar.bgP() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.j(this.exb, e.d.cp_bg_line_e);
            this.geV.onChangeSkinType();
        }
    }
}
