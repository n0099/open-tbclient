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
public class a extends k<i, C0248a> {
    private View.OnClickListener aEg;
    private b fWD;
    private final LinkedList<C0248a> fWE;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fWE = new LinkedList<>();
        this.fWD = new b(this.fMF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public C0248a onCreateViewHolder(ViewGroup viewGroup) {
        C0248a c0248a = new C0248a(LayoutInflater.from(this.mContext).inflate(e.h.layout_pb_thread_praise_item, viewGroup, false));
        this.fWE.add(c0248a);
        return c0248a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0248a c0248a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0248a);
        if (iVar != null && c0248a != null) {
            c0248a.fWF.setOnClickOutListener(this.aEg);
            c0248a.fWF.setPostId(getPostId());
            c0248a.fWF.setForumId(getForumId());
            c0248a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bkC();
        if (this.fWD != null) {
            this.fWD.onDestroy();
        }
    }

    private void bkC() {
        Iterator<C0248a> it = this.fWE.iterator();
        while (it.hasNext()) {
            C0248a next = it.next();
            if (next != null && next.fWF != null) {
                next.fWF.onDestroy();
            }
        }
    }

    public void fX(String str) {
        Iterator<C0248a> it = this.fWE.iterator();
        while (it.hasNext()) {
            C0248a next = it.next();
            if (next != null && next.fWF != null) {
                next.fWF.fX(str);
            }
        }
    }

    private String getPostId() {
        bb bkD = bkD();
        return bkD != null ? bkD.yM() : "";
    }

    private String getForumId() {
        return this.fMF.bga() != null ? this.fMF.bga().getForumId() : "";
    }

    private bb bkD() {
        if (this.fMF.bga() == null || this.fMF.bga().getPbData() == null) {
            return null;
        }
        return this.fMF.bga().getPbData().beV();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aEg = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0248a extends q.a {
        public View eoO;
        public PbThreadCommentAndPraiseInfoLayout fWF;

        public C0248a(View view) {
            super(view);
            if (view != null) {
                this.fWF = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_bottom_func_layout);
                this.eoO = view.findViewById(e.g.bottom_divider_line);
                this.eoO.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bIV != null) {
                this.fWF.setData(iVar.bIV);
                this.eoO.setVisibility(iVar.bfA() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.j(this.eoO, e.d.cp_bg_line_e);
            this.fWF.onChangeSkinType();
        }
    }
}
