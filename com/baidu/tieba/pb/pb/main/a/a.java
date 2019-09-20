package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends k<j, C0391a> {
    private View.OnClickListener cbs;
    private b hZs;
    private final LinkedList<C0391a> hZt;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hZt = new LinkedList<>();
        this.hZs = new b(this.hPu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public C0391a onCreateViewHolder(ViewGroup viewGroup) {
        C0391a c0391a = new C0391a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.hZt.add(c0391a);
        return c0391a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, C0391a c0391a) {
        super.onFillViewHolder(i, view, viewGroup, jVar, c0391a);
        if (jVar != null && c0391a != null) {
            c0391a.hZu.setOnClickOutListener(this.cbs);
            c0391a.hZu.setPostId(getPostId());
            c0391a.hZu.setForumId(getForumId());
            c0391a.a(jVar);
        }
        return view;
    }

    public void onDestroy() {
        bZq();
        if (this.hZs != null) {
            this.hZs.onDestroy();
        }
    }

    private void bZq() {
        Iterator<C0391a> it = this.hZt.iterator();
        while (it.hasNext()) {
            C0391a next = it.next();
            if (next != null && next.hZu != null) {
                next.hZu.onDestroy();
            }
        }
    }

    public void pa(String str) {
        Iterator<C0391a> it = this.hZt.iterator();
        while (it.hasNext()) {
            C0391a next = it.next();
            if (next != null && next.hZu != null) {
                next.hZu.pa(str);
            }
        }
    }

    private String getPostId() {
        bh bZr = bZr();
        return bZr != null ? bZr.aeS() : "";
    }

    private String getForumId() {
        return this.hPu.bUE() != null ? this.hPu.bUE().getForumId() : "";
    }

    private bh bZr() {
        if (this.hPu.bUE() == null || this.hPu.bUE().getPbData() == null) {
            return null;
        }
        return this.hPu.bUE().getPbData().bTy();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cbs = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0391a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hZu;
        public View hZv;

        public C0391a(View view) {
            super(view);
            if (view != null) {
                this.hZu = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.bFY = 4;
                dVar.bGd = 7;
                this.hZu.setAgreeStatisticData(dVar);
                this.hZv = view.findViewById(R.id.bottom_divider_line);
                this.hZv.setVisibility(0);
            }
        }

        public void a(j jVar) {
            if (jVar != null && jVar.cdk != null) {
                if (jVar.cdk.ags() != null) {
                    jVar.cdk.ags().postId = jVar.cdk.aeS();
                }
                this.hZu.setData(jVar.cdk);
                this.hZv.setVisibility(jVar.bUf() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.l(this.hZv, R.color.cp_bg_line_e);
            this.hZu.onChangeSkinType();
        }
    }
}
