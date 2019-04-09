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
    private View.OnClickListener bRz;
    private b hyy;
    private final LinkedList<C0357a> hyz;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hyz = new LinkedList<>();
        this.hyy = new b(this.hoK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public C0357a onCreateViewHolder(ViewGroup viewGroup) {
        C0357a c0357a = new C0357a(LayoutInflater.from(this.mContext).inflate(d.h.layout_pb_thread_praise_item, viewGroup, false));
        this.hyz.add(c0357a);
        return c0357a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0357a c0357a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0357a);
        if (iVar != null && c0357a != null) {
            c0357a.hyA.setOnClickOutListener(this.bRz);
            c0357a.hyA.setPostId(getPostId());
            c0357a.hyA.setForumId(getForumId());
            c0357a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bNB();
        if (this.hyy != null) {
            this.hyy.onDestroy();
        }
    }

    private void bNB() {
        Iterator<C0357a> it = this.hyz.iterator();
        while (it.hasNext()) {
            C0357a next = it.next();
            if (next != null && next.hyA != null) {
                next.hyA.onDestroy();
            }
        }
    }

    public void ns(String str) {
        Iterator<C0357a> it = this.hyz.iterator();
        while (it.hasNext()) {
            C0357a next = it.next();
            if (next != null && next.hyA != null) {
                next.hyA.ns(str);
            }
        }
    }

    private String getPostId() {
        bg bNC = bNC();
        return bNC != null ? bNC.Ze() : "";
    }

    private String getForumId() {
        return this.hoK.bIX() != null ? this.hoK.bIX().getForumId() : "";
    }

    private bg bNC() {
        if (this.hoK.bIX() == null || this.hoK.bIX().getPbData() == null) {
            return null;
        }
        return this.hoK.bIX().getPbData().bHW();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRz = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0357a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hyA;
        public View hyB;

        public C0357a(View view) {
            super(view);
            if (view != null) {
                this.hyA = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxn = 4;
                dVar.bxs = 7;
                this.hyA.setAgreeStatisticData(dVar);
                this.hyB = view.findViewById(d.g.bottom_divider_line);
                this.hyB.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bTo != null) {
                if (iVar.bTo.aaE() != null) {
                    iVar.bTo.aaE().postId = iVar.bTo.Ze();
                }
                this.hyA.setData(iVar.bTo);
                this.hyB.setVisibility(iVar.bIy() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.l(this.hyB, d.C0277d.cp_bg_line_e);
            this.hyA.onChangeSkinType();
        }
    }
}
