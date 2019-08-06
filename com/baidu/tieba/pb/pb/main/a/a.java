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
public class a extends k<j, C0380a> {
    private View.OnClickListener caz;
    private b hXv;
    private final LinkedList<C0380a> hXw;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hXw = new LinkedList<>();
        this.hXv = new b(this.hNx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public C0380a onCreateViewHolder(ViewGroup viewGroup) {
        C0380a c0380a = new C0380a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.hXw.add(c0380a);
        return c0380a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, C0380a c0380a) {
        super.onFillViewHolder(i, view, viewGroup, jVar, c0380a);
        if (jVar != null && c0380a != null) {
            c0380a.hXx.setOnClickOutListener(this.caz);
            c0380a.hXx.setPostId(getPostId());
            c0380a.hXx.setForumId(getForumId());
            c0380a.a(jVar);
        }
        return view;
    }

    public void onDestroy() {
        bYD();
        if (this.hXv != null) {
            this.hXv.onDestroy();
        }
    }

    private void bYD() {
        Iterator<C0380a> it = this.hXw.iterator();
        while (it.hasNext()) {
            C0380a next = it.next();
            if (next != null && next.hXx != null) {
                next.hXx.onDestroy();
            }
        }
    }

    public void oS(String str) {
        Iterator<C0380a> it = this.hXw.iterator();
        while (it.hasNext()) {
            C0380a next = it.next();
            if (next != null && next.hXx != null) {
                next.hXx.oS(str);
            }
        }
    }

    private String getPostId() {
        bh bYE = bYE();
        return bYE != null ? bYE.aeO() : "";
    }

    private String getForumId() {
        return this.hNx.bTR() != null ? this.hNx.bTR().getForumId() : "";
    }

    private bh bYE() {
        if (this.hNx.bTR() == null || this.hNx.bTR().getPbData() == null) {
            return null;
        }
        return this.hNx.bTR().getPbData().bSL();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.caz = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0380a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hXx;
        public View hXy;

        public C0380a(View view) {
            super(view);
            if (view != null) {
                this.hXx = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.bFA = 4;
                dVar.bFF = 7;
                this.hXx.setAgreeStatisticData(dVar);
                this.hXy = view.findViewById(R.id.bottom_divider_line);
                this.hXy.setVisibility(0);
            }
        }

        public void a(j jVar) {
            if (jVar != null && jVar.ccq != null) {
                if (jVar.ccq.ago() != null) {
                    jVar.ccq.ago().postId = jVar.ccq.aeO();
                }
                this.hXx.setData(jVar.ccq);
                this.hXy.setVisibility(jVar.bTs() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.l(this.hXy, R.color.cp_bg_line_e);
            this.hXx.onChangeSkinType();
        }
    }
}
