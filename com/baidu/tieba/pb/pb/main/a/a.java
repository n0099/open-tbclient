package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends k<j, C0375a> {
    private View.OnClickListener bZr;
    private b hQm;
    private final LinkedList<C0375a> hQn;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hQn = new LinkedList<>();
        this.hQm = new b(this.hGq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public C0375a onCreateViewHolder(ViewGroup viewGroup) {
        C0375a c0375a = new C0375a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.hQn.add(c0375a);
        return c0375a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, C0375a c0375a) {
        super.onFillViewHolder(i, view, viewGroup, jVar, c0375a);
        if (jVar != null && c0375a != null) {
            c0375a.hQo.setOnClickOutListener(this.bZr);
            c0375a.hQo.setPostId(getPostId());
            c0375a.hQo.setForumId(getForumId());
            c0375a.a(jVar);
        }
        return view;
    }

    public void onDestroy() {
        bVy();
        if (this.hQm != null) {
            this.hQm.onDestroy();
        }
    }

    private void bVy() {
        Iterator<C0375a> it = this.hQn.iterator();
        while (it.hasNext()) {
            C0375a next = it.next();
            if (next != null && next.hQo != null) {
                next.hQo.onDestroy();
            }
        }
    }

    public void oB(String str) {
        Iterator<C0375a> it = this.hQn.iterator();
        while (it.hasNext()) {
            C0375a next = it.next();
            if (next != null && next.hQo != null) {
                next.hQo.oB(str);
            }
        }
    }

    private String getPostId() {
        bg bVz = bVz();
        return bVz != null ? bVz.adL() : "";
    }

    private String getForumId() {
        return this.hGq.bQS() != null ? this.hGq.bQS().getForumId() : "";
    }

    private bg bVz() {
        if (this.hGq.bQS() == null || this.hGq.bQS().getPbData() == null) {
            return null;
        }
        return this.hGq.bQS().getPbData().bPM();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bZr = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0375a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hQo;
        public View hQp;

        public C0375a(View view) {
            super(view);
            if (view != null) {
                this.hQo = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.bEz = 4;
                dVar.bEE = 7;
                this.hQo.setAgreeStatisticData(dVar);
                this.hQp = view.findViewById(R.id.bottom_divider_line);
                this.hQp.setVisibility(0);
            }
        }

        public void a(j jVar) {
            if (jVar != null && jVar.cbh != null) {
                if (jVar.cbh.afl() != null) {
                    jVar.cbh.afl().postId = jVar.cbh.adL();
                }
                this.hQo.setData(jVar.cbh);
                this.hQp.setVisibility(jVar.bQt() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.l(this.hQp, R.color.cp_bg_line_e);
            this.hQo.onChangeSkinType();
        }
    }
}
