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
    private View.OnClickListener bRy;
    private b hyx;
    private final LinkedList<C0357a> hyy;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hyy = new LinkedList<>();
        this.hyx = new b(this.hoJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public C0357a onCreateViewHolder(ViewGroup viewGroup) {
        C0357a c0357a = new C0357a(LayoutInflater.from(this.mContext).inflate(d.h.layout_pb_thread_praise_item, viewGroup, false));
        this.hyy.add(c0357a);
        return c0357a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, C0357a c0357a) {
        super.onFillViewHolder(i, view, viewGroup, iVar, c0357a);
        if (iVar != null && c0357a != null) {
            c0357a.hyz.setOnClickOutListener(this.bRy);
            c0357a.hyz.setPostId(getPostId());
            c0357a.hyz.setForumId(getForumId());
            c0357a.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        bNB();
        if (this.hyx != null) {
            this.hyx.onDestroy();
        }
    }

    private void bNB() {
        Iterator<C0357a> it = this.hyy.iterator();
        while (it.hasNext()) {
            C0357a next = it.next();
            if (next != null && next.hyz != null) {
                next.hyz.onDestroy();
            }
        }
    }

    public void ns(String str) {
        Iterator<C0357a> it = this.hyy.iterator();
        while (it.hasNext()) {
            C0357a next = it.next();
            if (next != null && next.hyz != null) {
                next.hyz.ns(str);
            }
        }
    }

    private String getPostId() {
        bg bNC = bNC();
        return bNC != null ? bNC.Ze() : "";
    }

    private String getForumId() {
        return this.hoJ.bIX() != null ? this.hoJ.bIX().getForumId() : "";
    }

    private bg bNC() {
        if (this.hoJ.bIX() == null || this.hoJ.bIX().getPbData() == null) {
            return null;
        }
        return this.hoJ.bIX().getPbData().bHW();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRy = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0357a extends v.a {
        public View hyA;
        public PbThreadCommentAndPraiseInfoLayout hyz;

        public C0357a(View view) {
            super(view);
            if (view != null) {
                this.hyz = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxm = 4;
                dVar.bxr = 7;
                this.hyz.setAgreeStatisticData(dVar);
                this.hyA = view.findViewById(d.g.bottom_divider_line);
                this.hyA.setVisibility(0);
            }
        }

        public void a(i iVar) {
            if (iVar != null && iVar.bTn != null) {
                if (iVar.bTn.aaE() != null) {
                    iVar.bTn.aaE().postId = iVar.bTn.Ze();
                }
                this.hyz.setData(iVar.bTn);
                this.hyA.setVisibility(iVar.bIy() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.l(this.hyA, d.C0277d.cp_bg_line_e);
            this.hyz.onChangeSkinType();
        }
    }
}
